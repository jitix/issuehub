package net.jitix.issuehub.entity;

public class Comment {

    private String userId;

    private Long timestamp;

    private String comment;

    public Comment() {
    }

    public Comment(String userId, Long timestamp, String comment) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "userId=" + userId + ", timestamp=" + timestamp + ", comment=" + comment + '}';
    }

}
