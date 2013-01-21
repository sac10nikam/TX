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
 * <p>Represents a DFT_P03 message structure (see chapter 6.4.3). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: EVN (Event Type) <b> </b></li>
                 * <li>5: PID (Patient Identification) <b> </b></li>
                 * <li>6: PD1 (Patient Additional Demographic) <b>optional </b></li>
                 * <li>7: ROL (Role) <b>optional repeating</b></li>
                 * <li>8: PV1 (Patient Visit) <b>optional </b></li>
                 * <li>9: PV2 (Patient Visit - Additional Information) <b>optional </b></li>
                 * <li>10: ROL (Role) <b>optional repeating</b></li>
                 * <li>11: DB1 (Disability) <b>optional repeating</b></li>
                 * <li>12: DFT_P03_COMMON_ORDER (a Group object) <b>optional repeating</b></li>
                 * <li>13: DFT_P03_FINANCIAL (a Group object) <b> repeating</b></li>
                 * <li>14: DG1 (Diagnosis) <b>optional repeating</b></li>
                 * <li>15: DRG (Diagnosis Related Group) <b>optional </b></li>
                 * <li>16: GT1 (Guarantor) <b>optional repeating</b></li>
                 * <li>17: DFT_P03_INSURANCE (a Group object) <b>optional repeating</b></li>
                 * <li>18: ACC (Accident) <b>optional </b></li>
 * </ul>
 */
public class DFT_P03 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new DFT_P03 message with DefaultModelClassFactory. 
     */ 
    public DFT_P03() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new DFT_P03 message with custom ModelClassFactory.
     */
    public DFT_P03(ModelClassFactory factory) {
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
                          this.add(ROL.class, false, true);
                          this.add(PV1.class, false, false);
                          this.add(PV2.class, false, false);
                          this.add(ROL.class, false, true);
                          this.add(DB1.class, false, true);
                          this.add(DFT_P03_COMMON_ORDER.class, false, true);
                          this.add(DFT_P03_FINANCIAL.class, true, true);
                          this.add(DG1.class, false, true);
                          this.add(DRG.class, false, false);
                          this.add(GT1.class, false, true);
                          this.add(DFT_P03_INSURANCE.class, false, true);
                          this.add(ACC.class, false, false);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating DFT_P03 - this is probably a bug in the source code generator.", e);
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
     * ROL2 (Role) - creates it if necessary
     */
    public ROL getROL2() { 
       return getTyped("ROL2", ROL.class);
    }


    /**
     * Returns a specific repetition of
     * ROL2 (Role) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL2(int rep) { 
       return getTyped("ROL2", rep, ROL.class);
    }

    /** 
     * Returns the number of existing repetitions of ROL2 
     */ 
    public int getROL2Reps() { 
    	return getReps("ROL2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL2.
     * <p>
     * <p>
     * Note that unlike {@link #getROL2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<ROL> getROL2All() throws HL7Exception {
    	return getAllAsList("ROL2", ROL.class);
    } 

    /**
     * Inserts a specific repetition of ROL2 (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL2(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ROL2", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROL2 (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL2(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL2", rep);
    }


    /**
     * Removes a specific repetition of ROL2 (Role)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL2(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL2", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * DB1 (Disability) - creates it if necessary
     */
    public DB1 getDB1() { 
       return getTyped("DB1", DB1.class);
    }


    /**
     * Returns a specific repetition of
     * DB1 (Disability) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DB1 getDB1(int rep) { 
       return getTyped("DB1", rep, DB1.class);
    }

    /** 
     * Returns the number of existing repetitions of DB1 
     */ 
    public int getDB1Reps() { 
    	return getReps("DB1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DB1.
     * <p>
     * <p>
     * Note that unlike {@link #getDB1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<DB1> getDB1All() throws HL7Exception {
    	return getAllAsList("DB1", DB1.class);
    } 

    /**
     * Inserts a specific repetition of DB1 (Disability)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDB1(DB1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DB1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DB1 (Disability)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DB1 insertDB1(int rep) throws HL7Exception { 
       return (DB1)super.insertRepetition("DB1", rep);
    }


    /**
     * Removes a specific repetition of DB1 (Disability)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DB1 removeDB1(int rep) throws HL7Exception { 
       return (DB1)super.removeRepetition("DB1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * COMMON_ORDER (a Group object) - creates it if necessary
     */
    public DFT_P03_COMMON_ORDER getCOMMON_ORDER() { 
       return getTyped("COMMON_ORDER", DFT_P03_COMMON_ORDER.class);
    }


    /**
     * Returns a specific repetition of
     * COMMON_ORDER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P03_COMMON_ORDER getCOMMON_ORDER(int rep) { 
       return getTyped("COMMON_ORDER", rep, DFT_P03_COMMON_ORDER.class);
    }

    /** 
     * Returns the number of existing repetitions of COMMON_ORDER 
     */ 
    public int getCOMMON_ORDERReps() { 
    	return getReps("COMMON_ORDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of COMMON_ORDER.
     * <p>
     * <p>
     * Note that unlike {@link #getCOMMON_ORDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<DFT_P03_COMMON_ORDER> getCOMMON_ORDERAll() throws HL7Exception {
    	return getAllAsList("COMMON_ORDER", DFT_P03_COMMON_ORDER.class);
    } 

    /**
     * Inserts a specific repetition of COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCOMMON_ORDER(DFT_P03_COMMON_ORDER structure, int rep) throws HL7Exception { 
       super.insertRepetition( "COMMON_ORDER", structure, rep);
    }


    /**
     * Inserts a specific repetition of COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P03_COMMON_ORDER insertCOMMON_ORDER(int rep) throws HL7Exception { 
       return (DFT_P03_COMMON_ORDER)super.insertRepetition("COMMON_ORDER", rep);
    }


    /**
     * Removes a specific repetition of COMMON_ORDER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P03_COMMON_ORDER removeCOMMON_ORDER(int rep) throws HL7Exception { 
       return (DFT_P03_COMMON_ORDER)super.removeRepetition("COMMON_ORDER", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * FINANCIAL (a Group object) - creates it if necessary
     */
    public DFT_P03_FINANCIAL getFINANCIAL() { 
       return getTyped("FINANCIAL", DFT_P03_FINANCIAL.class);
    }


    /**
     * Returns a specific repetition of
     * FINANCIAL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P03_FINANCIAL getFINANCIAL(int rep) { 
       return getTyped("FINANCIAL", rep, DFT_P03_FINANCIAL.class);
    }

    /** 
     * Returns the number of existing repetitions of FINANCIAL 
     */ 
    public int getFINANCIALReps() { 
    	return getReps("FINANCIAL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FINANCIAL.
     * <p>
     * <p>
     * Note that unlike {@link #getFINANCIAL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<DFT_P03_FINANCIAL> getFINANCIALAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL", DFT_P03_FINANCIAL.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL(DFT_P03_FINANCIAL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "FINANCIAL", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P03_FINANCIAL insertFINANCIAL(int rep) throws HL7Exception { 
       return (DFT_P03_FINANCIAL)super.insertRepetition("FINANCIAL", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P03_FINANCIAL removeFINANCIAL(int rep) throws HL7Exception { 
       return (DFT_P03_FINANCIAL)super.removeRepetition("FINANCIAL", rep);
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
     * DRG (Diagnosis Related Group) - creates it if necessary
     */
    public DRG getDRG() { 
       return getTyped("DRG", DRG.class);
    }




    /**
     * Returns
     * the first repetition of 
     * GT1 (Guarantor) - creates it if necessary
     */
    public GT1 getGT1() { 
       return getTyped("GT1", GT1.class);
    }


    /**
     * Returns a specific repetition of
     * GT1 (Guarantor) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public GT1 getGT1(int rep) { 
       return getTyped("GT1", rep, GT1.class);
    }

    /** 
     * Returns the number of existing repetitions of GT1 
     */ 
    public int getGT1Reps() { 
    	return getReps("GT1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GT1.
     * <p>
     * <p>
     * Note that unlike {@link #getGT1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<GT1> getGT1All() throws HL7Exception {
    	return getAllAsList("GT1", GT1.class);
    } 

    /**
     * Inserts a specific repetition of GT1 (Guarantor)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGT1(GT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "GT1", structure, rep);
    }


    /**
     * Inserts a specific repetition of GT1 (Guarantor)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public GT1 insertGT1(int rep) throws HL7Exception { 
       return (GT1)super.insertRepetition("GT1", rep);
    }


    /**
     * Removes a specific repetition of GT1 (Guarantor)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public GT1 removeGT1(int rep) throws HL7Exception { 
       return (GT1)super.removeRepetition("GT1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * INSURANCE (a Group object) - creates it if necessary
     */
    public DFT_P03_INSURANCE getINSURANCE() { 
       return getTyped("INSURANCE", DFT_P03_INSURANCE.class);
    }


    /**
     * Returns a specific repetition of
     * INSURANCE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P03_INSURANCE getINSURANCE(int rep) { 
       return getTyped("INSURANCE", rep, DFT_P03_INSURANCE.class);
    }

    /** 
     * Returns the number of existing repetitions of INSURANCE 
     */ 
    public int getINSURANCEReps() { 
    	return getReps("INSURANCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of INSURANCE.
     * <p>
     * <p>
     * Note that unlike {@link #getINSURANCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<DFT_P03_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", DFT_P03_INSURANCE.class);
    } 

    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(DFT_P03_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "INSURANCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P03_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (DFT_P03_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * Removes a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P03_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (DFT_P03_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }



    /**
     * Returns
     * ACC (Accident) - creates it if necessary
     */
    public ACC getACC() { 
       return getTyped("ACC", ACC.class);
    }




}

