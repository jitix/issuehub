package net.jitix.issuehub.entity;

import java.util.List;

public class Status {

    private String statusId;

    private String status;

    private List<String> substatusList;

    public Status() {
    }

    public Status(String statusId, String status, List<String> substatusList) {
        this.statusId = statusId;
        this.status = status;
        this.substatusList = substatusList;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSubstatusList() {
        return substatusList;
    }

    public void setSubstatusList(List<String> substatusList) {
        this.substatusList = substatusList;
    }

    @Override
    public String toString() {
        return "Status{" + "statusId=" + statusId + ", status=" + status + ", substatusList=" + substatusList + '}';
    }

}
