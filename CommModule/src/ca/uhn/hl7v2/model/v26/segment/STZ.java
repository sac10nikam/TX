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
 *<p>Represents an HL7 STZ message segment (Sterilization Parameter). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>STZ-1: Sterilization Type (CWE) <b>optional </b>
     * <li>STZ-2: Sterilization Cycle (CWE) <b>optional </b>
     * <li>STZ-3: Maintenance Cycle (CWE) <b>optional </b>
     * <li>STZ-4: Maintenance Type (CWE) <b>optional </b>
 * </ul>
 */
public class STZ extends AbstractSegment {
	private static final long serialVersionUID = 1L;

    /** 
     * Creates a new STZ segment
     */
    public STZ(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Sterilization Type");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Sterilization Cycle");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Maintenance Cycle");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Maintenance Type");
       } catch(HL7Exception e) {
          Log.e(Constants.TAG, "Unexpected error creating STZ - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * STZ-1: "Sterilization Type" - creates it if necessary
     */
    public CWE getSterilizationType() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STZ-1: "Sterilization Type" - creates it if necessary
     */
    public CWE getStz1_SterilizationType() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * STZ-2: "Sterilization Cycle" - creates it if necessary
     */
    public CWE getSterilizationCycle() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STZ-2: "Sterilization Cycle" - creates it if necessary
     */
    public CWE getStz2_SterilizationCycle() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * STZ-3: "Maintenance Cycle" - creates it if necessary
     */
    public CWE getMaintenanceCycle() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STZ-3: "Maintenance Cycle" - creates it if necessary
     */
    public CWE getStz3_MaintenanceCycle() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * STZ-4: "Maintenance Type" - creates it if necessary
     */
    public CWE getMaintenanceType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STZ-4: "Maintenance Type" - creates it if necessary
     */
    public CWE getStz4_MaintenanceType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          default: return null;
       }
   }


}

