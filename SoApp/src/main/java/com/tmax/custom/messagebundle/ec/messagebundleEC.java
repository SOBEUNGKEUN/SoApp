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
		
		if(code.isEmpty()) {
			output.setMessage("메세지 코드를 입력하세요.");
			return output;
		}else if(input.getName().isEmpty() && input.getTitle().isEmpty() && input.getType().isEmpty()){
			output.setMessage(code+"NAME , TITLE, TYPE값을 지정해주세요");
			return output;
		}else {
			if(!input.getName().isEmpty())
			{
				logger.info("1번");
				messagebundleDAO.updateName(input);	
			}
			if (!input.getTitle().isEmpty()) {
				logger.info("2번");
				messagebundleDAO.updateTitle(input);	
			}
			if (!input.getType().isEmpty()) {
				logger.info("3번");
				messagebundleDAO.updateType(input);
			}
			output.setMessage(code + "메세지 update 성공");
		}
		logger.info("4번");
		return output;
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
