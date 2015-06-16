package net.jitix.issuehub.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Issue {

    @Id
    private Integer issueId;

    private String title;

    private String description;

    private Integer issueTypeId;

    private String reporterUserId;

    private Long reportedTimestamp;

    private String assigneeUserId;

    private Integer statusId;

    private String substatus;

    private Long updatedTimestamp;

    private List<Comment> comments;

    public Issue() {
    }

    public Issue(Integer issueId, String title, String description, Integer issueTypeId, String reporterUserId, Long reportedTimestamp, String assigneeUserId, Integer statusId, String substatus, Long updatedTimestamp, List<Comment> comments) {
        this.issueId = issueId;
        this.title = title;
        this.description = description;
        this.issueTypeId = issueTypeId;
        this.reporterUserId = reporterUserId;
        this.reportedTimestamp = reportedTimestamp;
        this.assigneeUserId = assigneeUserId;
        this.statusId = statusId;
        this.substatus = substatus;
        this.updatedTimestamp = updatedTimestamp;
        this.comments = comments;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Issue{" + "issueId=" + issueId + ", title=" + title + ", description=" + description + ", issueTypeId=" + issueTypeId + ", reporterUserId=" + reporterUserId + ", reportedTimestamp=" + reportedTimestamp + ", assigneeUserId=" + assigneeUserId + ", statusId=" + statusId + ", substatus=" + substatus + ", updatedTimestamp=" + updatedTimestamp + ", comments=" + comments + '}';
    }

}
