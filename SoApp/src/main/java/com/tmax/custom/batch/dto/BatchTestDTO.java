package com.tmax.custom.batch.dto;

import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.model.dataobject.FieldProperty;
import com.tmax.proobject.model.exception.FieldNotFoundException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.lang.Cloneable;
import java.util.Date;

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.dto.DtoGenerator",
	date= "23. 12. 25. 오후 4:04"
)

@com.tmax.proobject.core2.annotation.DataObject
public class BatchTestDTO extends DataObject implements Serializable, Cloneable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getLogicalName() {
    	return "BatchTestDTO";
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
    private String servicename = null;
    private transient boolean servicename_modified = false;
    
    public String getServicename() {
    	return servicename;
    }	
    
    public void setServicename(String servicename) {
    	if (servicename == null) {
    		this.servicename = null;
    	} else {
    		this.servicename = servicename;
    	}
    }
    private String jobId = null;
    private transient boolean jobId_modified = false;
    
    public String getJobId() {
    	return jobId;
    }	
    
    public void setJobId(String jobId) {
    	if (jobId == null) {
    		this.jobId = null;
    	} else {
    		this.jobId = jobId;
    	}
    }
    private String jobName = null;
    private transient boolean jobName_modified = false;
    
    public String getJobName() {
    	return jobName;
    }	
    
    public void setJobName(String jobName) {
    	if (jobName == null) {
    		this.jobName = null;
    	} else {
    		this.jobName = jobName;
    	}
    }
    private String jobDate = null;
    private transient boolean jobDate_modified = false;
    
    public String getJobDate() {
    	return jobDate;
    }	
    
    public void setJobDate(String jobDate) {
    	if (jobDate == null) {
    		this.jobDate = null;
    	} else {
    		this.jobDate = jobDate;
    	}
    }
    private long jobExecutionId = 0L;
    private transient boolean jobExecutionId_modified = false;
    
    public long getJobExecutionId() {
    	return jobExecutionId;
    }	
    
    public void setJobExecutionId(long jobExecutionId) {
    	this.jobExecutionId = jobExecutionId;
    }
    public void setJobExecutionId(Long jobExecutionId) {
    	if (jobExecutionId == null) {
    		this.jobExecutionId = 0;
    	} else {
    		this.jobExecutionId = jobExecutionId.longValue();
    	}
    }
    public void setJobExecutionId(String jobExecutionId) {
    	if (jobExecutionId == null || jobExecutionId.length() == 0) {
    		this.jobExecutionId = 0;
    	} else {
    		this.jobExecutionId = Long.parseLong( jobExecutionId);
    	}
    }
    private String batchCallType = null;
    private transient boolean batchCallType_modified = false;
    
    public String getBatchCallType() {
    	return batchCallType;
    }	
    
    public void setBatchCallType(String batchCallType) {
    	if (batchCallType == null) {
    		this.batchCallType = null;
    	} else {
    		this.batchCallType = batchCallType;
    	}
    }
    private String callType = null;
    private transient boolean callType_modified = false;
    
    public String getCallType() {
    	return callType;
    }	
    
    public void setCallType(String callType) {
    	if (callType == null) {
    		this.callType = null;
    	} else {
    		this.callType = callType;
    	}
    }
    private String stringValue = null;
    private transient boolean stringValue_modified = false;
    
    public String getStringValue() {
    	return stringValue;
    }	
    
    public void setStringValue(String stringValue) {
    	if (stringValue == null) {
    		this.stringValue = null;
    	} else {
    		this.stringValue = stringValue;
    	}
    }
    private long longValue = 0L;
    private transient boolean longValue_modified = false;
    
    public long getLongValue() {
    	return longValue;
    }	
    
    public void setLongValue(long longValue) {
    	this.longValue = longValue;
    }
    public void setLongValue(Long longValue) {
    	if (longValue == null) {
    		this.longValue = 0;
    	} else {
    		this.longValue = longValue.longValue();
    	}
    }
    public void setLongValue(String longValue) {
    	if (longValue == null || longValue.length() == 0) {
    		this.longValue = 0;
    	} else {
    		this.longValue = Long.parseLong( longValue);
    	}
    }
    private double doubleValue = 0.0d;
    private transient boolean doubleValue_modified = false;
    
    public double getDoubleValue() {
    	return doubleValue;
    }	
    
    public void setDoubleValue(double doubleValue) {
    	this.doubleValue = doubleValue;
    }
    public void setDoubleValue(Double doubleValue) {
    	if (doubleValue == null) {
    		this.doubleValue = (double)0;
    	} else{
    		this.doubleValue = doubleValue.doubleValue();
    	}
    }
    public void setDoubleValue(String doubleValue) {
    	if (doubleValue == null || doubleValue.length() == 0) {
    		this.doubleValue = (double)0;
    	} else{
    		this.doubleValue = Double.parseDouble(doubleValue);
    	}
    }
    private Date dateValue = null;
    private transient boolean dateValue_modified = false;
    
    public Date getDateValue() {
    	return dateValue;
    }	
    
    public void setDateValue(Date dateValue) {
    	if (dateValue == null) {
    		this.dateValue = null;
    	} else {
    		this.dateValue = dateValue;
    	}
    }
    public void setDateValue(long dateValue) {
    	this.dateValue = new Date(dateValue);
    }
    private String parameterType = null;
    private transient boolean parameterType_modified = false;
    
    public String getParameterType() {
    	return parameterType;
    }	
    
    public void setParameterType(String parameterType) {
    	if (parameterType == null) {
    		this.parameterType = null;
    	} else {
    		this.parameterType = parameterType;
    	}
    }
    private String parameterName = null;
    private transient boolean parameterName_modified = false;
    
    public String getParameterName() {
    	return parameterName;
    }	
    
    public void setParameterName(String parameterName) {
    	if (parameterName == null) {
    		this.parameterName = null;
    	} else {
    		this.parameterName = parameterName;
    	}
    }
    private String inputPath = null;
    private transient boolean inputPath_modified = false;
    
    public String getInputPath() {
    	return inputPath;
    }	
    
    public void setInputPath(String inputPath) {
    	if (inputPath == null) {
    		this.inputPath = null;
    	} else {
    		this.inputPath = inputPath;
    	}
    }
    private String outputPath = null;
    private transient boolean outputPath_modified = false;
    
    public String getOutputPath() {
    	return outputPath;
    }	
    
    public void setOutputPath(String outputPath) {
    	if (outputPath == null) {
    		this.outputPath = null;
    	} else {
    		this.outputPath = outputPath;
    	}
    }
    
    public String toString() {
    	StringBuilder buffer = new StringBuilder();
    	
    	buffer.append("key : ").append(key).append("\n");   
    	buffer.append("value : ").append(value).append("\n");   
    	buffer.append("servicename : ").append(servicename).append("\n");   
    	buffer.append("jobId : ").append(jobId).append("\n");   
    	buffer.append("jobName : ").append(jobName).append("\n");   
    	buffer.append("jobDate : ").append(jobDate).append("\n");   
    	buffer.append("jobExecutionId : ").append(jobExecutionId).append("\n");   
    	buffer.append("batchCallType : ").append(batchCallType).append("\n");   
    	buffer.append("callType : ").append(callType).append("\n");   
    	buffer.append("stringValue : ").append(stringValue).append("\n");   
    	buffer.append("longValue : ").append(longValue).append("\n");   
    	buffer.append("doubleValue : ").append(doubleValue).append("\n");   
    	buffer.append("dateValue : ").append(dateValue).append("\n");   
    	buffer.append("parameterType : ").append(parameterType).append("\n");   
    	buffer.append("parameterName : ").append(parameterName).append("\n");   
    	buffer.append("inputPath : ").append(inputPath).append("\n");   
    	buffer.append("outputPath : ").append(outputPath).append("\n");   
    	return buffer.toString();
    }
    
    @Override
    public Object clone() {
    	BatchTestDTO copyObj = new BatchTestDTO();
    	copyObj.clone(this);
    	return copyObj;
    }
    
    public void clone(Object _batchTestDTO){
    	if (this == _batchTestDTO)
    		return;
    		
    	BatchTestDTO __batchTestDTO = (BatchTestDTO) _batchTestDTO;
    	this.setKey(__batchTestDTO.getKey());
    	this.setValue(__batchTestDTO.getValue());
    	this.setServicename(__batchTestDTO.getServicename());
    	this.setJobId(__batchTestDTO.getJobId());
    	this.setJobName(__batchTestDTO.getJobName());
    	this.setJobDate(__batchTestDTO.getJobDate());
    	this.setJobExecutionId(__batchTestDTO.getJobExecutionId());
    	this.setBatchCallType(__batchTestDTO.getBatchCallType());
    	this.setCallType(__batchTestDTO.getCallType());
    	this.setStringValue(__batchTestDTO.getStringValue());
    	this.setLongValue(__batchTestDTO.getLongValue());
    	this.setDoubleValue(__batchTestDTO.getDoubleValue());
    	Date _value12 = __batchTestDTO.getDateValue();
    	if (_value12 == null) {
    		this.setDateValue(null);
    	}else {
    		this.setDateValue((Date)_value12.clone());
    	}
    	this.setParameterType(__batchTestDTO.getParameterType());
    	this.setParameterName(__batchTestDTO.getParameterName());
    	this.setInputPath(__batchTestDTO.getInputPath());
    	this.setOutputPath(__batchTestDTO.getOutputPath());
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Object get(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "key":
    		return getKey();
    	case "value":
    		return getValue();
    	case "servicename":
    		return getServicename();
    	case "jobId":
    		return getJobId();
    	case "jobName":
    		return getJobName();
    	case "jobDate":
    		return getJobDate();
    	case "jobExecutionId":
    		return getJobExecutionId();
    	case "batchCallType":
    		return getBatchCallType();
    	case "callType":
    		return getCallType();
    	case "stringValue":
    		return getStringValue();
    	case "longValue":
    		return getLongValue();
    	case "doubleValue":
    		return getDoubleValue();
    	case "dateValue":
    		return getDateValue();
    	case "parameterType":
    		return getParameterType();
    	case "parameterName":
    		return getParameterName();
    	case "inputPath":
    		return getInputPath();
    	case "outputPath":
    		return getOutputPath();
    	default:
    		throw new FieldNotFoundException(fieldName);
    	}
    }
    
    @Override
    public void set(String fieldName, Object fieldValue) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "key":
    		setKey((String) fieldValue);
    		break;
    	case "value":
    		setValue((String) fieldValue);
    		break;
    	case "servicename":
    		setServicename((String) fieldValue);
    		break;
    	case "jobId":
    		setJobId((String) fieldValue);
    		break;
    	case "jobName":
    		setJobName((String) fieldValue);
    		break;
    	case "jobDate":
    		setJobDate((String) fieldValue);
    		break;
    	case "jobExecutionId":
    		setJobExecutionId((Long) fieldValue);
    		break;
    	case "batchCallType":
    		setBatchCallType((String) fieldValue);
    		break;
    	case "callType":
    		setCallType((String) fieldValue);
    		break;
    	case "stringValue":
    		setStringValue((String) fieldValue);
    		break;
    	case "longValue":
    		setLongValue((Long) fieldValue);
    		break;
    	case "doubleValue":
    		setDoubleValue((Double) fieldValue);
    		break;
    	case "dateValue":
    		setDateValue((Date) fieldValue);
    		break;
    	case "parameterType":
    		setParameterType((String) fieldValue);
    		break;
    	case "parameterName":
    		setParameterName((String) fieldValue);
    		break;
    	case "inputPath":
    		setInputPath((String) fieldValue);
    		break;
    	case "outputPath":
    		setOutputPath((String) fieldValue);
    		break;
    	default:
    		throw new FieldNotFoundException(fieldName);
    		
    	}
    }
    
    private static final Map<String, FieldProperty> fieldPropertyMap;
    
    static {
    	fieldPropertyMap = new java.util.LinkedHashMap<String, FieldProperty>(17);
    	fieldPropertyMap.put("key", FieldProperty.builder().setPhysicalName("key").setLogicalName("key")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("value", FieldProperty.builder().setPhysicalName("value").setLogicalName("value")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("servicename", FieldProperty.builder().setPhysicalName("servicename").setLogicalName("servicename")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("jobId", FieldProperty.builder().setPhysicalName("jobId").setLogicalName("jobId")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("jobName", FieldProperty.builder().setPhysicalName("jobName").setLogicalName("jobName")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("jobDate", FieldProperty.builder().setPhysicalName("jobDate").setLogicalName("jobDate")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("jobExecutionId", FieldProperty.builder().setPhysicalName("jobExecutionId").setLogicalName("jobExecutionId")
    	              .setType(FieldProperty.TYPE_PRIMITIVE_LONG).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("batchCallType", FieldProperty.builder().setPhysicalName("batchCallType").setLogicalName("batchCallType")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("callType", FieldProperty.builder().setPhysicalName("callType").setLogicalName("callType")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("stringValue", FieldProperty.builder().setPhysicalName("stringValue").setLogicalName("stringValue")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("longValue", FieldProperty.builder().setPhysicalName("longValue").setLogicalName("longValue")
    	              .setType(FieldProperty.TYPE_PRIMITIVE_LONG).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("doubleValue", FieldProperty.builder().setPhysicalName("doubleValue").setLogicalName("doubleValue")
    	              .setType(FieldProperty.TYPE_PRIMITIVE_DOUBLE).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("dateValue", FieldProperty.builder().setPhysicalName("dateValue").setLogicalName("dateValue")
    	              .setType(FieldProperty.TYPE_OBJECT_DATE).setLength(19).setDecimal(-1).build());
    	fieldPropertyMap.put("parameterType", FieldProperty.builder().setPhysicalName("parameterType").setLogicalName("parameterType")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("parameterName", FieldProperty.builder().setPhysicalName("parameterName").setLogicalName("parameterName")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(20).setDecimal(-1).build());
    	fieldPropertyMap.put("inputPath", FieldProperty.builder().setPhysicalName("inputPath").setLogicalName("inputPath")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(50).setDecimal(-1).build());
    	fieldPropertyMap.put("outputPath", FieldProperty.builder().setPhysicalName("outputPath").setLogicalName("outputPath")
    	              .setType(FieldProperty.TYPE_OBJECT_STRING).setLength(50).setDecimal(-1).build());
    }
    
    @Override
    public Map<String, FieldProperty> getFieldPropertyMap() {
     	return Collections.unmodifiableMap(fieldPropertyMap);
    }
    
    @Override
    public void clearModifiedStatus() {
    	key_modified = false;
    	value_modified = false;
    	servicename_modified = false;
    	jobId_modified = false;
    	jobName_modified = false;
    	jobDate_modified = false;
    	jobExecutionId_modified = false;
    	batchCallType_modified = false;
    	callType_modified = false;
    	stringValue_modified = false;
    	longValue_modified = false;
    	doubleValue_modified = false;
    	dateValue_modified = false;
    	parameterType_modified = false;
    	parameterName_modified = false;
    	inputPath_modified = false;
    	outputPath_modified = false;
    }
    
    @Override
    public void clearModifiedStatus(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "key":
    		key_modified = false;
    		break;
    	case "value":
    		value_modified = false;
    		break;
    	case "servicename":
    		servicename_modified = false;
    		break;
    	case "jobId":
    		jobId_modified = false;
    		break;
    	case "jobName":
    		jobName_modified = false;
    		break;
    	case "jobDate":
    		jobDate_modified = false;
    		break;
    	case "jobExecutionId":
    		jobExecutionId_modified = false;
    		break;
    	case "batchCallType":
    		batchCallType_modified = false;
    		break;
    	case "callType":
    		callType_modified = false;
    		break;
    	case "stringValue":
    		stringValue_modified = false;
    		break;
    	case "longValue":
    		longValue_modified = false;
    		break;
    	case "doubleValue":
    		doubleValue_modified = false;
    		break;
    	case "dateValue":
    		dateValue_modified = false;
    		break;
    	case "parameterType":
    		parameterType_modified = false;
    		break;
    	case "parameterName":
    		parameterName_modified = false;
    		break;
    	case "inputPath":
    		inputPath_modified = false;
    		break;
    	case "outputPath":
    		outputPath_modified = false;
    		break;
      	default:
         	throw new FieldNotFoundException(fieldName);
       	}
    }
    
    @Override
    public List<String> getModifiedField() {
    	List<String> modifiedFields = new ArrayList<>();
        if (this.key_modified = true)
        	modifiedFields.add("key");
        if (this.value_modified = true)
        	modifiedFields.add("value");
        if (this.servicename_modified = true)
        	modifiedFields.add("servicename");
        if (this.jobId_modified = true)
        	modifiedFields.add("jobId");
        if (this.jobName_modified = true)
        	modifiedFields.add("jobName");
        if (this.jobDate_modified = true)
        	modifiedFields.add("jobDate");
        if (this.jobExecutionId_modified = true)
        	modifiedFields.add("jobExecutionId");
        if (this.batchCallType_modified = true)
        	modifiedFields.add("batchCallType");
        if (this.callType_modified = true)
        	modifiedFields.add("callType");
        if (this.stringValue_modified = true)
        	modifiedFields.add("stringValue");
        if (this.longValue_modified = true)
        	modifiedFields.add("longValue");
        if (this.doubleValue_modified = true)
        	modifiedFields.add("doubleValue");
        if (this.dateValue_modified = true)
        	modifiedFields.add("dateValue");
        if (this.parameterType_modified = true)
        	modifiedFields.add("parameterType");
        if (this.parameterName_modified = true)
        	modifiedFields.add("parameterName");
        if (this.inputPath_modified = true)
        	modifiedFields.add("inputPath");
        if (this.outputPath_modified = true)
        	modifiedFields.add("outputPath");
        return modifiedFields;
    }
    
    @Override
    public boolean isModified() {
    	if (key_modified || value_modified || servicename_modified || jobId_modified || jobName_modified || jobDate_modified || jobExecutionId_modified || batchCallType_modified || callType_modified || stringValue_modified || longValue_modified || doubleValue_modified || dateValue_modified || parameterType_modified || parameterName_modified || inputPath_modified || outputPath_modified) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean isModified(String fieldName) throws FieldNotFoundException {
    	switch (fieldName) {
    	case "key":
    		return key_modified;
    	case "value":
    		return value_modified;
    	case "servicename":
    		return servicename_modified;
    	case "jobId":
    		return jobId_modified;
    	case "jobName":
    		return jobName_modified;
    	case "jobDate":
    		return jobDate_modified;
    	case "jobExecutionId":
    		return jobExecutionId_modified;
    	case "batchCallType":
    		return batchCallType_modified;
    	case "callType":
    		return callType_modified;
    	case "stringValue":
    		return stringValue_modified;
    	case "longValue":
    		return longValue_modified;
    	case "doubleValue":
    		return doubleValue_modified;
    	case "dateValue":
    		return dateValue_modified;
    	case "parameterType":
    		return parameterType_modified;
    	case "parameterName":
    		return parameterName_modified;
    	case "inputPath":
    		return inputPath_modified;
    	case "outputPath":
    		return outputPath_modified;
       	default:
      		throw new FieldNotFoundException(fieldName);
        }
    }
}
