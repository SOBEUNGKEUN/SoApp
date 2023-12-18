package com.tmax.custom.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.ProHeaderMsgJson;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.header.SysHeaderMsgJson;
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

	@Override
	public byte[] marshalErrorResponseBody(Throwable arg0, Object arg1, ServiceName arg2, RequestContext arg3,
			ProMapperMessageType arg4) throws Exception {

		logger.info("\n ######### marshalErrorResponseBody ##########");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] marshalRequestBody(ProObjectHttpProtocol arg0, ServiceName arg1, RequestContext arg2,
			ProMapperMessageType arg3) throws Exception {
		logger.info("\n ######### marshalRequestBody ##########");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] marshalResponseBody(ProObjectHttpProtocol protocol, ServiceName serviceName, RequestContext requestContext,
			ProMapperMessageType arg3) throws Exception {

		logger.info("\n ######### marshalResponseBody ##########");
		// TODO Auto-generated method stub

		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();

		JsonObject returnObject = new JsonObject();

		logger.info("\n ### marshalResponseBody requestContext : " + requestContext);

		JsonElement userDataProHeader = gson.toJsonTree(requestContext.getUserDataContext().get("ProHeader"));
		returnObject.add("ProHeader", userDataProHeader);
		logger.info("\n ### marshalResponseBody userData1 : " + userDataProHeader);

		JsonElement userDataSysHeader = gson.toJsonTree(requestContext.getUserDataContext().get("SysHeader"));
		returnObject.add("SysHeader", userDataSysHeader);
		logger.info("\n ### marshalResponseBody userData2 : " + userDataSysHeader);

		String dtoClassName = ServiceGroupManager.getServiceMeta(serviceName).getServiceOutputType().getResourceName();

		logger.info("\n\n### Output Dto: " + dtoClassName);
		JsonElement dto = gson.toJsonTree(protocol.getDto());
		returnObject.add(dtoClassName, dto);

		return returnObject.toString().getBytes();

	}

	@Override
	public ProObjectHttpProtocol unmarshalRequestBody(InputStream inputStream, ServiceName serviceName,
			RequestContext requestContext, ProMapperMessageType arg3) throws Exception {

		logger.info("\n ######### unmarshalRequestBody ##########");
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

			logger.info("\n\n### Input Dto: " + dtoClassName);

			 String[] fieldNames = { "ProHeader", "SysHeader", dtoClassName };
				for (String fieldName : fieldNames) {
					JsonElement element = root.get(fieldName);
					if (element != null && element.isJsonNull() == false) {
				
						if ("ProHeader".equals(fieldName)) {
				
							AbstractMessage headerMsg = new ProHeaderMsgJson();
							ProHeader proHeader = (ProHeader) headerMsg.unmarshal(element.toString().getBytes(charset));
							userData.put("ProHeader", proHeader);
							customHeader.setProHeader(proHeader);
				
						} else if ("SysHeader".equals(fieldName)) {
							AbstractMessage headerMsg = new SysHeaderMsgJson();		
							SysHeader sysHeader = (SysHeader) headerMsg.unmarshal(element.toString().getBytes(charset));
							userData.put("SysHeader", sysHeader);
							customHeader.setSysHeader(sysHeader);
							
					} else if (dtoClassName.equals(fieldName)) {
						String dtoMsgJsonPackage = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType()
								.getResourcePackage();
						String dtoMsgJsonClassName = dtoMsgJsonPackage + "." + dtoClassName + "MsgJson";
						Class cls = Class.forName(dtoMsgJsonClassName);
						Object obj = cls.newInstance();
						AbstractMessage dtoMsg = (AbstractMessage) obj;

						Object input = dtoMsg.unmarshal(element.toString().getBytes(charset));
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

		return protocol;
	}
	@Override
	public ProObjectHttpProtocol unmarshalResponseBody(InputStream arg0, ServiceName arg1, RequestContext arg2,
			ProMapperMessageType arg3) throws Exception {
		logger.info("\n ######### unmarshalResponseBody ##########");
		// TODO Auto-generated method stub
		return null;
	}

}
