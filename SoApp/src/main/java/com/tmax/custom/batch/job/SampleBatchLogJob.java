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
public class SampleBatchLogJob {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job SampleBatchLogJob(SampleBatchListener sampleBatchListener, Step SampleLogStep1, Step SampleLogStep2, Step SampleLogStep3) {
		
		return jobBuilderFactory.get("SampleBatchLogJob").incrementer(new RunIdIncrementer()).listener(sampleBatchListener)
				.flow(SampleLogStep1).next(SampleLogStep2).next(SampleLogStep3).end().build();
	}
}
