package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataDisp;
import excepciones.PersistenciaException;

public class DaoDisponibilidadMySQL implements IDaoDisponibilidad {

	public void altaDisponibilidad(Transaccion trn, DataDisp dataDsip) throws PersistenciaException {
		System.out.println("Insertando disponibilidad del medico en el dao: "+dataDsip.getIdMed());
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Disponibilidad values (?,?,?)");
			pst.setString(1, dataDsip.getIdMed());
			pst.setInt(2, dataDsip.getDia());
			pst.setInt(3, dataDsip.getHorario());
			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
	public void eliminarDisponibilidad(Transaccion trn, String idMed) throws PersistenciaException {
		
		try {
			PreparedStatement pst = trn.preparedStatement("delete from Disponibilidad where idmedico=?");
			pst.setString(1, idMed);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataDisp> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException {
		System.out.println("Listando disponibilidad del medico: "+idMed);
		Vector<DataDisp> resultado = new Vector<DataDisp>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select dia, horario from Disponibilidad where idMedico=?");
			pst.setString(1, idMed);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int dia = rst.getInt("dia");
				int horario = rst.getInt("horario");
				DataDisp disp = new DataDisp(dia, horario, idMed);
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
	public Vector<DataDisp> listarDispTotal(Transaccion trn) throws PersistenciaException {
		
		Vector<DataDisp> resultado = new Vector<DataDisp>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select dia, horario, idmedico from Disponibilidad ");
		
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int dia = rst.getInt("dia");
				int horario = rst.getInt("horario");
				String idMed = rst.getString("idmedico");
				DataDisp disp = new DataDisp(dia, horario, idMed);
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
