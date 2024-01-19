package com.tmax.custom.sample.dto;

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
	date= "24. 1. 16. 오후 3:45"
)

@com.tmax.proobject.core2.annotation.DataObject
public class SampleMultiDTO extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "SampleMultiDTO";
    }
    
    private List<com.tmax.custom.sample.dto.SampleDTO> input =  null;
    private transient boolean input_modified = false;
    
    public void clearInput() {
    	if (input != null)
    		input.clear();
    }
    
    public void ensureCapacityInput(int minCapacity) {
    	if (input == null)
    		input = new ArrayList<com.tmax.custom.sample.dto.SampleDTO>(minCapacity);
    	else
    		((ArrayList<com.tmax.custom.sample.dto.SampleDTO>)input).ensureCapacity(minCapacity);
    }
    		
    public SampleMultiDTO fillInput(int _index) {
    	ensureCapacityInput(_index+1);
    	for (int i = sizeInput(); i < _index + 1; i++) {
    		this.input.add(i, new com.tmax.custom.sample.dto.SampleDTO());
    	}
    	return this;
    }
    	
    public int sizeInput() {
    	if (input == null)
    		return 0;
    		
    	return input.size();
    }
    
    public List<com.tmax.custom.sample.dto.SampleDTO> getInput() {
    	if (this.input == null)
    		return null;
    
    	return this.input;
    }
    
    public com.tmax.custom.sample.dto.SampleDTO getInput(int _index) {
    	return (com.tmax.custom.sample.dto.SampleDTO)input.get(_index);
    }
    
    
    public void setInput(List<com.tmax.custom.sample.dto.SampleDTO> input) {
    	if (input == null) {
    		this.input = null;
    	} else {
    		this.input = input;
    	}
    }
    
    private int arraysize = 0;
    private transient boolean arraysize_modified = false;
    
    public int getArraysize() {
    	return arraysize;
    }	
    
    public void setArraysize(int arraysize) {
    	this.arraysize = arraysize;
    }
    public void setArraysize(Integer arraysize) {
    	if ( arraysize == null) {
    		this.arraysize = 0;
    	} else{
    		this.arraysize = arraysize.intValue();
    	}
    }
    public void setArraysize(String arraysize) {
    	if  (arraysize==null || arraysize.length() == 0) {
    		this.arraysize = 0;
    	} else {
    		this.arraysize = Integer.parseInt(arraysize);
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("input[");
    	for (int index = 0; index < sizeInput(); index++) {
    		buffer.append("(").append(index).append(") : ").append(getInput(index)).append(" ");
    	}
    	buffer.append("]");
    	buffer.append("\n");
    	buffer.append("arraysize : ").append(arraysize).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	SampleMultiDTO copyObj = new SampleMultiDTO();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _sampleMultiDTO){
    	if (this == _sampleMultiDTO)
    		return;
    		
    	SampleMultiDTO __sampleMultiDTO = (SampleMultiDTO) _sampleMultiDTO;
    	this.clearInput();
    	if (this.getInput() == null && __sampleMultiDTO.getInput() != null)
    		this.ensureCapacityInput(__sampleMultiDTO.sizeInput());
    		
    	for (int index = 0; index < __sampleMultiDTO.sizeInput(); index++) {
    		com.tmax.custom.sample.dto.SampleDTO _value0 = __sampleMultiDTO.getInput(index);
    		if (_value0 == null) {
    			this.getInput().add(index, null);
    		} else{
    			this.getInput().add(index, (com.tmax.custom.sample.dto.SampleDTO)_value0.clone());
    		}
    	}
    	this.setArraysize(__sampleMultiDTO.getArraysize());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "input":
    		return getInput();
    	case "arraysize":
    		return getArraysize();
    	default:
    		throw new FieldNotFoundException(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "input":
    		setInput((List<com.tmax.custom.sample.dto.SampleDTO>) fieldValue);
    		break;
    	case "arraysize":
    		setArraysize((Integer) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(2);
    	fieldPropertyMap.put("input", FieldProperty.builder().setPhysicalName("input").setLogicalName("input")
    	              .setType(FieldProperty.TYPE_ABSTRACT_INCLUDE).setDecimal(-1).setArray("arraysize").setReference("com.tmax.custom.sample.dto.SampleDTO").build());
    	fieldPropertyMap.put("arraysize", FieldProperty.builder().setPhysicalName("arraysize").setLogicalName("arraysize")
    	              .setType(FieldProperty.TYPE_PRIMITIVE_INT).setLength(4).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	input_modified = false;
    	arraysize_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "input":
    		input_modified = false;
    		break;
    	case "arraysize":
    		arraysize_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.input_modified = true)
        	modifiedFields.add("input");
        if (this.arraysize_modified = true)
        	modifiedFields.add("arraysize");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (input_modified || arraysize_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "input":
    		return input_modified;
    	case "arraysize":
    		return arraysize_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
