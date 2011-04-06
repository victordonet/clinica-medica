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
		
		int dia = vo.getDia();
		int horario = vo.getHorario();
		int idMed = vo.getIdMed();
		int cantConsultas;
		int nuevaConsulta = 0;
		PreparedStatement pst = trn.preparedStatement("Select count (idconsultorio) as cantConsultas FROM Disponibilidad WHERE dia="+dia+" & horario="+horario+" & idmedico="+idMed+"");
		try {
			ResultSet rst = pst.executeQuery();
			if(rst.next())
				cantConsultas = rst.getInt(1);
			else
				cantConsultas = 0;
			pst.close();
			
			if (cantConsultas<5)
				nuevaConsulta = cantConsultas + 1;
				PreparedStatement pst1 = trn.preparedStatement("update Disponibilidad set dia=?, horario=?, idconsultorio=? where idmedico=?");
				pst1.setInt(1, idMed);
				pst1.setInt(2, dia);
				pst1.setInt(3, horario);
				pst1.setInt(4, nuevaConsulta);
				pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<Disponibilidad> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException {
		Vector<Disponibilidad> resultado = new Vector<Disponibilidad>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select dia, horario from Disponibilidad where idMedico="+idMed);
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
