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
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import com.tmax.custom.condition.MAT_DScondition;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

//@Conditional(SampleCondition.class)
@Conditional(MAT_DScondition.class)
@Configuration
//@DependsOn("lazyInitializationBeanFactoryPostProcessorConfig")
//@MapperScan(basePackages="com.tmax", annotationClass=DatabaseMAT_DS.class, sqlSessionFactoryRef="nonXaSqlSessionFactoryMAT_DS", lazyInitialization = "true")
@MapperScan(basePackages="com.tmax", annotationClass=DatabaseMAT_DS.class, sqlSessionFactoryRef="nonXaSqlSessionFactoryMAT_DS")
public class DatasourceMAT_DS {
		
		public ProObjectLogger logger = SystemLogger.getLogger();
		
//		@PostConstruct
//		public void adf() {
//			logger.error("adsfasdfasdfasdfasdf");
//		}
//		
		
		@Bean(name = "jndiTemplateMAT_DS")
		public JndiTemplate jndiTemplate() { 
			JndiTemplate jndiTemplate = new JndiTemplate();
			Properties environment = new Properties();

			environment.setProperty("java.naming.factory.initial", "jeus.jndi.JNSContextFactory");
			jndiTemplate.setEnvironment(environment);

			return jndiTemplate;
		}
		
		@Bean(name="nonXaDataSourceMAT_DS")
		public JndiObjectFactoryBean nonXaDataSource(@Qualifier("jndiTemplateMAT_DS")JndiTemplate jndiTemplateMAT_DS) { 
			JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
			
			logger.info("\n### MAT_DS 데이터 소스 생성 ###");
			jpfb.setJndiName("MAT_DS");
			jpfb.setJndiTemplate(jndiTemplateMAT_DS);
			logger.info("\n### MAT_DS 데이터 소스 생성 성공 ###");
			return jpfb;
		}
		
		@Bean(name="nonXaTransactionManagerMAT_DS")
		public DataSourceTransactionManager nonXaTransactionManager(@Qualifier("nonXaDataSourceMAT_DS") DataSource nonXaDataSource) {
			DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(nonXaDataSource);
			
			return transactionManager;
		}
		
		@Bean(name="nonXaSqlSessionFactoryMAT_DS")
		public SqlSessionFactory nonXaSqlSessionFactory(@Qualifier("nonXaDataSourceMAT_DS") DataSource nonXaDataSource, ApplicationContext applicationContext) throws Exception {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			
			factoryBean.setDataSource(nonXaDataSource);
			factoryBean.setConfigLocation(applicationContext.getResource("classpath:com/tmax/custom/datasource/DatasourceMAT_DS.xml"));
			
			return factoryBean.getObject();
		}
		
		@Bean(name="nonXaSqlSessionTemplateMAT_DS")
		public SqlSessionTemplate nonXaSqlSessionTemplate(@Qualifier("nonXaSqlSessionFactoryMAT_DS") SqlSessionFactory nonXaSqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(nonXaSqlSessionFactory);
		}
		
	}

