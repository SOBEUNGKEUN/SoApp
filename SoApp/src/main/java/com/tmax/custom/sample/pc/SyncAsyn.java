package com.tmax.custom.sample.pc;

import org.springframework.stereotype.Service;
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
	date= "24. 1. 9. 오후 9:18",
	comments= "SyncAsyn"
)
@Service
public class SyncAsyn{
    
	ProObjectLogger logger = SystemLogger.getLogger();
	
    /**
     * @param com.tmax.custom.sample.dto.SampleDTO
     * @return com.tmax.custom.sample.dto.SampleDTO
     */
    @ServiceMethod
    public com.tmax.custom.sample.dto.SampleDTO test(com.tmax.custom.sample.dto.SampleDTO input) throws Throwable {
    	

		Thread t1 = new Thread(()->{
			test1();
		});
		Thread t2 = new Thread(()->{
			test2();
		});
		Thread t3 = new Thread(()->{
			test3();
		});
    	
		t1.start();
		t2.start();
		t3.start();
		
        return null;
    }
    
    public void test1() {
    	logger.info("### 1번 ###");
    }
    
    public void test2() {
    	logger.info("### 2번 ###");
    }
    
    public void test3() {
    	logger.info("### 3번 ###");
    }
}

