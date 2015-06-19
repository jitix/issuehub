package net.jitix.issuehub.vo;

public class NewIssueDetails {

    private String title;

    private String description;

    private String issueTypeName;
    
    private String priority;

    private String assigneeUserId;

    public NewIssueDetails() {
    }

    public NewIssueDetails(String title, String description, String issueTypeName, String priority, String assigneeUserId) {
        this.title = title;
        this.description = description;
        this.issueTypeName = issueTypeName;
        this.priority = priority;
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

    public String getAssigneeUserId() {
        return assigneeUserId;
    }

    public void setAssigneeUserId(String assigneeUserId) {
        this.assigneeUserId = assigneeUserId;
    }

    @Override
    public String toString() {
        return "NewIssueDetails{" + "title=" + title + ", description=" + description + ", issueTypeName=" + issueTypeName + ", priority=" + priority + ", assigneeUserId=" + assigneeUserId + '}';
    }

}
