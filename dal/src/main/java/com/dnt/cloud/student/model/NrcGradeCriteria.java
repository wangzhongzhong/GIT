package com.dnt.cloud.student.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NrcGradeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NrcGradeCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdIsNull() {
            addCriterion("NRC_EXAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdIsNotNull() {
            addCriterion("NRC_EXAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdEqualTo(Long value) {
            addCriterion("NRC_EXAM_ID =", value, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdNotEqualTo(Long value) {
            addCriterion("NRC_EXAM_ID <>", value, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdGreaterThan(Long value) {
            addCriterion("NRC_EXAM_ID >", value, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("NRC_EXAM_ID >=", value, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdLessThan(Long value) {
            addCriterion("NRC_EXAM_ID <", value, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdLessThanOrEqualTo(Long value) {
            addCriterion("NRC_EXAM_ID <=", value, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdIn(List<Long> values) {
            addCriterion("NRC_EXAM_ID in", values, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdNotIn(List<Long> values) {
            addCriterion("NRC_EXAM_ID not in", values, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdBetween(Long value1, Long value2) {
            addCriterion("NRC_EXAM_ID between", value1, value2, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcExamIdNotBetween(Long value1, Long value2) {
            addCriterion("NRC_EXAM_ID not between", value1, value2, "nrcExamId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdIsNull() {
            addCriterion("NRC_CLASS_ID is null");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdIsNotNull() {
            addCriterion("NRC_CLASS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdEqualTo(Long value) {
            addCriterion("NRC_CLASS_ID =", value, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdNotEqualTo(Long value) {
            addCriterion("NRC_CLASS_ID <>", value, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdGreaterThan(Long value) {
            addCriterion("NRC_CLASS_ID >", value, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("NRC_CLASS_ID >=", value, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdLessThan(Long value) {
            addCriterion("NRC_CLASS_ID <", value, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdLessThanOrEqualTo(Long value) {
            addCriterion("NRC_CLASS_ID <=", value, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdIn(List<Long> values) {
            addCriterion("NRC_CLASS_ID in", values, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdNotIn(List<Long> values) {
            addCriterion("NRC_CLASS_ID not in", values, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdBetween(Long value1, Long value2) {
            addCriterion("NRC_CLASS_ID between", value1, value2, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andNrcClassIdNotBetween(Long value1, Long value2) {
            addCriterion("NRC_CLASS_ID not between", value1, value2, "nrcClassId");
            return (Criteria) this;
        }

        public Criteria andTearIsNull() {
            addCriterion("TEAR is null");
            return (Criteria) this;
        }

        public Criteria andTearIsNotNull() {
            addCriterion("TEAR is not null");
            return (Criteria) this;
        }

        public Criteria andTearEqualTo(String value) {
            addCriterion("TEAR =", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearNotEqualTo(String value) {
            addCriterion("TEAR <>", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearGreaterThan(String value) {
            addCriterion("TEAR >", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearGreaterThanOrEqualTo(String value) {
            addCriterion("TEAR >=", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearLessThan(String value) {
            addCriterion("TEAR <", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearLessThanOrEqualTo(String value) {
            addCriterion("TEAR <=", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearLike(String value) {
            addCriterion("TEAR like", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearNotLike(String value) {
            addCriterion("TEAR not like", value, "tear");
            return (Criteria) this;
        }

        public Criteria andTearIn(List<String> values) {
            addCriterion("TEAR in", values, "tear");
            return (Criteria) this;
        }

        public Criteria andTearNotIn(List<String> values) {
            addCriterion("TEAR not in", values, "tear");
            return (Criteria) this;
        }

        public Criteria andTearBetween(String value1, String value2) {
            addCriterion("TEAR between", value1, value2, "tear");
            return (Criteria) this;
        }

        public Criteria andTearNotBetween(String value1, String value2) {
            addCriterion("TEAR not between", value1, value2, "tear");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMathIsNull() {
            addCriterion("MATH is null");
            return (Criteria) this;
        }

        public Criteria andMathIsNotNull() {
            addCriterion("MATH is not null");
            return (Criteria) this;
        }

        public Criteria andMathEqualTo(String value) {
            addCriterion("MATH =", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotEqualTo(String value) {
            addCriterion("MATH <>", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThan(String value) {
            addCriterion("MATH >", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThanOrEqualTo(String value) {
            addCriterion("MATH >=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThan(String value) {
            addCriterion("MATH <", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThanOrEqualTo(String value) {
            addCriterion("MATH <=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLike(String value) {
            addCriterion("MATH like", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotLike(String value) {
            addCriterion("MATH not like", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathIn(List<String> values) {
            addCriterion("MATH in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotIn(List<String> values) {
            addCriterion("MATH not in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathBetween(String value1, String value2) {
            addCriterion("MATH between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotBetween(String value1, String value2) {
            addCriterion("MATH not between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andChinessIsNull() {
            addCriterion("CHINESS is null");
            return (Criteria) this;
        }

        public Criteria andChinessIsNotNull() {
            addCriterion("CHINESS is not null");
            return (Criteria) this;
        }

        public Criteria andChinessEqualTo(String value) {
            addCriterion("CHINESS =", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessNotEqualTo(String value) {
            addCriterion("CHINESS <>", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessGreaterThan(String value) {
            addCriterion("CHINESS >", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessGreaterThanOrEqualTo(String value) {
            addCriterion("CHINESS >=", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessLessThan(String value) {
            addCriterion("CHINESS <", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessLessThanOrEqualTo(String value) {
            addCriterion("CHINESS <=", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessLike(String value) {
            addCriterion("CHINESS like", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessNotLike(String value) {
            addCriterion("CHINESS not like", value, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessIn(List<String> values) {
            addCriterion("CHINESS in", values, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessNotIn(List<String> values) {
            addCriterion("CHINESS not in", values, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessBetween(String value1, String value2) {
            addCriterion("CHINESS between", value1, value2, "chiness");
            return (Criteria) this;
        }

        public Criteria andChinessNotBetween(String value1, String value2) {
            addCriterion("CHINESS not between", value1, value2, "chiness");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNull() {
            addCriterion("ENGLISH is null");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNotNull() {
            addCriterion("ENGLISH is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishEqualTo(String value) {
            addCriterion("ENGLISH =", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotEqualTo(String value) {
            addCriterion("ENGLISH <>", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThan(String value) {
            addCriterion("ENGLISH >", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH >=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThan(String value) {
            addCriterion("ENGLISH <", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH <=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLike(String value) {
            addCriterion("ENGLISH like", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotLike(String value) {
            addCriterion("ENGLISH not like", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishIn(List<String> values) {
            addCriterion("ENGLISH in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotIn(List<String> values) {
            addCriterion("ENGLISH not in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishBetween(String value1, String value2) {
            addCriterion("ENGLISH between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotBetween(String value1, String value2) {
            addCriterion("ENGLISH not between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andPhysicsIsNull() {
            addCriterion("PHYSICS is null");
            return (Criteria) this;
        }

        public Criteria andPhysicsIsNotNull() {
            addCriterion("PHYSICS is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicsEqualTo(String value) {
            addCriterion("PHYSICS =", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotEqualTo(String value) {
            addCriterion("PHYSICS <>", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsGreaterThan(String value) {
            addCriterion("PHYSICS >", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsGreaterThanOrEqualTo(String value) {
            addCriterion("PHYSICS >=", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsLessThan(String value) {
            addCriterion("PHYSICS <", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsLessThanOrEqualTo(String value) {
            addCriterion("PHYSICS <=", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsLike(String value) {
            addCriterion("PHYSICS like", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotLike(String value) {
            addCriterion("PHYSICS not like", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsIn(List<String> values) {
            addCriterion("PHYSICS in", values, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotIn(List<String> values) {
            addCriterion("PHYSICS not in", values, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsBetween(String value1, String value2) {
            addCriterion("PHYSICS between", value1, value2, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotBetween(String value1, String value2) {
            addCriterion("PHYSICS not between", value1, value2, "physics");
            return (Criteria) this;
        }

        public Criteria andChemistryIsNull() {
            addCriterion("CHEMISTRY is null");
            return (Criteria) this;
        }

        public Criteria andChemistryIsNotNull() {
            addCriterion("CHEMISTRY is not null");
            return (Criteria) this;
        }

        public Criteria andChemistryEqualTo(String value) {
            addCriterion("CHEMISTRY =", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotEqualTo(String value) {
            addCriterion("CHEMISTRY <>", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryGreaterThan(String value) {
            addCriterion("CHEMISTRY >", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryGreaterThanOrEqualTo(String value) {
            addCriterion("CHEMISTRY >=", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryLessThan(String value) {
            addCriterion("CHEMISTRY <", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryLessThanOrEqualTo(String value) {
            addCriterion("CHEMISTRY <=", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryLike(String value) {
            addCriterion("CHEMISTRY like", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotLike(String value) {
            addCriterion("CHEMISTRY not like", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryIn(List<String> values) {
            addCriterion("CHEMISTRY in", values, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotIn(List<String> values) {
            addCriterion("CHEMISTRY not in", values, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryBetween(String value1, String value2) {
            addCriterion("CHEMISTRY between", value1, value2, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotBetween(String value1, String value2) {
            addCriterion("CHEMISTRY not between", value1, value2, "chemistry");
            return (Criteria) this;
        }

        public Criteria andContent1IsNull() {
            addCriterion("CONTENT1 is null");
            return (Criteria) this;
        }

        public Criteria andContent1IsNotNull() {
            addCriterion("CONTENT1 is not null");
            return (Criteria) this;
        }

        public Criteria andContent1EqualTo(String value) {
            addCriterion("CONTENT1 =", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotEqualTo(String value) {
            addCriterion("CONTENT1 <>", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1GreaterThan(String value) {
            addCriterion("CONTENT1 >", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1GreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT1 >=", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1LessThan(String value) {
            addCriterion("CONTENT1 <", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1LessThanOrEqualTo(String value) {
            addCriterion("CONTENT1 <=", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1Like(String value) {
            addCriterion("CONTENT1 like", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotLike(String value) {
            addCriterion("CONTENT1 not like", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1In(List<String> values) {
            addCriterion("CONTENT1 in", values, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotIn(List<String> values) {
            addCriterion("CONTENT1 not in", values, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1Between(String value1, String value2) {
            addCriterion("CONTENT1 between", value1, value2, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotBetween(String value1, String value2) {
            addCriterion("CONTENT1 not between", value1, value2, "content1");
            return (Criteria) this;
        }

        public Criteria andContent2IsNull() {
            addCriterion("CONTENT2 is null");
            return (Criteria) this;
        }

        public Criteria andContent2IsNotNull() {
            addCriterion("CONTENT2 is not null");
            return (Criteria) this;
        }

        public Criteria andContent2EqualTo(String value) {
            addCriterion("CONTENT2 =", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotEqualTo(String value) {
            addCriterion("CONTENT2 <>", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2GreaterThan(String value) {
            addCriterion("CONTENT2 >", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2GreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT2 >=", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2LessThan(String value) {
            addCriterion("CONTENT2 <", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2LessThanOrEqualTo(String value) {
            addCriterion("CONTENT2 <=", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2Like(String value) {
            addCriterion("CONTENT2 like", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotLike(String value) {
            addCriterion("CONTENT2 not like", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2In(List<String> values) {
            addCriterion("CONTENT2 in", values, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotIn(List<String> values) {
            addCriterion("CONTENT2 not in", values, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2Between(String value1, String value2) {
            addCriterion("CONTENT2 between", value1, value2, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotBetween(String value1, String value2) {
            addCriterion("CONTENT2 not between", value1, value2, "content2");
            return (Criteria) this;
        }

        public Criteria andContent3IsNull() {
            addCriterion("CONTENT3 is null");
            return (Criteria) this;
        }

        public Criteria andContent3IsNotNull() {
            addCriterion("CONTENT3 is not null");
            return (Criteria) this;
        }

        public Criteria andContent3EqualTo(String value) {
            addCriterion("CONTENT3 =", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotEqualTo(String value) {
            addCriterion("CONTENT3 <>", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3GreaterThan(String value) {
            addCriterion("CONTENT3 >", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3GreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT3 >=", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3LessThan(String value) {
            addCriterion("CONTENT3 <", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3LessThanOrEqualTo(String value) {
            addCriterion("CONTENT3 <=", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3Like(String value) {
            addCriterion("CONTENT3 like", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotLike(String value) {
            addCriterion("CONTENT3 not like", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3In(List<String> values) {
            addCriterion("CONTENT3 in", values, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotIn(List<String> values) {
            addCriterion("CONTENT3 not in", values, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3Between(String value1, String value2) {
            addCriterion("CONTENT3 between", value1, value2, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotBetween(String value1, String value2) {
            addCriterion("CONTENT3 not between", value1, value2, "content3");
            return (Criteria) this;
        }

        public Criteria andContent5IsNull() {
            addCriterion("CONTENT5 is null");
            return (Criteria) this;
        }

        public Criteria andContent5IsNotNull() {
            addCriterion("CONTENT5 is not null");
            return (Criteria) this;
        }

        public Criteria andContent5EqualTo(String value) {
            addCriterion("CONTENT5 =", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotEqualTo(String value) {
            addCriterion("CONTENT5 <>", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5GreaterThan(String value) {
            addCriterion("CONTENT5 >", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5GreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT5 >=", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5LessThan(String value) {
            addCriterion("CONTENT5 <", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5LessThanOrEqualTo(String value) {
            addCriterion("CONTENT5 <=", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5Like(String value) {
            addCriterion("CONTENT5 like", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotLike(String value) {
            addCriterion("CONTENT5 not like", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5In(List<String> values) {
            addCriterion("CONTENT5 in", values, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotIn(List<String> values) {
            addCriterion("CONTENT5 not in", values, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5Between(String value1, String value2) {
            addCriterion("CONTENT5 between", value1, value2, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotBetween(String value1, String value2) {
            addCriterion("CONTENT5 not between", value1, value2, "content5");
            return (Criteria) this;
        }

        public Criteria andContent4IsNull() {
            addCriterion("CONTENT4 is null");
            return (Criteria) this;
        }

        public Criteria andContent4IsNotNull() {
            addCriterion("CONTENT4 is not null");
            return (Criteria) this;
        }

        public Criteria andContent4EqualTo(String value) {
            addCriterion("CONTENT4 =", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotEqualTo(String value) {
            addCriterion("CONTENT4 <>", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4GreaterThan(String value) {
            addCriterion("CONTENT4 >", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4GreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT4 >=", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4LessThan(String value) {
            addCriterion("CONTENT4 <", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4LessThanOrEqualTo(String value) {
            addCriterion("CONTENT4 <=", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4Like(String value) {
            addCriterion("CONTENT4 like", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotLike(String value) {
            addCriterion("CONTENT4 not like", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4In(List<String> values) {
            addCriterion("CONTENT4 in", values, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotIn(List<String> values) {
            addCriterion("CONTENT4 not in", values, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4Between(String value1, String value2) {
            addCriterion("CONTENT4 between", value1, value2, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotBetween(String value1, String value2) {
            addCriterion("CONTENT4 not between", value1, value2, "content4");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("GMT_CREATE is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("GMT_CREATE is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("GMT_CREATE =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("GMT_CREATE <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("GMT_CREATE >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATE >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("GMT_CREATE <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATE <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("GMT_CREATE in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("GMT_CREATE not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("GMT_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("GMT_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("GMT_MODIFY =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("GMT_MODIFY <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("GMT_MODIFY >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFY >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("GMT_MODIFY <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFY <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("GMT_MODIFY in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("GMT_MODIFY not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFY between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFY not between", value1, value2, "gmtModify");
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