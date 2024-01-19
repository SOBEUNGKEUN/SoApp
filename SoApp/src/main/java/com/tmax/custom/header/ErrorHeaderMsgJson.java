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
	date= "24. 1. 10. 오전 11:07"
)

@Message
public class ErrorHeaderMsgJson extends AbstractMessage {
    public byte[] marshal(Object obj) throws MarshalException {
    	ErrorHeader _ErrorHeader = (ErrorHeader)obj;
    	
    	if (_ErrorHeader == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _ErrorHeader, jw);
    		
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
    
    
    public void marshal(com.tmax.custom.header.ErrorHeader _ErrorHeader, JsonWriter writer )throws IOException {
    
    	writer.name("responseCode"); 
    	if (_ErrorHeader.getResponseCode() != null) {
    		writer.value(_ErrorHeader.getResponseCode());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("responseType"); 
    	if (_ErrorHeader.getResponseType() != null) {
    		writer.value(_ErrorHeader.getResponseType());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("responseTitle"); 
    	if (_ErrorHeader.getResponseTitle() != null) {
    		writer.value(_ErrorHeader.getResponseTitle());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("responseBasic"); 
    	if (_ErrorHeader.getResponseBasic() != null) {
    		writer.value(_ErrorHeader.getResponseBasic());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("responseDtal"); 
    	if (_ErrorHeader.getResponseDtal() != null) {
    		writer.value(_ErrorHeader.getResponseDtal());
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
    
    
    public ErrorHeader unmarshal(byte[] bytes) throws UnmarshalException {
    	ErrorHeader _ErrorHeader = new ErrorHeader();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new ErrorHeader();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_ErrorHeader = (ErrorHeader)unmarshal( jr,  _ErrorHeader);
    
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
    	return _ErrorHeader;
    }
    	
    public Object unmarshal(byte[] bytes, ErrorHeader dto) throws UnmarshalException {
    	
    	ErrorHeader _ErrorHeader = (ErrorHeader) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new ErrorHeader();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_ErrorHeader = (ErrorHeader)unmarshal( jr,  _ErrorHeader);
    
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
    	                       
        return _ErrorHeader;
    }
    
    public ErrorHeader unmarshal(JsonReader reader, ErrorHeader dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(ErrorHeader dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "responseCode" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setResponseCode( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "responseType" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setResponseType( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "responseTitle" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setResponseTitle( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "responseBasic" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setResponseBasic( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "responseDtal" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setResponseDtal( reader.nextString());
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
       return new ErrorHeader();
    }
        
}
