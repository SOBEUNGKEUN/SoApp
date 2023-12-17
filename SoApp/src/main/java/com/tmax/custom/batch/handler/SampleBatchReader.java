package com.tmax.custom.batch.handler;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.tmax.custom.batch.dto.Emp;

@Configuration
public class SampleBatchReader {

	@Bean
	public FlatFileItemReader<Emp> empReader() {
		return new FlatFileItemReaderBuilder<Emp>().name("empItemReader")
				.resource(new FileSystemResource("/home/tmax/src/batch/sample-data.csv")).delimited()
				.names(new String[] {"empno", "ename"}).fieldSetMapper(new BeanWrapperFieldSetMapper<Emp>() {
					
					{
						setTargetType(Emp.class);
					}
				}).build();
	}
}
