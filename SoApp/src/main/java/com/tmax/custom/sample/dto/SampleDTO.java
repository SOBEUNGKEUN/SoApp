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
	date= "23. 12. 5. 오후 7:37"
)

@com.tmax.proobject.core2.annotation.DataObject
public class SampleDTO extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "SampleDTO";
    }
    
    private int empno = 0;
    private transient boolean empno_modified = false;
    
    public int getEmpno() {
    	return empno;
    }	
    
    public void setEmpno(int empno) {
    	this.empno = empno;
    }
    public void setEmpno(Integer empno) {
    	if ( empno == null) {
    		this.empno = 0;
    	} else{
    		this.empno = empno.intValue();
    	}
    }
    public void setEmpno(String empno) {
    	if  (empno==null || empno.length() == 0) {
    		this.empno = 0;
    	} else {
    		this.empno = Integer.parseInt(empno);
    	}
    }
    private String ename = null;
    private transient boolean ename_modified = false;
    
    public String getEname() {
    	return ename;
    }	
    
    public void setEname(String ename) {
    	if (ename == null) {
    		this.ename = null;
    	} else {
    		this.ename = ename;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("empno : ").append(empno).append("\n");   
    	buffer.append("ename : ").append(ename).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	SampleDTO copyObj = new SampleDTO();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _sampleDTO){
    	if (this == _sampleDTO)
    		return;
    		
    	SampleDTO __sampleDTO = (SampleDTO) _sampleDTO;
    	this.setEmpno(__sampleDTO.getEmpno());
    	this.setEname(__sampleDTO.getEname());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "empno":
    		return getEmpno();
    	case "ename":
    		return getEname();
    	default:
    		throw new FieldNotFoundException(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "empno":
    		setEmpno((Integer) fieldValue);
    		break;
    	case "ename":
    		setEname((String) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(2);
    	fieldPropertyMap.put("empno", FieldProperty.builder().setPhysicalName("empno").setLogicalName("empno")
    	              .setType(FieldProperty.TYPE_PRIMITIVE_INT).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("ename", FieldProperty.builder().setPhysicalName("ename").setLogicalName("ename")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	empno_modified = false;
    	ename_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "empno":
    		empno_modified = false;
    		break;
    	case "ename":
    		ename_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.empno_modified = true)
        	modifiedFields.add("empno");
        if (this.ename_modified = true)
        	modifiedFields.add("ename");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (empno_modified || ename_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "empno":
    		return empno_modified;
    	case "ename":
    		return ename_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
