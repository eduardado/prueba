package com.comerzzia.core.model.acciones.estados;

import java.util.ArrayList;
import java.util.List;

public class AccionEstadoExample {
    public static final String ORDER_BY_ID_ACCION_ESTADOS = "ID_ACCION_ESTADOS";

    public static final String ORDER_BY_ID_ACCION_ESTADOS_DESC = "ID_ACCION_ESTADOS DESC";

    public static final String ORDER_BY_ID_ESTADO = "ID_ESTADO";

    public static final String ORDER_BY_ID_ESTADO_DESC = "ID_ESTADO DESC";

    public static final String ORDER_BY_ESTADO = "ESTADO";

    public static final String ORDER_BY_ESTADO_DESC = "ESTADO DESC";

    public static final String ORDER_BY_SUBESTADO = "SUBESTADO";

    public static final String ORDER_BY_SUBESTADO_DESC = "SUBESTADO DESC";

    public static final String ORDER_BY_DESESTADO = "DESESTADO";

    public static final String ORDER_BY_DESESTADO_DESC = "DESESTADO DESC";

    public static final String ORDER_BY_ABREVIATURA = "ABREVIATURA";

    public static final String ORDER_BY_ABREVIATURA_DESC = "ABREVIATURA DESC";

    public static final String ORDER_BY_ICONO = "ICONO";

    public static final String ORDER_BY_ICONO_DESC = "ICONO DESC";

    public static final String ORDER_BY_AMBITO_APLICACION = "AMBITO_APLICACION";

    public static final String ORDER_BY_AMBITO_APLICACION_DESC = "AMBITO_APLICACION DESC";

    public static final String ORDER_BY_DESSUBESTADO = "DESSUBESTADO";

    public static final String ORDER_BY_DESSUBESTADO_DESC = "DESSUBESTADO DESC";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccionEstadoExample() {
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

        public Criteria andIdAccionEstadosIsNull() {
            addCriterion("ID_ACCION_ESTADOS is null");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosIsNotNull() {
            addCriterion("ID_ACCION_ESTADOS is not null");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosEqualTo(Long value) {
            addCriterion("ID_ACCION_ESTADOS =", value, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosNotEqualTo(Long value) {
            addCriterion("ID_ACCION_ESTADOS <>", value, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosGreaterThan(Long value) {
            addCriterion("ID_ACCION_ESTADOS >", value, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_ACCION_ESTADOS >=", value, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosLessThan(Long value) {
            addCriterion("ID_ACCION_ESTADOS <", value, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosLessThanOrEqualTo(Long value) {
            addCriterion("ID_ACCION_ESTADOS <=", value, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosIn(List<Long> values) {
            addCriterion("ID_ACCION_ESTADOS in", values, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosNotIn(List<Long> values) {
            addCriterion("ID_ACCION_ESTADOS not in", values, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosBetween(Long value1, Long value2) {
            addCriterion("ID_ACCION_ESTADOS between", value1, value2, "idAccionEstados");
            return (Criteria) this;
        }

        public Criteria andIdAccionEstadosNotBetween(Long value1, Long value2) {
            addCriterion("ID_ACCION_ESTADOS not between", value1, value2, "idAccionEstados");
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

        public Criteria andIdEstadoEqualTo(Integer value) {
            addCriterion("ID_ESTADO =", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoNotEqualTo(Integer value) {
            addCriterion("ID_ESTADO <>", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoGreaterThan(Integer value) {
            addCriterion("ID_ESTADO >", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_ESTADO >=", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoLessThan(Integer value) {
            addCriterion("ID_ESTADO <", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoLessThanOrEqualTo(Integer value) {
            addCriterion("ID_ESTADO <=", value, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoIn(List<Integer> values) {
            addCriterion("ID_ESTADO in", values, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoNotIn(List<Integer> values) {
            addCriterion("ID_ESTADO not in", values, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoBetween(Integer value1, Integer value2) {
            addCriterion("ID_ESTADO between", value1, value2, "idEstado");
            return (Criteria) this;
        }

        public Criteria andIdEstadoNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_ESTADO not between", value1, value2, "idEstado");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNull() {
            addCriterion("ESTADO is null");
            return (Criteria) this;
        }

        public Criteria andEstadoIsNotNull() {
            addCriterion("ESTADO is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoEqualTo(Short value) {
            addCriterion("ESTADO =", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotEqualTo(Short value) {
            addCriterion("ESTADO <>", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThan(Short value) {
            addCriterion("ESTADO >", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoGreaterThanOrEqualTo(Short value) {
            addCriterion("ESTADO >=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThan(Short value) {
            addCriterion("ESTADO <", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoLessThanOrEqualTo(Short value) {
            addCriterion("ESTADO <=", value, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoIn(List<Short> values) {
            addCriterion("ESTADO in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotIn(List<Short> values) {
            addCriterion("ESTADO not in", values, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoBetween(Short value1, Short value2) {
            addCriterion("ESTADO between", value1, value2, "estado");
            return (Criteria) this;
        }

        public Criteria andEstadoNotBetween(Short value1, Short value2) {
            addCriterion("ESTADO not between", value1, value2, "estado");
            return (Criteria) this;
        }

        public Criteria andSubestadoIsNull() {
            addCriterion("SUBESTADO is null");
            return (Criteria) this;
        }

        public Criteria andSubestadoIsNotNull() {
            addCriterion("SUBESTADO is not null");
            return (Criteria) this;
        }

        public Criteria andSubestadoEqualTo(Short value) {
            addCriterion("SUBESTADO =", value, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoNotEqualTo(Short value) {
            addCriterion("SUBESTADO <>", value, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoGreaterThan(Short value) {
            addCriterion("SUBESTADO >", value, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoGreaterThanOrEqualTo(Short value) {
            addCriterion("SUBESTADO >=", value, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoLessThan(Short value) {
            addCriterion("SUBESTADO <", value, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoLessThanOrEqualTo(Short value) {
            addCriterion("SUBESTADO <=", value, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoIn(List<Short> values) {
            addCriterion("SUBESTADO in", values, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoNotIn(List<Short> values) {
            addCriterion("SUBESTADO not in", values, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoBetween(Short value1, Short value2) {
            addCriterion("SUBESTADO between", value1, value2, "subestado");
            return (Criteria) this;
        }

        public Criteria andSubestadoNotBetween(Short value1, Short value2) {
            addCriterion("SUBESTADO not between", value1, value2, "subestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoIsNull() {
            addCriterion("DESESTADO is null");
            return (Criteria) this;
        }

        public Criteria andDesestadoIsNotNull() {
            addCriterion("DESESTADO is not null");
            return (Criteria) this;
        }

        public Criteria andDesestadoEqualTo(String value) {
            addCriterion("DESESTADO =", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoNotEqualTo(String value) {
            addCriterion("DESESTADO <>", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoGreaterThan(String value) {
            addCriterion("DESESTADO >", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoGreaterThanOrEqualTo(String value) {
            addCriterion("DESESTADO >=", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoLessThan(String value) {
            addCriterion("DESESTADO <", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoLessThanOrEqualTo(String value) {
            addCriterion("DESESTADO <=", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoLike(String value) {
            addCriterion("DESESTADO like", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoNotLike(String value) {
            addCriterion("DESESTADO not like", value, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoIn(List<String> values) {
            addCriterion("DESESTADO in", values, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoNotIn(List<String> values) {
            addCriterion("DESESTADO not in", values, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoBetween(String value1, String value2) {
            addCriterion("DESESTADO between", value1, value2, "desestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoNotBetween(String value1, String value2) {
            addCriterion("DESESTADO not between", value1, value2, "desestado");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaIsNull() {
            addCriterion("ABREVIATURA is null");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaIsNotNull() {
            addCriterion("ABREVIATURA is not null");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaEqualTo(String value) {
            addCriterion("ABREVIATURA =", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotEqualTo(String value) {
            addCriterion("ABREVIATURA <>", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaGreaterThan(String value) {
            addCriterion("ABREVIATURA >", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaGreaterThanOrEqualTo(String value) {
            addCriterion("ABREVIATURA >=", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaLessThan(String value) {
            addCriterion("ABREVIATURA <", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaLessThanOrEqualTo(String value) {
            addCriterion("ABREVIATURA <=", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaLike(String value) {
            addCriterion("ABREVIATURA like", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotLike(String value) {
            addCriterion("ABREVIATURA not like", value, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaIn(List<String> values) {
            addCriterion("ABREVIATURA in", values, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotIn(List<String> values) {
            addCriterion("ABREVIATURA not in", values, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaBetween(String value1, String value2) {
            addCriterion("ABREVIATURA between", value1, value2, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaNotBetween(String value1, String value2) {
            addCriterion("ABREVIATURA not between", value1, value2, "abreviatura");
            return (Criteria) this;
        }

        public Criteria andIconoIsNull() {
            addCriterion("ICONO is null");
            return (Criteria) this;
        }

        public Criteria andIconoIsNotNull() {
            addCriterion("ICONO is not null");
            return (Criteria) this;
        }

        public Criteria andIconoEqualTo(String value) {
            addCriterion("ICONO =", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoNotEqualTo(String value) {
            addCriterion("ICONO <>", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoGreaterThan(String value) {
            addCriterion("ICONO >", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoGreaterThanOrEqualTo(String value) {
            addCriterion("ICONO >=", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoLessThan(String value) {
            addCriterion("ICONO <", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoLessThanOrEqualTo(String value) {
            addCriterion("ICONO <=", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoLike(String value) {
            addCriterion("ICONO like", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoNotLike(String value) {
            addCriterion("ICONO not like", value, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoIn(List<String> values) {
            addCriterion("ICONO in", values, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoNotIn(List<String> values) {
            addCriterion("ICONO not in", values, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoBetween(String value1, String value2) {
            addCriterion("ICONO between", value1, value2, "icono");
            return (Criteria) this;
        }

        public Criteria andIconoNotBetween(String value1, String value2) {
            addCriterion("ICONO not between", value1, value2, "icono");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionIsNull() {
            addCriterion("AMBITO_APLICACION is null");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionIsNotNull() {
            addCriterion("AMBITO_APLICACION is not null");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionEqualTo(String value) {
            addCriterion("AMBITO_APLICACION =", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionNotEqualTo(String value) {
            addCriterion("AMBITO_APLICACION <>", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionGreaterThan(String value) {
            addCriterion("AMBITO_APLICACION >", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionGreaterThanOrEqualTo(String value) {
            addCriterion("AMBITO_APLICACION >=", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionLessThan(String value) {
            addCriterion("AMBITO_APLICACION <", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionLessThanOrEqualTo(String value) {
            addCriterion("AMBITO_APLICACION <=", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionLike(String value) {
            addCriterion("AMBITO_APLICACION like", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionNotLike(String value) {
            addCriterion("AMBITO_APLICACION not like", value, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionIn(List<String> values) {
            addCriterion("AMBITO_APLICACION in", values, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionNotIn(List<String> values) {
            addCriterion("AMBITO_APLICACION not in", values, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionBetween(String value1, String value2) {
            addCriterion("AMBITO_APLICACION between", value1, value2, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionNotBetween(String value1, String value2) {
            addCriterion("AMBITO_APLICACION not between", value1, value2, "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andDessubestadoIsNull() {
            addCriterion("DESSUBESTADO is null");
            return (Criteria) this;
        }

        public Criteria andDessubestadoIsNotNull() {
            addCriterion("DESSUBESTADO is not null");
            return (Criteria) this;
        }

        public Criteria andDessubestadoEqualTo(String value) {
            addCriterion("DESSUBESTADO =", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoNotEqualTo(String value) {
            addCriterion("DESSUBESTADO <>", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoGreaterThan(String value) {
            addCriterion("DESSUBESTADO >", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoGreaterThanOrEqualTo(String value) {
            addCriterion("DESSUBESTADO >=", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoLessThan(String value) {
            addCriterion("DESSUBESTADO <", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoLessThanOrEqualTo(String value) {
            addCriterion("DESSUBESTADO <=", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoLike(String value) {
            addCriterion("DESSUBESTADO like", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoNotLike(String value) {
            addCriterion("DESSUBESTADO not like", value, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoIn(List<String> values) {
            addCriterion("DESSUBESTADO in", values, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoNotIn(List<String> values) {
            addCriterion("DESSUBESTADO not in", values, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoBetween(String value1, String value2) {
            addCriterion("DESSUBESTADO between", value1, value2, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDessubestadoNotBetween(String value1, String value2) {
            addCriterion("DESSUBESTADO not between", value1, value2, "dessubestado");
            return (Criteria) this;
        }

        public Criteria andDesestadoLikeInsensitive(String value) {
            addCriterion("upper(DESESTADO) like", value.toUpperCase(), "desestado");
            return (Criteria) this;
        }

        public Criteria andAbreviaturaLikeInsensitive(String value) {
            addCriterion("upper(ABREVIATURA) like", value.toUpperCase(), "abreviatura");
            return (Criteria) this;
        }

        public Criteria andIconoLikeInsensitive(String value) {
            addCriterion("upper(ICONO) like", value.toUpperCase(), "icono");
            return (Criteria) this;
        }

        public Criteria andAmbitoAplicacionLikeInsensitive(String value) {
            addCriterion("upper(AMBITO_APLICACION) like", value.toUpperCase(), "ambitoAplicacion");
            return (Criteria) this;
        }

        public Criteria andDessubestadoLikeInsensitive(String value) {
            addCriterion("upper(DESSUBESTADO) like", value.toUpperCase(), "dessubestado");
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