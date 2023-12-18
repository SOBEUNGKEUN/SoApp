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
@javax.annotation.Generated(value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator", date = "23. 12. 18. 오후 7:14", comments = "CustomHeaderTestPC")
@Service
public class CustomHeaderTestPC {

	/**
	 * @param com.tmax.custom.sample.dto.SampleDTO
	 * @return com.tmax.custom.sample.dto.SampleDTO
	 */
	@Autowired
	SampleEC sampleEC;

	private ProObjectLogger logger = SystemLogger.getLogger();

	@ServiceMethod
	public SampleDTO select(SampleDTO input) throws Throwable {
		// TODO Auto-generated method stub

		logger.info("\n##### Custom Header select start ####");
		SampleDTO output = new SampleDTO();
		output = sampleEC.select(input);
		logger.info("\n##### Custom Header select start ####");
		return output;
	}

}
