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
 * <p>Represents a RPR_I03 message structure (see chapter 11.3.3). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: MSA (Message Acknowledgment) <b> </b></li>
                 * <li>5: RPR_I03_PROVIDER (a Group object) <b> repeating</b></li>
                 * <li>6: PID (Patient Identification) <b>optional repeating</b></li>
                 * <li>7: NTE (Notes and Comments) <b>optional repeating</b></li>
 * </ul>
 */
public class RPR_I03 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new RPR_I03 message with DefaultModelClassFactory. 
     */ 
    public RPR_I03() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RPR_I03 message with custom ModelClassFactory.
     */
    public RPR_I03(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(MSA.class, true, false);
                          this.add(RPR_I03_PROVIDER.class, true, true);
                          this.add(PID.class, false, true);
                          this.add(NTE.class, false, true);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating RPR_I03 - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * PROVIDER (a Group object) - creates it if necessary
     */
    public RPR_I03_PROVIDER getPROVIDER() { 
       return getTyped("PROVIDER", RPR_I03_PROVIDER.class);
    }


    /**
     * Returns a specific repetition of
     * PROVIDER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RPR_I03_PROVIDER getPROVIDER(int rep) { 
       return getTyped("PROVIDER", rep, RPR_I03_PROVIDER.class);
    }

    /** 
     * Returns the number of existing repetitions of PROVIDER 
     */ 
    public int getPROVIDERReps() { 
    	return getReps("PROVIDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROVIDER.
     * <p>
     * <p>
     * Note that unlike {@link #getPROVIDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<RPR_I03_PROVIDER> getPROVIDERAll() throws HL7Exception {
    	return getAllAsList("PROVIDER", RPR_I03_PROVIDER.class);
    } 

    /**
     * Inserts a specific repetition of PROVIDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROVIDER(RPR_I03_PROVIDER structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROVIDER", structure, rep);
    }


    /**
     * Inserts a specific repetition of PROVIDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RPR_I03_PROVIDER insertPROVIDER(int rep) throws HL7Exception { 
       return (RPR_I03_PROVIDER)super.insertRepetition("PROVIDER", rep);
    }


    /**
     * Removes a specific repetition of PROVIDER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RPR_I03_PROVIDER removePROVIDER(int rep) throws HL7Exception { 
       return (RPR_I03_PROVIDER)super.removeRepetition("PROVIDER", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PID (Patient Identification) - creates it if necessary
     */
    public PID getPID() { 
       return getTyped("PID", PID.class);
    }


    /**
     * Returns a specific repetition of
     * PID (Patient Identification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PID getPID(int rep) { 
       return getTyped("PID", rep, PID.class);
    }

    /** 
     * Returns the number of existing repetitions of PID 
     */ 
    public int getPIDReps() { 
    	return getReps("PID");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PID.
     * <p>
     * <p>
     * Note that unlike {@link #getPID()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<PID> getPIDAll() throws HL7Exception {
    	return getAllAsList("PID", PID.class);
    } 

    /**
     * Inserts a specific repetition of PID (Patient Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPID(PID structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PID", structure, rep);
    }


    /**
     * Inserts a specific repetition of PID (Patient Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PID insertPID(int rep) throws HL7Exception { 
       return (PID)super.insertRepetition("PID", rep);
    }


    /**
     * Removes a specific repetition of PID (Patient Identification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PID removePID(int rep) throws HL7Exception { 
       return (PID)super.removeRepetition("PID", rep);
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

