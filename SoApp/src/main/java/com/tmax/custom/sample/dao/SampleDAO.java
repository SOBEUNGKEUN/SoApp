package com.tmax.custom.sample.dao;

import com.tmax.custom.datasource.DatabasePO21;
import com.tmax.custom.sample.dto.SampleDTO;

@DatabasePO21
public interface SampleDAO {
	
	public SampleDTO select(SampleDTO input) throws Exception;
	
	public void insert(SampleDTO input) throws Exception;
	
	public void update(SampleDTO input) throws Exception;
	
	public void delete(SampleDTO input) throws Exception;
}
