package com.dnt.cloud.student.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NrcStudentParentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NrcStudentParentCriteria() {
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

        public Criteria andNrcStudentIdIsNull() {
            addCriterion("NRC_STUDENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdIsNotNull() {
            addCriterion("NRC_STUDENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdEqualTo(Long value) {
            addCriterion("NRC_STUDENT_ID =", value, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdNotEqualTo(Long value) {
            addCriterion("NRC_STUDENT_ID <>", value, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdGreaterThan(Long value) {
            addCriterion("NRC_STUDENT_ID >", value, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("NRC_STUDENT_ID >=", value, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdLessThan(Long value) {
            addCriterion("NRC_STUDENT_ID <", value, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdLessThanOrEqualTo(Long value) {
            addCriterion("NRC_STUDENT_ID <=", value, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdIn(List<Long> values) {
            addCriterion("NRC_STUDENT_ID in", values, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdNotIn(List<Long> values) {
            addCriterion("NRC_STUDENT_ID not in", values, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdBetween(Long value1, Long value2) {
            addCriterion("NRC_STUDENT_ID between", value1, value2, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcStudentIdNotBetween(Long value1, Long value2) {
            addCriterion("NRC_STUDENT_ID not between", value1, value2, "nrcStudentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdIsNull() {
            addCriterion("NRC_PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdIsNotNull() {
            addCriterion("NRC_PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdEqualTo(Long value) {
            addCriterion("NRC_PARENT_ID =", value, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdNotEqualTo(Long value) {
            addCriterion("NRC_PARENT_ID <>", value, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdGreaterThan(Long value) {
            addCriterion("NRC_PARENT_ID >", value, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("NRC_PARENT_ID >=", value, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdLessThan(Long value) {
            addCriterion("NRC_PARENT_ID <", value, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdLessThanOrEqualTo(Long value) {
            addCriterion("NRC_PARENT_ID <=", value, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdIn(List<Long> values) {
            addCriterion("NRC_PARENT_ID in", values, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdNotIn(List<Long> values) {
            addCriterion("NRC_PARENT_ID not in", values, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdBetween(Long value1, Long value2) {
            addCriterion("NRC_PARENT_ID between", value1, value2, "nrcParentId");
            return (Criteria) this;
        }

        public Criteria andNrcParentIdNotBetween(Long value1, Long value2) {
            addCriterion("NRC_PARENT_ID not between", value1, value2, "nrcParentId");
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