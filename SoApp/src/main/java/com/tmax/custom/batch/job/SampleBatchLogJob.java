package com.tmax.custom.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.handler.SampleBatchListener;
import com.tmax.custom.batch.step.SampleBatchLogStep;

@Configuration
public class SampleBatchLogJob {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public SampleBatchLogStep sampleBatchLogStep;
	@Bean
	public Job SampleBatchLogJob(SampleBatchListener sampleBatchListener) {
		
		return jobBuilderFactory.get("SampleBatchLogJob")
				.incrementer(new RunIdIncrementer())
				.listener(sampleBatchListener)
				.start(sampleBatchLogStep.SampleLogStep1())
				.next(sampleBatchLogStep.SampleLogStep2())
				.next(sampleBatchLogStep.SampleLogStep3())
				.build();
	}
}
