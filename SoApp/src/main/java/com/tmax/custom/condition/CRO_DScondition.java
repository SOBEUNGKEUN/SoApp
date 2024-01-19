package com.tmax.custom.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

public class CRO_DScondition implements Condition{

	   private ProObjectLogger logger = SystemLogger.getLogger();

	   @Override
	   public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
	      String CRO_DS = context.getEnvironment().getProperty("condition.CRO_DS");
	      logger.info("\n###[CRO_DSCondition] CRO_DS = {} ###", CRO_DS);
	      return ("true".equals(CRO_DS));
	   }
	   

	}
