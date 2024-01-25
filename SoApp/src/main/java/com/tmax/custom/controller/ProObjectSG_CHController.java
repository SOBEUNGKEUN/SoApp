package com.tmax.custom.controller;

import com.tmax.custom.header.CustomHeader;
import com.tmax.custom.sample.pc.CustomHeaderTestPC;
import com.tmax.custom.sample.pc.ServletCallPC;
import com.tmax.custom.sample.pc.TcpCallPC;
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
    date= "24. 1. 25. 오후 5:22",
    comments= "SG_CHController"
)

@Component(value="ProObjectSG_CHController")
@EnableAutoConfiguration
@ProObjectController
public class ProObjectSG_CHController
{
    @Autowired
    CustomHeaderTestPC _CustomHeaderTestPC;
    
    @Autowired
    ServletCallPC _ServletCallPC;
    
    @Autowired
    TcpCallPC _TcpCallPC;
    
    @Autowired
    ValidExecutor validExecutor;
    public Object executeCustomHeaderTestPC_select(ProObjectControllerInput controllerInput) throws Throwable {
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
                switch (msgType) {
                    case JSON:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                    case XML:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgXml();
                        break;
                    default:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            msgType = ProObjectControllerUtil.getMsgType(header.getInputMsgType(), controllerInput.getRequestMessageType());
            
            if(parser instanceof DefaultProObjectBodyParser) {
                switch (msgType) {
                    case JSON:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                    case XML:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgXml();
                        break;
                    default:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                }
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
            svcOutput = _CustomHeaderTestPC.select(svcInput);
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
                switch (msgType) {
                    case JSON:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                    case XML:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgXml();
                        break;
                    default:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            msgType = ProObjectControllerUtil.getMsgType(header.getOutputMsgType(), controllerInput.getResponseMessageType());
            
            if(parser instanceof DefaultProObjectBodyParser) {
                switch (msgType) {
                    case JSON:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                    case XML:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgXml();
                        break;
                    default:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeCustomHeaderTestPC_selectError(ProObjectControllerInput controllerInput) throws Throwable {
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
                switch (msgType) {
                    case JSON:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                    case XML:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgXml();
                        break;
                    default:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            msgType = ProObjectControllerUtil.getMsgType(header.getInputMsgType(), controllerInput.getRequestMessageType());
            
            if(parser instanceof DefaultProObjectBodyParser) {
                switch (msgType) {
                    case JSON:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                    case XML:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgXml();
                        break;
                    default:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.tmax.custom.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.tmax.custom.sample.dto.SampleOUTDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _CustomHeaderTestPC.selectError(svcInput);
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
                switch (msgType) {
                    case JSON:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                    case XML:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgXml();
                        break;
                    default:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            msgType = ProObjectControllerUtil.getMsgType(header.getOutputMsgType(), controllerInput.getResponseMessageType());
            
            if(parser instanceof DefaultProObjectBodyParser) {
                switch (msgType) {
                    case JSON:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleOUTDTOMsgJson();
                        break;
                    case XML:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleOUTDTOMsgXml();
                        break;
                    default:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleOUTDTOMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeServletCallPC_testCall(ProObjectControllerInput controllerInput) throws Throwable {
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
                switch (msgType) {
                    case JSON:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                    case XML:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgXml();
                        break;
                    default:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            msgType = ProObjectControllerUtil.getMsgType(header.getInputMsgType(), controllerInput.getRequestMessageType());
            
            if(parser instanceof DefaultProObjectBodyParser) {
                switch (msgType) {
                    case JSON:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                    case XML:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgXml();
                        break;
                    default:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                }
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
            svcOutput = _ServletCallPC.testCall(svcInput);
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
                switch (msgType) {
                    case JSON:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                    case XML:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgXml();
                        break;
                    default:
                        headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            msgType = ProObjectControllerUtil.getMsgType(header.getOutputMsgType(), controllerInput.getResponseMessageType());
            
            if(parser instanceof DefaultProObjectBodyParser) {
                switch (msgType) {
                    case JSON:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                    case XML:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgXml();
                        break;
                    default:
                        dtoMsg = new com.tmax.custom.sample.dto.SampleDTOMsgJson();
                        break;
                }
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeTcpCallPC_select(ProObjectControllerInput controllerInput) throws Throwable {
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
                headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
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
            svcOutput = _TcpCallPC.select(svcInput);
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
                headerMsg = new com.tmax.custom.header.CustomHeaderMsgJson();
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
