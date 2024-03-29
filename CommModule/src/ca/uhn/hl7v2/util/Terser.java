/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "Terser.java".  Description:
 * "Wraps a message to provide access to fields using a more terse syntax."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): Ryan W. Gross (General Electric Corporation - Healthcare IT).
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.util;

import net.newel.android.Log;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.HL7Exception;
import java.util.StringTokenizer;

/**
 * <p>Wraps a message to provide access to fields using a terse location
 * specification syntax.  For example: </p>
 * <p><code>terser.set("MSH-9-3", "ADT_A01");</code>  <br>
 * can be used instead of <br>
 * <code>message.getMSH().getMessageType().getMessageStructure().setValue("ADT_A01"); </code> </p>
 * <p>The syntax of a location spec is as follows: </p>
 * <p>location_spec: <code>segment_path_spec "-" field ["(" rep ")"] ["-" component ["-" subcomponent]] </code></p>
 * <p>... where rep, field, component, and subcomponent are integers (representing, respectively,
 * the field repetition (starting at 0), and the field number, component number, and subcomponent
 * numbers (starting at 1).  Omitting the rep is equivalent to specifying 0; omitting the
 * component or subcomponent is equivalent to specifying 1.</p>
 * <p>The syntax for the segment_path_spec is as follows: </p>
 * <p>segment_path_spec: </code> ["/"] (group_spec ["(" rep ")"] "/")* segment_spec ["(" rep ")"]</code></p>
 * <p> ... where rep has the same meaning as for fields.  A leading "/" indicates that navigation to the
 * location begins at the root of the message; ommitting this indicates that navigation begins at the
 * current location of the underlying SegmentFinder (see getFinder() -- this allows manual navigation
 * if desired).  The syntax for group_spec is: </p>
 * <p>group_spec: <code>["."] group_name_pattern</code></p>
 * <p>Here, a . indicates that the group should be searched for (using a SegmentFinder) starting at the
 * current location in the message.  The wildcards "*" and "?" represent any number of arbitrary characters, 
 * and a single arbitrary character, respectively.  For example, "M*" and "?S?" match MSH.  The first
 * group with a name that matches the given group_name_pattern will be matched.  </p>
 * <p>The segment_spec is analogous to the group_spec. </p>
 * <p>As another example, the following subcomponent in an SIU_S12 message: <p>
 * <p><code>msg.getSIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE(1).getSIU_S12_AIGNTE().getAIG().getResourceGroup(1).getIdentifier();</code></p>
 * </p> ... is referenced by all of the following location_spec: </p>
 * <p><code>/SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE(1)/SIU_S12_AIGNTE/AIG-5(1)-1 <br>
 * /*AIG*(1)/SIU_S12_AIGNTE/AIG-5(1)-1 <br>
 * /*AIG*(1)/.AIG-5(1) <code></p>
 * <p>The search function only iterates through rep 0 of each group.  Thus if rep 0 of the first group
 * in this example was desired instead of rep 1, the following syntax would also work (since there is
 * only one AIG segment position in SUI_S12): </p>
 * <p><code>/.AIG-5(1)</code></p>
 * 
 * @author Bryan Tripp
 * @author Ryan W. Gross (General Electric Corporation - Healthcare IT).
 */
public class Terser {
    
    private SegmentFinder finder;
    
    /** Creates a new instance of Terser */
    public Terser(Message message) {
        finder = new SegmentFinder(message);
    }
    
    /**
     * Returns the string value of the Primitive at the given location.
     * @param segment the segment from which to get the primitive
     * @param field the field number (indexed from 1)
     * @param rep the field repetition (indexed from 0)
     * @param component the component number (indexed from 1, use 1 for primitive field)
     * @param subcomponent the subcomponent number (indexed from 1, use 1 for primitive component)
     */
    public static String get(Segment segment, int field, int rep, int component, int subcomponent) throws HL7Exception {
        if (segment == null) {
        	throw new NullPointerException("segment may not be null");
        }
        if (rep < 0) {
        	throw new IllegalArgumentException("rep must not be negative");
        }
        if (component < 1) {
        	throw new IllegalArgumentException("component must not be 1 or more (note that this parameter is 1-indexed, not 0-indexed)");
        }
        if (subcomponent < 1) {
        	throw new IllegalArgumentException("subcomponent must not be 1 or more (note that this parameter is 1-indexed, not 0-indexed)");
        }
        
    	Primitive prim = getPrimitive(segment, field, rep, component, subcomponent);
        return prim.getValue();
    }
    
    /**
     * Sets the string value of the Primitive at the given location.
     * @param segment the segment from which to get the primitive
     * @param field the field number (indexed from 1)
     * @param rep the field repetition (indexed from 0)
     * @param component the component number (indexed from 1, use 1 for primitive field)
     * @param subcomponent the subcomponent number (indexed from 1, use 1 for primitive component)
     */
    public static void set(Segment segment, int field, int rep, int component, int subcomponent, String value) throws HL7Exception {
        if (segment == null) {
        	throw new NullPointerException("segment may not be null");
        }
        if (rep < 0) {
        	throw new IllegalArgumentException("rep must not be negative");
        }
        if (component < 1) {
        	throw new IllegalArgumentException("component must not be 1 or more (note that this parameter is 1-indexed, not 0-indexed)");
        }
        if (subcomponent < 1) {
        	throw new IllegalArgumentException("subcomponent must not be 1 or more (note that this parameter is 1-indexed, not 0-indexed)");
        }

        Primitive prim = getPrimitive(segment, field, rep, component, subcomponent);
        prim.setValue(value);
    }
    
    /**
     * Returns the Primitive object at the given location.
     */
    private static Primitive getPrimitive(Segment segment, int field, int rep, int component, int subcomponent) throws HL7Exception {
        Type type = segment.getField(field, rep);
        return getPrimitive(type, component, subcomponent);
    }
    
    
	/**
	 * Returns the Primitive object at the given location in the given field.
	 * It is intended that the given type be at the field level, although extra components
	 * will be added blindly if, for example, you provide a primitive subcomponent instead
	 * and specify component or subcomponent > 1
     * @param type the type from which to get the primitive
     * @param component the component number (indexed from 1, use 1 for primitive field)
     * @param subcomponent the subcomponent number (indexed from 1, use 1 for primitive component)
	 */
	public static Primitive getPrimitive(final Type type, final int component, final int subcomponent) {
        if (type == null) {
        	throw new NullPointerException("type may not be null");
        }
        if (component < 1) {
        	throw new IllegalArgumentException("component must not be 1 or more (note that this parameter is 1-indexed, not 0-indexed)");
        }
        if (subcomponent < 1) {
        	throw new IllegalArgumentException("subcomponent must not be 1 or more (note that this parameter is 1-indexed, not 0-indexed)");
        }


        Type comp = getComponent(type, component);
		if(type instanceof Varies && comp instanceof GenericPrimitive && subcomponent > 1) {
			try {
				final Varies varies = (Varies)type;
				final GenericComposite comp2 = new GenericComposite(type.getMessage());
				varies.setData(comp2);
				comp = getComponent(type, component);
			} catch (final DataTypeException de) {
				final String message = "Unexpected exception copying data to generic composite. This is probably a bug within HAPI. " + de.getMessage();
				Log.e(Constants.TAG, message);
				throw new Error(message);
			}
		}
		final Type sub = getComponent(comp, subcomponent);
		return getPrimitive(sub);
	}

    
    /** 
     * Attempts to extract a Primitive from the given type. If it's a composite, 
     * drills down through first components until a primitive is reached. 
     */
    private static Primitive getPrimitive(Type type) {
        Primitive p = null;
        if (Varies.class.isAssignableFrom(type.getClass())) {
            p = getPrimitive(((Varies) type).getData());
        } else if (Composite.class.isAssignableFrom(type.getClass())) {
            try {
                p = getPrimitive(((Composite) type).getComponent(0));            
            } catch (HL7Exception e) {
                throw new Error("Internal error: HL7Exception thrown on Composite.getComponent(0)."); 
            }
        } else if (type instanceof Primitive) {
            p = (Primitive) type;
        } 
        return p;
    }
    
    /**
     * Returns the component (or sub-component, as the case may be) at the given
     * index.  If it does not exist, it is added as an "extra component".  
     * If comp > 1 is requested from a Varies with GenericPrimitive data, the 
     * data is set to GenericComposite (this avoids the creation of a chain of 
     * ExtraComponents on GenericPrimitives).  
     * Components are numbered from 1.  
     */
    private static Type getComponent(Type type, int comp) {
        Type ret = null;
        if (Varies.class.isAssignableFrom(type.getClass())) {
            Varies v = (Varies) type;
            
            try {
                if (comp > 1 && GenericPrimitive.class.isAssignableFrom(v.getData().getClass())) 
                    v.setData(new GenericComposite(v.getMessage()));
            } catch (DataTypeException de) {
                String message = "Unexpected exception copying data to generic composite: " + de.getMessage(); 
                Log.e(Constants.TAG, message);
                throw new Error(message);
            }
            
            ret = getComponent(v.getData(), comp);
        } else {
            if (Primitive.class.isAssignableFrom(type.getClass()) && comp == 1) {
                ret = type;
            } else if (GenericComposite.class.isAssignableFrom(type.getClass()) 
                || (Composite.class.isAssignableFrom(type.getClass()) && comp <= numStandardComponents(type))) {
                //note that GenericComposite can return components > number of standard components
                
                try {
                    ret = ((Composite) type).getComponent(comp - 1);
                } catch (Exception e) {
                    throw new Error("Internal error: HL7Exception thrown on getComponent(x) where x < # standard components.", e);
                }
            } else {
                ret = type.getExtraComponents().getComponent(comp - numStandardComponents(type) - 1);
            }
        }
        return ret;
    }
    
    /**
     * <p>Gets the string value of the field specified.  See the class docs for syntax
     * of the location spec.  </p>
     * <p>If a repetition is omitted for a repeating segment or field, the first rep is used.
     * If the component or subcomponent is not specified for a composite field, the first
     * component is used (this allows one to write code that will work with later versions of
     * the HL7 standard).
     */
    public String get(String spec) throws HL7Exception {
        StringTokenizer tok = new StringTokenizer(spec, "-", false);
        Segment segment = getSegment(tok.nextToken());
        
        int[] ind = getIndices(spec);
        return get(segment, ind[0], ind[1], ind[2], ind[3]);
    }
    
    /** 
     * Returns the segment specified in the given segment_path_spec. 
     */
    public Segment getSegment(String segSpec) throws HL7Exception {
        Segment seg = null;
        
        if (segSpec.substring(0, 1).equals("/")) {
            getFinder().reset();
        }
        
        StringTokenizer tok = new StringTokenizer(segSpec, "/", false);
        SegmentFinder finder = getFinder();
        while(tok.hasMoreTokens()) {
            String pathSpec = tok.nextToken();
            Terser.PathSpec ps = parsePathSpec(pathSpec);
            if (tok.hasMoreTokens()) {
                ps.isGroup = true;
            } else {
                ps.isGroup = false;
            }
            
            if (ps.isGroup) {
                Group g = null;
                if (ps.find) {
                    g = finder.findGroup(ps.pattern, ps.rep);
                } else {
                    g = finder.getGroup(ps.pattern, ps.rep);
                }
                finder = new SegmentFinder(g);
            } else {
                if (ps.find) {
                    seg = finder.findSegment(ps.pattern, ps.rep);
                } else {
                    seg = finder.getSegment(ps.pattern, ps.rep);
                }
            }
        }
        
        return seg;
    }
    
    /** Gets path information from a path spec. */
    private PathSpec parsePathSpec(String spec) throws HL7Exception {
        PathSpec ps = new PathSpec();
        
        if (spec.startsWith(".")) {
            ps.find = true;
            spec = spec.substring(1);
        } else {
            ps.find = false;
        }
        
        if (spec.length() == 0) {
            throw new HL7Exception("Invalid path (some path element is either empty or contains only a dot)");
        }
        StringTokenizer tok = new StringTokenizer(spec, "()", false);
        ps.pattern = tok.nextToken();
        if (tok.hasMoreTokens()) {
            String repString = tok.nextToken();
            try {
                ps.rep = Integer.parseInt(repString);
            } catch (NumberFormatException e) {
                throw new HL7Exception(repString + " is not a valid rep #", HL7Exception.APPLICATION_INTERNAL_ERROR);
            }
        } else {
            ps.rep = 0;
        }
        return ps;
    }
    
    /** 
     * Given a Terser path, returns an array containing field num, field rep, 
     * component, and subcomponent.  
     */
    public static int[] getIndices(String spec) throws HL7Exception {
        StringTokenizer tok = new StringTokenizer(spec, "-", false);
        tok.nextToken();  //skip over segment
        if (!tok.hasMoreTokens())
            throw new HL7Exception("Must specify field in spec " + spec, HL7Exception.APPLICATION_INTERNAL_ERROR);
        
        int[] ret = null;
        try {
            StringTokenizer fieldSpec = new StringTokenizer(tok.nextToken(), "()", false);
            int fieldNum = Integer.parseInt(fieldSpec.nextToken());
            int fieldRep = 0;
            if (fieldSpec.hasMoreTokens()) {
                fieldRep = Integer.parseInt(fieldSpec.nextToken());
            }
            
            int component = 1;
            if (tok.hasMoreTokens()) {
                component = Integer.parseInt(tok.nextToken());
            }
            
            int subcomponent = 1;
            if (tok.hasMoreTokens()) {
                subcomponent = Integer.parseInt(tok.nextToken());
            }
            int[] result = {fieldNum, fieldRep, component, subcomponent};
            ret = result;
        } catch (NumberFormatException e) {
            throw new HL7Exception("Invalid integer in spec " + spec, HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        
        return ret;
    }
    
    /**
     * Sets the string value of the field specified.  See class docs for location spec syntax.
     */
    public void set(String spec, String value) throws HL7Exception {
        StringTokenizer tok = new StringTokenizer(spec, "-", false);
        Segment segment = getSegment(tok.nextToken());
        
        int[] ind = getIndices(spec);
        Log.d(Constants.TAG, "Setting {"+spec+"} seg: {"+segment.getName()+"} ind: {"+ind[0]+"} {"+ind[1]+"} {"+ind[2]+"} {"+ind[3]+"}");            
        set(segment, ind[0], ind[1], ind[2], ind[3], value);
    }
    
    /**
     * Returns the number of components in the given field, i.e. the
     * number of standard components (e.g. 6 for CE) plus any extra components that
     * have been added at runtime.  This may vary by repetition, as different reps
     * may have different extra components.
     */
    /*public static int numComponents(Type field) throws HL7Exception {
        return numComponents(seg.getField(field, rep));
    }*/
    
    /**
     * Returns the number of sub-components in the specified component, i.e. 
     * the number of standard sub-components (e.g. 6 for CE) plus any extra components that
     * that have been added at runtime.
     * @param component numbered from 1 
     */
    public static int numSubComponents(Type type, int component) {
        int n = -1;
        if (component == 1 && Primitive.class.isAssignableFrom(type.getClass())) {
            //note that getComponent(primitive, 1) below returns the primitive 
            //itself -- if we do numComponents on it, we'll end up with the 
            //number of components in the field, not the number of subcomponents
            n = 1;
        } else {
            Type comp = getComponent(type, component);
            n = numComponents(comp);
        }
        return n;
        /*
        //Type t = seg.getField(field, rep);
        if (Varies.class.isAssignableFrom(type.getClass())) {
            return numSubComponents(((Varies) type).getData(), component);
        } else if (Primitive.class.isAssignableFrom(type.getClass()) && component == 1) {
            n = 1;  
        } else if (Composite.class.isAssignableFrom(type.getClass()) && component <= numStandardComponents(t)) {
            n = numComponents(((Composite) type).getComponent(component - 1));
        } else { //we're being asked about subcomponents of an extra component
            n = numComponents(t.getExtraComponents().getComponent(component - numStandardComponents(t) - 1));
        }
        return n;
         */
    }
    
    /**
     * Returns the number of components in the given type, i.e. the
     * number of standard components (e.g. 6 for CE) plus any extra components that
     * have been added at runtime.  
     */
    public static int numComponents(Type type) {
        if (Varies.class.isAssignableFrom(type.getClass())) {
            return numComponents(((Varies) type).getData());
        } else {
            return numStandardComponents(type) + type.getExtraComponents().numComponents();
        }
    }
    
    private static int numStandardComponents(Type t) {
        int n = 0;
        if (Varies.class.isAssignableFrom(t.getClass())) {
            n = numStandardComponents(((Varies) t).getData());
        } else if (Composite.class.isAssignableFrom(t.getClass())) {
            n = ((Composite) t).getComponents().length;
        } else {
            n = 1;
        }
        return n;
    }
    
    /**
     * Returns the segment finder used by this Terser.  Navigating the
     * finder will influence the behaviour of the Terser accordingly.  Ie
     * when the full path of the segment is not specified the segment will
     * be sought beginning at the current location of the finder.
     */
    public SegmentFinder getFinder() {
        return finder;
    }
    
    /** Struct for information about a step in a segment path. */
    private class PathSpec {
        public String pattern;
        public boolean isGroup;
        public boolean find;
        public int rep;
    }
}
