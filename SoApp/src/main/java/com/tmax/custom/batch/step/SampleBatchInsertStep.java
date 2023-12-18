package com.tmax.custom.batch.step;

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
	
	// writed
	@Autowired
	public SampleBatchWriter sampleBatchWriter;
	
	// reader
	@Autowired
	public SampleBatchReader sampleBatchReader;
	
	// processor
	@Autowired
	public SampleBatchProcessor sampleBatchProcessor;
	
	@Autowired
	@Qualifier("SampleBatchDataSourceTransactionManager")
	private PlatformTransactionManager transactionManager; 
	
	@Bean
	public Step SampleStep() {
		return stepBuilderFactory.get("SampleStep").tasklet((contribution, chunkContext) -> {
			 logger.info(">>>>> This is step1");
			 logger.info(">>>>> This is step1");
			return RepeatStatus.FINISHED;
			}).build();
	}
	
	// MyBatis writer 사용
	@Bean
	public Step SampleInsertStep()  throws Exception{
		return stepBuilderFactory.get("SampleInsertStep")
				.<Emp, Emp>chunk(2)
				.reader(sampleBatchReader.empReader())
				.processor(sampleBatchProcessor.process())
				.writer(sampleBatchWriter.empWriter())
				.transactionManager(transactionManager)
				.build();
	}
	
	// 커스텀 writer 사용
	@Bean
	public Step SampleCustomInsertStep()  throws Exception{
		return stepBuilderFactory.get("SampleCustomInsertStep")
				.<Emp, Emp>chunk(2)
				.reader(sampleBatchReader.empReader())
				.processor(sampleBatchProcessor.process())
				.writer(sampleBatchWriter.customWriter())
				.transactionManager(transactionManager)
				.build();
	}
}
