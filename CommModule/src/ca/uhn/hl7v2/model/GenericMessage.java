package ca.uhn.hl7v2.model;


import net.newel.android.Log;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.util.Constants;

/**
 * A generic HL7 message, meant for parsing message with unrecognized structures
 * into a flat list of segments.
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public abstract class GenericMessage extends AbstractMessage {
	
    /** 
     * Creates a new instance of GenericMessage. 
     * 
     * @param factory class factory for contained structures 
     */
    public GenericMessage(ModelClassFactory factory) {
        super(factory);
        try {
            this.addNonstandardSegment("MSH");
        } catch(HL7Exception e) {
            String message = "Unexpected error adding GenericSegment to GenericMessage.";
            Log.e(Constants.TAG, message);
            throw new Error(message); // TODO better throw RuntimeException
        }        
    }
    
    /**
     * Returns a subclass of GenericMessage corresponding to a certain version.  
     * This is needed so that version-specific segments can be added as the message
     * is parsed.  
     */
	public static Class<? extends Message> getGenericMessageClass(String version) {
        if (!Version.supportsVersion(version))
            throw new IllegalArgumentException("The version " + version + " is not recognized");
        
        if ("2.1".equals(version)) {
        	return V21.class;
        }
        
        if ("2.2".equals(version)) {
        	return V22.class;
        }

        if ("2.3".equals(version)) {
        	return V23.class;
        }

        if ("2.3.1".equals(version)) {
        	return V231.class;
        }
        
        if ("2.4".equals(version)) {
        	return V24.class;
        }

        if ("2.5.1".equals(version)) {
        	return V25.class;
        }

        if ("2.5.1".equals(version)) {
        	return V251.class;
        }

        if ("2.6".equals(version)) {
        	return V26.class;
        }

        Log.d(Constants.TAG, "Unknown version for generic type {"+version+"}");
        
        return UnknownVersion.class;
    }


    public static class UnknownVersion extends GenericMessage {
		private static final long serialVersionUID = 4773366840392833956L;

		public UnknownVersion(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() {
        	return Version.latestVersion().getVersion();
        }

    }

    public static class V21 extends GenericMessage {
		private static final long serialVersionUID = 4773366840392833956L;
		public V21(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.1"; }
    }
    
    public static class V22 extends GenericMessage {
		private static final long serialVersionUID = 7124224621400437244L;
		public V22(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.2"; }
    }
    
    public static class V23 extends GenericMessage {
		private static final long serialVersionUID = -8794048442253389190L;
		public V23(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.3"; }
    }
    
    public static class V231 extends GenericMessage {
		private static final long serialVersionUID = 5979370667795858995L;
		public V231(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.3.1"; }
    }
    
    public static class V24 extends GenericMessage {
		private static final long serialVersionUID = -4944772617600551061L;
		public V24(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.4"; }
    }
    
    public static class V25 extends GenericMessage {
		private static final long serialVersionUID = 3937051332672967947L;
		public V25(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.5"; }
    }
    
    public static class V251 extends GenericMessage {
		private static final long serialVersionUID = -767282165482145544L;
		public V251(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.5.1"; }
    }

    public static class V26 extends GenericMessage {
		private static final long serialVersionUID = -1693277295151324396L;
		public V26(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.6"; }
    }

}
