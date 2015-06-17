package net.jitix.issuehub.vo;

public class NewIssueDetails {

    private String title;

    private String description;

    private String issueTypeId;

    private String reporterUserId;

    private String assigneeUserId;

    public NewIssueDetails() {
    }

    public NewIssueDetails(String title, String description, String issueTypeId, String reporterUserId, String assigneeUserId) {
        this.title = title;
        this.description = description;
        this.issueTypeId = issueTypeId;
        this.reporterUserId = reporterUserId;
        this.assigneeUserId = assigneeUserId;
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

    public String getIssueTypeId() {
        return issueTypeId;
    }

    public void setIssueTypeId(String issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    public String getReporterUserId() {
        return reporterUserId;
    }

    public void setReporterUserId(String reporterUserId) {
        this.reporterUserId = reporterUserId;
    }

    public String getAssigneeUserId() {
        return assigneeUserId;
    }

    public void setAssigneeUserId(String assigneeUserId) {
        this.assigneeUserId = assigneeUserId;
    }

    @Override
    public String toString() {
        return "NewIssueDetails{" + "title=" + title + ", description=" + description + ", issueTypeId=" + issueTypeId + ", reporterUserId=" + reporterUserId + ", assigneeUserId=" + assigneeUserId + '}';
    }

}
