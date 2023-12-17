package com.tmax.custom.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchLogStep {
	
	private ProObjectLogger logger = BatchLogger.getLogger();
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step SampleLogStep1() {
		return stepBuilderFactory.get("SampleLogStep1").tasklet((contribution, chunkContext) -> {
			logger.info("\n>>>> This is SampleLogStep1_1");
			Thread.sleep(3000);
			logger.info("\n>>>> This is SampleLogStep1_2");
			Thread.sleep(3000);
			
			return RepeatStatus.FINISHED;
			}).build();
	}
	@Bean
	public Step SampleLogStep2() {
		return stepBuilderFactory.get("SampleLogStep2").tasklet((contribution, chunkContext) -> {
			logger.info("\n>>>> This is SampleLogStep2_1");
			Thread.sleep(3000);
			logger.info("\n>>>> This is SampleLogStep2_2");
			Thread.sleep(3000);
			
			return RepeatStatus.FINISHED;
			}).build();
	}
	@Bean
	public Step SampleLogStep3() {
		return stepBuilderFactory.get("SampleLogStep3").tasklet((contribution, chunkContext) -> {
			logger.info("\n>>>> This is SampleLogStep3_1");
			Thread.sleep(3000);
			logger.info("\n>>>> This is SampleLogStep3_2");
			Thread.sleep(3000);
			
			return RepeatStatus.FINISHED;
			}).build();
	}
	
}
