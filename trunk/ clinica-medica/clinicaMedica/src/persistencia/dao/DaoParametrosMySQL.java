package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public class DaoParametrosMySQL implements IDaoParametros {

	public String getValor(Transaccion trn, String param) throws PersistenciaException {
		String resultado = null;
		try {
			PreparedStatement pst = trn.preparedStatement("Select valor from Parametros WHERE Parametro=?");
			pst.setString(1, param);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				resultado = rst.getString("valor");
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

}
