package com.tmax.custom.batch.dao;

import com.tmax.custom.batch.dto.Emp;
import com.tmax.custom.datasoruce.DatabasePO21;

@DatabasePO21
public interface SampleBatchDAO {
	public void insert(Emp input) throws Exception;
	public void delete(Emp input) throws Exception;
}
