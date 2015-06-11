package net.jitix.issuehub.vo;

public class UserDetails {

    private String userId;

    private String userName;

    private String email;

    private Boolean adminFlag;

    public UserDetails() {
    }

    public UserDetails(String userId, String userName, String email, Boolean adminFlag) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.adminFlag = adminFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
        return "UserDetails{" + "userId=" + userId + ", userName=" + userName + ", email=" + email + ", adminFlag=" + adminFlag + '}';
    }

}
