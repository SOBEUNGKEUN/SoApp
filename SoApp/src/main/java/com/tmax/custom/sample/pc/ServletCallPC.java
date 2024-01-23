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
@javax.annotation.Generated(value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator", date = "23. 12. 21. 오전 10:30", comments = "ServletCallPC")
@Service
public class ServletCallPC {

	/**
	 * @param com.tmax.custom.sample.dto.SampleDTO
	 * @return com.tmax.custom.sample.dto.SampleDTO
	 */

	@Autowired
//	@Autowired(required=false)
	SampleEC sampleEC;

	private ProObjectLogger logger = SystemLogger.getLogger();

	@ServiceMethod
	public com.tmax.custom.sample.dto.SampleDTO testCall(com.tmax.custom.sample.dto.SampleDTO input) throws Throwable {

		logger.info("\n##### testCall start ####");
		SampleDTO output = new SampleDTO();
		output = sampleEC.select(input);
		logger.info("\n#### testCall end ###");
		return output;
	}

}
