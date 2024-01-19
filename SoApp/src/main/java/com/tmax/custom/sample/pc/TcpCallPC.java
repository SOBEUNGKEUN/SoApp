package com.tmax.custom.sample.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.custom.sample.ec.SampleEC;
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
	date= "24. 1. 18. 오후 1:42",
	comments= "TcpCallPC"
)
@Service
public class TcpCallPC{
    
	@Autowired
	SampleEC sampleEC;
	
	private ProObjectLogger logger = SystemLogger.getLogger();
    /**
     * @param com.tmax.custom.sample.dto.SampleDTO
     * @return com.tmax.custom.sample.dto.SampleDTO
     */
    @ServiceMethod
    public com.tmax.custom.sample.dto.SampleDTO select(com.tmax.custom.sample.dto.SampleDTO input) throws Throwable {
    	
    	logger.info("\n##### TCP select starts ####");
		SampleDTO output = new SampleDTO();	
		output = sampleEC.select(input);
		
		logger.info("\n##### TCP select end ####");
		
		return output;
      
    }
    
}

