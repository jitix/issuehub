package net.jitix.issuehub.vo;

public class SaveIssueDetails {

    private String title;

    private String description;
    
    private String priority;

    private String assigneeUserId;

    private String status;

    private String substatus;

    public SaveIssueDetails() {
    }

    public SaveIssueDetails(String title, String description, String priority, String assigneeUserId, String status, String substatus) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assigneeUserId = assigneeUserId;
        this.status = status;
        this.substatus = substatus;
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

    @Override
    public String toString() {
        return "SaveIssueDetails{" + "title=" + title + ", description=" + description + ", priority=" + priority + ", assigneeUserId=" + assigneeUserId + ", status=" + status + ", substatus=" + substatus + '}';
    }

}
