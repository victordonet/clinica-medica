package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.DataConsultas;
import vista.dataobjet.VoTurnosDisp;
import excepciones.PersistenciaException;

public class DaoConsultasMySQL implements IDaoConsultas {

	public int getCantidadConsultas(Transaccion trn, Calendar fDesde, Calendar fHasta, String idMed) throws PersistenciaException {
		int cantidadConsulta = 0;	
		try {
			PreparedStatement pst = trn.preparedStatement("select count(*) as cantidad from consultas where idMedico = ?");
			pst.setString (1, idMed);
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

	public void altaConsultaProxMes(Transaccion trn, DataConsulta cons, String idMed) throws PersistenciaException {
		System.out.println("Insertando consulta proximo mes");
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Consultas values (?,?,?,?,?,?,?,?)");
			pst.setString(1, idMed);
			pst.setString(2, cons.getIdAfil());
			Date fecha = new java.sql.Date(cons.getFecha().getTimeInMillis());
			pst.setDate(3, fecha);
			pst.setInt(4, cons.getDia());
			pst.setInt(5, cons.getIdConsultorio());
			pst.setInt(6, cons.getTurno());
			pst.setInt(7, cons.getHorario());
			pst.setBoolean(8, cons.isPagoConsulta());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public Vector<VoTurnosDisp> listarConsultasDisp(Transaccion trn, String idMed) throws PersistenciaException {
		Vector<VoTurnosDisp> consultas  = new Vector<VoTurnosDisp>();
		try {
			PreparedStatement pst = trn.preparedStatement("select fecha, dia, horario, (select count(turno)+1 from consultas co where co.idMedico=c.idMedico and co.fecha=c.fecha and co.idconsultorio=c.idConsultorio and co.turno>0) as proxTurno, idConsultorio from consultas c where idmedico = ? and fecha>= ? and turno = 0");
			pst.setString(1, idMed);
			Calendar hoy = Calendar.getInstance(); 
			Date fechaHoy = new java.sql.Date(hoy.getTimeInMillis());
			pst.setDate(2, fechaHoy);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				Date fecha = rst.getDate("fecha");
				int dia = rst.getInt("dia");
				int horario = rst.getInt("horario");
				int proxTurno = rst.getInt("proxTurno");
				int idConsultorio = rst.getInt("idConsultorio");
				Calendar cal = Calendar.getInstance();
				cal.setTime(fecha);
				VoTurnosDisp data = new VoTurnosDisp(cal, dia, horario, proxTurno, idConsultorio);
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

	public void altaConsulta(Transaccion trn, Calendar fecha, String idMed, int dia, String idAfil, int consult, int turno, int horario, boolean timbre) throws PersistenciaException {
		System.out.println("Insertando nueva consulta para el medico: "+idMed);
		PreparedStatement pst;
		try {
			pst = trn.preparedStatement("insert into Consultas values (?,?,?,?,?,?,?,?)");
			pst.setString(1, idMed);
			pst.setString(2, idAfil);
			Date date = new java.sql.Date(fecha.getTimeInMillis());
			pst.setDate(3, date);
			pst.setInt(4, dia);
			pst.setInt(5, consult);
			pst.setInt(6, turno);
			pst.setInt(7, horario);
			pst.setBoolean(8, timbre);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public void elimConsultasAfil(Transaccion trn, String idAfi) throws PersistenciaException {
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

	public Vector<DataConsultas> listarConsultas(Transaccion trn)
			throws PersistenciaException {
		Vector<DataConsultas> consultas  = new Vector<DataConsultas>();
		try {
			PreparedStatement pst = trn.preparedStatement("select c.idConsultorio, CONCAT(m.nombre,' ',m.apellido) as nomMed, c.horario from consultas c, medicos m where fecha=? and c.idmedico=m.id");
			Calendar hoy = Calendar.getInstance();
			java.sql.Date fhoy = new java.sql.Date(hoy.getTimeInMillis());
			pst.setDate(1, fhoy);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int idConsultorio = rst.getInt("idConsultorio");
				String nomMed = rst.getString("nomMed");
				int hora = rst.getInt("horario");
				String horario = "";
				switch (hora) {
					case 0: horario="00 a 02"; break;
					case 2: horario="02 a 04"; break;
					case 4: horario="04 a 06"; break;
					case 6: horario="06 a 08"; break;
					case 8: horario="08 a 10"; break;
					case 10: horario="10 a 12"; break;
					case 12: horario="12 a 14"; break;
					case 14: horario="14 a 16"; break;
					case 16: horario="16 a 18"; break;
					case 18: horario="18 a 20"; break;
					case 20: horario="20 a 22"; break;
					case 22: horario="22 a 24"; break;
					default: horario="sin horario"; break;
				}
				DataConsultas data = new DataConsultas(idConsultorio, nomMed, horario);
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
}
