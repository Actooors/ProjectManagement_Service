package com.management.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectModificationApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectModificationApplicationExample() {
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

        public Criteria andProjectModificationApplicationIdIsNull() {
            addCriterion("project_modification_application_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdIsNotNull() {
            addCriterion("project_modification_application_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdEqualTo(Integer value) {
            addCriterion("project_modification_application_id =", value, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdNotEqualTo(Integer value) {
            addCriterion("project_modification_application_id <>", value, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdGreaterThan(Integer value) {
            addCriterion("project_modification_application_id >", value, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_modification_application_id >=", value, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdLessThan(Integer value) {
            addCriterion("project_modification_application_id <", value, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_modification_application_id <=", value, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdIn(List<Integer> values) {
            addCriterion("project_modification_application_id in", values, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdNotIn(List<Integer> values) {
            addCriterion("project_modification_application_id not in", values, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("project_modification_application_id between", value1, value2, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andProjectModificationApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_modification_application_id not between", value1, value2, "projectModificationApplicationId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andModificationReasonIsNull() {
            addCriterion("modification_reason is null");
            return (Criteria) this;
        }

        public Criteria andModificationReasonIsNotNull() {
            addCriterion("modification_reason is not null");
            return (Criteria) this;
        }

        public Criteria andModificationReasonEqualTo(String value) {
            addCriterion("modification_reason =", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonNotEqualTo(String value) {
            addCriterion("modification_reason <>", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonGreaterThan(String value) {
            addCriterion("modification_reason >", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonGreaterThanOrEqualTo(String value) {
            addCriterion("modification_reason >=", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonLessThan(String value) {
            addCriterion("modification_reason <", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonLessThanOrEqualTo(String value) {
            addCriterion("modification_reason <=", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonLike(String value) {
            addCriterion("modification_reason like", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonNotLike(String value) {
            addCriterion("modification_reason not like", value, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonIn(List<String> values) {
            addCriterion("modification_reason in", values, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonNotIn(List<String> values) {
            addCriterion("modification_reason not in", values, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonBetween(String value1, String value2) {
            addCriterion("modification_reason between", value1, value2, "modificationReason");
            return (Criteria) this;
        }

        public Criteria andModificationReasonNotBetween(String value1, String value2) {
            addCriterion("modification_reason not between", value1, value2, "modificationReason");
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

        public Criteria andReviewPhaseIsNull() {
            addCriterion("review_phase is null");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseIsNotNull() {
            addCriterion("review_phase is not null");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseEqualTo(Integer value) {
            addCriterion("review_phase =", value, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseNotEqualTo(Integer value) {
            addCriterion("review_phase <>", value, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseGreaterThan(Integer value) {
            addCriterion("review_phase >", value, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_phase >=", value, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseLessThan(Integer value) {
            addCriterion("review_phase <", value, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseLessThanOrEqualTo(Integer value) {
            addCriterion("review_phase <=", value, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseIn(List<Integer> values) {
            addCriterion("review_phase in", values, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseNotIn(List<Integer> values) {
            addCriterion("review_phase not in", values, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseBetween(Integer value1, Integer value2) {
            addCriterion("review_phase between", value1, value2, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andReviewPhaseNotBetween(Integer value1, Integer value2) {
            addCriterion("review_phase not between", value1, value2, "reviewPhase");
            return (Criteria) this;
        }

        public Criteria andFailureReasonIsNull() {
            addCriterion("failure_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailureReasonIsNotNull() {
            addCriterion("failure_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailureReasonEqualTo(String value) {
            addCriterion("failure_reason =", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotEqualTo(String value) {
            addCriterion("failure_reason <>", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonGreaterThan(String value) {
            addCriterion("failure_reason >", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonGreaterThanOrEqualTo(String value) {
            addCriterion("failure_reason >=", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonLessThan(String value) {
            addCriterion("failure_reason <", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonLessThanOrEqualTo(String value) {
            addCriterion("failure_reason <=", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonLike(String value) {
            addCriterion("failure_reason like", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotLike(String value) {
            addCriterion("failure_reason not like", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonIn(List<String> values) {
            addCriterion("failure_reason in", values, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotIn(List<String> values) {
            addCriterion("failure_reason not in", values, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonBetween(String value1, String value2) {
            addCriterion("failure_reason between", value1, value2, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotBetween(String value1, String value2) {
            addCriterion("failure_reason not between", value1, value2, "failureReason");
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