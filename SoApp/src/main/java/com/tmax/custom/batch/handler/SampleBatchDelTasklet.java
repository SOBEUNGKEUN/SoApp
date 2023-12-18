package com.tmax.custom.batch.handler;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.dao.SampleBatchDAO;
import com.tmax.custom.batch.dto.Emp;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchDelTasklet implements Tasklet{
	
	private ProObjectLogger logger = BatchLogger.getLogger();
	
	@Autowired
	SampleBatchDAO sampleBatchDAO;

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.info("\n ### 데이터가 삭제됩니다 3 ###");
		Thread.sleep(1000);
		logger.info("\n ### 데이터가 삭제됩니다 2 ###");
		Thread.sleep(1000);
		logger.info("\n ### 데이터가 삭제됩니다 1 ###");
		Thread.sleep(1000);
		logger.info("\n ### 데이터가 삭제 완료 ###");
		Emp input = new Emp();
		input.setEname("Doe");
		sampleBatchDAO.delete(input);
		
		return RepeatStatus.FINISHED;
	}
}
