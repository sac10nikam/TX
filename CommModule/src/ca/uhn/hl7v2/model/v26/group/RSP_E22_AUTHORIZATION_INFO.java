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
 * <p>Represents a RSP_E22_AUTHORIZATION_INFO group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                 * <li>1: IVC (Invoice Segment) <b> </b></li>
                 * <li>2: PSG (Product/Service Group) <b> </b></li>
                 * <li>3: RSP_E22_PSL_ITEM_INFO (a Group object) <b> repeating</b></li>
 * </ul>
 */
public class RSP_E22_AUTHORIZATION_INFO extends AbstractGroup {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new RSP_E22_AUTHORIZATION_INFO group
     */
    public RSP_E22_AUTHORIZATION_INFO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(IVC.class, true, false);
                          this.add(PSG.class, true, false);
                          this.add(RSP_E22_PSL_ITEM_INFO.class, true, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating RSP_E22_AUTHORIZATION_INFO - this is probably a bug in the source code generator.", e);
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
     * IVC (Invoice Segment) - creates it if necessary
     */
    public IVC getIVC() { 
       IVC retVal = getTyped("IVC", IVC.class);
       return retVal;
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
    public RSP_E22_PSL_ITEM_INFO getPSL_ITEM_INFO() { 
       RSP_E22_PSL_ITEM_INFO retVal = getTyped("PSL_ITEM_INFO", RSP_E22_PSL_ITEM_INFO.class);
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
    public RSP_E22_PSL_ITEM_INFO getPSL_ITEM_INFO(int rep) { 
       RSP_E22_PSL_ITEM_INFO retVal = getTyped("PSL_ITEM_INFO", rep, RSP_E22_PSL_ITEM_INFO.class);
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
    public List<RSP_E22_PSL_ITEM_INFO> getPSL_ITEM_INFOAll() throws HL7Exception {
    	return getAllAsList("PSL_ITEM_INFO", RSP_E22_PSL_ITEM_INFO.class);
    } 

    /**
     * Inserts a specific repetition of PSL_ITEM_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPSL_ITEM_INFO(RSP_E22_PSL_ITEM_INFO structure, int rep) throws HL7Exception { 
       super.insertRepetition("PSL_ITEM_INFO", structure, rep);
    }


    /**
     * Inserts a specific repetition of PSL_ITEM_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RSP_E22_PSL_ITEM_INFO insertPSL_ITEM_INFO(int rep) throws HL7Exception { 
       return (RSP_E22_PSL_ITEM_INFO)super.insertRepetition("PSL_ITEM_INFO", rep);
    }


    /**
     * Removes a specific repetition of PSL_ITEM_INFO (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RSP_E22_PSL_ITEM_INFO removePSL_ITEM_INFO(int rep) throws HL7Exception { 
       return (RSP_E22_PSL_ITEM_INFO)super.removeRepetition("PSL_ITEM_INFO", rep);
    }



}

