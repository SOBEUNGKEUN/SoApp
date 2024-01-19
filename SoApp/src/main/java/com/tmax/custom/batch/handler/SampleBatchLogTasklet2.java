package com.tmax.custom.batch.handler;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Configuration;

import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchLogTasklet2 implements Tasklet {

	private ProObjectLogger logger = BatchLogger.getLogger();
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		logger.info("\n ### Step2 Log 1###");
		Thread.sleep(3000);
		logger.info("\n ### Step2 Log 2###");
		Thread.sleep(3000);
		logger.info("\n ### Step2 Log 3###");
		Thread.sleep(3000);	
		return RepeatStatus.FINISHED;
	}	
}
