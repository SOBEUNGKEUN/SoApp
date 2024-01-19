package com.tmax.custom.sample.dao;

import java.util.List;

import com.tmax.custom.datasoruce.DatabasePO21;
import com.tmax.custom.sample.dto.MemoryCalDTO;
import com.tmax.custom.sample.dto.SampleDTO;
import com.tmax.custom.sample.dto.SampleOUTDTO;

@DatabasePO21
public interface SampleDAO {
	
	public SampleDTO select(SampleDTO input) throws Exception;
	
	public SampleOUTDTO selectError(SampleDTO input) throws Exception;
	
	public void insert(SampleDTO input) throws Exception;
	
	public void update(SampleDTO input) throws Exception;
	
	public void delete(SampleDTO input) throws Exception;
	
	// multi
	public List<SampleDTO> multiselect(SampleDTO input) throws Exception;
	
	// oom 방지기능
	public MemoryCalDTO MemoryCal(MemoryCalDTO input) throws Exception;
}
