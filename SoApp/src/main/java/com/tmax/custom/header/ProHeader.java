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
	date= "23. 12. 21. 오전 11:18"
)

@com.tmax.proobject.core2.annotation.DataObject
public class ProHeader extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "ProHeader";
    }
    
    private String appName = null;
    private transient boolean appName_modified = false;
    
    public String getAppName() {
    	return appName;
    }	
    
    public void setAppName(String appName) {
    	if (appName == null) {
    		this.appName = null;
    	} else {
    		this.appName = appName;
    	}
    }
    private String sgName = null;
    private transient boolean sgName_modified = false;
    
    public String getSgName() {
    	return sgName;
    }	
    
    public void setSgName(String sgName) {
    	if (sgName == null) {
    		this.sgName = null;
    	} else {
    		this.sgName = sgName;
    	}
    }
    private String svcName = null;
    private transient boolean svcName_modified = false;
    
    public String getSvcName() {
    	return svcName;
    }	
    
    public void setSvcName(String svcName) {
    	if (svcName == null) {
    		this.svcName = null;
    	} else {
    		this.svcName = svcName;
    	}
    }
    private String fnName = null;
    private transient boolean fnName_modified = false;
    
    public String getFnName() {
    	return fnName;
    }	
    
    public void setFnName(String fnName) {
    	if (fnName == null) {
    		this.fnName = null;
    	} else {
    		this.fnName = fnName;
    	}
    }
    private String guid = null;
    private transient boolean guid_modified = false;
    
    public String getGuid() {
    	return guid;
    }	
    
    public void setGuid(String guid) {
    	if (guid == null) {
    		this.guid = null;
    	} else {
    		this.guid = guid;
    	}
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
    	
    	buffer.append("appName : ").append(appName).append("\n");   
    	buffer.append("sgName : ").append(sgName).append("\n");   
    	buffer.append("svcName : ").append(svcName).append("\n");   
    	buffer.append("fnName : ").append(fnName).append("\n");   
    	buffer.append("guid : ").append(guid).append("\n");   
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
    	this.setAppName(__proHeader.getAppName());
    	this.setSgName(__proHeader.getSgName());
    	this.setSvcName(__proHeader.getSvcName());
    	this.setFnName(__proHeader.getFnName());
    	this.setGuid(__proHeader.getGuid());
    	this.setName(__proHeader.getName());
    	this.setEnumber(__proHeader.getEnumber());
    	this.setPosition(__proHeader.getPosition());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "appName":
    		return getAppName();
    	case "sgName":
    		return getSgName();
    	case "svcName":
    		return getSvcName();
    	case "fnName":
    		return getFnName();
    	case "guid":
    		return getGuid();
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
    	case "appName":
    		setAppName((String) fieldValue);
    		break;
    	case "sgName":
    		setSgName((String) fieldValue);
    		break;
    	case "svcName":
    		setSvcName((String) fieldValue);
    		break;
    	case "fnName":
    		setFnName((String) fieldValue);
    		break;
    	case "guid":
    		setGuid((String) fieldValue);
    		break;
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
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(8);
    	fieldPropertyMap.put("appName", FieldProperty.builder().setPhysicalName("appName").setLogicalName("appName")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("sgName", FieldProperty.builder().setPhysicalName("sgName").setLogicalName("sgName")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("svcName", FieldProperty.builder().setPhysicalName("svcName").setLogicalName("svcName")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("fnName", FieldProperty.builder().setPhysicalName("fnName").setLogicalName("fnName")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("guid", FieldProperty.builder().setPhysicalName("guid").setLogicalName("guid")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
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
    	appName_modified = false;
    	sgName_modified = false;
    	svcName_modified = false;
    	fnName_modified = false;
    	guid_modified = false;
    	name_modified = false;
    	enumber_modified = false;
    	position_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "appName":
    		appName_modified = false;
    		break;
    	case "sgName":
    		sgName_modified = false;
    		break;
    	case "svcName":
    		svcName_modified = false;
    		break;
    	case "fnName":
    		fnName_modified = false;
    		break;
    	case "guid":
    		guid_modified = false;
    		break;
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
        if (this.appName_modified = true)
        	modifiedFields.add("appName");
        if (this.sgName_modified = true)
        	modifiedFields.add("sgName");
        if (this.svcName_modified = true)
        	modifiedFields.add("svcName");
        if (this.fnName_modified = true)
        	modifiedFields.add("fnName");
        if (this.guid_modified = true)
        	modifiedFields.add("guid");
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
    	if (appName_modified || sgName_modified || svcName_modified || fnName_modified || guid_modified || name_modified || enumber_modified || position_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "appName":
    		return appName_modified;
    	case "sgName":
    		return sgName_modified;
    	case "svcName":
    		return svcName_modified;
    	case "fnName":
    		return fnName_modified;
    	case "guid":
    		return guid_modified;
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
