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
 * <p>Represents a OPU_R25 message structure (see chapter 7.3.10). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: NTE (Notes and Comments) <b>optional </b></li>
                 * <li>5: PV1 (Patient Visit) <b> </b></li>
                 * <li>6: PV2 (Patient Visit - Additional Information) <b>optional </b></li>
                 * <li>7: OBX (Observation/Result) <b>optional repeating</b></li>
                 * <li>8: NTE (Notes and Comments) <b>optional repeating</b></li>
                 * <li>9: ROL (Role) <b> repeating</b></li>
                 * <li>10: OPU_R25_ACCESSION_DETAIL (a Group object) <b> repeating</b></li>
 * </ul>
 */
public class OPU_R25 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new OPU_R25 message with DefaultModelClassFactory. 
     */ 
    public OPU_R25() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new OPU_R25 message with custom ModelClassFactory.
     */
    public OPU_R25(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(NTE.class, false, false);
                          this.add(PV1.class, true, false);
                          this.add(PV2.class, false, false);
                          this.add(OBX.class, false, true);
                          this.add(NTE.class, false, true);
                          this.add(ROL.class, true, true);
                          this.add(OPU_R25_ACCESSION_DETAIL.class, true, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating OPU_R25 - this is probably a bug in the source code generator.", e);
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
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       return getTyped("NTE", NTE.class);
    }




    /**
     * Returns
     * PV1 (Patient Visit) - creates it if necessary
     */
    public PV1 getPV1() { 
       return getTyped("PV1", PV1.class);
    }




    /**
     * Returns
     * PV2 (Patient Visit - Additional Information) - creates it if necessary
     */
    public PV2 getPV2() { 
       return getTyped("PV2", PV2.class);
    }




    /**
     * Returns
     * the first repetition of 
     * OBX (Observation/Result) - creates it if necessary
     */
    public OBX getOBX() { 
       return getTyped("OBX", OBX.class);
    }


    /**
     * Returns a specific repetition of
     * OBX (Observation/Result) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX(int rep) { 
       return getTyped("OBX", rep, OBX.class);
    }

    /** 
     * Returns the number of existing repetitions of OBX 
     */ 
    public int getOBXReps() { 
    	return getReps("OBX");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<OBX> getOBXAll() throws HL7Exception {
    	return getAllAsList("OBX", OBX.class);
    } 

    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * NTE2 (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE2() { 
       return getTyped("NTE2", NTE.class);
    }


    /**
     * Returns a specific repetition of
     * NTE2 (Notes and Comments) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE2(int rep) { 
       return getTyped("NTE2", rep, NTE.class);
    }

    /** 
     * Returns the number of existing repetitions of NTE2 
     */ 
    public int getNTE2Reps() { 
    	return getReps("NTE2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NTE2.
     * <p>
     * <p>
     * Note that unlike {@link #getNTE2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<NTE> getNTE2All() throws HL7Exception {
    	return getAllAsList("NTE2", NTE.class);
    } 

    /**
     * Inserts a specific repetition of NTE2 (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE2(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NTE2", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE2 (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE2(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE2", rep);
    }


    /**
     * Removes a specific repetition of NTE2 (Notes and Comments)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE2(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE2", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROL (Role) - creates it if necessary
     */
    public ROL getROL() { 
       return getTyped("ROL", ROL.class);
    }


    /**
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       return getTyped("ROL", rep, ROL.class);
    }

    /** 
     * Returns the number of existing repetitions of ROL 
     */ 
    public int getROLReps() { 
    	return getReps("ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ROL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * Removes a specific repetition of ROL (Role)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ACCESSION_DETAIL (a Group object) - creates it if necessary
     */
    public OPU_R25_ACCESSION_DETAIL getACCESSION_DETAIL() { 
       return getTyped("ACCESSION_DETAIL", OPU_R25_ACCESSION_DETAIL.class);
    }


    /**
     * Returns a specific repetition of
     * ACCESSION_DETAIL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPU_R25_ACCESSION_DETAIL getACCESSION_DETAIL(int rep) { 
       return getTyped("ACCESSION_DETAIL", rep, OPU_R25_ACCESSION_DETAIL.class);
    }

    /** 
     * Returns the number of existing repetitions of ACCESSION_DETAIL 
     */ 
    public int getACCESSION_DETAILReps() { 
    	return getReps("ACCESSION_DETAIL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ACCESSION_DETAIL.
     * <p>
     * <p>
     * Note that unlike {@link #getACCESSION_DETAIL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<OPU_R25_ACCESSION_DETAIL> getACCESSION_DETAILAll() throws HL7Exception {
    	return getAllAsList("ACCESSION_DETAIL", OPU_R25_ACCESSION_DETAIL.class);
    } 

    /**
     * Inserts a specific repetition of ACCESSION_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertACCESSION_DETAIL(OPU_R25_ACCESSION_DETAIL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ACCESSION_DETAIL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ACCESSION_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPU_R25_ACCESSION_DETAIL insertACCESSION_DETAIL(int rep) throws HL7Exception { 
       return (OPU_R25_ACCESSION_DETAIL)super.insertRepetition("ACCESSION_DETAIL", rep);
    }


    /**
     * Removes a specific repetition of ACCESSION_DETAIL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPU_R25_ACCESSION_DETAIL removeACCESSION_DETAIL(int rep) throws HL7Exception { 
       return (OPU_R25_ACCESSION_DETAIL)super.removeRepetition("ACCESSION_DETAIL", rep);
    }



}

