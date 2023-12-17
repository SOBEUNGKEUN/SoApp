package com.tmax.custom.batch.handler;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.context.annotation.Configuration;

import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchListener extends JobExecutionListenerSupport{
	
	// extends StepExecutionListenerSupport 대체가능
	
	private ProObjectLogger logger = BatchLogger.getLogger();
	
	// 시작시간
	long startTime;
	// 종료 시간
	long endTime;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		logger.info("#### Before Job ###");
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		endTime = System.currentTimeMillis();
		logger.info("#### 걸린 시간: "+ (endTime - startTime));
		logger.info("#### After Job ###");
	}

}
