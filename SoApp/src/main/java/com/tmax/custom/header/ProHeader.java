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
	date= "23. 12. 19. 오후 2:00"
)

@com.tmax.proobject.core2.annotation.DataObject
public class ProHeader extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "ProHeader";
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
    private int enumber = 0;
    private transient boolean enumber_modified = false;
    
    public int getEnumber() {
    	return enumber;
    }	
    
    public void setEnumber(int enumber) {
    	this.enumber = enumber;
    }
    public void setEnumber(Integer enumber) {
    	if ( enumber == null) {
    		this.enumber = 0;
    	} else{
    		this.enumber = enumber.intValue();
    	}
    }
    public void setEnumber(String enumber) {
    	if  (enumber==null || enumber.length() == 0) {
    		this.enumber = 0;
    	} else {
    		this.enumber = Integer.parseInt(enumber);
    	}
    }
    private String position = null;
    private transient boolean position_modified = false;
    
    public String getPosition() {
    	return position;
    }	
    
    public void setPosition(String position) {
    	if (position == null) {
    		this.position = null;
    	} else {
    		this.position = position;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("name : ").append(name).append("\n");   
    	buffer.append("enumber : ").append(enumber).append("\n");   
    	buffer.append("position : ").append(position).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	ProHeader copyObj = new ProHeader();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _proHeader){
    	if (this == _proHeader)
    		return;
    		
    	ProHeader __proHeader = (ProHeader) _proHeader;
    	this.setName(__proHeader.getName());
    	this.setEnumber(__proHeader.getEnumber());
    	this.setPosition(__proHeader.getPosition());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "name":
    		return getName();
    	case "enumber":
    		return getEnumber();
    	case "position":
    		return getPosition();
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
    	case "enumber":
    		setEnumber((Integer) fieldValue);
    		break;
    	case "position":
    		setPosition((String) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(3);
    	fieldPropertyMap.put("name", FieldProperty.builder().setPhysicalName("name").setLogicalName("name")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("enumber", FieldProperty.builder().setPhysicalName("enumber").setLogicalName("enumber")
    	              .setType(FieldProperty.TYPE_PRIMITIVE_INT).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("position", FieldProperty.builder().setPhysicalName("position").setLogicalName("position")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	name_modified = false;
    	enumber_modified = false;
    	position_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "name":
    		name_modified = false;
    		break;
    	case "enumber":
    		enumber_modified = false;
    		break;
    	case "position":
    		position_modified = false;
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
        if (this.enumber_modified = true)
        	modifiedFields.add("enumber");
        if (this.position_modified = true)
        	modifiedFields.add("position");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (name_modified || enumber_modified || position_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "name":
    		return name_modified;
    	case "enumber":
    		return enumber_modified;
    	case "position":
    		return position_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
