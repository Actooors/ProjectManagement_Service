package com.management.model.entity;

public class ReviewExpert extends ReviewExpertKey {
    private String score;

    private String reviewOpinion;

    private Integer finalOpinion;

    private Integer isFinished;

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
}