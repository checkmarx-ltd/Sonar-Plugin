/**
 * WebClientUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class WebClientUser  implements java.io.Serializable {
    private long ID;

    private String firstName;

    private String lastName;

    private int userPreferedLanguageLCID;

    private String password;

    private String jobTitle;

    private String email;

    private String userName;

    private String UPN;

    private String phone;

    private String cellPhone;

    private String skype;

    private String companyID;

    private String companyName;

    private String willExpireAfterDays;

    private String country;

    private java.util.Calendar dateCreated;

    private boolean auditUser;

    private ArrayOfGroup groupList;

    private java.util.Calendar lastLoginDate;

    private boolean limitAccessByIPAddress;

    private ArrayOfString allowedIPs;

    public WebClientUser() {
    }

    public WebClientUser(
           long ID,
           String firstName,
           String lastName,
           int userPreferedLanguageLCID,
           String password,
           String jobTitle,
           String email,
           String userName,
           String UPN,
           String phone,
           String cellPhone,
           String skype,
           String companyID,
           String companyName,
           String willExpireAfterDays,
           String country,
           java.util.Calendar dateCreated,
           boolean auditUser,
           ArrayOfGroup groupList,
           java.util.Calendar lastLoginDate,
           boolean limitAccessByIPAddress,
           ArrayOfString allowedIPs) {
           this.ID = ID;
           this.firstName = firstName;
           this.lastName = lastName;
           this.userPreferedLanguageLCID = userPreferedLanguageLCID;
           this.password = password;
           this.jobTitle = jobTitle;
           this.email = email;
           this.userName = userName;
           this.UPN = UPN;
           this.phone = phone;
           this.cellPhone = cellPhone;
           this.skype = skype;
           this.companyID = companyID;
           this.companyName = companyName;
           this.willExpireAfterDays = willExpireAfterDays;
           this.country = country;
           this.dateCreated = dateCreated;
           this.auditUser = auditUser;
           this.groupList = groupList;
           this.lastLoginDate = lastLoginDate;
           this.limitAccessByIPAddress = limitAccessByIPAddress;
           this.allowedIPs = allowedIPs;
    }


    /**
     * Gets the ID value for this WebClientUser.
     *
     * @return ID
     */
    public long getID() {
        return ID;
    }


    /**
     * Sets the ID value for this WebClientUser.
     *
     * @param ID
     */
    public void setID(long ID) {
        this.ID = ID;
    }


    /**
     * Gets the firstName value for this WebClientUser.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this WebClientUser.
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the lastName value for this WebClientUser.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this WebClientUser.
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the userPreferedLanguageLCID value for this WebClientUser.
     *
     * @return userPreferedLanguageLCID
     */
    public int getUserPreferedLanguageLCID() {
        return userPreferedLanguageLCID;
    }


    /**
     * Sets the userPreferedLanguageLCID value for this WebClientUser.
     *
     * @param userPreferedLanguageLCID
     */
    public void setUserPreferedLanguageLCID(int userPreferedLanguageLCID) {
        this.userPreferedLanguageLCID = userPreferedLanguageLCID;
    }


    /**
     * Gets the password value for this WebClientUser.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this WebClientUser.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Gets the jobTitle value for this WebClientUser.
     *
     * @return jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }


    /**
     * Sets the jobTitle value for this WebClientUser.
     *
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    /**
     * Gets the email value for this WebClientUser.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this WebClientUser.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the userName value for this WebClientUser.
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this WebClientUser.
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * Gets the UPN value for this WebClientUser.
     *
     * @return UPN
     */
    public String getUPN() {
        return UPN;
    }


    /**
     * Sets the UPN value for this WebClientUser.
     *
     * @param UPN
     */
    public void setUPN(String UPN) {
        this.UPN = UPN;
    }


    /**
     * Gets the phone value for this WebClientUser.
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this WebClientUser.
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * Gets the cellPhone value for this WebClientUser.
     *
     * @return cellPhone
     */
    public String getCellPhone() {
        return cellPhone;
    }


    /**
     * Sets the cellPhone value for this WebClientUser.
     *
     * @param cellPhone
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }


    /**
     * Gets the skype value for this WebClientUser.
     *
     * @return skype
     */
    public String getSkype() {
        return skype;
    }


    /**
     * Sets the skype value for this WebClientUser.
     *
     * @param skype
     */
    public void setSkype(String skype) {
        this.skype = skype;
    }


    /**
     * Gets the companyID value for this WebClientUser.
     *
     * @return companyID
     */
    public String getCompanyID() {
        return companyID;
    }


    /**
     * Sets the companyID value for this WebClientUser.
     *
     * @param companyID
     */
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }


    /**
     * Gets the companyName value for this WebClientUser.
     *
     * @return companyName
     */
    public String getCompanyName() {
        return companyName;
    }


    /**
     * Sets the companyName value for this WebClientUser.
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    /**
     * Gets the willExpireAfterDays value for this WebClientUser.
     *
     * @return willExpireAfterDays
     */
    public String getWillExpireAfterDays() {
        return willExpireAfterDays;
    }


    /**
     * Sets the willExpireAfterDays value for this WebClientUser.
     *
     * @param willExpireAfterDays
     */
    public void setWillExpireAfterDays(String willExpireAfterDays) {
        this.willExpireAfterDays = willExpireAfterDays;
    }


    /**
     * Gets the country value for this WebClientUser.
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }


    /**
     * Sets the country value for this WebClientUser.
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }


    /**
     * Gets the dateCreated value for this WebClientUser.
     *
     * @return dateCreated
     */
    public java.util.Calendar getDateCreated() {
        return dateCreated;
    }


    /**
     * Sets the dateCreated value for this WebClientUser.
     *
     * @param dateCreated
     */
    public void setDateCreated(java.util.Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }


    /**
     * Gets the auditUser value for this WebClientUser.
     *
     * @return auditUser
     */
    public boolean isAuditUser() {
        return auditUser;
    }


    /**
     * Sets the auditUser value for this WebClientUser.
     *
     * @param auditUser
     */
    public void setAuditUser(boolean auditUser) {
        this.auditUser = auditUser;
    }


    /**
     * Gets the groupList value for this WebClientUser.
     *
     * @return groupList
     */
    public ArrayOfGroup getGroupList() {
        return groupList;
    }


    /**
     * Sets the groupList value for this WebClientUser.
     *
     * @param groupList
     */
    public void setGroupList(ArrayOfGroup groupList) {
        this.groupList = groupList;
    }


    /**
     * Gets the lastLoginDate value for this WebClientUser.
     *
     * @return lastLoginDate
     */
    public java.util.Calendar getLastLoginDate() {
        return lastLoginDate;
    }


    /**
     * Sets the lastLoginDate value for this WebClientUser.
     *
     * @param lastLoginDate
     */
    public void setLastLoginDate(java.util.Calendar lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }


    /**
     * Gets the limitAccessByIPAddress value for this WebClientUser.
     *
     * @return limitAccessByIPAddress
     */
    public boolean isLimitAccessByIPAddress() {
        return limitAccessByIPAddress;
    }


    /**
     * Sets the limitAccessByIPAddress value for this WebClientUser.
     *
     * @param limitAccessByIPAddress
     */
    public void setLimitAccessByIPAddress(boolean limitAccessByIPAddress) {
        this.limitAccessByIPAddress = limitAccessByIPAddress;
    }


    /**
     * Gets the allowedIPs value for this WebClientUser.
     *
     * @return allowedIPs
     */
    public ArrayOfString getAllowedIPs() {
        return allowedIPs;
    }


    /**
     * Sets the allowedIPs value for this WebClientUser.
     *
     * @param allowedIPs
     */
    public void setAllowedIPs(ArrayOfString allowedIPs) {
        this.allowedIPs = allowedIPs;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof WebClientUser)) return false;
        WebClientUser other = (WebClientUser) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.ID == other.getID() &&
            ((this.firstName==null && other.getFirstName()==null) ||
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.lastName==null && other.getLastName()==null) ||
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            this.userPreferedLanguageLCID == other.getUserPreferedLanguageLCID() &&
            ((this.password==null && other.getPassword()==null) ||
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.jobTitle==null && other.getJobTitle()==null) ||
             (this.jobTitle!=null &&
              this.jobTitle.equals(other.getJobTitle()))) &&
            ((this.email==null && other.getEmail()==null) ||
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.userName==null && other.getUserName()==null) ||
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.UPN==null && other.getUPN()==null) ||
             (this.UPN!=null &&
              this.UPN.equals(other.getUPN()))) &&
            ((this.phone==null && other.getPhone()==null) ||
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.cellPhone==null && other.getCellPhone()==null) ||
             (this.cellPhone!=null &&
              this.cellPhone.equals(other.getCellPhone()))) &&
            ((this.skype==null && other.getSkype()==null) ||
             (this.skype!=null &&
              this.skype.equals(other.getSkype()))) &&
            ((this.companyID==null && other.getCompanyID()==null) ||
             (this.companyID!=null &&
              this.companyID.equals(other.getCompanyID()))) &&
            ((this.companyName==null && other.getCompanyName()==null) ||
             (this.companyName!=null &&
              this.companyName.equals(other.getCompanyName()))) &&
            ((this.willExpireAfterDays==null && other.getWillExpireAfterDays()==null) ||
             (this.willExpireAfterDays!=null &&
              this.willExpireAfterDays.equals(other.getWillExpireAfterDays()))) &&
            ((this.country==null && other.getCountry()==null) ||
             (this.country!=null &&
              this.country.equals(other.getCountry()))) &&
            ((this.dateCreated==null && other.getDateCreated()==null) ||
             (this.dateCreated!=null &&
              this.dateCreated.equals(other.getDateCreated()))) &&
            this.auditUser == other.isAuditUser() &&
            ((this.groupList==null && other.getGroupList()==null) ||
             (this.groupList!=null &&
              this.groupList.equals(other.getGroupList()))) &&
            ((this.lastLoginDate==null && other.getLastLoginDate()==null) ||
             (this.lastLoginDate!=null &&
              this.lastLoginDate.equals(other.getLastLoginDate()))) &&
            this.limitAccessByIPAddress == other.isLimitAccessByIPAddress() &&
            ((this.allowedIPs==null && other.getAllowedIPs()==null) ||
             (this.allowedIPs!=null &&
              this.allowedIPs.equals(other.getAllowedIPs())));
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
        _hashCode += new Long(getID()).hashCode();
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        _hashCode += getUserPreferedLanguageLCID();
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getJobTitle() != null) {
            _hashCode += getJobTitle().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getUPN() != null) {
            _hashCode += getUPN().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getCellPhone() != null) {
            _hashCode += getCellPhone().hashCode();
        }
        if (getSkype() != null) {
            _hashCode += getSkype().hashCode();
        }
        if (getCompanyID() != null) {
            _hashCode += getCompanyID().hashCode();
        }
        if (getCompanyName() != null) {
            _hashCode += getCompanyName().hashCode();
        }
        if (getWillExpireAfterDays() != null) {
            _hashCode += getWillExpireAfterDays().hashCode();
        }
        if (getCountry() != null) {
            _hashCode += getCountry().hashCode();
        }
        if (getDateCreated() != null) {
            _hashCode += getDateCreated().hashCode();
        }
        _hashCode += (isAuditUser() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getGroupList() != null) {
            _hashCode += getGroupList().hashCode();
        }
        if (getLastLoginDate() != null) {
            _hashCode += getLastLoginDate().hashCode();
        }
        _hashCode += (isLimitAccessByIPAddress() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getAllowedIPs() != null) {
            _hashCode += getAllowedIPs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebClientUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "WebClientUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userPreferedLanguageLCID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserPreferedLanguageLCID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "JobTitle"));
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
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UPN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "UPN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cellPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CellPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skype");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Skype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CompanyID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CompanyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("willExpireAfterDays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "willExpireAfterDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("country");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "country"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateCreated");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "DateCreated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "AuditUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "GroupList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfGroup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastLoginDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LastLoginDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitAccessByIPAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LimitAccessByIPAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowedIPs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "AllowedIPs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ArrayOfString"));
        elemField.setMinOccurs(0);
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
