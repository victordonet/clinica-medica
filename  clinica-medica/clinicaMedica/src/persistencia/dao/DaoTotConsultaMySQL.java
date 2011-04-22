package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataConsAfi;
import vista.dataobjet.DataConsFecha;
import excepciones.PersistenciaException;

public class DaoTotConsultaMySQL implements IDaoTotConsulta {
	
	public int getCantConsult(Transaccion trn, String idAfi) throws PersistenciaException{
		int cantidadConsulta = 0;
		Calendar calHoy = Calendar.getInstance();
		Date hoy = new java.sql.Date(calHoy.getTimeInMillis());
		try {
			PreparedStatement pst = trn.preparedStatement("select count(idafiliado) as cantidad from consultas " +
															"where idafiliado = ? and YEAR(fecha)=YEAR(?) and turno>0");
			pst.setString(1, idAfi);
			pst.setDate(2, hoy);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				cantidadConsulta = rst.getInt("cantidad");
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return cantidadConsulta;
	}

	public int getCantConsultasPagas(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		int cantidadConsulta = 0;
		try {
			PreparedStatement pst = trn.preparedStatement("select count(idafiliado) as cantidad from consultas " +
															"where fecha between ? and ? and timbre = 'S' and turno>0");
			Date desde = new java.sql.Date(fDesde.getTimeInMillis());
			Date hasta = new java.sql.Date(fHasta.getTimeInMillis());
			pst.setDate(1,desde);
			pst.setDate(2,hasta);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				cantidadConsulta = rst.getInt("cantidad");
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return cantidadConsulta;
	}

	
	public Vector<DataConsAfi> listarConsultasAfi(Transaccion trn, String id) throws PersistenciaException {
		Vector<DataConsAfi> consultas  = new Vector<DataConsAfi>();
		try {
			PreparedStatement pst = trn.preparedStatement("select c.fecha, m.nombre, m.apellido from consultas c, medicos m " +
															"where c.idmedico = m.id and c.idafiliado = ? and turno>0");
			pst.setString (1, id);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				Date fecha = rst.getDate("fecha");
				String nom = rst.getString("nombre");
				String ape = rst.getString("apellido");
				Calendar cal = Calendar.getInstance();
				cal.setTime(fecha);
				DataConsAfi data = new DataConsAfi(cal, nom, ape);
				consultas.add(data);
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return consultas;
	}

	public Vector<DataConsFecha> listarConsFecha(Transaccion trn, Calendar fecha) throws PersistenciaException {
		Vector<DataConsFecha> consultas  = new Vector<DataConsFecha>();
		try {
			PreparedStatement pst = trn.preparedStatement("select m.nombre as nomMed, m.apellido as apeMed, a.nombre as nomAfi, " +
					"a.apellido as apeAfi, c.idconsultorio, c.turno from consultas c, afiliados a, medicos m " +
					"where c.idmedico = m.id and c.idafiliado = a.id and c.fecha = ? and turno>0");
			Date dia = new java.sql.Date(fecha.getTimeInMillis());
			pst.setDate (1, dia);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String nomMed = rst.getString("nomMed");
				String apeMed = rst.getString("apeMed");
				String nomAfi = rst.getString("nomAfi");
				String apeAfi = rst.getString("apeAfi");
				int consultorio = rst.getInt("idconsultorio");
				int turno = rst.getInt("turno");
				DataConsFecha data = new DataConsFecha(fecha, nomMed, apeMed, nomAfi, apeAfi, consultorio, turno);
				consultas.add(data);
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return consultas;
	}

	public void elimConsultaAfi(Transaccion trn, String idAfi) throws PersistenciaException {
		System.out.println("Baja del las consultas pendientes del afiliado ="+ idAfi);
		try {
			PreparedStatement pst = trn.preparedStatement("delete from Consultas where idAfiliado = ? and fecha >= ?");
			pst.setString(1,idAfi);
			Calendar hoy = Calendar.getInstance(); 
			Date dia = new java.sql.Date(hoy.getTimeInMillis());
			pst.setDate(2, dia);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
	public void elimConsultaMed(Transaccion trn, String idMed) throws PersistenciaException {
		System.out.println("Baja del las consultas pendientes del Medico ="+ idMed);
		try {
			PreparedStatement pst = trn.preparedStatement("delete from Consultas where idMedico = ? and fecha >= ?");
			pst.setString(1,idMed);
			Calendar hoy = Calendar.getInstance(); 
			Date dia = new java.sql.Date(hoy.getTimeInMillis());
			pst.setDate(2, dia);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
}
