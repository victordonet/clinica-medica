package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import logica.Especialidad;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataEsp;
import excepciones.PersistenciaException;

public class DaoEspecialidadesMySQL implements IDaoEspecialidades {

	public void altaEspecialidad(Transaccion trn, Especialidad esp) throws PersistenciaException {
		
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Especialidades values (?,?,?)");
			pst.setInt(1, esp.getIdEspecialidad());
			pst.setString(2, esp.getDescripcion());
			pst.setDouble(3, esp.getMontoBase());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataEsp> listarEspecialidades(Transaccion trn) throws PersistenciaException {
		
		Vector<DataEsp> resultado = new Vector<DataEsp>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select * from Especialidades");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int id = rst.getInt("Id");
				String descripcion = rst.getString("Descripcion");
				double monto = rst.getDouble("MontoBase");
				DataEsp dataEsp = new DataEsp(id, descripcion, monto);
				resultado.add(dataEsp);
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public DataEsp obtenerEspecialidad(Transaccion trn, int idEsp) throws PersistenciaException {
		DataEsp esp = null;
		try {
			PreparedStatement pst = trn.preparedStatement("Select * from Especialidades where id=?");
			pst.setInt(1, idEsp);
			ResultSet rst = pst.executeQuery();
			if (rst.next()){
				int id = rst.getInt("Id");
				String descripcion = rst.getString("Descripcion");
				double monto = rst.getDouble("MontoBase");
				esp = new DataEsp(id, descripcion, monto);
			}
			rst.close();
			pst.close();
			return esp;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void bajaEspecialidad(Transaccion trn, int idEsp) throws PersistenciaException {
		
		try {
			PreparedStatement pst = trn.preparedStatement("delete from Especialidades values id=?");
			pst.setInt(1, idEsp);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		} 
	}
}