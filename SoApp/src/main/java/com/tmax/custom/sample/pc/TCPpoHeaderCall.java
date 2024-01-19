package com.tmax.custom.sample.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.sample.dao.SampleDAO;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.engine.waitobject.WaitObject;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 1. 18. 오후 5:44",
	comments= "TCPpoHeaderCall"
)
@Service
public class TCPpoHeaderCall{
    
	private ProObjectLogger logger = SystemLogger.getLogger();
	
	@Autowired
	SampleDAO SampleDAO;
	
    /**
     * @param com.tmax.custom.sample.dto.SampleDTO
     * @return com.tmax.custom.sample.dto.SampleDTO
     */
    @ServiceMethod
    public com.tmax.custom.sample.dto.SampleDTO select(com.tmax.custom.sample.dto.SampleDTO input) throws Throwable {
    	SampleDTO output = new SampleDTO();
    	
    	logger.info(" ######################## 성공 ######################");
    	output = SampleDAO.select(input);
        return output;
    }
    
}

