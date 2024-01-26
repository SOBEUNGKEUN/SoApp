package com.tmax.custom.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.ProHeaderMsgXml;
import com.tmax.custom.header.SysHeader;
import com.tmax.custom.header.SysHeaderMsgXml;
import com.tmax.custom.util.RecieverCaller;
import com.tmax.custom.util.TcpUtils;
import com.tmax.custom.util.XmlUtils;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.application.servicegroup.ServiceGroupManager;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

import proframe.util.StringUtils;
import proobject.com.google.gson.Gson;
import proobject.com.google.gson.GsonBuilder;
import proobject.com.google.gson.JsonObject;

@Component(value = "SampleXmlHttpServlet")
public class SampleXmlHttpServlet extends HttpServlet {

	private ProObjectLogger logger = SystemLogger.getLogger();

	private static final long serialVersionUID = -1279939644787622273L;

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("######## SampleXmlHttpServlet service ServletRequest 진입 ##############");
		logger.info("######## SampleXmlHttpServlet servletResponse : " + servletResponse);
		this.service((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
	}

	@Override
	protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		logger.info("######## SampleXmlHttpServlet service HttpServletRequest 진입 ##############");
		logger.info("######## service httpServletResponse : " + httpServletResponse);
		try {
			this._service(httpServletRequest, httpServletResponse);
		} catch (Exception e) {
			responseException(httpServletResponse, e);
		} catch (Throwable t) {
			flushException(httpServletResponse, t);
		}
	}

	private void _service(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {
		logger.info("######## SampleXmlHttpServlet _service Start ##############");

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

		// 요청전문
		String reqXmlformData = "";
		// 응답전문
		String resXmlformData = "";
		// 결과
		String result = "";

		String responseResult = "";

		ServletInputStream inputStream = httpRequest.getInputStream();
		logger.info("######## inputStream : " + inputStream);

		// inputStream에서 string으로 가공
		String tmpXmlformData = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		logger.info("######## tmpXmlformData : " + tmpXmlformData);

		String queryString = httpRequest.getQueryString();
		logger.info("######## queryString : " + queryString);

		String remoteAdress = httpRequest.getRemoteAddr();
		logger.info("######## remoteAdress : " + remoteAdress);

		// 요청 uri
		String requestURI = httpRequest.getRequestURI();
		logger.info("######## requestURI : " + requestURI);

		// XML 파싱
		Document doc = XmlUtils.doDomParse(tmpXmlformData);

		NodeList proNodeList = doc.getElementsByTagName("ProHeader");
		NodeList sysNodeList = doc.getElementsByTagName("SysHeader");

		Node proElement = proNodeList.item(0);
		Node sysElement = sysNodeList.item(0);

		String charset = Charset.defaultCharset().toString();

		AbstractMessage proHeaderMsg = new ProHeaderMsgXml();
		ProHeader tmpProHeader = (ProHeader) proHeaderMsg
				.unmarshal(XmlUtils.covertNodeToString(proElement).getBytes(charset));
		ProHeader reqProHeader = (ProHeader) proHeaderMsg
				.unmarshal(XmlUtils.covertNodeToString(proElement).getBytes(charset));

		logger.info("######## reqProHeader : " + reqProHeader);

		AbstractMessage sysHeaderMsg = new SysHeaderMsgXml();

		SysHeader tmpSysHeader = (SysHeader) sysHeaderMsg
				.unmarshal(XmlUtils.covertNodeToString(sysElement).getBytes(charset));
		SysHeader reqSysHeader = (SysHeader) sysHeaderMsg
				.unmarshal(XmlUtils.covertNodeToString(sysElement).getBytes(charset));

		logger.info("######## reqSysHeader : " + reqSysHeader);

		// Vadlidation Check
		// DataSet 체크
		validateDataSet(reqProHeader, reqSysHeader);

		// 필수 값 체크
		validateField(reqProHeader.getName(), reqProHeader.getEnumber());

		// 헤더에 값 세팅
		if (StringUtils.isNull(reqProHeader.getGuid()))
			reqProHeader.setGuid("<94578fsd>");
		if (StringUtils.isNull(reqSysHeader.getIp()))
			reqSysHeader.setIp(httpRequest.getRemoteAddr());

		reqXmlformData = XmlUtils.covertXmlToString(doc);

		// =================== EventManager 통신용 로직 추가 ========================

		logger.info("######## EventManager XML ####################");
		// Custom 헤더
		CustomHeader customheader = new CustomHeader();
		customheader.setProHeader(reqProHeader);
		customheader.setSysHeader(reqSysHeader);

		logger.info("######## customheader : " + customheader);
		// customHeaderJsonObj
		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd hh.mm.ss").create();
		JsonObject customHeaderJsonObj = (JsonObject) gson.toJsonTree(customheader);

		// dtoObject
		// Service input dto type 가쟈오기
		String appName = reqProHeader.getAppName();
		String sgName = reqProHeader.getSgName();
		String svcName = reqProHeader.getSvcName();
		String fnName = reqProHeader.getFnName();

		// 분기용 필드값

		String user = reqSysHeader.getUserId();
		// ex): APP_CH.SG_CH.ServletCallPC_testCall
		String reqServiceName = appName + "." + sgName + "." + svcName + "_" + fnName;
		ServiceName serviceName = new ServiceName(reqServiceName);

		String reqtDtoType = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType().getResourceName();
		String reqDtoPackage = ServiceGroupManager.getServiceMeta(serviceName).getServiceInputType()
				.getResourcePackage();
		String reqDtoFullName = reqDtoPackage + "." + reqtDtoType;

		String dtoMsgXmlClassName = reqDtoPackage + "." + reqtDtoType + "MsgXml";
		Class cls = Class.forName(dtoMsgXmlClassName);

		Object obj = cls.newInstance();
		AbstractMessage dtoMsg = (AbstractMessage) obj;

		NodeList dtoNodeList = doc.getElementsByTagName(reqtDtoType);

		Node dtoElement = dtoNodeList.item(0);

		Object inputdto = dtoMsg.unmarshal(XmlUtils.covertNodeToString(dtoElement).getBytes(charset));

		logger.info("######## inputdto : " + inputdto);

		logger.info("######## getUserId : " + user);
		logger.info("######## equals : " + user.equals("lnijn320"));

		if (user.equals("lnijn320")) {

			logger.info("######## Http 통신 입니다 ##################");

			// PO21 호출 (http)
			responseResult = xmlCallReciever(httpRequest, reqProHeader, reqSysHeader, reqXmlformData, resXmlformData,
					reqProHeader.toString(), reqSysHeader.toString(), queryString, remoteAdress, result);

			logger.info("######## responseResult ################## : " + responseResult);
		} else {
			logger.info("######## Tcp 통신 입니다 ##################");

			// localPo21 호출 (eventManager)
			responseResult = eventManagerReciever(customheader, serviceName, reqDtoFullName, result, doc, inputdto);
			logger.info("######## responseResult ################## : " + responseResult);
		}
		// 응답 전송
		httpResponse.setContentType("applicatoin/xml");
		httpResponse.setCharacterEncoding("UTF-8");
		httpResponse.getWriter().write(responseResult);

	}

	// XML Reciever
	private String xmlCallReciever(HttpServletRequest httpRequest, ProHeader reqProHeader, SysHeader reqSysHeader,
			String reqXmlformData, String resXmlformData, String tmpproheader, String tmpsysheader, String queryString,
			String remoteAdress, String result) throws IOException {

		RecieverCaller caller = new RecieverCaller();
		result = caller.xmlCallReciever(reqXmlformData, queryString, remoteAdress, reqProHeader, reqSysHeader);

		return result;
	}

	// xml EventManager 호출
	private String eventManagerReciever(CustomHeader customheader, ServiceName serviceName, String reqDtoFullName,
			String result, Document doc, Object inputdto) throws Exception {
		logger.info("\n###########  eventManagerReciever XML  ################");

		TcpUtils caller = new TcpUtils();

		result = caller.localXmlCallReciever(customheader, serviceName, reqDtoFullName, result, doc, inputdto);
		logger.info("\n###########  eventManagerReciever result  ################ \n"+result);
		return result;
	}

	// HttpServletRequest 예외처리
	private void responseException(HttpServletResponse httpResponse, Exception e) {

		logger.error("\n\n### [ "
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()))
				+ " ] [HttpServletRequest]" + "[responseException] : internal Server Error");
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
		} catch (Exception e2) {
			flushException(httpResponse, e2);
		}

	}

	// HttpServletResponse 예외처리
	private void flushException(HttpServletResponse httpServletResponse, Throwable t) {
		logger.error("\n\n### [ "
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()))
				+ " ] [HttpServletRequest]" + "[flushException] : internal Server Error");
		logger.error(t.getMessage(), t);

		try {
			OutputStream os = httpServletResponse.getOutputStream();
			os.write(ExceptionUtils.getStackTrace(t).getBytes());
			os.flush();
			os.close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	// Input 데이터 validaion 체크
	public void validateDataSet(ProHeader reqProHeader, SysHeader reqSysHeader) throws Exception {
		if (reqProHeader == null) {
			throw new Exception("invalid ProHeader request");
		} else if (reqSysHeader == null) {
			throw new Exception("invalid SysHeader request");
		}
	}

	// 필수값 체크 (이름, 사번)
	public void validateField(String name, int enumber) throws Exception {
		if (name == null) {
			logger.error("There is no name, Please check your name");
			throw new Exception("invalid name request");
		} else if (enumber == 0) {
			logger.error("There is no enumber, Please check your enumber");
			throw new Exception("invalid enumber request");
		}
	}

}
