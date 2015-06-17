package net.jitix.issuehub.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "issues")
public class Issue {

    @Id
    private Integer issueNumber;

    private String title;

    private String description;

    private Integer issueTypeId;

    private String reporterUserId;

    private Long reportedTimestamp;

    private String assigneeUserId;

    private String status;

    private String substatus;

    private String updatedByUserId;

    private Long updatedTimestamp;

    private List<Comment> comments;

    public Issue() {
    }

    public Issue(Integer issueNumber, String title, String description, Integer issueTypeId, String reporterUserId, Long reportedTimestamp, String assigneeUserId, String status, String substatus, String updatedByUserId, Long updatedTimestamp, List<Comment> comments) {
        this.issueNumber = issueNumber;
        this.title = title;
        this.description = description;
        this.issueTypeId = issueTypeId;
        this.reporterUserId = reporterUserId;
        this.reportedTimestamp = reportedTimestamp;
        this.assigneeUserId = assigneeUserId;
        this.status = status;
        this.substatus = substatus;
        this.updatedByUserId = updatedByUserId;
        this.updatedTimestamp = updatedTimestamp;
        this.comments = comments;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIssueTypeId() {
        return issueTypeId;
    }

    public void setIssueTypeId(Integer issueTypeId) {
        this.issueTypeId = issueTypeId;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Issue{" + "issueNumber=" + issueNumber + ", title=" + title + ", description=" + description + ", issueTypeId=" + issueTypeId + ", reporterUserId=" + reporterUserId + ", reportedTimestamp=" + reportedTimestamp + ", assigneeUserId=" + assigneeUserId + ", status=" + status + ", substatus=" + substatus + ", updatedByUserId=" + updatedByUserId + ", updatedTimestamp=" + updatedTimestamp + ", comments=" + comments + '}';
    }

}
