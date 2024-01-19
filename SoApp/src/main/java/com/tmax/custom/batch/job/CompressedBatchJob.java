
package com.tmax.custom.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.handler.SampleBatchListener;
import com.tmax.custom.batch.step.CompressedBatchStep;
import com.tmax.custom.batch.step.SampleBatchInsertStep;

@Configuration
public class CompressedBatchJob {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private CompressedBatchStep compressedBatchStep;
	
	@Autowired
	private SampleBatchListener sampleBatchListener;
	
	@Autowired
	private SampleBatchInsertStep sampleBatchInsertStep;
	
	@Bean
	public Job compressJob() throws Exception {
		return jobBuilderFactory.get("compressJob")
				.incrementer(new RunIdIncrementer())
				.listener(sampleBatchListener)
				.flow(sampleBatchInsertStep.SampleStep())
				.next(compressedBatchStep.compresseStep())
				.end()
				.build();
		
	}
	@Bean
	public Job compressJobrmExtension() throws Exception {
		return jobBuilderFactory.get("compressJobrmExtension")
				.incrementer(new RunIdIncrementer())
				.listener(sampleBatchListener)
				.flow(sampleBatchInsertStep.SampleStep())
				.next(compressedBatchStep.compresseStep())
//				.next(compressedBatchStep.removeExtensionStep())
				.end()
				.build();
		
	}
}
