package com.tmax.custom.sample.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.waitobject.WaitObject;
import com.tmax.proobject.network.protocol.message.ProObjectProtocolResponseBody;
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
	date= "24. 2. 12. 오전 10:58",
	comments= "MsCallPC"
)
@Service
public class MsCallPC{

	@Autowired
	ServiceManager serviceManager;
	
	public ProObjectLogger logger = SystemLogger.getLogger();
	
	/**
	 * @param com.sample.dto.SampleDTO
	 * @return com.sample.dto.SampleDTO
	 */
	@ServiceMethod
	public com.sample.dto.SampleDTO call(com.sample.dto.SampleDTO input) throws Throwable {
		// TODO Auto-generated method stub
		
		com.sample.dto.SampleDTO output = new  com.sample.dto.SampleDTO();
		 
		logger.info("########## TestAPP call start ##############");
		
		ServiceName serviceName = new ServiceName("TestAPP.SG_AA.TestPC_logCall");
		
		output = serviceManager.call(serviceName, input, com.sample.dto.SampleDTO.class,60 * 1000);
		
		return output;
	}

	/**
	 * @param com.tmax.custom.sample.dto.SampleDTO
	 * @return com.tmax.custom.sample.dto.SampleDTO
	 */
	@ServiceMethod
	public SampleDTO SoAppCall(SampleDTO input) throws Throwable {
		// TODO Auto-generated method stub
		
		SampleDTO output = new SampleDTO();
		
		logger.info("########## SoApp SoAppCall start ##############");
		
		ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_select");
		
		output = serviceManager.call(serviceName, input, SampleDTO.class,60 * 1000);
		
		return output;
	}
}

