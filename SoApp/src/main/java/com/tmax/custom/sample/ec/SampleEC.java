package com.tmax.custom.sample.ec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tmax.custom.sample.dao.SampleDAO;
import com.tmax.custom.sample.dto.MemoryCalDTO;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.custom.sample.dto.SampleOUTDTO;

@Repository
public class SampleEC {

	@Autowired
//	@Autowired(required=false)
	SampleDAO sampleDAO;
	
	public SampleDTO select(SampleDTO input) throws Throwable{
		SampleDTO output = new SampleDTO();
		
		output = sampleDAO.select(input);
				
		return output;
	}
	
	public SampleOUTDTO selectError(SampleDTO input) throws Throwable{
		SampleOUTDTO output = new SampleOUTDTO();
		
		output = sampleDAO.selectError(input);
				
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
	
	//  multi
	public List<SampleDTO> multiselect(SampleDTO input) throws Throwable{
		
		List<SampleDTO> output = sampleDAO.multiselect(input);
		
		return output;
				
	}
	
	public MemoryCalDTO MemoryCal(MemoryCalDTO input) throws Throwable{
		MemoryCalDTO output = new MemoryCalDTO();
		
		output = sampleDAO.MemoryCal(input);
		
		return output;
	}
	
	
}
