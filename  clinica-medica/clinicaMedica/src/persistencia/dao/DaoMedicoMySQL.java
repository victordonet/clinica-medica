package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import logica.DateIterator;
import logica.Especialidad;
import logica.Medico;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataCantConsu;
import vista.dataobjet.DataDisp;
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

		try {
			PreparedStatement pst = trn.preparedStatement("insert into Medicos values (?,?,?,?,?,?,?)");
			pst.setString (1, med.getId());
			pst.setString(2, med.getNombre());
			pst.setString(3, med.getApellido());
			pst.setString(4, med.getCi());
			pst.setString(5, med.getTel());
			pst.setInt(6, med.getEsp());
			pst.setString(7, med.getEstado());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		} 
	}

	public void modifMedico(Transaccion trn, String id, String nom, String apell, String ci, String tel, DataEsp esp, String estado) throws PersistenciaException {

		try {
			PreparedStatement pst = trn.preparedStatement("update Medicos set nombre=?, apellido=?, ci=?, telefono=?, idEspecialidad=?, estado=? where id=?");
			pst.setString (1, nom);
			pst.setString(2, apell);
			pst.setString(3, ci);
			pst.setString(4, tel);
			pst.setInt(5, esp.getCodigo());
			pst.setString(6, estado);
			pst.setString(7, id);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void bajarMedico(Transaccion trn, String id) throws PersistenciaException {

		try {
			PreparedStatement pst = trn.preparedStatement("update Medicos set estado=? WHERE id=?");
			// I = inactivo
			pst.setString(1,"I");
			pst.setString(2, id);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataMed> listarMedicos(Transaccion trn, String est) throws PersistenciaException {

		Vector<DataMed> resultado = new Vector<DataMed>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select id, nombre, apellido, ci, telefono, idEspecialidad, estado from Medicos where estado in (?,?)");
			
			pst.setString(1, "A");
			pst.setString(2, est);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String id = rst.getString("Id");
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				String ci = rst.getString("ci");
				String tel = rst.getString("telefono");
				int esp = rst.getInt("idEspecialidad");
				String estado = rst.getString("telefono");
				DataMed dataMed = new DataMed(id, nombre, apellido, ci, tel, estado, esp);
				resultado.add(dataMed);
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<VoMedEsp> listarMedEsp(int idEsp, Transaccion trn) throws PersistenciaException {

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
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Medico getMedico(Transaccion trn, String id) throws PersistenciaException {
		String pass = null, tipo = null, nombre = null, apellido = null, ci = null, tel = null, estado = null, desc = null;
		int idEsp = 0;
		double monto = 0;
		Medico med = null;
		try {
			PreparedStatement pst = trn.preparedStatement("SELECT U.CONTRASENA, U.TIPO, M.NOMBRE, M.APELLIDO, M.CI, M.TELEFONO, M.ESTADO, M.IDESPECIALIDAD, E.DESCRIPCION, E.MONTOBASE FROM MEDICOS M, USUARIOS U, ESPECIALIDADES E WHERE M.ID=U.ID AND M.IDESPECIALIDAD=E.ID AND M.ID=?");
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
			rst.close();
			pst.close();
			Especialidad esp = new Especialidad(idEsp, desc, monto);
			IDaoConsultas daoConsultas = new DaoConsultasMySQL();
			IDaoDisponibilidad daoDisp = new DaoDisponibilidadMySQL();
			med = new Medico(id, pass, tipo, estado, nombre, apellido, ci, tel, esp, daoDisp, daoConsultas);
			
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		return med;
	}

	public VosLogin getDataMedico(Transaccion trn, String id) throws PersistenciaException {
		VosLogin vosLogin = null;
		try{
			PreparedStatement pst = trn.preparedStatement("Select M.nombre, M.apellido, U.contrasena, U.tipo from Medicos M, Usuarios U " +
															"WHERE M.id=U.id and M.id=?");
			pst.setString(1, id);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				String pass = rst.getString("contrasena");
				String tipo = rst.getString("tipo");
				vosLogin = new VosLogin(nombre, apellido, tipo, pass);
			}
			rst.close();
			pst.close();
			return vosLogin;
		} catch (SQLException e) {
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
			rst.close();
			pst.close();
		}catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		return validar;
	}

	public Vector<DataSalario> listarSalarios(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		Vector<DataSalario> resultado = new Vector<DataSalario>();
		IDaoConsultas daoCon = new DaoConsultasMySQL();
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
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataCantConsu> listarMedPremiado(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		Vector<DataCantConsu> vMedPremiado = new Vector<DataCantConsu>();
		IDaoConsultas daoCon = new DaoConsultasMySQL();
		DataCantConsu medicoPremiado= new DataCantConsu();

		Vector<DataMed> medicos = this.listarMedicos(trn, "A");
		for (int i = 0; i < medicos.size(); i++) {
			String id = medicos.get(i).getId();
			int cant = daoCon.getCantidadConsultas(trn, fDesde, fHasta, id);
			String nombre = medicos.get(i).getNombre();
			String apellido = medicos.get(i).getApellido();
			DataCantConsu dataCantCons = new DataCantConsu(id, nombre, apellido, cant);
			if(medicoPremiado.getCantConsultas()==dataCantCons.getCantConsultas()&&cant!=0){
				vMedPremiado.add(dataCantCons);
				medicoPremiado = dataCantCons; 
			}else{
				if(medicoPremiado.getCantConsultas()<dataCantCons.getCantConsultas()){
					vMedPremiado = new Vector<DataCantConsu>();
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
	
	public Vector<DataDisp> listarDispMed(String idMed, Transaccion trn) throws PersistenciaException {
		
		Medico med = this.getMedico(trn, idMed);
		IDaoDisponibilidad disp = med.getDisp();
		return disp.listarDispMedico(idMed, trn);
	}

	public void cargaConsultasProxMes(Transaccion trn, String id, int totalConsultorios) throws PersistenciaException {
		
		Medico med = this.getMedico(trn, id);
		Vector<DataDisp> horarios = this.listarDispMed(id, trn);
		IDaoConsultas daoCons = med.getDaoConsultas();
		int contadorConsultorios = 0;
		
		//Para recorrer el mes.
		Calendar calHoy = Calendar.getInstance();
		calHoy.setTime(new java.util.Date());
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		if(calHoy.MONTH==10){
			cal1.set((calHoy.get(Calendar.YEAR))+1,Calendar.JANUARY,1);
		}else{
			if(calHoy.MONTH==11){
				cal1.set((calHoy.get(Calendar.YEAR))+1,Calendar.FEBRUARY,1);
			}else{
				cal1.set(Calendar.YEAR,(calHoy.get(Calendar.MONTH))+2,1);
			}
		}
		
		int diaUltimo = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal2.set(cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH), diaUltimo);
		
		java.util.Date primerDia = new java.sql.Date(cal1.getTimeInMillis());
		java.util.Date ultimoDia = new java.sql.Date(cal2.getTimeInMillis());
		
		for (int i = 0; i < horarios.size(); i++) {
			DataDisp disp = horarios.get(i);

			DateIterator j = new DateIterator(primerDia, ultimoDia);
			while (j.hasNext()) {
				java.util.Date actual = (java.util.Date) j.next();
				Calendar calActual = Calendar.getInstance();
				calActual.setTime(actual);
				int diaSemana = calActual.get(Calendar.DAY_OF_MONTH);
				if (diaSemana==disp.getDia()){
					if (contadorConsultorios<totalConsultorios){
						//Alta de la consulta
						daoCons.altaConsulta(trn, calActual, id, disp.getDia(), "0", contadorConsultorios, 0, disp.getHorario(), false);
					}
					contadorConsultorios++;
				}
			}
		}
	}

	public Vector<VoTurnosDisp> listarConsultasDisp(Transaccion trn) throws PersistenciaException {
		
		Vector<VoTurnosDisp> resultado = new Vector<VoTurnosDisp>();
		int cantTurno = 0, dia =0,hora =0,cons =0;
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
				//int dia = rst.getInt("dia");
				String diaSem = "";
				switch (dia) {
					case 0: diaSem="Domingo"; break;
					case 1: diaSem="Lunes"; break;
					case 2: diaSem="Martes"; break;
					case 3: diaSem="Mi�rcoles"; break;
					case 4: diaSem="Jueves"; break;
					case 5: diaSem="Viernes"; break;
					case 6: diaSem="S�bado"; break;
					default: diaSem="sin d�a"; break;
				}
				hora = rst.getInt("horario");
				String horario = "";
				switch (hora) {
					case 0: horario="00 a 02"; break;
					case 1: horario="02 a 04"; break;
					case 2: horario="04 a 06"; break;
					case 3: horario="06 a 08"; break;
					case 4: horario="08 a 10"; break;
					case 5: horario="10 a 12"; break;
					case 6: horario="12 a 14"; break;
					case 7: horario="14 a 16"; break;
					case 8: horario="16 a 18"; break;
					case 9: horario="18 a 20"; break;
					case 10: horario="20 a 22"; break;
					case 11: horario="22 a 24"; break;
					default: horario="sin horario"; break;
				}
				cons = rst.getInt("idconsultario");
				PreparedStatement pst2 = trn.preparedStatement("Select count(*) as cantTurnos from Consultas " +
																"where fecha =? and dia=? and horario=? and idconsultorio=? and turno>0");
				pst2.setDate(1, fecha);
				pst2.setInt(2, dia);
				pst2.setInt(3, hora);
				pst2.setInt(4, cons);
				ResultSet rst2 = pst.executeQuery();
				while(rst2.next()){
					cantTurno = rst.getInt("cantTurnos");
				}
				if (cantTurno<=9){
					Calendar fech = Calendar.getInstance();
					fech.setTime(fecha);
					VoTurnosDisp voTurnosDisp = new VoTurnosDisp(fech, diaSem, horario, cantTurno+1, cons);
					resultado.add(voTurnosDisp);
				}
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
	public DataMed getDataMed(Transaccion trn, String id) throws PersistenciaException {
		String nombre = null, apellido = null, ci = null, tel = null, estado = null;
		int idEsp = 0;
		DataMed med = null;
		try {
			PreparedStatement pst = trn.preparedStatement("SELECT M.NOMBRE, M.APELLIDO, M.CI, M.TELEFONO, M.ESTADO, IDESPECIALIDAD FROM MEDICOS M WHERE M.ID=?");
			pst.setString(1, id);
 			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				nombre = rst.getString("NOMBRE");
				apellido = rst.getString("APELLIDO");
				ci = rst.getString("CI");
				tel = rst.getString("TELEFONO");
				idEsp = rst.getInt("IDESPECIALIDAD");
				estado = rst.getString("ESTADO");
			}
			rst.close();
			pst.close();
			med = new DataMed(id, nombre, apellido, ci, tel, estado, idEsp);
			
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		return med;
	}
}