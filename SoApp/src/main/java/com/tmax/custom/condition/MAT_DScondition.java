package com.tmax.custom.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

public class MAT_DScondition implements Condition{

	   private ProObjectLogger logger = SystemLogger.getLogger();

	   @Override
	   public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
	      String MAT_DS = context.getEnvironment().getProperty("condition.MAT_DS");
	      logger.info("\n###[MAT_DSCondition] MAT_DS = {} ###", MAT_DS);
	      return ("true".equals(MAT_DS));
	   }
	   

	}
