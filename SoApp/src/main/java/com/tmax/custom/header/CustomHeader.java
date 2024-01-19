package com.tmax.custom.header;

import com.tmax.proobject.model.dataobject.FieldProperty;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.dto.DtoGenerator",
	date= "24. 1. 10. 오전 11:07"
)

@com.tmax.proobject.core2.annotation.DataObject
public class CustomHeader extends com.tmax.proobject.model.context.Header {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "CustomHeader";
    }
    
    private com.tmax.custom.header.ProHeader ProHeader = null;
    private transient boolean ProHeader_modified = false;
    
    public com.tmax.custom.header.ProHeader getProHeader() {
    	return ProHeader;
    }	
    
    public void setProHeader(com.tmax.custom.header.ProHeader ProHeader) {
    	if (ProHeader == null) {
    		this.ProHeader = null;
    	} else {
    		this.ProHeader = ProHeader;
    	}
    }
    private com.tmax.custom.header.SysHeader SysHeader = null;
    private transient boolean SysHeader_modified = false;
    
    public com.tmax.custom.header.SysHeader getSysHeader() {
    	return SysHeader;
    }	
    
    public void setSysHeader(com.tmax.custom.header.SysHeader SysHeader) {
    	if (SysHeader == null) {
    		this.SysHeader = null;
    	} else {
    		this.SysHeader = SysHeader;
    	}
    }
    private com.tmax.custom.header.ErrorHeader ErrorHeader = null;
    private transient boolean ErrorHeader_modified = false;
    
    public com.tmax.custom.header.ErrorHeader getErrorHeader() {
    	return ErrorHeader;
    }	
    
    public void setErrorHeader(com.tmax.custom.header.ErrorHeader ErrorHeader) {
    	if (ErrorHeader == null) {
    		this.ErrorHeader = null;
    	} else {
    		this.ErrorHeader = ErrorHeader;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("ProHeader : ").append(ProHeader).append("\n");   
    	buffer.append("SysHeader : ").append(SysHeader).append("\n");   
    	buffer.append("ErrorHeader : ").append(ErrorHeader).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	CustomHeader copyObj = new CustomHeader();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _customHeader){
    	if (this == _customHeader)
    		return;
    		
    	CustomHeader __customHeader = (CustomHeader) _customHeader;
    	super.clone(__customHeader);
    	com.tmax.custom.header.ProHeader _value0 = __customHeader.getProHeader();
    	if (_value0 == null) {
    		this.setProHeader(null);
    	}else {
    		this.setProHeader((com.tmax.custom.header.ProHeader)_value0.clone());
    	}
    	com.tmax.custom.header.SysHeader _value1 = __customHeader.getSysHeader();
    	if (_value1 == null) {
    		this.setSysHeader(null);
    	}else {
    		this.setSysHeader((com.tmax.custom.header.SysHeader)_value1.clone());
    	}
    	com.tmax.custom.header.ErrorHeader _value2 = __customHeader.getErrorHeader();
    	if (_value2 == null) {
    		this.setErrorHeader(null);
    	}else {
    		this.setErrorHeader((com.tmax.custom.header.ErrorHeader)_value2.clone());
    	}
    }
    
    
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ProHeader":
    		return getProHeader();
    	case "SysHeader":
    		return getSysHeader();
    	case "ErrorHeader":
    		return getErrorHeader();
    	default:
    		return super.get(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ProHeader":
    		setProHeader((com.tmax.custom.header.ProHeader) fieldValue);
    		break;
    	case "SysHeader":
    		setSysHeader((com.tmax.custom.header.SysHeader) fieldValue);
    		break;
    	case "ErrorHeader":
    		setErrorHeader((com.tmax.custom.header.ErrorHeader) fieldValue);
    		break;
    	default:
    		super.set(fieldName, fieldValue);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(3);
    	fieldPropertyMap.put("ProHeader", FieldProperty.builder().setPhysicalName("ProHeader").setLogicalName("ProHeader")
    	              .setType(FieldProperty.TYPE_ABSTRACT_INCLUDE).setDecimal(-1).setReference("com.tmax.custom.header.ProHeader").build());
    	fieldPropertyMap.put("SysHeader", FieldProperty.builder().setPhysicalName("SysHeader").setLogicalName("SysHeader")
    	              .setType(FieldProperty.TYPE_ABSTRACT_INCLUDE).setDecimal(-1).setReference("com.tmax.custom.header.SysHeader").build());
    	fieldPropertyMap.put("ErrorHeader", FieldProperty.builder().setPhysicalName("ErrorHeader").setLogicalName("ErrorHeader")
    	              .setType(FieldProperty.TYPE_ABSTRACT_INCLUDE).setDecimal(-1).setReference("com.tmax.custom.header.ErrorHeader").build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	ProHeader_modified = false;
    	SysHeader_modified = false;
    	ErrorHeader_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ProHeader":
    		ProHeader_modified = false;
    		break;
    	case "SysHeader":
    		SysHeader_modified = false;
    		break;
    	case "ErrorHeader":
    		ErrorHeader_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.ProHeader_modified = true)
        	modifiedFields.add("ProHeader");
        if (this.SysHeader_modified = true)
        	modifiedFields.add("SysHeader");
        if (this.ErrorHeader_modified = true)
        	modifiedFields.add("ErrorHeader");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (ProHeader_modified || SysHeader_modified || ErrorHeader_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ProHeader":
    		return ProHeader_modified;
    	case "SysHeader":
    		return SysHeader_modified;
    	case "ErrorHeader":
    		return ErrorHeader_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
