package net.jitix.issuehub.vo;

import java.util.List;

public class IssueUpdationDetails {

    private SaveIssueDetails saveIssueDetails;

    private List<CommentDetails> commentsList;

    public IssueUpdationDetails() {
    }

    public IssueUpdationDetails(SaveIssueDetails saveIssueDetails, List<CommentDetails> commentsList) {
        this.saveIssueDetails = saveIssueDetails;
        this.commentsList = commentsList;
    }

    public SaveIssueDetails getSaveIssueDetails() {
        return saveIssueDetails;
    }

    public void setSaveIssueDetails(SaveIssueDetails saveIssueDetails) {
        this.saveIssueDetails = saveIssueDetails;
    }

    public List<CommentDetails> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<CommentDetails> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public String toString() {
        return "IssueUpdationDetails{" + "saveIssueDetails=" + saveIssueDetails + ", commentsList=" + commentsList + '}';
    }

}
