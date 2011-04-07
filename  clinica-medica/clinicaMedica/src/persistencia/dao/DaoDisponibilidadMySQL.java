package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import logica.Disponibilidad;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.VoDispo;
import excepciones.PersistenciaException;

public class DaoDisponibilidadMySQL implements IDaoDisponibilidad {

	public void updateDisponibilidad(VoDispo vo, Transaccion trn) throws PersistenciaException {
		try {
			PreparedStatement pst = trn.preparedStatement("update Disponibilidad set dia=?, horario=? where idmedico=?");
			pst.setInt(1, vo.getDia());
			pst.setInt(2, vo.getHorario());
			pst.setString(3, vo.getIdMed());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<Disponibilidad> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException {
		Vector<Disponibilidad> resultado = new Vector<Disponibilidad>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select dia, horario from Disponibilidad where idMedico=?");
			pst.setString(1, idMed);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int dia = rst.getInt("dia");
				int horario = rst.getInt("horario");
				Disponibilidad disp = new Disponibilidad(dia, horario);
				resultado.add(disp);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
}
