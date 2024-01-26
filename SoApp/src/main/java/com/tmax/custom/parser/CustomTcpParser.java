package com.tmax.custom.parser;

import java.nio.charset.Charset;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.codehaus.jettison.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.ProHeaderMsgJson;
import com.tmax.custom.header.ProHeaderMsgXml;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.header.SysHeaderMsgJson;
import com.tmax.custom.header.SysHeaderMsgXml;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.custom.sample.dto.SampleDTOMsgXml;
import com.tmax.custom.util.XmlUtils;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.application.servicegroup.ServiceGroupManager;
import com.tmax.proobject.model.context.Header;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.parser.ProObjectBodyParser;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
import proobject.com.google.gson.JsonElement;
import proobject.com.google.gson.JsonObject;
import proobject.com.google.gson.JsonParser;

public class CustomTcpParser implements ProObjectBodyParser {

	private ProObjectLogger logger = SystemLogger.getLogger();

	@Override
	public byte[] marshalHeader(Header header, ServiceName serviceName, RequestContext requestContext,
			ProMapperMessageType proMapperMessageType) throws Exception {
		// TODO Auto-generated method stub

		String requestMessageType = requestContext.getRequest().getRequestMessageType().toString();

		logger.info("############# requestContext \n" + requestMessageType);

		if (requestMessageType.equals("JSON")) {
			JsonObject returnObject = new JsonObject();
			Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();
			logger.info("############# marshalHeader start ##############");

			JsonElement userDataProHeader = gson.toJsonTree(requestContext.getUserDataContext().get("ProHeader"));
			returnObject.add("ProHeader", userDataProHeader);

			JsonElement userDataSysHeader = gson.toJsonTree(requestContext.getUserDataContext().get("SysHeader"));
			returnObject.add("SysHeader", userDataSysHeader);

			logger.info("############# returnObject : \n" + returnObject);

			logger.info("############# marshalHeader end ##############");
			return returnObject.toString().getBytes();
		} else {
			
			
			logger.info("############# marshalHeader requestContext : \n"+requestContext);


			String findDto = requestContext.getUserDataContext().get("findDto").toString();

			
			logger.info("############# marshalHeader findDto : \n"+findDto);
			
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
			
			
			Document findDtos = XmlUtils.doDomParse(findDto);

			Node proHeader = findDtos.getElementsByTagName("ProHeader").item(0);
			Node proNode = doc.importNode(proHeader, true);
			message.appendChild(proNode);

			Node sysHeader = findDtos.getElementsByTagName("SysHeader").item(0);
			Node sysNode = doc.importNode(sysHeader, true);
			message.appendChild(sysNode);

			logger.info("############# marshalHeader End ##### ");
			return XmlUtils.covertXmlToString(doc).getBytes();
		}
	}

	@Override
	public byte[] marshalInput(Object object, ServiceName serviceName, RequestContext requestContext,
			ProMapperMessageType proMapperMessageType) throws Exception {
		// TODO Auto-generated method stub
		logger.info("############# marshalInput ##############");
		return null;
	}

	@Override
	public byte[] marshalOutput(Object object, ServiceName serviceName, RequestContext requestContext,
			ProMapperMessageType proMapperMessageType) throws Exception {
		// TODO Auto-generated method stub
		logger.info("############# marshalOutput start ##############");
		String requestMessageType = requestContext.getRequest().getRequestMessageType().toString();

		logger.info("############# requestContext \n" + requestMessageType);

		if (requestMessageType.equals("JSON")) {

			String dtoName = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourceName();

			Gson gson = new GsonBuilder().serializeNulls().create();

			JsonObject returnObject = new JsonObject();
			JsonElement outputElement = gson.toJsonTree(object);
			returnObject.add(dtoName, outputElement);

			logger.info("############# requestContext : \n" + requestContext);

			// dto 결과 tcpUtil로 전달을 위해 userData에 담기
			Map<String, Object> userData = requestContext.getUserDataContext();
			userData.put("outputElement", returnObject.get(dtoName));

			logger.info("############# marshalOutput end ##############");

			return returnObject.toString().getBytes();
		} else {
			
			logger.info("############# marshalHeader requestContext : \n"+requestContext);
			
			
			String findDto = requestContext.getUserDataContext().get("findDto").toString();
			
			logger.info("############# marshalHeader findDto : \n"+findDto);
			

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();
			doc.setXmlStandalone(true);

			Document findDtos = XmlUtils.doDomParse(findDto);
			
			// root 엘리멘트 추가
			Element root = doc.createElement("root");
			doc.appendChild(root);
			
			// Document 에 message 엘리멘트 추가
			Element message = doc.createElement("message");
			root.appendChild(message);

			Node dto = findDtos.getElementsByTagName("SampleDTO").item(0);
	
			message.appendChild(dto);
			logger.info("############# marshalOutput  dto ############## : "+dto);
			Node dtoNode = doc.importNode(dto, true);
			message.appendChild(dto);
			logger.info("############# marshalOutput  dtoNode ############## : "+dtoNode);
		
			
			logger.info("############# marshalOutput  XmlUtils.covertXmlToString(doc) ##############\n"
			+XmlUtils.covertXmlToString(doc));
			
			
			logger.info("############# marshalOutput  end ##############");
			
			return XmlUtils.covertXmlToString(doc).getBytes();
		}
	}

	@Override
	public Header unmarshalHeader(byte[] inputHeaderBytes, ServiceName serviceName, RequestContext requestContext,
			ProMapperMessageType proMapperMessageType) throws Exception {

		logger.info("############# TCP ##############");
		// TODO Auto-generated method stub
		logger.info("############# unmarshalHeader start ##############");

		logger.info("############# requestContext \n" + requestContext);

		String requestMessageType = requestContext.getRequest().getRequestMessageType().toString();

		logger.info("############# requestContext \n" + requestMessageType);

		if (requestMessageType.equals("JSON")) {

			logger.info("\n ######### JSON 입니다. ##########");

			CustomHeader customHeader = new CustomHeader();

			String charset = Charset.defaultCharset().toString();
			Map<String, Object> userData = requestContext.getUserDataContext();

			logger.info("############# unmarshalHeader userData ##############\n" + userData);

			String inputHeaderString = new String(inputHeaderBytes);

			logger.info("############# inputHeaderString ##############\n" + inputHeaderString);

			JsonParser parser = new JsonParser();
			JsonElement rootElement = parser.parse(inputHeaderString);
			JsonObject root = rootElement.getAsJsonObject();

			try {

				String[] fieldNames = { "ProHeader", "SysHeader" };

				for (String fieldName : fieldNames) {
					JsonElement element = root.get(fieldName);

					if (element != null && element.isJsonNull() == false) {

						if ("ProHeader".equals(fieldName)) {
							logger.info("############# \"ProHeader\".equals ##############");
							userData.put("ProHeader", element.getAsJsonObject());
							AbstractMessage proHeaderMsgJson = new ProHeaderMsgJson();
							ProHeader proHeader = (ProHeader) proHeaderMsgJson
									.unmarshal(element.toString().getBytes(charset));
							customHeader.setProHeader(proHeader);
						} else if ("SysHeader".equals(fieldName)) {
							logger.info("############# \"SysHeader\".equals ##############");
							userData.put("SysHeader", element.getAsJsonObject());
							AbstractMessage sysHeaderMsgJson = new SysHeaderMsgJson();
							SysHeader sysHeader = (SysHeader) sysHeaderMsgJson
									.unmarshal(element.toString().getBytes(charset));
							customHeader.setSysHeader(sysHeader);
						}
					}
				}

			} catch (Exception e) {
				SystemLogger.getLogger().error(e);
			}

			logger.info("############# After requestContext ##############\n" + requestContext);
			logger.info("############# unmarshalHeader end ##############");

			// protocol.setHeader(customHeader);
			// userData.put("header", customHeader);
			return customHeader;
		} else {

			logger.info("\n ######### XML 입니다. ##########");

			Map<String, Object> userData = requestContext.getUserDataContext();

			CustomHeader customHeader = new CustomHeader();

			String inputHeaderString = new String(inputHeaderBytes);

			userData.put("findDto", inputHeaderString);

			String charset = Charset.defaultCharset().toString();

			logger.info("\n ######### XML inputHeaderString : \n" + inputHeaderString);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();
			doc.setXmlStandalone(true);

			Document CustomHeaderDoc = XmlUtils.doDomParse(inputHeaderString);

			logger.info("\n ######### XML CustomHeaderDoc : \n" + CustomHeaderDoc);

			Node proHeader = CustomHeaderDoc.getElementsByTagName("ProHeader").item(0);
			Node proNode = doc.importNode(proHeader, true);

			logger.info("\n ######### XML proNode : \n" + proNode);
			Node sysHeader = CustomHeaderDoc.getElementsByTagName("SysHeader").item(0);
			Node sysNode = doc.importNode(sysHeader, true);
			logger.info("\n ######### XML sysNode : \n" + sysNode);

			AbstractMessage proHeaderMsg = new ProHeaderMsgXml();
			AbstractMessage sysHeaderMsg = new SysHeaderMsgXml();
			ProHeader proHeader2 = (ProHeader) proHeaderMsg
					.unmarshal(XmlUtils.covertNodeToString(proNode).getBytes(charset));
			SysHeader sysHeader2 = (SysHeader) sysHeaderMsg
					.unmarshal(XmlUtils.covertNodeToString(sysNode).getBytes(charset));

			customHeader.setProHeader(proHeader2);
			customHeader.setSysHeader(sysHeader2);

			logger.info("\n ######### XML customHeaders : \n" + customHeader);

			return customHeader;
		}
	}

	@Override
	public Object unmarshalInput(byte[] inputBytes, ServiceName serviceName, RequestContext requestContext,
			ProMapperMessageType proMapperMessageType) throws Exception {

		logger.info("############# unmarshalInput start ############## ");

		logger.info("############# unmarshalInput inputBytes ############## : " + inputBytes);
		logger.info("############# unmarshalInput inputBytes ############## : " + new String(inputBytes));

		String requestMessageType = requestContext.getRequest().getRequestMessageType().toString();

		logger.info("############# requestContext \n" + requestMessageType);

		if (requestMessageType.equals("JSON")) {

			String charset = Charset.defaultCharset().toString();

			Map<String, Object> userData = requestContext.getUserDataContext();
			String inputDtoString = new String(inputBytes);
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(inputDtoString);

			String dtoClassName = "SampleDTO";

			JsonObject jsonObject = jsonElement.getAsJsonObject().get(dtoClassName).getAsJsonObject();

			Gson gson = new GsonBuilder().serializeNulls().create();

			SampleDTO input = gson.fromJson(jsonObject, SampleDTO.class);

			logger.info("############# unmarshalInput input ############## : " + input);
			return input;
		} else {

			logger.info("############# XML 입니다 ##############");

			String findDto = requestContext.getUserDataContext().get("findDto").toString();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();
			doc.setXmlStandalone(true);

			Document findDtos = XmlUtils.doDomParse(findDto);

			Node dto = findDtos.getElementsByTagName("SampleDTO").item(0);
			Node dtoNode = doc.importNode(dto, true);

			AbstractMessage dtoMsg = new SampleDTOMsgXml();
			String charset = Charset.defaultCharset().toString();

			SampleDTO dtoee = (SampleDTO) dtoMsg.unmarshal(XmlUtils.covertNodeToString(dtoNode).getBytes(charset));
			logger.info("############# unmarshalInput dtoee ############## : " + dtoee);
			return dtoee;
		}

	}

	@Override
	public Object unmarshalOutput(byte[] arg0, ServiceName arg1, RequestContext arg2, ProMapperMessageType arg3)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("############# unmarshalOutput ##############");
		return null;
	}

}
