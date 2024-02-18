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
import com.tmax.custom.sample.pc.MsCallPC;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.core2.annotation.ProObjectController;
import com.tmax.proobject.model.context.Header;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.parser.ProObjectBodyParser;
import com.tmax.proobject.engine.parser.DefaultProObjectBodyParser;
import com.tmax.proobject.runtime.ProObjectControllerInput;
import com.tmax.proobject.runtime.ProObjectControllerOutput;
import com.tmax.proobject.runtime.context.ServiceContextHolder;
import com.tmax.proobject.runtime.util.ParserUtil;
import com.tmax.proobject.service.util.ProObjectControllerUtil;
import com.tmax.proobject.runtime.memory.validator.ValidExecutor;

@javax.annotation.Generated(
    value = "com.tmaxsoft.sts4.codegen.controller.POControllerGenerator",
    date= "24. 2. 18. 오후 2:35",
    comments= "SG_EGController"
)

@Component(value="ProObjectSG_EGController")
@EnableAutoConfiguration
@ProObjectController
public class ProObjectSG_EGController
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
    MsCallPC _MsCallPC;
    
    @Autowired
    ValidExecutor validExecutor;
    public Object executeSamplePC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSamplePC_insert(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.insert(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSamplePC_update(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.update(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSamplePC_delete(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.delete(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSamplePC_multiselect(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleMultiDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.multiselect(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleMultiDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSamplePC_multiinsert(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleMultiDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleMultiDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleMultiDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleMultiDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.multiinsert(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSamplePC_timeout(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.timeout(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeBatchCall_service(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.batch.dto.BatchTestDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.batch.dto.BatchTestDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.batch.dto.BatchTestDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.batch.dto.BatchTestDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.batch.dto.BatchTestDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _BatchCall.service(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.batch.dto.BatchTestDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeMessagebundlePC_insert(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.messagebundle.dto.messageDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.insert(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeMessagebundlePC_delete(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.messagebundle.dto.messageDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.delete(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeMessagebundlePC_update(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.messagebundle.dto.messageDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.update(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeMessagebundlePC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.messagebundle.dto.messageDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.messagebundle.dto.messageDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.messagebundle.dto.messageDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MessagebundlePC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.messagebundle.dto.messageDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSyncAsyncCall_sync(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SyncAsyncCall.sync(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSyncAsyncCall_async(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SyncAsyncCall.async(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSyncAsyn_test(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SyncAsyn.test(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeMemoryCalculatorPC_test(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.MemoryCalDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.MemoryCalDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.MemoryCalDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.MemoryCalDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.MemoryCalDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MemoryCalculatorPC.test(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.MemoryCalDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSampleCroPC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SampleCroPC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSampleMatPC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SampleMatPC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeSampleCachePC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.systemcontext.dto.SampleCacheDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.systemcontext.dto.SampleCacheDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.systemcontext.dto.SampleCacheDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.systemcontext.dto.SampleCacheDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.systemcontext.dto.SampleCacheDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SampleCachePC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.systemcontext.dto.SampleCacheDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeTCPpoHeaderCall_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _TCPpoHeaderCall.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeMsCallPC_call(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MsCallPC.call(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeMsCallPC_SoAppCall(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.tmax.custom.sample.dto.SampleDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _MsCallPC.SoAppCall(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
}
