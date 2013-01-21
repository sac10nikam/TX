/*
 * This class is an auto-generated source file for a HAPI
 * HL7 v2.x standard structure class.
 *
 * For more information, visit: http://hl7api.sourceforge.net/
 * 
 * The contents of this file are subject to the Mozilla Public License Version 1.1 
 * (the "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
 * Software distributed under the License is distributed on an "AS IS" basis, 
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
 * specific language governing rights and limitations under the License. 
 * 
 * The Original Code is "[file_name]".  Description: 
 * "[one_line_description]" 
 * 
 * The Initial Developer of the Original Code is University Health Network. Copyright (C) 
 * 2012.  All Rights Reserved. 
 * 
 * Contributor(s): ______________________________________. 
 * 
 * Alternatively, the contents of this file may be used under the terms of the 
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
 * applicable instead of those above.  If you wish to allow use of your version of this 
 * file only under the terms of the GPL and not to allow others to use your version 
 * of this file under the MPL, indicate your decision by deleting  the provisions above 
 * and replace  them with the notice and other provisions required by the GPL License.  
 * If you do not delete the provisions above, a recipient may use your version of 
 * this file under either the MPL or the GPL. 
 * 
 */


package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.model.v26.segment.*;

import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;
import net.newel.android.Log;
import ca.uhn.hl7v2.util.Constants;


/**
 * <p>Represents a OUL_R22_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                 * <li>1: OBR (Observation Request) <b> </b></li>
                 * <li>2: ORC (Common Order) <b>optional </b></li>
                 * <li>3: NTE (Notes and Comments) <b>optional repeating</b></li>
                 * <li>4: ROL (Role) <b>optional repeating</b></li>
                 * <li>5: OUL_R22_TIMING_QTY (a Group object) <b>optional repeating</b></li>
                 * <li>6: OUL_R22_RESULT (a Group object) <b>optional repeating</b></li>
                 * <li>7: CTI (Clinical Trial Identification) <b>optional repeating</b></li>
 * </ul>
 */
public class OUL_R22_ORDER extends AbstractGroup {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new OUL_R22_ORDER group
     */
    public OUL_R22_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(OBR.class, true, false);
                          this.add(ORC.class, false, false);
                          this.add(NTE.class, false, true);
                          this.add(ROL.class, false, true);
                          this.add(OUL_R22_TIMING_QTY.class, false, true);
                          this.add(OUL_R22_RESULT.class, false, true);
                          this.add(CTI.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating OUL_R22_ORDER - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.6"
     */
    public String getVersion() {
       return "2.6";
    }



    /**
     * Returns
     * OBR (Observation Request) - creates it if necessary
     */
    public OBR getOBR() { 
       OBR retVal = getTyped("OBR", OBR.class);
       return retVal;
    }




    /**
     * Returns
     * ORC (Common Order) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (Notes and Comments) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE(int rep) { 
       NTE retVal = getTyped("NTE", rep, NTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NTE 
     */ 
    public int getNTEReps() {  
        return getReps("NTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NTE.
     * <p>
     * <p>
     * Note that unlike {@link #getNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<NTE> getNTEAll() throws HL7Exception {
    	return getAllAsList("NTE", NTE.class);
    } 

    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROL (Role) - creates it if necessary
     */
    public ROL getROL() { 
       ROL retVal = getTyped("ROL", ROL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       ROL retVal = getTyped("ROL", rep, ROL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROL 
     */ 
    public int getROLReps() {  
        return getReps("ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * Removes a specific repetition of ROL (Role)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * TIMING_QTY (a Group object) - creates it if necessary
     */
    public OUL_R22_TIMING_QTY getTIMING_QTY() { 
       OUL_R22_TIMING_QTY retVal = getTyped("TIMING_QTY", OUL_R22_TIMING_QTY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING_QTY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OUL_R22_TIMING_QTY getTIMING_QTY(int rep) { 
       OUL_R22_TIMING_QTY retVal = getTyped("TIMING_QTY", rep, OUL_R22_TIMING_QTY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING_QTY 
     */ 
    public int getTIMING_QTYReps() {  
        return getReps("TIMING_QTY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING_QTY.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING_QTY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<OUL_R22_TIMING_QTY> getTIMING_QTYAll() throws HL7Exception {
    	return getAllAsList("TIMING_QTY", OUL_R22_TIMING_QTY.class);
    } 

    /**
     * Inserts a specific repetition of TIMING_QTY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING_QTY(OUL_R22_TIMING_QTY structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING_QTY", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING_QTY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OUL_R22_TIMING_QTY insertTIMING_QTY(int rep) throws HL7Exception { 
       return (OUL_R22_TIMING_QTY)super.insertRepetition("TIMING_QTY", rep);
    }


    /**
     * Removes a specific repetition of TIMING_QTY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OUL_R22_TIMING_QTY removeTIMING_QTY(int rep) throws HL7Exception { 
       return (OUL_R22_TIMING_QTY)super.removeRepetition("TIMING_QTY", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RESULT (a Group object) - creates it if necessary
     */
    public OUL_R22_RESULT getRESULT() { 
       OUL_R22_RESULT retVal = getTyped("RESULT", OUL_R22_RESULT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RESULT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OUL_R22_RESULT getRESULT(int rep) { 
       OUL_R22_RESULT retVal = getTyped("RESULT", rep, OUL_R22_RESULT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RESULT 
     */ 
    public int getRESULTReps() {  
        return getReps("RESULT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RESULT.
     * <p>
     * <p>
     * Note that unlike {@link #getRESULT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<OUL_R22_RESULT> getRESULTAll() throws HL7Exception {
    	return getAllAsList("RESULT", OUL_R22_RESULT.class);
    } 

    /**
     * Inserts a specific repetition of RESULT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESULT(OUL_R22_RESULT structure, int rep) throws HL7Exception { 
       super.insertRepetition("RESULT", structure, rep);
    }


    /**
     * Inserts a specific repetition of RESULT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OUL_R22_RESULT insertRESULT(int rep) throws HL7Exception { 
       return (OUL_R22_RESULT)super.insertRepetition("RESULT", rep);
    }


    /**
     * Removes a specific repetition of RESULT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OUL_R22_RESULT removeRESULT(int rep) throws HL7Exception { 
       return (OUL_R22_RESULT)super.removeRepetition("RESULT", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CTI (Clinical Trial Identification) - creates it if necessary
     */
    public CTI getCTI() { 
       CTI retVal = getTyped("CTI", CTI.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CTI (Clinical Trial Identification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CTI getCTI(int rep) { 
       CTI retVal = getTyped("CTI", rep, CTI.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CTI 
     */ 
    public int getCTIReps() {  
        return getReps("CTI");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CTI.
     * <p>
     * <p>
     * Note that unlike {@link #getCTI()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<CTI> getCTIAll() throws HL7Exception {
    	return getAllAsList("CTI", CTI.class);
    } 

    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCTI(CTI structure, int rep) throws HL7Exception { 
       super.insertRepetition("CTI", structure, rep);
    }


    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CTI insertCTI(int rep) throws HL7Exception { 
       return (CTI)super.insertRepetition("CTI", rep);
    }


    /**
     * Removes a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CTI removeCTI(int rep) throws HL7Exception { 
       return (CTI)super.removeRepetition("CTI", rep);
    }



}

