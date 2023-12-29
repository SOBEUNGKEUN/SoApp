package com.tmax.custom.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SpringBatchRepositoryConfig {
	
	@Autowired
	@Qualifier(value= "SampleBatchDataSourceTransactionManager")
	private PlatformTransactionManager sampleBatchDataSourceTransactionManager;
	
	@Autowired
	@Qualifier(value= "SpringBatchBean")
	private DataSource datraSource;
	
	@Bean(name = "SampleBatchRepository")
	public JobRepository getJobRepository() throws Exception{
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(datraSource);
		factory.setTransactionManager(sampleBatchDataSourceTransactionManager);
		factory.setDatabaseType("DB2");
		factory.afterPropertiesSet();
		return factory.getObject();
	}
}
