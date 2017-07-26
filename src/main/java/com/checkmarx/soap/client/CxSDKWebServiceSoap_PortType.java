/**
 * CxSDKWebServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public interface CxSDKWebServiceSoap_PortType extends java.rmi.Remote {
    public CxWSResponseRunID scan(String sessionId, CliScanArgs args) throws java.rmi.RemoteException;
    public CxWSResponseRunID branchProjectById(String sessionId, long originProjectId, String newBranchProjectName) throws java.rmi.RemoteException;
    public CxWSResponseRunID scanWithOriginName(String sessionId, CliScanArgs args, String origName) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse cancelScan(String sessionID, String runId) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse deleteProjects(String sessionID, ArrayOfLong projectIDs) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse deleteScans(String sessionID, ArrayOfLong scanIDs) throws java.rmi.RemoteException;
    public CxWSResponseRunID scanWithScheduling(String sessionId, CliScanArgs args, String schedulingData) throws java.rmi.RemoteException;
    public CxWSResponseRunID scanWithSchedulingWithCron(String sessionId, CliScanArgs args, String cronString, long utcEpochStartTime, long utcEpochEndTime) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse updateScanComment(String sessionID, long scanID, String comment) throws java.rmi.RemoteException;
    public CxWSResponsePresetList getPresetList(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseConfigSetList getConfigurationSetList(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseProjectsDisplayData getProjectsDisplayData(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseProjectScannedDisplayData getProjectScannedDisplayData(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseProjectConfig getProjectConfiguration(String sessionID, long projectID) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse updateProjectIncrementalConfiguration(String sessionID, long projectID, ProjectConfiguration projectConfiguration) throws java.rmi.RemoteException;
    public CxWSResponseLoginData login(Credentials applicationCredentials, int lcid) throws java.rmi.RemoteException;
    public CxWSResponseLoginData ssoLogin(Credentials encryptedCredentials, int lcid) throws java.rmi.RemoteException;
    public CxWSResponseLoginData loginWithToken(String token, int lcid) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse logout(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseGroupList getAssociatedGroupsList(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseScanStatus getStatusOfSingleScan(String sessionID, String runId) throws java.rmi.RemoteException;
    public CxWSResponseScansDisplayData getScansDisplayDataForAllProjects(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseScanSummary getScanSummary(String sessionID, long scanID) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse updateProjectConfiguration(String sessionID, long projectID, ProjectConfiguration projectConfiguration) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse deleteUser(String sessionID, int userID) throws java.rmi.RemoteException;
    public CxWSResponseUserData getAllUsers(String sessionID) throws java.rmi.RemoteException;
    public CxWSCreateReportResponse createScanReport(String sessionID, CxWSReportRequest reportRequest) throws java.rmi.RemoteException;
    public CxWSReportStatusResponse getScanReportStatus(String sessionID, long reportID) throws java.rmi.RemoteException;
    public CxWSResponseScanResults getScanReport(String sessionID, long reportID) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse executeDataRetention(String sessionID, CxDataRetentionConfiguration dataRetentionConfiguration) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse stopDataRetention(String sessionID) throws java.rmi.RemoteException;
    public CxWSResponseTeamLdapGroupMappingData getTeamLdapGroupsMapping(String sessionId, String teamId) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse setTeamLdapGroupsMapping(String sessionId, String teamId, ArrayOfCxWSLdapGroupMapping ldapGroups) throws java.rmi.RemoteException;
    public CxWSBasicRepsonse isValidProjectName(String sessionID, String projectName, String groupId) throws java.rmi.RemoteException;
}
