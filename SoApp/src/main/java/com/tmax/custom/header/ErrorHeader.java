package com.tmax.custom.header;

import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.model.dataobject.FieldProperty;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.lang.Cloneable;

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.dto.DtoGenerator",
	date= "24. 1. 10. 오전 11:07"
)

@com.tmax.proobject.core2.annotation.DataObject
public class ErrorHeader extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "ErrorHeader";
    }
    
    private String responseCode = null;
    private transient boolean responseCode_modified = false;
    
    public String getResponseCode() {
    	return responseCode;
    }	
    
    public void setResponseCode(String responseCode) {
    	if (responseCode == null) {
    		this.responseCode = null;
    	} else {
    		this.responseCode = responseCode;
    	}
    }
    private String responseType = null;
    private transient boolean responseType_modified = false;
    
    public String getResponseType() {
    	return responseType;
    }	
    
    public void setResponseType(String responseType) {
    	if (responseType == null) {
    		this.responseType = null;
    	} else {
    		this.responseType = responseType;
    	}
    }
    private String responseTitle = null;
    private transient boolean responseTitle_modified = false;
    
    public String getResponseTitle() {
    	return responseTitle;
    }	
    
    public void setResponseTitle(String responseTitle) {
    	if (responseTitle == null) {
    		this.responseTitle = null;
    	} else {
    		this.responseTitle = responseTitle;
    	}
    }
    private String responseBasic = null;
    private transient boolean responseBasic_modified = false;
    
    public String getResponseBasic() {
    	return responseBasic;
    }	
    
    public void setResponseBasic(String responseBasic) {
    	if (responseBasic == null) {
    		this.responseBasic = null;
    	} else {
    		this.responseBasic = responseBasic;
    	}
    }
    private String responseDtal = null;
    private transient boolean responseDtal_modified = false;
    
    public String getResponseDtal() {
    	return responseDtal;
    }	
    
    public void setResponseDtal(String responseDtal) {
    	if (responseDtal == null) {
    		this.responseDtal = null;
    	} else {
    		this.responseDtal = responseDtal;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("responseCode : ").append(responseCode).append("\n");   
    	buffer.append("responseType : ").append(responseType).append("\n");   
    	buffer.append("responseTitle : ").append(responseTitle).append("\n");   
    	buffer.append("responseBasic : ").append(responseBasic).append("\n");   
    	buffer.append("responseDtal : ").append(responseDtal).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	ErrorHeader copyObj = new ErrorHeader();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _errorHeader){
    	if (this == _errorHeader)
    		return;
    		
    	ErrorHeader __errorHeader = (ErrorHeader) _errorHeader;
    	this.setResponseCode(__errorHeader.getResponseCode());
    	this.setResponseType(__errorHeader.getResponseType());
    	this.setResponseTitle(__errorHeader.getResponseTitle());
    	this.setResponseBasic(__errorHeader.getResponseBasic());
    	this.setResponseDtal(__errorHeader.getResponseDtal());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "responseCode":
    		return getResponseCode();
    	case "responseType":
    		return getResponseType();
    	case "responseTitle":
    		return getResponseTitle();
    	case "responseBasic":
    		return getResponseBasic();
    	case "responseDtal":
    		return getResponseDtal();
    	default:
    		throw new FieldNotFoundException(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "responseCode":
    		setResponseCode((String) fieldValue);
    		break;
    	case "responseType":
    		setResponseType((String) fieldValue);
    		break;
    	case "responseTitle":
    		setResponseTitle((String) fieldValue);
    		break;
    	case "responseBasic":
    		setResponseBasic((String) fieldValue);
    		break;
    	case "responseDtal":
    		setResponseDtal((String) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(5);
    	fieldPropertyMap.put("responseCode", FieldProperty.builder().setPhysicalName("responseCode").setLogicalName("responseCode")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(4).setDecimal(-1).build());
    	fieldPropertyMap.put("responseType", FieldProperty.builder().setPhysicalName("responseType").setLogicalName("responseType")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(4).setDecimal(-1).build());
    	fieldPropertyMap.put("responseTitle", FieldProperty.builder().setPhysicalName("responseTitle").setLogicalName("responseTitle")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(4).setDecimal(-1).build());
    	fieldPropertyMap.put("responseBasic", FieldProperty.builder().setPhysicalName("responseBasic").setLogicalName("responseBasic")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(4).setDecimal(-1).build());
    	fieldPropertyMap.put("responseDtal", FieldProperty.builder().setPhysicalName("responseDtal").setLogicalName("responseDtal")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(256).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	responseCode_modified = false;
    	responseType_modified = false;
    	responseTitle_modified = false;
    	responseBasic_modified = false;
    	responseDtal_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "responseCode":
    		responseCode_modified = false;
    		break;
    	case "responseType":
    		responseType_modified = false;
    		break;
    	case "responseTitle":
    		responseTitle_modified = false;
    		break;
    	case "responseBasic":
    		responseBasic_modified = false;
    		break;
    	case "responseDtal":
    		responseDtal_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.responseCode_modified = true)
        	modifiedFields.add("responseCode");
        if (this.responseType_modified = true)
        	modifiedFields.add("responseType");
        if (this.responseTitle_modified = true)
        	modifiedFields.add("responseTitle");
        if (this.responseBasic_modified = true)
        	modifiedFields.add("responseBasic");
        if (this.responseDtal_modified = true)
        	modifiedFields.add("responseDtal");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (responseCode_modified || responseType_modified || responseTitle_modified || responseBasic_modified || responseDtal_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "responseCode":
    		return responseCode_modified;
    	case "responseType":
    		return responseType_modified;
    	case "responseTitle":
    		return responseTitle_modified;
    	case "responseBasic":
    		return responseBasic_modified;
    	case "responseDtal":
    		return responseDtal_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
