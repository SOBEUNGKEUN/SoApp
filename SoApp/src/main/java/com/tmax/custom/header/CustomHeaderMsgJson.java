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
public class CustomHeaderMsgJson extends com.tmax.proobject.model.context.HeaderMsgJson {
    public byte[] marshal(Object obj) throws MarshalException {
    	CustomHeader _CustomHeader = (CustomHeader)obj;
    	
    	if (_CustomHeader == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _CustomHeader, jw);
    		
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
    
    
    public void marshal(com.tmax.custom.header.CustomHeader _CustomHeader, JsonWriter writer )throws IOException {
    	super.marshal(_CustomHeader, writer);
    
    	com.tmax.custom.header.ProHeaderMsgJson __ProHeader = new com.tmax.custom.header.ProHeaderMsgJson();	
    	writer.name("ProHeader");
    	if (_CustomHeader.getProHeader() != null) {
    	writer.beginObject();
    	__ProHeader.marshal((com.tmax.custom.header.ProHeader)_CustomHeader.getProHeader(), writer);
    	writer.endObject();
    	} else {
    		writer.nullValue();
    	}
    	com.tmax.custom.header.SysHeaderMsgJson __SysHeader = new com.tmax.custom.header.SysHeaderMsgJson();	
    	writer.name("SysHeader");
    	if (_CustomHeader.getSysHeader() != null) {
    	writer.beginObject();
    	__SysHeader.marshal((com.tmax.custom.header.SysHeader)_CustomHeader.getSysHeader(), writer);
    	writer.endObject();
    	} else {
    		writer.nullValue();
    	}
    	com.tmax.custom.header.ErrorHeaderMsgJson __ErrorHeader = new com.tmax.custom.header.ErrorHeaderMsgJson();	
    	writer.name("ErrorHeader");
    	if (_CustomHeader.getErrorHeader() != null) {
    	writer.beginObject();
    	__ErrorHeader.marshal((com.tmax.custom.header.ErrorHeader)_CustomHeader.getErrorHeader(), writer);
    	writer.endObject();
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
    
    
    public CustomHeader unmarshal(byte[] bytes) throws UnmarshalException {
    	CustomHeader _CustomHeader = new CustomHeader();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new CustomHeader();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_CustomHeader = (CustomHeader)unmarshal( jr,  _CustomHeader);
    
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
    	return _CustomHeader;
    }
    	
    public Object unmarshal(byte[] bytes, CustomHeader dto) throws UnmarshalException {
    	
    	CustomHeader _CustomHeader = (CustomHeader) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new CustomHeader();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_CustomHeader = (CustomHeader)unmarshal( jr,  _CustomHeader);
    
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
    	                       
        return _CustomHeader;
    }
    
    public CustomHeader unmarshal(JsonReader reader, CustomHeader dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(CustomHeader dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "ProHeader" :
    		{	
    			if (reader.peek() == JsonToken.NULL) {
    				reader.nextNull();
    			} else {
    				com.tmax.custom.header.ProHeaderMsgJson __ProHeader = new com.tmax.custom.header.ProHeaderMsgJson();
    				com.tmax.custom.header.ProHeader ___ProHeader = new com.tmax.custom.header.ProHeader();
    				reader.beginObject();
    				dto.setProHeader((com.tmax.custom.header.ProHeader)__ProHeader.unmarshal( reader, ___ProHeader ));
    				reader.endObject();
    			}
    			break;
    		}
    		case "SysHeader" :
    		{	
    			if (reader.peek() == JsonToken.NULL) {
    				reader.nextNull();
    			} else {
    				com.tmax.custom.header.SysHeaderMsgJson __SysHeader = new com.tmax.custom.header.SysHeaderMsgJson();
    				com.tmax.custom.header.SysHeader ___SysHeader = new com.tmax.custom.header.SysHeader();
    				reader.beginObject();
    				dto.setSysHeader((com.tmax.custom.header.SysHeader)__SysHeader.unmarshal( reader, ___SysHeader ));
    				reader.endObject();
    			}
    			break;
    		}
    		case "ErrorHeader" :
    		{	
    			if (reader.peek() == JsonToken.NULL) {
    				reader.nextNull();
    			} else {
    				com.tmax.custom.header.ErrorHeaderMsgJson __ErrorHeader = new com.tmax.custom.header.ErrorHeaderMsgJson();
    				com.tmax.custom.header.ErrorHeader ___ErrorHeader = new com.tmax.custom.header.ErrorHeader();
    				reader.beginObject();
    				dto.setErrorHeader((com.tmax.custom.header.ErrorHeader)__ErrorHeader.unmarshal( reader, ___ErrorHeader ));
    				reader.endObject();
    			}
    			break;
    		}
    		default :
    		super.setField(dto, reader, name);
    			break;
    	}
    }
    
    @Override
    public Object getDtoInstance() {        
       return new CustomHeader();
    }
        
}
