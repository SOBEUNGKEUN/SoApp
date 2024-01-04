package com.tmax.custom.messagebundle.dto;
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
	date= "24. 1. 3. 오후 4:29"
)

@Message
public class messageDTOMsgJson extends AbstractMessage {
    public byte[] marshal(Object obj) throws MarshalException {
    	messageDTO _messageDTO = (messageDTO)obj;
    	
    	if (_messageDTO == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _messageDTO, jw);
    		
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
    
    
    public void marshal(com.tmax.custom.messagebundle.dto.messageDTO _messageDTO, JsonWriter writer )throws IOException {
    
    	writer.name("code"); 
    	if (_messageDTO.getCode() != null) {
    		writer.value(_messageDTO.getCode());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("name"); 
    	if (_messageDTO.getName() != null) {
    		writer.value(_messageDTO.getName());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("title"); 
    	if (_messageDTO.getTitle() != null) {
    		writer.value(_messageDTO.getTitle());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("type"); 
    	if (_messageDTO.getType() != null) {
    		writer.value(_messageDTO.getType());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("message"); 
    	if (_messageDTO.getMessage() != null) {
    		writer.value(_messageDTO.getMessage());
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
    
    
    public messageDTO unmarshal(byte[] bytes) throws UnmarshalException {
    	messageDTO _messageDTO = new messageDTO();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new messageDTO();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_messageDTO = (messageDTO)unmarshal( jr,  _messageDTO);
    
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
    	return _messageDTO;
    }
    	
    public Object unmarshal(byte[] bytes, messageDTO dto) throws UnmarshalException {
    	
    	messageDTO _messageDTO = (messageDTO) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new messageDTO();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_messageDTO = (messageDTO)unmarshal( jr,  _messageDTO);
    
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
    	                       
        return _messageDTO;
    }
    
    public messageDTO unmarshal(JsonReader reader, messageDTO dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(messageDTO dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "code" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setCode( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "name" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setName( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "title" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setTitle( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "type" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setType( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "message" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setMessage( reader.nextString());
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
       return new messageDTO();
    }
        
}
