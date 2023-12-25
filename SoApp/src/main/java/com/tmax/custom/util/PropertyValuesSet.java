package com.tmax.custom.util;

public class PropertyValuesSet implements PropertyValues {

	@Override
	public String getPO21ServletUrl(String poServletUrl) {
		// TODO Auto-generated method stub
		return "http://192.168.56.1:10110/po-21/"+poServletUrl;
	}

}
