package com.tmax.custom.dataSourceTest.dao;

import com.tmax.custom.datasoruce.DatabaseMAT_DS;
import com.tmax.custom.sample.dto.SampleDTO;

@DatabaseMAT_DS
public interface SampleMAT_DAO {
	
	public SampleDTO select(SampleDTO input) throws Exception;
}
