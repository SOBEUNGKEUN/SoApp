package com.tmax.custom.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.handler.SampleBatchListener;

@Configuration
public class SampleBatchInsertJob {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job SampleInsert(SampleBatchListener sampleBatchListener, Step SampleStep, Step SampleInsertStep) {
		return jobBuilderFactory.get("SampleInsert").incrementer(new RunIdIncrementer()).listener(sampleBatchListener)
				.flow(SampleStep).next(SampleInsertStep).end().build();
	}
}
