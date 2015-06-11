package net.jitix.issuehub.entity;

import java.util.List;

public class IssueType {

    private String issueTypeId;

    private String issueType;

    private List<Status> statusList;

    public IssueType() {
    }

    public IssueType(String issueTypeId, String issueType, List<Status> statusList) {
        this.issueTypeId = issueTypeId;
        this.issueType = issueType;
        this.statusList = statusList;
    }

    public String getIssueTypeId() {
        return issueTypeId;
    }

    public void setIssueTypeId(String issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @Override
    public String toString() {
        return "IssueType{" + "issueTypeId=" + issueTypeId + ", issueType=" + issueType + ", statusList=" + statusList + '}';
    }

}
