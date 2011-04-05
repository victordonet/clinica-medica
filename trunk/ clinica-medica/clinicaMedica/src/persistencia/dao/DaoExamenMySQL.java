package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import persistencia.transacciones.Transaccion;
import logica.Examen;
import excepciones.PersistenciaException;

public class DaoExamenMySQL implements IDaoExamen {

	public int getCantExPagos(Transaccion trn, Calendar fini, Calendar ffin) throws PersistenciaException {
		System.out.println("Listando cantidad de exámenes pagos");
		int resultado = 0;
		try {
			PreparedStatement pst = trn.preparedStatement("Select count(*) as cantidad from Examenes where COBRATIMBRE='S'");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				resultado = rst.getInt("cantidad");
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public int getCantExam(Transaccion trn, Calendar fecha) throws PersistenciaException {
		System.out.println("Listando cantidad de exámenes");
		int resultado = 0;
		try {
			PreparedStatement pst = trn.preparedStatement("Select count(*) as cantidad from Examenes");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				resultado = rst.getInt("cantidad");
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void regEx(Transaccion trn, Examen ex, String idAfil) throws PersistenciaException {
		System.out.println("Registrando nuevo examen");
		PreparedStatement pst;
		try {
			pst = trn.preparedStatement("insert into Examenes(IDAFILIADO,FECHAINICIO,IDTIPOEXAMEN,ENVIAMAIL,COBRATIMBRE) values (?,?,?,?,?)");
			pst.setString(1, idAfil);
			Date fInicio = new java.sql.Date(ex.getFechaInicio().getTimeInMillis());
			pst.setDate(2, fInicio);
			pst.setInt(3, ex.getTex().getId());
			pst.setBoolean(4, ex.isEnviaMail());
			pst.setBoolean(5, ex.isCobroTimbre());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}
