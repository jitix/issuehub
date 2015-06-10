package net.jitix.issuehub.entity;

public class Project {

    private Integer projectId;

    private String projectName;

    public Project() {
    }

    public Project(Integer projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" + "projectId=" + projectId + ", projectName=" + projectName + '}';
    }

}
