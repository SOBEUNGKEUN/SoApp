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
	date= "23. 12. 5. 오후 7:40",
	comments= "SamplePC"
)
@Service
public class SamplePC{
    
    /**
     * @param com.tmax.custom.sample.dto.SampleDTO
     * @return com.tmax.custom.sample.dto.SampleDTO
     */
	@Autowired
	SampleEC sampleEC;
	
	private ProObjectLogger logger = SystemLogger.getLogger();
	
    @ServiceMethod
    public com.tmax.custom.sample.dto.SampleDTO select(com.tmax.custom.sample.dto.SampleDTO input) throws Throwable {
    		
    	logger.info("\n##### select starts ####");
		SampleDTO output = new SampleDTO();	
		output = sampleEC.select(input);
		logger.info("\n##### select end ####");
		return output;
    }

	/**
	 * @param com.tmax.custom.sample.dto.SampleDTO
	 * @return com.tmax.custom.sample.dto.SampleDTO
	 */
	@ServiceMethod
	public SampleDTO insert(SampleDTO input) throws Throwable {
		// TODO Auto-generated method stub
		logger.info("\n##### insert start ####");
		SampleDTO output = new SampleDTO();	
		sampleEC.insert(input);
		output.setEmpno(0);
		output.setEname("sucess");
		logger.info("\n##### insert end ####");
		return output;
	}

	/**
	 * @param com.tmax.custom.sample.dto.SampleDTO
	 * @return com.tmax.custom.sample.dto.SampleDTO
	 */
	@ServiceMethod
	public SampleDTO update(SampleDTO input) throws Throwable {
		// TODO Auto-generated method stub
		logger.info("\n##### update start ####");
		SampleDTO output = new SampleDTO();	
		sampleEC.update(input);
		output.setEmpno(0);
		output.setEname("sucess");
		logger.info("\n##### update end ####");
		return output;
	}

	/**
	 * @param com.tmax.custom.sample.dto.SampleDTO
	 * @return com.tmax.custom.sample.dto.SampleDTO
	 */
	@ServiceMethod
	public SampleDTO delete(SampleDTO input) throws Throwable {
		logger.info("\n##### delete start ####");
		SampleDTO output = new SampleDTO();	
		sampleEC.delete(input);
		output.setEmpno(0);
		output.setEname("sucess");
		logger.info("\n##### delete end ####");
		return output;
	}
    
}

