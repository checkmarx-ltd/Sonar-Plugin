/**
 * SourceControlSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class SourceControlSettings  implements java.io.Serializable {
    private int port;

    private boolean useSSL;

    private boolean useSSH;

    private String serverName;

    private RepositoryType repository;

    private Credentials userCredentials;

    private SourceControlProtocolType protocol;

    private String repositoryName;

    private String protocolParameters;

    private String GITBranch;

    private GitLsRemoteViewType gitLsViewType;

    private String SSHPublicKey;

    private String SSHPrivateKey;

    private GitHubIntegrationSettings gitHubSettings;

    private CxWSPerforceBrowsingMode perforceBrowsingMode;

    public SourceControlSettings() {
    }

    public SourceControlSettings(
           int port,
           boolean useSSL,
           boolean useSSH,
           String serverName,
           RepositoryType repository,
           Credentials userCredentials,
           SourceControlProtocolType protocol,
           String repositoryName,
           String protocolParameters,
           String GITBranch,
           GitLsRemoteViewType gitLsViewType,
           String SSHPublicKey,
           String SSHPrivateKey,
           GitHubIntegrationSettings gitHubSettings,
           CxWSPerforceBrowsingMode perforceBrowsingMode) {
           this.port = port;
           this.useSSL = useSSL;
           this.useSSH = useSSH;
           this.serverName = serverName;
           this.repository = repository;
           this.userCredentials = userCredentials;
           this.protocol = protocol;
           this.repositoryName = repositoryName;
           this.protocolParameters = protocolParameters;
           this.GITBranch = GITBranch;
           this.gitLsViewType = gitLsViewType;
           this.SSHPublicKey = SSHPublicKey;
           this.SSHPrivateKey = SSHPrivateKey;
           this.gitHubSettings = gitHubSettings;
           this.perforceBrowsingMode = perforceBrowsingMode;
    }


    /**
     * Gets the port value for this SourceControlSettings.
     *
     * @return port
     */
    public int getPort() {
        return port;
    }


    /**
     * Sets the port value for this SourceControlSettings.
     *
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }


    /**
     * Gets the useSSL value for this SourceControlSettings.
     *
     * @return useSSL
     */
    public boolean isUseSSL() {
        return useSSL;
    }


    /**
     * Sets the useSSL value for this SourceControlSettings.
     *
     * @param useSSL
     */
    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }


    /**
     * Gets the useSSH value for this SourceControlSettings.
     *
     * @return useSSH
     */
    public boolean isUseSSH() {
        return useSSH;
    }


    /**
     * Sets the useSSH value for this SourceControlSettings.
     *
     * @param useSSH
     */
    public void setUseSSH(boolean useSSH) {
        this.useSSH = useSSH;
    }


    /**
     * Gets the serverName value for this SourceControlSettings.
     *
     * @return serverName
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the serverName value for this SourceControlSettings.
     *
     * @param serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Gets the repository value for this SourceControlSettings.
     *
     * @return repository
     */
    public RepositoryType getRepository() {
        return repository;
    }


    /**
     * Sets the repository value for this SourceControlSettings.
     *
     * @param repository
     */
    public void setRepository(RepositoryType repository) {
        this.repository = repository;
    }


    /**
     * Gets the userCredentials value for this SourceControlSettings.
     *
     * @return userCredentials
     */
    public Credentials getUserCredentials() {
        return userCredentials;
    }


    /**
     * Sets the userCredentials value for this SourceControlSettings.
     *
     * @param userCredentials
     */
    public void setUserCredentials(Credentials userCredentials) {
        this.userCredentials = userCredentials;
    }


    /**
     * Gets the protocol value for this SourceControlSettings.
     *
     * @return protocol
     */
    public SourceControlProtocolType getProtocol() {
        return protocol;
    }


    /**
     * Sets the protocol value for this SourceControlSettings.
     *
     * @param protocol
     */
    public void setProtocol(SourceControlProtocolType protocol) {
        this.protocol = protocol;
    }


    /**
     * Gets the repositoryName value for this SourceControlSettings.
     *
     * @return repositoryName
     */
    public String getRepositoryName() {
        return repositoryName;
    }


    /**
     * Sets the repositoryName value for this SourceControlSettings.
     *
     * @param repositoryName
     */
    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }


    /**
     * Gets the protocolParameters value for this SourceControlSettings.
     *
     * @return protocolParameters
     */
    public String getProtocolParameters() {
        return protocolParameters;
    }


    /**
     * Sets the protocolParameters value for this SourceControlSettings.
     *
     * @param protocolParameters
     */
    public void setProtocolParameters(String protocolParameters) {
        this.protocolParameters = protocolParameters;
    }


    /**
     * Gets the GITBranch value for this SourceControlSettings.
     *
     * @return GITBranch
     */
    public String getGITBranch() {
        return GITBranch;
    }


    /**
     * Sets the GITBranch value for this SourceControlSettings.
     *
     * @param GITBranch
     */
    public void setGITBranch(String GITBranch) {
        this.GITBranch = GITBranch;
    }


    /**
     * Gets the gitLsViewType value for this SourceControlSettings.
     *
     * @return gitLsViewType
     */
    public GitLsRemoteViewType getGitLsViewType() {
        return gitLsViewType;
    }


    /**
     * Sets the gitLsViewType value for this SourceControlSettings.
     *
     * @param gitLsViewType
     */
    public void setGitLsViewType(GitLsRemoteViewType gitLsViewType) {
        this.gitLsViewType = gitLsViewType;
    }


    /**
     * Gets the SSHPublicKey value for this SourceControlSettings.
     *
     * @return SSHPublicKey
     */
    public String getSSHPublicKey() {
        return SSHPublicKey;
    }


    /**
     * Sets the SSHPublicKey value for this SourceControlSettings.
     *
     * @param SSHPublicKey
     */
    public void setSSHPublicKey(String SSHPublicKey) {
        this.SSHPublicKey = SSHPublicKey;
    }


    /**
     * Gets the SSHPrivateKey value for this SourceControlSettings.
     *
     * @return SSHPrivateKey
     */
    public String getSSHPrivateKey() {
        return SSHPrivateKey;
    }


    /**
     * Sets the SSHPrivateKey value for this SourceControlSettings.
     *
     * @param SSHPrivateKey
     */
    public void setSSHPrivateKey(String SSHPrivateKey) {
        this.SSHPrivateKey = SSHPrivateKey;
    }


    /**
     * Gets the gitHubSettings value for this SourceControlSettings.
     *
     * @return gitHubSettings
     */
    public GitHubIntegrationSettings getGitHubSettings() {
        return gitHubSettings;
    }


    /**
     * Sets the gitHubSettings value for this SourceControlSettings.
     *
     * @param gitHubSettings
     */
    public void setGitHubSettings(GitHubIntegrationSettings gitHubSettings) {
        this.gitHubSettings = gitHubSettings;
    }


    /**
     * Gets the perforceBrowsingMode value for this SourceControlSettings.
     *
     * @return perforceBrowsingMode
     */
    public CxWSPerforceBrowsingMode getPerforceBrowsingMode() {
        return perforceBrowsingMode;
    }


    /**
     * Sets the perforceBrowsingMode value for this SourceControlSettings.
     *
     * @param perforceBrowsingMode
     */
    public void setPerforceBrowsingMode(CxWSPerforceBrowsingMode perforceBrowsingMode) {
        this.perforceBrowsingMode = perforceBrowsingMode;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SourceControlSettings)) return false;
        SourceControlSettings other = (SourceControlSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.port == other.getPort() &&
            this.useSSL == other.isUseSSL() &&
            this.useSSH == other.isUseSSH() &&
            ((this.serverName==null && other.getServerName()==null) ||
             (this.serverName!=null &&
              this.serverName.equals(other.getServerName()))) &&
            ((this.repository==null && other.getRepository()==null) ||
             (this.repository!=null &&
              this.repository.equals(other.getRepository()))) &&
            ((this.userCredentials==null && other.getUserCredentials()==null) ||
             (this.userCredentials!=null &&
              this.userCredentials.equals(other.getUserCredentials()))) &&
            ((this.protocol==null && other.getProtocol()==null) ||
             (this.protocol!=null &&
              this.protocol.equals(other.getProtocol()))) &&
            ((this.repositoryName==null && other.getRepositoryName()==null) ||
             (this.repositoryName!=null &&
              this.repositoryName.equals(other.getRepositoryName()))) &&
            ((this.protocolParameters==null && other.getProtocolParameters()==null) ||
             (this.protocolParameters!=null &&
              this.protocolParameters.equals(other.getProtocolParameters()))) &&
            ((this.GITBranch==null && other.getGITBranch()==null) ||
             (this.GITBranch!=null &&
              this.GITBranch.equals(other.getGITBranch()))) &&
            ((this.gitLsViewType==null && other.getGitLsViewType()==null) ||
             (this.gitLsViewType!=null &&
              this.gitLsViewType.equals(other.getGitLsViewType()))) &&
            ((this.SSHPublicKey==null && other.getSSHPublicKey()==null) ||
             (this.SSHPublicKey!=null &&
              this.SSHPublicKey.equals(other.getSSHPublicKey()))) &&
            ((this.SSHPrivateKey==null && other.getSSHPrivateKey()==null) ||
             (this.SSHPrivateKey!=null &&
              this.SSHPrivateKey.equals(other.getSSHPrivateKey()))) &&
            ((this.gitHubSettings==null && other.getGitHubSettings()==null) ||
             (this.gitHubSettings!=null &&
              this.gitHubSettings.equals(other.getGitHubSettings()))) &&
            ((this.perforceBrowsingMode==null && other.getPerforceBrowsingMode()==null) ||
             (this.perforceBrowsingMode!=null &&
              this.perforceBrowsingMode.equals(other.getPerforceBrowsingMode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getPort();
        _hashCode += (isUseSSL() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isUseSSH() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getServerName() != null) {
            _hashCode += getServerName().hashCode();
        }
        if (getRepository() != null) {
            _hashCode += getRepository().hashCode();
        }
        if (getUserCredentials() != null) {
            _hashCode += getUserCredentials().hashCode();
        }
        if (getProtocol() != null) {
            _hashCode += getProtocol().hashCode();
        }
        if (getRepositoryName() != null) {
            _hashCode += getRepositoryName().hashCode();
        }
        if (getProtocolParameters() != null) {
            _hashCode += getProtocolParameters().hashCode();
        }
        if (getGITBranch() != null) {
            _hashCode += getGITBranch().hashCode();
        }
        if (getGitLsViewType() != null) {
            _hashCode += getGitLsViewType().hashCode();
        }
        if (getSSHPublicKey() != null) {
            _hashCode += getSSHPublicKey().hashCode();
        }
        if (getSSHPrivateKey() != null) {
            _hashCode += getSSHPrivateKey().hashCode();
        }
        if (getGitHubSettings() != null) {
            _hashCode += getGitHubSettings().hashCode();
        }
        if (getPerforceBrowsingMode() != null) {
            _hashCode += getPerforceBrowsingMode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SourceControlSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceControlSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("port");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Port"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useSSL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UseSSL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useSSH");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UseSSH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ServerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repository");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Repository"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RepositoryType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userCredentials");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserCredentials"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Credentials"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocol");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Protocol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceControlProtocolType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repositoryName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RepositoryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocolParameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProtocolParameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GITBranch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GITBranch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gitLsViewType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GitLsViewType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GitLsRemoteViewType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSHPublicKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SSHPublicKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSHPrivateKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SSHPrivateKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gitHubSettings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GitHubSettings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GitHubIntegrationSettings"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perforceBrowsingMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PerforceBrowsingMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSPerforceBrowsingMode"));
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
