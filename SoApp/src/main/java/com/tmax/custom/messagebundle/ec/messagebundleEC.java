package com.tmax.custom.messagebundle.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tmax.custom.messagebundle.dao.messagebundleDAO;
import com.tmax.custom.messagebundle.dto.messageDTO;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

@Repository
public class messagebundleEC {
	
	String code = null;
	
	private ProObjectLogger logger = SystemLogger.getLogger();
	
	@Autowired
	messagebundleDAO messagebundleDAO;
	
	public void insert(messageDTO input) throws Throwable{	
		messagebundleDAO.insert(input);
	}
	
	public messageDTO update(messageDTO input) throws Throwable{
		
		logger.info("input 로그 찍기 name : " + input.getName());
		logger.info("input 로그 찍기 name : " + input.getName().isEmpty());
		logger.info("input 로그 찍기 title : " + input.getTitle());
		logger.info("input 로그 찍기 title : " + input.getTitle().isEmpty());
		
		code = input.getCode();
		messageDTO output = new messageDTO();
		if(!input.getName().isEmpty() && !input.getTitle().isEmpty()){
			messagebundleDAO.updateName(input);
			messagebundleDAO.updateTitle(input);
			output.setMessage(code+"title, name update 성공");	
			return output;
		}
		else if(!input.getName().isEmpty())
		{
			messagebundleDAO.updateName(input);
			output.setMessage(code+"name update 성공");
			return output;
		}
		else if (!input.getTitle().isEmpty()) {
			messagebundleDAO.updateTitle(input);
			output.setMessage(code+"title update 성공");
			return output;
		}
		else {
			output.setMessage(code+"update 실패");
			return output;
		}
	}
	
	public messageDTO delete(messageDTO input) throws Throwable{
		messageDTO output = new messageDTO();
		code = input.getCode();
		if(!code.isEmpty()) {
			messagebundleDAO.delete(input);
			output.setMessage(code+"삭제 완료");
			return output;
		}else {
			output.setMessage("코드를 입력하세요.");
			return output;
		}
	}
	
	public messageDTO select(messageDTO input) throws Throwable{
		messageDTO output = new messageDTO();
		output = messagebundleDAO.select(input);
		return output;
		
	}
}
