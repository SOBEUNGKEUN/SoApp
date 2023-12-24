package com.tmax.custom.batch.handler;

import java.net.MalformedURLException;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.tmax.custom.batch.dto.Emp;
import com.tmax.proobject.batch.core.item.file.ProObjectParameterBufferedReaderFactory;
import com.tmax.proobject.batch.core.item.file.ProObjectParameterResource;

@Configuration
public class SampleBatchReader {

	// 샘플용
	@Bean
	public FlatFileItemReader<Emp> empReader() {
		return new FlatFileItemReaderBuilder<Emp>().name("empReader")
				.resource(new FileSystemResource("/home/tmax/src/batch/sample-data.csv")).delimited()
				.names(new String[] {"empno", "ename"}).fieldSetMapper(new BeanWrapperFieldSetMapper<Emp>() {
					
					{
						setTargetType(Emp.class);
					}
				}).build();
	}
	
	// 파일 압축 피 압축용 Reader
    @StepScope
    @Bean
    public FlatFileItemReader<Emp> fileReader(@Value("#{jobParameters['inputfile']}") String inputfile) throws MalformedURLException {
        return new FlatFileItemReaderBuilder<Emp>().name("fileReader").bufferedReaderFactory(new ProObjectParameterBufferedReaderFactory())
        		.resource(new ProObjectParameterResource(inputfile))
        		.delimited().names(new String[] { "empno", "ename" })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Emp>() {
                    {
                        setTargetType(Emp.class);
                    }
                }).build();
    }
	
}
