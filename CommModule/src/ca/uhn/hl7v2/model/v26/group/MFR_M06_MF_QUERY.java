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
 * <p>Represents a MFR_M06_MF_QUERY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                 * <li>1: MFE (Master File Entry) <b> </b></li>
                 * <li>2: CM0 (Clinical Study Master) <b> </b></li>
                 * <li>3: MFR_M06_MF_PHASE_SCHED_DETAIL (a Group object) <b>optional repeating</b></li>
 * </ul>
 */
public class MFR_M06_MF_QUERY extends AbstractGroup {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5876203335638622507L;


	/** 
     * Creates a new MFR_M06_MF_QUERY group
     */
    public MFR_M06_MF_QUERY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MFE.class, true, false);
                          this.add(CM0.class, true, false);
                          this.add(MFR_M06_MF_PHASE_SCHED_DETAIL.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating MFR_M06_MF_QUERY - this is probably a bug in the source code generator.", e);
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
     * MFE (Master File Entry) - creates it if necessary
     */
    public MFE getMFE() { 
       MFE retVal = getTyped("MFE", MFE.class);
       return retVal;
    }




    /**
     * Returns
     * CM0 (Clinical Study Master) - creates it if necessary
     */
    public CM0 getCM0() { 
       CM0 retVal = getTyped("CM0", CM0.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * MF_PHASE_SCHED_DETAIL (a Group object) - creates it if necessary
     */
    public MFR_M06_MF_PHASE_SCHED_DETAIL getMF_PHASE_SCHED_DETAIL() { 
       MFR_M06_MF_PHASE_SCHED_DETAIL retVal = getTyped("MF_PHASE_SCHED_DETAIL", MFR_M06_MF_PHASE_SCHED_DETAIL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * MF_PHASE_SCHED_DETAIL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFR_M06_MF_PHASE_SCHED_DETAIL getMF_PHASE_SCHED_DETAIL(int rep) { 
       MFR_M06_MF_PHASE_SCHED_DETAIL retVal = getTyped("MF_PHASE_SCHED_DETAIL", rep, MFR_M06_MF_PHASE_SCHED_DETAIL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of MF_PHASE_SCHED_DETAIL 
     */ 
    public int getMF_PHASE_SCHED_DETAILReps() {  
        return getReps("MF_PHASE_SCHED_DETAIL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MF_PHASE_SCHED_DETAIL.
     * <p>
     * <p>
     * Note that unlike {@link #getMF_PHASE_SCHED_DETAIL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<MFR_M06_MF_PHASE_SCHED_DETAIL> getMF_PHASE_SCHED_DETAILAll() throws HL7Exception {
    	return getAllAsList("MF_PHASE_SCHED_DETAIL", MFR_M06_MF_PHASE_SCHED_DETAIL.class);
    } 

    /**
     * Inserts a specific repetition of MF_PHASE_SCHED_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMF_PHASE_SCHED_DETAIL(MFR_M06_MF_PHASE_SCHED_DETAIL structure, int rep) throws HL7Exception { 
       super.insertRepetition("MF_PHASE_SCHED_DETAIL", structure, rep);
    }


    /**
     * Inserts a specific repetition of MF_PHASE_SCHED_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFR_M06_MF_PHASE_SCHED_DETAIL insertMF_PHASE_SCHED_DETAIL(int rep) throws HL7Exception { 
       return (MFR_M06_MF_PHASE_SCHED_DETAIL)super.insertRepetition("MF_PHASE_SCHED_DETAIL", rep);
    }


    /**
     * Removes a specific repetition of MF_PHASE_SCHED_DETAIL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFR_M06_MF_PHASE_SCHED_DETAIL removeMF_PHASE_SCHED_DETAIL(int rep) throws HL7Exception { 
       return (MFR_M06_MF_PHASE_SCHED_DETAIL)super.removeRepetition("MF_PHASE_SCHED_DETAIL", rep);
    }



}

