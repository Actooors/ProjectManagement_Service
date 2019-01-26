package com.management.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectApplicationExample() {
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectMemberIsNull() {
            addCriterion("project_member is null");
            return (Criteria) this;
        }

        public Criteria andProjectMemberIsNotNull() {
            addCriterion("project_member is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMemberEqualTo(String value) {
            addCriterion("project_member =", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberNotEqualTo(String value) {
            addCriterion("project_member <>", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberGreaterThan(String value) {
            addCriterion("project_member >", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberGreaterThanOrEqualTo(String value) {
            addCriterion("project_member >=", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberLessThan(String value) {
            addCriterion("project_member <", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberLessThanOrEqualTo(String value) {
            addCriterion("project_member <=", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberLike(String value) {
            addCriterion("project_member like", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberNotLike(String value) {
            addCriterion("project_member not like", value, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberIn(List<String> values) {
            addCriterion("project_member in", values, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberNotIn(List<String> values) {
            addCriterion("project_member not in", values, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberBetween(String value1, String value2) {
            addCriterion("project_member between", value1, value2, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectMemberNotBetween(String value1, String value2) {
            addCriterion("project_member not between", value1, value2, "projectMember");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionIsNull() {
            addCriterion("project_description is null");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionIsNotNull() {
            addCriterion("project_description is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionEqualTo(String value) {
            addCriterion("project_description =", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotEqualTo(String value) {
            addCriterion("project_description <>", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionGreaterThan(String value) {
            addCriterion("project_description >", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("project_description >=", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionLessThan(String value) {
            addCriterion("project_description <", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionLessThanOrEqualTo(String value) {
            addCriterion("project_description <=", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionLike(String value) {
            addCriterion("project_description like", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotLike(String value) {
            addCriterion("project_description not like", value, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionIn(List<String> values) {
            addCriterion("project_description in", values, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotIn(List<String> values) {
            addCriterion("project_description not in", values, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionBetween(String value1, String value2) {
            addCriterion("project_description between", value1, value2, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectDescriptionNotBetween(String value1, String value2) {
            addCriterion("project_description not between", value1, value2, "projectDescription");
            return (Criteria) this;
        }

        public Criteria andProjectIndexIsNull() {
            addCriterion("project_index is null");
            return (Criteria) this;
        }

        public Criteria andProjectIndexIsNotNull() {
            addCriterion("project_index is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIndexEqualTo(String value) {
            addCriterion("project_index =", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexNotEqualTo(String value) {
            addCriterion("project_index <>", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexGreaterThan(String value) {
            addCriterion("project_index >", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexGreaterThanOrEqualTo(String value) {
            addCriterion("project_index >=", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexLessThan(String value) {
            addCriterion("project_index <", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexLessThanOrEqualTo(String value) {
            addCriterion("project_index <=", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexLike(String value) {
            addCriterion("project_index like", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexNotLike(String value) {
            addCriterion("project_index not like", value, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexIn(List<String> values) {
            addCriterion("project_index in", values, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexNotIn(List<String> values) {
            addCriterion("project_index not in", values, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexBetween(String value1, String value2) {
            addCriterion("project_index between", value1, value2, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexNotBetween(String value1, String value2) {
            addCriterion("project_index not between", value1, value2, "projectIndex");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateIsNull() {
            addCriterion("project_index_state is null");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateIsNotNull() {
            addCriterion("project_index_state is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateEqualTo(Boolean value) {
            addCriterion("project_index_state =", value, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateNotEqualTo(Boolean value) {
            addCriterion("project_index_state <>", value, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateGreaterThan(Boolean value) {
            addCriterion("project_index_state >", value, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("project_index_state >=", value, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateLessThan(Boolean value) {
            addCriterion("project_index_state <", value, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateLessThanOrEqualTo(Boolean value) {
            addCriterion("project_index_state <=", value, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateIn(List<Boolean> values) {
            addCriterion("project_index_state in", values, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateNotIn(List<Boolean> values) {
            addCriterion("project_index_state not in", values, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateBetween(Boolean value1, Boolean value2) {
            addCriterion("project_index_state between", value1, value2, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectIndexStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("project_index_state not between", value1, value2, "projectIndexState");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNull() {
            addCriterion("project_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNotNull() {
            addCriterion("project_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyEqualTo(Integer value) {
            addCriterion("project_money =", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotEqualTo(Integer value) {
            addCriterion("project_money <>", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThan(Integer value) {
            addCriterion("project_money >", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_money >=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThan(Integer value) {
            addCriterion("project_money <", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("project_money <=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIn(List<Integer> values) {
            addCriterion("project_money in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotIn(List<Integer> values) {
            addCriterion("project_money not in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyBetween(Integer value1, Integer value2) {
            addCriterion("project_money between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("project_money not between", value1, value2, "projectMoney");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressIsNull() {
            addCriterion("project_application_upload_address is null");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressIsNotNull() {
            addCriterion("project_application_upload_address is not null");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressEqualTo(String value) {
            addCriterion("project_application_upload_address =", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressNotEqualTo(String value) {
            addCriterion("project_application_upload_address <>", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressGreaterThan(String value) {
            addCriterion("project_application_upload_address >", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressGreaterThanOrEqualTo(String value) {
            addCriterion("project_application_upload_address >=", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressLessThan(String value) {
            addCriterion("project_application_upload_address <", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressLessThanOrEqualTo(String value) {
            addCriterion("project_application_upload_address <=", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressLike(String value) {
            addCriterion("project_application_upload_address like", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressNotLike(String value) {
            addCriterion("project_application_upload_address not like", value, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressIn(List<String> values) {
            addCriterion("project_application_upload_address in", values, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressNotIn(List<String> values) {
            addCriterion("project_application_upload_address not in", values, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressBetween(String value1, String value2) {
            addCriterion("project_application_upload_address between", value1, value2, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationUploadAddressNotBetween(String value1, String value2) {
            addCriterion("project_application_upload_address not between", value1, value2, "projectApplicationUploadAddress");
            return (Criteria) this;
        }

        public Criteria andIsMeetingIsNull() {
            addCriterion("is_meeting is null");
            return (Criteria) this;
        }

        public Criteria andIsMeetingIsNotNull() {
            addCriterion("is_meeting is not null");
            return (Criteria) this;
        }

        public Criteria andIsMeetingEqualTo(Integer value) {
            addCriterion("is_meeting =", value, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingNotEqualTo(Integer value) {
            addCriterion("is_meeting <>", value, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingGreaterThan(Integer value) {
            addCriterion("is_meeting >", value, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_meeting >=", value, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingLessThan(Integer value) {
            addCriterion("is_meeting <", value, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingLessThanOrEqualTo(Integer value) {
            addCriterion("is_meeting <=", value, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingIn(List<Integer> values) {
            addCriterion("is_meeting in", values, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingNotIn(List<Integer> values) {
            addCriterion("is_meeting not in", values, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingBetween(Integer value1, Integer value2) {
            addCriterion("is_meeting between", value1, value2, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andIsMeetingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_meeting not between", value1, value2, "isMeeting");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageIsNull() {
            addCriterion("meeting_review_message is null");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageIsNotNull() {
            addCriterion("meeting_review_message is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageEqualTo(String value) {
            addCriterion("meeting_review_message =", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageNotEqualTo(String value) {
            addCriterion("meeting_review_message <>", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageGreaterThan(String value) {
            addCriterion("meeting_review_message >", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_review_message >=", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageLessThan(String value) {
            addCriterion("meeting_review_message <", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageLessThanOrEqualTo(String value) {
            addCriterion("meeting_review_message <=", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageLike(String value) {
            addCriterion("meeting_review_message like", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageNotLike(String value) {
            addCriterion("meeting_review_message not like", value, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageIn(List<String> values) {
            addCriterion("meeting_review_message in", values, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageNotIn(List<String> values) {
            addCriterion("meeting_review_message not in", values, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageBetween(String value1, String value2) {
            addCriterion("meeting_review_message between", value1, value2, "meetingReviewMessage");
            return (Criteria) this;
        }

        public Criteria andMeetingReviewMessageNotBetween(String value1, String value2) {
            addCriterion("meeting_review_message not between", value1, value2, "meetingReviewMessage");
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

        public Criteria andApplicationTimeIsNull() {
            addCriterion("application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(Date value) {
            addCriterion("application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(Date value) {
            addCriterion("application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(Date value) {
            addCriterion("application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(Date value) {
            addCriterion("application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<Date> values) {
            addCriterion("application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<Date> values) {
            addCriterion("application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("application_time not between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineIsNull() {
            addCriterion("application_deadline is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineIsNotNull() {
            addCriterion("application_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineEqualTo(Date value) {
            addCriterion("application_deadline =", value, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineNotEqualTo(Date value) {
            addCriterion("application_deadline <>", value, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineGreaterThan(Date value) {
            addCriterion("application_deadline >", value, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("application_deadline >=", value, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineLessThan(Date value) {
            addCriterion("application_deadline <", value, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("application_deadline <=", value, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineIn(List<Date> values) {
            addCriterion("application_deadline in", values, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineNotIn(List<Date> values) {
            addCriterion("application_deadline not in", values, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineBetween(Date value1, Date value2) {
            addCriterion("application_deadline between", value1, value2, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andApplicationDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("application_deadline not between", value1, value2, "applicationDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineIsNull() {
            addCriterion("middle_deadline is null");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineIsNotNull() {
            addCriterion("middle_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineEqualTo(Date value) {
            addCriterion("middle_deadline =", value, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineNotEqualTo(Date value) {
            addCriterion("middle_deadline <>", value, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineGreaterThan(Date value) {
            addCriterion("middle_deadline >", value, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("middle_deadline >=", value, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineLessThan(Date value) {
            addCriterion("middle_deadline <", value, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("middle_deadline <=", value, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineIn(List<Date> values) {
            addCriterion("middle_deadline in", values, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineNotIn(List<Date> values) {
            addCriterion("middle_deadline not in", values, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineBetween(Date value1, Date value2) {
            addCriterion("middle_deadline between", value1, value2, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andMiddleDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("middle_deadline not between", value1, value2, "middleDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineIsNull() {
            addCriterion("final_deadline is null");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineIsNotNull() {
            addCriterion("final_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineEqualTo(Date value) {
            addCriterion("final_deadline =", value, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineNotEqualTo(Date value) {
            addCriterion("final_deadline <>", value, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineGreaterThan(Date value) {
            addCriterion("final_deadline >", value, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("final_deadline >=", value, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineLessThan(Date value) {
            addCriterion("final_deadline <", value, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("final_deadline <=", value, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineIn(List<Date> values) {
            addCriterion("final_deadline in", values, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineNotIn(List<Date> values) {
            addCriterion("final_deadline not in", values, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineBetween(Date value1, Date value2) {
            addCriterion("final_deadline between", value1, value2, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andFinalDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("final_deadline not between", value1, value2, "finalDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineIsNull() {
            addCriterion("project_deadline is null");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineIsNotNull() {
            addCriterion("project_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineEqualTo(Date value) {
            addCriterion("project_deadline =", value, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineNotEqualTo(Date value) {
            addCriterion("project_deadline <>", value, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineGreaterThan(Date value) {
            addCriterion("project_deadline >", value, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("project_deadline >=", value, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineLessThan(Date value) {
            addCriterion("project_deadline <", value, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("project_deadline <=", value, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineIn(List<Date> values) {
            addCriterion("project_deadline in", values, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineNotIn(List<Date> values) {
            addCriterion("project_deadline not in", values, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineBetween(Date value1, Date value2) {
            addCriterion("project_deadline between", value1, value2, "projectDeadline");
            return (Criteria) this;
        }

        public Criteria andProjectDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("project_deadline not between", value1, value2, "projectDeadline");
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