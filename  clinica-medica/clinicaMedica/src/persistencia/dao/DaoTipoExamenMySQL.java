package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import logica.TipoExamen;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataTipoExamen;
import excepciones.PersistenciaException;

public class DaoTipoExamenMySQL implements IDaoTipoExamen {

	public void agregar(Transaccion trn, DataTipoExamen tex) throws PersistenciaException {
		System.out.println("Insertando tipo examen: "+ tex.getId());
		try {
			PreparedStatement pst = trn.preparedStatement("insert into TipoExamenes values (?,?)");
			pst.setInt(1, tex.getId());
			pst.setString(2, tex.getNombre());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public void modificar(Transaccion trn, DataTipoExamen tex) throws PersistenciaException {
		System.out.println("Modificando tipo de examen: "+tex.getId());
		try {
			PreparedStatement pst = trn.preparedStatement("update TipoExamenes set nombre=? where id=?");
			pst.setString(1, tex.getNombre());
			pst.setInt(2, tex.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<TipoExamen> listarTipoEx(Transaccion trn) throws PersistenciaException {
		System.out.println("Listando Tipos de exámenes");
		Vector<TipoExamen> resultado = new Vector<TipoExamen>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select id, nombre from TipoExamenes");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int id = rst.getInt("Id");
				String nombre = rst.getString("nombre");
				TipoExamen tex = new TipoExamen(id, nombre);
				resultado.add(tex);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
}
