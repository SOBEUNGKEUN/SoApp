package com.tmax.custom.sample.dto;
import com.tmax.proobject.model.message.AbstractXmlMessage;
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
import java.io.InputStream;
import org.w3c.dom.Node;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import com.tmax.proobject.model.message.util.xml.stax.ProObjectStreamXMLConstants;

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.message.MessageGenerator",
	date= "24. 1. 24. 오전 11:58"
)

@Message
public class SampleOUTDTOMsgXml extends AbstractXmlMessage {
    private static java.text.DecimalFormat nf =  (java.text.DecimalFormat)java.text.NumberFormat.getInstance();
    static XMLOutputFactory outputFactory = new com.ctc.wstx.stax.WstxOutputFactory();
    static XMLInputFactory inputFactory = new com.ctc.wstx.stax.WstxInputFactory();
    static {
        inputFactory.setProperty( XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
    }
    /* marshall method */
    public byte[] marshal(Object obj) throws MarshalException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        XMLStreamWriter writer = null;
        try {
            if (encoding != null)
                writer = outputFactory.createXMLStreamWriter(new BufferedWriter(new OutputStreamWriter(bout, encoding)));
            else
                writer = outputFactory.createXMLStreamWriter(bout);     
            com.tmax.custom.sample.dto.SampleOUTDTO _SampleOUTDTO = (com.tmax.custom.sample.dto.SampleOUTDTO)obj;
            if (encoding != null)
                writer.writeStartDocument(encoding, "1.0");
            else
                writer.writeStartDocument();
            writer.writeCharacters("\n");
            marshal(_SampleOUTDTO, writer, "");
            writer.writeEndDocument();
            writer.flush();
            return bout.toByteArray();
        } catch(Exception e) {
            throw new MarshalException(e);
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (XMLStreamException ignore) {// ignore
                }
            }
            
            if(bout != null) {
                try {
                    bout.close();
                } catch (IOException ignore) { // ignore
                }
            }
        }
    }
    
    public byte[] marshalWithoutStartDocument(Object obj) throws MarshalException {
        //This method doesn't writes a start document tag and dosen't write Namespace declaration.
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        XMLStreamWriter writer = null;
        try {
            if (encoding != null)
                writer = outputFactory.createXMLStreamWriter(new BufferedWriter(new OutputStreamWriter(bout, encoding)));
            else
                writer = outputFactory.createXMLStreamWriter(bout);     
            com.tmax.custom.sample.dto.SampleOUTDTO _SampleOUTDTO = (com.tmax.custom.sample.dto.SampleOUTDTO)obj;
            //do NOT  writeStartDocument
            marshalWithoutNamespace(_SampleOUTDTO, writer);
            //do NOT  writeEndDocument
            writer.flush();
            return bout.toByteArray();
        } catch(Exception e) {
            throw new MarshalException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (XMLStreamException ignore) { // ignore
                }
            }
            
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException ignore) { // ignore
                }
            }
        }
    }
    
    public void marshal(com.tmax.custom.sample.dto.SampleOUTDTO _SampleOUTDTO, XMLStreamWriter writer, String namespace) throws XMLStreamException {         
        writer.writeStartElement("SampleOUTDTO");
        if (namespace.trim().length() != 0) {
            writer.setDefaultNamespace(namespace);
            writer.writeDefaultNamespace(namespace);
        }    
        writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        marshalXmlBody(_SampleOUTDTO, writer, namespace);
        writer.writeEndElement();
    }
    
    public void marshalWithoutNamespace(com.tmax.custom.sample.dto.SampleOUTDTO _SampleOUTDTO, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("SampleOUTDTO");
        marshalXmlBodyWithoutNameSpace(_SampleOUTDTO, writer);
        writer.writeEndElement();
    }
    
    public void marshalXmlBodyWithoutNameSpace(Object obj, XMLStreamWriter writer) throws XMLStreamException{
        com.tmax.custom.sample.dto.SampleOUTDTO _SampleOUTDTO = (com.tmax.custom.sample.dto.SampleOUTDTO)obj;
        marshalXmlBodyWithoutNameSpace(_SampleOUTDTO, writer);
    }
    
    public void marshalXmlBodyWithoutNameSpace(com.tmax.custom.sample.dto.SampleOUTDTO  _SampleOUTDTO, XMLStreamWriter writer) throws XMLStreamException{ 
        nf.setMaximumFractionDigits(340);
        nf.setGroupingUsed(false);
        writer.writeCharacters("\n");
        
        /** empno */
        writer.writeStartElement("empno"); 
        writer.writeCharacters(Integer.toString(_SampleOUTDTO.getEmpno()));
        writer.writeEndElement();
        writer.writeCharacters("\n");
        /** ename */
        writer.writeStartElement("ename"); 
        if (_SampleOUTDTO.getEname() != null ) {
            writer.writeCharacters(removeNullChar(_SampleOUTDTO.getEname()));
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
    }
    
    public void marshalXmlBody(Object target, XMLStreamWriter writer, String namespace) throws XMLStreamException{
        com.tmax.custom.sample.dto.SampleOUTDTO _SampleOUTDTO = (com.tmax.custom.sample.dto.SampleOUTDTO) target;
        nf.setMaximumFractionDigits(340);
        nf.setGroupingUsed(false);
        writer.writeCharacters("\n");
        if(namespace.length() != 0) {
            writer.writeStartElement(namespace, "empno");
        } else {
            writer.writeStartElement("empno");
        }
        writer.writeCharacters(Integer.toString(_SampleOUTDTO.getEmpno()));
        writer.writeEndElement();
        writer.writeCharacters("\n");
        if(namespace.length() != 0) {
            writer.writeStartElement(namespace, "ename");
        } else {
            writer.writeStartElement("ename");
        }
        if (_SampleOUTDTO.getEname() == null) {
            writer.writeAttribute("xsi", NS_XSI, "nil", "true");
        } else {
            writer.writeCharacters(removeNullChar(_SampleOUTDTO.getEname()));
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
    }
    
    public void marshal(Object obj, Node domOut) {
        return;
    }
    
    public String removeNullChar(String charString) {
        if( charString == null )
            return "";
            
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i<charString.length(); i++) {
            if(charString.charAt(i) == (char)0) {
                sb.append("");
            } else {
                sb.append(charString.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public SampleOUTDTO unmarshal(byte[] message) throws UnmarshalException {
        InputStream bin = new ByteArrayInputStream(message);
        XMLStreamReader reader = null;
        try {
            if (encoding != null) {
                reader = inputFactory.createXMLStreamReader(new BufferedReader(new InputStreamReader(bin, encoding)));
            } else {
                reader = inputFactory.createXMLStreamReader(bin);
            }
            return unmarshal(reader, "SampleOUTDTO", true);
        } catch(Exception e) {
            throw new UnmarshalException(e);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException ignore) { // ignore
                }
            }
            
            if(bin != null) {
                try {
                    bin.close();
                } catch (IOException ignore) { // ignore
                }
            }
        }
    }
    
    public SampleOUTDTO unmarshal(InputStream bin) throws UnmarshalException {
        XMLStreamReader reader = null;
        try {
            if (encoding != null)
                reader = inputFactory.createXMLStreamReader(new BufferedReader(new InputStreamReader(bin, encoding)));
            else
                reader = inputFactory.createXMLStreamReader(bin);
        
            return unmarshal(reader, "SampleOUTDTO", true);
        } catch(Exception e) {
            throw new UnmarshalException(e);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException ignore) { // ignore
                }
            }
        }
    }
    
    
    public SampleOUTDTO unmarshal(XMLStreamReader reader, String rootElementName) throws XMLStreamException {
        return unmarshal(reader, "SampleOUTDTO", false);
    }
    
    @Override
    public SampleOUTDTO unmarshal(XMLStreamReader reader, String rootElementName, boolean skipHeader) throws XMLStreamException {
          com.tmax.custom.sample.dto.SampleOUTDTO  _SampleOUTDTO = new com.tmax.custom.sample.dto.SampleOUTDTO();
          java.util.Map<String, String> messageFieldNameList = new java.util.HashMap<>();
          //XML message does NOT support dtoStart, dtoEnd field.  use Complex type, instead.
          messageFieldNameList.put("empno","0");
          messageFieldNameList.put("ename","1");
          boolean isCharacterSection = false;
          boolean isStartElement = false;
        
          int fieldNumber = 0, numberOfStartElement = 0;
          int eventType = 0;
          
          int pfmHeaderStack= -1;
          int sysHeaderStack= -1;
          String localName= "";
        
          boolean isSelfClose = false;
          boolean isStartEle = false;
          boolean isEndEle = false;
            
          com.ctc.wstx.sr.ValidatingStreamReader sr = (com.ctc.wstx.sr.ValidatingStreamReader)reader;
          
          while ( reader.hasNext() ) {
              if ( (pfmHeaderStack== 2 && sysHeaderStack== 2) || skipHeader ) {
                  eventType = reader.getEventType();
                  switch(eventType) {
                      case XMLStreamConstants.START_ELEMENT:
                          isCharacterSection =false;
                          isStartElement = true;
                          numberOfStartElement++;
        
                          isSelfClose = sr.isEmptyElement();
        
                          if (messageFieldNameList.containsKey(reader.getLocalName())) {
                              fieldNumber = Integer.parseInt((String)messageFieldNameList.get(reader.getLocalName()));
                          } else {
                              fieldNumber = -1;
                          }
                          if (fieldNumber == -1 ) {
                              if (reader.getLocalName().equals(rootElementName)) {
                                  break;
                              } else {
                                  break;
                                  //throw new XMLStreamException("Unexpected element : " + reader.getLocalName() +"; ");
                              }
                          } else {
                              String nil = reader.getAttributeValue(NS_XSI, "nil");
                              if (nil == null || nil.equals("false")) {
                              } else {
                                  switch(fieldNumber) {
                                      case 0 : _SampleOUTDTO.setEmpno((Integer)null); isCharacterSection=true;break;
                                      case 1 : _SampleOUTDTO.setEname((String)null); isCharacterSection=true;break;
                                      default: break;
                                  }
                              }
                          }
                          break;
                      case XMLStreamConstants.CHARACTERS:
                          isCharacterSection = true;
                          if ( isStartElement ) {
                              switch(fieldNumber) {
                                  case 0 : _SampleOUTDTO.setEmpno(Integer.parseInt(reader.getText().trim())); break;
                                  case 1 : _SampleOUTDTO.setEname(reader.getText()); break;
                                  default: break;
                              }
                          }
                          break;
                      case XMLStreamConstants.END_ELEMENT :
                          isStartElement = false;
                          numberOfStartElement--;
                          if (numberOfStartElement > 0 || !isCharacterSection) {
                              if (!isCharacterSection) {
                                  switch (fieldNumber) {
                                      case 0 : _SampleOUTDTO.setEmpno((Integer)null); isCharacterSection=true; break;
                                      case 1 : _SampleOUTDTO.setEname((String)""); isCharacterSection=true; break;
                                      default: isCharacterSection=true; break;
                                  }
                              }
                          }
                          if (reader.getLocalName().equals(rootElementName)) {
                              return _SampleOUTDTO;
                          }
                          break;
                      default:
                          break;
                  }
              } else {
                  eventType= reader.getEventType();
                  switch( eventType)
                  {
                      case XMLStreamConstants.START_ELEMENT:
                          localName= reader.getLocalName();
                          if( pfmHeaderStack== -1 && ProObjectStreamXMLConstants.PROOBJECTHEADER_ELEMENT.equals( localName))
                              pfmHeaderStack= 1;
                          else if( sysHeaderStack== -1 && ProObjectStreamXMLConstants.SYSTEMHEADER_ELEMENT.equals( localName))
                              sysHeaderStack= 1;
                          break;
                      case XMLStreamConstants.END_ELEMENT:
                          localName= reader.getLocalName();
                          if( pfmHeaderStack== 1 && ProObjectStreamXMLConstants.PROOBJECTHEADER_ELEMENT.equals( localName))
                              pfmHeaderStack= 0;
                          else if(sysHeaderStack== 1 && ProObjectStreamXMLConstants.SYSTEMHEADER_ELEMENT.equals( localName))
                              sysHeaderStack= 0;
                          localName= null;
                          break;
                      default:
                          break;
                  }
                  if (pfmHeaderStack== 0) {
                      pfmHeaderStack= 2;
                  }
                  if (sysHeaderStack== 0) {
                      sysHeaderStack= 2;
                  }
              }
              if (reader.hasNext())
                  reader.next(); 
          }
          return _SampleOUTDTO;
    }
    
    public SampleOUTDTO unmarshal(XMLStreamReader reader, String rootElementName, com.tmax.custom.sample.dto.SampleOUTDTO  _SampleOUTDTO) throws XMLStreamException {
          java.util.Map<String, String> messageFieldNameList = new java.util.HashMap<>();
          //XML message does NOT support dtoStart, dtoEnd field.  use Complex type, instead.
          messageFieldNameList.put("empno","0");
          messageFieldNameList.put("ename","1");
          boolean isCharacterSection = false;
          boolean isStartElement = false;
          boolean isSelfClose = false;
          
          int fieldNumber = 0, numberOfStartElement = 0;
          int eventType = 0;
        
          while( reader.hasNext() ) {
              eventType = reader.getEventType();
              switch(eventType) {
                  case XMLStreamConstants.START_ELEMENT:
                      isCharacterSection =false;
                      isStartElement = true;
                      numberOfStartElement++;
                      if (messageFieldNameList.containsKey(reader.getLocalName())) {
                          fieldNumber = Integer.parseInt((String)messageFieldNameList.get(reader.getLocalName()));
                      } else {
                          fieldNumber = -1;
                      }
                      if(fieldNumber == -1 ) {
                          if(reader.getLocalName().equals(rootElementName)) {
                              break;
                          } else {
                              return _SampleOUTDTO;
                          }
                      } else {
                          String nil = reader.getAttributeValue(NS_XSI, "nil");
                          if (nil == null || nil.equals("false")) {
                          } else {
                              switch(fieldNumber) {
                                  case 0 : _SampleOUTDTO.setEmpno((Integer)null); isCharacterSection=true;break;
                                  case 1 : _SampleOUTDTO.setEname((String)null); isCharacterSection=true;break;
                                  default: break;
                              }
                          }
                      }
                      break;
                  case XMLStreamConstants.CHARACTERS:
                      isCharacterSection = true;
                      if ( isStartElement ) {
                          switch(fieldNumber) {
                              case 0 : _SampleOUTDTO.setEmpno(Integer.parseInt(reader.getText().trim())); break;
                              case 1 : _SampleOUTDTO.setEname(reader.getText()); break;
                              default: break;
                          }
                      }
                      break;
                  case XMLStreamConstants.END_ELEMENT :
                      isStartElement = false;
                      numberOfStartElement--;
                      if (numberOfStartElement > 0 || !isCharacterSection) {
                          if (!isCharacterSection) {
                              switch(fieldNumber) {
                                  case 0 : _SampleOUTDTO.setEmpno((Integer)null); isCharacterSection=true; break;
                                  case 1 : _SampleOUTDTO.setEname((String)""); isCharacterSection=true; break;
                                  default: isCharacterSection=true; break;
                              }
                          }
                      }
                      if (reader.getLocalName().equals(rootElementName) || numberOfStartElement == 0) {
                          return _SampleOUTDTO;
                      }
                      break;
                  default:
                      break;
              }
              reader.next();
          }
          
          return _SampleOUTDTO;
    }
    
    public SampleOUTDTO unmarshal(byte[] msg, int offset) throws UnmarshalException {
        return null;
    }
    
    public int unmarshal(byte[] msg, int offset, Object obj) throws UnmarshalException {
        return -1;
    }
    
    public SampleOUTDTO unmarshal(Node message) throws Exception{
    	return null;
    }
}
