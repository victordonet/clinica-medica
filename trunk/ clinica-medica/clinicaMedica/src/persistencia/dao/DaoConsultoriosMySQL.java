package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Consultorio;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataConsultorio;
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
	public boolean validaConsultorio(Transaccion trn, int idConsul) throws PersistenciaException {
		Boolean validar;
		try {
			PreparedStatement pst = trn.preparedStatement("Select id from consultorio WHERE id=?");
			pst.setInt(1, idConsul);
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
	public void altaConsultorio(Transaccion trn, DataConsultorio consultorio) throws PersistenciaException {
		
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Consultorios values (?,?)");
			pst.setInt (1, consultorio.getIdConsultorio());
			pst.setString(2, consultorio.getNombre());
			pst.executeUpdate();
			pst.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

}
