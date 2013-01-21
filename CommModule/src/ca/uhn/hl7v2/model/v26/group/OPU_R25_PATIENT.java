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
 * <p>Represents a OPU_R25_PATIENT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                 * <li>1: PID (Patient Identification) <b> </b></li>
                 * <li>2: PD1 (Patient Additional Demographic) <b>optional </b></li>
                 * <li>3: OPU_R25_PATIENT_OBSERVATION (a Group object) <b>optional repeating</b></li>
 * </ul>
 */
public class OPU_R25_PATIENT extends AbstractGroup {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new OPU_R25_PATIENT group
     */
    public OPU_R25_PATIENT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(PID.class, true, false);
                          this.add(PD1.class, false, false);
                          this.add(OPU_R25_PATIENT_OBSERVATION.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating OPU_R25_PATIENT - this is probably a bug in the source code generator.", e);
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
     * PID (Patient Identification) - creates it if necessary
     */
    public PID getPID() { 
       PID retVal = getTyped("PID", PID.class);
       return retVal;
    }




    /**
     * Returns
     * PD1 (Patient Additional Demographic) - creates it if necessary
     */
    public PD1 getPD1() { 
       PD1 retVal = getTyped("PD1", PD1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PATIENT_OBSERVATION (a Group object) - creates it if necessary
     */
    public OPU_R25_PATIENT_OBSERVATION getPATIENT_OBSERVATION() { 
       OPU_R25_PATIENT_OBSERVATION retVal = getTyped("PATIENT_OBSERVATION", OPU_R25_PATIENT_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PATIENT_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPU_R25_PATIENT_OBSERVATION getPATIENT_OBSERVATION(int rep) { 
       OPU_R25_PATIENT_OBSERVATION retVal = getTyped("PATIENT_OBSERVATION", rep, OPU_R25_PATIENT_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PATIENT_OBSERVATION 
     */ 
    public int getPATIENT_OBSERVATIONReps() {  
        return getReps("PATIENT_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<OPU_R25_PATIENT_OBSERVATION> getPATIENT_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("PATIENT_OBSERVATION", OPU_R25_PATIENT_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of PATIENT_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT_OBSERVATION(OPU_R25_PATIENT_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("PATIENT_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of PATIENT_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPU_R25_PATIENT_OBSERVATION insertPATIENT_OBSERVATION(int rep) throws HL7Exception { 
       return (OPU_R25_PATIENT_OBSERVATION)super.insertRepetition("PATIENT_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of PATIENT_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPU_R25_PATIENT_OBSERVATION removePATIENT_OBSERVATION(int rep) throws HL7Exception { 
       return (OPU_R25_PATIENT_OBSERVATION)super.removeRepetition("PATIENT_OBSERVATION", rep);
    }



}

