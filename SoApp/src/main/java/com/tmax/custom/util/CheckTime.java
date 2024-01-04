package com.tmax.custom.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

public class CheckTime {

	public static ProObjectLogger logger = SystemLogger.getLogger();
	
	static long startTime;
	static long endTime;
	static long leadTime;
		
	public static String time(long time) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(time));
	}
	
	public static long startTime() {
		startTime = System.currentTimeMillis();
		String formatTime = time(startTime);
		logger.info("Service Started Time :" +formatTime);
		return startTime;
	}
	
	public static long endTime() {
		endTime = System.currentTimeMillis();
		String formatTime = time(endTime);
		logger.info("Service End Time :" +formatTime);
		return endTime;
	}
	
	public static void leadTime(long start, long end) {
		leadTime = start-end;
		String formatTime = time(leadTime);
		logger.info("\n###### Service lead Time : "+formatTime+" #######");
		
	}
}
