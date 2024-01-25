package com.tmax.custom.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.codehaus.jettison.json.JSONObject;
import org.json.XML;
import org.springframework.util.StreamUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.header.ErrorHeader;
import com.tmax.custom.header.ErrorHeaderMsgJson;
import com.tmax.custom.header.ErrorHeaderMsgXml;
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.ProHeaderMsgJson;
import com.tmax.custom.header.ProHeaderMsgXml;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.header.SysHeaderMsgJson;
import com.tmax.custom.header.SysHeaderMsgXml;
import com.tmax.custom.util.CheckTime;
import com.tmax.custom.util.XmlUtils;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.application.servicegroup.ServiceGroupManager;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.parser.HttpBodyParser;
import com.tmax.proobject.network.protocol.http.ProObjectHttpProtocol;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
import proobject.com.google.gson.JsonElement;
import proobject.com.google.gson.JsonObject;
import proobject.com.google.gson.JsonParser;

public class CustomParser implements HttpBodyParser {

	private ProObjectLogger logger = SystemLogger.getLogger();
	
	long startTime;
	long endTime;

	@Override
	public byte[] marshalErrorResponseBody(Throwable exception, Object input, ServiceName serviceName,
			RequestContext requestContext, ProMapperMessageType messageType) throws Exception {

		logger.info("\n ######### marshalErrorResponseBody Start ##########");
		
		
		logger.info("\n ######### marshalErrorResponseBody input ##########"+input);
		
		
		ProObjectHttpProtocol protocol = new ProObjectHttpProtocol();

		protocol.setDto(input);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();

		JsonObject returnObject = new JsonObject();

		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));

		JsonObject errorHeader = (JsonObject) gson.toJsonTree(requestContext.getUserDataContext().get("ErrorHeader"));

		CustomHeader customheader = (CustomHeader) requestContext.getRequest().getHeader();

		errorHeader.addProperty("responseCode", customheader.getErrorHeader().getResponseCode());
		errorHeader.addProperty("responseType", customheader.getErrorHeader().getResponseType());
		errorHeader.addProperty("responseBasic", customheader.getErrorHeader().getResponseBasic());
		errorHeader.addProperty("responseDtal", sw.toString());

		returnObject.add("ErrorHeader", errorHeader);

		logger.info("\n ######### marshalErrorResponseBody errorHeader : " + returnObject.toString());

		logger.info("\n ######### marshalErrorResponseBody End ##########");
		return returnObject.toString().getBytes();
	}

	@Override
	public byte[] marshalRequestBody(ProObjectHttpProtocol arg0, ServiceName arg1, RequestContext arg2,
			ProMapperMessageType arg3) throws Exception {
		logger.info("\n ######### marshalRequestBody ##########");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] marshalResponseBody(ProObjectHttpProtocol protocol, ServiceName serviceName,
			RequestContext requestContext, ProMapperMessageType msg_type) throws Exception {

		logger.info("\n ######### marshalResponseBody Start ##########");
		
		// TODO Auto-generated method stub
		
		String msgType = requestContext.getRequest().getWebHeader().get("content-type");
		
		JsonObject returnObject = new JsonObject();
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		// json
		if(msgType.equals("application/json")) {
		
			logger.info("\n ######### JSON 입니다. ##########");
	
			JsonElement userDataProHeader = gson.toJsonTree(requestContext.getUserDataContext().get("ProHeader"));
			returnObject.add("ProHeader", userDataProHeader);
	
			JsonElement userDataSysHeader = gson.toJsonTree(requestContext.getUserDataContext().get("SysHeader"));
			returnObject.add("SysHeader", userDataSysHeader);
	
			String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceOutputType()
						.getResourceName();
	
			JsonElement dto = gson.toJsonTree(protocol.getDto());
			returnObject.add(dtoClassName, dto);
	
			logger.info("\n ### return ###  : \n" + "ProHeader : " + returnObject.get("ProHeader") + "\n" + "\n"
						+ "SysHeader : " + returnObject.get("SysHeader") + "\n" + "\n" + "dto : "
						+ returnObject.get(dtoClassName) + "\n");
	
			logger.info("\n ######### marshalResponseBody Json End ##########");
	
			endTime = CheckTime.endTime();
				
			CheckTime.leadTime(endTime, startTime);
				
			return returnObject.toString().getBytes();
		}
		// xml
		else {
			
			logger.info("\n ######### XML 입니다. ##########");
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();
			doc.setXmlStandalone(true);
			
			// root 엘리멘트 추가
			Element root = doc.createElement("root");
			doc.appendChild(root);
			
			// Document 에 message 엘리멘트 추가
			Element message = doc.createElement("message");
			root.appendChild(message);
			
			// proheader doc 생성
			Document proheaderDoc = XmlUtils.doDomParse(requestContext.getUserDataContext().get("ProHeader").toString());		
			Node proHeader = proheaderDoc.getElementsByTagName("ProHeader").item(0);
			Node proNode = doc.importNode(proHeader, true);
			message.appendChild(proNode);
			
			// sysheader doc 생성
			Document sysheaderDoc = XmlUtils.doDomParse(requestContext.getUserDataContext().get("SysHeader").toString());
			Node sysHeader = sysheaderDoc.getElementsByTagName("SysHeader").item(0);
			Node sysNode = doc.importNode(sysHeader, true);
			message.appendChild(sysNode);
	
			// DTO
			String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceOutputType()
					.getResourceName();
			logger.info("\n ######### outpout dtoClassName : \n"+dtoClassName);
			
			JsonElement jsonElement = gson.toJsonTree(protocol.getDto());			
			JSONObject jsonObject = new JSONObject(jsonElement.toString());		
			String xmlDto = XML.toString(jsonObject, dtoClassName);
			Document dtoDoc = XmlUtils.doDomParse(xmlDto);
			Node outputDto = dtoDoc.getElementsByTagName(dtoClassName).item(0);
			Node dtoNode = doc.importNode(outputDto, true);
			message.appendChild(dtoNode);
			
			logger.info("\n ######### marshalResponseBody Xml End ##########");
			
			return XmlUtils.covertXmlToString(doc).getBytes();
		}
	}


	@Override
	public ProObjectHttpProtocol unmarshalRequestBody(InputStream inputStream, ServiceName serviceName,
			RequestContext requestContext, ProMapperMessageType arg3) throws Exception {

		logger.info("\n ######### unmarshalRequestBody Start ##########");
		
		logger.info("\n ######### unmarshalRequestBody RequestContext ##########\n"+requestContext);
		
		logger.info("\n ######### unmarshalRequestBody RequestContext content-type ##########\n"+requestContext.getRequest().getWebHeader().get("content-type"));
		
		String msg_type = requestContext.getRequest().getWebHeader().get("content-type");
		
		// contet_type 으로 입력전문 분기 처리
		if(msg_type.equals("application/json")) {
			logger.info("\n ######### JSON 입니다. ##########");
		}
			
		else if(msg_type.equals("application/xml")) {
			logger.info("\n ######### XML 입니다. ##########");
		}
			
		
		startTime = CheckTime.startTime();

		// JSON
		if(msg_type.equals("application/json")) {
			ProObjectHttpProtocol protocol = new ProObjectHttpProtocol();
	
			Map<String, Object> userData = requestContext.getUserDataContext();
	
			String charset = Charset.defaultCharset().toString();
	
			BufferedReader reader = null;
	
			try {
				reader = new BufferedReader(new InputStreamReader(inputStream, charset));
				JsonParser parser = new JsonParser();
				JsonElement rootElement = parser.parse(reader);
				JsonObject root = rootElement.getAsJsonObject();
				Gson gson = new Gson();
	
				CustomHeader customHeader = gson.fromJson(root.toString(), CustomHeader.class);
				String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType()
						.getResourceName();
	
				String[] fieldNames = { "ProHeader", "SysHeader", "ErrorHeader", dtoClassName };
				for (String fieldName : fieldNames) {
					JsonElement element = root.get(fieldName);
					if (element != null && element.isJsonNull() == false) {
						if ("ProHeader".equals(fieldName)) {
	
							AbstractMessage headerMsg = new ProHeaderMsgJson();
							ProHeader proHeader = (ProHeader) headerMsg.unmarshal(element.toString().getBytes(charset));
	
							// ProHeader
							logger.info("\n\n### ProHeader ####  \n" + element.toString() + "\n");
	
							userData.put("ProHeader", proHeader);
							customHeader.setProHeader(proHeader);
	
						} else if ("SysHeader".equals(fieldName)) {
							AbstractMessage headerMsg = new SysHeaderMsgJson();
							SysHeader sysHeader = (SysHeader) headerMsg.unmarshal(element.toString().getBytes(charset));
	
							// SysHeader
							logger.info("\n\n### SysHeader ####  \n" + element.toString() + "\n");
	
							userData.put("SysHeader", sysHeader);
							customHeader.setSysHeader(sysHeader);
	
						} else if ("ErrorHeader".equals(fieldName)) {
	
							AbstractMessage headerMsg = new ErrorHeaderMsgJson();
							ErrorHeader errorHeader = (ErrorHeader) headerMsg
									.unmarshal(element.toString().getBytes(charset));
	
							// SysHeader
							logger.info("\n\n### ErrorHeader ####  \n" + element.toString() + "\n");
	
							userData.put("ErrorHeader", errorHeader);
							customHeader.setErrorHeader(errorHeader);
						}
	
						else if (dtoClassName.equals(fieldName)) {
							String dtoMsgJsonPackage = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType()
									.getResourcePackage();
							String dtoMsgJsonClassName = dtoMsgJsonPackage + "." + dtoClassName + "MsgJson";
							Class cls = Class.forName(dtoMsgJsonClassName);
							Object obj = cls.newInstance();
							AbstractMessage dtoMsg = (AbstractMessage) obj;
	
							Object input = dtoMsg.unmarshal(element.toString().getBytes(charset));
	
							logger.info("\n\n### DTO ####  \n" + dtoClassName + "\n" + input.toString());
							userData.put(dtoClassName, input);
							protocol.setDto(input);
						}
						protocol.setHeader(customHeader);
					}
				}
			} catch (Exception e) {
				protocol.setHeader(new CustomHeader());
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						SystemLogger.getLogger().error(e);
					}
				}
			}
			logger.info("\n ######### unmarshalRequestBody JSON End ##########");
			return protocol;	
		}
		// XML
		else {
			
			//InputStream inputStream, ServiceName serviceName, RequestContext requestContext, ProMapperMessageType arg3
			
			ProObjectHttpProtocol protocol = new ProObjectHttpProtocol();
			
			Map<String, Object> userData = requestContext.getUserDataContext();			
			
			CustomHeader customHeader = new CustomHeader();
			
			String charset = Charset.defaultCharset().toString();
			String tmpXmlData = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
			
			logger.info("############ input tmpXmlData XML  \n"+tmpXmlData);
			
			
			try {
				// XML Parsing
				Document doc = XmlUtils.doDomParse(tmpXmlData);
				
				String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType()
						.getResourceName();
				logger.info("############ input dtoClassName XML  \n"+dtoClassName);
				
				String[] fieldNames = { "ProHeader", "SysHeader", "ErrorHeader", dtoClassName };
				
				NodeList proNodeList = doc.getElementsByTagName("ProHeader");
				NodeList sysNodeList = doc.getElementsByTagName("SysHeader");
				NodeList errNodeList = doc.getElementsByTagName("ErrorHeader");
				NodeList dtoNodeList = doc.getElementsByTagName(dtoClassName);
				
				Node proElement = proNodeList.item(0);
				Node sysElement = sysNodeList.item(0);
				Node errElement = errNodeList.item(0);
				Node dtoElement = dtoNodeList.item(0);
				
				for(String fieldName : fieldNames) {
					if(proElement != null & sysElement != null) {
						if ("ProHeader".equals(fieldName)) {					
							userData.put("ProHeader",XmlUtils.covertNodeToString(proElement));						
							AbstractMessage headerMsg = new ProHeaderMsgXml();
							ProHeader proHeader = (ProHeader) headerMsg.unmarshal(XmlUtils.covertNodeToString(proElement).getBytes(charset));
//							ProHeader proHeader = (ProHeader) headerMsg.unmarshal(XmlUtils.covertNodeToString(proElement));	
							customHeader.setProHeader(proHeader);
							
						} else if ("SysHeader".equals(fieldName)) {
							userData.put("SysHeader",XmlUtils.covertNodeToString(sysElement));						
							AbstractMessage headerMsg = new SysHeaderMsgXml();
							SysHeader sysHeader = (SysHeader) headerMsg.unmarshal(XmlUtils.covertNodeToString(sysElement).getBytes(charset));
							customHeader.setSysHeader(sysHeader);
							
						} else if("ErrorHeader".equals(fieldName)) {
							userData.put("ErrorHeader",XmlUtils.covertNodeToString(errElement));						
							AbstractMessage headerMsg = new ErrorHeaderMsgXml();
							ErrorHeader errorHeader = (ErrorHeader) headerMsg.unmarshal(XmlUtils.covertNodeToString(errElement).getBytes(charset));
							customHeader.setErrorHeader(errorHeader);
							
						}else if (dtoClassName.equals(fieldName)) {
							String dtoMsgXmlPackage = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType()
									.getResourcePackage();
							String dtoMsgXmlClassName = dtoMsgXmlPackage + "." + dtoClassName + "MsgXml";
							Class cls = Class.forName(dtoMsgXmlClassName);
							Object obj = cls.newInstance();
							AbstractMessage dtoMsg = (AbstractMessage) obj;
	
							Object input = dtoMsg.unmarshal(XmlUtils.covertNodeToString(dtoElement).getBytes());
	
							logger.info("\n\n### DTO ####  \n" + dtoClassName + "\n" + input.toString());
	
							protocol.setDto(input);
							
						}
						protocol.setHeader(customHeader);
					}
				}
				
			}catch(Exception e) {
				
			}
			logger.info("\n ######### unmarshalRequestBody XML End ##########");
			return protocol;
		}
	}

	@Override
	public ProObjectHttpProtocol unmarshalResponseBody(InputStream arg0, ServiceName arg1,
			RequestContext requestContext, ProMapperMessageType arg3) throws Exception {
		logger.info("\n ######### unmarshalResponseBody ##########");

		logger.info("\n ######### unmarshalResponseBody RequestContext : \n" + requestContext);

		CheckTime.startTime();
		// TODO Auto-generated method stub
		return null;
	}

}
