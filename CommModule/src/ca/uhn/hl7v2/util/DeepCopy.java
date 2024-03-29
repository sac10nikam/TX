package ca.uhn.hl7v2.util;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.*;

/**
 * Tools for copying data recurvisely from one message element into another.  Currently only Types are 
 * supported.  
 * @author Bryan Tripp
 */
public class DeepCopy {
    
    /**
     * Copies data from the "from" Type into the "to" Type.  Either Type may be 
     * a Primitive, Composite, or Varies.  If a Varies is provided, the operation is 
     * performed on the result of calling its getData() method.  A Primitive may be 
     * copied into a Composite, in which case the value is copied into the first 
     * component of the Composite.  A Composite may be copied into a Primitive, 
     * in which case the first component is copied.  Given Composites with different 
     * numbers of components, the first components are copied, up to the length 
     * of the smaller one.  
     */
    public static void copy(Type from, Type to) throws DataTypeException {
        for (int i = 1; i <= Terser.numComponents(from); i++) {
            for (int j = 1; j <= Terser.numSubComponents(from, i); j++) {
                String val = Terser.getPrimitive(from, i, j).getValue();
                Terser.getPrimitive(to, i, j).setValue(val);
            }
        }
    }
    
    /*    if (from instanceof Varies) {
            from = ((Varies) from).getData();
        }        
        if (to instanceof Varies) {
            to = ((Varies) to).getData();
        }
        if (from instanceof Primitive) {
            if (to instanceof Primitive) {
                copy((Primitive) from, (Primitive) to);
            } else {
                copy((Primitive) from, (Composite) to);                
            }
        } else {
            if (to instanceof Primitive) {
                copy((Composite) from, (Primitive) to);                
            } else {
                copy((Composite) from, (Composite) to);                
            }            
        }
    }*/
    
    /** Copies a primitive to a primitive */
    /*private static void copy(Primitive from, Primitive to) throws DataTypeException {
        to.setValue(from.getValue());
    }*/
    
    /** Copies composite to composite - could be different # of components (extras either way are ignored) */
    /*private static void copy(Composite from, Composite to) throws DataTypeException {
        Type[] froms = from.getComponents();
        Type[] tos = to.getComponents();
        int limit = Math.min(froms.length, tos.length);
        for (int i = 0; i < limit; i++) {
            copy(froms[i], tos[i]);
        }
    }*/
    
    /** Copies primitive to first component of composite.  */
    /*private static void copy(Primitive from, Composite to) throws DataTypeException {
        Type firstComponent = to.getComponent(0);
        copy(from, firstComponent);
    }*/
    
    /** Copies first component of composite to a primitive */
    /*private static void copy(Composite from, Primitive to) throws DataTypeException {
        Type firstComponent = from.getComponent(0);
        copy(firstComponent, to);
    }*/
    
    /**
     * Copies contents from the source segment to the destination segment.  This 
     * method calls copy(Type, Type) on each repetition of each field (see additional 
     * behavioural description there).  An attempt is made to copy each repetition of 
     * each field in the source segment, regardless of whether the corresponding 
     * destination field is repeating or even exists.  
     * @param from the segment from which data are copied 
     * @param to the segment into which data are copied
     */
    public static void copy(Segment from, Segment to) throws HL7Exception {
        int n = from.numFields();
        for (int i = 1; i <= n; i++) {
            Type[] reps = from.getField(i);
            for (int j = 0; j < reps.length; j++) {
                copy(reps[j], to.getField(i, j));
            }
        }
    }
}
