package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.VoDispo;
import excepciones.PersistenciaException;

public class DaoDisponibilidadMySQL implements IDaoDisponibilidad {

	@Override
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
				PreparedStatement pst1 = trn.preparedStatement("update Disponibilidad set idmedico=?, dia=?, horario=?, idconsultorio=?");
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

}
