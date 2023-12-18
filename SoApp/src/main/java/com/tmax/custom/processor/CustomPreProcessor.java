package com.tmax.custom.processor;

import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.application.servicegroup.ServiceGroupManager;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.processor.PreProcessor;

import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
import proobject.com.google.gson.JsonElement;
import proobject.com.google.gson.JsonObject;

@Component(value = "CustomPreProcessor")
public class CustomPreProcessor implements PreProcessor{
	
	private ProObjectLogger logger = SystemLogger.getLogger();
	@Override
	public Object processPreProcess(RequestContext requestContext, ServiceName serviceName, Object object) {
		// TODO Auto-generated method stub
		
		
		logger.info("\n ######### CustomPreProcessor Start ##########");
		// TODO Auto-generated method stub

		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();

		JsonObject returnObject = new JsonObject();

		logger.info("\n ### CustomPreProcessor requestContext : " + requestContext);

		JsonElement userDataProHeader = gson.toJsonTree(requestContext.getUserDataContext().get("ProHeader"));
		
		logger.info("\n ### CustomPreProcessor userDataProHeader : " + userDataProHeader);


		JsonElement userDataSysHeader = gson.toJsonTree(requestContext.getUserDataContext().get("SysHeader"));
		
		logger.info("\n ### CustomPreProcessor userDataSysHeader : " + userDataSysHeader);
		
		return returnObject;
	}

}
