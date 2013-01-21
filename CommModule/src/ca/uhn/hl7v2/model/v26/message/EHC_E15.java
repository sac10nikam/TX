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
 * <p>Represents a EHC_E15 message structure (see chapter 16.3.9). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional repeating</b></li>
                 * <li>4: PMT (Payment Information) <b> </b></li>
                 * <li>5: PYE (Payee Information) <b> </b></li>
                 * <li>6: EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO (a Group object) <b>optional repeating</b></li>
                 * <li>7: EHC_E15_ADJUSTMENT_PAYEE (a Group object) <b>optional repeating</b></li>
 * </ul>
 */
public class EHC_E15 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new EHC_E15 message with DefaultModelClassFactory. 
     */ 
    public EHC_E15() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new EHC_E15 message with custom ModelClassFactory.
     */
    public EHC_E15(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, true);
                          this.add(PMT.class, true, false);
                          this.add(PYE.class, true, false);
                          this.add(EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO.class, false, true);
                          this.add(EHC_E15_ADJUSTMENT_PAYEE.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating EHC_E15 - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * UAC (User Authentication Credential Segment) - creates it if necessary
     */
    public UAC getUAC() { 
       return getTyped("UAC", UAC.class);
    }


    /**
     * Returns a specific repetition of
     * UAC (User Authentication Credential Segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public UAC getUAC(int rep) { 
       return getTyped("UAC", rep, UAC.class);
    }

    /** 
     * Returns the number of existing repetitions of UAC 
     */ 
    public int getUACReps() { 
    	return getReps("UAC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of UAC.
     * <p>
     * <p>
     * Note that unlike {@link #getUAC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<UAC> getUACAll() throws HL7Exception {
    	return getAllAsList("UAC", UAC.class);
    } 

    /**
     * Inserts a specific repetition of UAC (User Authentication Credential Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertUAC(UAC structure, int rep) throws HL7Exception { 
       super.insertRepetition( "UAC", structure, rep);
    }


    /**
     * Inserts a specific repetition of UAC (User Authentication Credential Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public UAC insertUAC(int rep) throws HL7Exception { 
       return (UAC)super.insertRepetition("UAC", rep);
    }


    /**
     * Removes a specific repetition of UAC (User Authentication Credential Segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public UAC removeUAC(int rep) throws HL7Exception { 
       return (UAC)super.removeRepetition("UAC", rep);
    }



    /**
     * Returns
     * PMT (Payment Information) - creates it if necessary
     */
    public PMT getPMT() { 
       return getTyped("PMT", PMT.class);
    }




    /**
     * Returns
     * PYE (Payee Information) - creates it if necessary
     */
    public PYE getPYE() { 
       return getTyped("PYE", PYE.class);
    }




    /**
     * Returns
     * the first repetition of 
     * PAYMENT_REMITTANCE_DETAIL_INFO (a Group object) - creates it if necessary
     */
    public EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO getPAYMENT_REMITTANCE_DETAIL_INFO() { 
       return getTyped("PAYMENT_REMITTANCE_DETAIL_INFO", EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO.class);
    }


    /**
     * Returns a specific repetition of
     * PAYMENT_REMITTANCE_DETAIL_INFO (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO getPAYMENT_REMITTANCE_DETAIL_INFO(int rep) { 
       return getTyped("PAYMENT_REMITTANCE_DETAIL_INFO", rep, EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO.class);
    }

    /** 
     * Returns the number of existing repetitions of PAYMENT_REMITTANCE_DETAIL_INFO 
     */ 
    public int getPAYMENT_REMITTANCE_DETAIL_INFOReps() { 
    	return getReps("PAYMENT_REMITTANCE_DETAIL_INFO");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PAYMENT_REMITTANCE_DETAIL_INFO.
     * <p>
     * <p>
     * Note that unlike {@link #getPAYMENT_REMITTANCE_DETAIL_INFO()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO> getPAYMENT_REMITTANCE_DETAIL_INFOAll() throws HL7Exception {
    	return getAllAsList("PAYMENT_REMITTANCE_DETAIL_INFO", EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO.class);
    } 

    /**
     * Inserts a specific repetition of PAYMENT_REMITTANCE_DETAIL_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPAYMENT_REMITTANCE_DETAIL_INFO(EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PAYMENT_REMITTANCE_DETAIL_INFO", structure, rep);
    }


    /**
     * Inserts a specific repetition of PAYMENT_REMITTANCE_DETAIL_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO insertPAYMENT_REMITTANCE_DETAIL_INFO(int rep) throws HL7Exception { 
       return (EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO)super.insertRepetition("PAYMENT_REMITTANCE_DETAIL_INFO", rep);
    }


    /**
     * Removes a specific repetition of PAYMENT_REMITTANCE_DETAIL_INFO (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO removePAYMENT_REMITTANCE_DETAIL_INFO(int rep) throws HL7Exception { 
       return (EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO)super.removeRepetition("PAYMENT_REMITTANCE_DETAIL_INFO", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ADJUSTMENT_PAYEE (a Group object) - creates it if necessary
     */
    public EHC_E15_ADJUSTMENT_PAYEE getADJUSTMENT_PAYEE() { 
       return getTyped("ADJUSTMENT_PAYEE", EHC_E15_ADJUSTMENT_PAYEE.class);
    }


    /**
     * Returns a specific repetition of
     * ADJUSTMENT_PAYEE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E15_ADJUSTMENT_PAYEE getADJUSTMENT_PAYEE(int rep) { 
       return getTyped("ADJUSTMENT_PAYEE", rep, EHC_E15_ADJUSTMENT_PAYEE.class);
    }

    /** 
     * Returns the number of existing repetitions of ADJUSTMENT_PAYEE 
     */ 
    public int getADJUSTMENT_PAYEEReps() { 
    	return getReps("ADJUSTMENT_PAYEE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ADJUSTMENT_PAYEE.
     * <p>
     * <p>
     * Note that unlike {@link #getADJUSTMENT_PAYEE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<EHC_E15_ADJUSTMENT_PAYEE> getADJUSTMENT_PAYEEAll() throws HL7Exception {
    	return getAllAsList("ADJUSTMENT_PAYEE", EHC_E15_ADJUSTMENT_PAYEE.class);
    } 

    /**
     * Inserts a specific repetition of ADJUSTMENT_PAYEE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertADJUSTMENT_PAYEE(EHC_E15_ADJUSTMENT_PAYEE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ADJUSTMENT_PAYEE", structure, rep);
    }


    /**
     * Inserts a specific repetition of ADJUSTMENT_PAYEE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E15_ADJUSTMENT_PAYEE insertADJUSTMENT_PAYEE(int rep) throws HL7Exception { 
       return (EHC_E15_ADJUSTMENT_PAYEE)super.insertRepetition("ADJUSTMENT_PAYEE", rep);
    }


    /**
     * Removes a specific repetition of ADJUSTMENT_PAYEE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E15_ADJUSTMENT_PAYEE removeADJUSTMENT_PAYEE(int rep) throws HL7Exception { 
       return (EHC_E15_ADJUSTMENT_PAYEE)super.removeRepetition("ADJUSTMENT_PAYEE", rep);
    }



}

