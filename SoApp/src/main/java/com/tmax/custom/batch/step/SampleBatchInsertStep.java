package com.tmax.custom.batch.step;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.tmax.custom.batch.dto.Emp;
import com.tmax.custom.batch.handler.SampleBatchProcessor;
import com.tmax.custom.batch.handler.SampleBatchReader;
import com.tmax.custom.batch.handler.SampleBatchWriter;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchInsertStep {
	
	private ProObjectLogger logger = BatchLogger.getLogger();
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	// reader
	@Autowired
	public SampleBatchReader sampleBatchReader;
	
	// processor
	@Autowired
	public SampleBatchProcessor sampleBatchProcessor;
	@Bean
	
	public Step SampleStep() {
		return stepBuilderFactory.get("SampleStep").tasklet((contribution, chunkContext) -> {
			 logger.info(">>>>> This is step1");
			 logger.info(">>>>> This is step1");
			return RepeatStatus.FINISHED;
			}).build();
	}
	
	@Bean
	public Step SampleInsertStep(MyBatisBatchItemWriter<Emp> sampleInsert, 
			@Qualifier("SampleBatchDataSourceTransactionManager") PlatformTransactionManager transactionManager)  throws Exception{
		return stepBuilderFactory.get("SampleStep").<Emp, Emp>chunk(2).reader(sampleBatchReader.empReader())
				.processor(sampleBatchProcessor.process()).writer(sampleInsert)
				.transactionManager(transactionManager)
				.build();
	}
}
