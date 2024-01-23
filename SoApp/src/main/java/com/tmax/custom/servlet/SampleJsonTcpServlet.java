package com.tmax.custom.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.util.TcpUtils;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.application.servicegroup.ServiceGroupManager;
import com.tmax.proobject.model.resource.ResourceBasicType;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proframe.util.StringUtils;
import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
import proobject.com.google.gson.JsonElement;
import proobject.com.google.gson.JsonObject;
import proobject.com.google.gson.JsonParser;

@Component(value = "SampleJsonTcpServlet")
public class SampleJsonTcpServlet extends HttpServlet{
	
	private ProObjectLogger logger = SystemLogger.getLogger();
	
	private static final long serialVersionUID = -1279939644787622273L;
	
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("######## SampleJsonHttpServlet service ServletRequest 진입 ##############");
		logger.info("######## SampleJsonHttpServlet servletResponse : "+servletResponse);
		this.service((HttpServletRequest)servletRequest, (HttpServletResponse)servletResponse);
	}
	
	@Override
	protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("######## SampleJsonHttpServlet service HttpServletRequest 진입 ##############");
		logger.info("######## service httpServletResponse : "+httpServletResponse);
		try {
			this._service(httpServletRequest, httpServletResponse);
		} catch(Exception e) {
			responseException(httpServletResponse, e);
		} catch(Throwable t) {
			flushException(httpServletResponse, t);
		}
	}
	
	private void _service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
		logger.info("######## SampleJsonHttpServlet _service Start ##############");
		
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		ServletInputStream inputStream = httpRequest.getInputStream(); 
		logger.info("######## inputStream : " + inputStream);
		
		// inputStream에서 string으로 가공
		String tmpJsonformData = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		logger.info("######## tmpJsonformData : " + tmpJsonformData);
		
		// JSON 파싱
		@SuppressWarnings("deprecation")
		JsonParser parser = new JsonParser(); 
		@SuppressWarnings("deprecation")
		
		// Request 전문 파싱
		Object obj = parser.parse(tmpJsonformData);
		JsonObject jsonObj = (JsonObject)obj;

		// 요청 헤더 가져오기
		JsonElement tmpproheader = jsonObj.get("ProHeader");
		JsonElement tmpsysheader = jsonObj.get("SysHeader");
		ProHeader reqProHeader = objectMapper.readValue(tmpproheader.toString(), ProHeader.class);
		SysHeader reqSysHeader = objectMapper.readValue(tmpsysheader.toString(), SysHeader.class);
		
		// 헤더에 값 세팅
		if(StringUtils.isNull(reqProHeader.getGuid()))
			reqProHeader.setGuid("<94578fsd>");
		if(StringUtils.isNull(reqSysHeader.getIp()))
			reqSysHeader.setIp(httpRequest.getRemoteAddr());	
		
		// Custom 헤더
		CustomHeader customheader = new CustomHeader();
		customheader.setProHeader(reqProHeader);
		customheader.setSysHeader(reqSysHeader);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();
		JsonObject customHeaderJsonObj = (JsonObject) gson.toJsonTree(customheader);
		
		// Service input dto type 가쟈오기 
		String appName = reqProHeader.getAppName();
		String sgName = reqProHeader.getSgName();
		String svcName = reqProHeader.getSvcName();
		String fnName = reqProHeader.getFnName();
		
		// ex): APP_CH.SG_CH.ServletCallPC_testCall
		String reqServiceName = appName + "." + sgName + "." + svcName + "_" + fnName;
		ServiceName serviceName = new ServiceName(reqServiceName);
				
		String reqtDtoType = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourceName(); 
		String reqDtoPackage = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourcePackage();
		String reqDtoFullName = reqDtoPackage+"."+reqtDtoType;
		// DTO 파싱
		JsonElement reqInputDto = jsonObj.get(reqtDtoType);
		
		JsonObject reqjsonDtoObject = new JsonObject();
		reqjsonDtoObject.add(reqtDtoType, reqInputDto);
		
		TcpUtils caller = new TcpUtils();
		
		String response = caller.localJsCallReciever(customheader, customHeaderJsonObj, reqjsonDtoObject, serviceName, reqDtoFullName);
		
		
		// 응답 전송
		httpResponse.setContentType("applicatoin/json");
		httpResponse.setCharacterEncoding("UTF-8");
		
		logger.info("######## httpResponse : " + httpResponse);
		// tcp
		httpResponse.getWriter().write(response);
		
	}

	// HttpServletRequest 예외처리
	private void responseException(HttpServletResponse httpResponse, Exception e) {
		
		logger.error("\n\n### [ "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()))+ " ] [HttpServletRequest]"
				+ "[responseException] : internal Server Error");
		logger.error(e.getMessage(), e);
		
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty("ErrorCode", "-500");
		jsonObject.addProperty("ErrorMsg", e.getMessage());
		
		String resJsonMsg = gson.toJson(jsonObject);
		
		try {
			httpResponse.setContentType("application/json");
			httpResponse.setCharacterEncoding("UTF-8");
			httpResponse.getWriter().write(resJsonMsg);
		}catch(Exception e2) {
			flushException(httpResponse, e2);
		}
		
	}
	
	// HttpServletResponse 예외처리
	private void flushException(HttpServletResponse httpServletResponse, Throwable t) {
		logger.error("\n\n### [ "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()))+ " ] [HttpServletRequest]"
				+ "[flushException] : internal Server Error");
		logger.error(t.getMessage(), t);
		
		try {
			OutputStream os = httpServletResponse.getOutputStream();
			os.write(ExceptionUtils.getStackTrace(t).getBytes());
			os.flush();
			os.close();
		}catch(IOException e) {
			logger.error(e.getMessage(), e);
		}	
	}	
}
