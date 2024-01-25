package com.tmax.custom.header;
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
public class SysHeaderMsgXml extends AbstractXmlMessage {
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
            com.tmax.custom.header.SysHeader _SysHeader = (com.tmax.custom.header.SysHeader)obj;
            if (encoding != null)
                writer.writeStartDocument(encoding, "1.0");
            else
                writer.writeStartDocument();
            writer.writeCharacters("\n");
            marshal(_SysHeader, writer, "");
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
            com.tmax.custom.header.SysHeader _SysHeader = (com.tmax.custom.header.SysHeader)obj;
            //do NOT  writeStartDocument
            marshalWithoutNamespace(_SysHeader, writer);
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
    
    public void marshal(com.tmax.custom.header.SysHeader _SysHeader, XMLStreamWriter writer, String namespace) throws XMLStreamException {         
        writer.writeStartElement("SysHeader");
        if (namespace.trim().length() != 0) {
            writer.setDefaultNamespace(namespace);
            writer.writeDefaultNamespace(namespace);
        }    
        writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        marshalXmlBody(_SysHeader, writer, namespace);
        writer.writeEndElement();
    }
    
    public void marshalWithoutNamespace(com.tmax.custom.header.SysHeader _SysHeader, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("SysHeader");
        marshalXmlBodyWithoutNameSpace(_SysHeader, writer);
        writer.writeEndElement();
    }
    
    public void marshalXmlBodyWithoutNameSpace(Object obj, XMLStreamWriter writer) throws XMLStreamException{
        com.tmax.custom.header.SysHeader _SysHeader = (com.tmax.custom.header.SysHeader)obj;
        marshalXmlBodyWithoutNameSpace(_SysHeader, writer);
    }
    
    public void marshalXmlBodyWithoutNameSpace(com.tmax.custom.header.SysHeader  _SysHeader, XMLStreamWriter writer) throws XMLStreamException{ 
        nf.setMaximumFractionDigits(340);
        nf.setGroupingUsed(false);
        writer.writeCharacters("\n");
        
        /** ip */
        writer.writeStartElement("ip"); 
        if (_SysHeader.getIp() != null ) {
            writer.writeCharacters(removeNullChar(_SysHeader.getIp()));
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
        /** userId */
        writer.writeStartElement("userId"); 
        if (_SysHeader.getUserId() != null ) {
            writer.writeCharacters(removeNullChar(_SysHeader.getUserId()));
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
        /** userPwd */
        writer.writeStartElement("userPwd"); 
        if (_SysHeader.getUserPwd() != null ) {
            writer.writeCharacters(removeNullChar(_SysHeader.getUserPwd()));
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
    }
    
    public void marshalXmlBody(Object target, XMLStreamWriter writer, String namespace) throws XMLStreamException{
        com.tmax.custom.header.SysHeader _SysHeader = (com.tmax.custom.header.SysHeader) target;
        nf.setMaximumFractionDigits(340);
        nf.setGroupingUsed(false);
        writer.writeCharacters("\n");
        if(namespace.length() != 0) {
            writer.writeStartElement(namespace, "ip");
        } else {
            writer.writeStartElement("ip");
        }
        if (_SysHeader.getIp() == null) {
            writer.writeAttribute("xsi", NS_XSI, "nil", "true");
        } else {
            writer.writeCharacters(removeNullChar(_SysHeader.getIp()));
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
        if(namespace.length() != 0) {
            writer.writeStartElement(namespace, "userId");
        } else {
            writer.writeStartElement("userId");
        }
        if (_SysHeader.getUserId() == null) {
            writer.writeAttribute("xsi", NS_XSI, "nil", "true");
        } else {
            writer.writeCharacters(removeNullChar(_SysHeader.getUserId()));
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
        if(namespace.length() != 0) {
            writer.writeStartElement(namespace, "userPwd");
        } else {
            writer.writeStartElement("userPwd");
        }
        if (_SysHeader.getUserPwd() == null) {
            writer.writeAttribute("xsi", NS_XSI, "nil", "true");
        } else {
            writer.writeCharacters(removeNullChar(_SysHeader.getUserPwd()));
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
    
    public SysHeader unmarshal(byte[] message) throws UnmarshalException {
        InputStream bin = new ByteArrayInputStream(message);
        XMLStreamReader reader = null;
        try {
            if (encoding != null) {
                reader = inputFactory.createXMLStreamReader(new BufferedReader(new InputStreamReader(bin, encoding)));
            } else {
                reader = inputFactory.createXMLStreamReader(bin);
            }
            return unmarshal(reader, "SysHeader", true);
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
    
    public SysHeader unmarshal(InputStream bin) throws UnmarshalException {
        XMLStreamReader reader = null;
        try {
            if (encoding != null)
                reader = inputFactory.createXMLStreamReader(new BufferedReader(new InputStreamReader(bin, encoding)));
            else
                reader = inputFactory.createXMLStreamReader(bin);
        
            return unmarshal(reader, "SysHeader", true);
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
    
    
    public SysHeader unmarshal(XMLStreamReader reader, String rootElementName) throws XMLStreamException {
        return unmarshal(reader, "SysHeader", false);
    }
    
    @Override
    public SysHeader unmarshal(XMLStreamReader reader, String rootElementName, boolean skipHeader) throws XMLStreamException {
          com.tmax.custom.header.SysHeader  _SysHeader = new com.tmax.custom.header.SysHeader();
          java.util.Map<String, String> messageFieldNameList = new java.util.HashMap<>();
          //XML message does NOT support dtoStart, dtoEnd field.  use Complex type, instead.
          messageFieldNameList.put("ip","0");
          messageFieldNameList.put("userId","1");
          messageFieldNameList.put("userPwd","2");
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
                                      case 0 : _SysHeader.setIp((String)null); isCharacterSection=true;break;
                                      case 1 : _SysHeader.setUserId((String)null); isCharacterSection=true;break;
                                      case 2 : _SysHeader.setUserPwd((String)null); isCharacterSection=true;break;
                                      default: break;
                                  }
                              }
                          }
                          break;
                      case XMLStreamConstants.CHARACTERS:
                          isCharacterSection = true;
                          if ( isStartElement ) {
                              switch(fieldNumber) {
                                  case 0 : _SysHeader.setIp(reader.getText()); break;
                                  case 1 : _SysHeader.setUserId(reader.getText()); break;
                                  case 2 : _SysHeader.setUserPwd(reader.getText()); break;
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
                                      case 0 : _SysHeader.setIp((String)""); isCharacterSection=true; break;
                                      case 1 : _SysHeader.setUserId((String)""); isCharacterSection=true; break;
                                      case 2 : _SysHeader.setUserPwd((String)""); isCharacterSection=true; break;
                                      default: isCharacterSection=true; break;
                                  }
                              }
                          }
                          if (reader.getLocalName().equals(rootElementName)) {
                              return _SysHeader;
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
          return _SysHeader;
    }
    
    public SysHeader unmarshal(XMLStreamReader reader, String rootElementName, com.tmax.custom.header.SysHeader  _SysHeader) throws XMLStreamException {
          java.util.Map<String, String> messageFieldNameList = new java.util.HashMap<>();
          //XML message does NOT support dtoStart, dtoEnd field.  use Complex type, instead.
          messageFieldNameList.put("ip","0");
          messageFieldNameList.put("userId","1");
          messageFieldNameList.put("userPwd","2");
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
                              return _SysHeader;
                          }
                      } else {
                          String nil = reader.getAttributeValue(NS_XSI, "nil");
                          if (nil == null || nil.equals("false")) {
                          } else {
                              switch(fieldNumber) {
                                  case 0 : _SysHeader.setIp((String)null); isCharacterSection=true;break;
                                  case 1 : _SysHeader.setUserId((String)null); isCharacterSection=true;break;
                                  case 2 : _SysHeader.setUserPwd((String)null); isCharacterSection=true;break;
                                  default: break;
                              }
                          }
                      }
                      break;
                  case XMLStreamConstants.CHARACTERS:
                      isCharacterSection = true;
                      if ( isStartElement ) {
                          switch(fieldNumber) {
                              case 0 : _SysHeader.setIp(reader.getText()); break;
                              case 1 : _SysHeader.setUserId(reader.getText()); break;
                              case 2 : _SysHeader.setUserPwd(reader.getText()); break;
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
                                  case 0 : _SysHeader.setIp((String)""); isCharacterSection=true; break;
                                  case 1 : _SysHeader.setUserId((String)""); isCharacterSection=true; break;
                                  case 2 : _SysHeader.setUserPwd((String)""); isCharacterSection=true; break;
                                  default: isCharacterSection=true; break;
                              }
                          }
                      }
                      if (reader.getLocalName().equals(rootElementName) || numberOfStartElement == 0) {
                          return _SysHeader;
                      }
                      break;
                  default:
                      break;
              }
              reader.next();
          }
          
          return _SysHeader;
    }
    
    public SysHeader unmarshal(byte[] msg, int offset) throws UnmarshalException {
        return null;
    }
    
    public int unmarshal(byte[] msg, int offset, Object obj) throws UnmarshalException {
        return -1;
    }
    
    public SysHeader unmarshal(Node message) throws Exception{
    	return null;
    }
}
