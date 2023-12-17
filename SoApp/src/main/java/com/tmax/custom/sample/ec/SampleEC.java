package com.tmax.custom.sample.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tmax.custom.sample.dao.SampleDAO;
import com.tmax.custom.sample.dto.SampleDTO;

@Repository
public class SampleEC {

	@Autowired
	SampleDAO sampleDAO;
	
	public SampleDTO select(SampleDTO input) throws Throwable{
		SampleDTO output = new SampleDTO();
		
		output = sampleDAO.select(input);
				
		return output;
	}
	
	public void insert(SampleDTO input) throws Throwable{
		
		sampleDAO.insert(input);
	
	}
	
	public void update(SampleDTO input) throws Throwable{;
		
		sampleDAO.update(input);
				
	}
	
	public void delete(SampleDTO input) throws Throwable{
		
		sampleDAO.delete(input);
				
	}
}
