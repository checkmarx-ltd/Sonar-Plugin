/**
 * CxSDKWebServiceSoap_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxSDKWebServiceSoap_BindingStub extends org.apache.axis.client.Stub implements CxSDKWebServiceSoap_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[34];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Scan");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "args"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CliScanArgs"), CliScanArgs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID"));
        oper.setReturnClass(CxWSResponseRunID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BranchProjectById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "originProjectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "newBranchProjectName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID"));
        oper.setReturnClass(CxWSResponseRunID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "BranchProjectByIdResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ScanWithOriginName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "args"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CliScanArgs"), CliScanArgs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "origName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID"));
        oper.setReturnClass(CxWSResponseRunID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithOriginNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelScan");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RunId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CancelScanResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteProjects");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfLong"), ArrayOfLong.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DeleteProjectsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteScans");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "scanIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfLong"), ArrayOfLong.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DeleteScansResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ScanWithScheduling");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "args"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CliScanArgs"), CliScanArgs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "schedulingData"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID"));
        oper.setReturnClass(CxWSResponseRunID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithSchedulingResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ScanWithSchedulingWithCron");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "args"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CliScanArgs"), CliScanArgs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "cronString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "utcEpochStartTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "utcEpochEndTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID"));
        oper.setReturnClass(CxWSResponseRunID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithSchedulingWithCronResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateScanComment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Comment"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UpdateScanCommentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetPresetList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponsePresetList"));
        oper.setReturnClass(CxWSResponsePresetList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetPresetListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetConfigurationSetList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseConfigSetList"));
        oper.setReturnClass(CxWSResponseConfigSetList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetConfigurationSetListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProjectsDisplayData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectsDisplayData"));
        oper.setReturnClass(CxWSResponseProjectsDisplayData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetProjectsDisplayDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProjectScannedDisplayData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectScannedDisplayData"));
        oper.setReturnClass(CxWSResponseProjectScannedDisplayData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetProjectScannedDisplayDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProjectConfiguration");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectConfig"));
        oper.setReturnClass(CxWSResponseProjectConfig.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetProjectConfigurationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateProjectIncrementalConfiguration");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectConfiguration"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectConfiguration"), ProjectConfiguration.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UpdateProjectIncrementalConfigurationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Login");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "applicationCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"), Credentials.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "lcid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseLoginData"));
        oper.setReturnClass(CxWSResponseLoginData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LoginResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SsoLogin");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "encryptedCredentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"), Credentials.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "lcid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseLoginData"));
        oper.setReturnClass(CxWSResponseLoginData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SsoLoginResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LoginWithToken");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "token"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "lcid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseLoginData"));
        oper.setReturnClass(CxWSResponseLoginData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LoginWithTokenResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Logout");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LogoutResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAssociatedGroupsList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseGroupList"));
        oper.setReturnClass(CxWSResponseGroupList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetAssociatedGroupsListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetStatusOfSingleScan");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "runId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanStatus"));
        oper.setReturnClass(CxWSResponseScanStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetStatusOfSingleScanResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetScansDisplayDataForAllProjects");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScansDisplayData"));
        oper.setReturnClass(CxWSResponseScansDisplayData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScansDisplayDataForAllProjectsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetScanSummary");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanSummary"));
        oper.setReturnClass(CxWSResponseScanSummary.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanSummaryResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateProjectConfiguration");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectConfiguration"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectConfiguration"), ProjectConfiguration.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UpdateProjectConfigurationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "userID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DeleteUserResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllUsers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseUserData"));
        oper.setReturnClass(CxWSResponseUserData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetAllUsersResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CreateScanReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "reportRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSReportRequest"), CxWSReportRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSCreateReportResponse"));
        oper.setReturnClass(CxWSCreateReportResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CreateScanReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetScanReportStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ReportID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSReportStatusResponse"));
        oper.setReturnClass(CxWSReportStatusResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanReportStatusResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetScanReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ReportID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanResults"));
        oper.setReturnClass(CxWSResponseScanResults.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanReportResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExecuteDataRetention");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "dataRetentionConfiguration"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDataRetentionConfiguration"), CxDataRetentionConfiguration.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ExecuteDataRetentionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("StopDataRetention");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StopDataRetentionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTeamLdapGroupsMapping");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "teamId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseTeamLdapGroupMappingData"));
        oper.setReturnClass(CxWSResponseTeamLdapGroupMappingData.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetTeamLdapGroupsMappingResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetTeamLdapGroupsMapping");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "teamId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ldapGroups"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSLdapGroupMapping"), ArrayOfCxWSLdapGroupMapping.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SetTeamLdapGroupsMappingResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsValidProjectName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SessionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GroupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse"));
        oper.setReturnClass(CxWSBasicRepsonse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsValidProjectNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

    }

    public CxSDKWebServiceSoap_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CxSDKWebServiceSoap_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CxSDKWebServiceSoap_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">BranchProjectById");
            cachedSerQNames.add(qName);
            cls = BranchProjectById.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">BranchProjectByIdResponse");
            cachedSerQNames.add(qName);
            cls = BranchProjectByIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">CancelScan");
            cachedSerQNames.add(qName);
            cls = CancelScan.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">CancelScanResponse");
            cachedSerQNames.add(qName);
            cls = CancelScanResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">CreateScanReport");
            cachedSerQNames.add(qName);
            cls = CreateScanReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">CreateScanReportResponse");
            cachedSerQNames.add(qName);
            cls = CreateScanReportResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">DeleteProjects");
            cachedSerQNames.add(qName);
            cls = DeleteProjects.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">DeleteProjectsResponse");
            cachedSerQNames.add(qName);
            cls = DeleteProjectsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">DeleteScans");
            cachedSerQNames.add(qName);
            cls = DeleteScans.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">DeleteScansResponse");
            cachedSerQNames.add(qName);
            cls = DeleteScansResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">DeleteUser");
            cachedSerQNames.add(qName);
            cls = DeleteUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">DeleteUserResponse");
            cachedSerQNames.add(qName);
            cls = DeleteUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ExecuteDataRetention");
            cachedSerQNames.add(qName);
            cls = ExecuteDataRetention.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ExecuteDataRetentionResponse");
            cachedSerQNames.add(qName);
            cls = ExecuteDataRetentionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetAllUsers");
            cachedSerQNames.add(qName);
            cls = GetAllUsers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetAllUsersResponse");
            cachedSerQNames.add(qName);
            cls = GetAllUsersResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetAssociatedGroupsList");
            cachedSerQNames.add(qName);
            cls = GetAssociatedGroupsList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetAssociatedGroupsListResponse");
            cachedSerQNames.add(qName);
            cls = GetAssociatedGroupsListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetConfigurationSetList");
            cachedSerQNames.add(qName);
            cls = GetConfigurationSetList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetConfigurationSetListResponse");
            cachedSerQNames.add(qName);
            cls = GetConfigurationSetListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetPresetList");
            cachedSerQNames.add(qName);
            cls = GetPresetList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetPresetListResponse");
            cachedSerQNames.add(qName);
            cls = GetPresetListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetProjectConfiguration");
            cachedSerQNames.add(qName);
            cls = GetProjectConfiguration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetProjectConfigurationResponse");
            cachedSerQNames.add(qName);
            cls = GetProjectConfigurationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetProjectScannedDisplayData");
            cachedSerQNames.add(qName);
            cls = GetProjectScannedDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetProjectScannedDisplayDataResponse");
            cachedSerQNames.add(qName);
            cls = GetProjectScannedDisplayDataResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetProjectsDisplayData");
            cachedSerQNames.add(qName);
            cls = GetProjectsDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetProjectsDisplayDataResponse");
            cachedSerQNames.add(qName);
            cls = GetProjectsDisplayDataResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanReport");
            cachedSerQNames.add(qName);
            cls = GetScanReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanReportResponse");
            cachedSerQNames.add(qName);
            cls = GetScanReportResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanReportStatus");
            cachedSerQNames.add(qName);
            cls = GetScanReportStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanReportStatusResponse");
            cachedSerQNames.add(qName);
            cls = GetScanReportStatusResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScansDisplayDataForAllProjects");
            cachedSerQNames.add(qName);
            cls = GetScansDisplayDataForAllProjects.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScansDisplayDataForAllProjectsResponse");
            cachedSerQNames.add(qName);
            cls = GetScansDisplayDataForAllProjectsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanSummary");
            cachedSerQNames.add(qName);
            cls = GetScanSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetScanSummaryResponse");
            cachedSerQNames.add(qName);
            cls = GetScanSummaryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetStatusOfSingleScan");
            cachedSerQNames.add(qName);
            cls = GetStatusOfSingleScan.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetStatusOfSingleScanResponse");
            cachedSerQNames.add(qName);
            cls = GetStatusOfSingleScanResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetTeamLdapGroupsMapping");
            cachedSerQNames.add(qName);
            cls = GetTeamLdapGroupsMapping.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">GetTeamLdapGroupsMappingResponse");
            cachedSerQNames.add(qName);
            cls = GetTeamLdapGroupsMappingResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">IsValidProjectName");
            cachedSerQNames.add(qName);
            cls = IsValidProjectName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">IsValidProjectNameResponse");
            cachedSerQNames.add(qName);
            cls = IsValidProjectNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">Login");
            cachedSerQNames.add(qName);
            cls = Login.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">LoginResponse");
            cachedSerQNames.add(qName);
            cls = LoginResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">LoginWithToken");
            cachedSerQNames.add(qName);
            cls = LoginWithToken.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">LoginWithTokenResponse");
            cachedSerQNames.add(qName);
            cls = LoginWithTokenResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">Logout");
            cachedSerQNames.add(qName);
            cls = Logout.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">LogoutResponse");
            cachedSerQNames.add(qName);
            cls = LogoutResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">Scan");
            cachedSerQNames.add(qName);
            cls = Scan.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanResponse");
            cachedSerQNames.add(qName);
            cls = ScanResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithOriginName");
            cachedSerQNames.add(qName);
            cls = ScanWithOriginName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithOriginNameResponse");
            cachedSerQNames.add(qName);
            cls = ScanWithOriginNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithScheduling");
            cachedSerQNames.add(qName);
            cls = ScanWithScheduling.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithSchedulingResponse");
            cachedSerQNames.add(qName);
            cls = ScanWithSchedulingResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithSchedulingWithCron");
            cachedSerQNames.add(qName);
            cls = ScanWithSchedulingWithCron.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">ScanWithSchedulingWithCronResponse");
            cachedSerQNames.add(qName);
            cls = ScanWithSchedulingWithCronResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">SetTeamLdapGroupsMapping");
            cachedSerQNames.add(qName);
            cls = SetTeamLdapGroupsMapping.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">SetTeamLdapGroupsMappingResponse");
            cachedSerQNames.add(qName);
            cls = SetTeamLdapGroupsMappingResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">SsoLogin");
            cachedSerQNames.add(qName);
            cls = SsoLogin.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">SsoLoginResponse");
            cachedSerQNames.add(qName);
            cls = SsoLoginResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">StopDataRetention");
            cachedSerQNames.add(qName);
            cls = StopDataRetention.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">StopDataRetentionResponse");
            cachedSerQNames.add(qName);
            cls = StopDataRetentionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateProjectConfiguration");
            cachedSerQNames.add(qName);
            cls = UpdateProjectConfiguration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateProjectConfigurationResponse");
            cachedSerQNames.add(qName);
            cls = UpdateProjectConfigurationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateProjectIncrementalConfiguration");
            cachedSerQNames.add(qName);
            cls = UpdateProjectIncrementalConfiguration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateProjectIncrementalConfigurationResponse");
            cachedSerQNames.add(qName);
            cls = UpdateProjectIncrementalConfigurationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateScanComment");
            cachedSerQNames.add(qName);
            cls = UpdateScanComment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", ">UpdateScanCommentResponse");
            cachedSerQNames.add(qName);
            cls = UpdateScanCommentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfAnyType");
            cachedSerQNames.add(qName);
            cls = ArrayOfAnyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfConfigurationSet");
            cachedSerQNames.add(qName);
            cls = ArrayOfConfigurationSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSEnableCRUDAction");
            cachedSerQNames.add(qName);
            cls = ArrayOfCxWSEnableCRUDAction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSIssueTrackingParam");
            cachedSerQNames.add(qName);
            cls = ArrayOfCxWSIssueTrackingParam.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSItemAndCRUD");
            cachedSerQNames.add(qName);
            cls = ArrayOfCxWSItemAndCRUD.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSLdapGroupMapping");
            cachedSerQNames.add(qName);
            cls = ArrayOfCxWSLdapGroupMapping.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSProjectCustomField");
            cachedSerQNames.add(qName);
            cls = ArrayOfCxWSProjectCustomField.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfCxWSQueryLanguageState");
            cachedSerQNames.add(qName);
            cls = ArrayOfCxWSQueryLanguageState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfDayOfWeek");
            cachedSerQNames.add(qName);
            cls = ArrayOfDayOfWeek.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfGroup");
            cachedSerQNames.add(qName);
            cls = ArrayOfGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfLong");
            cachedSerQNames.add(qName);
            cls = ArrayOfLong.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfPreset");
            cachedSerQNames.add(qName);
            cls = ArrayOfPreset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfProjectDisplayData");
            cachedSerQNames.add(qName);
            cls = ArrayOfProjectDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfProjectScannedDisplayData");
            cachedSerQNames.add(qName);
            cls = ArrayOfProjectScannedDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanAction");
            cachedSerQNames.add(qName);
            cls = ArrayOfScanAction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanDisplayData");
            cachedSerQNames.add(qName);
            cls = ArrayOfScanDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfScanPath");
            cachedSerQNames.add(qName);
            cls = ArrayOfScanPath.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = ArrayOfString.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfUserData");
            cachedSerQNames.add(qName);
            cls = ArrayOfUserData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CliScanArgs");
            cachedSerQNames.add(qName);
            cls = CliScanArgs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ConfigurationSet");
            cachedSerQNames.add(qName);
            cls = ConfigurationSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials");
            cachedSerQNames.add(qName);
            cls = Credentials.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CurrentStatusEnum");
            cachedSerQNames.add(qName);
            cls = CurrentStatusEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxClientType");
            cachedSerQNames.add(qName);
            cls = CxClientType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDataRetentionConfiguration");
            cachedSerQNames.add(qName);
            cls = CxDataRetentionConfiguration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDataRetentionType");
            cachedSerQNames.add(qName);
            cls = CxDataRetentionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime");
            cachedSerQNames.add(qName);
            cls = CxDateTime.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSBasicRepsonse");
            cachedSerQNames.add(qName);
            cls = CxWSBasicRepsonse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSCreateReportResponse");
            cachedSerQNames.add(qName);
            cls = CxWSCreateReportResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSCrudEnum");
            cachedSerQNames.add(qName);
            cls = CxWSCrudEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSEnableCRUDAction");
            cachedSerQNames.add(qName);
            cls = CxWSEnableCRUDAction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSIssueTrackingParam");
            cachedSerQNames.add(qName);
            cls = CxWSIssueTrackingParam.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSItemAndCRUD");
            cachedSerQNames.add(qName);
            cls = CxWSItemAndCRUD.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSItemTypeEnum");
            cachedSerQNames.add(qName);
            cls = CxWSItemTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSLdapGroup");
            cachedSerQNames.add(qName);
            cls = CxWSLdapGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSLdapGroupMapping");
            cachedSerQNames.add(qName);
            cls = CxWSLdapGroupMapping.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSPerforceBrowsingMode");
            cachedSerQNames.add(qName);
            cls = CxWSPerforceBrowsingMode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSProjectCustomField");
            cachedSerQNames.add(qName);
            cls = CxWSProjectCustomField.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSProjectIssueTrackingSettings");
            cachedSerQNames.add(qName);
            cls = CxWSProjectIssueTrackingSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSQueryLanguageState");
            cachedSerQNames.add(qName);
            cls = CxWSQueryLanguageState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSReportRequest");
            cachedSerQNames.add(qName);
            cls = CxWSReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSReportStatusResponse");
            cachedSerQNames.add(qName);
            cls = CxWSReportStatusResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSReportType");
            cachedSerQNames.add(qName);
            cls = CxWSReportType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseConfigSetList");
            cachedSerQNames.add(qName);
            cls = CxWSResponseConfigSetList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseGroupList");
            cachedSerQNames.add(qName);
            cls = CxWSResponseGroupList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseLoginData");
            cachedSerQNames.add(qName);
            cls = CxWSResponseLoginData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponsePresetList");
            cachedSerQNames.add(qName);
            cls = CxWSResponsePresetList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectConfig");
            cachedSerQNames.add(qName);
            cls = CxWSResponseProjectConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectScannedDisplayData");
            cachedSerQNames.add(qName);
            cls = CxWSResponseProjectScannedDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseProjectsDisplayData");
            cachedSerQNames.add(qName);
            cls = CxWSResponseProjectsDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseRunID");
            cachedSerQNames.add(qName);
            cls = CxWSResponseRunID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanResults");
            cachedSerQNames.add(qName);
            cls = CxWSResponseScanResults.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScansDisplayData");
            cachedSerQNames.add(qName);
            cls = CxWSResponseScansDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanStatus");
            cachedSerQNames.add(qName);
            cls = CxWSResponseScanStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanSummary");
            cachedSerQNames.add(qName);
            cls = CxWSResponseScanSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseSessionID");
            cachedSerQNames.add(qName);
            cls = CxWSResponseSessionID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseTeamLdapGroupMappingData");
            cachedSerQNames.add(qName);
            cls = CxWSResponseTeamLdapGroupMappingData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseUserData");
            cachedSerQNames.add(qName);
            cls = CxWSResponseUserData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSRoleWithUserPrivileges");
            cachedSerQNames.add(qName);
            cls = CxWSRoleWithUserPrivileges.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DataRetentionSettings");
            cachedSerQNames.add(qName);
            cls = DataRetentionSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DayOfWeek");
            cachedSerQNames.add(qName);
            cls = DayOfWeek.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GitHubIntegrationSettings");
            cachedSerQNames.add(qName);
            cls = GitHubIntegrationSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GitLsRemoteViewType");
            cachedSerQNames.add(qName);
            cls = GitLsRemoteViewType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Group");
            cachedSerQNames.add(qName);
            cls = Group.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GroupType");
            cachedSerQNames.add(qName);
            cls = GroupType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LocalCodeContainer");
            cachedSerQNames.add(qName);
            cls = LocalCodeContainer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Preset");
            cachedSerQNames.add(qName);
            cls = Preset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectConfiguration");
            cachedSerQNames.add(qName);
            cls = ProjectConfiguration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectDisplayData");
            cachedSerQNames.add(qName);
            cls = ProjectDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectOrigin");
            cachedSerQNames.add(qName);
            cls = ProjectOrigin.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectScannedDisplayData");
            cachedSerQNames.add(qName);
            cls = ProjectScannedDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSettings");
            cachedSerQNames.add(qName);
            cls = ProjectSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectSharedLocation");
            cachedSerQNames.add(qName);
            cls = ProjectSharedLocation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RepositoryType");
            cachedSerQNames.add(qName);
            cls = RepositoryType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Role");
            cachedSerQNames.add(qName);
            cls = Role.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanAction");
            cachedSerQNames.add(qName);
            cls = ScanAction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanActionSettings");
            cachedSerQNames.add(qName);
            cls = ScanActionSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanActionType");
            cachedSerQNames.add(qName);
            cls = ScanActionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanDisplayData");
            cachedSerQNames.add(qName);
            cls = ScanDisplayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanEventType");
            cachedSerQNames.add(qName);
            cls = ScanEventType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanPath");
            cachedSerQNames.add(qName);
            cls = ScanPath.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanType");
            cachedSerQNames.add(qName);
            cls = ScanType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScheduleSettings");
            cachedSerQNames.add(qName);
            cls = ScheduleSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScheduleType");
            cachedSerQNames.add(qName);
            cls = ScheduleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceCodeSettings");
            cachedSerQNames.add(qName);
            cls = SourceCodeSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceControlProtocolType");
            cachedSerQNames.add(qName);
            cls = SourceControlProtocolType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceControlSettings");
            cachedSerQNames.add(qName);
            cls = SourceControlSettings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceFilterPatterns");
            cachedSerQNames.add(qName);
            cls = SourceFilterPatterns.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceLocationType");
            cachedSerQNames.add(qName);
            cls = SourceLocationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserData");
            cachedSerQNames.add(qName);
            cls = UserData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserPermission");
            cachedSerQNames.add(qName);
            cls = UserPermission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://Checkmarx.com/v7", "WebClientUser");
            cachedSerQNames.add(qName);
            cls = WebClientUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public CxWSResponseRunID scan(String sessionId, CliScanArgs args) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/Scan");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Scan"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionId, args});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseRunID) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseRunID) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseRunID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseRunID branchProjectById(String sessionId, long originProjectId, String newBranchProjectName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/BranchProjectById");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "BranchProjectById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionId, new Long(originProjectId), newBranchProjectName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseRunID) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseRunID) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseRunID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseRunID scanWithOriginName(String sessionId, CliScanArgs args, String origName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/ScanWithOriginName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithOriginName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionId, args, origName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseRunID) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseRunID) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseRunID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse cancelScan(String sessionID, String runId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/CancelScan");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CancelScan"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, runId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse deleteProjects(String sessionID, ArrayOfLong projectIDs) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/DeleteProjects");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DeleteProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, projectIDs});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse deleteScans(String sessionID, ArrayOfLong scanIDs) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/DeleteScans");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DeleteScans"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, scanIDs});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseRunID scanWithScheduling(String sessionId, CliScanArgs args, String schedulingData) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/ScanWithScheduling");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithScheduling"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionId, args, schedulingData});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseRunID) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseRunID) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseRunID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseRunID scanWithSchedulingWithCron(String sessionId, CliScanArgs args, String cronString, long utcEpochStartTime, long utcEpochEndTime) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/ScanWithSchedulingWithCron");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanWithSchedulingWithCron"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionId, args, cronString, new Long(utcEpochStartTime), new Long(utcEpochEndTime)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseRunID) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseRunID) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseRunID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse updateScanComment(String sessionID, long scanID, String comment) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/UpdateScanComment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UpdateScanComment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Long(scanID), comment});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponsePresetList getPresetList(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetPresetList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetPresetList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponsePresetList) _resp;
            } catch (Exception _exception) {
                return (CxWSResponsePresetList) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponsePresetList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseConfigSetList getConfigurationSetList(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetConfigurationSetList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetConfigurationSetList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseConfigSetList) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseConfigSetList) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseConfigSetList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseProjectsDisplayData getProjectsDisplayData(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetProjectsDisplayData");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetProjectsDisplayData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseProjectsDisplayData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseProjectsDisplayData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseProjectsDisplayData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseProjectScannedDisplayData getProjectScannedDisplayData(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetProjectScannedDisplayData");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetProjectScannedDisplayData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseProjectScannedDisplayData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseProjectScannedDisplayData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseProjectScannedDisplayData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseProjectConfig getProjectConfiguration(String sessionID, long projectID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetProjectConfiguration");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetProjectConfiguration"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Long(projectID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseProjectConfig) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseProjectConfig) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseProjectConfig.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse updateProjectIncrementalConfiguration(String sessionID, long projectID, ProjectConfiguration projectConfiguration) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/UpdateProjectIncrementalConfiguration");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UpdateProjectIncrementalConfiguration"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Long(projectID), projectConfiguration});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseLoginData login(Credentials applicationCredentials, int lcid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/Login");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Login"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {applicationCredentials, new Integer(lcid)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseLoginData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseLoginData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseLoginData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseLoginData ssoLogin(Credentials encryptedCredentials, int lcid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/SsoLogin");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SsoLogin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {encryptedCredentials, new Integer(lcid)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseLoginData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseLoginData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseLoginData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseLoginData loginWithToken(String token, int lcid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/LoginWithToken");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LoginWithToken"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {token, new Integer(lcid)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseLoginData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseLoginData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseLoginData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse logout(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/Logout");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Logout"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseGroupList getAssociatedGroupsList(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetAssociatedGroupsList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetAssociatedGroupsList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseGroupList) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseGroupList) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseGroupList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseScanStatus getStatusOfSingleScan(String sessionID, String runId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetStatusOfSingleScan");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetStatusOfSingleScan"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, runId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseScanStatus) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseScanStatus) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseScanStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseScansDisplayData getScansDisplayDataForAllProjects(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetScansDisplayDataForAllProjects");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScansDisplayDataForAllProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseScansDisplayData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseScansDisplayData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseScansDisplayData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseScanSummary getScanSummary(String sessionID, long scanID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetScanSummary");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanSummary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Long(scanID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseScanSummary) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseScanSummary) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseScanSummary.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse updateProjectConfiguration(String sessionID, long projectID, ProjectConfiguration projectConfiguration) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/UpdateProjectConfiguration");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UpdateProjectConfiguration"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Long(projectID), projectConfiguration});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse deleteUser(String sessionID, int userID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/DeleteUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DeleteUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Integer(userID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseUserData getAllUsers(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetAllUsers");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetAllUsers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseUserData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseUserData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseUserData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSCreateReportResponse createScanReport(String sessionID, CxWSReportRequest reportRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/CreateScanReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CreateScanReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, reportRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSCreateReportResponse) _resp;
            } catch (Exception _exception) {
                return (CxWSCreateReportResponse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSCreateReportResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSReportStatusResponse getScanReportStatus(String sessionID, long reportID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetScanReportStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanReportStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Long(reportID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSReportStatusResponse) _resp;
            } catch (Exception _exception) {
                return (CxWSReportStatusResponse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSReportStatusResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseScanResults getScanReport(String sessionID, long reportID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetScanReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetScanReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, new Long(reportID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseScanResults) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseScanResults) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseScanResults.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse executeDataRetention(String sessionID, CxDataRetentionConfiguration dataRetentionConfiguration) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/ExecuteDataRetention");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ExecuteDataRetention"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, dataRetentionConfiguration});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse stopDataRetention(String sessionID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/StopDataRetention");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StopDataRetention"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSResponseTeamLdapGroupMappingData getTeamLdapGroupsMapping(String sessionId, String teamId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/GetTeamLdapGroupsMapping");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GetTeamLdapGroupsMapping"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionId, teamId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSResponseTeamLdapGroupMappingData) _resp;
            } catch (Exception _exception) {
                return (CxWSResponseTeamLdapGroupMappingData) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSResponseTeamLdapGroupMappingData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse setTeamLdapGroupsMapping(String sessionId, String teamId, ArrayOfCxWSLdapGroupMapping ldapGroups) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/SetTeamLdapGroupsMapping");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SetTeamLdapGroupsMapping"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionId, teamId, ldapGroups});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public CxWSBasicRepsonse isValidProjectName(String sessionID, String projectName, String groupId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://Checkmarx.com/v7/IsValidProjectName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsValidProjectName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sessionID, projectName, groupId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CxWSBasicRepsonse) _resp;
            } catch (Exception _exception) {
                return (CxWSBasicRepsonse) org.apache.axis.utils.JavaUtils.convert(_resp, CxWSBasicRepsonse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
