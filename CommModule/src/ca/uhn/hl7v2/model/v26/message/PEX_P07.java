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
 * <p>Represents a PEX_P07 message structure (see chapter 7.11.1). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: EVN (Event Type) <b> </b></li>
                 * <li>5: PID (Patient Identification) <b> </b></li>
                 * <li>6: PD1 (Patient Additional Demographic) <b>optional </b></li>
                 * <li>7: NTE (Notes and Comments) <b>optional repeating</b></li>
                 * <li>8: PEX_P07_VISIT (a Group object) <b>optional </b></li>
                 * <li>9: PEX_P07_EXPERIENCE (a Group object) <b> repeating</b></li>
 * </ul>
 */
public class PEX_P07 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new PEX_P07 message with DefaultModelClassFactory. 
     */ 
    public PEX_P07() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new PEX_P07 message with custom ModelClassFactory.
     */
    public PEX_P07(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(EVN.class, true, false);
                          this.add(PID.class, true, false);
                          this.add(PD1.class, false, false);
                          this.add(NTE.class, false, true);
                          this.add(PEX_P07_VISIT.class, false, false);
                          this.add(PEX_P07_EXPERIENCE.class, true, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating PEX_P07 - this is probably a bug in the source code generator.", e);
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
     * PID (Patient Identification) - creates it if necessary
     */
    public PID getPID() { 
       return getTyped("PID", PID.class);
    }




    /**
     * Returns
     * PD1 (Patient Additional Demographic) - creates it if necessary
     */
    public PD1 getPD1() { 
       return getTyped("PD1", PD1.class);
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



    /**
     * Returns
     * VISIT (a Group object) - creates it if necessary
     */
    public PEX_P07_VISIT getVISIT() { 
       return getTyped("VISIT", PEX_P07_VISIT.class);
    }




    /**
     * Returns
     * the first repetition of 
     * EXPERIENCE (a Group object) - creates it if necessary
     */
    public PEX_P07_EXPERIENCE getEXPERIENCE() { 
       return getTyped("EXPERIENCE", PEX_P07_EXPERIENCE.class);
    }


    /**
     * Returns a specific repetition of
     * EXPERIENCE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PEX_P07_EXPERIENCE getEXPERIENCE(int rep) { 
       return getTyped("EXPERIENCE", rep, PEX_P07_EXPERIENCE.class);
    }

    /** 
     * Returns the number of existing repetitions of EXPERIENCE 
     */ 
    public int getEXPERIENCEReps() { 
    	return getReps("EXPERIENCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of EXPERIENCE.
     * <p>
     * <p>
     * Note that unlike {@link #getEXPERIENCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<PEX_P07_EXPERIENCE> getEXPERIENCEAll() throws HL7Exception {
    	return getAllAsList("EXPERIENCE", PEX_P07_EXPERIENCE.class);
    } 

    /**
     * Inserts a specific repetition of EXPERIENCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertEXPERIENCE(PEX_P07_EXPERIENCE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "EXPERIENCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of EXPERIENCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PEX_P07_EXPERIENCE insertEXPERIENCE(int rep) throws HL7Exception { 
       return (PEX_P07_EXPERIENCE)super.insertRepetition("EXPERIENCE", rep);
    }


    /**
     * Removes a specific repetition of EXPERIENCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PEX_P07_EXPERIENCE removeEXPERIENCE(int rep) throws HL7Exception { 
       return (PEX_P07_EXPERIENCE)super.removeRepetition("EXPERIENCE", rep);
    }



}
