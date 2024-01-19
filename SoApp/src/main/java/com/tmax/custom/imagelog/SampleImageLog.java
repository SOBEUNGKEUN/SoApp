package com.tmax.custom.imagelog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.core2.util.consistency.GUID;
import com.tmax.proobject.model.context.Header;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.imagelog.ImageLogDto;
import com.tmax.proobject.service.imagelog.ImageLogHandler;
import com.tmax.proobject.service.util.SystemUtil;

@Component(value = "SampleImageLog")
public class SampleImageLog implements ImageLogHandler {

	@Autowired
	private ImagelogDAO imagelogDAO;
	
	private ProObjectLogger logger = SystemLogger.getLogger();

	@Override
	public void errorImageLog(ServiceName service, RequestContext requestContext, Throwable exception) {
		// TODO Auto-generated method stub
		insertMethod(service, requestContext, exception, "error");
	}

	@Override
	public void postImageLog(ServiceName service, RequestContext requestContext, Object data) {
		// TODO Auto-generated method stub
		insertMethod(service, requestContext, data, "output");
	}

	@Override
	public void preImageLog(ServiceName service, RequestContext requestContext, Object data) {
		// TODO Auto-generated method stub
		insertMethod(service, requestContext, data, "input");

	}

	public void insertMethod(ServiceName service, RequestContext requestContext, Object data, String status) {

		String applicationName = service.getApplicationName();
		String serviceGroupName = service.getServiceGroupName();
		String serviceName = service.getServiceName();

		GUID guid = requestContext.getGuid();
		Header header = requestContext.getRequest().getHeader();

		String dataString = data != null ? data.toString() : "";
		String headerString = header != null ? header.toString() : "";

		ImageLogDto imageLogDto = new ImageLogDto();

		imageLogDto.setApplication(applicationName);
		imageLogDto.setServicegroup(serviceGroupName);
		imageLogDto.setService(serviceName);
		imageLogDto.setGuid(guid.toString());
		imageLogDto.setStatus(status);
		imageLogDto.setData(SystemUtil.serialize(data));
		imageLogDto.setDataString(dataString);
		imageLogDto.setHeader(SystemUtil.serialize(header));
		imageLogDto.setHeaderString(headerString);
		imageLogDto.setInsertTime(System.currentTimeMillis());

		try {
			imagelogDAO.insert(imageLogDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
