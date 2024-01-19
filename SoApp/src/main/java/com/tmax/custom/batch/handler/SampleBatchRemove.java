package com.tmax.custom.batch.handler;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

@Configuration
public class SampleBatchRemove 	{
	
	public ProObjectLogger logger = SystemLogger.getLogger();
	
	@StepScope
	@Bean
	public Tasklet removeExtension(@Value("#{jobParameters['outputfile']}") String outputfile) {
		
		return (contribution, chunckContext) -> {
			
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
	               
//	            ProcessBuilder processBuilder = new ProcessBuilder();
//	            processBuilder.command("mv",gzfilename,rmcompressd);
//	            p = processBuilder.start();
	         
//	            int exitCode =  p.waitFor();
//	            assert exitCode == 0; 
				
//				String cmd = "cp "+gzfilename+" "+rmcompressd;
				
//				String cmd = "rm -rf /home/tmax/src/batch/temp";
				
				String cmd = "rename "+gzfilename+" "+rmcompressd+" "+gzfilename;

				String[] cmds = {"/bin/sh","-c",cmd};
//				
//				String[] cmd = {
//						"sh",
//						"-c",
//						"mv",gzfilename,rmcompressd
//						};
//							
				p = Runtime.getRuntime().exec(cmds);
				p.waitFor();
				logger.info("\nExit :"+ p.exitValue());
				p.destroy();
//	
	        } catch (Exception e) {
	        }
	
			return RepeatStatus.FINISHED;
		};

	}
}
