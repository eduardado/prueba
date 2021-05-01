package com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones;

import java.util.ArrayList;
import java.util.List;

public class EncuadernacionBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EncuadernacionBeanExample() {
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

        public Criteria andUidActividadIsNull() {
            addCriterion("UID_ACTIVIDAD is null");
            return (Criteria) this;
        }

        public Criteria andUidActividadIsNotNull() {
            addCriterion("UID_ACTIVIDAD is not null");
            return (Criteria) this;
        }

        public Criteria andUidActividadEqualTo(String value) {
            addCriterion("UID_ACTIVIDAD =", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadNotEqualTo(String value) {
            addCriterion("UID_ACTIVIDAD <>", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadGreaterThan(String value) {
            addCriterion("UID_ACTIVIDAD >", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadGreaterThanOrEqualTo(String value) {
            addCriterion("UID_ACTIVIDAD >=", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadLessThan(String value) {
            addCriterion("UID_ACTIVIDAD <", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadLessThanOrEqualTo(String value) {
            addCriterion("UID_ACTIVIDAD <=", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadLike(String value) {
            addCriterion("UID_ACTIVIDAD like", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadNotLike(String value) {
            addCriterion("UID_ACTIVIDAD not like", value, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadIn(List<String> values) {
            addCriterion("UID_ACTIVIDAD in", values, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadNotIn(List<String> values) {
            addCriterion("UID_ACTIVIDAD not in", values, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadBetween(String value1, String value2) {
            addCriterion("UID_ACTIVIDAD between", value1, value2, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andUidActividadNotBetween(String value1, String value2) {
            addCriterion("UID_ACTIVIDAD not between", value1, value2, "uidActividad");
            return (Criteria) this;
        }

        public Criteria andCodalmIsNull() {
            addCriterion("CODALM is null");
            return (Criteria) this;
        }

        public Criteria andCodalmIsNotNull() {
            addCriterion("CODALM is not null");
            return (Criteria) this;
        }

        public Criteria andCodalmEqualTo(String value) {
            addCriterion("CODALM =", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmNotEqualTo(String value) {
            addCriterion("CODALM <>", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmGreaterThan(String value) {
            addCriterion("CODALM >", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmGreaterThanOrEqualTo(String value) {
            addCriterion("CODALM >=", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmLessThan(String value) {
            addCriterion("CODALM <", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmLessThanOrEqualTo(String value) {
            addCriterion("CODALM <=", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmLike(String value) {
            addCriterion("CODALM like", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmNotLike(String value) {
            addCriterion("CODALM not like", value, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmIn(List<String> values) {
            addCriterion("CODALM in", values, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmNotIn(List<String> values) {
            addCriterion("CODALM not in", values, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmBetween(String value1, String value2) {
            addCriterion("CODALM between", value1, value2, "codalm");
            return (Criteria) this;
        }

        public Criteria andCodalmNotBetween(String value1, String value2) {
            addCriterion("CODALM not between", value1, value2, "codalm");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranIsNull() {
            addCriterion("ID_CLIE_ALBARAN is null");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranIsNotNull() {
            addCriterion("ID_CLIE_ALBARAN is not null");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranEqualTo(Long value) {
            addCriterion("ID_CLIE_ALBARAN =", value, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranNotEqualTo(Long value) {
            addCriterion("ID_CLIE_ALBARAN <>", value, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranGreaterThan(Long value) {
            addCriterion("ID_CLIE_ALBARAN >", value, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_CLIE_ALBARAN >=", value, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranLessThan(Long value) {
            addCriterion("ID_CLIE_ALBARAN <", value, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranLessThanOrEqualTo(Long value) {
            addCriterion("ID_CLIE_ALBARAN <=", value, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranIn(List<Long> values) {
            addCriterion("ID_CLIE_ALBARAN in", values, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranNotIn(List<Long> values) {
            addCriterion("ID_CLIE_ALBARAN not in", values, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranBetween(Long value1, Long value2) {
            addCriterion("ID_CLIE_ALBARAN between", value1, value2, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andIdClieAlbaranNotBetween(Long value1, Long value2) {
            addCriterion("ID_CLIE_ALBARAN not between", value1, value2, "idClieAlbaran");
            return (Criteria) this;
        }

        public Criteria andLineaIsNull() {
            addCriterion("LINEA is null");
            return (Criteria) this;
        }

        public Criteria andLineaIsNotNull() {
            addCriterion("LINEA is not null");
            return (Criteria) this;
        }

        public Criteria andLineaEqualTo(Integer value) {
            addCriterion("LINEA =", value, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaNotEqualTo(Integer value) {
            addCriterion("LINEA <>", value, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaGreaterThan(Integer value) {
            addCriterion("LINEA >", value, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaGreaterThanOrEqualTo(Integer value) {
            addCriterion("LINEA >=", value, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaLessThan(Integer value) {
            addCriterion("LINEA <", value, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaLessThanOrEqualTo(Integer value) {
            addCriterion("LINEA <=", value, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaIn(List<Integer> values) {
            addCriterion("LINEA in", values, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaNotIn(List<Integer> values) {
            addCriterion("LINEA not in", values, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaBetween(Integer value1, Integer value2) {
            addCriterion("LINEA between", value1, value2, "linea");
            return (Criteria) this;
        }

        public Criteria andLineaNotBetween(Integer value1, Integer value2) {
            addCriterion("LINEA not between", value1, value2, "linea");
            return (Criteria) this;
        }

        public Criteria andTapaIsNull() {
            addCriterion("TAPA is null");
            return (Criteria) this;
        }

        public Criteria andTapaIsNotNull() {
            addCriterion("TAPA is not null");
            return (Criteria) this;
        }

        public Criteria andTapaEqualTo(String value) {
            addCriterion("TAPA =", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaNotEqualTo(String value) {
            addCriterion("TAPA <>", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaGreaterThan(String value) {
            addCriterion("TAPA >", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaGreaterThanOrEqualTo(String value) {
            addCriterion("TAPA >=", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaLessThan(String value) {
            addCriterion("TAPA <", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaLessThanOrEqualTo(String value) {
            addCriterion("TAPA <=", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaLike(String value) {
            addCriterion("TAPA like", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaNotLike(String value) {
            addCriterion("TAPA not like", value, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaIn(List<String> values) {
            addCriterion("TAPA in", values, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaNotIn(List<String> values) {
            addCriterion("TAPA not in", values, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaBetween(String value1, String value2) {
            addCriterion("TAPA between", value1, value2, "tapa");
            return (Criteria) this;
        }

        public Criteria andTapaNotBetween(String value1, String value2) {
            addCriterion("TAPA not between", value1, value2, "tapa");
            return (Criteria) this;
        }

        public Criteria andSubtituloIsNull() {
            addCriterion("SUBTITULO is null");
            return (Criteria) this;
        }

        public Criteria andSubtituloIsNotNull() {
            addCriterion("SUBTITULO is not null");
            return (Criteria) this;
        }

        public Criteria andSubtituloEqualTo(String value) {
            addCriterion("SUBTITULO =", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloNotEqualTo(String value) {
            addCriterion("SUBTITULO <>", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloGreaterThan(String value) {
            addCriterion("SUBTITULO >", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloGreaterThanOrEqualTo(String value) {
            addCriterion("SUBTITULO >=", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloLessThan(String value) {
            addCriterion("SUBTITULO <", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloLessThanOrEqualTo(String value) {
            addCriterion("SUBTITULO <=", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloLike(String value) {
            addCriterion("SUBTITULO like", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloNotLike(String value) {
            addCriterion("SUBTITULO not like", value, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloIn(List<String> values) {
            addCriterion("SUBTITULO in", values, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloNotIn(List<String> values) {
            addCriterion("SUBTITULO not in", values, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloBetween(String value1, String value2) {
            addCriterion("SUBTITULO between", value1, value2, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andSubtituloNotBetween(String value1, String value2) {
            addCriterion("SUBTITULO not between", value1, value2, "subtitulo");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaIsNull() {
            addCriterion("DEDICATORIA is null");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaIsNotNull() {
            addCriterion("DEDICATORIA is not null");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaEqualTo(String value) {
            addCriterion("DEDICATORIA =", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaNotEqualTo(String value) {
            addCriterion("DEDICATORIA <>", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaGreaterThan(String value) {
            addCriterion("DEDICATORIA >", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaGreaterThanOrEqualTo(String value) {
            addCriterion("DEDICATORIA >=", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaLessThan(String value) {
            addCriterion("DEDICATORIA <", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaLessThanOrEqualTo(String value) {
            addCriterion("DEDICATORIA <=", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaLike(String value) {
            addCriterion("DEDICATORIA like", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaNotLike(String value) {
            addCriterion("DEDICATORIA not like", value, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaIn(List<String> values) {
            addCriterion("DEDICATORIA in", values, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaNotIn(List<String> values) {
            addCriterion("DEDICATORIA not in", values, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaBetween(String value1, String value2) {
            addCriterion("DEDICATORIA between", value1, value2, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaNotBetween(String value1, String value2) {
            addCriterion("DEDICATORIA not between", value1, value2, "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andHechoIsNull() {
            addCriterion("HECHO is null");
            return (Criteria) this;
        }

        public Criteria andHechoIsNotNull() {
            addCriterion("HECHO is not null");
            return (Criteria) this;
        }

        public Criteria andHechoEqualTo(String value) {
            addCriterion("HECHO =", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoNotEqualTo(String value) {
            addCriterion("HECHO <>", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoGreaterThan(String value) {
            addCriterion("HECHO >", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoGreaterThanOrEqualTo(String value) {
            addCriterion("HECHO >=", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoLessThan(String value) {
            addCriterion("HECHO <", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoLessThanOrEqualTo(String value) {
            addCriterion("HECHO <=", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoLike(String value) {
            addCriterion("HECHO like", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoNotLike(String value) {
            addCriterion("HECHO not like", value, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoIn(List<String> values) {
            addCriterion("HECHO in", values, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoNotIn(List<String> values) {
            addCriterion("HECHO not in", values, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoBetween(String value1, String value2) {
            addCriterion("HECHO between", value1, value2, "hecho");
            return (Criteria) this;
        }

        public Criteria andHechoNotBetween(String value1, String value2) {
            addCriterion("HECHO not between", value1, value2, "hecho");
            return (Criteria) this;
        }

        public Criteria andUidActividadLikeInsensitive(String value) {
            addCriterion("upper(UID_ACTIVIDAD) like", value.toUpperCase(), "uidActividad");
            return (Criteria) this;
        }

        public Criteria andCodalmLikeInsensitive(String value) {
            addCriterion("upper(CODALM) like", value.toUpperCase(), "codalm");
            return (Criteria) this;
        }

        public Criteria andTapaLikeInsensitive(String value) {
            addCriterion("upper(TAPA) like", value.toUpperCase(), "tapa");
            return (Criteria) this;
        }

        public Criteria andSubtituloLikeInsensitive(String value) {
            addCriterion("upper(SUBTITULO) like", value.toUpperCase(), "subtitulo");
            return (Criteria) this;
        }

        public Criteria andDedicatoriaLikeInsensitive(String value) {
            addCriterion("upper(DEDICATORIA) like", value.toUpperCase(), "dedicatoria");
            return (Criteria) this;
        }

        public Criteria andHechoLikeInsensitive(String value) {
            addCriterion("upper(HECHO) like", value.toUpperCase(), "hecho");
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