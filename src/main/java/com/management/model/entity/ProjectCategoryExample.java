package com.management.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectCategoryExample() {
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

        public Criteria andProjectCategoryNameIsNull() {
            addCriterion("project_category_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameIsNotNull() {
            addCriterion("project_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameEqualTo(String value) {
            addCriterion("project_category_name =", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameNotEqualTo(String value) {
            addCriterion("project_category_name <>", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameGreaterThan(String value) {
            addCriterion("project_category_name >", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_category_name >=", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameLessThan(String value) {
            addCriterion("project_category_name <", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("project_category_name <=", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameLike(String value) {
            addCriterion("project_category_name like", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameNotLike(String value) {
            addCriterion("project_category_name not like", value, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameIn(List<String> values) {
            addCriterion("project_category_name in", values, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameNotIn(List<String> values) {
            addCriterion("project_category_name not in", values, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameBetween(String value1, String value2) {
            addCriterion("project_category_name between", value1, value2, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryNameNotBetween(String value1, String value2) {
            addCriterion("project_category_name not between", value1, value2, "projectCategoryName");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionIsNull() {
            addCriterion("project_category_description is null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionIsNotNull() {
            addCriterion("project_category_description is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionEqualTo(String value) {
            addCriterion("project_category_description =", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionNotEqualTo(String value) {
            addCriterion("project_category_description <>", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionGreaterThan(String value) {
            addCriterion("project_category_description >", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("project_category_description >=", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionLessThan(String value) {
            addCriterion("project_category_description <", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionLessThanOrEqualTo(String value) {
            addCriterion("project_category_description <=", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionLike(String value) {
            addCriterion("project_category_description like", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionNotLike(String value) {
            addCriterion("project_category_description not like", value, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionIn(List<String> values) {
            addCriterion("project_category_description in", values, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionNotIn(List<String> values) {
            addCriterion("project_category_description not in", values, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionBetween(String value1, String value2) {
            addCriterion("project_category_description between", value1, value2, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionNotBetween(String value1, String value2) {
            addCriterion("project_category_description not between", value1, value2, "projectCategoryDescription");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressIsNull() {
            addCriterion("project_category_description_address is null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressIsNotNull() {
            addCriterion("project_category_description_address is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressEqualTo(String value) {
            addCriterion("project_category_description_address =", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressNotEqualTo(String value) {
            addCriterion("project_category_description_address <>", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressGreaterThan(String value) {
            addCriterion("project_category_description_address >", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressGreaterThanOrEqualTo(String value) {
            addCriterion("project_category_description_address >=", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressLessThan(String value) {
            addCriterion("project_category_description_address <", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressLessThanOrEqualTo(String value) {
            addCriterion("project_category_description_address <=", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressLike(String value) {
            addCriterion("project_category_description_address like", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressNotLike(String value) {
            addCriterion("project_category_description_address not like", value, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressIn(List<String> values) {
            addCriterion("project_category_description_address in", values, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressNotIn(List<String> values) {
            addCriterion("project_category_description_address not in", values, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressBetween(String value1, String value2) {
            addCriterion("project_category_description_address between", value1, value2, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryDescriptionAddressNotBetween(String value1, String value2) {
            addCriterion("project_category_description_address not between", value1, value2, "projectCategoryDescriptionAddress");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(Integer value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(Integer value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(Integer value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(Integer value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<Integer> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<Integer> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdIsNull() {
            addCriterion("principal_id is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdIsNotNull() {
            addCriterion("principal_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdEqualTo(String value) {
            addCriterion("principal_id =", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdNotEqualTo(String value) {
            addCriterion("principal_id <>", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdGreaterThan(String value) {
            addCriterion("principal_id >", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdGreaterThanOrEqualTo(String value) {
            addCriterion("principal_id >=", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdLessThan(String value) {
            addCriterion("principal_id <", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdLessThanOrEqualTo(String value) {
            addCriterion("principal_id <=", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdLike(String value) {
            addCriterion("principal_id like", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdNotLike(String value) {
            addCriterion("principal_id not like", value, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdIn(List<String> values) {
            addCriterion("principal_id in", values, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdNotIn(List<String> values) {
            addCriterion("principal_id not in", values, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdBetween(String value1, String value2) {
            addCriterion("principal_id between", value1, value2, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIdNotBetween(String value1, String value2) {
            addCriterion("principal_id not between", value1, value2, "principalId");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameIsNull() {
            addCriterion("principal_name is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameIsNotNull() {
            addCriterion("principal_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameEqualTo(String value) {
            addCriterion("principal_name =", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotEqualTo(String value) {
            addCriterion("principal_name <>", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameGreaterThan(String value) {
            addCriterion("principal_name >", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameGreaterThanOrEqualTo(String value) {
            addCriterion("principal_name >=", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameLessThan(String value) {
            addCriterion("principal_name <", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameLessThanOrEqualTo(String value) {
            addCriterion("principal_name <=", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameLike(String value) {
            addCriterion("principal_name like", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotLike(String value) {
            addCriterion("principal_name not like", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameIn(List<String> values) {
            addCriterion("principal_name in", values, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotIn(List<String> values) {
            addCriterion("principal_name not in", values, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameBetween(String value1, String value2) {
            addCriterion("principal_name between", value1, value2, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotBetween(String value1, String value2) {
            addCriterion("principal_name not between", value1, value2, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneIsNull() {
            addCriterion("principal_phone is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneIsNotNull() {
            addCriterion("principal_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneEqualTo(String value) {
            addCriterion("principal_phone =", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotEqualTo(String value) {
            addCriterion("principal_phone <>", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneGreaterThan(String value) {
            addCriterion("principal_phone >", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("principal_phone >=", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneLessThan(String value) {
            addCriterion("principal_phone <", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneLessThanOrEqualTo(String value) {
            addCriterion("principal_phone <=", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneLike(String value) {
            addCriterion("principal_phone like", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotLike(String value) {
            addCriterion("principal_phone not like", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneIn(List<String> values) {
            addCriterion("principal_phone in", values, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotIn(List<String> values) {
            addCriterion("principal_phone not in", values, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneBetween(String value1, String value2) {
            addCriterion("principal_phone between", value1, value2, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotBetween(String value1, String value2) {
            addCriterion("principal_phone not between", value1, value2, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIsNull() {
            addCriterion("applicant_type is null");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIsNotNull() {
            addCriterion("applicant_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeEqualTo(String value) {
            addCriterion("applicant_type =", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotEqualTo(String value) {
            addCriterion("applicant_type <>", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeGreaterThan(String value) {
            addCriterion("applicant_type >", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_type >=", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeLessThan(String value) {
            addCriterion("applicant_type <", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeLessThanOrEqualTo(String value) {
            addCriterion("applicant_type <=", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeLike(String value) {
            addCriterion("applicant_type like", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotLike(String value) {
            addCriterion("applicant_type not like", value, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeIn(List<String> values) {
            addCriterion("applicant_type in", values, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotIn(List<String> values) {
            addCriterion("applicant_type not in", values, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeBetween(String value1, String value2) {
            addCriterion("applicant_type between", value1, value2, "applicantType");
            return (Criteria) this;
        }

        public Criteria andApplicantTypeNotBetween(String value1, String value2) {
            addCriterion("applicant_type not between", value1, value2, "applicantType");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyIsNull() {
            addCriterion("max_money is null");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyIsNotNull() {
            addCriterion("max_money is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyEqualTo(String value) {
            addCriterion("max_money =", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyNotEqualTo(String value) {
            addCriterion("max_money <>", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyGreaterThan(String value) {
            addCriterion("max_money >", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("max_money >=", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyLessThan(String value) {
            addCriterion("max_money <", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyLessThanOrEqualTo(String value) {
            addCriterion("max_money <=", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyLike(String value) {
            addCriterion("max_money like", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyNotLike(String value) {
            addCriterion("max_money not like", value, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyIn(List<String> values) {
            addCriterion("max_money in", values, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyNotIn(List<String> values) {
            addCriterion("max_money not in", values, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyBetween(String value1, String value2) {
            addCriterion("max_money between", value1, value2, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyNotBetween(String value1, String value2) {
            addCriterion("max_money not between", value1, value2, "maxMoney");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdIsNull() {
            addCriterion("review_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdIsNotNull() {
            addCriterion("review_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdEqualTo(String value) {
            addCriterion("review_leader_id =", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdNotEqualTo(String value) {
            addCriterion("review_leader_id <>", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdGreaterThan(String value) {
            addCriterion("review_leader_id >", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdGreaterThanOrEqualTo(String value) {
            addCriterion("review_leader_id >=", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdLessThan(String value) {
            addCriterion("review_leader_id <", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdLessThanOrEqualTo(String value) {
            addCriterion("review_leader_id <=", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdLike(String value) {
            addCriterion("review_leader_id like", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdNotLike(String value) {
            addCriterion("review_leader_id not like", value, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdIn(List<String> values) {
            addCriterion("review_leader_id in", values, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdNotIn(List<String> values) {
            addCriterion("review_leader_id not in", values, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdBetween(String value1, String value2) {
            addCriterion("review_leader_id between", value1, value2, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderIdNotBetween(String value1, String value2) {
            addCriterion("review_leader_id not between", value1, value2, "reviewLeaderId");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameIsNull() {
            addCriterion("review_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameIsNotNull() {
            addCriterion("review_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameEqualTo(String value) {
            addCriterion("review_leader_name =", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameNotEqualTo(String value) {
            addCriterion("review_leader_name <>", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameGreaterThan(String value) {
            addCriterion("review_leader_name >", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("review_leader_name >=", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameLessThan(String value) {
            addCriterion("review_leader_name <", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("review_leader_name <=", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameLike(String value) {
            addCriterion("review_leader_name like", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameNotLike(String value) {
            addCriterion("review_leader_name not like", value, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameIn(List<String> values) {
            addCriterion("review_leader_name in", values, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameNotIn(List<String> values) {
            addCriterion("review_leader_name not in", values, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameBetween(String value1, String value2) {
            addCriterion("review_leader_name between", value1, value2, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andReviewLeaderNameNotBetween(String value1, String value2) {
            addCriterion("review_leader_name not between", value1, value2, "reviewLeaderName");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewIsNull() {
            addCriterion("is_exist_meeting_review is null");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewIsNotNull() {
            addCriterion("is_exist_meeting_review is not null");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewEqualTo(Integer value) {
            addCriterion("is_exist_meeting_review =", value, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewNotEqualTo(Integer value) {
            addCriterion("is_exist_meeting_review <>", value, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewGreaterThan(Integer value) {
            addCriterion("is_exist_meeting_review >", value, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_exist_meeting_review >=", value, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewLessThan(Integer value) {
            addCriterion("is_exist_meeting_review <", value, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewLessThanOrEqualTo(Integer value) {
            addCriterion("is_exist_meeting_review <=", value, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewIn(List<Integer> values) {
            addCriterion("is_exist_meeting_review in", values, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewNotIn(List<Integer> values) {
            addCriterion("is_exist_meeting_review not in", values, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewBetween(Integer value1, Integer value2) {
            addCriterion("is_exist_meeting_review between", value1, value2, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andIsExistMeetingReviewNotBetween(Integer value1, Integer value2) {
            addCriterion("is_exist_meeting_review not between", value1, value2, "isExistMeetingReview");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressIsNull() {
            addCriterion("project_application_download_address is null");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressIsNotNull() {
            addCriterion("project_application_download_address is not null");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressEqualTo(String value) {
            addCriterion("project_application_download_address =", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressNotEqualTo(String value) {
            addCriterion("project_application_download_address <>", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressGreaterThan(String value) {
            addCriterion("project_application_download_address >", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressGreaterThanOrEqualTo(String value) {
            addCriterion("project_application_download_address >=", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressLessThan(String value) {
            addCriterion("project_application_download_address <", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressLessThanOrEqualTo(String value) {
            addCriterion("project_application_download_address <=", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressLike(String value) {
            addCriterion("project_application_download_address like", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressNotLike(String value) {
            addCriterion("project_application_download_address not like", value, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressIn(List<String> values) {
            addCriterion("project_application_download_address in", values, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressNotIn(List<String> values) {
            addCriterion("project_application_download_address not in", values, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressBetween(String value1, String value2) {
            addCriterion("project_application_download_address between", value1, value2, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andProjectApplicationDownloadAddressNotBetween(String value1, String value2) {
            addCriterion("project_application_download_address not between", value1, value2, "projectApplicationDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeIsNull() {
            addCriterion("application_start_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeIsNotNull() {
            addCriterion("application_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeEqualTo(Date value) {
            addCriterion("application_start_time =", value, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeNotEqualTo(Date value) {
            addCriterion("application_start_time <>", value, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeGreaterThan(Date value) {
            addCriterion("application_start_time >", value, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("application_start_time >=", value, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeLessThan(Date value) {
            addCriterion("application_start_time <", value, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("application_start_time <=", value, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeIn(List<Date> values) {
            addCriterion("application_start_time in", values, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeNotIn(List<Date> values) {
            addCriterion("application_start_time not in", values, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeBetween(Date value1, Date value2) {
            addCriterion("application_start_time between", value1, value2, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("application_start_time not between", value1, value2, "applicationStartTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeIsNull() {
            addCriterion("application_end_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeIsNotNull() {
            addCriterion("application_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeEqualTo(Date value) {
            addCriterion("application_end_time =", value, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeNotEqualTo(Date value) {
            addCriterion("application_end_time <>", value, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeGreaterThan(Date value) {
            addCriterion("application_end_time >", value, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("application_end_time >=", value, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeLessThan(Date value) {
            addCriterion("application_end_time <", value, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("application_end_time <=", value, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeIn(List<Date> values) {
            addCriterion("application_end_time in", values, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeNotIn(List<Date> values) {
            addCriterion("application_end_time not in", values, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeBetween(Date value1, Date value2) {
            addCriterion("application_end_time between", value1, value2, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andApplicationEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("application_end_time not between", value1, value2, "applicationEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeIsNull() {
            addCriterion("project_start_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeIsNotNull() {
            addCriterion("project_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeEqualTo(Date value) {
            addCriterion("project_start_time =", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeNotEqualTo(Date value) {
            addCriterion("project_start_time <>", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeGreaterThan(Date value) {
            addCriterion("project_start_time >", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_start_time >=", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeLessThan(Date value) {
            addCriterion("project_start_time <", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_start_time <=", value, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeIn(List<Date> values) {
            addCriterion("project_start_time in", values, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeNotIn(List<Date> values) {
            addCriterion("project_start_time not in", values, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeBetween(Date value1, Date value2) {
            addCriterion("project_start_time between", value1, value2, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_start_time not between", value1, value2, "projectStartTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeIsNull() {
            addCriterion("project_end_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeIsNotNull() {
            addCriterion("project_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeEqualTo(Date value) {
            addCriterion("project_end_time =", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeNotEqualTo(Date value) {
            addCriterion("project_end_time <>", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeGreaterThan(Date value) {
            addCriterion("project_end_time >", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_end_time >=", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeLessThan(Date value) {
            addCriterion("project_end_time <", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_end_time <=", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeIn(List<Date> values) {
            addCriterion("project_end_time in", values, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeNotIn(List<Date> values) {
            addCriterion("project_end_time not in", values, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeBetween(Date value1, Date value2) {
            addCriterion("project_end_time between", value1, value2, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_end_time not between", value1, value2, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedIsNull() {
            addCriterion("is_interim_report_activated is null");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedIsNotNull() {
            addCriterion("is_interim_report_activated is not null");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedEqualTo(Integer value) {
            addCriterion("is_interim_report_activated =", value, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedNotEqualTo(Integer value) {
            addCriterion("is_interim_report_activated <>", value, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedGreaterThan(Integer value) {
            addCriterion("is_interim_report_activated >", value, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_interim_report_activated >=", value, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedLessThan(Integer value) {
            addCriterion("is_interim_report_activated <", value, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedLessThanOrEqualTo(Integer value) {
            addCriterion("is_interim_report_activated <=", value, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedIn(List<Integer> values) {
            addCriterion("is_interim_report_activated in", values, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedNotIn(List<Integer> values) {
            addCriterion("is_interim_report_activated not in", values, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedBetween(Integer value1, Integer value2) {
            addCriterion("is_interim_report_activated between", value1, value2, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsInterimReportActivatedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_interim_report_activated not between", value1, value2, "isInterimReportActivated");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeIsNull() {
            addCriterion("interim_report_start_time is null");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeIsNotNull() {
            addCriterion("interim_report_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeEqualTo(Date value) {
            addCriterion("interim_report_start_time =", value, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeNotEqualTo(Date value) {
            addCriterion("interim_report_start_time <>", value, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeGreaterThan(Date value) {
            addCriterion("interim_report_start_time >", value, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("interim_report_start_time >=", value, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeLessThan(Date value) {
            addCriterion("interim_report_start_time <", value, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("interim_report_start_time <=", value, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeIn(List<Date> values) {
            addCriterion("interim_report_start_time in", values, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeNotIn(List<Date> values) {
            addCriterion("interim_report_start_time not in", values, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeBetween(Date value1, Date value2) {
            addCriterion("interim_report_start_time between", value1, value2, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("interim_report_start_time not between", value1, value2, "interimReportStartTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeIsNull() {
            addCriterion("interim_report_end_time is null");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeIsNotNull() {
            addCriterion("interim_report_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeEqualTo(Date value) {
            addCriterion("interim_report_end_time =", value, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeNotEqualTo(Date value) {
            addCriterion("interim_report_end_time <>", value, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeGreaterThan(Date value) {
            addCriterion("interim_report_end_time >", value, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("interim_report_end_time >=", value, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeLessThan(Date value) {
            addCriterion("interim_report_end_time <", value, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("interim_report_end_time <=", value, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeIn(List<Date> values) {
            addCriterion("interim_report_end_time in", values, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeNotIn(List<Date> values) {
            addCriterion("interim_report_end_time not in", values, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeBetween(Date value1, Date value2) {
            addCriterion("interim_report_end_time between", value1, value2, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("interim_report_end_time not between", value1, value2, "interimReportEndTime");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressIsNull() {
            addCriterion("interim_report_download_address is null");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressIsNotNull() {
            addCriterion("interim_report_download_address is not null");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressEqualTo(String value) {
            addCriterion("interim_report_download_address =", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressNotEqualTo(String value) {
            addCriterion("interim_report_download_address <>", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressGreaterThan(String value) {
            addCriterion("interim_report_download_address >", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressGreaterThanOrEqualTo(String value) {
            addCriterion("interim_report_download_address >=", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressLessThan(String value) {
            addCriterion("interim_report_download_address <", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressLessThanOrEqualTo(String value) {
            addCriterion("interim_report_download_address <=", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressLike(String value) {
            addCriterion("interim_report_download_address like", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressNotLike(String value) {
            addCriterion("interim_report_download_address not like", value, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressIn(List<String> values) {
            addCriterion("interim_report_download_address in", values, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressNotIn(List<String> values) {
            addCriterion("interim_report_download_address not in", values, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressBetween(String value1, String value2) {
            addCriterion("interim_report_download_address between", value1, value2, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andInterimReportDownloadAddressNotBetween(String value1, String value2) {
            addCriterion("interim_report_download_address not between", value1, value2, "interimReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedIsNull() {
            addCriterion("is_concluding_report_activated is null");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedIsNotNull() {
            addCriterion("is_concluding_report_activated is not null");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedEqualTo(Integer value) {
            addCriterion("is_concluding_report_activated =", value, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedNotEqualTo(Integer value) {
            addCriterion("is_concluding_report_activated <>", value, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedGreaterThan(Integer value) {
            addCriterion("is_concluding_report_activated >", value, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_concluding_report_activated >=", value, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedLessThan(Integer value) {
            addCriterion("is_concluding_report_activated <", value, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedLessThanOrEqualTo(Integer value) {
            addCriterion("is_concluding_report_activated <=", value, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedIn(List<Integer> values) {
            addCriterion("is_concluding_report_activated in", values, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedNotIn(List<Integer> values) {
            addCriterion("is_concluding_report_activated not in", values, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedBetween(Integer value1, Integer value2) {
            addCriterion("is_concluding_report_activated between", value1, value2, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andIsConcludingReportActivatedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_concluding_report_activated not between", value1, value2, "isConcludingReportActivated");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeIsNull() {
            addCriterion("concluding_report_start_time is null");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeIsNotNull() {
            addCriterion("concluding_report_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeEqualTo(Date value) {
            addCriterion("concluding_report_start_time =", value, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeNotEqualTo(Date value) {
            addCriterion("concluding_report_start_time <>", value, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeGreaterThan(Date value) {
            addCriterion("concluding_report_start_time >", value, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("concluding_report_start_time >=", value, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeLessThan(Date value) {
            addCriterion("concluding_report_start_time <", value, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("concluding_report_start_time <=", value, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeIn(List<Date> values) {
            addCriterion("concluding_report_start_time in", values, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeNotIn(List<Date> values) {
            addCriterion("concluding_report_start_time not in", values, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeBetween(Date value1, Date value2) {
            addCriterion("concluding_report_start_time between", value1, value2, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("concluding_report_start_time not between", value1, value2, "concludingReportStartTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeIsNull() {
            addCriterion("concluding_report_end_time is null");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeIsNotNull() {
            addCriterion("concluding_report_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeEqualTo(Date value) {
            addCriterion("concluding_report_end_time =", value, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeNotEqualTo(Date value) {
            addCriterion("concluding_report_end_time <>", value, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeGreaterThan(Date value) {
            addCriterion("concluding_report_end_time >", value, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("concluding_report_end_time >=", value, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeLessThan(Date value) {
            addCriterion("concluding_report_end_time <", value, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("concluding_report_end_time <=", value, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeIn(List<Date> values) {
            addCriterion("concluding_report_end_time in", values, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeNotIn(List<Date> values) {
            addCriterion("concluding_report_end_time not in", values, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeBetween(Date value1, Date value2) {
            addCriterion("concluding_report_end_time between", value1, value2, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("concluding_report_end_time not between", value1, value2, "concludingReportEndTime");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressIsNull() {
            addCriterion("concluding_report_download_address is null");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressIsNotNull() {
            addCriterion("concluding_report_download_address is not null");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressEqualTo(String value) {
            addCriterion("concluding_report_download_address =", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressNotEqualTo(String value) {
            addCriterion("concluding_report_download_address <>", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressGreaterThan(String value) {
            addCriterion("concluding_report_download_address >", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressGreaterThanOrEqualTo(String value) {
            addCriterion("concluding_report_download_address >=", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressLessThan(String value) {
            addCriterion("concluding_report_download_address <", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressLessThanOrEqualTo(String value) {
            addCriterion("concluding_report_download_address <=", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressLike(String value) {
            addCriterion("concluding_report_download_address like", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressNotLike(String value) {
            addCriterion("concluding_report_download_address not like", value, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressIn(List<String> values) {
            addCriterion("concluding_report_download_address in", values, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressNotIn(List<String> values) {
            addCriterion("concluding_report_download_address not in", values, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressBetween(String value1, String value2) {
            addCriterion("concluding_report_download_address between", value1, value2, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andConcludingReportDownloadAddressNotBetween(String value1, String value2) {
            addCriterion("concluding_report_download_address not between", value1, value2, "concludingReportDownloadAddress");
            return (Criteria) this;
        }

        public Criteria andStatisticsIsNull() {
            addCriterion("statistics is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsIsNotNull() {
            addCriterion("statistics is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsEqualTo(Integer value) {
            addCriterion("statistics =", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsNotEqualTo(Integer value) {
            addCriterion("statistics <>", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsGreaterThan(Integer value) {
            addCriterion("statistics >", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistics >=", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsLessThan(Integer value) {
            addCriterion("statistics <", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsLessThanOrEqualTo(Integer value) {
            addCriterion("statistics <=", value, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsIn(List<Integer> values) {
            addCriterion("statistics in", values, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsNotIn(List<Integer> values) {
            addCriterion("statistics not in", values, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsBetween(Integer value1, Integer value2) {
            addCriterion("statistics between", value1, value2, "statistics");
            return (Criteria) this;
        }

        public Criteria andStatisticsNotBetween(Integer value1, Integer value2) {
            addCriterion("statistics not between", value1, value2, "statistics");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIsNull() {
            addCriterion("is_approved is null");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIsNotNull() {
            addCriterion("is_approved is not null");
            return (Criteria) this;
        }

        public Criteria andIsApprovedEqualTo(Integer value) {
            addCriterion("is_approved =", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotEqualTo(Integer value) {
            addCriterion("is_approved <>", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedGreaterThan(Integer value) {
            addCriterion("is_approved >", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_approved >=", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedLessThan(Integer value) {
            addCriterion("is_approved <", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedLessThanOrEqualTo(Integer value) {
            addCriterion("is_approved <=", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIn(List<Integer> values) {
            addCriterion("is_approved in", values, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotIn(List<Integer> values) {
            addCriterion("is_approved not in", values, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedBetween(Integer value1, Integer value2) {
            addCriterion("is_approved between", value1, value2, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_approved not between", value1, value2, "isApproved");
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

        public Criteria andReviewExpertIdIsNull() {
            addCriterion("review_expert_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdIsNotNull() {
            addCriterion("review_expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdEqualTo(String value) {
            addCriterion("review_expert_id =", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdNotEqualTo(String value) {
            addCriterion("review_expert_id <>", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdGreaterThan(String value) {
            addCriterion("review_expert_id >", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdGreaterThanOrEqualTo(String value) {
            addCriterion("review_expert_id >=", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdLessThan(String value) {
            addCriterion("review_expert_id <", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdLessThanOrEqualTo(String value) {
            addCriterion("review_expert_id <=", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdLike(String value) {
            addCriterion("review_expert_id like", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdNotLike(String value) {
            addCriterion("review_expert_id not like", value, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdIn(List<String> values) {
            addCriterion("review_expert_id in", values, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdNotIn(List<String> values) {
            addCriterion("review_expert_id not in", values, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdBetween(String value1, String value2) {
            addCriterion("review_expert_id between", value1, value2, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andReviewExpertIdNotBetween(String value1, String value2) {
            addCriterion("review_expert_id not between", value1, value2, "reviewExpertId");
            return (Criteria) this;
        }

        public Criteria andExpertListIsNull() {
            addCriterion("expert_list is null");
            return (Criteria) this;
        }

        public Criteria andExpertListIsNotNull() {
            addCriterion("expert_list is not null");
            return (Criteria) this;
        }

        public Criteria andExpertListEqualTo(String value) {
            addCriterion("expert_list =", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListNotEqualTo(String value) {
            addCriterion("expert_list <>", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListGreaterThan(String value) {
            addCriterion("expert_list >", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListGreaterThanOrEqualTo(String value) {
            addCriterion("expert_list >=", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListLessThan(String value) {
            addCriterion("expert_list <", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListLessThanOrEqualTo(String value) {
            addCriterion("expert_list <=", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListLike(String value) {
            addCriterion("expert_list like", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListNotLike(String value) {
            addCriterion("expert_list not like", value, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListIn(List<String> values) {
            addCriterion("expert_list in", values, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListNotIn(List<String> values) {
            addCriterion("expert_list not in", values, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListBetween(String value1, String value2) {
            addCriterion("expert_list between", value1, value2, "expertList");
            return (Criteria) this;
        }

        public Criteria andExpertListNotBetween(String value1, String value2) {
            addCriterion("expert_list not between", value1, value2, "expertList");
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