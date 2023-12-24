package com.tmax.custom.batch.handler;

import java.net.MalformedURLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.custom.batch.dao.SampleBatchDAO;
import com.tmax.custom.batch.dto.Emp;
import com.tmax.proobject.batch.core.item.file.ProObjectParameterFlatFileItemWriter;
import com.tmax.proobject.batch.core.item.file.ProObjectParameterFlatFileItemWriterBuilder;
import com.tmax.proobject.batch.core.item.file.ProObjectParameterResource;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchWriter{
//implements ItemWriter<Emp>

	private ProObjectLogger logger = BatchLogger.getLogger();
	
	@Autowired
	@Qualifier("SampleBatchSqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private SampleBatchDAO sampleBatchDAO;
	
	@Bean
	public MyBatisBatchItemWriter<Emp> empWriter(){
		return new MyBatisBatchItemWriterBuilder<Emp>()
				.sqlSessionFactory(sqlSessionFactory)
				.statementId("com.tmax.custom.batch.dao.SampleBatchDAO.insert")
				.build();
	}
	
	// 캐스팅 에러 발생
	@Bean
	public ItemWriter<Emp> customWriter(){
		return input -> {		
			/*
			 * ### input ### : 
			 * [empno : 6018
				ename : Doe
				, empno : 6019
				ename : Doe
				]

			 */
			Emp param = new Emp();
			for(int i=0; i< input.size(); i++) {
				param.setEmpno(input.get(i).getEmpno());
				param.setEname(input.get(1).getEname());
				sampleBatchDAO.insert(param);
			}		
			return;
		};
	}
	// 파일 압축/비 압축영 writer
	  @StepScope
	  @Bean
	    public ProObjectParameterFlatFileItemWriter<Emp> fileWriter(@Value("#{jobParameters['outputfile']}") String outputfile) throws MalformedURLException {
	        BeanWrapperFieldExtractor<Emp> extractor = new BeanWrapperFieldExtractor<Emp>();
	        extractor.setNames(new String[] { "empno", "ename" });
	        return new ProObjectParameterFlatFileItemWriterBuilder<Emp>().name("fileWriter")
	        		.resource(new ProObjectParameterResource(outputfile)).delimited().delimiter(",")
	                .fieldExtractor(extractor).build();
	    }
}
