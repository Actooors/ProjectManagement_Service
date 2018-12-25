package com.management.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectCategoryExpertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectCategoryExpertExample() {
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

        public Criteria andProjectExpertIdIsNull() {
            addCriterion("project_expert_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdIsNotNull() {
            addCriterion("project_expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdEqualTo(Integer value) {
            addCriterion("project_expert_id =", value, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdNotEqualTo(Integer value) {
            addCriterion("project_expert_id <>", value, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdGreaterThan(Integer value) {
            addCriterion("project_expert_id >", value, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_expert_id >=", value, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdLessThan(Integer value) {
            addCriterion("project_expert_id <", value, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_expert_id <=", value, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdIn(List<Integer> values) {
            addCriterion("project_expert_id in", values, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdNotIn(List<Integer> values) {
            addCriterion("project_expert_id not in", values, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdBetween(Integer value1, Integer value2) {
            addCriterion("project_expert_id between", value1, value2, "projectExpertId");
            return (Criteria) this;
        }

        public Criteria andProjectExpertIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_expert_id not between", value1, value2, "projectExpertId");
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

        public Criteria andExpertNameIsNull() {
            addCriterion("expert_name is null");
            return (Criteria) this;
        }

        public Criteria andExpertNameIsNotNull() {
            addCriterion("expert_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpertNameEqualTo(String value) {
            addCriterion("expert_name =", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotEqualTo(String value) {
            addCriterion("expert_name <>", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThan(String value) {
            addCriterion("expert_name >", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThanOrEqualTo(String value) {
            addCriterion("expert_name >=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThan(String value) {
            addCriterion("expert_name <", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThanOrEqualTo(String value) {
            addCriterion("expert_name <=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLike(String value) {
            addCriterion("expert_name like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotLike(String value) {
            addCriterion("expert_name not like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameIn(List<String> values) {
            addCriterion("expert_name in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotIn(List<String> values) {
            addCriterion("expert_name not in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameBetween(String value1, String value2) {
            addCriterion("expert_name between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotBetween(String value1, String value2) {
            addCriterion("expert_name not between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentIsNull() {
            addCriterion("expert_department is null");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentIsNotNull() {
            addCriterion("expert_department is not null");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentEqualTo(String value) {
            addCriterion("expert_department =", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentNotEqualTo(String value) {
            addCriterion("expert_department <>", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentGreaterThan(String value) {
            addCriterion("expert_department >", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("expert_department >=", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentLessThan(String value) {
            addCriterion("expert_department <", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentLessThanOrEqualTo(String value) {
            addCriterion("expert_department <=", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentLike(String value) {
            addCriterion("expert_department like", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentNotLike(String value) {
            addCriterion("expert_department not like", value, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentIn(List<String> values) {
            addCriterion("expert_department in", values, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentNotIn(List<String> values) {
            addCriterion("expert_department not in", values, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentBetween(String value1, String value2) {
            addCriterion("expert_department between", value1, value2, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andExpertDepartmentNotBetween(String value1, String value2) {
            addCriterion("expert_department not between", value1, value2, "expertDepartment");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdIsNull() {
            addCriterion("project_category_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdIsNotNull() {
            addCriterion("project_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdEqualTo(Integer value) {
            addCriterion("project_category_id =", value, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdNotEqualTo(Integer value) {
            addCriterion("project_category_id <>", value, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdGreaterThan(Integer value) {
            addCriterion("project_category_id >", value, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_category_id >=", value, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdLessThan(Integer value) {
            addCriterion("project_category_id <", value, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_category_id <=", value, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdIn(List<Integer> values) {
            addCriterion("project_category_id in", values, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdNotIn(List<Integer> values) {
            addCriterion("project_category_id not in", values, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("project_category_id between", value1, value2, "projectCategoryId");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_category_id not between", value1, value2, "projectCategoryId");
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