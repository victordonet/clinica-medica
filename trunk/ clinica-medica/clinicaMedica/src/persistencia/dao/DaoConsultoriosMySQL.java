package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
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
			PreparedStatement pst = trn.preparedStatement("Select id from consultorios WHERE id=?");
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

	public void bajaConsultorio(Transaccion trn, int idConsultorio) throws PersistenciaException {
		try {
			PreparedStatement pst = trn.preparedStatement("delete from Consultorios where id =?");
			pst.setInt (1, idConsultorio);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public Vector<DataConsultorio> listarConsultorios(Transaccion trn) throws PersistenciaException {
		System.out.println("Listando Administrativos");
		Vector<DataConsultorio> resultado = new Vector<DataConsultorio>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select * from consultorios");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int id = rst.getInt("id");
				String nombre = rst.getString("nombre");
				DataConsultorio dataC = new DataConsultorio(id, nombre);
				resultado.add(dataC);
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
