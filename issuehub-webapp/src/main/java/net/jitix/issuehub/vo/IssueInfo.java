package net.jitix.issuehub.vo;

import java.util.List;
import net.jitix.issuehub.entity.Comment;

public class IssueInfo {
    
    private Integer issueNumber;

    private String title;

    private String issueType;

    private String reporterUserId;

    private Long reportedTimestamp;

    private String assigneeUserId;

    private String status;

    private String substatus;

    private Long updatedTimestamp;

    public IssueInfo() {
    }

    public IssueInfo(Integer issueNumber, String title, String issueType, String reporterUserId, Long reportedTimestamp, String assigneeUserId, String status, String substatus, Long updatedTimestamp) {
        this.issueNumber = issueNumber;
        this.title = title;
        this.issueType = issueType;
        this.reporterUserId = reporterUserId;
        this.reportedTimestamp = reportedTimestamp;
        this.assigneeUserId = assigneeUserId;
        this.status = status;
        this.substatus = substatus;
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

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getReporterUserId() {
        return reporterUserId;
    }

    public void setReporterUserId(String reporterUserId) {
        this.reporterUserId = reporterUserId;
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

    public Long getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Long updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public String toString() {
        return "IssueInfo{" + "issueNumber=" + issueNumber + ", title=" + title + ", issueType=" + issueType + ", reporterUserId=" + reporterUserId + ", reportedTimestamp=" + reportedTimestamp + ", assigneeUserId=" + assigneeUserId + ", status=" + status + ", substatus=" + substatus + ", updatedTimestamp=" + updatedTimestamp + '}';
    }

}
