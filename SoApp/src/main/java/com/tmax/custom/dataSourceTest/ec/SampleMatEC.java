package com.tmax.custom.dataSourceTest.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tmax.custom.dataSourceTest.dao.SampleMAT_DAO;
import com.tmax.custom.sample.dto.SampleDTO;

@Repository
public class SampleMatEC {
	
	@Autowired
//	@Autowired(required=false)
	SampleMAT_DAO sampleMAT_DAO;
	
	public SampleDTO select(SampleDTO input) throws Throwable{
		SampleDTO output = new SampleDTO();
		
		output = sampleMAT_DAO.select(input);
				
		return output;
	}
}
