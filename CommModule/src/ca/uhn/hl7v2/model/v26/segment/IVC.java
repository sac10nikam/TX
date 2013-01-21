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
 *<p>Represents an HL7 IVC message segment (Invoice Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IVC-1: Provider Invoice Number (EI) <b> </b>
     * <li>IVC-2: Payer Invoice Number (EI) <b>optional </b>
     * <li>IVC-3: Contract/Agreement Number (EI) <b>optional </b>
     * <li>IVC-4: Invoice Control (IS) <b> </b>
     * <li>IVC-5: Invoice Reason (IS) <b> </b>
     * <li>IVC-6: Invoice Type (IS) <b> </b>
     * <li>IVC-7: Invoice Date/Time (DTM) <b> </b>
     * <li>IVC-8: Invoice Amount (CP) <b> </b>
     * <li>IVC-9: Payment Terms (ST) <b>optional </b>
     * <li>IVC-10: Provider Organization (XON) <b> </b>
     * <li>IVC-11: Payer Organization (XON) <b> </b>
     * <li>IVC-12: Attention (XCN) <b>optional </b>
     * <li>IVC-13: Last Invoice Indicator (ID) <b>optional </b>
     * <li>IVC-14: Invoice Booking Period (DTM) <b>optional </b>
     * <li>IVC-15: Origin (ST) <b>optional </b>
     * <li>IVC-16: Invoice Fixed Amount (CP) <b>optional </b>
     * <li>IVC-17: Special Costs (CP) <b>optional </b>
     * <li>IVC-18: Amount for Doctors Treatment (CP) <b>optional </b>
     * <li>IVC-19: Responsible Physician (XCN) <b>optional </b>
     * <li>IVC-20: Cost Center (CX) <b>optional </b>
     * <li>IVC-21: Invoice Prepaid Amount (CP) <b>optional </b>
     * <li>IVC-22: Total Invoice Amount without Prepaid Amount (CP) <b>optional </b>
     * <li>IVC-23: Total-Amount of VAT (CP) <b>optional </b>
     * <li>IVC-24: VAT-Rates applied (NM) <b>optional repeating</b>
     * <li>IVC-25: Benefit Group (IS) <b> </b>
     * <li>IVC-26: Provider Tax ID (ST) <b>optional </b>
     * <li>IVC-27: Payer Tax ID (ST) <b>optional </b>
     * <li>IVC-28: Provider Tax status (IS) <b>optional </b>
     * <li>IVC-29: Payer Tax status (IS) <b>optional </b>
     * <li>IVC-30: Sales Tax ID (ST) <b>optional </b>
 * </ul>
 */
public class IVC extends AbstractSegment {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new IVC segment
     */
    public IVC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 74, new Object[]{ getMessage() }, "Provider Invoice Number");
                                  this.add(EI.class, false, 1, 74, new Object[]{ getMessage() }, "Payer Invoice Number");
                                  this.add(EI.class, false, 1, 74, new Object[]{ getMessage() }, "Contract/Agreement Number");
                                              this.add(IS.class, true, 1, 2, new Object[]{ getMessage(), new Integer(553) }, "Invoice Control");
                                              this.add(IS.class, true, 1, 4, new Object[]{ getMessage(), new Integer(554) }, "Invoice Reason");
                                              this.add(IS.class, true, 1, 2, new Object[]{ getMessage(), new Integer(555) }, "Invoice Type");
                                  this.add(DTM.class, true, 1, 24, new Object[]{ getMessage() }, "Invoice Date/Time");
                                  this.add(CP.class, true, 1, 254, new Object[]{ getMessage() }, "Invoice Amount");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Payment Terms");
                                  this.add(XON.class, true, 1, 183, new Object[]{ getMessage() }, "Provider Organization");
                                  this.add(XON.class, true, 1, 183, new Object[]{ getMessage() }, "Payer Organization");
                                  this.add(XCN.class, false, 1, 637, new Object[]{ getMessage() }, "Attention");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Last Invoice Indicator");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Invoice Booking Period");
                                  this.add(ST.class, false, 1, 250, new Object[]{ getMessage() }, "Origin");
                                  this.add(CP.class, false, 1, 254, new Object[]{ getMessage() }, "Invoice Fixed Amount");
                                  this.add(CP.class, false, 1, 254, new Object[]{ getMessage() }, "Special Costs");
                                  this.add(CP.class, false, 1, 254, new Object[]{ getMessage() }, "Amount for Doctors Treatment");
                                  this.add(XCN.class, false, 1, 250, new Object[]{ getMessage() }, "Responsible Physician");
                                  this.add(CX.class, false, 1, 250, new Object[]{ getMessage() }, "Cost Center");
                                  this.add(CP.class, false, 1, 254, new Object[]{ getMessage() }, "Invoice Prepaid Amount");
                                  this.add(CP.class, false, 1, 254, new Object[]{ getMessage() }, "Total Invoice Amount without Prepaid Amount");
                                  this.add(CP.class, false, 1, 254, new Object[]{ getMessage() }, "Total-Amount of VAT");
                                  this.add(NM.class, false, 0, 1024, new Object[]{ getMessage() }, "VAT-Rates applied");
                                              this.add(IS.class, true, 1, 4, new Object[]{ getMessage(), new Integer(556) }, "Benefit Group");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Provider Tax ID");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Payer Tax ID");
                                              this.add(IS.class, false, 1, 4, new Object[]{ getMessage(), new Integer(572) }, "Provider Tax status");
                                              this.add(IS.class, false, 1, 4, new Object[]{ getMessage(), new Integer(572) }, "Payer Tax status");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Sales Tax ID");
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating IVC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IVC-1: "Provider Invoice Number" - creates it if necessary
     */
    public EI getProviderInvoiceNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-1: "Provider Invoice Number" - creates it if necessary
     */
    public EI getIvc1_ProviderInvoiceNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-2: "Payer Invoice Number" - creates it if necessary
     */
    public EI getPayerInvoiceNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-2: "Payer Invoice Number" - creates it if necessary
     */
    public EI getIvc2_PayerInvoiceNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-3: "Contract/Agreement Number" - creates it if necessary
     */
    public EI getContractAgreementNumber() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-3: "Contract/Agreement Number" - creates it if necessary
     */
    public EI getIvc3_ContractAgreementNumber() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-4: "Invoice Control" - creates it if necessary
     */
    public IS getInvoiceControl() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-4: "Invoice Control" - creates it if necessary
     */
    public IS getIvc4_InvoiceControl() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-5: "Invoice Reason" - creates it if necessary
     */
    public IS getInvoiceReason() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-5: "Invoice Reason" - creates it if necessary
     */
    public IS getIvc5_InvoiceReason() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-6: "Invoice Type" - creates it if necessary
     */
    public IS getInvoiceType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-6: "Invoice Type" - creates it if necessary
     */
    public IS getIvc6_InvoiceType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-7: "Invoice Date/Time" - creates it if necessary
     */
    public DTM getInvoiceDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-7: "Invoice Date/Time" - creates it if necessary
     */
    public DTM getIvc7_InvoiceDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-8: "Invoice Amount" - creates it if necessary
     */
    public CP getInvoiceAmount() { 
		CP retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-8: "Invoice Amount" - creates it if necessary
     */
    public CP getIvc8_InvoiceAmount() { 
		CP retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-9: "Payment Terms" - creates it if necessary
     */
    public ST getPaymentTerms() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-9: "Payment Terms" - creates it if necessary
     */
    public ST getIvc9_PaymentTerms() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-10: "Provider Organization" - creates it if necessary
     */
    public XON getProviderOrganization() { 
		XON retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-10: "Provider Organization" - creates it if necessary
     */
    public XON getIvc10_ProviderOrganization() { 
		XON retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-11: "Payer Organization" - creates it if necessary
     */
    public XON getPayerOrganization() { 
		XON retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-11: "Payer Organization" - creates it if necessary
     */
    public XON getIvc11_PayerOrganization() { 
		XON retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-12: "Attention" - creates it if necessary
     */
    public XCN getAttention() { 
		XCN retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-12: "Attention" - creates it if necessary
     */
    public XCN getIvc12_Attention() { 
		XCN retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-13: "Last Invoice Indicator" - creates it if necessary
     */
    public ID getLastInvoiceIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-13: "Last Invoice Indicator" - creates it if necessary
     */
    public ID getIvc13_LastInvoiceIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-14: "Invoice Booking Period" - creates it if necessary
     */
    public DTM getInvoiceBookingPeriod() { 
		DTM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-14: "Invoice Booking Period" - creates it if necessary
     */
    public DTM getIvc14_InvoiceBookingPeriod() { 
		DTM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-15: "Origin" - creates it if necessary
     */
    public ST getOrigin() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-15: "Origin" - creates it if necessary
     */
    public ST getIvc15_Origin() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-16: "Invoice Fixed Amount" - creates it if necessary
     */
    public CP getInvoiceFixedAmount() { 
		CP retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-16: "Invoice Fixed Amount" - creates it if necessary
     */
    public CP getIvc16_InvoiceFixedAmount() { 
		CP retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-17: "Special Costs" - creates it if necessary
     */
    public CP getSpecialCosts() { 
		CP retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-17: "Special Costs" - creates it if necessary
     */
    public CP getIvc17_SpecialCosts() { 
		CP retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-18: "Amount for Doctors Treatment" - creates it if necessary
     */
    public CP getAmountForDoctorsTreatment() { 
		CP retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-18: "Amount for Doctors Treatment" - creates it if necessary
     */
    public CP getIvc18_AmountForDoctorsTreatment() { 
		CP retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-19: "Responsible Physician" - creates it if necessary
     */
    public XCN getResponsiblePhysician() { 
		XCN retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-19: "Responsible Physician" - creates it if necessary
     */
    public XCN getIvc19_ResponsiblePhysician() { 
		XCN retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-20: "Cost Center" - creates it if necessary
     */
    public CX getCostCenter() { 
		CX retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-20: "Cost Center" - creates it if necessary
     */
    public CX getIvc20_CostCenter() { 
		CX retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-21: "Invoice Prepaid Amount" - creates it if necessary
     */
    public CP getInvoicePrepaidAmount() { 
		CP retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-21: "Invoice Prepaid Amount" - creates it if necessary
     */
    public CP getIvc21_InvoicePrepaidAmount() { 
		CP retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-22: "Total Invoice Amount without Prepaid Amount" - creates it if necessary
     */
    public CP getTotalInvoiceAmountWithoutPrepaidAmount() { 
		CP retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-22: "Total Invoice Amount without Prepaid Amount" - creates it if necessary
     */
    public CP getIvc22_TotalInvoiceAmountWithoutPrepaidAmount() { 
		CP retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-23: "Total-Amount of VAT" - creates it if necessary
     */
    public CP getTotalAmountOfVAT() { 
		CP retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-23: "Total-Amount of VAT" - creates it if necessary
     */
    public CP getIvc23_TotalAmountOfVAT() { 
		CP retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of VAT-Rates applied (IVC-24).
     */
    public NM[] getVATRatesApplied() {
    	NM[] retVal = this.getTypedField(24, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of VAT-Rates applied (IVC-24).
     */
    public NM[] getIvc24_VATRatesApplied() {
    	NM[] retVal = this.getTypedField(24, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of VAT-Rates applied (IVC-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVATRatesAppliedReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * IVC-24: "VAT-Rates applied" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getVATRatesApplied(int rep) { 
		NM retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IVC-24: "VAT-Rates applied" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getIvc24_VATRatesApplied(int rep) { 
		NM retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of VAT-Rates applied (IVC-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIvc24_VATRatesAppliedReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * IVC-24: "VAT-Rates applied" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertVATRatesApplied(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * IVC-24: "VAT-Rates applied" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertIvc24_VATRatesApplied(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IVC-24: "VAT-Rates applied" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeVATRatesApplied(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IVC-24: "VAT-Rates applied" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeIvc24_VATRatesApplied(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(24, rep);
    }




    /**
     * Returns
     * IVC-25: "Benefit Group" - creates it if necessary
     */
    public IS getBenefitGroup() { 
		IS retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-25: "Benefit Group" - creates it if necessary
     */
    public IS getIvc25_BenefitGroup() { 
		IS retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-26: "Provider Tax ID" - creates it if necessary
     */
    public ST getProviderTaxID() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-26: "Provider Tax ID" - creates it if necessary
     */
    public ST getIvc26_ProviderTaxID() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-27: "Payer Tax ID" - creates it if necessary
     */
    public ST getPayerTaxID() { 
		ST retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-27: "Payer Tax ID" - creates it if necessary
     */
    public ST getIvc27_PayerTaxID() { 
		ST retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-28: "Provider Tax status" - creates it if necessary
     */
    public IS getProviderTaxStatus() { 
		IS retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-28: "Provider Tax status" - creates it if necessary
     */
    public IS getIvc28_ProviderTaxStatus() { 
		IS retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-29: "Payer Tax status" - creates it if necessary
     */
    public IS getPayerTaxStatus() { 
		IS retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-29: "Payer Tax status" - creates it if necessary
     */
    public IS getIvc29_PayerTaxStatus() { 
		IS retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * IVC-30: "Sales Tax ID" - creates it if necessary
     */
    public ST getSalesTaxID() { 
		ST retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVC-30: "Sales Tax ID" - creates it if necessary
     */
    public ST getIvc30_SalesTaxID() { 
		ST retVal = this.getTypedField(30, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new IS(getMessage(), new Integer( 553 ));
          case 4: return new IS(getMessage(), new Integer( 554 ));
          case 5: return new IS(getMessage(), new Integer( 555 ));
          case 6: return new DTM(getMessage());
          case 7: return new CP(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new XON(getMessage());
          case 10: return new XON(getMessage());
          case 11: return new XCN(getMessage());
          case 12: return new ID(getMessage(), new Integer( 136 ));
          case 13: return new DTM(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new CP(getMessage());
          case 16: return new CP(getMessage());
          case 17: return new CP(getMessage());
          case 18: return new XCN(getMessage());
          case 19: return new CX(getMessage());
          case 20: return new CP(getMessage());
          case 21: return new CP(getMessage());
          case 22: return new CP(getMessage());
          case 23: return new NM(getMessage());
          case 24: return new IS(getMessage(), new Integer( 556 ));
          case 25: return new ST(getMessage());
          case 26: return new ST(getMessage());
          case 27: return new IS(getMessage(), new Integer( 572 ));
          case 28: return new IS(getMessage(), new Integer( 572 ));
          case 29: return new ST(getMessage());
          default: return null;
       }
   }


}

