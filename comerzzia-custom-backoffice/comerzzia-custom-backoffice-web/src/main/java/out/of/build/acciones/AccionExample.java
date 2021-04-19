package com.comerzzia.core.model.acciones;

import java.util.ArrayList;
import java.util.List;

public class AccionExample {
    public static final String ORDER_BY_ID_ACCION = "ID_ACCION";

    public static final String ORDER_BY_ID_ACCION_DESC = "ID_ACCION DESC";

    public static final String ORDER_BY_ACCION = "ACCION";

    public static final String ORDER_BY_ACCION_DESC = "ACCION DESC";

    public static final String ORDER_BY_TIPO_ACCION = "TIPO_ACCION";

    public static final String ORDER_BY_TIPO_ACCION_DESC = "TIPO_ACCION DESC";

    public static final String ORDER_BY_EJECUCION = "EJECUCION";

    public static final String ORDER_BY_EJECUCION_DESC = "EJECUCION DESC";

    public static final String ORDER_BY_PARAMETROS = "PARAMETROS";

    public static final String ORDER_BY_PARAMETROS_DESC = "PARAMETROS DESC";

    public static final String ORDER_BY_DESCRIPCION = "DESCRIPCION";

    public static final String ORDER_BY_DESCRIPCION_DESC = "DESCRIPCION DESC";

    public static final String ORDER_BY_TITULO = "TITULO";

    public static final String ORDER_BY_TITULO_DESC = "TITULO DESC";

    public static final String ORDER_BY_ICONO = "ICONO";

    public static final String ORDER_BY_ICONO_DESC = "ICONO DESC";

    public static final String ORDER_BY_ACTIVO = "ACTIVO";

    public static final String ORDER_BY_ACTIVO_DESC = "ACTIVO DESC";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccionExample() {
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

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            activoCriteria = new ArrayList<Criterion>();
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

        public boolean isValid() {
            return criteria.size() > 0
                || activoCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(activoCriteria);
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

        public Criteria andAccionIsNull() {
            addCriterion("ACCION is null");
            return (Criteria) this;
        }

        public Criteria andAccionIsNotNull() {
            addCriterion("ACCION is not null");
            return (Criteria) this;
        }

        public Criteria andAccionEqualTo(String value) {
            addCriterion("ACCION =", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionNotEqualTo(String value) {
            addCriterion("ACCION <>", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionGreaterThan(String value) {
            addCriterion("ACCION >", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionGreaterThanOrEqualTo(String value) {
            addCriterion("ACCION >=", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionLessThan(String value) {
            addCriterion("ACCION <", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionLessThanOrEqualTo(String value) {
            addCriterion("ACCION <=", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionLike(String value) {
            addCriterion("ACCION like", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionNotLike(String value) {
            addCriterion("ACCION not like", value, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionIn(List<String> values) {
            addCriterion("ACCION in", values, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionNotIn(List<String> values) {
            addCriterion("ACCION not in", values, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionBetween(String value1, String value2) {
            addCriterion("ACCION between", value1, value2, "accion");
            return (Criteria) this;
        }

        public Criteria andAccionNotBetween(String value1, String value2) {
            addCriterion("ACCION not between", value1, value2, "accion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionIsNull() {
            addCriterion("TIPO_ACCION is null");
            return (Criteria) this;
        }

        public Criteria andTipoAccionIsNotNull() {
            addCriterion("TIPO_ACCION is not null");
            return (Criteria) this;
        }

        public Criteria andTipoAccionEqualTo(String value) {
            addCriterion("TIPO_ACCION =", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionNotEqualTo(String value) {
            addCriterion("TIPO_ACCION <>", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionGreaterThan(String value) {
            addCriterion("TIPO_ACCION >", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionGreaterThanOrEqualTo(String value) {
            addCriterion("TIPO_ACCION >=", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionLessThan(String value) {
            addCriterion("TIPO_ACCION <", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionLessThanOrEqualTo(String value) {
            addCriterion("TIPO_ACCION <=", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionLike(String value) {
            addCriterion("TIPO_ACCION like", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionNotLike(String value) {
            addCriterion("TIPO_ACCION not like", value, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionIn(List<String> values) {
            addCriterion("TIPO_ACCION in", values, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionNotIn(List<String> values) {
            addCriterion("TIPO_ACCION not in", values, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionBetween(String value1, String value2) {
            addCriterion("TIPO_ACCION between", value1, value2, "tipoAccion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionNotBetween(String value1, String value2) {
            addCriterion("TIPO_ACCION not between", value1, value2, "tipoAccion");
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

        public Criteria andDescripcionIsNull() {
            addCriterion("DESCRIPCION is null");
            return (Criteria) this;
        }

        public Criteria andDescripcionIsNotNull() {
            addCriterion("DESCRIPCION is not null");
            return (Criteria) this;
        }

        public Criteria andDescripcionEqualTo(String value) {
            addCriterion("DESCRIPCION =", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotEqualTo(String value) {
            addCriterion("DESCRIPCION <>", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThan(String value) {
            addCriterion("DESCRIPCION >", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION >=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThan(String value) {
            addCriterion("DESCRIPCION <", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPCION <=", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionLike(String value) {
            addCriterion("DESCRIPCION like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotLike(String value) {
            addCriterion("DESCRIPCION not like", value, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionIn(List<String> values) {
            addCriterion("DESCRIPCION in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotIn(List<String> values) {
            addCriterion("DESCRIPCION not in", values, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionBetween(String value1, String value2) {
            addCriterion("DESCRIPCION between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andDescripcionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPCION not between", value1, value2, "descripcion");
            return (Criteria) this;
        }

        public Criteria andTituloIsNull() {
            addCriterion("TITULO is null");
            return (Criteria) this;
        }

        public Criteria andTituloIsNotNull() {
            addCriterion("TITULO is not null");
            return (Criteria) this;
        }

        public Criteria andTituloEqualTo(String value) {
            addCriterion("TITULO =", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloNotEqualTo(String value) {
            addCriterion("TITULO <>", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloGreaterThan(String value) {
            addCriterion("TITULO >", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloGreaterThanOrEqualTo(String value) {
            addCriterion("TITULO >=", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloLessThan(String value) {
            addCriterion("TITULO <", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloLessThanOrEqualTo(String value) {
            addCriterion("TITULO <=", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloLike(String value) {
            addCriterion("TITULO like", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloNotLike(String value) {
            addCriterion("TITULO not like", value, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloIn(List<String> values) {
            addCriterion("TITULO in", values, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloNotIn(List<String> values) {
            addCriterion("TITULO not in", values, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloBetween(String value1, String value2) {
            addCriterion("TITULO between", value1, value2, "titulo");
            return (Criteria) this;
        }

        public Criteria andTituloNotBetween(String value1, String value2) {
            addCriterion("TITULO not between", value1, value2, "titulo");
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

        public Criteria andAccionLikeInsensitive(String value) {
            addCriterion("upper(ACCION) like", value.toUpperCase(), "accion");
            return (Criteria) this;
        }

        public Criteria andTipoAccionLikeInsensitive(String value) {
            addCriterion("upper(TIPO_ACCION) like", value.toUpperCase(), "tipoAccion");
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

        public Criteria andDescripcionLikeInsensitive(String value) {
            addCriterion("upper(DESCRIPCION) like", value.toUpperCase(), "descripcion");
            return (Criteria) this;
        }

        public Criteria andTituloLikeInsensitive(String value) {
            addCriterion("upper(TITULO) like", value.toUpperCase(), "titulo");
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