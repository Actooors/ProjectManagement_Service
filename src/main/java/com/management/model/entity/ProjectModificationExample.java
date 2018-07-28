package com.management.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectModificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectModificationExample() {
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

        public Criteria andProjectModificaitonIdIsNull() {
            addCriterion("project_modificaiton_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdIsNotNull() {
            addCriterion("project_modificaiton_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdEqualTo(Integer value) {
            addCriterion("project_modificaiton_id =", value, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdNotEqualTo(Integer value) {
            addCriterion("project_modificaiton_id <>", value, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdGreaterThan(Integer value) {
            addCriterion("project_modificaiton_id >", value, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_modificaiton_id >=", value, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdLessThan(Integer value) {
            addCriterion("project_modificaiton_id <", value, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_modificaiton_id <=", value, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdIn(List<Integer> values) {
            addCriterion("project_modificaiton_id in", values, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdNotIn(List<Integer> values) {
            addCriterion("project_modificaiton_id not in", values, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdBetween(Integer value1, Integer value2) {
            addCriterion("project_modificaiton_id between", value1, value2, "projectModificaitonId");
            return (Criteria) this;
        }

        public Criteria andProjectModificaitonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_modificaiton_id not between", value1, value2, "projectModificaitonId");
            return (Criteria) this;
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

        public Criteria andIsPassedIsNull() {
            addCriterion("is_passed is null");
            return (Criteria) this;
        }

        public Criteria andIsPassedIsNotNull() {
            addCriterion("is_passed is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassedEqualTo(Integer value) {
            addCriterion("is_passed =", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedNotEqualTo(Integer value) {
            addCriterion("is_passed <>", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedGreaterThan(Integer value) {
            addCriterion("is_passed >", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_passed >=", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedLessThan(Integer value) {
            addCriterion("is_passed <", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedLessThanOrEqualTo(Integer value) {
            addCriterion("is_passed <=", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedIn(List<Integer> values) {
            addCriterion("is_passed in", values, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedNotIn(List<Integer> values) {
            addCriterion("is_passed not in", values, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedBetween(Integer value1, Integer value2) {
            addCriterion("is_passed between", value1, value2, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_passed not between", value1, value2, "isPassed");
            return (Criteria) this;
        }

        public Criteria andModificationMessageIsNull() {
            addCriterion("modification_message is null");
            return (Criteria) this;
        }

        public Criteria andModificationMessageIsNotNull() {
            addCriterion("modification_message is not null");
            return (Criteria) this;
        }

        public Criteria andModificationMessageEqualTo(String value) {
            addCriterion("modification_message =", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageNotEqualTo(String value) {
            addCriterion("modification_message <>", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageGreaterThan(String value) {
            addCriterion("modification_message >", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageGreaterThanOrEqualTo(String value) {
            addCriterion("modification_message >=", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageLessThan(String value) {
            addCriterion("modification_message <", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageLessThanOrEqualTo(String value) {
            addCriterion("modification_message <=", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageLike(String value) {
            addCriterion("modification_message like", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageNotLike(String value) {
            addCriterion("modification_message not like", value, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageIn(List<String> values) {
            addCriterion("modification_message in", values, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageNotIn(List<String> values) {
            addCriterion("modification_message not in", values, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageBetween(String value1, String value2) {
            addCriterion("modification_message between", value1, value2, "modificationMessage");
            return (Criteria) this;
        }

        public Criteria andModificationMessageNotBetween(String value1, String value2) {
            addCriterion("modification_message not between", value1, value2, "modificationMessage");
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