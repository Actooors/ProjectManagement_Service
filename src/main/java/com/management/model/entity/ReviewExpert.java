package com.management.model.entity;

public class ReviewExpert {
    private Integer reviewExpertId;

    private String expertId;

    private String expertName;

    private String score;

    private String reviewOpinion;

    private Integer finalOpinion;

    private Integer isFinished;

    private Integer projectApplicationId;

    public Integer getReviewExpertId() {
        return reviewExpertId;
    }

    public void setReviewExpertId(Integer reviewExpertId) {
        this.reviewExpertId = reviewExpertId;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getReviewOpinion() {
        return reviewOpinion;
    }

    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion == null ? null : reviewOpinion.trim();
    }

    public Integer getFinalOpinion() {
        return finalOpinion;
    }

    public void setFinalOpinion(Integer finalOpinion) {
        this.finalOpinion = finalOpinion;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    public Integer getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(Integer projectApplicationId) {
        this.projectApplicationId = projectApplicationId;
    }
}