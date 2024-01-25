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
public class CustomHeaderMsgXml extends com.tmax.proobject.model.context.HeaderMsgXml {
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
            com.tmax.custom.header.CustomHeader _CustomHeader = (com.tmax.custom.header.CustomHeader)obj;
            if (encoding != null)
                writer.writeStartDocument(encoding, "1.0");
            else
                writer.writeStartDocument();
            writer.writeCharacters("\n");
            marshal(_CustomHeader, writer, "");
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
            com.tmax.custom.header.CustomHeader _CustomHeader = (com.tmax.custom.header.CustomHeader)obj;
            //do NOT  writeStartDocument
            marshalWithoutNamespace(_CustomHeader, writer);
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
    
    public void marshal(com.tmax.custom.header.CustomHeader _CustomHeader, XMLStreamWriter writer, String namespace) throws XMLStreamException {         
        writer.writeStartElement("CustomHeader");
        if (namespace.trim().length() != 0) {
            writer.setDefaultNamespace(namespace);
            writer.writeDefaultNamespace(namespace);
        }    
        writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        marshalXmlBody(_CustomHeader, writer, namespace);
        writer.writeEndElement();
    }
    
    public void marshalWithoutNamespace(com.tmax.custom.header.CustomHeader _CustomHeader, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("CustomHeader");
        marshalXmlBodyWithoutNameSpace(_CustomHeader, writer);
        writer.writeEndElement();
    }
    
    public void marshalXmlBodyWithoutNameSpace(Object obj, XMLStreamWriter writer) throws XMLStreamException{
        com.tmax.custom.header.CustomHeader _CustomHeader = (com.tmax.custom.header.CustomHeader)obj;
        marshalXmlBodyWithoutNameSpace(_CustomHeader, writer);
    }
    
    public void marshalXmlBodyWithoutNameSpace(com.tmax.custom.header.CustomHeader  _CustomHeader, XMLStreamWriter writer) throws XMLStreamException{ 
        nf.setMaximumFractionDigits(340);
        nf.setGroupingUsed(false);
        super.marshalXmlBodyWithoutNameSpace(_CustomHeader, writer);
        
        /** ProHeader */
        writer.writeStartElement("ProHeader");                 
        if(_CustomHeader.getProHeader() != null) {  
            new com.tmax.custom.header.ProHeaderMsgXml().marshalXmlBodyWithoutNameSpace(_CustomHeader.getProHeader(), writer);                 
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
        /** SysHeader */
        writer.writeStartElement("SysHeader");                 
        if(_CustomHeader.getSysHeader() != null) {  
            new com.tmax.custom.header.SysHeaderMsgXml().marshalXmlBodyWithoutNameSpace(_CustomHeader.getSysHeader(), writer);                 
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
        /** ErrorHeader */
        writer.writeStartElement("ErrorHeader");                 
        if(_CustomHeader.getErrorHeader() != null) {  
            new com.tmax.custom.header.ErrorHeaderMsgXml().marshalXmlBodyWithoutNameSpace(_CustomHeader.getErrorHeader(), writer);                 
        }
        writer.writeEndElement();
        writer.writeCharacters("\n");
    }
    
    public void marshalXmlBody(Object target, XMLStreamWriter writer, String namespace) throws XMLStreamException{
        com.tmax.custom.header.CustomHeader _CustomHeader = (com.tmax.custom.header.CustomHeader) target;
        nf.setMaximumFractionDigits(340);
        nf.setGroupingUsed(false);
        super.marshalXmlBody(_CustomHeader, writer, namespace);
        if (namespace.length() != 0) {
            writer.writeStartElement(namespace, "ProHeader");
        } else {
            writer.writeStartElement("ProHeader");
        }
        
        if (_CustomHeader.getProHeader() == null) {
            writer.writeAttribute("xsi", NS_XSI, "nil", "true");
        } else {
            new com.tmax.custom.header.ProHeaderMsgXml().marshalXmlBody(_CustomHeader.getProHeader(), writer, "");
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
        
        if (namespace.length() != 0) {
            writer.writeStartElement(namespace, "SysHeader");
        } else {
            writer.writeStartElement("SysHeader");
        }
        
        if (_CustomHeader.getSysHeader() == null) {
            writer.writeAttribute("xsi", NS_XSI, "nil", "true");
        } else {
            new com.tmax.custom.header.SysHeaderMsgXml().marshalXmlBody(_CustomHeader.getSysHeader(), writer, "");
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
        
        if (namespace.length() != 0) {
            writer.writeStartElement(namespace, "ErrorHeader");
        } else {
            writer.writeStartElement("ErrorHeader");
        }
        
        if (_CustomHeader.getErrorHeader() == null) {
            writer.writeAttribute("xsi", NS_XSI, "nil", "true");
        } else {
            new com.tmax.custom.header.ErrorHeaderMsgXml().marshalXmlBody(_CustomHeader.getErrorHeader(), writer, "");
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
    
    public CustomHeader unmarshal(byte[] message) throws UnmarshalException {
        InputStream bin = new ByteArrayInputStream(message);
        XMLStreamReader reader = null;
        try {
            if (encoding != null) {
                reader = inputFactory.createXMLStreamReader(new BufferedReader(new InputStreamReader(bin, encoding)));
            } else {
                reader = inputFactory.createXMLStreamReader(bin);
            }
            return unmarshal(reader, "CustomHeader", true);
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
    
    public CustomHeader unmarshal(InputStream bin) throws UnmarshalException {
        XMLStreamReader reader = null;
        try {
            if (encoding != null)
                reader = inputFactory.createXMLStreamReader(new BufferedReader(new InputStreamReader(bin, encoding)));
            else
                reader = inputFactory.createXMLStreamReader(bin);
        
            return unmarshal(reader, "CustomHeader", true);
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
    
    
    public CustomHeader unmarshal(XMLStreamReader reader, String rootElementName) throws XMLStreamException {
        return unmarshal(reader, "CustomHeader", false);
    }
    
    @Override
    public CustomHeader unmarshal(XMLStreamReader reader, String rootElementName, boolean skipHeader) throws XMLStreamException {
          com.tmax.custom.header.CustomHeader  _CustomHeader = new com.tmax.custom.header.CustomHeader();
          java.util.Map<String, String> messageFieldNameList = new java.util.HashMap<>();
          java.util.ArrayList includeFieldList = new java.util.ArrayList();
          //XML message does NOT support dtoStart, dtoEnd field.  use Complex type, instead.
          messageFieldNameList.put("ProHeader","0");
          includeFieldList.add(new Integer(messageFieldNameList.size()>0?messageFieldNameList.size()-1:0));
          messageFieldNameList.put("SysHeader","1");
          includeFieldList.add(new Integer(messageFieldNameList.size()>0?messageFieldNameList.size()-1:0));
          messageFieldNameList.put("ErrorHeader","2");
          includeFieldList.add(new Integer(messageFieldNameList.size()>0?messageFieldNameList.size()-1:0));
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
                                  super.unmarshal(reader, rootElementName, _CustomHeader);
                                  if (reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {
                                      return _CustomHeader;
                                          }
                                          if (messageFieldNameList.containsKey(reader.getLocalName())) {
                                              fieldNumber = Integer.parseInt((String)messageFieldNameList.get(reader.getLocalName()));
                                              String nil = reader.getAttributeValue(NS_XSI, "nil");
                                              if (nil == null || nil.equals("false")) {
                                              if (includeFieldList.indexOf(new Integer(fieldNumber)) != -1) { 
                                              // include type element
                                                  switch(fieldNumber) {
                                                      case 0 : 
                                                          com.tmax.custom.header.ProHeader ProHeader_dto = new com.tmax.custom.header.ProHeader();
                                                          com.tmax.custom.header.ProHeaderMsgXml ProHeader_msg = new com.tmax.custom.header.ProHeaderMsgXml();
                                                          isStartEle = sr.isStartElement();
                                                          reader.next();
                                                          isEndEle = sr.isEndElement();
                                                          if ( (isStartEle&&isEndEle) || isSelfClose ) {
                                                              
                                                          } else {
                                                              ProHeader_dto = (com.tmax.custom.header.ProHeader)ProHeader_msg.unmarshal(reader, "ProHeader", true);
                                                              _CustomHeader.setProHeader(ProHeader_dto);
                                                              isCharacterSection = true;
                                                          }
                                                          break;
                                                      case 1 : 
                                                          com.tmax.custom.header.SysHeader SysHeader_dto = new com.tmax.custom.header.SysHeader();
                                                          com.tmax.custom.header.SysHeaderMsgXml SysHeader_msg = new com.tmax.custom.header.SysHeaderMsgXml();
                                                          isStartEle = sr.isStartElement();
                                                          reader.next();
                                                          isEndEle = sr.isEndElement();
                                                          if ( (isStartEle&&isEndEle) || isSelfClose ) {
                                                              
                                                          } else {
                                                              SysHeader_dto = (com.tmax.custom.header.SysHeader)SysHeader_msg.unmarshal(reader, "SysHeader", true);
                                                              _CustomHeader.setSysHeader(SysHeader_dto);
                                                              isCharacterSection = true;
                                                          }
                                                          break;
                                                      case 2 : 
                                                          com.tmax.custom.header.ErrorHeader ErrorHeader_dto = new com.tmax.custom.header.ErrorHeader();
                                                          com.tmax.custom.header.ErrorHeaderMsgXml ErrorHeader_msg = new com.tmax.custom.header.ErrorHeaderMsgXml();
                                                          isStartEle = sr.isStartElement();
                                                          reader.next();
                                                          isEndEle = sr.isEndElement();
                                                          if ( (isStartEle&&isEndEle) || isSelfClose ) {
                                                              
                                                          } else {
                                                              ErrorHeader_dto = (com.tmax.custom.header.ErrorHeader)ErrorHeader_msg.unmarshal(reader, "ErrorHeader", true);
                                                              _CustomHeader.setErrorHeader(ErrorHeader_dto);
                                                              isCharacterSection = true;
                                                          }
                                                          break;
                                                      default: break;
                                                  }
                                                  numberOfStartElement--;// includeMessage process EndElement of includeField.
                                              } else {
                                                  // element except include type, it will be processed int the "case XMLStreamConstants.CHARACTERS:" statement.
                                              }
                                          } else {
                                              switch(fieldNumber) {
                                                  case 0 : _CustomHeader.setProHeader((com.tmax.custom.header.ProHeader)null); isCharacterSection=true;break;
                                                  case 1 : _CustomHeader.setSysHeader((com.tmax.custom.header.SysHeader)null); isCharacterSection=true;break;
                                                  case 2 : _CustomHeader.setErrorHeader((com.tmax.custom.header.ErrorHeader)null); isCharacterSection=true;break;
                                                  default: break;
                                              }
                                          }
                                      } else {
                                          numberOfStartElement--;
                                      }
                              }
                          } else {
                              String nil = reader.getAttributeValue(NS_XSI, "nil");
                              if (nil == null || nil.equals("false")) {
                                  if (includeFieldList.indexOf(new Integer(fieldNumber)) != -1) { 
                                      // include type element
                                      switch(fieldNumber) {
                                          case 0 : 
                                          com.tmax.custom.header.ProHeader ProHeader_dto = new com.tmax.custom.header.ProHeader();
                                          com.tmax.custom.header.ProHeaderMsgXml ProHeader_msg = new com.tmax.custom.header.ProHeaderMsgXml();
                                          isStartEle = sr.isStartElement();
                                          reader.next();
                                          isEndEle = sr.isEndElement();
                                          if ( (isStartEle&&isEndEle) || isSelfClose ) {
                                          } else {
                                              ProHeader_dto = (com.tmax.custom.header.ProHeader)ProHeader_msg.unmarshal(reader, "ProHeader", true);
                                              _CustomHeader.setProHeader(ProHeader_dto);
                                              isCharacterSection = true;
                                          }
                                          break;
                                          case 1 : 
                                          com.tmax.custom.header.SysHeader SysHeader_dto = new com.tmax.custom.header.SysHeader();
                                          com.tmax.custom.header.SysHeaderMsgXml SysHeader_msg = new com.tmax.custom.header.SysHeaderMsgXml();
                                          isStartEle = sr.isStartElement();
                                          reader.next();
                                          isEndEle = sr.isEndElement();
                                          if ( (isStartEle&&isEndEle) || isSelfClose ) {
                                          } else {
                                              SysHeader_dto = (com.tmax.custom.header.SysHeader)SysHeader_msg.unmarshal(reader, "SysHeader", true);
                                              _CustomHeader.setSysHeader(SysHeader_dto);
                                              isCharacterSection = true;
                                          }
                                          break;
                                          case 2 : 
                                          com.tmax.custom.header.ErrorHeader ErrorHeader_dto = new com.tmax.custom.header.ErrorHeader();
                                          com.tmax.custom.header.ErrorHeaderMsgXml ErrorHeader_msg = new com.tmax.custom.header.ErrorHeaderMsgXml();
                                          isStartEle = sr.isStartElement();
                                          reader.next();
                                          isEndEle = sr.isEndElement();
                                          if ( (isStartEle&&isEndEle) || isSelfClose ) {
                                          } else {
                                              ErrorHeader_dto = (com.tmax.custom.header.ErrorHeader)ErrorHeader_msg.unmarshal(reader, "ErrorHeader", true);
                                              _CustomHeader.setErrorHeader(ErrorHeader_dto);
                                              isCharacterSection = true;
                                          }
                                          break;
                                          default: 
                                              break;
                                      }
                                      numberOfStartElement--;// includeMessage process EndElement of includeField.
                                  } else {
                                      // element except include type, it will be processed int the "case XMLStreamConstants.CHARACTERS:" statement.
                                  }
                              } else {
                                  switch(fieldNumber) {
                                      case 0 : _CustomHeader.setProHeader((com.tmax.custom.header.ProHeader)null); isCharacterSection=true;break;
                                      case 1 : _CustomHeader.setSysHeader((com.tmax.custom.header.SysHeader)null); isCharacterSection=true;break;
                                      case 2 : _CustomHeader.setErrorHeader((com.tmax.custom.header.ErrorHeader)null); isCharacterSection=true;break;
                                      default: break;
                                  }
                              }
                          }
                          break;
                      case XMLStreamConstants.CHARACTERS:
                          isCharacterSection = true;
                          if ( isStartElement ) {
                              switch(fieldNumber) {
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
                                      case 0 : _CustomHeader.setProHeader((com.tmax.custom.header.ProHeader)null); isCharacterSection=true; break;
                                      case 1 : _CustomHeader.setSysHeader((com.tmax.custom.header.SysHeader)null); isCharacterSection=true; break;
                                      case 2 : _CustomHeader.setErrorHeader((com.tmax.custom.header.ErrorHeader)null); isCharacterSection=true; break;
                                      default: isCharacterSection=true; break;
                                  }
                              }
                          }
                          if (reader.getLocalName().equals(rootElementName)) {
                              return _CustomHeader;
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
          return _CustomHeader;
    }
    
    public CustomHeader unmarshal(XMLStreamReader reader, String rootElementName, com.tmax.custom.header.CustomHeader  _CustomHeader) throws XMLStreamException {
          java.util.Map<String, String> messageFieldNameList = new java.util.HashMap<>();
          java.util.ArrayList includeFieldList = new java.util.ArrayList();
          //XML message does NOT support dtoStart, dtoEnd field.  use Complex type, instead.
          messageFieldNameList.put("ProHeader","0");
          includeFieldList.add(new Integer(messageFieldNameList.size()>0?messageFieldNameList.size()-1:0));
          messageFieldNameList.put("SysHeader","1");
          includeFieldList.add(new Integer(messageFieldNameList.size()>0?messageFieldNameList.size()-1:0));
          messageFieldNameList.put("ErrorHeader","2");
          includeFieldList.add(new Integer(messageFieldNameList.size()>0?messageFieldNameList.size()-1:0));
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
                              super.unmarshal(reader, rootElementName, _CustomHeader);
                              if (reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {
                                  return _CustomHeader;
                              }
                              if (messageFieldNameList.containsKey(reader.getLocalName())) {
                                  fieldNumber = Integer.parseInt((String)messageFieldNameList.get(reader.getLocalName()));
                                  String nil = reader.getAttributeValue(NS_XSI, "nil");
                                  if (nil == null || nil.equals("false")) {
                                      if(includeFieldList.indexOf(new Integer(fieldNumber)) != -1) { 
                                      // include type element
                                          switch(fieldNumber) {
                                              case 0 : 
                                              com.tmax.custom.header.ProHeader ProHeader_dto = new com.tmax.custom.header.ProHeader();
                                              com.tmax.custom.header.ProHeaderMsgXml ProHeader_msg = new com.tmax.custom.header.ProHeaderMsgXml();
                                              reader.next();
                                              ProHeader_dto = (com.tmax.custom.header.ProHeader)ProHeader_msg.unmarshal(reader, "ProHeader", true);
                                              _CustomHeader.setProHeader(ProHeader_dto);
                                              return _CustomHeader;
                                              case 1 : 
                                              com.tmax.custom.header.SysHeader SysHeader_dto = new com.tmax.custom.header.SysHeader();
                                              com.tmax.custom.header.SysHeaderMsgXml SysHeader_msg = new com.tmax.custom.header.SysHeaderMsgXml();
                                              reader.next();
                                              SysHeader_dto = (com.tmax.custom.header.SysHeader)SysHeader_msg.unmarshal(reader, "SysHeader", true);
                                              _CustomHeader.setSysHeader(SysHeader_dto);
                                              return _CustomHeader;
                                              case 2 : 
                                              com.tmax.custom.header.ErrorHeader ErrorHeader_dto = new com.tmax.custom.header.ErrorHeader();
                                              com.tmax.custom.header.ErrorHeaderMsgXml ErrorHeader_msg = new com.tmax.custom.header.ErrorHeaderMsgXml();
                                              reader.next();
                                              ErrorHeader_dto = (com.tmax.custom.header.ErrorHeader)ErrorHeader_msg.unmarshal(reader, "ErrorHeader", true);
                                              _CustomHeader.setErrorHeader(ErrorHeader_dto);
                                              return _CustomHeader;
                                              default: break;
                                          }
                                          numberOfStartElement--;// includeMessage process EndElement of includeField.
                                      } else {
                                          // element except include type, it will be processed int the "case XMLStreamConstants.CHARACTERS:" statement.
                                      }
                                  } else {
                                      switch(fieldNumber) {
                                          case 0 : _CustomHeader.setProHeader((com.tmax.custom.header.ProHeader)null); isCharacterSection=true;break;
                                          case 1 : _CustomHeader.setSysHeader((com.tmax.custom.header.SysHeader)null); isCharacterSection=true;break;
                                          case 2 : _CustomHeader.setErrorHeader((com.tmax.custom.header.ErrorHeader)null); isCharacterSection=true;break;
                                          default: break;
                                      }
                                  }
                              } else {
                                  return _CustomHeader;
                              }
                          }
                      } else {
                          String nil = reader.getAttributeValue(NS_XSI, "nil");
                          if (nil == null || nil.equals("false")) {
                              if (includeFieldList.indexOf(new Integer(fieldNumber)) != -1) { 
                                  // include type element
                                  switch(fieldNumber) {
                                      case 0 : 
                                          com.tmax.custom.header.ProHeader ProHeader_dto = new com.tmax.custom.header.ProHeader();
                                          com.tmax.custom.header.ProHeaderMsgXml ProHeader_msg = new com.tmax.custom.header.ProHeaderMsgXml();
                                          reader.next();
                                          ProHeader_dto = (com.tmax.custom.header.ProHeader)ProHeader_msg.unmarshal(reader, "ProHeader", true);
                                          _CustomHeader.setProHeader(ProHeader_dto);
                                          return _CustomHeader;
                                      case 1 : 
                                          com.tmax.custom.header.SysHeader SysHeader_dto = new com.tmax.custom.header.SysHeader();
                                          com.tmax.custom.header.SysHeaderMsgXml SysHeader_msg = new com.tmax.custom.header.SysHeaderMsgXml();
                                          reader.next();
                                          SysHeader_dto = (com.tmax.custom.header.SysHeader)SysHeader_msg.unmarshal(reader, "SysHeader", true);
                                          _CustomHeader.setSysHeader(SysHeader_dto);
                                          return _CustomHeader;
                                      case 2 : 
                                          com.tmax.custom.header.ErrorHeader ErrorHeader_dto = new com.tmax.custom.header.ErrorHeader();
                                          com.tmax.custom.header.ErrorHeaderMsgXml ErrorHeader_msg = new com.tmax.custom.header.ErrorHeaderMsgXml();
                                          reader.next();
                                          ErrorHeader_dto = (com.tmax.custom.header.ErrorHeader)ErrorHeader_msg.unmarshal(reader, "ErrorHeader", true);
                                          _CustomHeader.setErrorHeader(ErrorHeader_dto);
                                          return _CustomHeader;
                                      default: 
                                          break;
                                  }
                                  numberOfStartElement--;// includeMessage process EndElement of includeField.
                              } else {
                                  // element except include type, it will be processed int the "case XMLStreamConstants.CHARACTERS:" statement.
                              }
                          } else {
                              switch(fieldNumber) {
                                  case 0 : _CustomHeader.setProHeader((com.tmax.custom.header.ProHeader)null); isCharacterSection=true;break;
                                  case 1 : _CustomHeader.setSysHeader((com.tmax.custom.header.SysHeader)null); isCharacterSection=true;break;
                                  case 2 : _CustomHeader.setErrorHeader((com.tmax.custom.header.ErrorHeader)null); isCharacterSection=true;break;
                                  default: break;
                              }
                          }
                      }
                      break;
                  case XMLStreamConstants.CHARACTERS:
                      isCharacterSection = true;
                      if ( isStartElement ) {
                          switch(fieldNumber) {
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
                                  case 0 : _CustomHeader.setProHeader((com.tmax.custom.header.ProHeader)null); isCharacterSection=true; break;
                                  case 1 : _CustomHeader.setSysHeader((com.tmax.custom.header.SysHeader)null); isCharacterSection=true; break;
                                  case 2 : _CustomHeader.setErrorHeader((com.tmax.custom.header.ErrorHeader)null); isCharacterSection=true; break;
                                  default: isCharacterSection=true; break;
                              }
                          }
                      }
                      if (reader.getLocalName().equals(rootElementName) || numberOfStartElement == 0) {
                          return _CustomHeader;
                      }
                      break;
                  default:
                      break;
              }
              reader.next();
          }
          
          return _CustomHeader;
    }
    
    public CustomHeader unmarshal(byte[] msg, int offset) throws UnmarshalException {
        return null;
    }
    
    public int unmarshal(byte[] msg, int offset, Object obj) throws UnmarshalException {
        return -1;
    }
    
    public CustomHeader unmarshal(Node message) throws Exception{
    	return null;
    }
}
