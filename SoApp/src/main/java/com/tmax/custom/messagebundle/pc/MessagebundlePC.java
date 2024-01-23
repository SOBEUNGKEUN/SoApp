package com.tmax.custom.messagebundle.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmax.custom.messagebundle.dto.messageDTO;
import com.tmax.custom.messagebundle.ec.messagebundleEC;
import com.tmax.proobject.core2.annotation.ServiceMethod;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 1. 3. 오후 4:16",
	comments= "MessagebundlePC"
)
@Service
public class MessagebundlePC{
	
	@Autowired
//	@Autowired(required=false)
	messagebundleEC messagebundleEC;

	/**
	 * @param com.tmax.custom.messagebundle.dto.messageDTO
	 * @return com.tmax.custom.messagebundle.dto.messageDTO
	 */
	@ServiceMethod
	public messageDTO insert(messageDTO input) throws Throwable {
		// TODO Auto-generated method stub
		messageDTO output = new messageDTO();
		messagebundleEC.insert(input);
		output.setMessage("성공");
		return output;
	}

	/**
	 * @param com.tmax.custom.messagebundle.dto.messageDTO
	 * @return com.tmax.custom.messagebundle.dto.messageDTO
	 */
	@ServiceMethod
	public messageDTO delete(messageDTO input) throws Throwable {
		// TODO Auto-generated method stub
		messageDTO output = new messageDTO();
		output = messagebundleEC.delete(input);
		return output;
	}

	/**
	 * @param com.tmax.custom.messagebundle.dto.messageDTO
	 * @return com.tmax.custom.messagebundle.dto.messageDTO
	 */
	@ServiceMethod
	public messageDTO update(messageDTO input) throws Throwable {
		// TODO Auto-generated method stub
		messageDTO output = new messageDTO();
		
		output = messagebundleEC.update(input);
		
		return output;
	}

	/**
	 * @param com.tmax.custom.messagebundle.dto.messageDTO
	 * @return com.tmax.custom.messagebundle.dto.messageDTO
	 */
	@ServiceMethod
	public messageDTO select(messageDTO input) throws Throwable {
		// TODO Auto-generated method stub	
		messageDTO output = new messageDTO();
		output = messagebundleEC.select(input);
		return output;
	}
    
}

