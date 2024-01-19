package com.tmax.custom.systemcontext.dto;

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
	date= "24. 1. 16. 오후 9:20"
)

@com.tmax.proobject.core2.annotation.DataObject
public class SampleCacheDTO extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "SampleCacheDTO";
    }
    
    private String name = null;
    private transient boolean name_modified = false;
    
    public String getName() {
    	return name;
    }	
    
    public void setName(String name) {
    	if (name == null) {
    		this.name = null;
    	} else {
    		this.name = name;
    	}
    }
    private String key = null;
    private transient boolean key_modified = false;
    
    public String getKey() {
    	return key;
    }	
    
    public void setKey(String key) {
    	if (key == null) {
    		this.key = null;
    	} else {
    		this.key = key;
    	}
    }
    private String value = null;
    private transient boolean value_modified = false;
    
    public String getValue() {
    	return value;
    }	
    
    public void setValue(String value) {
    	if (value == null) {
    		this.value = null;
    	} else {
    		this.value = value;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("name : ").append(name).append("\n");   
    	buffer.append("key : ").append(key).append("\n");   
    	buffer.append("value : ").append(value).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	SampleCacheDTO copyObj = new SampleCacheDTO();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _sampleCacheDTO){
    	if (this == _sampleCacheDTO)
    		return;
    		
    	SampleCacheDTO __sampleCacheDTO = (SampleCacheDTO) _sampleCacheDTO;
    	this.setName(__sampleCacheDTO.getName());
    	this.setKey(__sampleCacheDTO.getKey());
    	this.setValue(__sampleCacheDTO.getValue());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "name":
    		return getName();
    	case "key":
    		return getKey();
    	case "value":
    		return getValue();
    	default:
    		throw new FieldNotFoundException(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "name":
    		setName((String) fieldValue);
    		break;
    	case "key":
    		setKey((String) fieldValue);
    		break;
    	case "value":
    		setValue((String) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(3);
    	fieldPropertyMap.put("name", FieldProperty.builder().setPhysicalName("name").setLogicalName("name")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("key", FieldProperty.builder().setPhysicalName("key").setLogicalName("key")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("value", FieldProperty.builder().setPhysicalName("value").setLogicalName("value")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	name_modified = false;
    	key_modified = false;
    	value_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "name":
    		name_modified = false;
    		break;
    	case "key":
    		key_modified = false;
    		break;
    	case "value":
    		value_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.name_modified = true)
        	modifiedFields.add("name");
        if (this.key_modified = true)
        	modifiedFields.add("key");
        if (this.value_modified = true)
        	modifiedFields.add("value");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (name_modified || key_modified || value_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "name":
    		return name_modified;
    	case "key":
    		return key_modified;
    	case "value":
    		return value_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
