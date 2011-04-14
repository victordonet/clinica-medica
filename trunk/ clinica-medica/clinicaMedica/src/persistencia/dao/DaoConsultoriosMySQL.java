package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public class DaoConsultoriosMySQL implements IDaoConsultorios {

	public int totalConsultorios(Transaccion trn) throws PersistenciaException {
		int resultado = 0;
		try {
			PreparedStatement pst = trn.preparedStatement("Select count(*) as cantidad from Consultorios");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				resultado = rst.getInt("cantidad");
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
	public boolean validarConsultorio(Transaccion trn, String idConsul) throws PersistenciaException {
		Boolean validar;
		try {
			PreparedStatement pst = trn.preparedStatement("Select id from consultorio WHERE id=?");
			pst.setString(1, idConsul);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				validar = true;
			}
			else{
				validar = false;
			}
			rst.close();
			pst.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		return validar;
	}


}
