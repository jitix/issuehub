package net.jitix.issuehub.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "issuetypes")
public class IssueType {

    @Id
    private String issueTypeId;

    private String issueTypeName;

    private List<Status> statusList;

    public IssueType() {
    }

    public IssueType(String issueTypeId, String issueTypeName, List<Status> statusList) {
        this.issueTypeId = issueTypeId;
        this.issueTypeName = issueTypeName;
        this.statusList = statusList;
    }

    public String getIssueTypeId() {
        return issueTypeId;
    }

    public void setIssueTypeId(String issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    public String getIssueTypeName() {
        return issueTypeName;
    }

    public void setIssueTypeName(String issueTypeName) {
        this.issueTypeName = issueTypeName;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @Override
    public String toString() {
        return "IssueType{" + "issueTypeId=" + issueTypeId + ", issueTypeName=" + issueTypeName + ", statusList=" + statusList + '}';
    }

}
