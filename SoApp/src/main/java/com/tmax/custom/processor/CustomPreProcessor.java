package com.tmax.custom.processor;

import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.processor.PreProcessor;

import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
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

		// 반환용 헤더 headerData
		JsonObject headerData = new JsonObject();

//		logger.info("\n ### CustomPreProcessor requestContext : " + requestContext);
			
		// ProHeader
		JsonObject proHeaderData = (JsonObject)gson.toJsonTree(requestContext.getUserDataContext().get("ProHeader"));
			
//		logger.info("\n ### CustomPreProcessor proHeaderData : " + proHeaderData);

		String name = proHeaderData.get("name").getAsString();
		String enumber = proHeaderData.get("enumber").getAsString();
		String position = proHeaderData.get("position").getAsString();
		
		// SysHeader
		JsonObject sysHeaderData = (JsonObject)gson.toJsonTree(requestContext.getUserDataContext().get("SysHeader"));
		
//		logger.info("\n ### CustomPreProcessor sysHeaderData : " + sysHeaderData);
		
		String ip = sysHeaderData.get("ip").getAsString();
		String userId = sysHeaderData.get("userId").getAsString();
		String userPwd = sysHeaderData.get("userPwd").getAsString();
		
		headerData.add("ProHeader", proHeaderData);
		headerData.add("SysHeader", sysHeaderData);

		logger.info("\n ### PreProcessor headerData #### : \n" + "ProHeader : "+headerData.get("ProHeader") +"\n"
				+"\n"+ "SysHeader : "+headerData.get("SysHeader") + "\n");
		return object;
	}

}
