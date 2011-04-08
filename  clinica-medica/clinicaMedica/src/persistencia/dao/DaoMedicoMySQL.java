package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import logica.Disponibilidad;
import logica.Especialidad;
import logica.Medico;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataCantConsu;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.dataobjet.DataSalario;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoResumCont;
import vista.dataobjet.VoTurnosDisp;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoMedicoMySQL implements IDaoMedico {

	public void altaMedico(Transaccion trn, DataMed med) throws PersistenciaException {
		System.out.println("Insertando medico: "+med.getId());
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Medico values (?,?,?,?,?,?,?)");
			pst.setString (1, med.getId());
			pst.setString(2, med.getNombre());
			pst.setString(3, med.getApellido());
			pst.setString(4, med.getCi());
			pst.setString(5, med.getTel());
			pst.setInt(6, med.getEsp());
			pst.setString(7, med.getEstado());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public void modifMedico(Transaccion trn, String id, String nom, String apell, String ci, String tel, DataEsp esp) throws PersistenciaException {
		System.out.println("Modificando medico: "+ id);
		try {
			PreparedStatement pst = trn.preparedStatement("update Medicos set nombre=?, apellido=?, ci=?, telefono=?, idEspecialidad=? where id=?");
			pst.setString (1, nom);
			pst.setString(2, apell);
			pst.setString(3, ci);
			pst.setString(4, tel);
			pst.setInt(5, esp.getCodigo());
			pst.setString(6, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void bajarMedico(Transaccion trn, String id) throws PersistenciaException {
		System.out.println("Baja del médico: "+id);
		try {
			PreparedStatement pst = trn.preparedStatement("update Medicos set estado=? WHERE id=?");
			// I = inactivo
			pst.setString(1,"I");
			pst.setString(2, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataMed> listarMedicos(Transaccion trn) throws PersistenciaException {
		System.out.println("Listando Medicos");
		Vector<DataMed> resultado = new Vector<DataMed>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select id, nombre, apellido, ci, telefono, idEspecialidad from Medicos");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String id = rst.getString("Id");
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				String ci = rst.getString("ci");
				String tel = rst.getString("telefono");
				int esp = rst.getInt("idEspecialidad");
				DataMed dataMed = new DataMed(id, nombre, apellido, ci, tel, esp);
				resultado.add(dataMed);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<VoMedEsp> listarMedEsp(int idEsp, Transaccion trn) throws PersistenciaException {
		System.out.println("Listando medicos con especialidad = "+idEsp);
		Vector<VoMedEsp> resultado = new Vector<VoMedEsp>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select id, nombre, apellido from Medicos where idEspecialidad=?");
			pst.setInt(1, idEsp);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String id = rst.getString("Id");
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				VoMedEsp voMed = new VoMedEsp(id, nombre, apellido);
				resultado.add(voMed);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Medico getMedico(Transaccion trn, String id) throws PersistenciaException {
		String pass = null, tipo = null, nombre = null, apellido = null, ci = null, tel = null, estado = null, desc = null;
		int idEsp = 0;
		double monto = 0;
		Medico med = null;
		try {
			PreparedStatement pst = trn.preparedStatement("SELECT U.CONTRASENA, U.TIPO, M.NOMBRE, M.APELLIDO, M.CI, " +
					"M.TELEFONO, M.ESTADO, M.IDESPECIALIDAD, E.DESCRIPCION, E.MONTOBASE" +
					"FROM MEDICOS M, USUARIOS U, ESPECIALIDADES E " +
					"WHERE A.ID=U.ID AND M.IDESPECIALIDAD=E.ID AND ID=?");
			pst.setString(1, id);
 			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				pass = rst.getString("CONTRASENA");
				tipo = rst.getString("TIPO");
				nombre = rst.getString("NOMBRE");
				apellido = rst.getString("APELLIDO");
				ci = rst.getString("CI");
				tel = rst.getString("TELEFONO");
				idEsp = rst.getInt("IDESPECIALIDAD");
				desc = rst.getString("DESCRIPCION");
				monto = rst.getDouble("MONTOBASE");
				estado = rst.getString("ESTADO");
			}
			pst.close();
			Especialidad esp = new Especialidad(idEsp, desc, monto);
			IDaoConsultas daoConsultas = new DaoConsultasMySQL();
			IDaoDisponibilidad daoDisp = new DaoDisponibilidadMySQL();
			med = new Medico(id, pass, tipo, estado, nombre, apellido, ci, tel, esp, daoDisp, daoConsultas);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return med;
	}

	public VosLogin getDataMedico(Transaccion trn, String id) throws PersistenciaException {
		VosLogin vosLogin = null;
		try{
			PreparedStatement pst = trn.preparedStatement("Select M.nombre, M.apellido, U.contrasena, U.tipo from Medicos M, Usuarios U " +
															"WHERE M.id=U.id and id=?");
			pst.setString(1, id);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				String pass = rst.getString("contrasena");
				String tipo = rst.getString("tipo");
				vosLogin = new VosLogin(nombre, apellido, tipo, pass);
			}
			pst.close();
			return vosLogin;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");			
		}
	}

	public boolean validarMed(Transaccion trn, String id) throws PersistenciaException {
		Boolean validar;
		try {
			PreparedStatement pst = trn.preparedStatement("Select estado from Medicos WHERE id=?");
			pst.setString(1, id);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				if(rst.getString(1)== "I")
					validar = false;
				else
					validar = true;
			}
			else{
				validar = false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		return validar;
	}

	public Vector<DataSalario> listarSalarios(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		System.out.println("Listando salarios");
		Vector<DataSalario> resultado = new Vector<DataSalario>();
		IDaoConsultas daoCon = null;
		try {
			PreparedStatement pst = trn.preparedStatement("Select M.id, M.nombre, M.apellido, E.montoBase " +
															"from Medicos M, Especialidades E where M.idEspecialidad=E.id");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String id = rst.getString("Id");
				int cant = daoCon.getCantidadConsultas(trn, fDesde, fHasta, id);
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				double montoBase = rst.getDouble("montoBase");
				double salarioMed = cant*montoBase;
				DataSalario dtSalario = new DataSalario(id, nombre, apellido, salarioMed);
				resultado.add(dtSalario);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataCantConsu> listarMedPremiado(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		Vector<DataCantConsu> vMedPremiado = new Vector<DataCantConsu>();
		IDaoConsultas daoCon = null;
		DataCantConsu medicoPremiado= new DataCantConsu();

		Vector<DataMed> medicos = this.listarMedicos(trn);
		for (int i = 0; i < medicos.size(); i++) {
			String id = medicos.get(i).getId();
			int cant = daoCon.getCantidadConsultas(trn, fDesde, fHasta, id);
			String nombre = medicos.get(i).getNombre();
			String apellido = medicos.get(i).getApellido();
			DataCantConsu dataCantCons = new DataCantConsu(id, nombre, apellido, cant);
			if(medicoPremiado.getCantConsultas()==dataCantCons.getCantConsultas()){
				vMedPremiado.add(medicoPremiado);
			}else{
				if(medicoPremiado.getCantConsultas()<dataCantCons.getCantConsultas()){
					vMedPremiado = null;
					medicoPremiado=dataCantCons;
					vMedPremiado.add(medicoPremiado);
				}
			}
		}
		return vMedPremiado;
	}

	public VoResumCont calcSalarioTotal(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		Vector<DataSalario> vSalarioMed = this.listarSalarios(trn, fDesde, fHasta);
		double salTotal = 0;
		for (int i = 0; i < vSalarioMed.size(); i++) {
			salTotal = salTotal + vSalarioMed.get(i).getSalarioMed();
		}
		VoResumCont vo = new VoResumCont("Salarios", salTotal);
		return vo;
	}
	
	public Vector<Disponibilidad> listarDispMed(DataMed dataMed, Transaccion trn) throws PersistenciaException {
		System.out.println("Listando disponibilidades por medico");
		Medico med = this.getMedico(trn, dataMed.getId());
		IDaoDisponibilidad disp = med.getDisp();
		return disp.listarDispMedico(dataMed.getId(), trn);
	}

	public void cargaConsultasProxMes(Transaccion trn, String id, Calendar fecha) throws PersistenciaException {
		//FALTAAAA
	}

	public Vector<VoTurnosDisp> listarConsultasDisp(Transaccion trn) throws PersistenciaException {
		System.out.println("Listando consultas disponibles");
		Vector<VoTurnosDisp> resultado = new Vector<VoTurnosDisp>();
		int cantTurno = 0, dia =0,horario =0,cons =0;
		Date fecha;
		try {
			PreparedStatement pst = trn.preparedStatement("Select fecha, dia, horario, idconsultorio from Consultas where fecha >=? and turno=0");
			Calendar calHoy = Calendar.getInstance();
			Date hoy = new java.sql.Date(calHoy.getTimeInMillis());
			pst.setDate(1, hoy);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				fecha = rst.getDate("fecha");
				dia = rst.getInt("dia");
				horario = rst.getInt("horario");
				cons = rst.getInt("idconsultario");
				PreparedStatement pst2 = trn.preparedStatement("Select count(*) as cantTurnos from Consultas " +
																"where fecha =? and dia=? and horario=? and idconsultorio=? and turno>0");
				pst2.setDate(1, fecha);
				pst2.setInt(2, dia);
				pst2.setInt(3, horario);
				pst2.setInt(4, cons);
				ResultSet rst2 = pst.executeQuery();
				while(rst2.next()){
					cantTurno = rst.getInt("cantTurnos");
				}
				if (cantTurno<=9){
					Calendar fech = Calendar.getInstance();
					fech.setTime(fecha);
					VoTurnosDisp voTurnosDisp = new VoTurnosDisp(fech, dia, horario, cantTurno+1, cons);
					resultado.add(voTurnosDisp);
				}
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}