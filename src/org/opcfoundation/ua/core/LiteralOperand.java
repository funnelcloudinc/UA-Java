 /* Copyright (c) 1996-2015, OPC Foundation. All rights reserved.
   The source code in this file is covered under a dual-license scenario:
     - RCL: for OPC Foundation members in good-standing
     - GPL V2: everybody else
   RCL license terms accompanied with this source code. See http://opcfoundation.org/License/RCL/1.00/
   GNU General Public License as published by the Free Software Foundation;
   version 2 of the License are accompanied with this source code. See http://opcfoundation.org/License/GPLv2
   This source code is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
*/

package org.opcfoundation.ua.core;

import org.opcfoundation.ua.builtintypes.Structure;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.utils.ObjectUtils;
import org.opcfoundation.ua.builtintypes.Variant;
import org.opcfoundation.ua.core.FilterOperand;



public class LiteralOperand extends FilterOperand implements Structure, Cloneable {
	
	public static final ExpandedNodeId ID = new ExpandedNodeId(Identifiers.LiteralOperand);
	public static final ExpandedNodeId BINARY = new ExpandedNodeId(Identifiers.LiteralOperand_Encoding_DefaultBinary);
	public static final ExpandedNodeId XML = new ExpandedNodeId(Identifiers.LiteralOperand_Encoding_DefaultXml);
	
    protected Variant Value;
    
    public LiteralOperand() {}
    
    public LiteralOperand(Variant Value)
    {
        this.Value = Value;
    }
    
    public Variant getValue()
    {
        return Value;
    }
    
    public void setValue(Variant Value)
    {
        this.Value = Value;
    }
    
    /**
      * Deep clone
      *
      * @return cloned LiteralOperand
      */
    public LiteralOperand clone()
    {
        LiteralOperand result = new LiteralOperand();
        result.Value = Value;
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        LiteralOperand other = (LiteralOperand) obj;
        if (Value==null) {
            if (other.Value != null) return false;
        } else if (!Value.equals(other.Value)) return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((Value == null) ? 0 : Value.hashCode());
        return result;
    }
    


	public ExpandedNodeId getTypeId() {
		return ID;
	}

	public ExpandedNodeId getXmlEncodeId() {
		return XML;
	}

	public ExpandedNodeId getBinaryEncodeId() {
		return BINARY;
	}
	
	public String toString() {
		return "LiteralOperand: "+ObjectUtils.printFieldsDeep(this);
	}

}