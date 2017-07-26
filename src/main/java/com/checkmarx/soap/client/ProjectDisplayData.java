/**
 * ProjectDisplayData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class ProjectDisplayData  implements java.io.Serializable {
    private UserPermission permission;

    private long projectID;

    private String serviceProvider;

    private String company;

    private String owner;

    private String projectName;

    private String group;

    private String preset;

    private CxDateTime lastScanDate;

    private int totalScans;

    private boolean isPublic;

    private int totalOsaScans;

    public ProjectDisplayData() {
    }

    public ProjectDisplayData(
           UserPermission permission,
           long projectID,
           String serviceProvider,
           String company,
           String owner,
           String projectName,
           String group,
           String preset,
           CxDateTime lastScanDate,
           int totalScans,
           boolean isPublic,
           int totalOsaScans) {
           this.permission = permission;
           this.projectID = projectID;
           this.serviceProvider = serviceProvider;
           this.company = company;
           this.owner = owner;
           this.projectName = projectName;
           this.group = group;
           this.preset = preset;
           this.lastScanDate = lastScanDate;
           this.totalScans = totalScans;
           this.isPublic = isPublic;
           this.totalOsaScans = totalOsaScans;
    }


    /**
     * Gets the permission value for this ProjectDisplayData.
     *
     * @return permission
     */
    public UserPermission getPermission() {
        return permission;
    }


    /**
     * Sets the permission value for this ProjectDisplayData.
     *
     * @param permission
     */
    public void setPermission(UserPermission permission) {
        this.permission = permission;
    }


    /**
     * Gets the projectID value for this ProjectDisplayData.
     *
     * @return projectID
     */
    public long getProjectID() {
        return projectID;
    }


    /**
     * Sets the projectID value for this ProjectDisplayData.
     *
     * @param projectID
     */
    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }


    /**
     * Gets the serviceProvider value for this ProjectDisplayData.
     *
     * @return serviceProvider
     */
    public String getServiceProvider() {
        return serviceProvider;
    }


    /**
     * Sets the serviceProvider value for this ProjectDisplayData.
     *
     * @param serviceProvider
     */
    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }


    /**
     * Gets the company value for this ProjectDisplayData.
     *
     * @return company
     */
    public String getCompany() {
        return company;
    }


    /**
     * Sets the company value for this ProjectDisplayData.
     *
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }


    /**
     * Gets the owner value for this ProjectDisplayData.
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this ProjectDisplayData.
     *
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }


    /**
     * Gets the projectName value for this ProjectDisplayData.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }


    /**
     * Sets the projectName value for this ProjectDisplayData.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Gets the group value for this ProjectDisplayData.
     *
     * @return group
     */
    public String getGroup() {
        return group;
    }


    /**
     * Sets the group value for this ProjectDisplayData.
     *
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }


    /**
     * Gets the preset value for this ProjectDisplayData.
     *
     * @return preset
     */
    public String getPreset() {
        return preset;
    }


    /**
     * Sets the preset value for this ProjectDisplayData.
     *
     * @param preset
     */
    public void setPreset(String preset) {
        this.preset = preset;
    }


    /**
     * Gets the lastScanDate value for this ProjectDisplayData.
     *
     * @return lastScanDate
     */
    public CxDateTime getLastScanDate() {
        return lastScanDate;
    }


    /**
     * Sets the lastScanDate value for this ProjectDisplayData.
     *
     * @param lastScanDate
     */
    public void setLastScanDate(CxDateTime lastScanDate) {
        this.lastScanDate = lastScanDate;
    }


    /**
     * Gets the totalScans value for this ProjectDisplayData.
     *
     * @return totalScans
     */
    public int getTotalScans() {
        return totalScans;
    }


    /**
     * Sets the totalScans value for this ProjectDisplayData.
     *
     * @param totalScans
     */
    public void setTotalScans(int totalScans) {
        this.totalScans = totalScans;
    }


    /**
     * Gets the isPublic value for this ProjectDisplayData.
     *
     * @return isPublic
     */
    public boolean isIsPublic() {
        return isPublic;
    }


    /**
     * Sets the isPublic value for this ProjectDisplayData.
     *
     * @param isPublic
     */
    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


    /**
     * Gets the totalOsaScans value for this ProjectDisplayData.
     *
     * @return totalOsaScans
     */
    public int getTotalOsaScans() {
        return totalOsaScans;
    }


    /**
     * Sets the totalOsaScans value for this ProjectDisplayData.
     *
     * @param totalOsaScans
     */
    public void setTotalOsaScans(int totalOsaScans) {
        this.totalOsaScans = totalOsaScans;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ProjectDisplayData)) return false;
        ProjectDisplayData other = (ProjectDisplayData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.permission==null && other.getPermission()==null) ||
             (this.permission!=null &&
              this.permission.equals(other.getPermission()))) &&
            this.projectID == other.getProjectID() &&
            ((this.serviceProvider==null && other.getServiceProvider()==null) ||
             (this.serviceProvider!=null &&
              this.serviceProvider.equals(other.getServiceProvider()))) &&
            ((this.company==null && other.getCompany()==null) ||
             (this.company!=null &&
              this.company.equals(other.getCompany()))) &&
            ((this.owner==null && other.getOwner()==null) ||
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            ((this.projectName==null && other.getProjectName()==null) ||
             (this.projectName!=null &&
              this.projectName.equals(other.getProjectName()))) &&
            ((this.group==null && other.getGroup()==null) ||
             (this.group!=null &&
              this.group.equals(other.getGroup()))) &&
            ((this.preset==null && other.getPreset()==null) ||
             (this.preset!=null &&
              this.preset.equals(other.getPreset()))) &&
            ((this.lastScanDate==null && other.getLastScanDate()==null) ||
             (this.lastScanDate!=null &&
              this.lastScanDate.equals(other.getLastScanDate()))) &&
            this.totalScans == other.getTotalScans() &&
            this.isPublic == other.isIsPublic() &&
            this.totalOsaScans == other.getTotalOsaScans();
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
        if (getPermission() != null) {
            _hashCode += getPermission().hashCode();
        }
        _hashCode += new Long(getProjectID()).hashCode();
        if (getServiceProvider() != null) {
            _hashCode += getServiceProvider().hashCode();
        }
        if (getCompany() != null) {
            _hashCode += getCompany().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getProjectName() != null) {
            _hashCode += getProjectName().hashCode();
        }
        if (getGroup() != null) {
            _hashCode += getGroup().hashCode();
        }
        if (getPreset() != null) {
            _hashCode += getPreset().hashCode();
        }
        if (getLastScanDate() != null) {
            _hashCode += getLastScanDate().hashCode();
        }
        _hashCode += getTotalScans();
        _hashCode += (isIsPublic() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getTotalOsaScans();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjectDisplayData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectDisplayData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permission");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Permission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserPermission"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "projectID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceProvider");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ServiceProvider"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Preset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastScanDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LastScanDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalScans");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TotalScans"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPublic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsPublic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalOsaScans");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TotalOsaScans"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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

    @Override
    public String toString() {
        return "ProjectDisplayData{" +
                "permission=" + permission +
                ", projectID=" + projectID +
                ", serviceProvider='" + serviceProvider + '\'' +
                ", company='" + company + '\'' +
                ", owner='" + owner + '\'' +
                ", projectName='" + projectName + '\'' +
                ", group='" + group + '\'' +
                ", preset='" + preset + '\'' +
                ", lastScanDate=" + lastScanDate +
                ", totalScans=" + totalScans +
                ", isPublic=" + isPublic +
                ", totalOsaScans=" + totalOsaScans +
                ", __equalsCalc=" + __equalsCalc +
                ", __hashCodeCalc=" + __hashCodeCalc +
                '}';
    }

}
