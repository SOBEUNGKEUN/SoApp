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
	date= "24. 1. 24. 오전 11:58"
)

@com.tmax.proobject.core2.annotation.DataObject
public class SysHeader extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "SysHeader";
    }
    
    private String ip = null;
    private transient boolean ip_modified = false;
    
    public String getIp() {
    	return ip;
    }	
    
    public void setIp(String ip) {
    	if (ip == null) {
    		this.ip = null;
    	} else {
    		this.ip = ip;
    	}
    }
    private String userId = null;
    private transient boolean userId_modified = false;
    
    public String getUserId() {
    	return userId;
    }	
    
    public void setUserId(String userId) {
    	if (userId == null) {
    		this.userId = null;
    	} else {
    		this.userId = userId;
    	}
    }
    private String userPwd = null;
    private transient boolean userPwd_modified = false;
    
    public String getUserPwd() {
    	return userPwd;
    }	
    
    public void setUserPwd(String userPwd) {
    	if (userPwd == null) {
    		this.userPwd = null;
    	} else {
    		this.userPwd = userPwd;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("ip : ").append(ip).append("\n");   
    	buffer.append("userId : ").append(userId).append("\n");   
    	buffer.append("userPwd : ").append(userPwd).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	SysHeader copyObj = new SysHeader();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _sysHeader){
    	if (this == _sysHeader)
    		return;
    		
    	SysHeader __sysHeader = (SysHeader) _sysHeader;
    	this.setIp(__sysHeader.getIp());
    	this.setUserId(__sysHeader.getUserId());
    	this.setUserPwd(__sysHeader.getUserPwd());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ip":
    		return getIp();
    	case "userId":
    		return getUserId();
    	case "userPwd":
    		return getUserPwd();
    	default:
    		throw new FieldNotFoundException(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ip":
    		setIp((String) fieldValue);
    		break;
    	case "userId":
    		setUserId((String) fieldValue);
    		break;
    	case "userPwd":
    		setUserPwd((String) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(3);
    	fieldPropertyMap.put("ip", FieldProperty.builder().setPhysicalName("ip").setLogicalName("ip")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("userId", FieldProperty.builder().setPhysicalName("userId").setLogicalName("userId")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    	fieldPropertyMap.put("userPwd", FieldProperty.builder().setPhysicalName("userPwd").setLogicalName("userPwd")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(10).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	ip_modified = false;
    	userId_modified = false;
    	userPwd_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ip":
    		ip_modified = false;
    		break;
    	case "userId":
    		userId_modified = false;
    		break;
    	case "userPwd":
    		userPwd_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.ip_modified = true)
        	modifiedFields.add("ip");
        if (this.userId_modified = true)
        	modifiedFields.add("userId");
        if (this.userPwd_modified = true)
        	modifiedFields.add("userPwd");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (ip_modified || userId_modified || userPwd_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "ip":
    		return ip_modified;
    	case "userId":
    		return userId_modified;
    	case "userPwd":
    		return userPwd_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
