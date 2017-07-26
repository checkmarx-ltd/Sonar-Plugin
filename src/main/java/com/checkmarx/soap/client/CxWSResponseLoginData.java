/**
 * CxWSResponseLoginData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseLoginData  extends CxWSResponseSessionID  implements java.io.Serializable {
    private String familyName;

    private String firstName;

    private String userName;

    private String email;

    private long userID;

    private int userPreferedLanguageLCID;

    private boolean isAllowedToCreateProject;

    private boolean isAllowedToChangeProject;

    private boolean isAllowedToManageUsers;

    private boolean isAllowedToViewCompanies;

    private boolean isAllowedToManageCompanies;

    private boolean isAllowedToManageServer;

    private boolean isAllowedToViewInstallationData;

    private boolean isAllowedToViewSp;

    private boolean isAllowedToManageSp;

    private boolean isScanner;

    private boolean isAuditor;

    private boolean isAllowedToManagePresets;

    private boolean isAllowedToManagePredefinedCommand;

    private boolean isAllowedToManagePostScanAction;

    private boolean isAllowedToModifyResultDetails;

    private boolean enableIncrementalScan;

    private boolean showSaaSPackageNotificationAndErrors;

    private boolean showSaaSPackageDetails;

    private boolean isAdviseChangePassword;

    private boolean isAllowedToManageITSServers;

    private boolean allowedToChangeNotExploitable;

    private boolean isAllowedToDeleteScans;

    public CxWSResponseLoginData() {
    }

    public CxWSResponseLoginData(
           boolean isSuccesfull,
           String errorMessage,
           String sessionId,
           String familyName,
           String firstName,
           String userName,
           String email,
           long userID,
           int userPreferedLanguageLCID,
           boolean isAllowedToCreateProject,
           boolean isAllowedToChangeProject,
           boolean isAllowedToManageUsers,
           boolean isAllowedToViewCompanies,
           boolean isAllowedToManageCompanies,
           boolean isAllowedToManageServer,
           boolean isAllowedToViewInstallationData,
           boolean isAllowedToViewSp,
           boolean isAllowedToManageSp,
           boolean isScanner,
           boolean isAuditor,
           boolean isAllowedToManagePresets,
           boolean isAllowedToManagePredefinedCommand,
           boolean isAllowedToManagePostScanAction,
           boolean isAllowedToModifyResultDetails,
           boolean enableIncrementalScan,
           boolean showSaaSPackageNotificationAndErrors,
           boolean showSaaSPackageDetails,
           boolean isAdviseChangePassword,
           boolean isAllowedToManageITSServers,
           boolean allowedToChangeNotExploitable,
           boolean isAllowedToDeleteScans) {
        super(
            isSuccesfull,
            errorMessage,
            sessionId);
        this.familyName = familyName;
        this.firstName = firstName;
        this.userName = userName;
        this.email = email;
        this.userID = userID;
        this.userPreferedLanguageLCID = userPreferedLanguageLCID;
        this.isAllowedToCreateProject = isAllowedToCreateProject;
        this.isAllowedToChangeProject = isAllowedToChangeProject;
        this.isAllowedToManageUsers = isAllowedToManageUsers;
        this.isAllowedToViewCompanies = isAllowedToViewCompanies;
        this.isAllowedToManageCompanies = isAllowedToManageCompanies;
        this.isAllowedToManageServer = isAllowedToManageServer;
        this.isAllowedToViewInstallationData = isAllowedToViewInstallationData;
        this.isAllowedToViewSp = isAllowedToViewSp;
        this.isAllowedToManageSp = isAllowedToManageSp;
        this.isScanner = isScanner;
        this.isAuditor = isAuditor;
        this.isAllowedToManagePresets = isAllowedToManagePresets;
        this.isAllowedToManagePredefinedCommand = isAllowedToManagePredefinedCommand;
        this.isAllowedToManagePostScanAction = isAllowedToManagePostScanAction;
        this.isAllowedToModifyResultDetails = isAllowedToModifyResultDetails;
        this.enableIncrementalScan = enableIncrementalScan;
        this.showSaaSPackageNotificationAndErrors = showSaaSPackageNotificationAndErrors;
        this.showSaaSPackageDetails = showSaaSPackageDetails;
        this.isAdviseChangePassword = isAdviseChangePassword;
        this.isAllowedToManageITSServers = isAllowedToManageITSServers;
        this.allowedToChangeNotExploitable = allowedToChangeNotExploitable;
        this.isAllowedToDeleteScans = isAllowedToDeleteScans;
    }


    /**
     * Gets the familyName value for this CxWSResponseLoginData.
     *
     * @return familyName
     */
    public String getFamilyName() {
        return familyName;
    }


    /**
     * Sets the familyName value for this CxWSResponseLoginData.
     *
     * @param familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }


    /**
     * Gets the firstName value for this CxWSResponseLoginData.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this CxWSResponseLoginData.
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the userName value for this CxWSResponseLoginData.
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this CxWSResponseLoginData.
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * Gets the email value for this CxWSResponseLoginData.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this CxWSResponseLoginData.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the userID value for this CxWSResponseLoginData.
     *
     * @return userID
     */
    public long getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this CxWSResponseLoginData.
     *
     * @param userID
     */
    public void setUserID(long userID) {
        this.userID = userID;
    }


    /**
     * Gets the userPreferedLanguageLCID value for this CxWSResponseLoginData.
     *
     * @return userPreferedLanguageLCID
     */
    public int getUserPreferedLanguageLCID() {
        return userPreferedLanguageLCID;
    }


    /**
     * Sets the userPreferedLanguageLCID value for this CxWSResponseLoginData.
     *
     * @param userPreferedLanguageLCID
     */
    public void setUserPreferedLanguageLCID(int userPreferedLanguageLCID) {
        this.userPreferedLanguageLCID = userPreferedLanguageLCID;
    }


    /**
     * Gets the isAllowedToCreateProject value for this CxWSResponseLoginData.
     *
     * @return isAllowedToCreateProject
     */
    public boolean isIsAllowedToCreateProject() {
        return isAllowedToCreateProject;
    }


    /**
     * Sets the isAllowedToCreateProject value for this CxWSResponseLoginData.
     *
     * @param isAllowedToCreateProject
     */
    public void setIsAllowedToCreateProject(boolean isAllowedToCreateProject) {
        this.isAllowedToCreateProject = isAllowedToCreateProject;
    }


    /**
     * Gets the isAllowedToChangeProject value for this CxWSResponseLoginData.
     *
     * @return isAllowedToChangeProject
     */
    public boolean isIsAllowedToChangeProject() {
        return isAllowedToChangeProject;
    }


    /**
     * Sets the isAllowedToChangeProject value for this CxWSResponseLoginData.
     *
     * @param isAllowedToChangeProject
     */
    public void setIsAllowedToChangeProject(boolean isAllowedToChangeProject) {
        this.isAllowedToChangeProject = isAllowedToChangeProject;
    }


    /**
     * Gets the isAllowedToManageUsers value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManageUsers
     */
    public boolean isIsAllowedToManageUsers() {
        return isAllowedToManageUsers;
    }


    /**
     * Sets the isAllowedToManageUsers value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManageUsers
     */
    public void setIsAllowedToManageUsers(boolean isAllowedToManageUsers) {
        this.isAllowedToManageUsers = isAllowedToManageUsers;
    }


    /**
     * Gets the isAllowedToViewCompanies value for this CxWSResponseLoginData.
     *
     * @return isAllowedToViewCompanies
     */
    public boolean isIsAllowedToViewCompanies() {
        return isAllowedToViewCompanies;
    }


    /**
     * Sets the isAllowedToViewCompanies value for this CxWSResponseLoginData.
     *
     * @param isAllowedToViewCompanies
     */
    public void setIsAllowedToViewCompanies(boolean isAllowedToViewCompanies) {
        this.isAllowedToViewCompanies = isAllowedToViewCompanies;
    }


    /**
     * Gets the isAllowedToManageCompanies value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManageCompanies
     */
    public boolean isIsAllowedToManageCompanies() {
        return isAllowedToManageCompanies;
    }


    /**
     * Sets the isAllowedToManageCompanies value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManageCompanies
     */
    public void setIsAllowedToManageCompanies(boolean isAllowedToManageCompanies) {
        this.isAllowedToManageCompanies = isAllowedToManageCompanies;
    }


    /**
     * Gets the isAllowedToManageServer value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManageServer
     */
    public boolean isIsAllowedToManageServer() {
        return isAllowedToManageServer;
    }


    /**
     * Sets the isAllowedToManageServer value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManageServer
     */
    public void setIsAllowedToManageServer(boolean isAllowedToManageServer) {
        this.isAllowedToManageServer = isAllowedToManageServer;
    }


    /**
     * Gets the isAllowedToViewInstallationData value for this CxWSResponseLoginData.
     *
     * @return isAllowedToViewInstallationData
     */
    public boolean isIsAllowedToViewInstallationData() {
        return isAllowedToViewInstallationData;
    }


    /**
     * Sets the isAllowedToViewInstallationData value for this CxWSResponseLoginData.
     *
     * @param isAllowedToViewInstallationData
     */
    public void setIsAllowedToViewInstallationData(boolean isAllowedToViewInstallationData) {
        this.isAllowedToViewInstallationData = isAllowedToViewInstallationData;
    }


    /**
     * Gets the isAllowedToViewSp value for this CxWSResponseLoginData.
     *
     * @return isAllowedToViewSp
     */
    public boolean isIsAllowedToViewSp() {
        return isAllowedToViewSp;
    }


    /**
     * Sets the isAllowedToViewSp value for this CxWSResponseLoginData.
     *
     * @param isAllowedToViewSp
     */
    public void setIsAllowedToViewSp(boolean isAllowedToViewSp) {
        this.isAllowedToViewSp = isAllowedToViewSp;
    }


    /**
     * Gets the isAllowedToManageSp value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManageSp
     */
    public boolean isIsAllowedToManageSp() {
        return isAllowedToManageSp;
    }


    /**
     * Sets the isAllowedToManageSp value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManageSp
     */
    public void setIsAllowedToManageSp(boolean isAllowedToManageSp) {
        this.isAllowedToManageSp = isAllowedToManageSp;
    }


    /**
     * Gets the isScanner value for this CxWSResponseLoginData.
     *
     * @return isScanner
     */
    public boolean isIsScanner() {
        return isScanner;
    }


    /**
     * Sets the isScanner value for this CxWSResponseLoginData.
     *
     * @param isScanner
     */
    public void setIsScanner(boolean isScanner) {
        this.isScanner = isScanner;
    }


    /**
     * Gets the isAuditor value for this CxWSResponseLoginData.
     *
     * @return isAuditor
     */
    public boolean isIsAuditor() {
        return isAuditor;
    }


    /**
     * Sets the isAuditor value for this CxWSResponseLoginData.
     *
     * @param isAuditor
     */
    public void setIsAuditor(boolean isAuditor) {
        this.isAuditor = isAuditor;
    }


    /**
     * Gets the isAllowedToManagePresets value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManagePresets
     */
    public boolean isIsAllowedToManagePresets() {
        return isAllowedToManagePresets;
    }


    /**
     * Sets the isAllowedToManagePresets value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManagePresets
     */
    public void setIsAllowedToManagePresets(boolean isAllowedToManagePresets) {
        this.isAllowedToManagePresets = isAllowedToManagePresets;
    }


    /**
     * Gets the isAllowedToManagePredefinedCommand value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManagePredefinedCommand
     */
    public boolean isIsAllowedToManagePredefinedCommand() {
        return isAllowedToManagePredefinedCommand;
    }


    /**
     * Sets the isAllowedToManagePredefinedCommand value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManagePredefinedCommand
     */
    public void setIsAllowedToManagePredefinedCommand(boolean isAllowedToManagePredefinedCommand) {
        this.isAllowedToManagePredefinedCommand = isAllowedToManagePredefinedCommand;
    }


    /**
     * Gets the isAllowedToManagePostScanAction value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManagePostScanAction
     */
    public boolean isIsAllowedToManagePostScanAction() {
        return isAllowedToManagePostScanAction;
    }


    /**
     * Sets the isAllowedToManagePostScanAction value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManagePostScanAction
     */
    public void setIsAllowedToManagePostScanAction(boolean isAllowedToManagePostScanAction) {
        this.isAllowedToManagePostScanAction = isAllowedToManagePostScanAction;
    }


    /**
     * Gets the isAllowedToModifyResultDetails value for this CxWSResponseLoginData.
     *
     * @return isAllowedToModifyResultDetails
     */
    public boolean isIsAllowedToModifyResultDetails() {
        return isAllowedToModifyResultDetails;
    }


    /**
     * Sets the isAllowedToModifyResultDetails value for this CxWSResponseLoginData.
     *
     * @param isAllowedToModifyResultDetails
     */
    public void setIsAllowedToModifyResultDetails(boolean isAllowedToModifyResultDetails) {
        this.isAllowedToModifyResultDetails = isAllowedToModifyResultDetails;
    }


    /**
     * Gets the enableIncrementalScan value for this CxWSResponseLoginData.
     *
     * @return enableIncrementalScan
     */
    public boolean isEnableIncrementalScan() {
        return enableIncrementalScan;
    }


    /**
     * Sets the enableIncrementalScan value for this CxWSResponseLoginData.
     *
     * @param enableIncrementalScan
     */
    public void setEnableIncrementalScan(boolean enableIncrementalScan) {
        this.enableIncrementalScan = enableIncrementalScan;
    }


    /**
     * Gets the showSaaSPackageNotificationAndErrors value for this CxWSResponseLoginData.
     *
     * @return showSaaSPackageNotificationAndErrors
     */
    public boolean isShowSaaSPackageNotificationAndErrors() {
        return showSaaSPackageNotificationAndErrors;
    }


    /**
     * Sets the showSaaSPackageNotificationAndErrors value for this CxWSResponseLoginData.
     *
     * @param showSaaSPackageNotificationAndErrors
     */
    public void setShowSaaSPackageNotificationAndErrors(boolean showSaaSPackageNotificationAndErrors) {
        this.showSaaSPackageNotificationAndErrors = showSaaSPackageNotificationAndErrors;
    }


    /**
     * Gets the showSaaSPackageDetails value for this CxWSResponseLoginData.
     *
     * @return showSaaSPackageDetails
     */
    public boolean isShowSaaSPackageDetails() {
        return showSaaSPackageDetails;
    }


    /**
     * Sets the showSaaSPackageDetails value for this CxWSResponseLoginData.
     *
     * @param showSaaSPackageDetails
     */
    public void setShowSaaSPackageDetails(boolean showSaaSPackageDetails) {
        this.showSaaSPackageDetails = showSaaSPackageDetails;
    }


    /**
     * Gets the isAdviseChangePassword value for this CxWSResponseLoginData.
     *
     * @return isAdviseChangePassword
     */
    public boolean isIsAdviseChangePassword() {
        return isAdviseChangePassword;
    }


    /**
     * Sets the isAdviseChangePassword value for this CxWSResponseLoginData.
     *
     * @param isAdviseChangePassword
     */
    public void setIsAdviseChangePassword(boolean isAdviseChangePassword) {
        this.isAdviseChangePassword = isAdviseChangePassword;
    }


    /**
     * Gets the isAllowedToManageITSServers value for this CxWSResponseLoginData.
     *
     * @return isAllowedToManageITSServers
     */
    public boolean isIsAllowedToManageITSServers() {
        return isAllowedToManageITSServers;
    }


    /**
     * Sets the isAllowedToManageITSServers value for this CxWSResponseLoginData.
     *
     * @param isAllowedToManageITSServers
     */
    public void setIsAllowedToManageITSServers(boolean isAllowedToManageITSServers) {
        this.isAllowedToManageITSServers = isAllowedToManageITSServers;
    }


    /**
     * Gets the allowedToChangeNotExploitable value for this CxWSResponseLoginData.
     *
     * @return allowedToChangeNotExploitable
     */
    public boolean isAllowedToChangeNotExploitable() {
        return allowedToChangeNotExploitable;
    }


    /**
     * Sets the allowedToChangeNotExploitable value for this CxWSResponseLoginData.
     *
     * @param allowedToChangeNotExploitable
     */
    public void setAllowedToChangeNotExploitable(boolean allowedToChangeNotExploitable) {
        this.allowedToChangeNotExploitable = allowedToChangeNotExploitable;
    }


    /**
     * Gets the isAllowedToDeleteScans value for this CxWSResponseLoginData.
     *
     * @return isAllowedToDeleteScans
     */
    public boolean isIsAllowedToDeleteScans() {
        return isAllowedToDeleteScans;
    }


    /**
     * Sets the isAllowedToDeleteScans value for this CxWSResponseLoginData.
     *
     * @param isAllowedToDeleteScans
     */
    public void setIsAllowedToDeleteScans(boolean isAllowedToDeleteScans) {
        this.isAllowedToDeleteScans = isAllowedToDeleteScans;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseLoginData)) return false;
        CxWSResponseLoginData other = (CxWSResponseLoginData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            ((this.familyName==null && other.getFamilyName()==null) ||
             (this.familyName!=null &&
              this.familyName.equals(other.getFamilyName()))) &&
            ((this.firstName==null && other.getFirstName()==null) ||
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.userName==null && other.getUserName()==null) ||
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.email==null && other.getEmail()==null) ||
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.userID == other.getUserID() &&
            this.userPreferedLanguageLCID == other.getUserPreferedLanguageLCID() &&
            this.isAllowedToCreateProject == other.isIsAllowedToCreateProject() &&
            this.isAllowedToChangeProject == other.isIsAllowedToChangeProject() &&
            this.isAllowedToManageUsers == other.isIsAllowedToManageUsers() &&
            this.isAllowedToViewCompanies == other.isIsAllowedToViewCompanies() &&
            this.isAllowedToManageCompanies == other.isIsAllowedToManageCompanies() &&
            this.isAllowedToManageServer == other.isIsAllowedToManageServer() &&
            this.isAllowedToViewInstallationData == other.isIsAllowedToViewInstallationData() &&
            this.isAllowedToViewSp == other.isIsAllowedToViewSp() &&
            this.isAllowedToManageSp == other.isIsAllowedToManageSp() &&
            this.isScanner == other.isIsScanner() &&
            this.isAuditor == other.isIsAuditor() &&
            this.isAllowedToManagePresets == other.isIsAllowedToManagePresets() &&
            this.isAllowedToManagePredefinedCommand == other.isIsAllowedToManagePredefinedCommand() &&
            this.isAllowedToManagePostScanAction == other.isIsAllowedToManagePostScanAction() &&
            this.isAllowedToModifyResultDetails == other.isIsAllowedToModifyResultDetails() &&
            this.enableIncrementalScan == other.isEnableIncrementalScan() &&
            this.showSaaSPackageNotificationAndErrors == other.isShowSaaSPackageNotificationAndErrors() &&
            this.showSaaSPackageDetails == other.isShowSaaSPackageDetails() &&
            this.isAdviseChangePassword == other.isIsAdviseChangePassword() &&
            this.isAllowedToManageITSServers == other.isIsAllowedToManageITSServers() &&
            this.allowedToChangeNotExploitable == other.isAllowedToChangeNotExploitable() &&
            this.isAllowedToDeleteScans == other.isIsAllowedToDeleteScans();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getFamilyName() != null) {
            _hashCode += getFamilyName().hashCode();
        }
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += new Long(getUserID()).hashCode();
        _hashCode += getUserPreferedLanguageLCID();
        _hashCode += (isIsAllowedToCreateProject() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToChangeProject() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManageUsers() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToViewCompanies() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManageCompanies() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManageServer() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToViewInstallationData() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToViewSp() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManageSp() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsScanner() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAuditor() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManagePresets() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManagePredefinedCommand() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManagePostScanAction() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToModifyResultDetails() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isEnableIncrementalScan() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowSaaSPackageNotificationAndErrors() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isShowSaaSPackageDetails() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAdviseChangePassword() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToManageITSServers() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAllowedToChangeNotExploitable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAllowedToDeleteScans() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseLoginData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseLoginData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "FamilyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "FirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userPreferedLanguageLCID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserPreferedLanguageLCID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToCreateProject");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToCreateProject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToChangeProject");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToChangeProject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManageUsers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToManageUsers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToViewCompanies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToViewCompanies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManageCompanies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToManageCompanies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManageServer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToManageServer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToViewInstallationData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToViewInstallationData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToViewSp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToViewSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManageSp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToManageSp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isScanner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsScanner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAuditor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAuditor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManagePresets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToManagePresets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManagePredefinedCommand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "isAllowedToManagePredefinedCommand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManagePostScanAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToManagePostScanAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToModifyResultDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToModifyResultDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableIncrementalScan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "EnableIncrementalScan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showSaaSPackageNotificationAndErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ShowSaaSPackageNotificationAndErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showSaaSPackageDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ShowSaaSPackageDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAdviseChangePassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAdviseChangePassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToManageITSServers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToManageITSServers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowedToChangeNotExploitable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "AllowedToChangeNotExploitable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAllowedToDeleteScans");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsAllowedToDeleteScans"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
