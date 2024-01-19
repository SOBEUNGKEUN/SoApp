package com.tmax.custom.systemcontext.dto;
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

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.message.MessageGenerator",
	date= "24. 1. 16. 오후 9:20"
)

@Message
public class SampleCacheDTOMsgJson extends AbstractMessage {
    public byte[] marshal(Object obj) throws MarshalException {
    	SampleCacheDTO _SampleCacheDTO = (SampleCacheDTO)obj;
    	
    	if (_SampleCacheDTO == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _SampleCacheDTO, jw);
    		
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
    
    
    public void marshal(com.tmax.custom.systemcontext.dto.SampleCacheDTO _SampleCacheDTO, JsonWriter writer )throws IOException {
    
    	writer.name("name"); 
    	if (_SampleCacheDTO.getName() != null) {
    		writer.value(_SampleCacheDTO.getName());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("key"); 
    	if (_SampleCacheDTO.getKey() != null) {
    		writer.value(_SampleCacheDTO.getKey());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("value"); 
    	if (_SampleCacheDTO.getValue() != null) {
    		writer.value(_SampleCacheDTO.getValue());
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
    
    
    public SampleCacheDTO unmarshal(byte[] bytes) throws UnmarshalException {
    	SampleCacheDTO _SampleCacheDTO = new SampleCacheDTO();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new SampleCacheDTO();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_SampleCacheDTO = (SampleCacheDTO)unmarshal( jr,  _SampleCacheDTO);
    
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
    	return _SampleCacheDTO;
    }
    	
    public Object unmarshal(byte[] bytes, SampleCacheDTO dto) throws UnmarshalException {
    	
    	SampleCacheDTO _SampleCacheDTO = (SampleCacheDTO) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new SampleCacheDTO();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_SampleCacheDTO = (SampleCacheDTO)unmarshal( jr,  _SampleCacheDTO);
    
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
    	                       
        return _SampleCacheDTO;
    }
    
    public SampleCacheDTO unmarshal(JsonReader reader, SampleCacheDTO dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(SampleCacheDTO dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "name" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setName( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
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
    		default :
    		reader.skipValue();
    			break;
    	}
    }
    
    @Override
    public Object getDtoInstance() {        
       return new SampleCacheDTO();
    }
        
}
