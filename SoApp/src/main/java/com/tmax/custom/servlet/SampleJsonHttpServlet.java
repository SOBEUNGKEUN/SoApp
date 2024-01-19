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
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.util.RecieverCaller;
import com.tmax.custom.util.TcpUtils;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proframe.util.StringUtils;
import proobject.com.google.gson.Gson;
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
		
		// 요청전문 
		String reqJsonformData ="";
		// 응답전문
		String resJsonformData ="";
		// 결과
		String result ="";
		
		String responseResult = "";
		
		// PO21 내부호출 프로토콜 변경 호출
		String localresponseResult = "";
		
		
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
		JsonObject jsonObj = (JsonObject)obj;

		
		// 요청 헤더 가져오기
		JsonElement tmpproheader = jsonObj.get("ProHeader");

		JsonElement tmpsysheader = jsonObj.get("SysHeader");

		ProHeader reqProHeader = objectMapper.readValue(tmpproheader.toString(), ProHeader.class);
		SysHeader reqSysHeader = objectMapper.readValue(tmpproheader.toString(), SysHeader.class);
			
		// Vadlidation Check
		// DataSet 체크
		validateDataSet(reqProHeader, reqSysHeader);
		
		// 필수 값 체크
		validateField(reqProHeader.getName(), reqProHeader.getEnumber());
		
		// 헤더에 값 세팅
		if(StringUtils.isNull(reqProHeader.getGuid()))
			reqProHeader.setGuid("<94578fsd>");
		if(StringUtils.isNull(reqSysHeader.getIp()))
			reqSysHeader.setIp(httpRequest.getRemoteAddr());	
		
		// 전문 만들기
		JsonObject proHeader = (JsonObject) jsonObj.get("ProHeader");
		proHeader.addProperty("guid", reqProHeader.getGuid());
		
		JsonObject sysHeader = (JsonObject) jsonObj.get("SysHeader");
		sysHeader.addProperty("ip", reqSysHeader.getIp());
		
		// 만들어진 헤더 세팅
		jsonObj.add("ProHeader", proHeader);
		jsonObj.add("SysHeader", sysHeader);
		
		reqJsonformData = jsonObj.toString();
		
		logger.info("######## reqJsonformData : " + reqJsonformData);
		
		// PO21 호출
		responseResult = jsonCallReciever(httpRequest, reqProHeader, reqSysHeader, reqJsonformData,
				resJsonformData, proHeader.toString(), sysHeader.toString(), queryString, remoteAdress, result);
		
		// localPo12 호출
//		localresponseResult = localJsonCallReciever(httpRequest, reqProHeader, reqSysHeader, reqJsonformData,
//				resJsonformData, proHeader.toString(), sysHeader.toString(), queryString, remoteAdress, result);
		
		
		// 응답 전송
		httpResponse.setContentType("applicatoin/json");
		httpResponse.setCharacterEncoding("UTF-8");
		httpResponse.getWriter().write(responseResult);
		// tcp
//		httpResponse.getWriter().write(localresponseResult);
		
	}
	

	// JSON Reciever
	private String jsonCallReciever(HttpServletRequest httpRequest, ProHeader reqProHeader, SysHeader reqSysHeader, 
			String reqJsonformData, String resJsonformData, String tmpproheader, String tmpsysheader, String queryString, String remoteAdress, String result) throws IOException {
		logger.info("######## jsonCallReciever Start ########## " );
		
		RecieverCaller caller = new RecieverCaller();
		result = caller.jsCallReciever(reqJsonformData, queryString, remoteAdress, reqProHeader, reqSysHeader);
		
		return result;
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
	
	// Input 데이터 validaion 체크
	public void validateDataSet(ProHeader reqProHeader, SysHeader reqSysHeader) throws Exception{
		if (reqProHeader == null) {
			throw new Exception("invalid ProHeader request");
		} else if(reqSysHeader == null) {
			throw new Exception("invalid SysHeader request");
		}
	}
	
	// 필수값 체크 (이름, 사번)
	public void validateField(String name, int enumber) throws Exception{
		if(name == null) {
			logger.error("There is no name, Please check your name");
			throw new Exception("invalid name request");
		}else if(enumber == 0) {
			logger.error("There is no enumber, Please check your enumber");
			throw new Exception("invalid enumber request");
		}
	}
	
}
