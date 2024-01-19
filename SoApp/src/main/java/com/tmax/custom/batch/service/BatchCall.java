package com.tmax.custom.batch.service;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.batch.dto.BatchTestDTO;
import com.tmax.proobject.batch.core.service.dto.SpringBatchJobQueryRequest;
import com.tmax.proobject.batch.core.service.dto.SpringBatchJobQueryResponse;
import com.tmax.proobject.batch.core.service.dto.SpringBatchLaunchRequest;
import com.tmax.proobject.batch.core.service.dto.SpringBatchLaunchResponse;
import com.tmax.proobject.batch.core.service.dto.SpringBatchOperationRequest;
import com.tmax.proobject.batch.core.service.dto.SpringBatchOperationResponse;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.engine.waitobject.WaitObject;
import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.service.ServiceManager;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator", date = "23. 12. 18. 오후 2:13", comments = "BatchCall")
@Service
public class BatchCall {

	@Autowired
	ServiceManager serviceManager;

	/**
	 * @param com.tmax.custom.batch.dto.BatchTestDTO
	 * @return com.tmax.custom.batch.dto.BatchTestDTO
	 */
	@ServiceMethod
	public com.tmax.custom.batch.dto.BatchTestDTO service(com.tmax.custom.batch.dto.BatchTestDTO input)
			throws Throwable {
		ProObjectLogger logger = BatchLogger.getLogger();
		BatchTestDTO output = new BatchTestDTO();
		try {
			logger.info("\n### BatchCallService Start ###");
			SpringBatchOperationRequest operReq = new SpringBatchOperationRequest();
			SpringBatchJobQueryRequest queryReq = new SpringBatchJobQueryRequest();
			ServiceName serviceName = null;
			SpringBatchLaunchResponse launchReturnObject = null;
			SpringBatchOperationResponse returnObject = null;
			SpringBatchJobQueryResponse returnResult = null;
			
			switch (input.getBatchCallType()) {

			case "LAUNCH":
				logger.info("call start");
				serviceName = new ServiceName("proobject.batch.SpringBatchLaunchService");

				SpringBatchLaunchRequest in = new SpringBatchLaunchRequest();
				in.setJobName(input.getJobName());

				Map<String, Object> parameters = new Hashtable<>();
				parameters.put("value", input.getValue());
				in.setParameters(parameters);

				if (input.getCallType().equals("CALL")) {
					logger.info("SpringBatchLaunchService call start");
					launchReturnObject = serviceManager.call(serviceName, in, SpringBatchLaunchResponse.class,
							60 * 1000);
					// output 값 세팅
					output.setJobExecutionId(launchReturnObject.getJobExecutionId());
					
					logger.info("returnObject : " + launchReturnObject.getJobName());
					logger.info("batch done");

				} else if (input.getCallType().equals("ACALL")) {
					logger.info("SpringBatchLaunchService acall start");
					WaitObject wo = serviceManager.acall(serviceName, in, SpringBatchLaunchResponse.class, 60 * 1000);
					wo.get();
					logger.info("batch done");
				}
				break;

			case "Stop":
				logger.info("SpringBatchStopService start");
				serviceName = new ServiceName("proobject.batch.SpringBatchStopService");

				operReq.setJobExecutionId(input.getJobExecutionId());
				returnObject = serviceManager.call(serviceName, operReq, SpringBatchOperationResponse.class, 60 * 1000);
				// output 값 세팅
				output.setJobExecutionId(input.getJobExecutionId());
				logger.info("returnObject : " + returnObject.getJobSummary());
				logger.info("batch done");
				break;
			case "Restart":
				logger.info("SpringBatchRestartService start");
				serviceName = new ServiceName("proobject.batch.SpringBatchRestartService");
				operReq.setJobExecutionId(input.getJobExecutionId());
				launchReturnObject = serviceManager.call(serviceName, operReq, SpringBatchLaunchResponse.class, 60 * 1000);
				
				// SpringBatchOperationResponse -> SpringBatchLaunchResponse
				// output 값 세팅
				output.setJobExecutionId(launchReturnObject.getJobExecutionId());
				
//				logger.info("returnObject : " + launchReturnObject);
				logger.info("batch done");
				break;
			case "Abandon":
				logger.info("SpringBatchAbandonService start");
				serviceName = new ServiceName("proobject.batch.SpringBatchAbandonService");
				operReq.setJobExecutionId(input.getJobExecutionId());
				returnObject = serviceManager.call(serviceName, operReq, SpringBatchOperationResponse.class, 60 * 1000);
				
				// output 값 세팅
				output.setJobExecutionId(input.getJobExecutionId());
				
				logger.info("returnObject : " + returnObject.getJobSummary());
				logger.info("batch done");
				break;
				
			case "Forced Stop":
				logger.info("SpringForced StopService start");
				serviceName = new ServiceName("proobject.batch.SpringBatchStopService");
				operReq.setJobExecutionId(input.getJobExecutionId());
				operReq.setForced(true);
				returnObject = serviceManager.call(serviceName, operReq, SpringBatchOperationResponse.class, 60 * 1000);

				output.setJobExecutionId(input.getJobExecutionId());
				logger.info("returnObject : " + returnObject.getJobSummary());
				logger.info("batch done");
				break;
				
			case "Stop and Abandon":
				logger.info("SpringForced StopNabandon start");
				serviceName = new ServiceName("proobject.batch.SpringBatchStopNabandonService");
				operReq.setJobExecutionId(input.getJobExecutionId());
				operReq.setForced(true);
				returnObject = serviceManager.call(serviceName, operReq, SpringBatchOperationResponse.class, 60 * 1000);

				output.setJobExecutionId(input.getJobExecutionId());
				logger.info("returnObject : " + returnObject.getJobSummary());
				logger.info("batch done");
				break;
			// 스텝을 안전하게 종료한 후 해당 job abandon 처리
			case "Graceful stop":
				logger.info("SpringForced Graceful stop start");
				serviceName = new ServiceName("proobject.batch.SpringBatchStopNabandonService");
				operReq.setJobExecutionId(input.getJobExecutionId());
				operReq.setForced(true);
				returnObject = serviceManager.call(serviceName, operReq, SpringBatchOperationResponse.class, 60 * 1000);

				output.setJobExecutionId(input.getJobExecutionId());
				logger.info("returnObject : " + returnObject.getJobSummary());
				logger.info("batch done");
				break;	
				
			// 압축
			case "compress":
				logger.info("call start");
				serviceName = new ServiceName("proobject.batch.SpringBatchLaunchService");

				SpringBatchLaunchRequest comp = new SpringBatchLaunchRequest();
				comp.setJobName(input.getJobName());

				Map<String, Object> parameterscomp = new Hashtable<>();
				parameterscomp.put("value", input.getValue());
				parameterscomp.put("inputfile", input.getInputPath());
				parameterscomp.put("outputfile", input.getOutputPath()+";compressed");	
				comp.setParameters(parameterscomp);
				logger.info("compress start");
				launchReturnObject = serviceManager.call(serviceName, comp, SpringBatchLaunchResponse.class,
						60 * 1000);
				// output 값 세팅
				output.setJobExecutionId(launchReturnObject.getJobExecutionId());
				
				logger.info("returnObject : " + launchReturnObject.getJobName());
				logger.info("batch done");
				break;
				
			// 비 압축
			case "decompress":
				serviceName = new ServiceName("proobject.batch.SpringBatchLaunchService");

				SpringBatchLaunchRequest dcomp = new SpringBatchLaunchRequest();
				dcomp.setJobName(input.getJobName());

				Map<String, Object> parametersdcomp = new Hashtable<>();
				parametersdcomp.put("value", input.getValue());
				parametersdcomp.put("inputfile", input.getInputPath()+";compressed");
				parametersdcomp.put("outputfile", input.getOutputPath());	
				dcomp.setParameters(parametersdcomp);
				logger.info("decompress start");
				launchReturnObject = serviceManager.call(serviceName, dcomp, SpringBatchLaunchResponse.class,
						60 * 1000);
				// output 값 세팅
				output.setJobExecutionId(launchReturnObject.getJobExecutionId());
				
				logger.info("returnObject : " + launchReturnObject.getJobName());
				logger.info("batch done");
				break;
			// 스텝을 즉시 종료 후 해당 job abandon 처리
//			case "Forced Stop and Abandon":
//				JobOperator jobOperator = null;
//				
//				logger.info("SpringForced Forced Stop and Abandon start");
//				serviceName = new ServiceName("proobject.batch.SpringBatchStopNabandonService");
//				operReq.setJobExecutionId(input.getJobExecutionId());
//				operReq.setForced(true);
//				returnObject = serviceManager.call(serviceName, operReq, SpringBatchOperationResponse.class, 60 * 1000);
//		
//				output.setJobExecutionId(input.getJobExecutionId());
//				logger.info("returnObject : " + returnObject.getJobSummary());
//				logger.info("batch done");
//				break;
				
//			case "Find Job":
//				logger.info("SpringForced Find Job start");
//				serviceName = new ServiceName("proobject.batch.SpringBatchFindJobExecution");
//				queryReq.setJobExecutionId(input.getJobExecutionId());
//				returnResult = serviceManager.call(serviceName, queryReq, SpringBatchJobQueryResponse.class, 60 * 1000);
//				logger.info("returnObject : " + returnResult.getSummary());
//				logger.info("batch done");
//				break;
				
			default:
				break;
			}

		} catch (Exception e) {
			throw e;
		}
		return output;
	}

}
