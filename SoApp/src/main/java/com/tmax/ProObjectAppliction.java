package com.tmax;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.tmax.proobject.batch.core.configuration.annotation.EnableProObjectBatchProcessing;
import com.tmax.proobject.runtime.ProObjectServletInitializer;
import com.tmax.proobject.runtime.application.autoconfigure.ProObjectApplication;

@EnableProObjectBatchProcessing
@ProObjectApplication(exclude = {
		JdbcTemplateAutoConfiguration.class }, scanBasePackageClasses = ProObjectAppliction.class)
public class ProObjectAppliction extends ProObjectServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		super.configure(application);
//		application.lazyInitialization(true);
		return application.sources(ProObjectAppliction.class);
	}
}
