package net.jitix.issuehub.entity;

import java.util.List;

public class Status {

    private String status;

    private List<String> substatusList;

    public Status() {
    }

    public Status(String status, List<String> substatusList) {
        this.status = status;
        this.substatusList = substatusList;
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
        return "Status{status=" + status + ", substatusList=" + substatusList + '}';
    }

}
