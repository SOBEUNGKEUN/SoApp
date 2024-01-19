package com.tmax.custom.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Map;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.header.ErrorHeader;
import com.tmax.custom.header.ErrorHeaderMsgJson;
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.ProHeaderMsgJson;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.header.SysHeaderMsgJson;
import com.tmax.custom.util.CheckTime;
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
		
		String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceOutputType()
				.getResourceName();
		
		
		String dtoMsgJsonPackage = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType()
				.getResourcePackage();
		
		
		String dtoMsgJsonPackages = ServiceGroupManager.getServiceMeta(serviceName).getServiceOutputType()
				.getResourcePackage();
		
		
		logger.info("\n ######### marshalErrorResponseBody input getServiceInputType()"+dtoMsgJsonPackage);
		logger.info("\n ######### marshalErrorResponseBody input getServiceOutputType()##########"+dtoMsgJsonPackages);
		
		
		String dtoMsgJsonClassName = dtoMsgJsonPackage + "." + dtoClassName + "MsgJson";
		Class cls = Class.forName(dtoMsgJsonClassName);
		Object obj = cls.newInstance();
		AbstractMessage dtoMsg = (AbstractMessage) obj;

	

		logger.info("\n\n### DTO ####  \n" + dtoClassName + "\n" + input.toString());

		protocol.setDto(input);
		
		
		
		
		

		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();

		JsonObject returnObject = new JsonObject();

		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));

		JsonObject errorHeader = (JsonObject) gson.toJsonTree(requestContext.getUserDataContext().get("ErrorHeader"));
//		responseMsgParameters
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
		
		JsonObject returnObject = new JsonObject();
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();
		// 서블릿 호출
		if (requestContext.getRequest().getWebHeader().get("msg-type") != null && 
				requestContext.getRequest().getWebHeader().get("msg-type").equals("TEST")) {
			logger.info("\n ######### 서블릿 호출 ###############");
			

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

			logger.info("\n ######### marshalResponseBody End ##########");

			return returnObject.toString().getBytes();
			
		} else {

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

			logger.info("\n ######### marshalResponseBody End ##########");

			endTime = CheckTime.endTime();
			
			CheckTime.leadTime(endTime, startTime);
			
			return returnObject.toString().getBytes();
		}

	}

	@Override
	public ProObjectHttpProtocol unmarshalRequestBody(InputStream inputStream, ServiceName serviceName,
			RequestContext requestContext, ProMapperMessageType arg3) throws Exception {

		logger.info("\n ######### unmarshalRequestBody Start ##########");
		
		logger.info("\n ######### unmarshalRequestBody RequestContext ##########\n"+requestContext);
		
		startTime = CheckTime.startTime();

//		검응용 requestContext 출력	
//		logger.info("\n ######### unmarshalRequestBody RequestContext : \n"+ requestContext);
		// TODO Auto-generated method stub
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

						/*
						 * dto 정보 로그 추가 value : dtoInfo
						 */
						// dtoClassName 헤더이름
						// element.toString() 실제 input
						// input.toString() 전체 값
//						logger.info("\n\n### Input Dto info #### : " + element.toString());

						Object input = dtoMsg.unmarshal(element.toString().getBytes(charset));

						logger.info("\n\n### DTO ####  \n" + dtoClassName + "\n" + input.toString());

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
		logger.info("\n ######### unmarshalRequestBody End ##########");
		return protocol;
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
