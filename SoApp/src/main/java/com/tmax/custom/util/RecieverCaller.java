package com.tmax.custom.util;

import java.io.IOException;

import com.tmax.custom.header.ProHeader;
import com.tmax.custom.header.SysHeader;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

public class RecieverCaller {

	private ProObjectLogger logger = SystemLogger.getLogger();

	public String jsCallReciever(String reqJsonformData, String queryString, String remoteAddress, ProHeader proHeader,
			SysHeader sysHeader) throws IOException {
		logger.info("######## jsCallReciever Start ########## ");

		String outputJsonData = "";
		String poServletUrl = getPoServletUrl(proHeader, sysHeader, remoteAddress);
		logger.info("########### poServletUrl ####### : " + poServletUrl);

		String httpurl = Property.getPO21ServletUrl(poServletUrl);
		logger.info("########### httpurl ####### : " + httpurl);

		try {
			// 호출
			// http 방식
			outputJsonData = HttpUtils.requestPostData(httpurl, reqJsonformData, "UTF-8", "json");
		} catch (IOException e) {
			throw e;
		}
		return outputJsonData;
	}

	public String xmlCallReciever(String reqJXmlformData, String queryString, String remoteAddress, ProHeader proHeader,
			SysHeader sysHeader) throws IOException {

		logger.info("######## xmlCallReciever Start ########## ");

		String outputXmlData = "";
		String poServletUrl = getPoServletUrl(proHeader, sysHeader, remoteAddress);
		logger.info("########### poServletUrl ####### : " + poServletUrl);

		String httpurl = Property.getPO21ServletUrl(poServletUrl);
		logger.info("########### httpurl ####### : " + httpurl);

		try {
			// 호출
			// http 방식
			outputXmlData = HttpUtils.requestPostData(httpurl, reqJXmlformData, "UTF-8", "xml");
		} catch (IOException e) {
			throw e;
		}
		return outputXmlData;
	}

	private String getPoServletUrl(ProHeader proHeader, SysHeader sysHeader, String remoteAddress) {

		logger.info("######## getPoServletUrl Start ########## ");

		logger.info("########### proHeader ####### : " + proHeader);
		logger.info("########### sysHeader ####### : " + sysHeader);
		logger.info("########### remoteAddress ####### : " + remoteAddress);

		String po21EntrySvc = proHeader.getAppName() + "/" + proHeader.getSgName() + "/" + proHeader.getSvcName() + "_"
				+ proHeader.getFnName();

		return po21EntrySvc;
	}
}
