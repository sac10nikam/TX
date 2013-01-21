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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import net.newel.android.Log;
import ca.uhn.hl7v2.util.Constants;

import ca.uhn.hl7v2.model.Varies;

/**
 *<p>Represents an HL7 OM3 message segment (Categorical Service/Test/Observation). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM3-1: Sequence Number - Test/Observation Master File (NM) <b>optional </b>
     * <li>OM3-2: Preferred Coding System (CWE) <b>optional </b>
     * <li>OM3-3: Valid Coded "Answers" (CWE) <b>optional repeating</b>
     * <li>OM3-4: Normal Text/Codes for Categorical Observations (CWE) <b>optional repeating</b>
     * <li>OM3-5: Abnormal Text/Codes for Categorical Observations (CWE) <b>optional repeating</b>
     * <li>OM3-6: Critical Text/Codes for Categorical Observations (CWE) <b>optional repeating</b>
     * <li>OM3-7: Value Type (ID) <b>optional </b>
 * </ul>
 */
public class OM3 extends AbstractSegment {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new OM3 segment
     */
    public OM3(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/Observation Master File");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Preferred Coding System");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Valid Coded \"Answers\"");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Normal Text/Codes for Categorical Observations");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Abnormal Text/Codes for Categorical Observations");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Critical Text/Codes for Categorical Observations");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(125) }, "Value Type");
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating OM3 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM3-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM3-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getOm31_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM3-2: "Preferred Coding System" - creates it if necessary
     */
    public CWE getPreferredCodingSystem() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM3-2: "Preferred Coding System" - creates it if necessary
     */
    public CWE getOm32_PreferredCodingSystem() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Valid Coded "Answers" (OM3-3).
     */
    public CWE[] getValidCodedAnswers() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Valid Coded "Answers" (OM3-3).
     */
    public CWE[] getOm33_ValidCodedAnswers() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Valid Coded "Answers" (OM3-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getValidCodedAnswersReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * OM3-3: "Valid Coded "Answers"" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getValidCodedAnswers(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM3-3: "Valid Coded "Answers"" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm33_ValidCodedAnswers(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Valid Coded "Answers" (OM3-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm33_ValidCodedAnswersReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * OM3-3: "Valid Coded "Answers"" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertValidCodedAnswers(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * OM3-3: "Valid Coded "Answers"" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm33_ValidCodedAnswers(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM3-3: "Valid Coded "Answers"" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeValidCodedAnswers(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM3-3: "Valid Coded "Answers"" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm33_ValidCodedAnswers(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     */
    public CWE[] getNormalTextCodesForCategoricalObservations() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     */
    public CWE[] getOm34_NormalTextCodesForCategoricalObservations() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getNormalTextCodesForCategoricalObservations(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm34_NormalTextCodesForCategoricalObservations(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm34_NormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertNormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm34_NormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeNormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm34_NormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     */
    public CWE[] getAbnormalTextCodesForCategoricalObservations() {
    	CWE[] retVal = this.getTypedField(5, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     */
    public CWE[] getOm35_AbnormalTextCodesForCategoricalObservations() {
    	CWE[] retVal = this.getTypedField(5, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAbnormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAbnormalTextCodesForCategoricalObservations(int rep) { 
		CWE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm35_AbnormalTextCodesForCategoricalObservations(int rep) { 
		CWE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm35_AbnormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm35_AbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm35_AbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     */
    public CWE[] getCriticalTextCodesForCategoricalObservations() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     */
    public CWE[] getOm36_CriticalTextCodesForCategoricalObservations() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCriticalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCriticalTextCodesForCategoricalObservations(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm36_CriticalTextCodesForCategoricalObservations(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm36_CriticalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm36_CriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm36_CriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * OM3-7: "Value Type" - creates it if necessary
     */
    public ID getValueType() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM3-7: "Value Type" - creates it if necessary
     */
    public ID getOm37_ValueType() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new ID(getMessage(), new Integer( 125 ));
          default: return null;
       }
   }


}

