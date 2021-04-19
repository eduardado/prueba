package com.comerzzia.core.servicios.sesion;

import java.util.Locale;

import org.apache.ibatis.session.SqlSessionFactory;

import com.comerzzia.core.util.i18n.Translation;

public interface IDatosSesion {

	String getUidInstancia();

	String getUidActividad();
	
	String getUser();
	
	Long getUserId();
	
	Locale getLocale();

	String getCodEmpresa();
	
    @Deprecated
	SqlSessionFactory getSqlSessionFactory();
    
	Translation getTranslation();
	
//	/**
//	 * Abre y cierra un SqlSession en un bloque try-catch. Hace commit() después de ejecutar el callback sqlTransaction y hace rollback() si el callback tira un RuntimeException
//	 * @param sqlTransaction
//	 * @return
//	 */
//    @Deprecated
//	<T> T doInSqlTransaction(SqlTransaction<T> sqlTransaction);
//	
//    @Deprecated
//	public static interface SqlTransaction<T> {
//		T execute(SqlSession sqlSession);
//	}
	
}