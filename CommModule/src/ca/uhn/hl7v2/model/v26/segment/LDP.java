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
 *<p>Represents an HL7 LDP message segment (Location Department). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>LDP-1: Primary Key Value - LDP (PL) <b> </b>
     * <li>LDP-2: Location Department (CWE) <b> </b>
     * <li>LDP-3: Location Service (IS) <b>optional repeating</b>
     * <li>LDP-4: Specialty Type (CWE) <b>optional repeating</b>
     * <li>LDP-5: Valid Patient Classes (IS) <b>optional repeating</b>
     * <li>LDP-6: Active/Inactive Flag (ID) <b>optional </b>
     * <li>LDP-7: Activation Date - LDP (DTM) <b>optional </b>
     * <li>LDP-8: Inactivation Date - LDP (DTM) <b>optional </b>
     * <li>LDP-9: Inactivated Reason (ST) <b>optional </b>
     * <li>LDP-10: Visiting Hours (VH) <b>optional repeating</b>
     * <li>LDP-11: Contact Phone (XTN) <b>optional </b>
     * <li>LDP-12: Location Cost Center (CWE) <b>optional </b>
 * </ul>
 */
public class LDP extends AbstractSegment {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new LDP segment
     */
    public LDP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PL.class, true, 1, 200, new Object[]{ getMessage() }, "Primary Key Value - LDP");
                                  this.add(CWE.class, true, 1, 250, new Object[]{ getMessage() }, "Location Department");
                                              this.add(IS.class, false, 0, 3, new Object[]{ getMessage(), new Integer(69) }, "Location Service");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Specialty Type");
                                              this.add(IS.class, false, 0, 1, new Object[]{ getMessage(), new Integer(4) }, "Valid Patient Classes");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(183) }, "Active/Inactive Flag");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Activation Date - LDP");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Inactivation Date - LDP");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Inactivated Reason");
                                  this.add(VH.class, false, 0, 80, new Object[]{ getMessage() }, "Visiting Hours");
                                  this.add(XTN.class, false, 1, 250, new Object[]{ getMessage() }, "Contact Phone");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Location Cost Center");
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating LDP - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * LDP-1: "Primary Key Value - LDP" - creates it if necessary
     */
    public PL getPrimaryKeyValueLDP() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-1: "Primary Key Value - LDP" - creates it if necessary
     */
    public PL getLdp1_PrimaryKeyValueLDP() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * LDP-2: "Location Department" - creates it if necessary
     */
    public CWE getLocationDepartment() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-2: "Location Department" - creates it if necessary
     */
    public CWE getLdp2_LocationDepartment() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Location Service (LDP-3).
     */
    public IS[] getLocationService() {
    	IS[] retVal = this.getTypedField(3, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location Service (LDP-3).
     */
    public IS[] getLdp3_LocationService() {
    	IS[] retVal = this.getTypedField(3, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location Service (LDP-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationServiceReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * LDP-3: "Location Service" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLocationService(int rep) { 
		IS retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LDP-3: "Location Service" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLdp3_LocationService(int rep) { 
		IS retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location Service (LDP-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLdp3_LocationServiceReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * LDP-3: "Location Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLocationService(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * LDP-3: "Location Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLdp3_LocationService(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LDP-3: "Location Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLocationService(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LDP-3: "Location Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLdp3_LocationService(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Specialty Type (LDP-4).
     */
    public CWE[] getSpecialtyType() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specialty Type (LDP-4).
     */
    public CWE[] getLdp4_SpecialtyType() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specialty Type (LDP-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecialtyTypeReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * LDP-4: "Specialty Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecialtyType(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LDP-4: "Specialty Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getLdp4_SpecialtyType(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specialty Type (LDP-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLdp4_SpecialtyTypeReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * LDP-4: "Specialty Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecialtyType(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * LDP-4: "Specialty Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertLdp4_SpecialtyType(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LDP-4: "Specialty Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecialtyType(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LDP-4: "Specialty Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeLdp4_SpecialtyType(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Valid Patient Classes (LDP-5).
     */
    public IS[] getValidPatientClasses() {
    	IS[] retVal = this.getTypedField(5, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Valid Patient Classes (LDP-5).
     */
    public IS[] getLdp5_ValidPatientClasses() {
    	IS[] retVal = this.getTypedField(5, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Valid Patient Classes (LDP-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getValidPatientClassesReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * LDP-5: "Valid Patient Classes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getValidPatientClasses(int rep) { 
		IS retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LDP-5: "Valid Patient Classes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLdp5_ValidPatientClasses(int rep) { 
		IS retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Valid Patient Classes (LDP-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLdp5_ValidPatientClassesReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * LDP-5: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * LDP-5: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLdp5_ValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * LDP-5: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * LDP-5: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLdp5_ValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * LDP-6: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getActiveInactiveFlag() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-6: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getLdp6_ActiveInactiveFlag() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * LDP-7: "Activation Date - LDP" - creates it if necessary
     */
    public DTM getActivationDateLDP() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-7: "Activation Date - LDP" - creates it if necessary
     */
    public DTM getLdp7_ActivationDateLDP() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * LDP-8: "Inactivation Date - LDP" - creates it if necessary
     */
    public DTM getInactivationDateLDP() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-8: "Inactivation Date - LDP" - creates it if necessary
     */
    public DTM getLdp8_InactivationDateLDP() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * LDP-9: "Inactivated Reason" - creates it if necessary
     */
    public ST getInactivatedReason() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-9: "Inactivated Reason" - creates it if necessary
     */
    public ST getLdp9_InactivatedReason() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Visiting Hours (LDP-10).
     */
    public VH[] getVisitingHours() {
    	VH[] retVal = this.getTypedField(10, new VH[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Visiting Hours (LDP-10).
     */
    public VH[] getLdp10_VisitingHours() {
    	VH[] retVal = this.getTypedField(10, new VH[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Visiting Hours (LDP-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVisitingHoursReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * LDP-10: "Visiting Hours" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public VH getVisitingHours(int rep) { 
		VH retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LDP-10: "Visiting Hours" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public VH getLdp10_VisitingHours(int rep) { 
		VH retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Visiting Hours (LDP-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLdp10_VisitingHoursReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * LDP-10: "Visiting Hours" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public VH insertVisitingHours(int rep) throws HL7Exception { 
        return (VH) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * LDP-10: "Visiting Hours" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public VH insertLdp10_VisitingHours(int rep) throws HL7Exception { 
        return (VH) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * LDP-10: "Visiting Hours" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public VH removeVisitingHours(int rep) throws HL7Exception { 
        return (VH) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * LDP-10: "Visiting Hours" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public VH removeLdp10_VisitingHours(int rep) throws HL7Exception { 
        return (VH) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * LDP-11: "Contact Phone" - creates it if necessary
     */
    public XTN getContactPhone() { 
		XTN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-11: "Contact Phone" - creates it if necessary
     */
    public XTN getLdp11_ContactPhone() { 
		XTN retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * LDP-12: "Location Cost Center" - creates it if necessary
     */
    public CWE getLocationCostCenter() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LDP-12: "Location Cost Center" - creates it if necessary
     */
    public CWE getLdp12_LocationCostCenter() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new IS(getMessage(), new Integer( 69 ));
          case 3: return new CWE(getMessage());
          case 4: return new IS(getMessage(), new Integer( 4 ));
          case 5: return new ID(getMessage(), new Integer( 183 ));
          case 6: return new DTM(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new VH(getMessage());
          case 10: return new XTN(getMessage());
          case 11: return new CWE(getMessage());
          default: return null;
       }
   }


}

