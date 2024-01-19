package com.tmax.custom.batch.dto;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.message.exception.UnmarshalException;
import com.tmax.proobject.model.message.exception.MarshalException;
import com.tmax.proobject.core2.annotation.Message;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import proobject.com.google.gson.stream.JsonReader;
import proobject.com.google.gson.stream.JsonWriter;
import proobject.com.google.gson.stream.JsonToken;
import java.util.Date;
import proobject.com.google.gson.stream.MalformedJsonException;

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.message.MessageGenerator",
	date= "23. 12. 25. 오후 4:04"
)

@Message
public class BatchTestDTOMsgJson extends AbstractMessage {
    public byte[] marshal(Object obj) throws MarshalException {
    	BatchTestDTO _BatchTestDTO = (BatchTestDTO)obj;
    	
    	if (_BatchTestDTO == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _BatchTestDTO, jw);
    		
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
       	} catch(Exception e) {
       		throw new MarshalException(e);
       	} finally{
       		try {
       			if ( jw != null )
    				try {
    					jw.close();
    				} catch (IOException e) {
    					throw new MarshalException(e);
    				}
    		} finally {
    			if ( bw != null )
    				try {
    					bw.close();
    				} catch (IOException e) {
    					throw new MarshalException(e);
    				}
    		}
    	}
    }
    
    
    public void marshal(com.tmax.custom.batch.dto.BatchTestDTO _BatchTestDTO, JsonWriter writer )throws IOException {
    
    	writer.name("key"); 
    	if (_BatchTestDTO.getKey() != null) {
    		writer.value(_BatchTestDTO.getKey());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("value"); 
    	if (_BatchTestDTO.getValue() != null) {
    		writer.value(_BatchTestDTO.getValue());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("servicename"); 
    	if (_BatchTestDTO.getServicename() != null) {
    		writer.value(_BatchTestDTO.getServicename());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("jobId"); 
    	if (_BatchTestDTO.getJobId() != null) {
    		writer.value(_BatchTestDTO.getJobId());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("jobName"); 
    	if (_BatchTestDTO.getJobName() != null) {
    		writer.value(_BatchTestDTO.getJobName());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("jobDate"); 
    	if (_BatchTestDTO.getJobDate() != null) {
    		writer.value(_BatchTestDTO.getJobDate());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("jobExecutionId");
    	writer.value(_BatchTestDTO.getJobExecutionId());
    	writer.name("batchCallType"); 
    	if (_BatchTestDTO.getBatchCallType() != null) {
    		writer.value(_BatchTestDTO.getBatchCallType());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("callType"); 
    	if (_BatchTestDTO.getCallType() != null) {
    		writer.value(_BatchTestDTO.getCallType());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("stringValue"); 
    	if (_BatchTestDTO.getStringValue() != null) {
    		writer.value(_BatchTestDTO.getStringValue());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("longValue");
    	writer.value(_BatchTestDTO.getLongValue());
    	writer.name("doubleValue");
    	writer.value(_BatchTestDTO.getDoubleValue());
    	java.text.SimpleDateFormat df = null;
    	writer.name("dateValue"); 
    	if (_BatchTestDTO.getDateValue() != null) {
    		df = new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss");		
    		writer.value(df.format(_BatchTestDTO.getDateValue()));
    	} else {
    		writer.nullValue();
    	}
    	writer.name("parameterType"); 
    	if (_BatchTestDTO.getParameterType() != null) {
    		writer.value(_BatchTestDTO.getParameterType());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("parameterName"); 
    	if (_BatchTestDTO.getParameterName() != null) {
    		writer.value(_BatchTestDTO.getParameterName());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("inputPath"); 
    	if (_BatchTestDTO.getInputPath() != null) {
    		writer.value(_BatchTestDTO.getInputPath());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("outputPath"); 
    	if (_BatchTestDTO.getOutputPath() != null) {
    		writer.value(_BatchTestDTO.getOutputPath());
    	} else {
    		writer.nullValue();
    	}
    }
    
    public String removeNullChar(String charString) {
    	if ( charString == null )
        	return "";
        
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0 ; i<charString.length(); i++) {
    		if (charString.charAt(i) == (char)0) {
    			sb.append("");
    		} else {
    			sb.append(charString.charAt(i));
    		}
    	}
    	return sb.toString();
    }
    
    
    public BatchTestDTO unmarshal(byte[] bytes) throws UnmarshalException {
    	BatchTestDTO _BatchTestDTO = new BatchTestDTO();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new BatchTestDTO();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_BatchTestDTO = (BatchTestDTO)unmarshal( jr,  _BatchTestDTO);
    
    		jr.endObject();
    		jr.close();
    
    	} catch(Exception e) {
    	    throw new UnmarshalException(e);
    	}finally{
    		try{
    			if ( jr != null )
    				try {
    					jr.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    		} finally {
    			if ( reader != null )
    				try {
    					reader.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    		}
    	}
    	return _BatchTestDTO;
    }
    	
    public Object unmarshal(byte[] bytes, BatchTestDTO dto) throws UnmarshalException {
    	
    	BatchTestDTO _BatchTestDTO = (BatchTestDTO) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new BatchTestDTO();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_BatchTestDTO = (BatchTestDTO)unmarshal( jr,  _BatchTestDTO);
    
    		jr.endObject();
    		jr.close();
    	
    	} catch(Exception e) {
    		throw new UnmarshalException(e);
    	} finally {
    		try{
    			if ( jr != null ) 
    				try{
    					jr.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    		} finally {
    			if ( reader != null )
    				try {
    					reader.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    			
    		}
    	}
    	                       
        return _BatchTestDTO;
    }
    
    public BatchTestDTO unmarshal(JsonReader reader, BatchTestDTO dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(BatchTestDTO dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "key" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setKey( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "value" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setValue( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "servicename" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setServicename( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "jobId" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setJobId( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "jobName" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setJobName( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "jobDate" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setJobDate( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "jobExecutionId" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setJobExecutionId( reader.nextLong());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "batchCallType" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setBatchCallType( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "callType" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setCallType( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "stringValue" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setStringValue( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "longValue" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setLongValue( reader.nextLong());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "doubleValue" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setDoubleValue( reader.nextDouble());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "dateValue" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				try {
    					dto.setDateValue( new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss").parse(reader.nextString().trim()));
    				} catch(java.text.ParseException e) {
    					throw new MalformedJsonException("yyyy.MM.dd HH.mm.ss", e);
    				}
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "parameterType" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setParameterType( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "parameterName" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setParameterName( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "inputPath" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setInputPath( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "outputPath" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setOutputPath( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		default :
    		reader.skipValue();
    			break;
    	}
    }
    
    @Override
    public Object getDtoInstance() {        
       return new BatchTestDTO();
    }
        
}
