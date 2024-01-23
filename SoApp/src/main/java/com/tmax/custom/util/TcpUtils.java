package com.tmax.custom.util;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.core2.util.consistency.GUID;
import com.tmax.proobject.engine.application.servicegroup.ServiceGroupManager;
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
			String reqDtoFullName) throws Exception {

		String outputJsonData = "TCP 통신용 테스트 입니다.";	
		logger.info("########### localJsCallReciever 진입 ####### ");
		
		NetworkContext requesterNetworkContext = NetworkContextImpl.LOCAL_NETWORK_CONTEXT;

		NetworkContext responserNetworkContext = NetworkContextImpl.LOCAL_NETWORK_CONTEXT;

		ProObjectRequest proObjectRequest = new ProObjectRequest(-1, serviceName, ProMapperMessageType.JSON,
				ProMapperMessageType.JSON);

		proObjectRequest.setHeader(customheader);
		proObjectRequest.setChannelType(StandardChannelType.PROOBJECT);


		GUID guid = SystemManager.generateGUID();

		RequestContext requestContext = new RequestContext(requesterNetworkContext, responserNetworkContext,
				proObjectRequest, guid);
		
		ServiceMeta serviceMeta = new ServiceMeta();

		// WaitObjectResource
		WaitObjectResource waitobjectResource = new WaitObjectResource(requestContext, serviceMeta, CustomHeader.class,
				new DefaultProObjectBodyParser());

		// Class.forName(dtoName) : SampleDTO.class
		WaitObject waitobject = null;
		try {
			waitobject = new WaitObject(waitobjectResource, Class.forName(reqDtoFullName));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
			e1.printStackTrace();
		}
				
		ServiceRequestEvent requestEvent = new ServiceRequestEvent(serviceName, customHeaderJsonObj.toString().getBytes(),
				dtoObject.toString().getBytes(), requestContext, waitobject);
		requestEvent.setServiceMeta(serviceMeta);
		
		// 서비스 이벤트 발생
		// 이벤트 큐에 요청 전달
		EventManager.postEvent(requestEvent);
		
		Object result = null;
		
		// 주석 하면 결과 
		/*
		 * {
		    "ProHeader": null,
		    "SysHeader": null,
		    "SampleDTO": null
			}
		 * 
		 */
		
		try {

			if (waitobject.waitUntilDone(10000) != null) {
				result = waitobject.get();				
			}

		} catch (Throwable e) {
			throw new RuntimeException(e);
		}

		logger.info("\n########### result  \n" +result);
		
		JsonObject returnObject = new JsonObject();
		String dtoNameoutput = ServiceGroupManager.getServiceMeta(serviceName).getServiceOutputType().getResourceName();
		
		// 헤더 및 dto 매핑
		returnObject.add("ProHeader", (JsonObject) requestContext.getUserDataContext().get("ProHeader"));
		returnObject.add("SysHeader", (JsonObject) requestContext.getUserDataContext().get("SysHeader"));	
		returnObject.add(dtoNameoutput, (JsonObject) requestContext.getUserDataContext().get("outputElement"));
		
		return returnObject.toString();
	}
}
