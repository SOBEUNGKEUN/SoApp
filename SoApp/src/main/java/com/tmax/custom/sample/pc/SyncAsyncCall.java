package com.tmax.custom.sample.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.ServiceManager;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 1. 9. 오후 9:14",
	comments= "SyncAsyncCall"
)
@Service
public class SyncAsyncCall{
    
	@Autowired
//	@Autowired(required=false)
	ServiceManager serviceManager;
	
	ProObjectLogger logger = SystemLogger.getLogger();
	
	ServiceName serviceName = new ServiceName("SoApp.SG_EG.SyncAsyn_test");
    /**
     * @param com.tmax.custom.sample.dto.SampleDTO
     * @return com.tmax.custom.sample.dto.SampleDTO
     */
    @ServiceMethod
    public com.tmax.custom.sample.dto.SampleDTO sync(com.tmax.custom.sample.dto.SampleDTO input) throws Throwable {
    	 // 동기 호출
    	
    	logger.info("### call ### ");
    	serviceManager.call(serviceName, input, SampleDTO.class,60 * 1000);
    	
        return null;
    }
    
    /**
     * @param com.tmax.custom.sample.dto.SampleDTO
     * @return com.tmax.custom.sample.dto.SampleDTO
     */
    @ServiceMethod
    public com.tmax.custom.sample.dto.SampleDTO async(com.tmax.custom.sample.dto.SampleDTO input) throws Throwable {
    	// 비동기 호출
    	
    	logger.info("### acall ### ");
    	serviceManager.acall(serviceName, input, SampleDTO.class,60 * 1000);
    	
        return null;
    }
    
}

