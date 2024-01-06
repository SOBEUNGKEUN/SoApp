package com.tmax.custom.test;

public class Test {

	public static void main(String[] args) {
		
		 String outputfile = "/home/tmax/src/batch/compressed/sample-data.csv_20240106_2.gz;compressed";
	      // ;compressed 제거
	   
//	      int index = outputfile.indexOf(";");
	   
		 
	      // rmcompressd = /home/tmax/src/batch/compressed/sample-data.csv_20240106_2
	     String rmcompressd = outputfile.replaceAll(";compressed","");
	     
	     System.out.println(rmcompressd);
	}

}
