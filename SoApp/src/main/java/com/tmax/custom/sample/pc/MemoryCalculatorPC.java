package com.tmax.custom.sample.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.sample.dto.MemoryCalDTO;
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
	date= "24. 1. 10. 오전 11:48",
	comments= "MemoryCalculatorPC"
)
@Service
public class MemoryCalculatorPC{
    
//	@Autowired
	@Autowired(required=false)
	SampleEC sampleEC;
	
	public ProObjectLogger logger = SystemLogger.getLogger();
	
    /**
     * @param com.tmax.custom.sample.dto.MemoryCalDTO
     * @return com.tmax.custom.sample.dto.MemoryCalDTO
     */
    @ServiceMethod
    public MemoryCalDTO test(MemoryCalDTO input) throws Throwable {
    	
    	MemoryCalDTO output = new MemoryCalDTO();
    	
    	output = sampleEC.MemoryCal(input);
    	
    	output.setEmpno(123);
    	
        return output;
    }
    
}

