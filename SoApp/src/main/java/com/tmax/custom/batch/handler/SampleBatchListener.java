package com.tmax.custom.batch.handler;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Configuration;

import com.tmax.proobject.runtime.logger.BatchLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;

@Configuration
public class SampleBatchListener extends JobExecutionListenerSupport{
	
	// extends StepExecutionListenerSupport 대체가능
	
	private ProObjectLogger logger = BatchLogger.getLogger();
	
	// 시작시간
	long startTime;
	// 종료 시간
	long endTime;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		logger.info("#### Before Job ###");
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		
		String outputfile = jobExecution.getJobParameters().getString("outputfile");
		
		logger.info("\noutputfile : "+outputfile);
		
		String rmcompressd;
		String gzfilename;
	    Process p;
	      
	      
	      
	      // outputfile = /home/tmax/src/batch/compressed/sample-data.csv_20240106_2;compressed
	      // ;compressed 제거
	      rmcompressd = outputfile.replaceAll(";compressed","");
	      
	      logger.info("\nrmcompressd : "+rmcompressd);
	      // .gz 붙이기
	      gzfilename = rmcompressd+".gz";
	      
	      logger.info("\ngzfilename : "+gzfilename);
	          
		try {
               
//            ProcessBuilder processBuilder = new ProcessBuilder();
//            processBuilder.command("mv",gzfilename,rmcompressd);
//            p = processBuilder.start();
         
//            int exitCode =  p.waitFor();
//            assert exitCode == 0; 
			
//			String cmd = "cp "+gzfilename+" "+rmcompressd;
			
//			String cmd = "rm -rf /home/tmax/src/batch/temp";
			
			String cmd = "rename "+gzfilename+" "+rmcompressd+" "+gzfilename;

			String[] cmds = {"/bin/sh","-c",cmd};
//			
//			String[] cmd = {
//					"sh",
//					"-c",
//					"mv",gzfilename,rmcompressd
//					};
//						
			p = Runtime.getRuntime().exec(cmds);
			p.waitFor();
			logger.info("\nExit :"+ p.exitValue());
			p.destroy();
//
        } catch (Exception e) {
        }	
	
		// TODO Auto-generated method stub
		endTime = System.currentTimeMillis();
		logger.info("#### 걸린 시간: "+ (endTime - startTime));
		logger.info("#### After Job ###");
	}

}
