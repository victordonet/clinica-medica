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
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataMed;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoMedicoMySQL implements IDaoMedico {

	public void altaMedico(Transaccion trn, Medico med) throws PersistenciaException {
		System.out.println("Insertando medico: "+ med.getId()+"");
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
		System.out.println("Listando afiliados");
		Vector<DataMed> resultado = new Vector();
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

	public Vector listarMedEsp(int idEsp, Transaccion trn) throws PersistenciaException {
		return null;
	}

	public Medico getMedico(Transaccion trn, String id) throws PersistenciaException {
		return null;
	}

	public VosLogin getDataMedico(Transaccion trn, String id) throws PersistenciaException {
		return null;
	}

	public boolean validarMed(Transaccion trn, String id) throws PersistenciaException {
		return false;
	}

	public Vector listarSalarios(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		return null;
	}

	public Vector listarMedPremiado(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		return null;
	}

	public Vector calcSalarioTotal(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException {
		return null;
	}

	public Vector listarDispMed(DataMed dataMed, Transaccion trn) throws PersistenciaException {
		return null;
	}

	public void cargaConsultasProxMes(Transaccion trn, String id, Calendar fecha) throws PersistenciaException {

	}

	public Vector listarConsultasDisp(Transaccion trn) throws PersistenciaException {
		return null;
	}

	public void altaConsulta(Transaccion trn, Calendar fecha, String id, int dia, Afiliado afil, int conult) throws PersistenciaException {

	}
}