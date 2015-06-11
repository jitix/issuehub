package net.jitix.issuehub.entity;

import java.util.List;

public class Issue {

    private Integer issueId;

    private String title;

    private String description;

    private Integer issueTypeId;

    private Integer statusId;

    private String substatus;

    private List<Comment> comments;

    public Issue() {
    }

    public Issue(Integer issueId, String title, String description, Integer issueTypeId, Integer statusId, String substatus, List<Comment> comments) {
        this.issueId = issueId;
        this.title = title;
        this.description = description;
        this.issueTypeId = issueTypeId;
        this.statusId = statusId;
        this.substatus = substatus;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Issue{" + "issueId=" + issueId + ", title=" + title + ", description=" + description + ", issueTypeId=" + issueTypeId + ", statusId=" + statusId + ", substatus=" + substatus + ", comments=" + comments + '}';
    }

}
