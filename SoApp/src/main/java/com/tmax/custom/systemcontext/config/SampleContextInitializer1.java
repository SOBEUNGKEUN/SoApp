package com.tmax.custom.systemcontext.config;

import java.util.List;

import com.tmax.proobject.core2.exception.ProObjectException;
import com.tmax.proobject.model.context.ContextInitializer;
import com.tmax.proobject.model.context.ContextObject;
import com.tmax.proobject.runtime.context.system.dao.SystemContextBucket;
import com.tmax.proobject.runtime.context.system.dao.SystemContextDAO;
import com.tmax.proobject.runtime.exception.code.ExtendedProObjectExceptionCode;

public class SampleContextInitializer1 implements ContextInitializer{

	@Override
	public void init(String contextName, ContextObject object) throws Exception {
		// TODO Auto-generated method stub
		
		SystemContextDAO dao = new SystemContextDAO("po21");
		dao.setTableInformation("db2user", "db2user.SAMPLE_SYSTEM_CONTEXT_1");
		
		List<SystemContextBucket> buckets = dao.selectAll();
		
		for (SystemContextBucket bucket: buckets) {
			try {
				object.set(bucket.getKey(), bucket.getValue());
			} catch (Throwable e) {
				throw new ProObjectException(ExtendedProObjectExceptionCode.RUNIME_SYSTEM_CONTEXT_BOOT_FAILED, e);
			}
		}
	}

}
