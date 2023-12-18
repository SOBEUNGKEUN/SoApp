package com.tmax.custom.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.handler.SampleBatchListener;
import com.tmax.custom.batch.step.SampleBatchDeleteStep;
import com.tmax.custom.batch.step.SampleBatchInsertStep;

@Configuration
public class SampleBatchInsertDelJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private SampleBatchInsertStep sampleBatchInsertStep;
	
	@Autowired
	private SampleBatchListener sampleBatchListener;
	
	@Autowired
	private SampleBatchDeleteStep sampleBatchDeleteStep;
	
	@Bean
	public Job SampleInsertDel() throws Exception {
		return jobBuilderFactory.get("SampleInsertDel")
				.incrementer(new RunIdIncrementer())
				.listener(sampleBatchListener)
				.flow(sampleBatchInsertStep.SampleInsertStep())
				.next(sampleBatchDeleteStep.SampleDeleteStep())
				.end()
				.build();
	}
	
}
