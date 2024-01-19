package com.tmax.custom.systemcontext.pc;

import org.springframework.stereotype.Service;

import com.tmax.custom.systemcontext.dto.SampleCacheDTO;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.model.context.SystemContext;
import com.tmax.proobject.runtime.context.ContextDataObject;
import com.tmax.proobject.runtime.context.exception.ContextDataObjectException;
import com.tmax.proobject.runtime.context.system.SystemContextManager;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 1. 16. 오후 9:21",
	comments= "SampleCachePC"
)
@Service
public class SampleCachePC{

	private ProObjectLogger logger = SystemLogger.getLogger();
	/**
	 * @param com.tmax.custom.systemcontext.dto.SampleCacheDTO
	 * @return com.tmax.custom.systemcontext.dto.SampleCacheDTO
	 */
	@ServiceMethod
	public SampleCacheDTO select(SampleCacheDTO input) throws Throwable {
		// TODO Auto-generated method stub
		
		SystemContext systemContext = SystemContextManager.getSystemContext();
		SampleCacheDTO output = new SampleCacheDTO();
		
		try {
			ContextDataObject contextDataObject = (ContextDataObject) systemContext.getContext(input.getName());
			
			String key = input.getKey();
			String value = contextDataObject.get(key);
			
			output.setKey(key);
			output.setValue(value);
		} catch (ContextDataObjectException e) {
	    	logger.error("contextDataObject 를 찾을 수 없습니다.");
		}   
    	
		return output;
	}
    
}

