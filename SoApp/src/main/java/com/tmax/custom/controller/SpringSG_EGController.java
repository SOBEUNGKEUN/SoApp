package com.tmax.custom.controller;

import com.tmax.custom.sample.pc.SamplePC;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.protocol.http.ProObjectHttpProtocol;
import com.tmax.proobject.network.parser.HttpBodyParser;
import com.tmax.proobject.engine.parser.DefaultHttpBodyParser;
import com.tmax.proobject.service.util.SpringControllerUtil;
import com.tmax.proobject.service.exception.ProObjectServiceErrorHandlingException;
import com.tmax.proobject.runtime.context.ServiceContextHolder;
import com.tmax.proobject.runtime.util.ParserUtil;
import com.tmax.proobject.runtime.memory.validator.ValidExecutor;

@javax.annotation.Generated(
    value = "com.tmaxsoft.sts4.codegen.controller.SpringControllerGenerator",
    date= "23. 12. 12. 오후 5:04",
    comments= "SG_EGController"
)

@Controller
public class SpringSG_EGController
{
    @Autowired
    SamplePC _SamplePC;
    
    @Autowired
    ValidExecutor validExecutor;
    @RequestMapping(value="/SoApp/SG_EG/SamplePC_select", method=RequestMethod.POST)
    public void executeSamplePC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.sample.dto.SampleDTO svcInput = (com.tmax.custom.sample.dto.SampleDTO)protocol.getDto();
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            try {
                SpringControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e);
            } catch (Throwable e1) {
                Exception exception = new ProObjectServiceErrorHandlingException(e1);
                throw exception;
            }
            
            SpringControllerUtil.writeErrorResponseBody(response, e, svcInput, serviceName, requestContext, msgType, parser);
            ServiceContextHolder.removeServiceContext();
            return;
        }
        
        SpringControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput);
        ServiceContextHolder.removeServiceContext();
        
        protocol.setDto(svcOutput);
        
        if (parser instanceof DefaultHttpBodyParser) {
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/SamplePC_insert", method=RequestMethod.POST)
    public void executeSamplePC_insert(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_insert");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.sample.dto.SampleDTO svcInput = (com.tmax.custom.sample.dto.SampleDTO)protocol.getDto();
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.insert(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            try {
                SpringControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e);
            } catch (Throwable e1) {
                Exception exception = new ProObjectServiceErrorHandlingException(e1);
                throw exception;
            }
            
            SpringControllerUtil.writeErrorResponseBody(response, e, svcInput, serviceName, requestContext, msgType, parser);
            ServiceContextHolder.removeServiceContext();
            return;
        }
        
        SpringControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput);
        ServiceContextHolder.removeServiceContext();
        
        protocol.setDto(svcOutput);
        
        if (parser instanceof DefaultHttpBodyParser) {
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/SamplePC_update", method=RequestMethod.POST)
    public void executeSamplePC_update(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_update");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.sample.dto.SampleDTO svcInput = (com.tmax.custom.sample.dto.SampleDTO)protocol.getDto();
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.update(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            try {
                SpringControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e);
            } catch (Throwable e1) {
                Exception exception = new ProObjectServiceErrorHandlingException(e1);
                throw exception;
            }
            
            SpringControllerUtil.writeErrorResponseBody(response, e, svcInput, serviceName, requestContext, msgType, parser);
            ServiceContextHolder.removeServiceContext();
            return;
        }
        
        SpringControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput);
        ServiceContextHolder.removeServiceContext();
        
        protocol.setDto(svcOutput);
        
        if (parser instanceof DefaultHttpBodyParser) {
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/SamplePC_delete", method=RequestMethod.POST)
    public void executeSamplePC_delete(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_delete");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.sample.dto.SampleDTO svcInput = (com.tmax.custom.sample.dto.SampleDTO)protocol.getDto();
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.delete(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            try {
                SpringControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e);
            } catch (Throwable e1) {
                Exception exception = new ProObjectServiceErrorHandlingException(e1);
                throw exception;
            }
            
            SpringControllerUtil.writeErrorResponseBody(response, e, svcInput, serviceName, requestContext, msgType, parser);
            ServiceContextHolder.removeServiceContext();
            return;
        }
        
        SpringControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput);
        ServiceContextHolder.removeServiceContext();
        
        protocol.setDto(svcOutput);
        
        if (parser instanceof DefaultHttpBodyParser) {
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
}
