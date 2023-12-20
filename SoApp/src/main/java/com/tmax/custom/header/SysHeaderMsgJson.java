package com.tmax.custom.header;
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
	date= "23. 12. 19. 오후 2:00"
)

@Message
public class SysHeaderMsgJson extends AbstractMessage {
    public byte[] marshal(Object obj) throws MarshalException {
    	SysHeader _SysHeader = (SysHeader)obj;
    	
    	if (_SysHeader == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _SysHeader, jw);
    		
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
    
    
    public void marshal(com.tmax.custom.header.SysHeader _SysHeader, JsonWriter writer )throws IOException {
    
    	writer.name("ip"); 
    	if (_SysHeader.getIp() != null) {
    		writer.value(_SysHeader.getIp());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("userId"); 
    	if (_SysHeader.getUserId() != null) {
    		writer.value(_SysHeader.getUserId());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("userPwd"); 
    	if (_SysHeader.getUserPwd() != null) {
    		writer.value(_SysHeader.getUserPwd());
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
    
    
    public SysHeader unmarshal(byte[] bytes) throws UnmarshalException {
    	SysHeader _SysHeader = new SysHeader();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new SysHeader();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_SysHeader = (SysHeader)unmarshal( jr,  _SysHeader);
    
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
    	return _SysHeader;
    }
    	
    public Object unmarshal(byte[] bytes, SysHeader dto) throws UnmarshalException {
    	
    	SysHeader _SysHeader = (SysHeader) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new SysHeader();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_SysHeader = (SysHeader)unmarshal( jr,  _SysHeader);
    
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
    	                       
        return _SysHeader;
    }
    
    public SysHeader unmarshal(JsonReader reader, SysHeader dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(SysHeader dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "ip" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setIp( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "userId" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setUserId( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "userPwd" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setUserPwd( reader.nextString());
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
       return new SysHeader();
    }
        
}
