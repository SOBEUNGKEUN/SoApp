package com.tmax.custom.controller;

import com.tmax.custom.sample.pc.CustomHeaderTestPC;
import com.tmax.custom.sample.pc.ServletCallPC;
import com.tmax.custom.sample.pc.TcpCallPC;
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
    date= "24. 1. 22. 오후 2:10",
    comments= "SG_CHController"
)

@Controller
public class SpringSG_CHController
{
    @Autowired
    CustomHeaderTestPC _CustomHeaderTestPC;
    
    @Autowired
    ServletCallPC _ServletCallPC;
    
    @Autowired
    TcpCallPC _TcpCallPC;
    
    @Autowired
    ValidExecutor validExecutor;
    @RequestMapping(value="/SoApp/SG_CH/CustomHeaderTestPC_select", method=RequestMethod.POST)
    public void executeCustomHeaderTestPC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_CH.CustomHeaderTestPC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
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
            svcOutput = _CustomHeaderTestPC.select(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_CH/CustomHeaderTestPC_selectError", method=RequestMethod.POST)
    public void executeCustomHeaderTestPC_selectError(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_CH.CustomHeaderTestPC_selectError");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.sample.dto.SampleDTO svcInput = (com.tmax.custom.sample.dto.SampleDTO)protocol.getDto();
        com.tmax.custom.sample.dto.SampleOUTDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _CustomHeaderTestPC.selectError(svcInput);
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
            dtoMsg = new com.tmax.custom.sample.dto.SampleOUTDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_CH/ServletCallPC_testCall", method=RequestMethod.POST)
    public void executeServletCallPC_testCall(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_CH.ServletCallPC_testCall");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
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
            svcOutput = _ServletCallPC.testCall(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_CH/TcpCallPC_select", method=RequestMethod.POST)
    public void executeTcpCallPC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_CH.TcpCallPC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
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
            svcOutput = _TcpCallPC.select(svcInput);
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
