package net.jitix.issuehub.vo;

public class UserSaveDetails {

    private String userName;

    private String email;

    private String password;

    private Boolean adminFlag;

    public UserSaveDetails() {
    }

    public UserSaveDetails(String userName, String email, String password, Boolean adminFlag) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.adminFlag = adminFlag;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Boolean adminFlag) {
        this.adminFlag = adminFlag;
    }

    @Override
    public String toString() {
        return "UserSaveDetails{userName=" + userName + ", email=" + email + ", password=" + password + ", adminFlag=" + adminFlag + '}';
    }

}
