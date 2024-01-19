package com.tmax.custom.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

public class SampleCondition implements Condition{

	 private ProObjectLogger logger = SystemLogger.getLogger();
	 
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		String datasource = context.getEnvironment().getProperty("condition.SAMPLE_DS");
		if  (datasource == "CRO") {
			logger.info("\nCRO 입니다.");
			return ("CRO".equals(datasource));
		}
		
		if  (datasource == "MAT") {
			logger.info("\nMAT 입니다.");
			return ("MAT".equals(datasource));
		}
		
		return false;
	}

}
