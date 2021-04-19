package com.comerzzia.core.model.acciones.estados.vistas;

import java.util.ArrayList;
import java.util.List;

public class VistaAccionEstadoExample {
    public static final String ORDER_BY_ID_ACCION = "ID_ACCION";

    public static final String ORDER_BY_ID_ACCION_DESC = "ID_ACCION DESC";

    public static final String ORDER_BY_CODVISTA = "CODVISTA";

    public static final String ORDER_BY_CODVISTA_DESC = "CODVISTA DESC";

    public static final String ORDER_BY_ID_ESTADO = "ID_ESTADO";

    public static final String ORDER_BY_ID_ESTADO_DESC = "ID_ESTADO DESC";

    public static final String ORDER_BY_ORDEN = "ORDEN";

    public static final String ORDER_BY_ORDEN_DESC = "ORDEN DESC";

    public static final String ORDER_BY_DESCRIPCION_ALTERNATIVA = "DESCRIPCION_ALTERNATIVA";

    public static final String ORDER_BY_DESCRIPCION_ALTERNATIVA_DESC = "DESCRIPCION_ALTERNATIVA DESC";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VistaAccionEstadoExample() {
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
            if (condition != null) {
                criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value != null) {
                criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                criteria.add(new Criterion(condition, value1, value2));
            }
        }

        public Criteria andIdAccionIsNull() {
            addCriterion("ID_ACCION is null");
            return (Criteria) this;
        }

        public Criteria andIdAccionIsNotNull() {
            addCriterion("ID_ACCION is not null");
            return (Criteria) this;
        }

        public Criteria andIdAccionEqualTo(Long value) {
            addCriterion("ID_ACCION =", value, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionNotEqualTo(Long value) {
            addCriterion("ID_ACCION <>", value, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionGreaterThan(Long value) {
            addCriterion("ID_ACCION >", value, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_ACCION >=", value, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionLessThan(Long value) {
            addCriterion("ID_ACCION <", value, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionLessThanOrEqualTo(Long value) {
            addCriterion("ID_ACCION <=", value, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionIn(List<Long> values) {
            addCriterion("ID_ACCION in", values, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionNotIn(List<Long> values) {
            addCriterion("ID_ACCION not in", values, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionBetween(Long value1, Long value2) {
            addCriterion("ID_ACCION between", value1, value2, "idAccion");
            return (Criteria) this;
        }

        public Criteria andIdAccionNotBetween(Long value1, Long value2) {
            addCriterion("ID_ACCION not between", value1, value2, "idAccion");
            return (Criteria) this;
        }

        public Criteria andCodvistaIsNull() {
            addCriterion("CODVISTA is null");
            return (Criteria) this;
        }

        public Criteria andCodvistaIsNotNull() {
            addCriterion("CODVISTA is not null");
            return (Criteria) this;
        }

        public Criteria andCodvistaEqualTo(String value) {
            addCriterion("CODVISTA =", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaNotEqualTo(String value) {
            addCriterion("CODVISTA <>", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaGreaterThan(String value) {
            addCriterion("CODVISTA >", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaGreaterThanOrEqualTo(String value) {
            addCriterion("CODVISTA >=", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaLessThan(String value) {
            addCriterion("CODVISTA <", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaLessThanOrEqualTo(String value) {
            addCriterion("CODVISTA <=", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaLike(String value) {
            addCriterion("CODVISTA like", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaNotLike(String value) {
            addCriterion("CODVISTA not like", value, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaIn(List<String> values) {
            addCriterion("CODVISTA in", values, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaNotIn(List<String> values) {
            addCriterion("CODVISTA not in", values, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaBetween(String value1, String value2) {
            addCriterion("CODVISTA between", value1, value2, "codvista");
            return (Criteria) this;
        }

        public Criteria andCodvistaNotBetween(String value1, String value2) {
            addCriterion("CODVISTA not between", value1, value2, "codvista");
            return (Criteria) this;
        }

        public Criteria andIdEstadoIsNull() {
            addCriterion("ID_ESTADO is null");
            return (Criteria) this;
        }

        public Criteria andIdEstadoIsNotNull() {
            addCriterion("ID_ESTADO is not null");
            return (Criteria) this;
        }

        public Criteria andIdEstadoEqualTo(Long value) {
            addCriterion("ID_ESTADO =", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoNotEqualTo(Long value) {
            addCriterion("ID_ESTADO <>", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoGreaterThan(Long value) {
            addCriterion("ID_ESTADO >", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_ESTADO >=", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoLessThan(Long value) {
            addCriterion("ID_ESTADO <", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoLessThanOrEqualTo(Long value) {
            addCriterion("ID_ESTADO <=", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoIn(List<Long> values) {
            addCriterion("ID_ESTADO in", values, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoNotIn(List<Long> values) {
            addCriterion("ID_ESTADO not in", values, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoBetween(Long value1, Long value2) {
            addCriterion("ID_ESTADO between", value1, value2, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoNotBetween(Long value1, Long value2) {
            addCriterion("ID_ESTADO not between", value1, value2, "idEstado");
            return (Criteria) this;
        }

        public Criteria andOrdenIsNull() {
            addCriterion("ORDEN is null");
            return (Criteria) this;
        }

        public Criteria andOrdenIsNotNull() {
            addCriterion("ORDEN is not null");
            return (Criteria) this;
        }

        public Criteria andOrdenEqualTo(Integer value) {
            addCriterion("ORDEN =", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenNotEqualTo(Integer value) {
            addCriterion("ORDEN <>", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenGreaterThan(Integer value) {
            addCriterion("ORDEN >", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDEN >=", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenLessThan(Integer value) {
            addCriterion("ORDEN <", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenLessThanOrEqualTo(Integer value) {
            addCriterion("ORDEN <=", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenIn(List<Integer> values) {
            addCriterion("ORDEN in", values, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenNotIn(List<Integer> values) {
            addCriterion("ORDEN not in", values, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenBetween(Integer value1, Integer value2) {
            addCriterion("ORDEN between", value1, value2, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDEN not between", value1, value2, "orden");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaIsNull() {
            addCriterion("DESCRIPCION_ALTERNATIVA is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaIsNotNull() {
            addCriterion("DESCRIPCION_ALTERNATIVA is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaEqualTo(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA =", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaNotEqualTo(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA <>", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaGreaterThan(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA >", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA >=", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaLessThan(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA <", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA <=", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaLike(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA like", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaNotLike(String value) {
            addCriterion("DESCRIPCION_ALTERNATIVA not like", value, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaIn(List<String> values) {
            addCriterion("DESCRIPCION_ALTERNATIVA in", values, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaNotIn(List<String> values) {
            addCriterion("DESCRIPCION_ALTERNATIVA not in", values, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaBetween(String value1, String value2) {
            addCriterion("DESCRIPCION_ALTERNATIVA between", value1, value2, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaNotBetween(String value1, String value2) {
            addCriterion("DESCRIPCION_ALTERNATIVA not between", value1, value2, "descripcionAlternativa");
            return (Criteria) this;
        }

        public Criteria andCodvistaLikeInsensitive(String value) {
            addCriterion("upper(CODVISTA) like", value.toUpperCase(), "codvista");
            return (Criteria) this;
        }

        public Criteria andDescripcionAlternativaLikeInsensitive(String value) {
            addCriterion("upper(DESCRIPCION_ALTERNATIVA) like", value.toUpperCase(), "descripcionAlternativa");
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