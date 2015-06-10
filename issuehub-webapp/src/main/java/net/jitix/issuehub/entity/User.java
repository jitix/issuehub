package net.jitix.issuehub.entity;

public class User {

    private Integer userId;

    private String userName;

    private String email;

    private Boolean adminFlag;

    public User() {
    }

    public User(Integer userId, String userName, String email, Boolean adminFlag) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.adminFlag = adminFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Boolean adminFlag) {
        this.adminFlag = adminFlag;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", email=" + email + ", adminFlag=" + adminFlag + '}';
    }

}
