package com.tmax.custom.sample.dto;
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
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.message.MessageGenerator",
	date= "24. 1. 16. 오후 3:45"
)

@Message
public class SampleMultiDTOMsgJson extends AbstractMessage {
    public byte[] marshal(Object obj) throws MarshalException {
    	SampleMultiDTO _SampleMultiDTO = (SampleMultiDTO)obj;
    	
    	if (_SampleMultiDTO == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _SampleMultiDTO, jw);
    		
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
    
    
    public void marshal(com.tmax.custom.sample.dto.SampleMultiDTO _SampleMultiDTO, JsonWriter writer )throws IOException {
    
    	writer.name("input");
    	if (_SampleMultiDTO.getInput() == null) {
    		writer.nullValue();
    	} else {
                                            int compareSize0 = (Integer)_SampleMultiDTO.getArraysize() == null ? 0 : _SampleMultiDTO.getArraysize();
    
    int arraySize0 = _SampleMultiDTO.getInput().size() < compareSize0 ? _SampleMultiDTO.getInput().size() : compareSize0;
    		com.tmax.custom.sample.dto.SampleDTOMsgJson __input = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
    		writer.beginArray();					
    		for (int i = 0; i < arraySize0; i++) {
    			if (_SampleMultiDTO.getInput().get(i) != null) {
    				writer.beginObject();
    				__input.marshal((com.tmax.custom.sample.dto.SampleDTO)_SampleMultiDTO.getInput().get(i), writer);
    				writer.endObject();
    			} else {
    				writer.nullValue();
    			}
    		}
    		writer.endArray();
    	}
    	writer.name("arraysize");
    	writer.value(_SampleMultiDTO.getArraysize());
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
    
    
    public SampleMultiDTO unmarshal(byte[] bytes) throws UnmarshalException {
    	SampleMultiDTO _SampleMultiDTO = new SampleMultiDTO();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new SampleMultiDTO();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_SampleMultiDTO = (SampleMultiDTO)unmarshal( jr,  _SampleMultiDTO);
    
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
    	return _SampleMultiDTO;
    }
    	
    public Object unmarshal(byte[] bytes, SampleMultiDTO dto) throws UnmarshalException {
    	
    	SampleMultiDTO _SampleMultiDTO = (SampleMultiDTO) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new SampleMultiDTO();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_SampleMultiDTO = (SampleMultiDTO)unmarshal( jr,  _SampleMultiDTO);
    
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
    	                       
        return _SampleMultiDTO;
    }
    
    public SampleMultiDTO unmarshal(JsonReader reader, SampleMultiDTO dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(SampleMultiDTO dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "input" :
    		{
    			if (reader.peek() != JsonToken.NULL) {
    				reader.beginArray();
    				List<com.tmax.custom.sample.dto.SampleDTO> array = new ArrayList<>();
    				com.tmax.custom.sample.dto.SampleDTOMsgJson __input = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
    				while( reader.hasNext() ){	
    					if (reader.peek() != JsonToken.NULL) {
    						com.tmax.custom.sample.dto.SampleDTO ___SampleDTO = new com.tmax.custom.sample.dto.SampleDTO();
    						reader.beginObject();
    						array.add((com.tmax.custom.sample.dto.SampleDTO)__input.unmarshal( reader, ___SampleDTO ));
    						reader.endObject();
    					} else {
    						reader.nextNull();
    					}
    				}
    				dto.setInput(array);
    				reader.endArray();
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}
    		case "arraysize" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setArraysize( reader.nextInt());
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
       return new SampleMultiDTO();
    }
        
}
