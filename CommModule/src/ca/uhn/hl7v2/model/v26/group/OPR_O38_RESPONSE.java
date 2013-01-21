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
 * <p>Represents a OPR_O38_RESPONSE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                 * <li>1: NK1 (Next of Kin / Associated Parties) <b> repeating</b></li>
                 * <li>2: PID (Patient Identification) <b>optional </b></li>
                 * <li>3: OPR_O38_SPECIMEN (a Group object) <b>optional repeating</b></li>
 * </ul>
 */
public class OPR_O38_RESPONSE extends AbstractGroup {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new OPR_O38_RESPONSE group
     */
    public OPR_O38_RESPONSE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(NK1.class, true, true);
                          this.add(PID.class, false, false);
                          this.add(OPR_O38_SPECIMEN.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating OPR_O38_RESPONSE - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NK1 getNK1(int rep) { 
       NK1 retVal = getTyped("NK1", rep, NK1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NK1 
     */ 
    public int getNK1Reps() {  
        return getReps("NK1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NK1.
     * <p>
     * <p>
     * Note that unlike {@link #getNK1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<NK1> getNK1All() throws HL7Exception {
    	return getAllAsList("NK1", NK1.class);
    } 

    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("NK1", structure, rep);
    }


    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * Removes a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
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
     * the first repetition of 
     * SPECIMEN (a Group object) - creates it if necessary
     */
    public OPR_O38_SPECIMEN getSPECIMEN() { 
       OPR_O38_SPECIMEN retVal = getTyped("SPECIMEN", OPR_O38_SPECIMEN.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SPECIMEN (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPR_O38_SPECIMEN getSPECIMEN(int rep) { 
       OPR_O38_SPECIMEN retVal = getTyped("SPECIMEN", rep, OPR_O38_SPECIMEN.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SPECIMEN 
     */ 
    public int getSPECIMENReps() {  
        return getReps("SPECIMEN");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SPECIMEN.
     * <p>
     * <p>
     * Note that unlike {@link #getSPECIMEN()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<OPR_O38_SPECIMEN> getSPECIMENAll() throws HL7Exception {
    	return getAllAsList("SPECIMEN", OPR_O38_SPECIMEN.class);
    } 

    /**
     * Inserts a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSPECIMEN(OPR_O38_SPECIMEN structure, int rep) throws HL7Exception { 
       super.insertRepetition("SPECIMEN", structure, rep);
    }


    /**
     * Inserts a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPR_O38_SPECIMEN insertSPECIMEN(int rep) throws HL7Exception { 
       return (OPR_O38_SPECIMEN)super.insertRepetition("SPECIMEN", rep);
    }


    /**
     * Removes a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPR_O38_SPECIMEN removeSPECIMEN(int rep) throws HL7Exception { 
       return (OPR_O38_SPECIMEN)super.removeRepetition("SPECIMEN", rep);
    }



}

