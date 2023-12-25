package com.tmax.custom.processor;

import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.processor.PostProcessor;

import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
import proobject.com.google.gson.JsonObject;

@Component(value = "CustomPostProcessor")
public class CustomPostProcessor implements PostProcessor{

	private ProObjectLogger logger = SystemLogger.getLogger();
	
	@Override
	public Object processPostProcess(RequestContext requestContext, ServiceName serviceName, Object serviceInput, Object serviceOutput) {
		
		logger.info("\n ######### CustomPostProcessor Start ##########");
		
		logger.info("\n ######### CustomPostProcessor requestContext : \n"+ requestContext);
		
		// 반환용 헤더
		JsonObject returnObject = new JsonObject();
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();
		
		// 서블릿에서 가져온 값 세팅하기
		
		JsonObject proHeaderData = (JsonObject)gson.toJsonTree(requestContext.getUserDataContext().get("ProHeader"));
		JsonObject sysHeaderData = (JsonObject)gson.toJsonTree(requestContext.getUserDataContext().get("SysHeader"));
		
		returnObject.add("ProHeader", proHeaderData);
		returnObject.add("SysHeader", sysHeaderData);
		
		logger.info("\n ######### CustomPostProcessor returnObject : \n"+returnObject);
		
		logger.info("\n ######### CustomPostProcessor End ##########");
		// TODO Auto-generated method stub
		
		
		
		return returnObject.toString().getBytes();
	}

}
