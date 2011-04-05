package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import logica.Afiliado;
import logica.Especialidad;
import logica.Medico;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataMed;
import vista.dataobjet.DataSalario;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoMedicoMySQL implements IDaoMedico {

	public void altaMedico(Transaccion trn, Medico med) throws PersistenciaException {
		System.out.println("Insertando medico: "+med.getId());
		PreparedStatement pst;
		try {
			pst = trn.preparedStatement("insert into Medico values (?,?,?,?,?,?,?)");
			pst.setString (1, med.getId());
			pst.setString(2, med.getNombre());
			pst.setString(3, med.getApellido());
			pst.setString(4, med.getCi());
			pst.setString(5, med.getTel());
			pst.setInt(6, med.getEsp().getIdEspecialidad());
			pst.setString(7, med.getEstado());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public void modifMedico(Transaccion trn, String id, String nom, String apell, String ci, String tel, Especialidad esp) throws PersistenciaException {
		System.out.println("Modificando medico: "+ id);
		PreparedStatement pst;
		pst = trn.preparedStatement("update Medicos set nombre=?, apellido=?, ci=?, telefono=?, idEspecialidad=? where id="+id);
		try {
			pst.setString (1, nom);
			pst.setString(2, apell);
			pst.setString(3, ci);
			pst.setString(4, tel);
			pst.setInt(5, esp.getIdEspecialidad());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void bajarMedico(Transaccion trn, String id) throws PersistenciaException {
		System.out.println("Baja del médico: "+id);
		PreparedStatement pst;
		pst = trn.preparedStatement("update Medicos set estado=? WHERE id="+id);
		try {
			// I = inactivo
			pst.setString(1,"I");
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
			PreparedStatement pst = trn.preparedStatement("Select id, nombre, apellido from Medicos where idEspecialidad="+idEsp);
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
		
		//BUSCO MEDICO c/USUARIOS y ESPECIALIDAD
		String pass = null, tipo = null, nombre = null, apellido = null, ci = null, tel = null, estado = null, desc = null;
		int idEsp = 0;
		double monto = 0;
		Medico med = null;
		
		PreparedStatement pst = trn.preparedStatement("SELECT U.CONTRASENA, U.TIPO, M.NOMBRE, M.APELLIDO, M.CI, " +
													"M.TELEFONO, M.ESTADO, M.IDESPECIALIDAD, E.DESCRIPCION, E.MONTOBASE" +
													"FROM MEDICOS M, USUARIOS U, ESPECIALIDADES E " +
													"WHERE A.ID=U.ID AND M.IDESPECIALIDAD=E.ID AND ID="+id+"");
		ResultSet rst;
		try {
			rst = pst.executeQuery();
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
			//DISPONIBILIDAD ????????
			med = new Medico(id, pass, tipo, estado, nombre, apellido, ci, tel, esp, null, daoConsultas);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return med;
	}

	public VosLogin getDataMedico(Transaccion trn, String id) throws PersistenciaException {
		VosLogin vosLogin = null;
		try{
			PreparedStatement pst = trn.preparedStatement("Select M.nombre, M.apellido, U.contrasena, U.tipo from Medicos M, Usuarios U WHERE M.id=U.id and id="+id+"");
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
			PreparedStatement pst = trn.preparedStatement("Select estado from Medicos WHERE id="+id+"");
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
		int cant = daoCon.getCantidadConsultas(trn, fDesde, fHasta);
		
		try {
			PreparedStatement pst = trn.preparedStatement("Select M.id, M.nombre, M.apellido, E.montoBase*"+cant+" as salarioMed from Medicos M, Especialidades E where M.idEspecialidad=E.id");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String id = rst.getString("Id");
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				double salarioMed = rst.getDouble("salarioMed");
				DataSalario dtSalario = new DataSalario(id, nombre, apellido, salarioMed);
				resultado.add(dtSalario);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector listarMedPremiado(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		return null;
	}

	public Vector calcSalarioTotal(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		return null;
	}

	public Vector listarDispMed(DataMed dataMed, Transaccion trn) throws PersistenciaException {
		System.out.println("Listando disponibilidades por medico");
		Vector<VoMedEsp> resultado = new Vector<VoMedEsp>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select dia, horario, idConsultorio from Disponibilidad where idMedico="+dataMed.getId());
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String dia = rst.getString("dia");
				int horario = rst.getInt("horario");
				int idConsultorio = rst.getInt("idConsultorio");
				//VoMedEsp voMed = new VoMedEsp(id, nombre, apellido);
				//resultado.add(voMed);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void cargaConsultasProxMes(Transaccion trn, String id, Calendar fecha) throws PersistenciaException {

	}

	public Vector listarConsultasDisp(Transaccion trn) throws PersistenciaException {
		return null;
	}

	public void altaConsulta(Transaccion trn, Calendar fecha, String id, int dia, Afiliado afil, int consult) throws PersistenciaException {
		System.out.println("Insertando nueva consulta para el medico: "+id);
		PreparedStatement pst;
		try {
			pst = trn.preparedStatement("insert into Consultas values (?,?,?,?,?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, afil.getId());
			Date date = new java.sql.Date(fecha.getTimeInMillis());
			pst.setDate(3, date);
			pst.setInt(4, dia);
			pst.setInt(5, consult);
			int turno = 0;
			pst.setInt(6, turno);
			int horario = 0;
			pst.setInt(7, horario);
			String timbre = "";
			pst.setString(8, timbre);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}