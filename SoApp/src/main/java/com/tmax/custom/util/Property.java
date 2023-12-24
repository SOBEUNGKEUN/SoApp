package com.tmax.custom.util;

public class Property {
	
	private static PropertyValues propertyValues;
	
	static {
		propertyValues = new PropertyValuesSet();
	}
	
	public static String getPO21ServletUrl(String poServletUrl) {
		
		return propertyValues.getPO21ServletUrl(poServletUrl);
	}
}
