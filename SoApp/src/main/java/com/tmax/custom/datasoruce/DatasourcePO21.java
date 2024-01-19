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

@Configuration
//@DependsOn("lazyInitializationBeanFactoryPostProcessorConfig")
//@MapperScan(basePackages="com.tmax", annotationClass=DatabasePO21.class, sqlSessionFactoryRef="nonXaSqlSessionFactoryPO21", lazyInitialization = "TRUE")
@MapperScan(basePackages="com.tmax", annotationClass=DatabasePO21.class, sqlSessionFactoryRef="nonXaSqlSessionFactoryPO21")
public class DatasourcePO21 {
		
		public ProObjectLogger logger = SystemLogger.getLogger();
	
	
		@Bean(name = "jndiTemplatePO21")
		public JndiTemplate jndiTemplate() {
			JndiTemplate jndiTemplate = new JndiTemplate();
			Properties environment = new Properties();

			environment.setProperty("java.naming.factory.initial", "jeus.jndi.JNSContextFactory");
			jndiTemplate.setEnvironment(environment);

			return jndiTemplate;
		}
		
		@Bean(name="nonXaDataSourcePO21")
		public JndiObjectFactoryBean nonXaDataSource(@Qualifier("jndiTemplatePO21")JndiTemplate jndiTemplatePO21) { 
			JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
			
			logger.info("\n### PO21 데이터 소스 생성 ###");
			jpfb.setJndiName("po21");
			jpfb.setJndiTemplate(jndiTemplatePO21);
			
			logger.info("\n### PO21 데이터 소스 생성 성공 ###");
			return jpfb;
		}
		
		@Bean(name="nonXaTransactionManagerPO21")
		public DataSourceTransactionManager nonXaTransactionManager(@Qualifier("nonXaDataSourcePO21") DataSource nonXaDataSource) {
			DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(nonXaDataSource);
			
			return transactionManager;
		}

		@Bean(name="nonXaSqlSessionFactoryPO21")
		public SqlSessionFactory nonXaSqlSessionFactory(@Qualifier("nonXaDataSourcePO21") DataSource nonXaDataSource, ApplicationContext applicationContext) throws Exception {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			
			factoryBean.setDataSource(nonXaDataSource);
			factoryBean.setConfigLocation(applicationContext.getResource("classpath:com/tmax/custom/datasource/DatasourcePO21.xml"));
			
			return factoryBean.getObject();
		}
		
		@Bean(name="nonXaSqlSessionTemplatePO21")
		public SqlSessionTemplate nonXaSqlSessionTemplate(@Qualifier("nonXaSqlSessionFactoryPO21") SqlSessionFactory nonXaSqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(nonXaSqlSessionFactory);
		}
		
	}

