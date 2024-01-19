package com.tmax.custom.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.tmax.custom.batch.handler.SampleBatchDelTasklet;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchDeleteStep {
	
	private ProObjectLogger logger = BatchLogger.getLogger();
		
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private SampleBatchDelTasklet sampleBatchDelTasklet;
	
	@Autowired
	@Qualifier("SampleBatchDataSourceTransactionManager")
	private PlatformTransactionManager transactionManager; 
	
	@Bean
	public Step SampleDeleteStep(){
		logger.info("\n ### SampleDeleteStep ###");
		return stepBuilderFactory.get("SampleDeleteStep")
				.tasklet(sampleBatchDelTasklet)
				.transactionManager(transactionManager)
				.build();
	}
}
