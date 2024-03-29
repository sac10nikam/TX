/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Varies.java".  Description: 
"Varies is a Type used as a placeholder for another Type in cases where 
  the appropriate Type is not known until run-time (e.g" 

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

package ca.uhn.hl7v2.model;

import net.newel.android.Log;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.util.Constants;
import ca.uhn.hl7v2.util.DeepCopy;

/**
 * <p>Varies is a Type used as a placeholder for another Type in cases where 
 * the appropriate Type is not known until run-time (e.g. OBX-5).  
 * Parsers and validators may have logic that enforces restrictions on the 
 * Type based on other features of a segment.</p>  
 * <p>If you want to set both the type and the values of a Varies object, you should
 * set the type first by calling setData(Type t), keeping a reference to your Type, 
 * and then set values by calling methods on the Type.  Here is an example:</p>
 * <p><code>CN cn = new CN();<br>
 * variesObject.setData(cn);<br>
 * cn.getIDNumber().setValue("foo");</code></p>
 * 
 * @author Bryan Tripp (bryan_tripp@users.sourceforge.net)
 * @author Andy Pardue 
 * 
 */
public class Varies implements Type {

	private static final long serialVersionUID = 4081596564709146646L;

	/** 
	 * System property key: The value may be set to provide a default
	 * datatype ("ST", "NM", etc) for an OBX segment with a missing
	 * OBX-2 value.
	 */	
	public static final String DEFAULT_OBX2_TYPE_PROP = "ca.uhn.hl7v2.model.varies.default_obx2_type";

    /** 
     * System property key: The value may be set to provide a default
     * datatype ("ST", "NM", etc) for an OBX segment with an invalid
     * OBX-2 value type. In other words, if OBX-2 has a value of "ZYZYZ",
     * which is not a valid value, but this property is set to "ST", then
     * OBX-5 will be parsed as an ST.
     */ 
    public static final String INVALID_OBX2_TYPE_PROP = "ca.uhn.hl7v2.model.varies.invalid_obx2_type";

    /** 
     * <p>
     * System property key: If this is not set, or set to "true", and a subcomponent delimiter is found within the
     * value of a Varies of a primitive type, this subcomponent delimiter will be treated as a literal
     * character instead of a subcomponent delimiter, and will therefore be escaped if the message is
     * re-encoded. This is handy when dealing with non-conformant sending systems which do not correctly
     * escape ampersands in OBX-5 values.
     * </p>
     * <p>
     * For example, consider the following OBX-5 segment:
     * <pre>
     *    OBX||ST|||Apples, Pears &amp; Bananas|||
     * </pre>
     * In this example, the data type is a primitive ST and does not support subcomponents, and the
     * ampersand is obviously not intended to represent a subcomponent delimiter. If this 
     * property is set to <code>true</code>, the entire string will be treated as the
     * value of OBX-5, and if the message is re-encoded the string will appear
     * as "Apples, Pears \T\ Bananas".
     * </p>
     * <p>
     * If this property is set to anything other than "true", the subcomponent delimiter is treated as a component delimiter, 
     * so the value after the ampersand is placed into an {@link ExtraComponents extra component}.
     * </p>
     */ 
    public static final String ESCAPE_SUBCOMPONENT_DELIM_IN_PRIMITIVE = "ca.uhn.hl7v2.model.varies.escape_subcomponent_delim_in_primitive";

    private Type data;
    private Message message;

    /** 
     * Creates new Varies. 
     *  
     * @param message message to which this type belongs
     */
    public Varies(Message message) {
        data = new GenericPrimitive(message);
        this.message = message;
    }

    /**
     * Returns the data contained by this instance of Varies.  Returns a GenericPrimitive unless 
     * setData() has been called. 
     */
    public Type getData() {
        return this.data;
    }

    /** @see Type#getName */
    public String getName() {
        String name = "*";
        if (this.data != null) {
            name = this.data.getName();
        }
        return name;
    }

    /**
     * Sets the data contained by this instance of Varies.  If a data object already exists, 
     * then its values are copied to the incoming data object before the old one is replaced.  
     * For example, if getData() returns an ST with the value "19901012" and you call 
     * setData(new DT()), then subsequent calls to getData() will return the same DT, with the value 
     * set to "19901012".   
     */
    public void setData(Type data) throws DataTypeException {
        if (this.data != null) {
            if (!(this.data instanceof Primitive) || ((Primitive) this.data).getValue() != null) {
                DeepCopy.copy(this.data, data);
            }
        }
        this.data = data;
    }
    
    /** Returns extra components from the underlying Type */
    public ExtraComponents getExtraComponents() {
        return this.data.getExtraComponents();
    }
    
    /**
     * @return the message to which this Type belongs
     */
    public Message getMessage() {
        return message;
    }    

    /** 
     * <p>
     * Sets the data type of field 5 in the given OBX segment to the value of OBX-2.  The argument 
     * is a Segment as opposed to a particular OBX because it is meant to work with any version.
     * </p>
     * <p>
     * Note that if no value is present in OBX-2, or an invalid value is present in
     * OBX-2, this method will throw an error. This behaviour can be corrected by using the 
     * following system properties: {@link #DEFAULT_OBX2_TYPE_PROP} and {@link #INVALID_OBX2_TYPE_PROP},
     * or by using configuration in {@link ParserConfiguration} 
     * </p>  
     */
    public static void fixOBX5(Segment segment, ModelClassFactory factory) throws HL7Exception {
        fixOBX5(segment, factory, segment.getMessage().getParser().getParserConfiguration());
    }

    /** 
     * <p>
     * Sets the data type of field 5 in the given OBX segment to the value of OBX-2.  The argument 
     * is a Segment as opposed to a particular OBX because it is meant to work with any version.
     * </p>
     * <p>
     * Note that if no value is present in OBX-2, or an invalid value is present in
     * OBX-2, this method will throw an error. This behaviour can be corrected by using the 
     * following system properties: {@link #DEFAULT_OBX2_TYPE_PROP} and {@link #INVALID_OBX2_TYPE_PROP} 
     * or by using configuration in {@link ParserConfiguration} 
     * </p>  
     */
	public static void fixOBX5(Segment segment, ModelClassFactory factory, ParserConfiguration parserConfiguration) throws HL7Exception {
		try {
            //get unqualified class name
            Primitive obx2 = (Primitive) segment.getField(2, 0);
            Type[] reps = segment.getField(5);
            for (int i = 0; i < reps.length; i++) {
                Varies v = (Varies)reps[i];

                // If we don't have a value for OBX-2, a default
                // can be supplied via a System property
                if (obx2.getValue() == null) {
	                String defaultOBX2Type = parserConfiguration.getDefaultObx2Type();
	                if (defaultOBX2Type == null) {
	                	defaultOBX2Type = System.getProperty(DEFAULT_OBX2_TYPE_PROP);
	                }
					if (defaultOBX2Type != null) {
	                    Log.d(Constants.TAG, "setting default obx2 type to {"+defaultOBX2Type+"}");
	                    obx2.setValue(defaultOBX2Type);
	                }
                } // if
                
                if (obx2.getValue() == null) {
                    if (v.getData() != null) {
                        if (!(v.getData() instanceof Primitive) || ((Primitive) v.getData()).getValue() != null) {
                            throw new HL7Exception(
                                "OBX-5 is valued, but OBX-2 is not.  A datatype for OBX-5 must be specified using OBX-2. See JavaDoc for Varies#fixOBX5(Segment, ModelClassFactory)",
                                HL7Exception.REQUIRED_FIELD_MISSING);
                        }
                    }
                }
                else {
                    //set class
                    String version = segment.getMessage().getVersion();
					String obx2Value = obx2.getValue();
					Class<? extends Type> c = factory.getTypeClass(obx2Value, version);
//                    Class c = ca.uhn.hl7v2.parser.Parser.findClass(obx2.getValue(), 
//                                                    segment.getMessage().getVersion(), 
//                                                    "datatype");
                    if (c == null) {
                        
                        String defaultOBX2Type = parserConfiguration.getInvalidObx2Type();
                        if (defaultOBX2Type == null) {
                        	defaultOBX2Type = System.getProperty(INVALID_OBX2_TYPE_PROP);
                        }
                        if (defaultOBX2Type != null) {
                            c = factory.getTypeClass(defaultOBX2Type, version);
                        }
                        
                        if (c == null) {
                        	Primitive obx1 = (Primitive) segment.getField(1, 0);
                        	HL7Exception h = new HL7Exception("\'" +
                        		obx2.getValue() + "\' in record " +
                        		obx1.getValue() + " is invalid for version " + version + 
                        		". See JavaDoc for Varies#fixOBX5(Segment, ModelClassFactory)",
                        		HL7Exception.DATA_TYPE_ERROR);
                        	h.setSegmentName("OBX");
                        	h.setFieldPosition(2);
                        	throw h;
                        }
                    }

                    Type newTypeInstance;
                    try {
                        newTypeInstance = (Type) c.getConstructor(new Class[]{Message.class}).newInstance(new Object[]{v.getMessage()});
                    } catch (NoSuchMethodException e) {
                        newTypeInstance = (Type) c.getConstructor(new Class[]{Message.class, Integer.class}).newInstance(new Object[]{v.getMessage(), 0});
                    }
                    
                    if (newTypeInstance instanceof Primitive) {
                    	Type[] subComponentsInFirstField = v.getFirstComponentSubcomponentsOnlyIfMoreThanOne();
                    	if (subComponentsInFirstField != null) {
                    		
                    		if (escapeSubcompponentDelimInPrimitive()) {
                    		
	                    		StringBuilder firstComponentValue = new StringBuilder();
	                    		for (Type type : subComponentsInFirstField) {
	                    			if (firstComponentValue.length() != 0) {
	                    				char subComponentSeparator = EncodingCharacters.getInstance(segment.getMessage()).getSubcomponentSeparator();
	                    				firstComponentValue.append(subComponentSeparator);
	                    			}
	                    			firstComponentValue.append(type.encode());
								}
	                    		
	                    		v.setFirstComponentPrimitiveValue(firstComponentValue.toString());
                    		
                    		} 
                    		
                    	}
                    }
                    
                    v.setData(newTypeInstance);
                }
                
            } // for reps
            
        }
        catch (HL7Exception e) {
            throw e;
        }
        catch (Exception e) {
            throw new HL7Exception(
                e.getClass().getName() + " trying to set data type of OBX-5",
                HL7Exception.APPLICATION_INTERNAL_ERROR,
                e);
        }
	}

    
    private static boolean escapeSubcompponentDelimInPrimitive() {
		String property = System.getProperty(ESCAPE_SUBCOMPONENT_DELIM_IN_PRIMITIVE);
		return property == null || "true".equalsIgnoreCase(property);
	}

	private void setFirstComponentPrimitiveValue(String theValue) throws DataTypeException {
		Composite c = (Composite) data;
		Type firstComponent = c.getComponent(0);
		setFirstComponentPrimitiveValue(firstComponent, theValue);
	}

    
	private void setFirstComponentPrimitiveValue(Type theFirstComponent, String theValue)
			throws DataTypeException {
		
		if (theFirstComponent instanceof Varies) {
			Varies firstComponentVaries = (Varies)theFirstComponent;
			if (((Varies) theFirstComponent).getData() instanceof Composite) {
				Type[] subComponents = ((Composite)firstComponentVaries.getData()).getComponents();
				setFirstComponentPrimitiveValue(subComponents[0], theValue);
				for (int i = 1; i < subComponents.length; i++) {
					setFirstComponentPrimitiveValue(subComponents[i], "");
				}
			} else {
				Primitive p = (Primitive) firstComponentVaries.getData();
				p.setValue(theValue);
			}
		} else if (theFirstComponent instanceof Composite) {
			Type[] subComponents = ((Composite)theFirstComponent).getComponents();
			setFirstComponentPrimitiveValue(subComponents[0], theValue);
			for (int i = 1; i < subComponents.length; i++) {
				setFirstComponentPrimitiveValue(subComponents[i], "");
			}
		} else {
			((Primitive)theFirstComponent).setValue(theValue);
		}
	}

	/**
     * Returns an array containing the subcomponents within the first component of this Varies
     * object only if there are more than one of them. Otherwise, returns null.
     */
    private Type[] getFirstComponentSubcomponentsOnlyIfMoreThanOne() throws DataTypeException {
    	if (data instanceof Composite) {
    		Composite c = (Composite) data;
    		Type firstComponent = c.getComponent(0);
    		if (firstComponent instanceof Varies) {
    			Varies firstComponentVaries = (Varies) firstComponent;
    			if (firstComponentVaries.getData() instanceof Composite) {
    				return ((Composite)firstComponentVaries.getData()).getComponents();
    			}
    		} 
    	}
		return null;
	}

	/**
     * {@inheritDoc }
     */
    public void parse(String string) throws HL7Exception {
        if (data != null) {
        	data.clear();
        }
    	getMessage().getParser().parse(this, string, EncodingCharacters.getInstance(getMessage()));
    }


    /**
     * {@inheritDoc }
     */
    public String encode() throws HL7Exception {
        return getMessage().getParser().doEncode(this, EncodingCharacters.getInstance(getMessage()));
    }


	/**
	 * {@inheritDoc }
	 */
	public void clear() {
		data.clear();
	}

	
	/**
	 * {@inheritDoc }
	 */
	public String toString() {
		return AbstractType.toString(this);
	}
	
}
