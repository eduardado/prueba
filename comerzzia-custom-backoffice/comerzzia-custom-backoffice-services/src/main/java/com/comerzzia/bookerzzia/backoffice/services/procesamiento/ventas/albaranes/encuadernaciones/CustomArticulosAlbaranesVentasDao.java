package com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones;

import java.sql.SQLException;

import com.comerzzia.bookerzzia.backoffice.util.EncuadernacionKeys;
import com.comerzzia.core.model.empresas.ConfigEmpresaBean;
import com.comerzzia.core.util.db.Connection;
import com.comerzzia.core.util.db.PreparedStatement;
import com.comerzzia.model.ventas.albaranes.articulos.ArticuloAlbaranVentaBean;
import com.comerzzia.persistencia.ventas.albaranes.articulos.ArticulosAlbaranesVentasDao;

public class CustomArticulosAlbaranesVentasDao extends ArticulosAlbaranesVentasDao {
	
	private static String TABLA_DETALLE_ALBARANES = "D_CLIE_ALBARANES_DET_TBL";
	
	public static void insert(Connection conn, ArticuloAlbaranVentaBean detalle, ConfigEmpresaBean config) throws SQLException {
		
		String sqlCustom = null;
		PreparedStatement pstmtCustom = null;
		
		sqlCustom =  "INSERT INTO " + getNombreElemento(TABLA_DETALLE_ALBARANES) +
				"(" +
				"UID_ACTIVIDAD, " + 
				"CODALM, " +
				"ID_CLIE_ALBARAN, " +
				"TAPA, " +
				"SUBTITULO, " +
				"DEDICATORIA, " +
				"HECHO " +
				") " +
			  "VALUES (?, ?, ?, ?, ?, ?)";

		
		try {
			pstmtCustom = new PreparedStatement(conn, sqlCustom);
			
			pstmtCustom.setString(1, config.getUidActividad());
			pstmtCustom.setString(2, (String) detalle.getExtension(EncuadernacionKeys.CODIGO_ALMACEN));
			pstmtCustom.setLong(3, detalle.getIdAlbaran());
			pstmtCustom.setString(4, (String) detalle.getExtension(EncuadernacionKeys.TAPA));
			pstmtCustom.setString(5, (String) detalle.getExtension(EncuadernacionKeys.SUBTITULO));
			pstmtCustom.setString(6, (String) detalle.getExtension(EncuadernacionKeys.DEDICATORIA));
			pstmtCustom.setString(6, "S"); // HECHO es NOT NULL
			
        	log.debug("insert() - " + pstmtCustom);
        	pstmtCustom.execute();
		}
		catch (SQLException e) {
			throw getDaoException(e);
		}
		finally {
    		try {
    			pstmtCustom.close();
    		}
    		catch(Exception ignore) {;}
    	}
	}

}
