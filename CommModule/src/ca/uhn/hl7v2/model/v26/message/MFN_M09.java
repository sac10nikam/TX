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


package ca.uhn.hl7v2.model.v26.message;

import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.segment.*;

import java.util.List;
import net.newel.android.Log;
import ca.uhn.hl7v2.util.Constants;


import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a MFN_M09 message structure (see chapter 8.8.4). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: MFI (Master File Identification) <b> </b></li>
                 * <li>5: MFN_M09_MF_TEST_CATEGORICAL (a Group object) <b> repeating</b></li>
 * </ul>
 */
public class MFN_M09 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new MFN_M09 message with DefaultModelClassFactory. 
     */ 
    public MFN_M09() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new MFN_M09 message with custom ModelClassFactory.
     */
    public MFN_M09(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(MFI.class, true, false);
                          this.add(MFN_M09_MF_TEST_CATEGORICAL.class, true, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating MFN_M09 - this is probably a bug in the source code generator.", e);
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
     * MSH (Message Header) - creates it if necessary
     */
    public MSH getMSH() { 
       return getTyped("MSH", MSH.class);
    }




    /**
     * Returns
     * the first repetition of 
     * SFT (Software Segment) - creates it if necessary
     */
    public SFT getSFT() { 
       return getTyped("SFT", SFT.class);
    }


    /**
     * Returns a specific repetition of
     * SFT (Software Segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SFT getSFT(int rep) { 
       return getTyped("SFT", rep, SFT.class);
    }

    /** 
     * Returns the number of existing repetitions of SFT 
     */ 
    public int getSFTReps() { 
    	return getReps("SFT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SFT.
     * <p>
     * <p>
     * Note that unlike {@link #getSFT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<SFT> getSFTAll() throws HL7Exception {
    	return getAllAsList("SFT", SFT.class);
    } 

    /**
     * Inserts a specific repetition of SFT (Software Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSFT(SFT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "SFT", structure, rep);
    }


    /**
     * Inserts a specific repetition of SFT (Software Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SFT insertSFT(int rep) throws HL7Exception { 
       return (SFT)super.insertRepetition("SFT", rep);
    }


    /**
     * Removes a specific repetition of SFT (Software Segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SFT removeSFT(int rep) throws HL7Exception { 
       return (SFT)super.removeRepetition("SFT", rep);
    }



    /**
     * Returns
     * UAC (User Authentication Credential Segment) - creates it if necessary
     */
    public UAC getUAC() { 
       return getTyped("UAC", UAC.class);
    }




    /**
     * Returns
     * MFI (Master File Identification) - creates it if necessary
     */
    public MFI getMFI() { 
       return getTyped("MFI", MFI.class);
    }




    /**
     * Returns
     * the first repetition of 
     * MF_TEST_CATEGORICAL (a Group object) - creates it if necessary
     */
    public MFN_M09_MF_TEST_CATEGORICAL getMF_TEST_CATEGORICAL() { 
       return getTyped("MF_TEST_CATEGORICAL", MFN_M09_MF_TEST_CATEGORICAL.class);
    }


    /**
     * Returns a specific repetition of
     * MF_TEST_CATEGORICAL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M09_MF_TEST_CATEGORICAL getMF_TEST_CATEGORICAL(int rep) { 
       return getTyped("MF_TEST_CATEGORICAL", rep, MFN_M09_MF_TEST_CATEGORICAL.class);
    }

    /** 
     * Returns the number of existing repetitions of MF_TEST_CATEGORICAL 
     */ 
    public int getMF_TEST_CATEGORICALReps() { 
    	return getReps("MF_TEST_CATEGORICAL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MF_TEST_CATEGORICAL.
     * <p>
     * <p>
     * Note that unlike {@link #getMF_TEST_CATEGORICAL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<MFN_M09_MF_TEST_CATEGORICAL> getMF_TEST_CATEGORICALAll() throws HL7Exception {
    	return getAllAsList("MF_TEST_CATEGORICAL", MFN_M09_MF_TEST_CATEGORICAL.class);
    } 

    /**
     * Inserts a specific repetition of MF_TEST_CATEGORICAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMF_TEST_CATEGORICAL(MFN_M09_MF_TEST_CATEGORICAL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "MF_TEST_CATEGORICAL", structure, rep);
    }


    /**
     * Inserts a specific repetition of MF_TEST_CATEGORICAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M09_MF_TEST_CATEGORICAL insertMF_TEST_CATEGORICAL(int rep) throws HL7Exception { 
       return (MFN_M09_MF_TEST_CATEGORICAL)super.insertRepetition("MF_TEST_CATEGORICAL", rep);
    }


    /**
     * Removes a specific repetition of MF_TEST_CATEGORICAL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M09_MF_TEST_CATEGORICAL removeMF_TEST_CATEGORICAL(int rep) throws HL7Exception { 
       return (MFN_M09_MF_TEST_CATEGORICAL)super.removeRepetition("MF_TEST_CATEGORICAL", rep);
    }



}

