package com.tmax.custom.datasoruce;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

//@Conditional(SampleCondition.class)
//@Conditional(CRO_DScondition.class)
@Configuration
//@DependsOn("lazyInitializationBeanFactoryPostProcessorConfig")
//@MapperScan(basePackages="com.tmax", annotationClass=DatabaseCRO_DS.class, sqlSessionFactoryRef="nonXaSqlSessionFactoryCRO_DS",lazyInitialization = "true")
@MapperScan(basePackages="com.tmax", annotationClass=DatabaseCRO_DS.class, sqlSessionFactoryRef="nonXaSqlSessionFactoryCRO_DS")
public class DatasourceCRO_DS {
		
		public ProObjectLogger logger = SystemLogger.getLogger();
		
		@Bean(name = "jndiTemplateCRO_DS")
		public JndiTemplate jndiTemplate() {
			JndiTemplate jndiTemplate = new JndiTemplate();
			Properties environment = new Properties();

			environment.setProperty("java.naming.factory.initial", "jeus.jndi.JNSContextFactory");
			jndiTemplate.setEnvironment(environment);

			return jndiTemplate;
		}
		
		
		@Bean(name="nonXaDataSourceCRO_DS")
		public JndiObjectFactoryBean nonXaDataSource(@Qualifier("jndiTemplateCRO_DS")JndiTemplate jndiTemplateCRO_DS) { 
			JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
			
			logger.info("\n### CRO_DS 데이터 소스 생성 ###");
			jpfb.setJndiName("CRO_DS");
			jpfb.setJndiTemplate(jndiTemplateCRO_DS);
			logger.info("\n### CRO_DS 데이터 소스 생성 성공 ###");
			return jpfb;
		}
		
		
//		@Bean(name="nonXaDataSourceCRO_DS")
//		public DataSource nonXaDataSource(@Qualifier("jndiTemplateCRO_DS")JndiTemplate jndiTemplateCRO_DS) { 
//			JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
//			
//			logger.info("\n### CRO_DS 데이터 소스 생성 ###");
//			jpfb.setJndiName("CRO_DS");
//			jpfb.setJndiTemplate(jndiTemplateCRO_DS);
//			logger.info("\n### CRO_DS 데이터 소스 생성 성공 ###");
//			return (DataSource) jpfb.getObject();
//		}
		
	
		@Bean(name="nonXaTransactionManagerCRO_DS")
		public DataSourceTransactionManager nonXaTransactionManager(@Qualifier("nonXaDataSourceCRO_DS") DataSource nonXaDataSource) {
			DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(nonXaDataSource);
			
			return transactionManager;
		}
		
		@Bean(name="nonXaSqlSessionFactoryCRO_DS")
		public SqlSessionFactory nonXaSqlSessionFactory(@Qualifier("nonXaDataSourceCRO_DS") DataSource nonXaDataSource, ApplicationContext applicationContext) throws Exception {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			
			factoryBean.setDataSource(nonXaDataSource);
			factoryBean.setConfigLocation(applicationContext.getResource("classpath:com/tmax/custom/datasource/DatasourceCRO_DS.xml"));
			
			return factoryBean.getObject();
		}
		
		@Bean(name="nonXaSqlSessionTemplateCRO_DS")
		public SqlSessionTemplate nonXaSqlSessionTemplate(@Qualifier("nonXaSqlSessionFactoryCRO_DS") SqlSessionFactory nonXaSqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(nonXaSqlSessionFactory);
		}
		
	}

