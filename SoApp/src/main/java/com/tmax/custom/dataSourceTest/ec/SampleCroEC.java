package com.tmax.custom.dataSourceTest.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tmax.custom.dataSourceTest.dao.SampleCRO_DAO;
import com.tmax.custom.sample.dto.SampleDTO;

@Repository
public class SampleCroEC {

	@Autowired
//	@Autowired(required=false)
	SampleCRO_DAO sampleCRO_DAO;
	
	public SampleDTO select(SampleDTO input) throws Throwable{
		SampleDTO output = new SampleDTO();
		
		output = sampleCRO_DAO.select(input);
				
		return output;
	}
}
