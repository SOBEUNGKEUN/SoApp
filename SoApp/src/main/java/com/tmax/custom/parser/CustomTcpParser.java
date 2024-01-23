package com.tmax.custom.parser;

import java.nio.charset.Charset;
import java.util.Map;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.ProHeaderMsgJson;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.header.SysHeaderMsgJson;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.application.servicegroup.ServiceGroupManager;
import com.tmax.proobject.model.context.Header;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.parser.ProObjectBodyParser;
import com.tmax.proobject.network.protocol.http.ProObjectHttpProtocol;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
import proobject.com.google.gson.JsonElement;
import proobject.com.google.gson.JsonObject;
import proobject.com.google.gson.JsonParser;

public class CustomTcpParser implements ProObjectBodyParser{

	private ProObjectLogger logger = SystemLogger.getLogger();
	@Override
	public byte[] marshalHeader(Header header, ServiceName serviceName, RequestContext requestContext, ProMapperMessageType proMapperMessageType)
			throws Exception {
		// TODO Auto-generated method stub
		JsonObject returnObject = new JsonObject();
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();
		logger.info("############# marshalHeader start ##############");	

		JsonElement userDataProHeader = gson.toJsonTree(requestContext.getUserDataContext().get("ProHeader"));
		returnObject.add("ProHeader", userDataProHeader);

		JsonElement userDataSysHeader = gson.toJsonTree(requestContext.getUserDataContext().get("SysHeader"));
		returnObject.add("SysHeader", userDataSysHeader);
		
		logger.info("############# returnObject : \n"+returnObject);
		
		logger.info("############# marshalHeader end ##############");
		return returnObject.toString().getBytes();
	}

	@Override
	public byte[] marshalInput(Object object, ServiceName serviceName, RequestContext requestContext, ProMapperMessageType proMapperMessageType)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("############# marshalInput ##############");
		return null;
	}

	@Override
	public byte[] marshalOutput(Object object, ServiceName serviceName, RequestContext requestContext, ProMapperMessageType proMapperMessageType)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("############# marshalOutput start ##############");
	
		String dtoName = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourceName();
		
		Gson gson = new GsonBuilder().serializeNulls().create();

		JsonObject returnObject = new JsonObject();
		JsonElement outputElement = gson.toJsonTree(object);
		returnObject.add(dtoName, outputElement);
		
		logger.info("############# requestContext : \n"+requestContext);
		
		// dto 결과 tcpUtil로 전달을 위해 userData에 담기
		Map<String, Object> userData = requestContext.getUserDataContext();
		userData.put("outputElement", returnObject.get(dtoName));
		
		logger.info("############# marshalOutput end ##############");
		
		return returnObject.toString().getBytes();
	}

	@Override
	public Header unmarshalHeader(byte[] inputHeaderBytes, ServiceName serviceName, RequestContext requestContext, ProMapperMessageType proMapperMessageType)
			throws Exception {
		
//		ProObjectHttpProtocol protocol = new ProObjectHttpProtocol();
		

		// TODO Auto-generated method stub
		logger.info("############# unmarshalHeader start ##############");

		CustomHeader customHeader = new CustomHeader();
				
		String charset = Charset.defaultCharset().toString();
		Map<String, Object> userData = requestContext.getUserDataContext();
		
		logger.info("############# unmarshalHeader userData ##############\n"+userData);
		
		String inputHeaderString = new String(inputHeaderBytes);
		
		logger.info("############# inputHeaderString ##############\n"+inputHeaderString);
		
			
		JsonParser parser = new JsonParser();
		JsonElement rootElement = parser.parse(inputHeaderString);	
		JsonObject root = rootElement.getAsJsonObject();
		
		
		try {		
			
			String[] fieldNames = {"ProHeader", "SysHeader"};
			
			for (String fieldName : fieldNames) {
				JsonElement element = root.get(fieldName);
				
				if (element != null && element.isJsonNull() == false) {
					
					if("ProHeader".equals(fieldName)) {
						logger.info("############# \"ProHeader\".equals ##############");
						userData.put("ProHeader", element.getAsJsonObject());
						AbstractMessage proHeaderMsgJson = new ProHeaderMsgJson();
						ProHeader proHeader = (ProHeader) proHeaderMsgJson.unmarshal(element.toString().getBytes(charset));
						customHeader.setProHeader(proHeader);
					}else if ("SysHeader".equals(fieldName)) {
						logger.info("############# \"SysHeader\".equals ##############");
						userData.put("SysHeader", element.getAsJsonObject());
						AbstractMessage sysHeaderMsgJson = new SysHeaderMsgJson();
						SysHeader sysHeader = (SysHeader) sysHeaderMsgJson.unmarshal(element.toString().getBytes(charset));
						customHeader.setSysHeader(sysHeader);
					}
				}
			}
			
	
		} catch (Exception e) {
			SystemLogger.getLogger().error(e);	
		}
		
		logger.info("############# After requestContext ##############\n"+requestContext);
		logger.info("############# unmarshalHeader end ##############");
		
//		protocol.setHeader(customHeader);
//		userData.put("header", customHeader);
		return customHeader;
	}

	@Override
	public Object unmarshalInput(byte[] inputBytes, ServiceName serviceName, RequestContext requestContext, ProMapperMessageType proMapperMessageType)
			throws Exception {
		
		logger.info("############# unmarshalInput start ############## " );
		
		
		logger.info("############# unmarshalInput inputBytes ############## : "+inputBytes );
		logger.info("############# unmarshalInput inputBytes ############## : "+new String(inputBytes));
		
		
//		Object input = new Object();
//		String charset = Charset.defaultCharset().toString();
//		
//		Map<String, Object> userData = requestContext.getUserDataContext();
//		
//		String inputDtoString  = new String(inputBytes);
//		JsonParser parser = new JsonParser();
//		JsonElement jsonElement = parser.parse(inputDtoString);
//		
//		JsonObject root = jsonElement.getAsJsonObject();
//		
//		try {
//			
//			String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourceName();
//			String dtoMsgJsonPackage = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourcePackage();
//			String dtoMsgJsonClassNmae = dtoMsgJsonPackage+"."+dtoClassName+"MsgJson";
//			
//			logger.info("############# unmarshalInput dtoMsgJsonClassNmae ############## : " +dtoMsgJsonClassNmae);
//			JsonElement element = root.get(dtoClassName);
//			Class cls = Class.forName(dtoMsgJsonClassNmae);
//			Object obj = cls.newInstance();
//			AbstractMessage dtoMsg = (AbstractMessage) obj;
//			input = dtoMsg.unmarshal(element.toString().getBytes(charset));
//		}
//		catch(Exception e) {
//			
//		}
//		
//		logger.info("############# unmarshalInput input ############## : " +input);
		
//		Object input = new Object();
		String charset = Charset.defaultCharset().toString();
		
		Map<String, Object> userData = requestContext.getUserDataContext();
//		String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourceName();
		String inputDtoString  = new String(inputBytes);
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(inputDtoString);
		
		String dtoClassName = "SampleDTO";
		
		JsonObject jsonObject = jsonElement.getAsJsonObject().get(dtoClassName).getAsJsonObject();
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		SampleDTO input = gson.fromJson(jsonObject, SampleDTO.class);
		
		logger.info("############# unmarshalInput input ############## : "+input);
		return input;
	}

	@Override
	public Object unmarshalOutput(byte[] arg0, ServiceName arg1, RequestContext arg2, ProMapperMessageType arg3)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("############# unmarshalOutput ##############");
		return null;
	}

}
