/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Parser.java".  Description: 
"Parses HL7 message Strings into HL7 Message objects and 
  encodes HL7 Message objects into HL7 message Strings" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.parser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.newel.android.Log;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.VersionLogger;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.util.Constants;
import ca.uhn.hl7v2.validation.MessageValidator;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * Parses HL7 message Strings into HL7 Message objects and 
 * encodes HL7 Message objects into HL7 message Strings.  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public abstract class Parser {

    private static Map<String, Properties> messageStructures = null;
    
    private ModelClassFactory myFactory;
    private ValidationContext myContext;
    private MessageValidator myValidator;
    private ParserConfiguration myParserConfiguration = new ParserConfiguration();

    static {
        VersionLogger.init();
    }
    
    /**
     * Uses DefaultModelClassFactory for model class lookup. 
     */
    public Parser() {
        this(null);
    }
    
    /**
     * @param theFactory custom factory to use for model class lookup 
     */
    public Parser(ModelClassFactory theFactory) {
    	if (theFactory == null) {
    		theFactory = new DefaultModelClassFactory();
    	}
    	
        myFactory = theFactory;
        ValidationContext validationContext;
		try {
			validationContext = ValidationContextFactory.getContext();
		} catch (ValidationException e) {
			Log.w(Constants.TAG,"Failed to get a validation context from the ValidationContextFactory");
			validationContext = ValidationContextFactory.defaultValidation();
		}
        setValidationContext(validationContext);
    }
    
    /**
     * @return the factory used by this Parser for model class lookup
     */
    public ModelClassFactory getFactory() {
        return myFactory;
    }
    
    /**
     * @return the set of validation rules that is applied to messages parsed or encoded by this parser. Note that this method may return <code>null</code>
     */
    public ValidationContext getValidationContext() {
        return myContext;
    }
    
    /**
     * @param theContext the set of validation rules to be applied to messages parsed or 
     *      encoded by this parser (defaults to ValidationContextFactory.DefaultValidation)
     */
    public void setValidationContext(ValidationContext theContext) {
        myContext = theContext;
        myValidator = new MessageValidator(theContext, true);
    }

    
    /**
	 * @return Returns the parser configuration. This is a bean which contains configuration
	 * instructions relating to how a parser should be parsing or encoding messages it
	 * deals with. 
	 */
	public ParserConfiguration getParserConfiguration() {
		return myParserConfiguration;
	}

	/**
	 * Sets the parser configuration for this parser (may not be null). This is a bean which contains configuration
	 * instructions relating to how a parser should be parsing or encoding messages it
	 * deals with. 
	 * 
	 * @param theParserConfiguration The parser configuration
	 */
	public void setParserConfiguration(ParserConfiguration theParserConfiguration) {
		if (theParserConfiguration == null) {
			throw new NullPointerException("theParserConfiguration may not be null");
		}
		myParserConfiguration = theParserConfiguration;
	}
    
    
    /**
     * Returns a String representing the encoding of the given message, if 
     * the encoding is recognized.  For example if the given message appears 
     * to be encoded using HL7 2.x XML rules then "XML" would be returned.  
     * If the encoding is not recognized then null is returned.  That this 
     * method returns a specific encoding does not guarantee that the 
     * message is correctly encoded (e.g. well formed XML) - just that  
     * it is not encoded using any other encoding than the one returned.  
     * Returns null if the encoding is not recognized.  
     */
    public abstract String getEncoding(String message);

    /** 
     * Returns true if and only if the given encoding is supported 
     * by this Parser.  
     */
    public abstract boolean supportsEncoding(String encoding);
    
    /**
     * @return the preferred encoding of this Parser
     */
    public abstract String getDefaultEncoding();

    /**
     * Parses a message string and returns the corresponding Message object.
     *   
     * @param message a String that contains an HL7 message 
     * @return a HAPI Message object parsed from the given String 
     * @throws HL7Exception if the message is not correctly formatted.  
     * @throws EncodingNotSupportedException if the message encoded 
     *      is not supported by this parser.   
     */
    public Message parse(String message) throws HL7Exception, EncodingNotSupportedException {
        String encoding = getEncoding(message);
        if (!supportsEncoding(encoding)) {
            throw new EncodingNotSupportedException(
                    "Can't parse message beginning " + message.substring(0, Math.min(message.length(), 50)));
        }
        
        String version = getVersion(message);
        if (!validVersion(version)) {
            throw new HL7Exception("Can't process message of version '" + version + "' - version not recognized",
                    HL7Exception.UNSUPPORTED_VERSION_ID);
        }
        
        myValidator.validate(message, encoding.equals("XML"), version);        
        Message result = doParse(message, version);
        myValidator.validate(result);

        result.setParser(this);
        
        return result;
    }
    
    /**
     * Called by parse() to perform implementation-specific parsing work.  
     * 
     * @param message a String that contains an HL7 message 
     * @param version the name of the HL7 version to which the message belongs (eg "2.5") 
     * @return a HAPI Message object parsed from the given String 
     * @throws HL7Exception if the message is not correctly formatted.  
     * @throws EncodingNotSupportedException if the message encoded 
     *      is not supported by this parser.   
     */
    protected abstract Message doParse(String message, String version) 
        throws HL7Exception, EncodingNotSupportedException;

    /** 
     * Formats a Message object into an HL7 message string using the given 
     * encoding. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @param encoding the name of the HL7 encoding to use (eg "XML"; most implementations support only  
     *      one encoding) 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     * @throws EncodingNotSupportedException if the requested encoding is not 
     *      supported by this parser.  
     */
    public String encode(Message source, String encoding) throws HL7Exception, EncodingNotSupportedException {
        myValidator.validate(source);        
        String result = doEncode(source, encoding);
        myValidator.validate(result, encoding.equals("XML"), source.getVersion());
        
        return result;
    }

    /**
     * Called by encode(Message, String) to perform implementation-specific encoding work. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @param encoding the name of the HL7 encoding to use (eg "XML"; most implementations support only 
     *      one encoding) 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     * @throws EncodingNotSupportedException if the requested encoding is not 
     *      supported by this parser.  
     */
    protected abstract String doEncode(Message source, String encoding) 
        throws HL7Exception, EncodingNotSupportedException;
    
    /** 
     * Formats a Message object into an HL7 message string using this parser's  
     * default encoding. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @param encoding the name of the encoding to use (eg "XML"; most implementations support only one 
     *      encoding) 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     */
    public String encode(Message source) throws HL7Exception {
        String encoding = getDefaultEncoding();
        
        myValidator.validate(source);        
        String result = doEncode(source);
        myValidator.validate(result, encoding.equals("XML"), source.getVersion());
        
        return result;
    }

    /**
     * Called by encode(Message) to perform implementation-specific encoding work. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     * @throws EncodingNotSupportedException if the requested encoding is not 
     *      supported by this parser.  
     */
    protected abstract String doEncode(Message source) throws HL7Exception;
    
    /**
     * <p>Returns a minimal amount of data from a message string, including only the 
     * data needed to send a response to the remote system.  This includes the 
     * following fields: 
     * <ul><li>field separator</li>
     * <li>encoding characters</li>
     * <li>processing ID</li>
     * <li>message control ID</li></ul>
     * This method is intended for use when there is an error parsing a message, 
     * (so the Message object is unavailable) but an error message must be sent 
     * back to the remote system including some of the information in the inbound
     * message.  This method parses only that required information, hopefully 
     * avoiding the condition that caused the original error.</p>  
     * @return an MSH segment 
     */
    public abstract Segment getCriticalResponseData(String message) throws HL7Exception;

    /**
     * For response messages, returns the value of MSA-2 (the message ID of the message 
     * sent by the sending system).  This value may be needed prior to main message parsing, 
     * so that (particularly in a multi-threaded scenario) the message can be routed to 
     * the thread that sent the request.  We need this information first so that any 
     * parse exceptions are thrown to the correct thread.  Implementers of Parsers should 
     * take care to make the implementation of this method very fast and robust.  
     * Returns null if MSA-2 can not be found (e.g. if the message is not a 
     * response message). 
     */
    public abstract String getAckID(String message);

    /**
     * Returns the version ID (MSH-12) from the given message, without fully parsing the message. 
     * The version is needed prior to parsing in order to determine the message class
     * into which the text of the message should be parsed. 
     * @throws HL7Exception if the version field can not be found. 
     */
    public abstract String getVersion(String message) throws HL7Exception;


    /**
     * Encodes a particular segment and returns the encoded structure
     *
     * @param structure The structure to encode
     * @param encodingCharacters The encoding characters
     * @return The encoded segment
     * @throws HL7Exception If there is a problem encoding
     * @since 1.0
     */
    public abstract String doEncode(Segment structure, EncodingCharacters encodingCharacters) throws HL7Exception;


    /**
     * Encodes a particular type and returns the encoded structure
     *
     * @param type The type to encode
     * @param encodingCharacters The encoding characters
     * @return The encoded type
     * @throws HL7Exception If there is a problem encoding
     * @since 1.0
     */
    public abstract String doEncode(Type type, EncodingCharacters encodingCharacters) throws HL7Exception;


    /**
     * Parses a particular type and returns the encoded structure
     *
     * @param string The string to parse
     * @param type The type to encode
     * @param encodingCharacters The encoding characters
     * @return The encoded type
     * @throws HL7Exception If there is a problem encoding
     * @since 1.0
     */
    public abstract void parse(Type type, String string, EncodingCharacters encodingCharacters) throws HL7Exception;

    /**
     * Parse a message using a specific model package instead of the default, using {@link ModelClassFactory#getMessageClassInASpecificPackage(String, String, boolean, String)}.
     * 
     * <b>WARNING: This method is only implemented in some parser implementations</b>. Currently it will only
     * work with the PipeParser parser implementation. Use with caution.
     */
	public Message parseForSpecificPackage(String message, String packageName) throws HL7Exception, EncodingNotSupportedException { 
		String encoding = getEncoding(message); 
		if (!supportsEncoding(encoding)) { 
		    throw new EncodingNotSupportedException( 
		            "Can't parse message beginning " + message.substring(0, Math.min(message.length(), 50))); 
		} 
		 
		String version = getVersion(message); 
		if (!validVersion(version)) { 
		    throw new HL7Exception("Can't process message of version '" + version + "' - version not recognized", 
		            HL7Exception.UNSUPPORTED_VERSION_ID); 
		} 
		 
		myValidator.validate(message, encoding.equals("XML"), version); 
		 
		Message result = doParseForSpecificPackage(message, version, packageName); 
		 
		myValidator.validate(result); 
		
		result.setParser(this); 
		 
		return result; 
	} 

	/**
	 * Attempt the parse a message using a specific model package
	 */
	protected abstract Message doParseForSpecificPackage(String message, String version, String packageName) throws HL7Exception, EncodingNotSupportedException;

	/**
	 * Instantiate a message type using a specific package name
	 * 
	 * @see ModelClassFactory#getMessageClassInASpecificPackage(String, String, boolean, String)
	 */
	protected Message instantiateMessageInASpecificPackage(String theName, String theVersion, boolean isExplicit, String packageName) throws HL7Exception { 
		Message result = null; 
		 
		try { 
			Class<? extends Message> messageClass = myFactory.getMessageClassInASpecificPackage(theName, theVersion, isExplicit, packageName); 
			if (messageClass == null) { 
				throw new ClassNotFoundException("Can't find message class in current package list: " + theName);
			}
			
			Log.d(Constants.TAG,"Instantiating msg of class {"+messageClass.getName()+"}"); 
			Constructor<? extends Message> constructor = messageClass.getConstructor(new Class[]{ModelClassFactory.class}); 
			result = (Message) constructor.newInstance(new Object[]{myFactory}); 
		} catch (Exception e) { 
			throw new HL7Exception("Couldn't create Message object of type " + theName, 
			HL7Exception.UNSUPPORTED_MESSAGE_TYPE, e); 
		} 
		 
		result.setValidationContext(myContext); 
		 
		return result; 
	} 
    
    
    /**
     * Parses a particular segment and returns the encoded structure
     *
     * @param string The string to parse
     * @param segment The segment to encode
     * @param encodingCharacters The encoding characters
     * @return The encoded type
     * @throws HL7Exception If there is a problem encoding
     */
    public abstract void parse(Segment segment, String string, EncodingCharacters encodingCharacters) throws HL7Exception;


    /**
     * Parses a particular message and returns the encoded structure
     *
     * @param string The string to parse
     * @param message The message to encode
     * @return The encoded type
     * @throws HL7Exception If there is a problem encoding
     * @since 1.0
     */
    public abstract void parse(Message message, String string) throws HL7Exception;


    /**
     * Creates a version-specific MSH object and returns it as a version-independent 
     * MSH interface. 
     * throws HL7Exception if there is a problem, e.g. invalid version, code not available 
     *     for given version. 
     */
    public static Segment makeControlMSH(String version, ModelClassFactory factory) throws HL7Exception {
        Segment msh = null;
        
        try {
            Message dummy = GenericMessage.getGenericMessageClass(version)
                .getConstructor(new Class[]{ModelClassFactory.class}).newInstance(new Object[]{factory});
            
            Class<?>[] constructorParamTypes = { Group.class, ModelClassFactory.class };
            Object[] constructorParamArgs = { dummy, factory };
            Class<? extends Segment> c = factory.getSegmentClass("MSH", version);
            Constructor<? extends Segment> constructor = c.getConstructor(constructorParamTypes);
            msh = constructor.newInstance(constructorParamArgs);
        }
        catch (Exception e) {
            throw new HL7Exception(
                "Couldn't create MSH for version " + version + " (does your classpath include this version?) ... ",
                HL7Exception.APPLICATION_INTERNAL_ERROR,
                e);
        }
        return msh;
    }

    /** 
     * Returns true if the given string represents a valid 2.x version.  Valid versions 
     * include "2.1", "2.2", "2.3", "2.3.1", "2.4", "2.5", "2.6"
     */
    public static boolean validVersion(String version) {
        return Version.supportsVersion(version);
    }
    
    /**
     * Given a concatenation of message type and event (e.g. ADT_A04), and the 
     * version, finds the corresponding message structure (e.g. ADT_A01).  This  
     * is needed because some events share message structures, although it is not needed
     * when the message structure is explicitly valued in MSH-9-3. 
     * If no mapping is found, returns the original name.
     * @throws HL7Exception if there is an error retrieving the map, or if the given 
     *      version is invalid  
     */
    public static String getMessageStructureForEvent(String name, String version) throws HL7Exception {
        String structure = null;
        
        if (!validVersion(version)) 
            throw new HL7Exception("The version " + version + " is unknown");
        
        Properties p = null; 
        try {
            p = (Properties) getMessageStructures().get(version);            
            
            if (p == null) 
                throw new HL7Exception("No map found for version " + version + ". Only the following are available: " + getMessageStructures().keySet());
            
        } catch (IOException ioe) {
            throw new HL7Exception(ioe);
        }
        
        structure = p.getProperty(name);
        
        if (structure == null) { 
            structure = name;
        }
        
        return structure;
    }

    
    /**
     * Returns a copy of the message structure map for a specific version.
     * Each key is a message type (e.g. ADT_A04) and each value is the
     * corresponding structure (e.g. ADT_A01).
     *
     * @throws IOException If the event map can't be loaded
     */
    public static Properties getMessageStructures(String version) throws IOException {
        Map<String, Properties> msgStructures = getMessageStructures();
        if (!msgStructures.containsKey(version)) {
            return null;
        }

        return (Properties) msgStructures.get(version).clone();
    }


    /**
     * Returns version->event->structure maps.
     */
    private synchronized static Map<String, Properties> getMessageStructures() throws IOException {
        if (messageStructures == null) {
            messageStructures = loadMessageStructures();
        }
        return messageStructures;
    }
    
    private static Map<String, Properties> loadMessageStructures() throws IOException {
        Map<String, Properties> map = new HashMap<String, Properties>();
        for (Version v : Version.values()) {
            String resource = "ca/uhn/hl7v2/parser/eventmap/" + v.getVersion() + ".properties";
            InputStream in = Parser.class.getClassLoader().getResourceAsStream(resource);
            
            Properties structures = null;
            if (in != null) {            
                structures = new Properties();
                structures.load(in);
                map.put(v.getVersion(), structures);
            }
            
        }
        return map;
    }
    
    /**
     * Note that the validation context of the resulting message is set to this parser's validation 
     * context.  The validation context is used within Primitive.setValue().
     *   
     * @param name name of the desired structure in the form XXX_YYY
     * @param version HL7 version (e.g. "2.3")  
     * @param isExplicit true if the structure was specified explicitly in MSH-9-3, false if it 
     *      was inferred from MSH-9-1 and MSH-9-2.  If false, a lookup may be performed to find 
     *      an alternate structure corresponding to that message type and event.   
     * @return a Message instance 
     * @throws HL7Exception if the version is not recognized or no appropriate class can be found or the Message 
     *      class throws an exception on instantiation (e.g. if args are not as expected) 
     */
    protected Message instantiateMessage(String theName, String theVersion, boolean isExplicit) throws HL7Exception {
        Message result = null;
        
        try {
            Class<? extends Message> messageClass = myFactory.getMessageClass(theName, theVersion, isExplicit);
            if (messageClass == null)
                throw new ClassNotFoundException("Can't find message class in current package list: " 
                    + theName);
            Log.d(Constants.TAG,"Instantiating msg of class {"+messageClass.getName()+"}");
            Constructor<? extends Message> constructor = messageClass.getConstructor(new Class[]{ModelClassFactory.class});
            result = constructor.newInstance(new Object[]{myFactory});
        } catch (Exception e) {            
            throw new HL7Exception("Couldn't create Message object of type " + theName,
                HL7Exception.UNSUPPORTED_MESSAGE_TYPE, e);
        }
        
        result.setValidationContext(myContext);
        
        return result;
    }
    
}