/**
 * CxWSResponseScanStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.checkmarx.soap.client;

public class CxWSResponseScanStatus  extends CxWSBasicRepsonse  implements java.io.Serializable {
    private int currentStage;

    private int queuePosition;

    private int totalPercent;

    private int currentStagePercent;

    private String owner;

    private String stageName;

    private String stageMessage;

    private String stepMessage;

    private String stepDetails;

    private long resultId;

    private long scanId;

    private long projectId;

    private long taskId;

    private String taskName;

    private String projectName;

    private String runId;

    private String sourceId;

    private long LOC;

    private CxDateTime timeScheduled;

    private CxDateTime elapsedTime;

    private CxDateTime timeFinished;

    private CxDateTime timeBeginWorking;

    private CurrentStatusEnum currentStatus;

    private String serverName;

    private String origin;

    private boolean isPublic;

    private boolean partialResults;

    public CxWSResponseScanStatus() {
    }

    public CxWSResponseScanStatus(
           boolean isSuccesfull,
           String errorMessage,
           int currentStage,
           int queuePosition,
           int totalPercent,
           int currentStagePercent,
           String owner,
           String stageName,
           String stageMessage,
           String stepMessage,
           String stepDetails,
           long resultId,
           long scanId,
           long projectId,
           long taskId,
           String taskName,
           String projectName,
           String runId,
           String sourceId,
           long LOC,
           CxDateTime timeScheduled,
           CxDateTime elapsedTime,
           CxDateTime timeFinished,
           CxDateTime timeBeginWorking,
           CurrentStatusEnum currentStatus,
           String serverName,
           String origin,
           boolean isPublic,
           boolean partialResults) {
        super(
            isSuccesfull,
            errorMessage);
        this.currentStage = currentStage;
        this.queuePosition = queuePosition;
        this.totalPercent = totalPercent;
        this.currentStagePercent = currentStagePercent;
        this.owner = owner;
        this.stageName = stageName;
        this.stageMessage = stageMessage;
        this.stepMessage = stepMessage;
        this.stepDetails = stepDetails;
        this.resultId = resultId;
        this.scanId = scanId;
        this.projectId = projectId;
        this.taskId = taskId;
        this.taskName = taskName;
        this.projectName = projectName;
        this.runId = runId;
        this.sourceId = sourceId;
        this.LOC = LOC;
        this.timeScheduled = timeScheduled;
        this.elapsedTime = elapsedTime;
        this.timeFinished = timeFinished;
        this.timeBeginWorking = timeBeginWorking;
        this.currentStatus = currentStatus;
        this.serverName = serverName;
        this.origin = origin;
        this.isPublic = isPublic;
        this.partialResults = partialResults;
    }


    /**
     * Gets the currentStage value for this CxWSResponseScanStatus.
     *
     * @return currentStage
     */
    public int getCurrentStage() {
        return currentStage;
    }


    /**
     * Sets the currentStage value for this CxWSResponseScanStatus.
     *
     * @param currentStage
     */
    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }


    /**
     * Gets the queuePosition value for this CxWSResponseScanStatus.
     *
     * @return queuePosition
     */
    public int getQueuePosition() {
        return queuePosition;
    }


    /**
     * Sets the queuePosition value for this CxWSResponseScanStatus.
     *
     * @param queuePosition
     */
    public void setQueuePosition(int queuePosition) {
        this.queuePosition = queuePosition;
    }


    /**
     * Gets the totalPercent value for this CxWSResponseScanStatus.
     *
     * @return totalPercent
     */
    public int getTotalPercent() {
        return totalPercent;
    }


    /**
     * Sets the totalPercent value for this CxWSResponseScanStatus.
     *
     * @param totalPercent
     */
    public void setTotalPercent(int totalPercent) {
        this.totalPercent = totalPercent;
    }


    /**
     * Gets the currentStagePercent value for this CxWSResponseScanStatus.
     *
     * @return currentStagePercent
     */
    public int getCurrentStagePercent() {
        return currentStagePercent;
    }


    /**
     * Sets the currentStagePercent value for this CxWSResponseScanStatus.
     *
     * @param currentStagePercent
     */
    public void setCurrentStagePercent(int currentStagePercent) {
        this.currentStagePercent = currentStagePercent;
    }


    /**
     * Gets the owner value for this CxWSResponseScanStatus.
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this CxWSResponseScanStatus.
     *
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }


    /**
     * Gets the stageName value for this CxWSResponseScanStatus.
     *
     * @return stageName
     */
    public String getStageName() {
        return stageName;
    }


    /**
     * Sets the stageName value for this CxWSResponseScanStatus.
     *
     * @param stageName
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }


    /**
     * Gets the stageMessage value for this CxWSResponseScanStatus.
     *
     * @return stageMessage
     */
    public String getStageMessage() {
        return stageMessage;
    }


    /**
     * Sets the stageMessage value for this CxWSResponseScanStatus.
     *
     * @param stageMessage
     */
    public void setStageMessage(String stageMessage) {
        this.stageMessage = stageMessage;
    }


    /**
     * Gets the stepMessage value for this CxWSResponseScanStatus.
     *
     * @return stepMessage
     */
    public String getStepMessage() {
        return stepMessage;
    }


    /**
     * Sets the stepMessage value for this CxWSResponseScanStatus.
     *
     * @param stepMessage
     */
    public void setStepMessage(String stepMessage) {
        this.stepMessage = stepMessage;
    }


    /**
     * Gets the stepDetails value for this CxWSResponseScanStatus.
     *
     * @return stepDetails
     */
    public String getStepDetails() {
        return stepDetails;
    }


    /**
     * Sets the stepDetails value for this CxWSResponseScanStatus.
     *
     * @param stepDetails
     */
    public void setStepDetails(String stepDetails) {
        this.stepDetails = stepDetails;
    }


    /**
     * Gets the resultId value for this CxWSResponseScanStatus.
     *
     * @return resultId
     */
    public long getResultId() {
        return resultId;
    }


    /**
     * Sets the resultId value for this CxWSResponseScanStatus.
     *
     * @param resultId
     */
    public void setResultId(long resultId) {
        this.resultId = resultId;
    }


    /**
     * Gets the scanId value for this CxWSResponseScanStatus.
     *
     * @return scanId
     */
    public long getScanId() {
        return scanId;
    }


    /**
     * Sets the scanId value for this CxWSResponseScanStatus.
     *
     * @param scanId
     */
    public void setScanId(long scanId) {
        this.scanId = scanId;
    }


    /**
     * Gets the projectId value for this CxWSResponseScanStatus.
     *
     * @return projectId
     */
    public long getProjectId() {
        return projectId;
    }


    /**
     * Sets the projectId value for this CxWSResponseScanStatus.
     *
     * @param projectId
     */
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }


    /**
     * Gets the taskId value for this CxWSResponseScanStatus.
     *
     * @return taskId
     */
    public long getTaskId() {
        return taskId;
    }


    /**
     * Sets the taskId value for this CxWSResponseScanStatus.
     *
     * @param taskId
     */
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }


    /**
     * Gets the taskName value for this CxWSResponseScanStatus.
     *
     * @return taskName
     */
    public String getTaskName() {
        return taskName;
    }


    /**
     * Sets the taskName value for this CxWSResponseScanStatus.
     *
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    /**
     * Gets the projectName value for this CxWSResponseScanStatus.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }


    /**
     * Sets the projectName value for this CxWSResponseScanStatus.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Gets the runId value for this CxWSResponseScanStatus.
     *
     * @return runId
     */
    public String getRunId() {
        return runId;
    }


    /**
     * Sets the runId value for this CxWSResponseScanStatus.
     *
     * @param runId
     */
    public void setRunId(String runId) {
        this.runId = runId;
    }


    /**
     * Gets the sourceId value for this CxWSResponseScanStatus.
     *
     * @return sourceId
     */
    public String getSourceId() {
        return sourceId;
    }


    /**
     * Sets the sourceId value for this CxWSResponseScanStatus.
     *
     * @param sourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }


    /**
     * Gets the LOC value for this CxWSResponseScanStatus.
     *
     * @return LOC
     */
    public long getLOC() {
        return LOC;
    }


    /**
     * Sets the LOC value for this CxWSResponseScanStatus.
     *
     * @param LOC
     */
    public void setLOC(long LOC) {
        this.LOC = LOC;
    }


    /**
     * Gets the timeScheduled value for this CxWSResponseScanStatus.
     *
     * @return timeScheduled
     */
    public CxDateTime getTimeScheduled() {
        return timeScheduled;
    }


    /**
     * Sets the timeScheduled value for this CxWSResponseScanStatus.
     *
     * @param timeScheduled
     */
    public void setTimeScheduled(CxDateTime timeScheduled) {
        this.timeScheduled = timeScheduled;
    }


    /**
     * Gets the elapsedTime value for this CxWSResponseScanStatus.
     *
     * @return elapsedTime
     */
    public CxDateTime getElapsedTime() {
        return elapsedTime;
    }


    /**
     * Sets the elapsedTime value for this CxWSResponseScanStatus.
     *
     * @param elapsedTime
     */
    public void setElapsedTime(CxDateTime elapsedTime) {
        this.elapsedTime = elapsedTime;
    }


    /**
     * Gets the timeFinished value for this CxWSResponseScanStatus.
     *
     * @return timeFinished
     */
    public CxDateTime getTimeFinished() {
        return timeFinished;
    }


    /**
     * Sets the timeFinished value for this CxWSResponseScanStatus.
     *
     * @param timeFinished
     */
    public void setTimeFinished(CxDateTime timeFinished) {
        this.timeFinished = timeFinished;
    }


    /**
     * Gets the timeBeginWorking value for this CxWSResponseScanStatus.
     *
     * @return timeBeginWorking
     */
    public CxDateTime getTimeBeginWorking() {
        return timeBeginWorking;
    }


    /**
     * Sets the timeBeginWorking value for this CxWSResponseScanStatus.
     *
     * @param timeBeginWorking
     */
    public void setTimeBeginWorking(CxDateTime timeBeginWorking) {
        this.timeBeginWorking = timeBeginWorking;
    }


    /**
     * Gets the currentStatus value for this CxWSResponseScanStatus.
     *
     * @return currentStatus
     */
    public CurrentStatusEnum getCurrentStatus() {
        return currentStatus;
    }


    /**
     * Sets the currentStatus value for this CxWSResponseScanStatus.
     *
     * @param currentStatus
     */
    public void setCurrentStatus(CurrentStatusEnum currentStatus) {
        this.currentStatus = currentStatus;
    }


    /**
     * Gets the serverName value for this CxWSResponseScanStatus.
     *
     * @return serverName
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the serverName value for this CxWSResponseScanStatus.
     *
     * @param serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Gets the origin value for this CxWSResponseScanStatus.
     *
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }


    /**
     * Sets the origin value for this CxWSResponseScanStatus.
     *
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }


    /**
     * Gets the isPublic value for this CxWSResponseScanStatus.
     *
     * @return isPublic
     */
    public boolean isIsPublic() {
        return isPublic;
    }


    /**
     * Sets the isPublic value for this CxWSResponseScanStatus.
     *
     * @param isPublic
     */
    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


    /**
     * Gets the partialResults value for this CxWSResponseScanStatus.
     *
     * @return partialResults
     */
    public boolean isPartialResults() {
        return partialResults;
    }


    /**
     * Sets the partialResults value for this CxWSResponseScanStatus.
     *
     * @param partialResults
     */
    public void setPartialResults(boolean partialResults) {
        this.partialResults = partialResults;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CxWSResponseScanStatus)) return false;
        CxWSResponseScanStatus other = (CxWSResponseScanStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
            this.currentStage == other.getCurrentStage() &&
            this.queuePosition == other.getQueuePosition() &&
            this.totalPercent == other.getTotalPercent() &&
            this.currentStagePercent == other.getCurrentStagePercent() &&
            ((this.owner==null && other.getOwner()==null) ||
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            ((this.stageName==null && other.getStageName()==null) ||
             (this.stageName!=null &&
              this.stageName.equals(other.getStageName()))) &&
            ((this.stageMessage==null && other.getStageMessage()==null) ||
             (this.stageMessage!=null &&
              this.stageMessage.equals(other.getStageMessage()))) &&
            ((this.stepMessage==null && other.getStepMessage()==null) ||
             (this.stepMessage!=null &&
              this.stepMessage.equals(other.getStepMessage()))) &&
            ((this.stepDetails==null && other.getStepDetails()==null) ||
             (this.stepDetails!=null &&
              this.stepDetails.equals(other.getStepDetails()))) &&
            this.resultId == other.getResultId() &&
            this.scanId == other.getScanId() &&
            this.projectId == other.getProjectId() &&
            this.taskId == other.getTaskId() &&
            ((this.taskName==null && other.getTaskName()==null) ||
             (this.taskName!=null &&
              this.taskName.equals(other.getTaskName()))) &&
            ((this.projectName==null && other.getProjectName()==null) ||
             (this.projectName!=null &&
              this.projectName.equals(other.getProjectName()))) &&
            ((this.runId==null && other.getRunId()==null) ||
             (this.runId!=null &&
              this.runId.equals(other.getRunId()))) &&
            ((this.sourceId==null && other.getSourceId()==null) ||
             (this.sourceId!=null &&
              this.sourceId.equals(other.getSourceId()))) &&
            this.LOC == other.getLOC() &&
            ((this.timeScheduled==null && other.getTimeScheduled()==null) ||
             (this.timeScheduled!=null &&
              this.timeScheduled.equals(other.getTimeScheduled()))) &&
            ((this.elapsedTime==null && other.getElapsedTime()==null) ||
             (this.elapsedTime!=null &&
              this.elapsedTime.equals(other.getElapsedTime()))) &&
            ((this.timeFinished==null && other.getTimeFinished()==null) ||
             (this.timeFinished!=null &&
              this.timeFinished.equals(other.getTimeFinished()))) &&
            ((this.timeBeginWorking==null && other.getTimeBeginWorking()==null) ||
             (this.timeBeginWorking!=null &&
              this.timeBeginWorking.equals(other.getTimeBeginWorking()))) &&
            ((this.currentStatus==null && other.getCurrentStatus()==null) ||
             (this.currentStatus!=null &&
              this.currentStatus.equals(other.getCurrentStatus()))) &&
            ((this.serverName==null && other.getServerName()==null) ||
             (this.serverName!=null &&
              this.serverName.equals(other.getServerName()))) &&
            ((this.origin==null && other.getOrigin()==null) ||
             (this.origin!=null &&
              this.origin.equals(other.getOrigin()))) &&
            this.isPublic == other.isIsPublic() &&
            this.partialResults == other.isPartialResults();
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
        _hashCode += getCurrentStage();
        _hashCode += getQueuePosition();
        _hashCode += getTotalPercent();
        _hashCode += getCurrentStagePercent();
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getStageName() != null) {
            _hashCode += getStageName().hashCode();
        }
        if (getStageMessage() != null) {
            _hashCode += getStageMessage().hashCode();
        }
        if (getStepMessage() != null) {
            _hashCode += getStepMessage().hashCode();
        }
        if (getStepDetails() != null) {
            _hashCode += getStepDetails().hashCode();
        }
        _hashCode += new Long(getResultId()).hashCode();
        _hashCode += new Long(getScanId()).hashCode();
        _hashCode += new Long(getProjectId()).hashCode();
        _hashCode += new Long(getTaskId()).hashCode();
        if (getTaskName() != null) {
            _hashCode += getTaskName().hashCode();
        }
        if (getProjectName() != null) {
            _hashCode += getProjectName().hashCode();
        }
        if (getRunId() != null) {
            _hashCode += getRunId().hashCode();
        }
        if (getSourceId() != null) {
            _hashCode += getSourceId().hashCode();
        }
        _hashCode += new Long(getLOC()).hashCode();
        if (getTimeScheduled() != null) {
            _hashCode += getTimeScheduled().hashCode();
        }
        if (getElapsedTime() != null) {
            _hashCode += getElapsedTime().hashCode();
        }
        if (getTimeFinished() != null) {
            _hashCode += getTimeFinished().hashCode();
        }
        if (getTimeBeginWorking() != null) {
            _hashCode += getTimeBeginWorking().hashCode();
        }
        if (getCurrentStatus() != null) {
            _hashCode += getCurrentStatus().hashCode();
        }
        if (getServerName() != null) {
            _hashCode += getServerName().hashCode();
        }
        if (getOrigin() != null) {
            _hashCode += getOrigin().hashCode();
        }
        _hashCode += (isIsPublic() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isPartialResults() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CxWSResponseScanStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxWSResponseScanStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentStage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CurrentStage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queuePosition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "QueuePosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TotalPercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentStagePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CurrentStagePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("stageName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StageName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stageMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StageMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stepMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StepMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stepDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "StepDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ResultId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scanId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ScanId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ProjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TaskId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TaskName"));
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
        elemField.setFieldName("runId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "RunId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "SourceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "LOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeScheduled");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TimeScheduled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elapsedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "ElapsedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeFinished");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TimeFinished"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeBeginWorking");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "TimeBeginWorking"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CxDateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CurrentStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "CurrentStatusEnum"));
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
        elemField.setFieldName("origin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "Origin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPublic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "IsPublic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partialResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Checkmarx.com/v7", "PartialResults"));
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
