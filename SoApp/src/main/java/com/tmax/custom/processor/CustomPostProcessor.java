package com.tmax.custom.processor;

import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.processor.PostProcessor;

@Component(value = "CustomPostProcessor")
public class CustomPostProcessor implements PostProcessor{

	private ProObjectLogger logger = SystemLogger.getLogger();
	
	@Override
	public Object processPostProcess(RequestContext requestContext, ServiceName serviceName, Object serviceInput, Object serviceOutput) {
		
		logger.info("\n ######### CustomPostProcessor Start ##########");
		
		logger.info("\n ######### CustomPostProcessor End ##########");
		// TODO Auto-generated method stub
		return null;
	}

}
