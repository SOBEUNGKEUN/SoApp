package com.tmax.custom.dataSourceTest.dao;

import com.tmax.custom.datasoruce.DatabaseCRO_DS;
import com.tmax.custom.sample.dto.SampleDTO;

@DatabaseCRO_DS
public interface SampleCRO_DAO {
	
	public SampleDTO select(SampleDTO input) throws Exception;
}
