package net.jitix.issuehub.vo;

public class IssueInfo {

    private Integer issueNumber;

    private String title;

    private String issueTypeName;

    private String priority;
    
    private String reporterUserId;
    
    private String reporterUserName;

    private Long reportedTimestamp;

    private String assigneeUserId;
    
    private String assigneeUserName;

    private String status;

    private String substatus;

    private String updatedByUserId;

    private Long updatedTimestamp;

    public IssueInfo() {
    }

    public IssueInfo(Integer issueNumber, String title, String issueTypeName, String priority, String reporterUserId, String reporterUserName, Long reportedTimestamp, String assigneeUserId, String assigneeUserName, String status, String substatus, String updatedByUserId, Long updatedTimestamp) {
        this.issueNumber = issueNumber;
        this.title = title;
        this.issueTypeName = issueTypeName;
        this.priority = priority;
        this.reporterUserId = reporterUserId;
        this.reporterUserName = reporterUserName;
        this.reportedTimestamp = reportedTimestamp;
        this.assigneeUserId = assigneeUserId;
        this.assigneeUserName = assigneeUserName;
        this.status = status;
        this.substatus = substatus;
        this.updatedByUserId = updatedByUserId;
        this.updatedTimestamp = updatedTimestamp;
    }

    public Integer getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssueTypeName() {
        return issueTypeName;
    }

    public void setIssueTypeName(String issueTypeName) {
        this.issueTypeName = issueTypeName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getReporterUserId() {
        return reporterUserId;
    }

    public void setReporterUserId(String reporterUserId) {
        this.reporterUserId = reporterUserId;
    }

    public String getReporterUserName() {
        return reporterUserName;
    }

    public void setReporterUserName(String reporterUserName) {
        this.reporterUserName = reporterUserName;
    }

    public Long getReportedTimestamp() {
        return reportedTimestamp;
    }

    public void setReportedTimestamp(Long reportedTimestamp) {
        this.reportedTimestamp = reportedTimestamp;
    }

    public String getAssigneeUserId() {
        return assigneeUserId;
    }

    public void setAssigneeUserId(String assigneeUserId) {
        this.assigneeUserId = assigneeUserId;
    }

    public String getAssigneeUserName() {
        return assigneeUserName;
    }

    public void setAssigneeUserName(String assigneeUserName) {
        this.assigneeUserName = assigneeUserName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubstatus() {
        return substatus;
    }

    public void setSubstatus(String substatus) {
        this.substatus = substatus;
    }

    public String getUpdatedByUserId() {
        return updatedByUserId;
    }

    public void setUpdatedByUserId(String updatedByUserId) {
        this.updatedByUserId = updatedByUserId;
    }

    public Long getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Long updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public String toString() {
        return "IssueInfo{" + "issueNumber=" + issueNumber + ", title=" + title + ", issueTypeName=" + issueTypeName + ", priority=" + priority + ", reporterUserId=" + reporterUserId + ", reporterUserName=" + reporterUserName + ", reportedTimestamp=" + reportedTimestamp + ", assigneeUserId=" + assigneeUserId + ", assigneeUserName=" + assigneeUserName + ", status=" + status + ", substatus=" + substatus + ", updatedByUserId=" + updatedByUserId + ", updatedTimestamp=" + updatedTimestamp + '}';
    }

}
