package com.tmax.custom.util;

import java.io.IOException;
import java.util.Map;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.core2.util.consistency.GUID;
import com.tmax.proobject.engine.event.ServiceRequestEvent;
import com.tmax.proobject.engine.manager.EventManager;
import com.tmax.proobject.engine.manager.SystemManager;
import com.tmax.proobject.engine.parser.DefaultProObjectBodyParser;
import com.tmax.proobject.engine.waitobject.WaitObject;
import com.tmax.proobject.engine.waitobject.WaitObjectResource;
import com.tmax.proobject.model.network.ProObjectRequest;
import com.tmax.proobject.model.network.StandardChannelType;
import com.tmax.proobject.model.network.context.NetworkContext;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.model.servicegroup.ServiceMeta;
import com.tmax.proobject.network.context.NetworkContextImpl;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proobject.com.google.gson.JsonObject;

public class TcpUtils {

	private ProObjectLogger logger = SystemLogger.getLogger();

	public String localJsCallReciever(CustomHeader customheader, JsonObject customHeaderJsonObj,JsonObject dtoObject, ServiceName serviceName, 
			String reqDtoFullName) throws IOException {

		String outputJsonData = "TCP 통신용 테스트 입니다.";	
		logger.info("########### localJsCallReciever 진입 ####### ");

		logger.info("########### customheader #######\n" + customheader);
		logger.info("########### customHeaderJsonObj #######\n" + customHeaderJsonObj);
		logger.info("########### dtoObject #######\n" + dtoObject);
		
		NetworkContext requesterNetworkContext = NetworkContextImpl.LOCAL_NETWORK_CONTEXT;

		NetworkContext responserNetworkContext = NetworkContextImpl.LOCAL_NETWORK_CONTEXT;

		ProObjectRequest proObjectRequest = new ProObjectRequest(-1, serviceName, ProMapperMessageType.JSON,
				ProMapperMessageType.JSON);

		proObjectRequest.setHeader(customheader);
		proObjectRequest.setChannelType(StandardChannelType.PROOBJECT);

		logger.info("\n########### After Header setting proObjectRequest :  \n" + proObjectRequest);

		GUID guid = SystemManager.generateGUID();

		RequestContext requestContext = new RequestContext(requesterNetworkContext, responserNetworkContext,
				proObjectRequest, guid);
		
		ServiceMeta serviceMeta = new ServiceMeta();

		// WaitObjectResource
		WaitObjectResource waitobjectResource = new WaitObjectResource(requestContext, serviceMeta, CustomHeader.class,
				new DefaultProObjectBodyParser());

		logger.info("\n########### waitobjectResource :  \n" + waitobjectResource);


		// Class.forName(dtoName) : SampleDTO.class
		WaitObject waitobject = null;
		try {
			waitobject = new WaitObject(waitobjectResource, Class.forName(reqDtoFullName));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
			e1.printStackTrace();
		}
		
		logger.info("\n########### waitobject  \n" +waitobject);
		
		ServiceRequestEvent requestEvent = new ServiceRequestEvent(serviceName, customHeaderJsonObj.toString().getBytes(),
				dtoObject.toString().getBytes(), requestContext, waitobject);
		requestEvent.setServiceMeta(serviceMeta);
		EventManager.postEvent(requestEvent);

		logger.info("\n########### waitobject  \n" +waitobject);
		
		SampleDTO result = null;
		SampleDTO output = new SampleDTO();
		try {

			if (waitobject.waitUntilDone(10000) != null) {
				result =  (SampleDTO) waitobject.get();				
			}

		} catch (Throwable e) {
			throw new RuntimeException(e);
		}

		logger.info("\n########### result  \n" +result);
		
		Map<String, Object> userData = requestContext.getUserDataContext();
		
		JsonObject returnObject = new JsonObject();
		
		JsonObject returnObjects = new JsonObject();
		
		returnObjects.add("ProHeader", returnObject = (JsonObject) requestContext.getUserDataContext().get("ProHeader"));
		returnObjects.add("SysHeader", returnObject = (JsonObject) requestContext.getUserDataContext().get("SysHeader"));
		returnObjects.add("dto", returnObject = (JsonObject) requestContext.getUserDataContext().get("output"));
		
		logger.info("\n########### returnObject  \n" +returnObjects);
	
		return returnObjects.toString();
	}
}
