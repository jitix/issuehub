package net.jitix.issuehub.vo;

public class CommentDetails {
    
    private String userId;

    private String comment;

    public CommentDetails() {
    }

    public CommentDetails(String userId, String comment) {
        this.userId = userId;
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentDetails{" + "userId=" + userId + ", comment=" + comment + '}';
    }
    
}
