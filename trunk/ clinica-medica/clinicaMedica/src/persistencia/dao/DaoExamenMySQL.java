package persistencia.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import logica.Examen;
import logica.TipoExamen;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataExamen;
import excepciones.PersistenciaException;

public class DaoExamenMySQL implements IDaoExamen, Serializable{

	private static final long serialVersionUID = 1L;

	public int getCantExPagos(Transaccion trn, Calendar fini, Calendar ffin) throws PersistenciaException {
		
		int resultado = 0;
		try {
			PreparedStatement pst = trn.preparedStatement("Select count(*) as cantidad from Examenes where COBRATIMBRE='S'");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				resultado = rst.getInt("cantidad");
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public int getCantExam(Transaccion trn, String idAfi) throws PersistenciaException {
		int resultado = 0;
		Calendar calHoy = Calendar.getInstance();
		Date hoy = new java.sql.Date(calHoy.getTimeInMillis());
		try {
			PreparedStatement pst = trn.preparedStatement("Select count(*) as cantidad from Examenes where idAfiliado=? and YEAR(fechainicio)=YEAR(?)");
			pst.setString(1, idAfi);
			pst.setDate(2, hoy);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				resultado = rst.getInt("cantidad");
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void regEx(Transaccion trn, DataExamen ex, String idAfil) throws PersistenciaException {
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Examenes(IDAFILIADO,FECHAINICIO,IDTIPOEXAMEN,ENVIAMAIL,COBRATIMBRE) values (?,?,?,?,?)");
			pst.setString(1, idAfil);
			Date fInicio = new java.sql.Date(ex.getFechaInicio().getTimeInMillis());
			pst.setDate(2, fInicio);
			pst.setInt(3, ex.getTex().getId());
			pst.setBoolean(4, ex.isEnviaMail());
			pst.setBoolean(5, ex.isCobroTimbre());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		} 
	}

	public Vector<Examen> listarExamAfil(String idAfil, Transaccion trn) throws PersistenciaException {
		//BUSCO EXAMENES DEL AFILIADO
		Vector<Examen> resultado = new Vector<Examen>();
		Date  fechaInicio, fechaResultado;
		Calendar fechaIni = Calendar.getInstance();
		Calendar fechaRes = Calendar.getInstance();
		int tipoEx;
		boolean enviaMail, cobroTimbre;
		try {
			PreparedStatement pst = trn.preparedStatement("SELECT E.IDTIPOEXAMEN, T.NOMBRE AS DESC_EXAMEN, E.ENVIAMAIL, " +
															"E.COBRATIMBRE, E.FECHARESULTADO " +
															"FROM EXAMENES E, TIPOEXAMENES T " +
															"WHERE E.IDTIPOEXAMEN=T.ID AND E.IDAFILIADO=?");
			pst.setString(1, idAfil);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				fechaInicio = rst.getDate("FECHAINICIO");
				fechaIni.setTime(fechaInicio);
				//Tipo de Examen
				tipoEx = rst.getInt("IDTIPOEXAMEN");
				String descTipoEx = rst.getString("DESC_EXAMEN");
				TipoExamen tex = new TipoExamen(tipoEx, descTipoEx);
				//----
				enviaMail = rst.getBoolean("ENVIAMAIL");
				cobroTimbre = rst.getBoolean("COBRATIMBRE");
				fechaResultado = rst.getDate("FECHARESULTADO");
				fechaRes.setTime(fechaResultado);
				Examen ex = new Examen(fechaIni, fechaRes, enviaMail, cobroTimbre, tex);
				resultado.add(ex);
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
}
