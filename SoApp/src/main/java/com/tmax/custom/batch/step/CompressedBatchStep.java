package com.tmax.custom.batch.step;

import java.net.MalformedURLException;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.tmax.custom.batch.dto.Emp;
import com.tmax.custom.batch.handler.SampleBatchProcessor;
import com.tmax.custom.batch.handler.SampleBatchReader;
import com.tmax.custom.batch.handler.SampleBatchRemove;
import com.tmax.custom.batch.handler.SampleBatchWriter;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class CompressedBatchStep {

	private ProObjectLogger logger = BatchLogger.getLogger();
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("SampleBatchDataSourceTransactionManager")
	private PlatformTransactionManager transactionManager; 
	
	// processor
	@Autowired
	public SampleBatchProcessor sampleBatchProcessor;
	
	// writed
	@Autowired
	public SampleBatchWriter sampleBatchWriter;
	
	// reader
	@Autowired
	public SampleBatchReader sampleBatchReader;
	
	@Autowired
	public SampleBatchRemove SampleBatchRemove;
	
	@Bean
	// 압축,비압축 스텝
	public Step compresseStep() throws MalformedURLException {
		return stepBuilderFactory.get("compresseStep")
				.<Emp, Emp>chunk(5)
				.reader(sampleBatchReader.fileReader(null))
				.processor(sampleBatchProcessor.process())
				.writer(sampleBatchWriter.fileWriter(null))
				.transactionManager(transactionManager)
				.build();
	}
	
	@Bean
	// 파일명 변경 step
	public Step removeExtensionStep() {
			return stepBuilderFactory.get("removeExtension")
					.tasklet(SampleBatchRemove.removeExtension(null))
					.transactionManager(transactionManager)
					.build();
	}
}
