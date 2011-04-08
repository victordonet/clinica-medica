package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.DataMed;
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
			PreparedStatement pst = trn.preparedStatement("select fecha,"+
					"dia,"+
					"horario,"+
						"(select count(turno)+1 from consultas c1"+ 
							"where c1.idMedico=c.idMedico "+
							"and c1.fecha=c.fecha "+
							"and c1.idconsultorio=c.idConsultorio"+
							"and c1.turno>0) as proxTurno,"+
					"idConsultorio"+
					"from consultas c"+										
					"where idmedico = ?"+
					"and fecha>= ?"+
					"and turno = 0");
			pst.setString (1, idMed);
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

	public void altaConsulta(Transaccion trn, Calendar fecha, String idMed, int dia, DataAfiliado afil, int consult, int turno, int horario, boolean timbre) throws PersistenciaException {
		System.out.println("Insertando nueva consulta para el medico: "+idMed);
		PreparedStatement pst;
		try {
			pst = trn.preparedStatement("insert into Consultas values (?,?,?,?,?,?,?,?)");
			pst.setString(1, idMed);
			pst.setString(2, afil.getId());
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
			PreparedStatement pst = trn.preparedStatement("delete Consultas where idAfiliado = ? and fecha >= ?");
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
}
