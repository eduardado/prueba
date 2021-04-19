/**
 * ComerZZia 3.0
 *
 * Copyright (c) 2008-2015 Comerzzia, S.L.  All Rights Reserved.
 *
 * THIS WORK IS  SUBJECT  TO  SPAIN  AND  INTERNATIONAL  COPYRIGHT  LAWS  AND
 * TREATIES.   NO  PART  OF  THIS  WORK MAY BE  USED,  PRACTICED,  PERFORMED
 * COPIED, DISTRIBUTED, REVISED, MODIFIED, TRANSLATED,  ABRIDGED, CONDENSED,
 * EXPANDED,  COLLECTED,  COMPILED,  LINKED,  RECAST, TRANSFORMED OR ADAPTED
 * WITHOUT THE PRIOR WRITTEN CONSENT OF COMERZZIA, S.L. ANY USE OR EXPLOITATION
 * OF THIS WORK WITHOUT AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO
 * CRIMINAL AND CIVIL LIABILITY.
 *
 * CONSULT THE END USER LICENSE AGREEMENT FOR INFORMATION ON ADDITIONAL
 * RESTRICTIONS.
 */
package com.comerzzia.core.servicios.sesion;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.comerzzia.core.model.acciones.AccionBean;
import com.comerzzia.core.model.empresas.ConfigEmpresaBean;
import com.comerzzia.core.model.empresas.EmpresaBean;
import com.comerzzia.core.model.empresas.EmpresaKey;
import com.comerzzia.core.model.usuarios.UsuarioBean;
import com.comerzzia.core.persistencia.empresas.EmpresaMapper;
import com.comerzzia.core.servicios.empresas.Empresa;
import com.comerzzia.core.servicios.empresas.EmpresaException;
import com.comerzzia.core.servicios.empresas.EmpresaNotFoundException;
import com.comerzzia.core.servicios.eventos.EventoException;
import com.comerzzia.core.servicios.eventos.ServicioEventosImpl;
import com.comerzzia.core.servicios.menu.ArbolMenuBean;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.variables.ServicioVariablesImpl;
import com.comerzzia.core.util.config.ComerzziaApp;
import com.comerzzia.core.util.db.Connection;
import com.comerzzia.core.util.db.Database;
import com.comerzzia.core.util.i18n.Translation;


/**
 * Datos de una sesión
 * 
 */
public class DatosSesionBean extends BasicSessionBean {	
	private String uidSesion;
	
	/**
	 * Datos del usuario de la sesión
	 */
	private UsuarioBean usuario;

	/**
	 * Menu del usuario
	 */
	protected ArbolMenuBean menu;
	
	/**
	 * Datos de la empresa
	 */
	private Empresa empresa;
	
	/**
	 * Variables de la sesión
	 */
	private Map<String, String> variables = new HashMap<String, String>();
	
	
	/**
	 * Cache de Permisos de Acciones asociados al usuario de la sesión
	 */
	protected PermisosAccionesSesion permisos = new PermisosAccionesSesion(this);
    	
	private boolean desglose1Activo;
	
	private boolean desglose2Activo;
	
	private String tituloDesglose1;
	
	private String tituloDesglose2;

	public DatosSesionBean() {
		uidSesion = UUID.randomUUID().toString();
	}
	
	public DatosSesionBean(String uidSesion) {
		this.uidSesion = uidSesion;
	}
	
	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
		this.setUser(usuario.getUsuario());
		this.setUserId(usuario.getIdUsuario());
	}

	public ArbolMenuBean getArbolMenu() {
		return menu;
	}

	public void setArbolMenu(ArbolMenuBean menu) {
		this.menu = menu;
	}
	
	public Empresa getEmpresa(){
		return this.empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public EmpresaBean getDatosEmpresa() {
		return this.empresa.getDatosEmpresa();
	}

	public ConfigEmpresaBean getConfigEmpresa() {
		return this.empresa.getConfigEmpresa();
	}

	/**
	 * Establece el valor del atributo variables
	 * @param variables Mapa con las variables que se van a guardar en sesión
	 */
	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}

	/**
	 * Obtiene el valor del atributo variables
	 * @return Mapa con las variables guardadas en sesión
	 */
	public Map<String, String> getVariables() {
		return variables;
	}
	
	/**
     * Guarda el valor de una variable guardada en sesión
     * @param variable Nombre de la variable
     * @param valor Valor de la variable
     */
    public void setVariable(String variable, String valor) {
        variables.put(variable, valor);
    }
    
    /**
     * Obtiene el valor de una variable guardada en sesión
     * @param variable Nombre de la variable
     * @return Valor de la variable
     */
    public String getVariable(String variable) {
        return (String) variables.get(variable);
    }
	
	
	/**
	 * Obtiene los permisos que el usuario de la sesión tiene sobre la acción indicada
	 * @param accion
	 * @return
	 */
	public PermisosEfectivosAccionBean getPermisos(AccionBean accion) {
		return permisos.getPermisos(accion);
	}
	
	
	/**
	 * Obtiene los permisos que el usuario de la sesión tiene sobre la acción indicada
	 * Se consulta la caché de permisos de la sesión, y si no se encuentra en ella
	 * se obtienen y se cachean para sucesivas consultas
	 * @param accion
	 * @return
	 */
	public PermisosEfectivosAccionBean getPermisosCache(AccionBean accion) {
		return permisos.getPermisosCache(accion);
	}

	@Override
	public void setUidInstancia(String uidInstancia) throws EmpresaException {
		// Por compatibilidad de método que reciben un ConfigEmpresaBean en vez de un DatosSessionBean
		if(empresa == null) {
			ConfigEmpresaBean configEmpresa = new ConfigEmpresaBean();
			configEmpresa.setUidInstancia(uidInstancia);
			
			// Actualizamos los datos de la sesión
			setEmpresa(new Empresa(new EmpresaBean(), configEmpresa));
		}
		else {
			if(!empresa.getConfigEmpresa().getUidInstancia().isEmpty() && !empresa.getConfigEmpresa().getUidInstancia().equals(uidInstancia)) {
				throw new EmpresaException(getTranslation()._("No puede cambiar la instancia si es diferente a la de la empresa seleccionada"));
			}
			else{
				empresa.getConfigEmpresa().setUidInstancia(uidInstancia);
			}
		}
		
		super.setUidInstancia(uidInstancia);
	}

	/* (non-Javadoc)
	 * @see com.comerzzia.core.servicios.sesion.IDatosSesion#getCodEmpresa()
	 */
	@Override
	public String getCodEmpresa() {
		return getEmpresa().getDatosEmpresa().getCodEmp();
	}
	
	@Override
	public void setUidActividad(String uidActividad) throws EmpresaException {
		// Por compatibilidad de método que reciben un ConfigEmpresaBean en vez de un DatosSessionBean
		if(empresa == null) {
			ConfigEmpresaBean configEmpresa = new ConfigEmpresaBean();
			configEmpresa.setUidActividad(uidActividad);
			
			// Actualizamos los datos de la sesión
			setEmpresa(new Empresa(new EmpresaBean(), configEmpresa));
		}
		else {
			if(!empresa.getConfigEmpresa().getUidActividad().isEmpty() && !empresa.getConfigEmpresa().getUidActividad().equals(uidActividad)) {
				throw new EmpresaException(getTranslation()._("No puede cambiar la actividad si es diferente a la de la empresa seleccionada"));
			}
			else{
				empresa.getConfigEmpresa().setUidActividad(uidActividad);
			}
		}
		
		super.setUidActividad(uidActividad);
		
		this.desglose1Activo = false;
		this.desglose2Activo = false;
		try {
			String desglose1Titulo = ServicioVariablesImpl.get().consultarValor(this, "ARTICULOS.DESGLOSE1_TITULO");
			if(desglose1Titulo != null && !desglose1Titulo.isEmpty()) {
				this.desglose1Activo = true;
				this.tituloDesglose1 = desglose1Titulo;
			}
		
			String desglose2Titulo = ServicioVariablesImpl.get().consultarValor(this, "ARTICULOS.DESGLOSE2_TITULO");
			if(desglose2Titulo != null && !desglose2Titulo.isEmpty()) {
				this.desglose2Activo = true;
				this.tituloDesglose2 = desglose2Titulo;
			}
		} catch (Exception e) {
			
		}
	}
	
	public void setEmpresaSeleccionada(String codEmpresa) throws EmpresaNotFoundException, SQLException {
		Connection conn = new Connection();

		try {
			// Obtenemos una conexión
			conn.abrirConexion(Database.getConnection());

			ConfigEmpresaBean configEmpresa = new ConfigEmpresaBean();
			// Inicializamos el objeto ConfigEmpresaBean
			configEmpresa.setUidInstancia(getUidInstancia());
			configEmpresa.setUidActividad(getUidActividad());
			configEmpresa.setCodEmpresa(codEmpresa);
			configEmpresa.setTranslation(getTranslation());
			
			// Creamos el objeto empresa
			Empresa empresa = new Empresa(getEmpresa(conn, configEmpresa) , configEmpresa);
			
			// Obtenemos los datos de la empresa
			setEmpresa(empresa);
		} 
		finally {
			conn.cerrarConexion();
		}
	}
	
	protected EmpresaBean getEmpresa(Connection conn, ConfigEmpresaBean configEmpresa) throws SQLException, EmpresaNotFoundException  {
		SqlSession sqlSession = getSqlSessionFactory().openSession(conn);
		
		EmpresaMapper empresaMapper = sqlSession.getMapper(EmpresaMapper.class);
		EmpresaKey empresaKey = new EmpresaKey();
		empresaKey.setUidActividad(getUidActividad());
		empresaKey.setCodEmp(configEmpresa.getCodEmpresa());
		
		// Obtenemos los datos de la empresa
		EmpresaBean empresa = empresaMapper.selectFromViewByPrimaryKey(empresaKey);
		if (empresa == null) {
			String msg = getTranslation()._("No existe ninguna empresa definida en el sistema");
			throw new EmpresaNotFoundException(msg);
		}

		return empresa;
	}
	
	@Override
	public void setTranslation(Translation translation) {
		if(empresa != null) {
			empresa.getConfigEmpresa().setTranslation(translation);
		}
		super.setTranslation(translation);
		
		if (translation != null) {
		   super.setLocale(translation.getLocale());
		}
	}

	public String getUidSesion() {
		return uidSesion;
	}
	
	public void registraEventoSesion(String tipoEvento) throws EventoException {
		//Registramos el evento de acceso a la aplicación.
		ServicioEventosImpl.get().registrarEventoAcceso(this, tipoEvento);
	}

	@Override
	@Deprecated
	public SqlSessionFactory getSqlSessionFactory() {
		return ComerzziaApp.get().getSqlSessionFactory();
	}
	

//	@Override
//	@Deprecated
//	public <T> T doInSqlTransaction(SqlTransaction<T> sqlTransaction) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		try {
//			T result = sqlTransaction.execute(sqlSession);
//			sqlSession.commit();
//			return result;
//		} catch (RuntimeException e) {
//			sqlSession.rollback();
//			throw e;
//		} finally {
//			sqlSession.close();
//		}
//	}

	public boolean isDesglose1Activo() {
		return desglose1Activo;
	}

	public void setDesglose1Activo(boolean desglose1Activo) {
		this.desglose1Activo = desglose1Activo;
	}

	public boolean isDesglose2Activo() {
		return desglose2Activo;
	}

	public void setDesglose2Activo(boolean desglose2Activo) {
		this.desglose2Activo = desglose2Activo;
	}

	public String getTituloDesglose1() {
		return tituloDesglose1;
	}

	public void setTituloDesglose1(String tituloDesglose1) {
		this.tituloDesglose1 = tituloDesglose1;
	}

	public String getTituloDesglose2() {
		return tituloDesglose2;
	}

	public void setTituloDesglose2(String tituloDesglose2) {
		this.tituloDesglose2 = tituloDesglose2;
	}
}

