package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.VoMedEsp;
import excepciones.PersistenciaException;

public class DaoParametrosMySQL implements IDaoParametros {

	public String getValor(Transaccion trn, String param) throws PersistenciaException {
		String resultado = null;
		try {
			PreparedStatement pst = trn.preparedStatement("Select valor from Parametros WHERE Parametro="+param);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				resultado = rst.getString("valor");
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

}
