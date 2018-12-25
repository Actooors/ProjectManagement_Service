package com.management.model.entity;

public class ProjectCategoryExpert {
    private Integer projectExpertId;

    private String expertId;

    private String expertName;

    private String expertDepartment;

    private Integer projectCategoryId;

    public Integer getProjectExpertId() {
        return projectExpertId;
    }

    public void setProjectExpertId(Integer projectExpertId) {
        this.projectExpertId = projectExpertId;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId == null ? null : expertId.trim();
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName == null ? null : expertName.trim();
    }

    public String getExpertDepartment() {
        return expertDepartment;
    }

    public void setExpertDepartment(String expertDepartment) {
        this.expertDepartment = expertDepartment == null ? null : expertDepartment.trim();
    }

    public Integer getProjectCategoryId() {
        return projectCategoryId;
    }

    public void setProjectCategoryId(Integer projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
    }
}