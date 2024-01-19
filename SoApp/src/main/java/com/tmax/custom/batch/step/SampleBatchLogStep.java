package com.tmax.custom.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.tmax.custom.batch.handler.SampleBatchLogTasklet;
import com.tmax.custom.batch.handler.SampleBatchLogTasklet2;
import com.tmax.custom.batch.handler.SampleBatchLogTasklet3;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchLogStep {
	
	private ProObjectLogger logger = BatchLogger.getLogger();
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	

	@Autowired
	private SampleBatchLogTasklet sampleBatchLogTasklet;
	

	@Autowired
	private SampleBatchLogTasklet2 sampleBatchLogTasklet2;
	
	@Autowired
	private SampleBatchLogTasklet3 sampleBatchLogTasklet3;
	
	@Autowired
	@Qualifier("SampleBatchDataSourceTransactionManager")
	private PlatformTransactionManager transactionManager; 
	
	@Bean
	public Step SampleLogStep1() {
		return stepBuilderFactory.get("SampleLogStep1")
				.tasklet(sampleBatchLogTasklet)
				.transactionManager(transactionManager)
				.build();
	}
	@Bean
	public Step SampleLogStep2() {
		return stepBuilderFactory.get("SampleLogStep2")
				.tasklet(sampleBatchLogTasklet2)
				.transactionManager(transactionManager)
				.build();
	}
	@Bean
	public Step SampleLogStep3() {
		return stepBuilderFactory.get("SampleLogStep3")
				.tasklet(sampleBatchLogTasklet3)
				.transactionManager(transactionManager)
				.build();
	}
	
}
