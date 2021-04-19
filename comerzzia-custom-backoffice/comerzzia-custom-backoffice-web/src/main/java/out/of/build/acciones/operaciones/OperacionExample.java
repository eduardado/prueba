package com.comerzzia.core.model.acciones.operaciones;

import java.util.ArrayList;
import java.util.List;

public class OperacionExample {
    public static final String ORDER_BY_ID_ACCION = "ID_ACCION";

    public static final String ORDER_BY_ID_ACCION_DESC = "ID_ACCION DESC";

    public static final String ORDER_BY_ID_OPERACION = "ID_OPERACION";

    public static final String ORDER_BY_ID_OPERACION_DESC = "ID_OPERACION DESC";

    public static final String ORDER_BY_ORDEN = "ORDEN";

    public static final String ORDER_BY_ORDEN_DESC = "ORDEN DESC";

    public static final String ORDER_BY_DESOPERACION = "DESOPERACION";

    public static final String ORDER_BY_DESOPERACION_DESC = "DESOPERACION DESC";

    public static final String ORDER_BY_EJECUCION = "EJECUCION";

    public static final String ORDER_BY_EJECUCION_DESC = "EJECUCION DESC";

    public static final String ORDER_BY_ID_ESTADO = "ID_ESTADO";

    public static final String ORDER_BY_ID_ESTADO_DESC = "ID_ESTADO DESC";

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

    public OperacionExample() {
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
        protected List<Criterion> activoCriteria;

        protected List<Criterion> visibleCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            activoCriteria = new ArrayList<Criterion>();
            visibleCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getActivoCriteria() {
            return activoCriteria;
        }

        protected void addActivoCriterion(String condition, Object value, String property) {
            if (value != null) {
                activoCriteria.add(new Criterion(condition, value, "com.comerzzia.core.util.mybatis.typehandlers.BooleanStringTypeHandler"));
                allCriteria = null;
            }
        }

        protected void addActivoCriterion(String condition, Boolean value1, Boolean value2, String property) {
            if (value1 != null && value2 != null) {
                activoCriteria.add(new Criterion(condition, value1, value2, "com.comerzzia.core.util.mybatis.typehandlers.BooleanStringTypeHandler"));
                allCriteria = null;
            }
        }

        public List<Criterion> getVisibleCriteria() {
            return visibleCriteria;
        }

        protected void addVisibleCriterion(String condition, Object value, String property) {
            if (value != null) {
                visibleCriteria.add(new Criterion(condition, value, "com.comerzzia.core.util.mybatis.typehandlers.BooleanStringTypeHandler"));
                allCriteria = null;
            }
        }

        protected void addVisibleCriterion(String condition, Boolean value1, Boolean value2, String property) {
            if (value1 != null && value2 != null) {
                visibleCriteria.add(new Criterion(condition, value1, value2, "com.comerzzia.core.util.mybatis.typehandlers.BooleanStringTypeHandler"));
                allCriteria = null;
            }
        }

        public boolean isValid() {
            return criteria.size() > 0
                || activoCriteria.size() > 0
                || visibleCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(activoCriteria);
                allCriteria.addAll(visibleCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition != null) {
                criteria.add(new Criterion(condition));
                allCriteria = null;
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value != null) {
                criteria.add(new Criterion(condition, value));
                allCriteria = null;
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                criteria.add(new Criterion(condition, value1, value2));
                allCriteria = null;
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

        public Criteria andIdOperacionIsNull() {
            addCriterion("ID_OPERACION is null");
            return (Criteria) this;
        }

        public Criteria andIdOperacionIsNotNull() {
            addCriterion("ID_OPERACION is not null");
            return (Criteria) this;
        }

        public Criteria andIdOperacionEqualTo(Byte value) {
            addCriterion("ID_OPERACION =", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionNotEqualTo(Byte value) {
            addCriterion("ID_OPERACION <>", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionGreaterThan(Byte value) {
            addCriterion("ID_OPERACION >", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionGreaterThanOrEqualTo(Byte value) {
            addCriterion("ID_OPERACION >=", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionLessThan(Byte value) {
            addCriterion("ID_OPERACION <", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionLessThanOrEqualTo(Byte value) {
            addCriterion("ID_OPERACION <=", value, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionIn(List<Byte> values) {
            addCriterion("ID_OPERACION in", values, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionNotIn(List<Byte> values) {
            addCriterion("ID_OPERACION not in", values, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionBetween(Byte value1, Byte value2) {
            addCriterion("ID_OPERACION between", value1, value2, "idOperacion");
            return (Criteria) this;
        }

        public Criteria andIdOperacionNotBetween(Byte value1, Byte value2) {
            addCriterion("ID_OPERACION not between", value1, value2, "idOperacion");
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

        public Criteria andOrdenEqualTo(Byte value) {
            addCriterion("ORDEN =", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenNotEqualTo(Byte value) {
            addCriterion("ORDEN <>", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenGreaterThan(Byte value) {
            addCriterion("ORDEN >", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenGreaterThanOrEqualTo(Byte value) {
            addCriterion("ORDEN >=", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenLessThan(Byte value) {
            addCriterion("ORDEN <", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenLessThanOrEqualTo(Byte value) {
            addCriterion("ORDEN <=", value, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenIn(List<Byte> values) {
            addCriterion("ORDEN in", values, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenNotIn(List<Byte> values) {
            addCriterion("ORDEN not in", values, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenBetween(Byte value1, Byte value2) {
            addCriterion("ORDEN between", value1, value2, "orden");
            return (Criteria) this;
        }

        public Criteria andOrdenNotBetween(Byte value1, Byte value2) {
            addCriterion("ORDEN not between", value1, value2, "orden");
            return (Criteria) this;
        }

        public Criteria andDesOperacionIsNull() {
            addCriterion("DESOPERACION is null");
            return (Criteria) this;
        }

        public Criteria andDesOperacionIsNotNull() {
            addCriterion("DESOPERACION is not null");
            return (Criteria) this;
        }

        public Criteria andDesOperacionEqualTo(String value) {
            addCriterion("DESOPERACION =", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionNotEqualTo(String value) {
            addCriterion("DESOPERACION <>", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionGreaterThan(String value) {
            addCriterion("DESOPERACION >", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionGreaterThanOrEqualTo(String value) {
            addCriterion("DESOPERACION >=", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionLessThan(String value) {
            addCriterion("DESOPERACION <", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionLessThanOrEqualTo(String value) {
            addCriterion("DESOPERACION <=", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionLike(String value) {
            addCriterion("DESOPERACION like", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionNotLike(String value) {
            addCriterion("DESOPERACION not like", value, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionIn(List<String> values) {
            addCriterion("DESOPERACION in", values, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionNotIn(List<String> values) {
            addCriterion("DESOPERACION not in", values, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionBetween(String value1, String value2) {
            addCriterion("DESOPERACION between", value1, value2, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andDesOperacionNotBetween(String value1, String value2) {
            addCriterion("DESOPERACION not between", value1, value2, "desOperacion");
            return (Criteria) this;
        }

        public Criteria andEjecucionIsNull() {
            addCriterion("EJECUCION is null");
            return (Criteria) this;
        }

        public Criteria andEjecucionIsNotNull() {
            addCriterion("EJECUCION is not null");
            return (Criteria) this;
        }

        public Criteria andEjecucionEqualTo(String value) {
            addCriterion("EJECUCION =", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionNotEqualTo(String value) {
            addCriterion("EJECUCION <>", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionGreaterThan(String value) {
            addCriterion("EJECUCION >", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionGreaterThanOrEqualTo(String value) {
            addCriterion("EJECUCION >=", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionLessThan(String value) {
            addCriterion("EJECUCION <", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionLessThanOrEqualTo(String value) {
            addCriterion("EJECUCION <=", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionLike(String value) {
            addCriterion("EJECUCION like", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionNotLike(String value) {
            addCriterion("EJECUCION not like", value, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionIn(List<String> values) {
            addCriterion("EJECUCION in", values, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionNotIn(List<String> values) {
            addCriterion("EJECUCION not in", values, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionBetween(String value1, String value2) {
            addCriterion("EJECUCION between", value1, value2, "ejecucion");
            return (Criteria) this;
        }

        public Criteria andEjecucionNotBetween(String value1, String value2) {
            addCriterion("EJECUCION not between", value1, value2, "ejecucion");
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

        public Criteria andActivoIsNull() {
            addCriterion("ACTIVO is null");
            return (Criteria) this;
        }

        public Criteria andActivoIsNotNull() {
            addCriterion("ACTIVO is not null");
            return (Criteria) this;
        }

        public Criteria andActivoEqualTo(Boolean value) {
            addActivoCriterion("ACTIVO =", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotEqualTo(Boolean value) {
            addActivoCriterion("ACTIVO <>", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoGreaterThan(Boolean value) {
            addActivoCriterion("ACTIVO >", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoGreaterThanOrEqualTo(Boolean value) {
            addActivoCriterion("ACTIVO >=", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLessThan(Boolean value) {
            addActivoCriterion("ACTIVO <", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLessThanOrEqualTo(Boolean value) {
            addActivoCriterion("ACTIVO <=", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoLike(Boolean value) {
            addActivoCriterion("ACTIVO like", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotLike(Boolean value) {
            addActivoCriterion("ACTIVO not like", value, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoIn(List<Boolean> values) {
            addActivoCriterion("ACTIVO in", values, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotIn(List<Boolean> values) {
            addActivoCriterion("ACTIVO not in", values, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoBetween(Boolean value1, Boolean value2) {
            addActivoCriterion("ACTIVO between", value1, value2, "activo");
            return (Criteria) this;
        }

        public Criteria andActivoNotBetween(Boolean value1, Boolean value2) {
            addActivoCriterion("ACTIVO not between", value1, value2, "activo");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNull() {
            addCriterion("VISIBLE is null");
            return (Criteria) this;
        }

        public Criteria andVisibleIsNotNull() {
            addCriterion("VISIBLE is not null");
            return (Criteria) this;
        }

        public Criteria andVisibleEqualTo(Boolean value) {
            addVisibleCriterion("VISIBLE =", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotEqualTo(Boolean value) {
            addVisibleCriterion("VISIBLE <>", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThan(Boolean value) {
            addVisibleCriterion("VISIBLE >", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleGreaterThanOrEqualTo(Boolean value) {
            addVisibleCriterion("VISIBLE >=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThan(Boolean value) {
            addVisibleCriterion("VISIBLE <", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLessThanOrEqualTo(Boolean value) {
            addVisibleCriterion("VISIBLE <=", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleLike(Boolean value) {
            addVisibleCriterion("VISIBLE like", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotLike(Boolean value) {
            addVisibleCriterion("VISIBLE not like", value, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleIn(List<Boolean> values) {
            addVisibleCriterion("VISIBLE in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotIn(List<Boolean> values) {
            addVisibleCriterion("VISIBLE not in", values, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleBetween(Boolean value1, Boolean value2) {
            addVisibleCriterion("VISIBLE between", value1, value2, "visible");
            return (Criteria) this;
        }

        public Criteria andVisibleNotBetween(Boolean value1, Boolean value2) {
            addVisibleCriterion("VISIBLE not between", value1, value2, "visible");
            return (Criteria) this;
        }

        public Criteria andParametrosIsNull() {
            addCriterion("PARAMETROS is null");
            return (Criteria) this;
        }

        public Criteria andParametrosIsNotNull() {
            addCriterion("PARAMETROS is not null");
            return (Criteria) this;
        }

        public Criteria andParametrosEqualTo(String value) {
            addCriterion("PARAMETROS =", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosNotEqualTo(String value) {
            addCriterion("PARAMETROS <>", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosGreaterThan(String value) {
            addCriterion("PARAMETROS >", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosGreaterThanOrEqualTo(String value) {
            addCriterion("PARAMETROS >=", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosLessThan(String value) {
            addCriterion("PARAMETROS <", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosLessThanOrEqualTo(String value) {
            addCriterion("PARAMETROS <=", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosLike(String value) {
            addCriterion("PARAMETROS like", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosNotLike(String value) {
            addCriterion("PARAMETROS not like", value, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosIn(List<String> values) {
            addCriterion("PARAMETROS in", values, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosNotIn(List<String> values) {
            addCriterion("PARAMETROS not in", values, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosBetween(String value1, String value2) {
            addCriterion("PARAMETROS between", value1, value2, "parametros");
            return (Criteria) this;
        }

        public Criteria andParametrosNotBetween(String value1, String value2) {
            addCriterion("PARAMETROS not between", value1, value2, "parametros");
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

        public Criteria andDesOperacionLikeInsensitive(String value) {
            addCriterion("upper(DESOPERACION) like", value.toUpperCase(), "desOperacion");
            return (Criteria) this;
        }

        public Criteria andEjecucionLikeInsensitive(String value) {
            addCriterion("upper(EJECUCION) like", value.toUpperCase(), "ejecucion");
            return (Criteria) this;
        }

        public Criteria andParametrosLikeInsensitive(String value) {
            addCriterion("upper(PARAMETROS) like", value.toUpperCase(), "parametros");
            return (Criteria) this;
        }

        public Criteria andIconoLikeInsensitive(String value) {
            addCriterion("upper(ICONO) like", value.toUpperCase(), "icono");
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