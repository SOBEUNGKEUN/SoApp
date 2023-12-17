package com.tmax.custom.batch.handler;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.dto.Emp;

@Configuration
public class SampleBatchWriter {
	
	@Autowired
	@Qualifier("SampleBatchSqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Bean
	public MyBatisBatchItemWriter<Emp> empWriter(){
		return new MyBatisBatchItemWriterBuilder<Emp>()
				.sqlSessionFactory(sqlSessionFactory)
				.statementId("com.tmax.custom.batch.dao.SampleBatchDAO.insert")
				.build();
	}
}
