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
	date= "23. 12. 18. 오후 7:09"
)

@Message
public class ProHeaderMsgJson extends com.tmax.proobject.model.context.HeaderMsgJson {
    public byte[] marshal(Object obj) throws MarshalException {
    	ProHeader _ProHeader = (ProHeader)obj;
    	
    	if (_ProHeader == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _ProHeader, jw);
    		
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
    
    
    public void marshal(com.tmax.custom.header.ProHeader _ProHeader, JsonWriter writer )throws IOException {
    	super.marshal(_ProHeader, writer);
    
    	writer.name("name"); 
    	if (_ProHeader.getName() != null) {
    		writer.value(_ProHeader.getName());
    	} else {
    		writer.nullValue();
    	}
    	writer.name("enumber");
    	writer.value(_ProHeader.getEnumber());
    	writer.name("position"); 
    	if (_ProHeader.getPosition() != null) {
    		writer.value(_ProHeader.getPosition());
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
    
    
    public ProHeader unmarshal(byte[] bytes) throws UnmarshalException {
    	ProHeader _ProHeader = new ProHeader();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new ProHeader();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_ProHeader = (ProHeader)unmarshal( jr,  _ProHeader);
    
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
    	return _ProHeader;
    }
    	
    public Object unmarshal(byte[] bytes, ProHeader dto) throws UnmarshalException {
    	
    	ProHeader _ProHeader = (ProHeader) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new ProHeader();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_ProHeader = (ProHeader)unmarshal( jr,  _ProHeader);
    
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
    	                       
        return _ProHeader;
    }
    
    public ProHeader unmarshal(JsonReader reader, ProHeader dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(ProHeader dto, JsonReader reader, String name) throws IOException {
    	
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
    		case "enumber" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setEnumber( reader.nextInt());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "position" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setPosition( reader.nextString());
    			} else {
    				reader.nextNull();
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
       return new ProHeader();
    }
        
}
