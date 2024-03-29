package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataTipoExamen;
import excepciones.PersistenciaException;

public class DaoTipoExamenMySQL implements IDaoTipoExamen {

	public void agregar(Transaccion trn, DataTipoExamen tex) throws PersistenciaException {
		
		try {
			PreparedStatement pst = trn.preparedStatement("insert into TipoExamenes values (?,?)");
			pst.setInt(1, tex.getId());
			pst.setString(2, tex.getNombre());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void modificar(Transaccion trn, DataTipoExamen tex) throws PersistenciaException {
		
		try {
			PreparedStatement pst = trn.preparedStatement("update TipoExamenes set nombre=? where id=?");
			pst.setString(1, tex.getNombre());
			pst.setInt(2, tex.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataTipoExamen> listarTipoEx(Transaccion trn) throws PersistenciaException {
		
		Vector<DataTipoExamen> resultado = new Vector<DataTipoExamen>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select id, nombre from TipoExamenes");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int id = rst.getInt("Id");
				String nombre = rst.getString("nombre");
				DataTipoExamen tex = new DataTipoExamen(id, nombre);
				resultado.add(tex);
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
}
