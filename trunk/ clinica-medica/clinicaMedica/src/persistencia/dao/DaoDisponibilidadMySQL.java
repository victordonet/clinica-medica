package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
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
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<VoDispo> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException {
		Vector<VoDispo> resultado = new Vector<VoDispo>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select dia, horario from Disponibilidad where idMedico=?");
			pst.setString(1, idMed);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int dia = rst.getInt("dia");
				int horario = rst.getInt("horario");
				VoDispo disp = new VoDispo(dia, horario, idMed);
				resultado.add(disp);
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
