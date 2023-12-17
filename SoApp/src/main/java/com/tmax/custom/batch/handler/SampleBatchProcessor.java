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
		
		return emp -> {
			Integer empno = emp.getEmpno();
			String ename = emp.getEname();
			
			Emp transformedEmp = new Emp();
			transformedEmp.setEmpno(empno);
			transformedEmp.setEname(ename);
			
			logger.info("Converting (" + emp + ") into (" + transformedEmp + ")");
			
			Thread.sleep(2000);
			
			return transformedEmp;
		};
	}
}
