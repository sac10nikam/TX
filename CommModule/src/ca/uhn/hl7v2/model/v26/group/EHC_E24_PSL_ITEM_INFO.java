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

import net.newel.android.Log;
import ca.uhn.hl7v2.model.v26.segment.*;

import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.util.Constants;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a EHC_E24_PSL_ITEM_INFO group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                 * <li>1: PSL (Product/Service Line Item) <b> </b></li>
                 * <li>2: AUT (Authorization Information) <b>optional </b></li>
                 * <li>3: EHC_E24_PAYER_ADJUSTMENT (a Group object) <b>optional repeating</b></li>
 * </ul>
 */
public class EHC_E24_PSL_ITEM_INFO extends AbstractGroup {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5117155035301832488L;


	/** 
     * Creates a new EHC_E24_PSL_ITEM_INFO group
     */
    public EHC_E24_PSL_ITEM_INFO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(PSL.class, true, false);
                          this.add(AUT.class, false, false);
                          this.add(EHC_E24_PAYER_ADJUSTMENT.class, false, true);
       } catch(HL7Exception e) {
    	   Log.e(Constants.TAG, "Unexpected error creating EHC_E24_PSL_ITEM_INFO - this is probably a bug in the source code generator.", e);
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
     * PSL (Product/Service Line Item) - creates it if necessary
     */
    public PSL getPSL() { 
       PSL retVal = getTyped("PSL", PSL.class);
       return retVal;
    }




    /**
     * Returns
     * AUT (Authorization Information) - creates it if necessary
     */
    public AUT getAUT() { 
       AUT retVal = getTyped("AUT", AUT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PAYER_ADJUSTMENT (a Group object) - creates it if necessary
     */
    public EHC_E24_PAYER_ADJUSTMENT getPAYER_ADJUSTMENT() { 
       EHC_E24_PAYER_ADJUSTMENT retVal = getTyped("PAYER_ADJUSTMENT", EHC_E24_PAYER_ADJUSTMENT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PAYER_ADJUSTMENT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E24_PAYER_ADJUSTMENT getPAYER_ADJUSTMENT(int rep) { 
       EHC_E24_PAYER_ADJUSTMENT retVal = getTyped("PAYER_ADJUSTMENT", rep, EHC_E24_PAYER_ADJUSTMENT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PAYER_ADJUSTMENT 
     */ 
    public int getPAYER_ADJUSTMENTReps() {  
        return getReps("PAYER_ADJUSTMENT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PAYER_ADJUSTMENT.
     * <p>
     * <p>
     * Note that unlike {@link #getPAYER_ADJUSTMENT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<EHC_E24_PAYER_ADJUSTMENT> getPAYER_ADJUSTMENTAll() throws HL7Exception {
    	return getAllAsList("PAYER_ADJUSTMENT", EHC_E24_PAYER_ADJUSTMENT.class);
    } 

    /**
     * Inserts a specific repetition of PAYER_ADJUSTMENT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPAYER_ADJUSTMENT(EHC_E24_PAYER_ADJUSTMENT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PAYER_ADJUSTMENT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PAYER_ADJUSTMENT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E24_PAYER_ADJUSTMENT insertPAYER_ADJUSTMENT(int rep) throws HL7Exception { 
       return (EHC_E24_PAYER_ADJUSTMENT)super.insertRepetition("PAYER_ADJUSTMENT", rep);
    }


    /**
     * Removes a specific repetition of PAYER_ADJUSTMENT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E24_PAYER_ADJUSTMENT removePAYER_ADJUSTMENT(int rep) throws HL7Exception { 
       return (EHC_E24_PAYER_ADJUSTMENT)super.removeRepetition("PAYER_ADJUSTMENT", rep);
    }



}

