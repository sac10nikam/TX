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
 * <p>Represents a RRI_I12 message structure (see chapter 11.5.1). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: MSA (Message Acknowledgment) <b>optional </b></li>
                 * <li>5: RF1 (Referral Information) <b>optional </b></li>
                 * <li>6: RRI_I12_AUTHORIZATION_CONTACT (a Group object) <b>optional </b></li>
                 * <li>7: RRI_I12_PROVIDER_CONTACT (a Group object) <b> repeating</b></li>
                 * <li>8: PID (Patient Identification) <b> </b></li>
                 * <li>9: ACC (Accident) <b>optional </b></li>
                 * <li>10: DG1 (Diagnosis) <b>optional repeating</b></li>
                 * <li>11: DRG (Diagnosis Related Group) <b>optional repeating</b></li>
                 * <li>12: AL1 (Patient Allergy Information) <b>optional repeating</b></li>
                 * <li>13: RRI_I12_PROCEDURE (a Group object) <b>optional repeating</b></li>
                 * <li>14: RRI_I12_OBSERVATION (a Group object) <b>optional repeating</b></li>
                 * <li>15: RRI_I12_PATIENT_VISIT (a Group object) <b>optional </b></li>
                 * <li>16: NTE (Notes and Comments) <b>optional repeating</b></li>
 * </ul>
 */
public class RRI_I12 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new RRI_I12 message with DefaultModelClassFactory. 
     */ 
    public RRI_I12() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RRI_I12 message with custom ModelClassFactory.
     */
    public RRI_I12(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(MSA.class, false, false);
                          this.add(RF1.class, false, false);
                          this.add(RRI_I12_AUTHORIZATION_CONTACT.class, false, false);
                          this.add(RRI_I12_PROVIDER_CONTACT.class, true, true);
                          this.add(PID.class, true, false);
                          this.add(ACC.class, false, false);
                          this.add(DG1.class, false, true);
                          this.add(DRG.class, false, true);
                          this.add(AL1.class, false, true);
                          this.add(RRI_I12_PROCEDURE.class, false, true);
                          this.add(RRI_I12_OBSERVATION.class, false, true);
                          this.add(RRI_I12_PATIENT_VISIT.class, false, false);
                          this.add(NTE.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating RRI_I12 - this is probably a bug in the source code generator.", e);
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
     * MSA (Message Acknowledgment) - creates it if necessary
     */
    public MSA getMSA() { 
       return getTyped("MSA", MSA.class);
    }




    /**
     * Returns
     * RF1 (Referral Information) - creates it if necessary
     */
    public RF1 getRF1() { 
       return getTyped("RF1", RF1.class);
    }




    /**
     * Returns
     * AUTHORIZATION_CONTACT (a Group object) - creates it if necessary
     */
    public RRI_I12_AUTHORIZATION_CONTACT getAUTHORIZATION_CONTACT() { 
       return getTyped("AUTHORIZATION_CONTACT", RRI_I12_AUTHORIZATION_CONTACT.class);
    }




    /**
     * Returns
     * the first repetition of 
     * PROVIDER_CONTACT (a Group object) - creates it if necessary
     */
    public RRI_I12_PROVIDER_CONTACT getPROVIDER_CONTACT() { 
       return getTyped("PROVIDER_CONTACT", RRI_I12_PROVIDER_CONTACT.class);
    }


    /**
     * Returns a specific repetition of
     * PROVIDER_CONTACT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRI_I12_PROVIDER_CONTACT getPROVIDER_CONTACT(int rep) { 
       return getTyped("PROVIDER_CONTACT", rep, RRI_I12_PROVIDER_CONTACT.class);
    }

    /** 
     * Returns the number of existing repetitions of PROVIDER_CONTACT 
     */ 
    public int getPROVIDER_CONTACTReps() { 
    	return getReps("PROVIDER_CONTACT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROVIDER_CONTACT.
     * <p>
     * <p>
     * Note that unlike {@link #getPROVIDER_CONTACT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<RRI_I12_PROVIDER_CONTACT> getPROVIDER_CONTACTAll() throws HL7Exception {
    	return getAllAsList("PROVIDER_CONTACT", RRI_I12_PROVIDER_CONTACT.class);
    } 

    /**
     * Inserts a specific repetition of PROVIDER_CONTACT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROVIDER_CONTACT(RRI_I12_PROVIDER_CONTACT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROVIDER_CONTACT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PROVIDER_CONTACT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRI_I12_PROVIDER_CONTACT insertPROVIDER_CONTACT(int rep) throws HL7Exception { 
       return (RRI_I12_PROVIDER_CONTACT)super.insertRepetition("PROVIDER_CONTACT", rep);
    }


    /**
     * Removes a specific repetition of PROVIDER_CONTACT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRI_I12_PROVIDER_CONTACT removePROVIDER_CONTACT(int rep) throws HL7Exception { 
       return (RRI_I12_PROVIDER_CONTACT)super.removeRepetition("PROVIDER_CONTACT", rep);
    }



    /**
     * Returns
     * PID (Patient Identification) - creates it if necessary
     */
    public PID getPID() { 
       return getTyped("PID", PID.class);
    }




    /**
     * Returns
     * ACC (Accident) - creates it if necessary
     */
    public ACC getACC() { 
       return getTyped("ACC", ACC.class);
    }




    /**
     * Returns
     * the first repetition of 
     * DG1 (Diagnosis) - creates it if necessary
     */
    public DG1 getDG1() { 
       return getTyped("DG1", DG1.class);
    }


    /**
     * Returns a specific repetition of
     * DG1 (Diagnosis) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DG1 getDG1(int rep) { 
       return getTyped("DG1", rep, DG1.class);
    }

    /** 
     * Returns the number of existing repetitions of DG1 
     */ 
    public int getDG1Reps() { 
    	return getReps("DG1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DG1.
     * <p>
     * <p>
     * Note that unlike {@link #getDG1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<DG1> getDG1All() throws HL7Exception {
    	return getAllAsList("DG1", DG1.class);
    } 

    /**
     * Inserts a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DG1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * Removes a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * DRG (Diagnosis Related Group) - creates it if necessary
     */
    public DRG getDRG() { 
       return getTyped("DRG", DRG.class);
    }


    /**
     * Returns a specific repetition of
     * DRG (Diagnosis Related Group) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DRG getDRG(int rep) { 
       return getTyped("DRG", rep, DRG.class);
    }

    /** 
     * Returns the number of existing repetitions of DRG 
     */ 
    public int getDRGReps() { 
    	return getReps("DRG");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DRG.
     * <p>
     * <p>
     * Note that unlike {@link #getDRG()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<DRG> getDRGAll() throws HL7Exception {
    	return getAllAsList("DRG", DRG.class);
    } 

    /**
     * Inserts a specific repetition of DRG (Diagnosis Related Group)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDRG(DRG structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DRG", structure, rep);
    }


    /**
     * Inserts a specific repetition of DRG (Diagnosis Related Group)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DRG insertDRG(int rep) throws HL7Exception { 
       return (DRG)super.insertRepetition("DRG", rep);
    }


    /**
     * Removes a specific repetition of DRG (Diagnosis Related Group)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DRG removeDRG(int rep) throws HL7Exception { 
       return (DRG)super.removeRepetition("DRG", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AL1 (Patient Allergy Information) - creates it if necessary
     */
    public AL1 getAL1() { 
       return getTyped("AL1", AL1.class);
    }


    /**
     * Returns a specific repetition of
     * AL1 (Patient Allergy Information) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AL1 getAL1(int rep) { 
       return getTyped("AL1", rep, AL1.class);
    }

    /** 
     * Returns the number of existing repetitions of AL1 
     */ 
    public int getAL1Reps() { 
    	return getReps("AL1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AL1.
     * <p>
     * <p>
     * Note that unlike {@link #getAL1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<AL1> getAL1All() throws HL7Exception {
    	return getAllAsList("AL1", AL1.class);
    } 

    /**
     * Inserts a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "AL1", structure, rep);
    }


    /**
     * Inserts a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * Removes a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PROCEDURE (a Group object) - creates it if necessary
     */
    public RRI_I12_PROCEDURE getPROCEDURE() { 
       return getTyped("PROCEDURE", RRI_I12_PROCEDURE.class);
    }


    /**
     * Returns a specific repetition of
     * PROCEDURE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRI_I12_PROCEDURE getPROCEDURE(int rep) { 
       return getTyped("PROCEDURE", rep, RRI_I12_PROCEDURE.class);
    }

    /** 
     * Returns the number of existing repetitions of PROCEDURE 
     */ 
    public int getPROCEDUREReps() { 
    	return getReps("PROCEDURE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROCEDURE.
     * <p>
     * <p>
     * Note that unlike {@link #getPROCEDURE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<RRI_I12_PROCEDURE> getPROCEDUREAll() throws HL7Exception {
    	return getAllAsList("PROCEDURE", RRI_I12_PROCEDURE.class);
    } 

    /**
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROCEDURE(RRI_I12_PROCEDURE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROCEDURE", structure, rep);
    }


    /**
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRI_I12_PROCEDURE insertPROCEDURE(int rep) throws HL7Exception { 
       return (RRI_I12_PROCEDURE)super.insertRepetition("PROCEDURE", rep);
    }


    /**
     * Removes a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRI_I12_PROCEDURE removePROCEDURE(int rep) throws HL7Exception { 
       return (RRI_I12_PROCEDURE)super.removeRepetition("PROCEDURE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     */
    public RRI_I12_OBSERVATION getOBSERVATION() { 
       return getTyped("OBSERVATION", RRI_I12_OBSERVATION.class);
    }


    /**
     * Returns a specific repetition of
     * OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRI_I12_OBSERVATION getOBSERVATION(int rep) { 
       return getTyped("OBSERVATION", rep, RRI_I12_OBSERVATION.class);
    }

    /** 
     * Returns the number of existing repetitions of OBSERVATION 
     */ 
    public int getOBSERVATIONReps() { 
    	return getReps("OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getOBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<RRI_I12_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", RRI_I12_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(RRI_I12_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRI_I12_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (RRI_I12_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRI_I12_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (RRI_I12_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
    }



    /**
     * Returns
     * PATIENT_VISIT (a Group object) - creates it if necessary
     */
    public RRI_I12_PATIENT_VISIT getPATIENT_VISIT() { 
       return getTyped("PATIENT_VISIT", RRI_I12_PATIENT_VISIT.class);
    }




    /**
     * Returns
     * the first repetition of 
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       return getTyped("NTE", NTE.class);
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
       return getTyped("NTE", rep, NTE.class);
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
       super.insertRepetition( "NTE", structure, rep);
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



}

