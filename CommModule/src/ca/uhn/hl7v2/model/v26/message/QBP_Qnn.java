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
 * <p>Represents a QBP_Qnn message structure (see chapter 5.3.2.3). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: QPD (Query Parameter Definition) <b> </b></li>
                 * <li>5: RDF (Table Row Definition) <b>optional </b></li>
                 * <li>6: RCP (Response Control Parameter) <b> </b></li>
                 * <li>7: DSC (Continuation Pointer) <b>optional </b></li>
                 * <li>8: MSH (Message Header) <b> </b></li>
                 * <li>9: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>10: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>11: MSA (Message Acknowledgment) <b> </b></li>
                 * <li>12: ERR (Error) <b>optional </b></li>
                 * <li>13: QAK (Query Acknowledgment) <b> </b></li>
                 * <li>14: QPD (Query Parameter Definition) <b> </b></li>
                 * <li>15: Hxx (any HL7 segment) <b> </b></li>
                 * <li>16: DSC (Continuation Pointer) <b>optional </b></li>
 * </ul>
 */
public class QBP_Qnn extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new QBP_Qnn message with DefaultModelClassFactory. 
     */ 
    public QBP_Qnn() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new QBP_Qnn message with custom ModelClassFactory.
     */
    public QBP_Qnn(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(QPD.class, true, false);
                          this.add(RDF.class, false, false);
                          this.add(RCP.class, true, false);
                          this.add(DSC.class, false, false);
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(MSA.class, true, false);
                          this.add(ERR.class, false, false);
                          this.add(QAK.class, true, false);
                          this.add(QPD.class, true, false);
                          this.add(Hxx.class, true, false);
                          this.add(DSC.class, false, false);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating QBP_Qnn - this is probably a bug in the source code generator.", e);
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
     * QPD (Query Parameter Definition) - creates it if necessary
     */
    public QPD getQPD() { 
       return getTyped("QPD", QPD.class);
    }




    /**
     * Returns
     * RDF (Table Row Definition) - creates it if necessary
     */
    public RDF getRDF() { 
       return getTyped("RDF", RDF.class);
    }




    /**
     * Returns
     * RCP (Response Control Parameter) - creates it if necessary
     */
    public RCP getRCP() { 
       return getTyped("RCP", RCP.class);
    }




    /**
     * Returns
     * DSC (Continuation Pointer) - creates it if necessary
     */
    public DSC getDSC() { 
       return getTyped("DSC", DSC.class);
    }




    /**
     * Returns
     * MSH2 (Message Header) - creates it if necessary
     */
    public MSH getMSH2() { 
       return getTyped("MSH2", MSH.class);
    }




    /**
     * Returns
     * the first repetition of 
     * SFT2 (Software Segment) - creates it if necessary
     */
    public SFT getSFT2() { 
       return getTyped("SFT2", SFT.class);
    }


    /**
     * Returns a specific repetition of
     * SFT2 (Software Segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SFT getSFT2(int rep) { 
       return getTyped("SFT2", rep, SFT.class);
    }

    /** 
     * Returns the number of existing repetitions of SFT2 
     */ 
    public int getSFT2Reps() { 
    	return getReps("SFT2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SFT2.
     * <p>
     * <p>
     * Note that unlike {@link #getSFT2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public List<SFT> getSFT2All() throws HL7Exception {
    	return getAllAsList("SFT2", SFT.class);
    } 

    /**
     * Inserts a specific repetition of SFT2 (Software Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSFT2(SFT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "SFT2", structure, rep);
    }


    /**
     * Inserts a specific repetition of SFT2 (Software Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SFT insertSFT2(int rep) throws HL7Exception { 
       return (SFT)super.insertRepetition("SFT2", rep);
    }


    /**
     * Removes a specific repetition of SFT2 (Software Segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SFT removeSFT2(int rep) throws HL7Exception { 
       return (SFT)super.removeRepetition("SFT2", rep);
    }



    /**
     * Returns
     * UAC2 (User Authentication Credential Segment) - creates it if necessary
     */
    public UAC getUAC2() { 
       return getTyped("UAC2", UAC.class);
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
     * ERR (Error) - creates it if necessary
     */
    public ERR getERR() { 
       return getTyped("ERR", ERR.class);
    }




    /**
     * Returns
     * QAK (Query Acknowledgment) - creates it if necessary
     */
    public QAK getQAK() { 
       return getTyped("QAK", QAK.class);
    }




    /**
     * Returns
     * QPD2 (Query Parameter Definition) - creates it if necessary
     */
    public QPD getQPD2() { 
       return getTyped("QPD2", QPD.class);
    }




    /**
     * Returns
     * Hxx (any HL7 segment) - creates it if necessary
     */
    public Hxx getHxx() { 
       return getTyped("Hxx", Hxx.class);
    }




    /**
     * Returns
     * DSC2 (Continuation Pointer) - creates it if necessary
     */
    public DSC getDSC2() { 
       return getTyped("DSC2", DSC.class);
    }




}

