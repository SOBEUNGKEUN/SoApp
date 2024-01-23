package com.tmax.custom.dataSourceTest.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.dataSourceTest.ec.SampleMatEC;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 1. 16. 오전 10:49",
	comments= "SampleMatPC"
)
@Service
public class SampleMatPC{

	@Autowired
//	@Autowired(required=false)
	SampleMatEC sampleMatEC;
	
	private ProObjectLogger logger = SystemLogger.getLogger();
	/**
	 * @param com.tmax.custom.sample.dto.SampleDTO
	 * @return com.tmax.custom.sample.dto.SampleDTO
	 */
	@ServiceMethod
	public SampleDTO select(SampleDTO input) throws Throwable {
		// TODO Auto-generated method stub
   		
    	logger.info("\n##### select starts ####");
		SampleDTO output = new SampleDTO();	
		output = sampleMatEC.select(input);
		logger.info("\n##### select end ####");
		return output;
	}
    
}

