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

import ca.uhn.hl7v2.model.v26.segment.*;

import java.util.List;
import net.newel.android.Log;
import ca.uhn.hl7v2.util.Constants;


import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a PMU_B01 message structure (see chapter 15.3.1). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: EVN (Event Type) <b> </b></li>
                 * <li>5: STF (Staff Identification) <b> </b></li>
                 * <li>6: PRA (Practitioner Detail) <b>optional repeating</b></li>
                 * <li>7: ORG (Practitioner Organization Unit) <b>optional repeating</b></li>
                 * <li>8: AFF (Professional Affiliation) <b>optional repeating</b></li>
                 * <li>9: LAN (Language Detail) <b>optional repeating</b></li>
                 * <li>10: EDU (Educational Detail) <b>optional repeating</b></li>
                 * <li>11: CER (Certificate Detail) <b>optional repeating</b></li>
 * </ul>
 */
public class PMU_B01 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new PMU_B01 message with DefaultModelClassFactory. 
     */ 
    public PMU_B01() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new PMU_B01 message with custom ModelClassFactory.
     */
    public PMU_B01(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(EVN.class, true, false);
                          this.add(STF.class, true, false);
                          this.add(PRA.class, false, true);
                          this.add(ORG.class, false, true);
                          this.add(AFF.class, false, true);
                          this.add(LAN.class, false, true);
                          this.add(EDU.class, false, true);
                          this.add(CER.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating PMU_B01 - this is probably a bug in the source code generator.", e);
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
     * EVN (Event Type) - creates it if necessary
     */
    public EVN getEVN() { 
       return getTyped("EVN", EVN.class);
    }




    /**
     * Returns
     * STF (Staff Identification) - creates it if necessary
     */
    public STF getSTF() { 
       return getTyped("STF", STF.class);
    }




    /**
     * Returns
     * the first repetition of 
     * PRA (Practitioner Detail) - creates it if necessary
     */
    public PRA getPRA() { 
       return getTyped("PRA", PRA.class);
    }


    /**
     * Returns a specific repetition of
     * PRA (Practitioner Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRA getPRA(int rep) { 
       return getTyped("PRA", rep, PRA.class);
    }

    /** 
     * Returns the number of existing repetitions of PRA 
     */ 
    public int getPRAReps() { 
    	return getReps("PRA");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRA.
     * <p>
     * <p>
     * Note that unlike {@link #getPRA()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<PRA> getPRAAll() throws HL7Exception {
    	return getAllAsList("PRA", PRA.class);
    } 

    /**
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRA(PRA structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PRA", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRA insertPRA(int rep) throws HL7Exception { 
       return (PRA)super.insertRepetition("PRA", rep);
    }


    /**
     * Removes a specific repetition of PRA (Practitioner Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRA removePRA(int rep) throws HL7Exception { 
       return (PRA)super.removeRepetition("PRA", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORG (Practitioner Organization Unit) - creates it if necessary
     */
    public ORG getORG() { 
       return getTyped("ORG", ORG.class);
    }


    /**
     * Returns a specific repetition of
     * ORG (Practitioner Organization Unit) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORG getORG(int rep) { 
       return getTyped("ORG", rep, ORG.class);
    }

    /** 
     * Returns the number of existing repetitions of ORG 
     */ 
    public int getORGReps() { 
    	return getReps("ORG");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORG.
     * <p>
     * <p>
     * Note that unlike {@link #getORG()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<ORG> getORGAll() throws HL7Exception {
    	return getAllAsList("ORG", ORG.class);
    } 

    /**
     * Inserts a specific repetition of ORG (Practitioner Organization Unit)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORG(ORG structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ORG", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORG (Practitioner Organization Unit)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORG insertORG(int rep) throws HL7Exception { 
       return (ORG)super.insertRepetition("ORG", rep);
    }


    /**
     * Removes a specific repetition of ORG (Practitioner Organization Unit)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORG removeORG(int rep) throws HL7Exception { 
       return (ORG)super.removeRepetition("ORG", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AFF (Professional Affiliation) - creates it if necessary
     */
    public AFF getAFF() { 
       return getTyped("AFF", AFF.class);
    }


    /**
     * Returns a specific repetition of
     * AFF (Professional Affiliation) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AFF getAFF(int rep) { 
       return getTyped("AFF", rep, AFF.class);
    }

    /** 
     * Returns the number of existing repetitions of AFF 
     */ 
    public int getAFFReps() { 
    	return getReps("AFF");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AFF.
     * <p>
     * <p>
     * Note that unlike {@link #getAFF()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<AFF> getAFFAll() throws HL7Exception {
    	return getAllAsList("AFF", AFF.class);
    } 

    /**
     * Inserts a specific repetition of AFF (Professional Affiliation)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAFF(AFF structure, int rep) throws HL7Exception { 
       super.insertRepetition( "AFF", structure, rep);
    }


    /**
     * Inserts a specific repetition of AFF (Professional Affiliation)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AFF insertAFF(int rep) throws HL7Exception { 
       return (AFF)super.insertRepetition("AFF", rep);
    }


    /**
     * Removes a specific repetition of AFF (Professional Affiliation)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AFF removeAFF(int rep) throws HL7Exception { 
       return (AFF)super.removeRepetition("AFF", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LAN (Language Detail) - creates it if necessary
     */
    public LAN getLAN() { 
       return getTyped("LAN", LAN.class);
    }


    /**
     * Returns a specific repetition of
     * LAN (Language Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LAN getLAN(int rep) { 
       return getTyped("LAN", rep, LAN.class);
    }

    /** 
     * Returns the number of existing repetitions of LAN 
     */ 
    public int getLANReps() { 
    	return getReps("LAN");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LAN.
     * <p>
     * <p>
     * Note that unlike {@link #getLAN()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<LAN> getLANAll() throws HL7Exception {
    	return getAllAsList("LAN", LAN.class);
    } 

    /**
     * Inserts a specific repetition of LAN (Language Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLAN(LAN structure, int rep) throws HL7Exception { 
       super.insertRepetition( "LAN", structure, rep);
    }


    /**
     * Inserts a specific repetition of LAN (Language Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LAN insertLAN(int rep) throws HL7Exception { 
       return (LAN)super.insertRepetition("LAN", rep);
    }


    /**
     * Removes a specific repetition of LAN (Language Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LAN removeLAN(int rep) throws HL7Exception { 
       return (LAN)super.removeRepetition("LAN", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * EDU (Educational Detail) - creates it if necessary
     */
    public EDU getEDU() { 
       return getTyped("EDU", EDU.class);
    }


    /**
     * Returns a specific repetition of
     * EDU (Educational Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EDU getEDU(int rep) { 
       return getTyped("EDU", rep, EDU.class);
    }

    /** 
     * Returns the number of existing repetitions of EDU 
     */ 
    public int getEDUReps() { 
    	return getReps("EDU");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of EDU.
     * <p>
     * <p>
     * Note that unlike {@link #getEDU()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<EDU> getEDUAll() throws HL7Exception {
    	return getAllAsList("EDU", EDU.class);
    } 

    /**
     * Inserts a specific repetition of EDU (Educational Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertEDU(EDU structure, int rep) throws HL7Exception { 
       super.insertRepetition( "EDU", structure, rep);
    }


    /**
     * Inserts a specific repetition of EDU (Educational Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EDU insertEDU(int rep) throws HL7Exception { 
       return (EDU)super.insertRepetition("EDU", rep);
    }


    /**
     * Removes a specific repetition of EDU (Educational Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EDU removeEDU(int rep) throws HL7Exception { 
       return (EDU)super.removeRepetition("EDU", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CER (Certificate Detail) - creates it if necessary
     */
    public CER getCER() { 
       return getTyped("CER", CER.class);
    }


    /**
     * Returns a specific repetition of
     * CER (Certificate Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CER getCER(int rep) { 
       return getTyped("CER", rep, CER.class);
    }

    /** 
     * Returns the number of existing repetitions of CER 
     */ 
    public int getCERReps() { 
    	return getReps("CER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CER.
     * <p>
     * <p>
     * Note that unlike {@link #getCER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<CER> getCERAll() throws HL7Exception {
    	return getAllAsList("CER", CER.class);
    } 

    /**
     * Inserts a specific repetition of CER (Certificate Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCER(CER structure, int rep) throws HL7Exception { 
       super.insertRepetition( "CER", structure, rep);
    }


    /**
     * Inserts a specific repetition of CER (Certificate Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CER insertCER(int rep) throws HL7Exception { 
       return (CER)super.insertRepetition("CER", rep);
    }


    /**
     * Removes a specific repetition of CER (Certificate Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CER removeCER(int rep) throws HL7Exception { 
       return (CER)super.removeRepetition("CER", rep);
    }



}

