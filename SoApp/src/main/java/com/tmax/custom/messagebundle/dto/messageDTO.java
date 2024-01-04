package com.tmax.custom.messagebundle.dto;

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
	date= "24. 1. 3. 오후 4:29"
)

@com.tmax.proobject.core2.annotation.DataObject
public class messageDTO extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "messageDTO";
    }
    
    private String code = null;
    private transient boolean code_modified = false;
    
    public String getCode() {
    	return code;
    }	
    
    public void setCode(String code) {
    	if (code == null) {
    		this.code = null;
    	} else {
    		this.code = code;
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
    private String title = null;
    private transient boolean title_modified = false;
    
    public String getTitle() {
    	return title;
    }	
    
    public void setTitle(String title) {
    	if (title == null) {
    		this.title = null;
    	} else {
    		this.title = title;
    	}
    }
    private String type = null;
    private transient boolean type_modified = false;
    
    public String getType() {
    	return type;
    }	
    
    public void setType(String type) {
    	if (type == null) {
    		this.type = null;
    	} else {
    		this.type = type;
    	}
    }
    private String message = null;
    private transient boolean message_modified = false;
    
    public String getMessage() {
    	return message;
    }	
    
    public void setMessage(String message) {
    	if (message == null) {
    		this.message = null;
    	} else {
    		this.message = message;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("code : ").append(code).append("\n");   
    	buffer.append("name : ").append(name).append("\n");   
    	buffer.append("title : ").append(title).append("\n");   
    	buffer.append("type : ").append(type).append("\n");   
    	buffer.append("message : ").append(message).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	messageDTO copyObj = new messageDTO();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _messageDTO){
    	if (this == _messageDTO)
    		return;
    		
    	messageDTO __messageDTO = (messageDTO) _messageDTO;
    	this.setCode(__messageDTO.getCode());
    	this.setName(__messageDTO.getName());
    	this.setTitle(__messageDTO.getTitle());
    	this.setType(__messageDTO.getType());
    	this.setMessage(__messageDTO.getMessage());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "code":
    		return getCode();
    	case "name":
    		return getName();
    	case "title":
    		return getTitle();
    	case "type":
    		return getType();
    	case "message":
    		return getMessage();
    	default:
    		throw new FieldNotFoundException(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "code":
    		setCode((String) fieldValue);
    		break;
    	case "name":
    		setName((String) fieldValue);
    		break;
    	case "title":
    		setTitle((String) fieldValue);
    		break;
    	case "type":
    		setType((String) fieldValue);
    		break;
    	case "message":
    		setMessage((String) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(5);
    	fieldPropertyMap.put("code", FieldProperty.builder().setPhysicalName("code").setLogicalName("code")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(50).setDecimal(-1).build());
    	fieldPropertyMap.put("name", FieldProperty.builder().setPhysicalName("name").setLogicalName("name")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(50).setDecimal(-1).build());
    	fieldPropertyMap.put("title", FieldProperty.builder().setPhysicalName("title").setLogicalName("title")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(50).setDecimal(-1).build());
    	fieldPropertyMap.put("type", FieldProperty.builder().setPhysicalName("type").setLogicalName("type")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(4).setDecimal(-1).build());
    	fieldPropertyMap.put("message", FieldProperty.builder().setPhysicalName("message").setLogicalName("message")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	code_modified = false;
    	name_modified = false;
    	title_modified = false;
    	type_modified = false;
    	message_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "code":
    		code_modified = false;
    		break;
    	case "name":
    		name_modified = false;
    		break;
    	case "title":
    		title_modified = false;
    		break;
    	case "type":
    		type_modified = false;
    		break;
    	case "message":
    		message_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.code_modified = true)
        	modifiedFields.add("code");
        if (this.name_modified = true)
        	modifiedFields.add("name");
        if (this.title_modified = true)
        	modifiedFields.add("title");
        if (this.type_modified = true)
        	modifiedFields.add("type");
        if (this.message_modified = true)
        	modifiedFields.add("message");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (code_modified || name_modified || title_modified || type_modified || message_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "code":
    		return code_modified;
    	case "name":
    		return name_modified;
    	case "title":
    		return title_modified;
    	case "type":
    		return type_modified;
    	case "message":
    		return message_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
