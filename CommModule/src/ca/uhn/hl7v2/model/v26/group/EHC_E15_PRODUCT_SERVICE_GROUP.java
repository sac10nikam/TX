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
 * <p>Represents a EHC_E15_PRODUCT_SERVICE_GROUP group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                 * <li>1: PSG (Product/Service Group) <b> </b></li>
                 * <li>2: EHC_E15_PSL_ITEM_INFO (a Group object) <b> repeating</b></li>
 * </ul>
 */

public class EHC_E15_PRODUCT_SERVICE_GROUP extends AbstractGroup {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7710373512177113121L;


	/** 
     * Creates a new EHC_E15_PRODUCT_SERVICE_GROUP group
     */
    public EHC_E15_PRODUCT_SERVICE_GROUP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(PSG.class, true, false);
                          this.add(EHC_E15_PSL_ITEM_INFO.class, true, true);
       } catch(HL7Exception e) {
    	   Log.e(Constants.TAG, "Unexpected error creating EHC_E15_PRODUCT_SERVICE_GROUP - this is probably a bug in the source code generator.", e);
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
     * PSG (Product/Service Group) - creates it if necessary
     */
    public PSG getPSG() { 
       PSG retVal = getTyped("PSG", PSG.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PSL_ITEM_INFO (a Group object) - creates it if necessary
     */
    public EHC_E15_PSL_ITEM_INFO getPSL_ITEM_INFO() { 
       EHC_E15_PSL_ITEM_INFO retVal = getTyped("PSL_ITEM_INFO", EHC_E15_PSL_ITEM_INFO.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PSL_ITEM_INFO (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E15_PSL_ITEM_INFO getPSL_ITEM_INFO(int rep) { 
       EHC_E15_PSL_ITEM_INFO retVal = getTyped("PSL_ITEM_INFO", rep, EHC_E15_PSL_ITEM_INFO.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PSL_ITEM_INFO 
     */ 
    public int getPSL_ITEM_INFOReps() {  
        return getReps("PSL_ITEM_INFO");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PSL_ITEM_INFO.
     * <p>
     * <p>
     * Note that unlike {@link #getPSL_ITEM_INFO()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<EHC_E15_PSL_ITEM_INFO> getPSL_ITEM_INFOAll() throws HL7Exception {
    	return getAllAsList("PSL_ITEM_INFO", EHC_E15_PSL_ITEM_INFO.class);
    } 

    /**
     * Inserts a specific repetition of PSL_ITEM_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPSL_ITEM_INFO(EHC_E15_PSL_ITEM_INFO structure, int rep) throws HL7Exception { 
       super.insertRepetition("PSL_ITEM_INFO", structure, rep);
    }


    /**
     * Inserts a specific repetition of PSL_ITEM_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E15_PSL_ITEM_INFO insertPSL_ITEM_INFO(int rep) throws HL7Exception { 
       return (EHC_E15_PSL_ITEM_INFO)super.insertRepetition("PSL_ITEM_INFO", rep);
    }


    /**
     * Removes a specific repetition of PSL_ITEM_INFO (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E15_PSL_ITEM_INFO removePSL_ITEM_INFO(int rep) throws HL7Exception { 
       return (EHC_E15_PSL_ITEM_INFO)super.removeRepetition("PSL_ITEM_INFO", rep);
    }



}

