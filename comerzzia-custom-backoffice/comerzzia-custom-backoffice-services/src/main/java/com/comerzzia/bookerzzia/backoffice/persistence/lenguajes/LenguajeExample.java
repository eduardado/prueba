package com.comerzzia.bookerzzia.backoffice.persistence.lenguajes;

import java.util.ArrayList;
import java.util.List;

public class LenguajeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LenguajeExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andUidInstanciaIsNull() {
            addCriterion("uid_instancia is null");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaIsNotNull() {
            addCriterion("uid_instancia is not null");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaEqualTo(String value) {
            addCriterion("uid_instancia =", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaNotEqualTo(String value) {
            addCriterion("uid_instancia <>", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaGreaterThan(String value) {
            addCriterion("uid_instancia >", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaGreaterThanOrEqualTo(String value) {
            addCriterion("uid_instancia >=", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaLessThan(String value) {
            addCriterion("uid_instancia <", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaLessThanOrEqualTo(String value) {
            addCriterion("uid_instancia <=", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaLike(String value) {
            addCriterion("uid_instancia like", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaNotLike(String value) {
            addCriterion("uid_instancia not like", value, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaIn(List<String> values) {
            addCriterion("uid_instancia in", values, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaNotIn(List<String> values) {
            addCriterion("uid_instancia not in", values, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaBetween(String value1, String value2) {
            addCriterion("uid_instancia between", value1, value2, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaNotBetween(String value1, String value2) {
            addCriterion("uid_instancia not between", value1, value2, "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andCodlenguaIsNull() {
            addCriterion("codlengua is null");
            return (Criteria) this;
        }

        public Criteria andCodlenguaIsNotNull() {
            addCriterion("codlengua is not null");
            return (Criteria) this;
        }

        public Criteria andCodlenguaEqualTo(String value) {
            addCriterion("codlengua =", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaNotEqualTo(String value) {
            addCriterion("codlengua <>", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaGreaterThan(String value) {
            addCriterion("codlengua >", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaGreaterThanOrEqualTo(String value) {
            addCriterion("codlengua >=", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaLessThan(String value) {
            addCriterion("codlengua <", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaLessThanOrEqualTo(String value) {
            addCriterion("codlengua <=", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaLike(String value) {
            addCriterion("codlengua like", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaNotLike(String value) {
            addCriterion("codlengua not like", value, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaIn(List<String> values) {
            addCriterion("codlengua in", values, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaNotIn(List<String> values) {
            addCriterion("codlengua not in", values, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaBetween(String value1, String value2) {
            addCriterion("codlengua between", value1, value2, "codlengua");
            return (Criteria) this;
        }

        public Criteria andCodlenguaNotBetween(String value1, String value2) {
            addCriterion("codlengua not between", value1, value2, "codlengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaIsNull() {
            addCriterion("deslengua is null");
            return (Criteria) this;
        }

        public Criteria andDeslenguaIsNotNull() {
            addCriterion("deslengua is not null");
            return (Criteria) this;
        }

        public Criteria andDeslenguaEqualTo(String value) {
            addCriterion("deslengua =", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaNotEqualTo(String value) {
            addCriterion("deslengua <>", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaGreaterThan(String value) {
            addCriterion("deslengua >", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaGreaterThanOrEqualTo(String value) {
            addCriterion("deslengua >=", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaLessThan(String value) {
            addCriterion("deslengua <", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaLessThanOrEqualTo(String value) {
            addCriterion("deslengua <=", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaLike(String value) {
            addCriterion("deslengua like", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaNotLike(String value) {
            addCriterion("deslengua not like", value, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaIn(List<String> values) {
            addCriterion("deslengua in", values, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaNotIn(List<String> values) {
            addCriterion("deslengua not in", values, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaBetween(String value1, String value2) {
            addCriterion("deslengua between", value1, value2, "deslengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaNotBetween(String value1, String value2) {
            addCriterion("deslengua not between", value1, value2, "deslengua");
            return (Criteria) this;
        }

        public Criteria andActivoIsNull() {
            addCriterion("activo is null");
            return (Criteria) this;
        }

        public Criteria andActivoIsNotNull() {
            addCriterion("activo is not null");
            return (Criteria) this;
        }

        public Criteria andActivoEqualTo(String value) {
            addCriterion("activo =", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotEqualTo(String value) {
            addCriterion("activo <>", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoGreaterThan(String value) {
            addCriterion("activo >", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoGreaterThanOrEqualTo(String value) {
            addCriterion("activo >=", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLessThan(String value) {
            addCriterion("activo <", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLessThanOrEqualTo(String value) {
            addCriterion("activo <=", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLike(String value) {
            addCriterion("activo like", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotLike(String value) {
            addCriterion("activo not like", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoIn(List<String> values) {
            addCriterion("activo in", values, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotIn(List<String> values) {
            addCriterion("activo not in", values, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoBetween(String value1, String value2) {
            addCriterion("activo between", value1, value2, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotBetween(String value1, String value2) {
            addCriterion("activo not between", value1, value2, "activo");
            return (Criteria) this;
        }

        public Criteria andUidInstanciaLikeInsensitive(String value) {
            addCriterion("upper(uid_instancia) like", value.toUpperCase(), "uidInstancia");
            return (Criteria) this;
        }

        public Criteria andCodlenguaLikeInsensitive(String value) {
            addCriterion("upper(codlengua) like", value.toUpperCase(), "codlengua");
            return (Criteria) this;
        }

        public Criteria andDeslenguaLikeInsensitive(String value) {
            addCriterion("upper(deslengua) like", value.toUpperCase(), "deslengua");
            return (Criteria) this;
        }

        public Criteria andActivoLikeInsensitive(String value) {
            addCriterion("upper(activo) like", value.toUpperCase(), "activo");
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