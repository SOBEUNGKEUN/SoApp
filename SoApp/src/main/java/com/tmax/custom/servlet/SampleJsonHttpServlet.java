package com.tmax.custom.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proobject.com.google.gson.JsonElement;
import proobject.com.google.gson.JsonObject;
import proobject.com.google.gson.JsonParser;

@Component(value = "SampleJsonHttpServlet")
public class SampleJsonHttpServlet extends HttpServlet{
	
	private ProObjectLogger logger = SystemLogger.getLogger();
	
	private static final long serialVersionUID = -1279939644787622273L;
	
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("######## SampleJsonHttpServlet service ServletRequest 진입 ##############");
		this.service((HttpServletRequest)servletRequest, (HttpServletResponse)servletResponse);
	}
	
	@Override
	protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("######## SampleJsonHttpServlet service HttpServletRequest 진입 ##############");
		
		try {
			this._service(httpServletRequest, httpServletResponse);
		} catch(Exception e) {
			responseException(httpServletRequest, e);
		} catch(Throwable t) {
			flushException(httpServletResponse, t);
		}
	}
	
	private void _service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
		logger.info("######## SampleJsonHttpServlet _service Start ##############");
		
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		// 요청전문 
		String reqJsonforData ="";
		// 응답전문
		String resJsonforData ="";
		// 결과
		String result ="";
		
		ServletInputStream inputStream = httpRequest.getInputStream(); 
		logger.info("######## inputStream : " + inputStream);
		
		// inputStream에서 string으로 가공
		String tmpJsonformData = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		logger.info("######## tmpJsonformData : " + tmpJsonformData);
		
		String queryString = httpRequest.getQueryString();
		logger.info("######## queryString : " + queryString);
		
		String remoteAdress = httpRequest.getRemoteAddr();
		logger.info("######## remoteAdress : " + remoteAdress);
		
		// 요청 uri
		String requestURI = httpRequest.getRequestURI();
		logger.info("######## requestURI : " + requestURI);
		
		// JSON 파싱
		@SuppressWarnings("deprecation")
		JsonParser parser = new JsonParser(); 
		@SuppressWarnings("deprecation")
		// string 데이터 받아서 json으로 파싱후 object에 담기
		Object obj = parser.parse(tmpJsonformData);
		logger.info("######## obj : " + obj);
		JsonObject jsonObj = (JsonObject)obj;
		logger.info("######## jsonObj : " + jsonObj);
		
		// 헤더 가져오기
		JsonElement proheader = jsonObj.get("ProHeader");
		logger.info("######## proheader : " + proheader);
		JsonElement sysheader = jsonObj.get("SysHeader");
		logger.info("######## sysheader : " + sysheader);
		
		
	}
	
	// HttpServletRequest 예외처리
	private void responseException(HttpServletRequest httpRequest, Exception e) {
		
	}
	
	// HttpServletResponse 예외처리
	private void flushException(HttpServletResponse httpServletResponse, Throwable t) {
		
	}
}
