package com.tmax.custom.messagebundle.dao;

import com.tmax.custom.datasoruce.DatabasePO21;
import com.tmax.custom.messagebundle.dto.messageDTO;

@DatabasePO21
public interface messagebundleDAO {
		
	public void insert(messageDTO input) throws Exception;
	
	public void updateName(messageDTO input) throws Exception;
	
	public void updateTitle(messageDTO input) throws Exception;
	
	public void updateType(messageDTO input) throws Exception;
	
	public void delete(messageDTO input) throws Exception;

	public messageDTO select (messageDTO input) throws Exception;
}
