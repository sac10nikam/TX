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
 * <p>Represents a RSP_K23 message structure (see chapter 3.3.58). This structure contains the 
 * following elements: </p>
 * <ul>
                 * <li>1: MSH (Message Header) <b> </b></li>
                 * <li>2: SFT (Software Segment) <b>optional repeating</b></li>
                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b></li>
                 * <li>4: MSA (Message Acknowledgment) <b> </b></li>
                 * <li>5: ERR (Error) <b>optional </b></li>
                 * <li>6: QAK (Query Acknowledgment) <b> </b></li>
                 * <li>7: QPD (Query Parameter Definition) <b> </b></li>
                 * <li>8: RSP_K23_QUERY_RESPONSE (a Group object) <b>optional </b></li>
                 * <li>9: DSC (Continuation Pointer) <b>optional </b></li>
 * </ul>
 */
public class RSP_K23 extends AbstractMessage  {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new RSP_K23 message with DefaultModelClassFactory. 
     */ 
    public RSP_K23() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RSP_K23 message with custom ModelClassFactory.
     */
    public RSP_K23(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
                          this.add(SFT.class, false, true);
                          this.add(UAC.class, false, false);
                          this.add(MSA.class, true, false);
                          this.add(ERR.class, false, false);
                          this.add(QAK.class, true, false);
                          this.add(QPD.class, true, false);
                          this.add(RSP_K23_QUERY_RESPONSE.class, false, false);
                          this.add(DSC.class, false, false);
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating RSP_K23 - this is probably a bug in the source code generator.", e);
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
     * QPD (Query Parameter Definition) - creates it if necessary
     */
    public QPD getQPD() { 
       return getTyped("QPD", QPD.class);
    }




    /**
     * Returns
     * QUERY_RESPONSE (a Group object) - creates it if necessary
     */
    public RSP_K23_QUERY_RESPONSE getQUERY_RESPONSE() { 
       return getTyped("QUERY_RESPONSE", RSP_K23_QUERY_RESPONSE.class);
    }




    /**
     * Returns
     * DSC (Continuation Pointer) - creates it if necessary
     */
    public DSC getDSC() { 
       return getTyped("DSC", DSC.class);
    }




}

