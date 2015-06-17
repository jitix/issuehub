package net.jitix.issuehub.vo;

public class IssueUpdationDetails {

    private SaveIssueDetails saveIssueDetails;

    private CommentDetails commentDetails;

    public IssueUpdationDetails() {
    }

    public IssueUpdationDetails(SaveIssueDetails saveIssueDetails, CommentDetails commentDetails) {
        this.saveIssueDetails = saveIssueDetails;
        this.commentDetails = commentDetails;
    }

    public SaveIssueDetails getSaveIssueDetails() {
        return saveIssueDetails;
    }

    public void setSaveIssueDetails(SaveIssueDetails saveIssueDetails) {
        this.saveIssueDetails = saveIssueDetails;
    }

    public CommentDetails getCommentDetails() {
        return commentDetails;
    }

    public void setCommentDetails(CommentDetails commentDetails) {
        this.commentDetails = commentDetails;
    }

    @Override
    public String toString() {
        return "IssueUpdationDetails{" + "saveIssueDetails=" + saveIssueDetails + ", commentDetails=" + commentDetails + '}';
    }
}
