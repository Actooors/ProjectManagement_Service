package com.management.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ReviewExpertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReviewExpertExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andReviewExpertIdIsNull() {
            addCriterion("review_expert_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdIsNotNull() {
            addCriterion("review_expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdEqualTo(Integer value) {
            addCriterion("review_expert_id =", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdNotEqualTo(Integer value) {
            addCriterion("review_expert_id <>", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdGreaterThan(Integer value) {
            addCriterion("review_expert_id >", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_expert_id >=", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdLessThan(Integer value) {
            addCriterion("review_expert_id <", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdLessThanOrEqualTo(Integer value) {
            addCriterion("review_expert_id <=", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdIn(List<Integer> values) {
            addCriterion("review_expert_id in", values, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdNotIn(List<Integer> values) {
            addCriterion("review_expert_id not in", values, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdBetween(Integer value1, Integer value2) {
            addCriterion("review_expert_id between", value1, value2, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdNotBetween(Integer value1, Integer value2) {
            addCriterion("review_expert_id not between", value1, value2, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNull() {
            addCriterion("expert_id is null");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNotNull() {
            addCriterion("expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpertIdEqualTo(String value) {
            addCriterion("expert_id =", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotEqualTo(String value) {
            addCriterion("expert_id <>", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThan(String value) {
            addCriterion("expert_id >", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThanOrEqualTo(String value) {
            addCriterion("expert_id >=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThan(String value) {
            addCriterion("expert_id <", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThanOrEqualTo(String value) {
            addCriterion("expert_id <=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLike(String value) {
            addCriterion("expert_id like", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotLike(String value) {
            addCriterion("expert_id not like", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIn(List<String> values) {
            addCriterion("expert_id in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotIn(List<String> values) {
            addCriterion("expert_id not in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdBetween(String value1, String value2) {
            addCriterion("expert_id between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotBetween(String value1, String value2) {
            addCriterion("expert_id not between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdIsNull() {
            addCriterion("project_application_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdIsNotNull() {
            addCriterion("project_application_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdEqualTo(Integer value) {
            addCriterion("project_application_id =", value, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdNotEqualTo(Integer value) {
            addCriterion("project_application_id <>", value, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdGreaterThan(Integer value) {
            addCriterion("project_application_id >", value, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_application_id >=", value, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdLessThan(Integer value) {
            addCriterion("project_application_id <", value, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_application_id <=", value, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdIn(List<Integer> values) {
            addCriterion("project_application_id in", values, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdNotIn(List<Integer> values) {
            addCriterion("project_application_id not in", values, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("project_application_id between", value1, value2, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_application_id not between", value1, value2, "projectApplicationId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionIsNull() {
            addCriterion("review_opinion is null");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionIsNotNull() {
            addCriterion("review_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionEqualTo(String value) {
            addCriterion("review_opinion =", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotEqualTo(String value) {
            addCriterion("review_opinion <>", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionGreaterThan(String value) {
            addCriterion("review_opinion >", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("review_opinion >=", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionLessThan(String value) {
            addCriterion("review_opinion <", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionLessThanOrEqualTo(String value) {
            addCriterion("review_opinion <=", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionLike(String value) {
            addCriterion("review_opinion like", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotLike(String value) {
            addCriterion("review_opinion not like", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionIn(List<String> values) {
            addCriterion("review_opinion in", values, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotIn(List<String> values) {
            addCriterion("review_opinion not in", values, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionBetween(String value1, String value2) {
            addCriterion("review_opinion between", value1, value2, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotBetween(String value1, String value2) {
            addCriterion("review_opinion not between", value1, value2, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionIsNull() {
            addCriterion("final_opinion is null");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionIsNotNull() {
            addCriterion("final_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionEqualTo(Integer value) {
            addCriterion("final_opinion =", value, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionNotEqualTo(Integer value) {
            addCriterion("final_opinion <>", value, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionGreaterThan(Integer value) {
            addCriterion("final_opinion >", value, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionGreaterThanOrEqualTo(Integer value) {
            addCriterion("final_opinion >=", value, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionLessThan(Integer value) {
            addCriterion("final_opinion <", value, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionLessThanOrEqualTo(Integer value) {
            addCriterion("final_opinion <=", value, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionIn(List<Integer> values) {
            addCriterion("final_opinion in", values, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionNotIn(List<Integer> values) {
            addCriterion("final_opinion not in", values, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionBetween(Integer value1, Integer value2) {
            addCriterion("final_opinion between", value1, value2, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andFinalOpinionNotBetween(Integer value1, Integer value2) {
            addCriterion("final_opinion not between", value1, value2, "finalOpinion");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNull() {
            addCriterion("is_finished is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNotNull() {
            addCriterion("is_finished is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedEqualTo(Integer value) {
            addCriterion("is_finished =", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotEqualTo(Integer value) {
            addCriterion("is_finished <>", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThan(Integer value) {
            addCriterion("is_finished >", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_finished >=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThan(Integer value) {
            addCriterion("is_finished <", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThanOrEqualTo(Integer value) {
            addCriterion("is_finished <=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIn(List<Integer> values) {
            addCriterion("is_finished in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotIn(List<Integer> values) {
            addCriterion("is_finished not in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedBetween(Integer value1, Integer value2) {
            addCriterion("is_finished between", value1, value2, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_finished not between", value1, value2, "isFinished");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}