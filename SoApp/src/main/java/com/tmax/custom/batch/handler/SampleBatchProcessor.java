package com.tmax.custom.batch.handler;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.dto.Emp;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchProcessor{
	
	private ProObjectLogger logger = BatchLogger.getLogger();

	@Bean
	public ItemProcessor<Emp, Emp> process() {
		
		return input -> {
			Emp output = new Emp();
			output.setEmpno(input.getEmpno());
			output.setEname(input.getEname());
			
			Thread.sleep(500);
			logger.info("Converting (" + input + ") into (" + output + ")");
			
			return output;
		};
	}
}
