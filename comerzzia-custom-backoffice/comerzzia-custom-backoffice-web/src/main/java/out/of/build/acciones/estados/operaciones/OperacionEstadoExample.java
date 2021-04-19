package com.comerzzia.core.model.acciones.estados.operaciones;

import java.util.ArrayList;
import java.util.List;

public class OperacionEstadoExample {
    public static final String ORDER_BY_ID_ACCION = "ID_ACCION";

    public static final String ORDER_BY_ID_ACCION_DESC = "ID_ACCION DESC";

    public static final String ORDER_BY_ID_ESTADO = "ID_ESTADO";

    public static final String ORDER_BY_ID_ESTADO_DESC = "ID_ESTADO DESC";

    public static final String ORDER_BY_ID_OPERACION = "ID_OPERACION";

    public static final String ORDER_BY_ID_OPERACION_DESC = "ID_OPERACION DESC";

    public static final String ORDER_BY_DESOPERACION = "DESOPERACION";

    public static final String ORDER_BY_DESOPERACION_DESC = "DESOPERACION DESC";

    public static final String ORDER_BY_EJECUCION = "EJECUCION";

    public static final String ORDER_BY_EJECUCION_DESC = "EJECUCION DESC";

    public static final String ORDER_BY_ORDEN = "ORDEN";

    public static final String ORDER_BY_ORDEN_DESC = "ORDEN DESC";

    public static final String ORDER_BY_ACTIVO = "ACTIVO";

    public static final String ORDER_BY_ACTIVO_DESC = "ACTIVO DESC";

    public static final String ORDER_BY_VISIBLE = "VISIBLE";

    public static final String ORDER_BY_VISIBLE_DESC = "VISIBLE DESC";

    public static final String ORDER_BY_PARAMETROS = "PARAMETROS";

    public static final String ORDER_BY_PARAMETROS_DESC = "PARAMETROS DESC";

    public static final String ORDER_BY_ICONO = "ICONO";

    public static final String ORDER_BY_ICONO_DESC = "ICONO DESC";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperacionEstadoExample() {
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

        public Criteria andIdOperacionIsNull() {
            addCriterion("ID_OPERACION is null");
            return (Criteria) this;
        }

        public Criteria andIdOperacionIsNotNull() {
            addCriterion("ID_OPERACION is not null");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEqualTo(Long value) {
            addCriterion("ID_OPERACION =", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionNotEqualTo(Long value) {
            addCriterion("ID_OPERACION <>", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionGreaterThan(Long value) {
            addCriterion("ID_OPERACION >", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_OPERACION >=", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionLessThan(Long value) {
            addCriterion("ID_OPERACION <", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionLessThanOrEqualTo(Long value) {
            addCriterion("ID_OPERACION <=", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionIn(List<Long> values) {
            addCriterion("ID_OPERACION in", values, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionNotIn(List<Long> values) {
            addCriterion("ID_OPERACION not in", values, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionBetween(Long value1, Long value2) {
            addCriterion("ID_OPERACION between", value1, value2, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionNotBetween(Long value1, Long value2) {
            addCriterion("ID_OPERACION not between", value1, value2, "idOperacion");
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