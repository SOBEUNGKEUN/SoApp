package com.tmax.custom.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.tmax.proobject.engine.ProObject;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

public class HttpUtils {

	public static String requestPostData(String address, String data, String encChar) throws IOException {

		ProObjectLogger logger = SystemLogger.getLogger();

		logger.info("##### requestPostData Start #### : ");

		StringBuilder sb;

		HttpURLConnection conn = null;
		DataOutputStream os = null;
		BufferedReader br = null;

		try {
			logger.info("##### 커넥션 시도 #### : ");
			logger.info("##### address : " + address);
			logger.info("##### encChar : " + encChar);
			// connection
			conn = getNewHttpURLConnection(address, encChar);
			logger.info("##### conn : " + conn);
			// outputStream
			os = writeOutputStream(data, encChar, conn);
			logger.info("##### os : " + os);
			// inputStream
			br = readInputStream(encChar, conn);
			logger.info("##### br : " + br);

			// inputStream 읽기
			String sbuild;
			sb = new StringBuilder();
			while ((sbuild = br.readLine()) != null)
				sb.append(sbuild + "\n");
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally { // 자원 clsoe
			try {
				logger.info("##### finally 진입 #### : ");
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (conn != null)
				conn.disconnect();
		}
		logger.info("##### StringBuilder #### : " + sb.toString());
		return sb.toString();
	}

	// URLConnection
	private static HttpURLConnection getNewHttpURLConnection(String address, String encChar)
			throws MalformedURLException, IOException, ProtocolException {
		ProObjectLogger logger = SystemLogger.getLogger();
		// specGB : ws, tf, xp 플랫폼 구분자
		logger.info("############# HttpURLConnection 진입 ###########");
		HttpURLConnection conn;
		URL url = new URL(address);
		logger.info("##### url : " + url);
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		conn.setConnectTimeout(10000);
		conn.setReadTimeout(300000);

		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Msg-Type", "TEST");
		conn.setRequestProperty("charset", encChar);

		logger.info("##### conn : " + conn);

		return conn;
	}

	// OutputStream
	private static DataOutputStream writeOutputStream(String data, String encChar, HttpURLConnection conn)
			throws IOException, UnsupportedEncodingException {
		ProObjectLogger logger = SystemLogger.getLogger();
		DataOutputStream os;
		// connection에서 outputstream 값 가져오기
		os = new DataOutputStream(conn.getOutputStream());
		// 데이터 내보내기
		os.write(data.getBytes(encChar));
		os.flush();
		logger.info("#### os : " + os);
		return os;
	}

	// InputStream
	private static BufferedReader readInputStream(String enchar, HttpURLConnection conn)
			throws UnsupportedEncodingException, IOException {

		ProObjectLogger logger = SystemLogger.getLogger();

		String masterIp = conn.getURL().getHost();

		logger.info("########### conn.getUrl.getHost() : " + masterIp);
		logger.info("########### conn.getUrl.getResponseCode() : " + conn.getResponseCode());

		
		logger.info("########### ProObject.getMasterIp() : " + ProObject.getMasterIp());
		logger.info("########### ProObject.getMasterPort() : " + ProObject.getMasterPort());
		// po 내부 호출

		logger.info("########### po 내부 호출 ###########  ");
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), enchar));
		return br;
		
		
		// 응답 코드 400 이하 일때 -> 정상 처리
		// ProObject.getMasterIp() == node-app
//		if (conn.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
//			BufferedReader br;
//			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), enchar));
//			return br;
//		} else { // 400이상일 때 에러 스트림 처리
//			BufferedReader br;
//			br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), enchar));
//			return br;
//		}
	}
}
