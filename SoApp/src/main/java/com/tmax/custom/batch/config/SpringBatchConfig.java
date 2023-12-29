package com.tmax.custom.batch.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import com.tmax.proobject.service.persistence.mybatis.spring.ProObjectSqlSessionFactoryBean;

@Configuration
public class SpringBatchConfig {
	
	/*
	 * 배치 업무에서 사용하는 데이터 소스
	 */
			
	@Bean(name = "SampleBatchJndiTemplate")
	public JndiTemplate SampleBatchJndiTemplate() {
		JndiTemplate jndiTemplate = new JndiTemplate();
		Properties environment = new Properties();
		environment.setProperty("java.naming.factory.initial", "jeus.jndi.JNSContextFactory");
		jndiTemplate.setEnvironment(environment);
		return jndiTemplate;
		
	}
	
	/*
	 * 배치에서 사용하는 빈 생성 
	 * Repository DB용 데이터소스
	 * Repository DB : 배치 실행 이력, 정보등이 저장되는 DB 
	 * 
	 */
	@Bean(name = "SpringBatchBean")
	@Primary
	@BatchDataSource
	public JndiObjectFactoryBean SpringBatchBean(@Qualifier("SampleBatchJndiTemplate") JndiTemplate SampleBatchJndiTemplate) {
		JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
		jpfb.setJndiName("po21");
		jpfb.setJndiTemplate(SampleBatchJndiTemplate);
		return jpfb;
	}
	
	/*
	 * 배치에서 사용 할 데이터소스
	 */
	@Bean(name = "SampleBatchDataSource")
	public JndiObjectFactoryBean SampleBatchDataSource(@Qualifier("SampleBatchJndiTemplate") JndiTemplate SampleBatchJndiTemplate){
		JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
		jpfb.setJndiName("po21");
		jpfb.setJndiTemplate(SampleBatchJndiTemplate);
		return jpfb;
	}
	/*
	 * MyBatis 사용을 위한 SqlSessionFactoryBean
	 */
	@Bean
	public SqlSessionFactoryBean SampleBatchSqlSessionFactory(@Qualifier("SampleBatchDataSource") DataSource SpringBatchBean) throws Exception{
		SqlSessionFactoryBean factoryBean = new ProObjectSqlSessionFactoryBean();
		factoryBean.setDataSource(SpringBatchBean);
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/tmax/custom/batch/dao/*.xml"));
		return factoryBean;
		
	}
	
	@Bean
	public SqlSessionTemplate SampleBatchSqlSessionTemplate(@Qualifier("SampleBatchSqlSessionFactory") SqlSessionFactoryBean SampleBatchSqlSessionFactory) throws Exception{
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(SampleBatchSqlSessionFactory.getObject(), ExecutorType.BATCH);
		return sqlSessionTemplate;
	}
	
	/*
	 * 배치 트랜젝션 관리를 위한 빈 생성
	 * commit, rollback 관리
	 */
	@Bean
	public DataSourceTransactionManager SampleBatchDataSourceTransactionManager(@Qualifier("SampleBatchDataSource") DataSource SpringBatchBean) {
		DataSourceTransactionManager sampletransactionManager = new DataSourceTransactionManager(SpringBatchBean);
		return sampletransactionManager;
	}
}
