package com.tmax.custom.processor;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import com.tmax.custom.header.CustomHeader;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.runtime.messagebundle.ProObjectMessageBundleManager;
import com.tmax.proobject.runtime.messagebundle.messagesource.ProObjectMessageSourceAccessor;
import com.tmax.proobject.service.processor.ErrorProcessor;

@Component(value = "CustomErrorProcessor")
public class CustomErrorProcessor implements ErrorProcessor{

	private ProObjectLogger logger = SystemLogger.getLogger();
	
	@Autowired
	ProObjectMessageBundleManager pmbm;
	
	@Override
	public void processServiceError(RequestContext requestContext, ServiceName serviceName, Object object, Throwable t) {
		// TODO Auto-generated method stub
		logger.info("\n ######### CustomErrorProcessor Start ##########");
		
		
		logger.info("\n ######### CustomErrorProcessor object ##########"+object);
		
		logger.info("\n ######### CustomErrorProcessor requestContext : \n"+requestContext);
		
		
		String responseCode = "";
		if(requestContext.getRequest().getResponseCode() != null) {
			responseCode = requestContext.getRequest().getResponseCode();
			
			logger.info("\n ######### CustomErrorProcessor responseCode : \n"+responseCode);
		}
		
		Object[] responseMsg = {};
		if (requestContext.getRequest().getResponseMsgParameters() != null) {
			responseMsg = requestContext.getRequest().getResponseMsgParameters();
			for (int i=0; i< responseMsg.length; i++) {
				logger.info("\n ######### CustomErrorProcessor responseMsg : \n"+responseMsg[i]);
			}
		}
		
		String msg_type="";
		String msg_title="";
		String msg_name="";
		
//		String msg_param = String.valueOf(requestContext.getRequest().getResponseMsgParameters());
		
		
		
		logger.info("\n ######### getResponseMsgParameters ######### \n "+ requestContext.getRequest().getResponseMsgParameters());
		
		if(responseCode.startsWith("NON")) {
			responseCode = "E44E4";
			msg_type = "E";
			msg_title = "에러";
			msg_name = "에러 입니다";
			
		} else if (responseCode.equals("")) {
			logger.info("\n ######### String responseCode = null ######### \n ");
			for(int i=0; i<responseMsg.length; i++) {
				msg_name += responseMsg[i];
			}
		}else {
			try {
				ProObjectMessageSourceAccessor pmsa = pmbm.getProObjectMessageSourceAccessor();
				msg_type = pmsa.getMessage(responseCode + "_MSG_TYPE", Locale.KOREA);
				msg_title = pmsa.getMessage(responseCode + "_MSG_TITLE", Locale.KOREA);
				msg_name = pmsa.getMessage(responseCode + "_MSG_NAME", responseMsg, Locale.KOREA);
			}catch(NoSuchMessageException e) {
				logger.error(e.getMessage(), e);
			}
		}	
		CustomHeader customHeader = (CustomHeader) requestContext.getRequest().getHeader();
		customHeader.getErrorHeader().setResponseCode(responseCode);
		customHeader.getErrorHeader().setResponseType(msg_type);
		customHeader.getErrorHeader().setResponseTitle(msg_title);
		customHeader.getErrorHeader().setResponseBasic(msg_name);
		
		logger.info("\n ######### CustomErrorProcessor End ##########");
		
	}

}
