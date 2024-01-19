package com.tmax.custom.controller;

import com.tmax.custom.sample.pc.SamplePC;
import com.tmax.custom.batch.service.BatchCall;
import com.tmax.custom.messagebundle.pc.MessagebundlePC;
import com.tmax.custom.sample.pc.SyncAsyncCall;
import com.tmax.custom.sample.pc.SyncAsyn;
import com.tmax.custom.sample.pc.MemoryCalculatorPC;
import com.tmax.custom.dataSourceTest.pc.SampleCroPC;
import com.tmax.custom.dataSourceTest.pc.SampleMatPC;
import com.tmax.custom.systemcontext.pc.SampleCachePC;
import com.tmax.custom.sample.pc.TCPpoHeaderCall;
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
    date= "24. 1. 18. 오후 5:44",
    comments= "SG_EGController"
)

@Controller
public class SpringSG_EGController
{
    @Autowired
    SamplePC _SamplePC;
    
    @Autowired
    BatchCall _BatchCall;
    
    @Autowired
    MessagebundlePC _MessagebundlePC;
    
    @Autowired
    SyncAsyncCall _SyncAsyncCall;
    
    @Autowired
    SyncAsyn _SyncAsyn;
    
    @Autowired
    MemoryCalculatorPC _MemoryCalculatorPC;
    
    @Autowired
    SampleCroPC _SampleCroPC;
    
    @Autowired
    SampleMatPC _SampleMatPC;
    
    @Autowired
    SampleCachePC _SampleCachePC;
    
    @Autowired
    TCPpoHeaderCall _TCPpoHeaderCall;
    
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
    
    @RequestMapping(value="/SoApp/SG_EG/SamplePC_multiselect", method=RequestMethod.POST)
    public void executeSamplePC_multiselect(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_multiselect");
       
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
        com.tmax.custom.sample.dto.SampleMultiDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.multiselect(svcInput);
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
            dtoMsg = new com.tmax.custom.sample.dto.SampleMultiDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/SamplePC_multiinsert", method=RequestMethod.POST)
    public void executeSamplePC_multiinsert(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_multiinsert");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.sample.dto.SampleMultiDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.sample.dto.SampleMultiDTO svcInput = (com.tmax.custom.sample.dto.SampleMultiDTO)protocol.getDto();
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.multiinsert(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_EG/SamplePC_timeout", method=RequestMethod.POST)
    public void executeSamplePC_timeout(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SamplePC_timeout");
       
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
            svcOutput = _SamplePC.timeout(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_EG/BatchCall_service", method=RequestMethod.POST)
    public void executeBatchCall_service(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.BatchCall_service");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.batch.dto.BatchTestDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.batch.dto.BatchTestDTO svcInput = (com.tmax.custom.batch.dto.BatchTestDTO)protocol.getDto();
        com.tmax.custom.batch.dto.BatchTestDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _BatchCall.service(svcInput);
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
            dtoMsg = new com.tmax.custom.batch.dto.BatchTestDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/MessagebundlePC_insert", method=RequestMethod.POST)
    public void executeMessagebundlePC_insert(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.MessagebundlePC_insert");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.messagebundle.dto.messageDTO svcInput = (com.tmax.custom.messagebundle.dto.messageDTO)protocol.getDto();
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.insert(svcInput);
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
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/MessagebundlePC_delete", method=RequestMethod.POST)
    public void executeMessagebundlePC_delete(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.MessagebundlePC_delete");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.messagebundle.dto.messageDTO svcInput = (com.tmax.custom.messagebundle.dto.messageDTO)protocol.getDto();
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.delete(svcInput);
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
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/MessagebundlePC_update", method=RequestMethod.POST)
    public void executeMessagebundlePC_update(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.MessagebundlePC_update");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.messagebundle.dto.messageDTO svcInput = (com.tmax.custom.messagebundle.dto.messageDTO)protocol.getDto();
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.update(svcInput);
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
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/MessagebundlePC_select", method=RequestMethod.POST)
    public void executeMessagebundlePC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.MessagebundlePC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.messagebundle.dto.messageDTO svcInput = (com.tmax.custom.messagebundle.dto.messageDTO)protocol.getDto();
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.select(svcInput);
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
            dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/SyncAsyncCall_sync", method=RequestMethod.POST)
    public void executeSyncAsyncCall_sync(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SyncAsyncCall_sync");
       
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
            svcOutput = _SyncAsyncCall.sync(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_EG/SyncAsyncCall_async", method=RequestMethod.POST)
    public void executeSyncAsyncCall_async(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SyncAsyncCall_async");
       
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
            svcOutput = _SyncAsyncCall.async(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_EG/SyncAsyn_test", method=RequestMethod.POST)
    public void executeSyncAsyn_test(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SyncAsyn_test");
       
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
            svcOutput = _SyncAsyn.test(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_EG/MemoryCalculatorPC_test", method=RequestMethod.POST)
    public void executeMemoryCalculatorPC_test(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.MemoryCalculatorPC_test");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.sample.dto.MemoryCalDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.sample.dto.MemoryCalDTO svcInput = (com.tmax.custom.sample.dto.MemoryCalDTO)protocol.getDto();
        com.tmax.custom.sample.dto.MemoryCalDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MemoryCalculatorPC.test(svcInput);
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
            dtoMsg = new com.tmax.custom.sample.dto.MemoryCalDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/SampleCroPC_select", method=RequestMethod.POST)
    public void executeSampleCroPC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SampleCroPC_select");
       
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
            svcOutput = _SampleCroPC.select(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_EG/SampleMatPC_select", method=RequestMethod.POST)
    public void executeSampleMatPC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SampleMatPC_select");
       
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
            svcOutput = _SampleMatPC.select(svcInput);
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
    
    @RequestMapping(value="/SoApp/SG_EG/SampleCachePC_select", method=RequestMethod.POST)
    public void executeSampleCachePC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.SampleCachePC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.tmax.custom.systemcontext.dto.SampleCacheDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.tmax.custom.systemcontext.dto.SampleCacheDTO svcInput = (com.tmax.custom.systemcontext.dto.SampleCacheDTO)protocol.getDto();
        com.tmax.custom.systemcontext.dto.SampleCacheDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SampleCachePC.select(svcInput);
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
            dtoMsg = new com.tmax.custom.systemcontext.dto.SampleCacheDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/SoApp/SG_EG/TCPpoHeaderCall_select", method=RequestMethod.POST)
    public void executeTCPpoHeaderCall_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("SoApp.SG_EG.TCPpoHeaderCall_select");
       
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
            svcOutput = _TCPpoHeaderCall.select(svcInput);
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
