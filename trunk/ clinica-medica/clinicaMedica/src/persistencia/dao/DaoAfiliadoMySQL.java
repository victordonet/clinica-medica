package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import java.sql.Date;

import logica.Afiliado;
import persistencia.EntradaPersistencia;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataEsp;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoAfiliadoMySQL implements IDaoAfiliado {

	@Override
	public void altaAfiliado(Transaccion trn, Afiliado afil) throws PersistenciaException {

		System.out.println("Insertando afiliado: "+ afil.getId());
		PreparedStatement pst;

		try {
			pst = trn.preparedStatement("insert into Afiliados values (?,?,?,?,?,?,?,?,?,?)");
			pst.setString (1, afil.getId());
			pst.setString(2, afil.getNombre());
			pst.setString(3, afil.getApellido());
			pst.setString(4, afil.getCi());
			pst.setString(5, afil.getMail());
			pst.setString(6, afil.getDir());
			pst.setString(7, afil.getTel());
			Date dt = new Date(afil.getFecha().getTimeInMillis());
			pst.setDate(8, dt);
			pst.setBoolean(9, afil.isFonasa());
			pst.setString(10, afil.getEstado());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifAfil(Transaccion trn, String idAfil, String nom,
			String apel, String ci, String mail, String dir, String tel,
			Calendar ing, boolean fon) throws PersistenciaException {
		
		System.out.println("Modificando afiliado: "+ idAfil);
		PreparedStatement pst;
		pst = trn.preparedStatement("update Afiliados set id=?, nombre=?, apellido=?, ci=?, mail=?, direccion=?, telefono=?, fechaingreso=?, fonasa=?, estado=?");
		try {
			pst.setString (1, idAfil);
			pst.setString(2, nom);
			pst.setString(3, apel);
			pst.setString(4, ci);
			pst.setString(5, mail);
			pst.setString(6, dir);
			pst.setString(7, tel);
			Date dt = new Date (ing.getTimeInMillis());
			pst.setDate (8, dt);
			pst.setBoolean(9, fon);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		
	}

	@Override
	public void bajaAfil(Transaccion trn, String id) throws PersistenciaException {
		
		System.out.println("Doy de baja el afiliado: "+ id);
		PreparedStatement pst;
		pst = trn.preparedStatement("update Afiliados set estado=? WHERE id="+id);
		try {
			// I = inactivo
			pst.setString(1,"I");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}

	}

	@Override
	public Vector listarAfiliados(Transaccion trn) throws PersistenciaException {
		System.out.println("Listando afiliados");
		Vector <DataAfiliado> resultado = new Vector();
		try {
			PreparedStatement pst = trn.preparedStatement("Select id, nombre, apellido, ci, mail, direccion, telefono, fechaingreso, fonasa, estado from Afiliados");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int id = rst.getInt("Id");
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				int ci = rst.getInt("ci");
				String mail = rst.getString("mail");
				String direccion = rst.getString("direccion");
				String telefono = rst.getString("telefono");
				Date fechaIngreso = rst.getDate("fechaingreso");
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaIngreso);
				Boolean fonasa = rst.getBoolean("fonsasa");
				String estado = rst.getString("estado");
				DataAfiliado dataAfil = new DataAfiliado (id, ci, nombre, apellido,  mail, direccion, telefono, estado, cal, fonasa);
				resultado.add(dataAfil);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	@Override
	public boolean validarAfil(Transaccion trn, String idAfil) throws PersistenciaException {
		
		PreparedStatement pst = trn.preparedStatement("Select estado from Afiliados WHERE id="+idAfil);
		ResultSet rst = pst.executeQuery();
		Boolean validar;
		try {
			if(rst.next()){
				if(rst.getString(1)== "I")
					validar = false;
				else
					validar = true;
			}
			else{
				validar = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		return validar;
	}

	@Override
	public Vector listarExPend(Transaccion trn, int idAfil) throws PersistenciaException {
		
		
		return null;
	}

	@Override
	public Afiliado getAfiliado(String idAfil, Transaccion trn)	throws PersistenciaException {
		
		// VER CON PELADO!!!
		
		PreparedStatement pst = trn.preparedStatement("Select id, nombre, apellido, ci, mail, direccion, telefono, fechaingreso, fonasa, estado from Afiliados WHERE id="+idAfil);
		ResultSet rst = pst.executeQuery();
		while(rst.next()){
			int id = rst.getInt("Id");
			String nombre = rst.getString("nombre");
			String apellido = rst.getString("apellido");
			int ci = rst.getInt("ci");
			String mail = rst.getString("mail");
			String direccion = rst.getString("direccion");
			String telefono = rst.getString("telefono");
			Date fechaIngreso = rst.getDate("fechaingreso");
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaIngreso);
			Boolean fonasa = rst.getBoolean("fonsasa");
			String estado = rst.getString("estado");
		}
		pst.close();
		
		
			
		return null;
	}

	@Override
	public VosLogin getDataAfiliado(Transaccion trn, String id) throws PersistenciaException {
		
		PreparedStatement pst = trn.preparedStatement("Select nombre, apellido from Afiliados WHERE id="+id);
		ResultSet rs = pst.executeQuery();
		VosLogin vosLogin = new VosLogin();
		
		try{
			vosLogin.setNombre(rs.getString(1));
			vosLogin.setApellido(rs.getString(2));
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");			
		}
		
		PreparedStatement pst1 = trn.preparedStatement("Select contrasena, tipo from Usuarios WHERE id="+id);
		ResultSet rs1 = pst1.executeQuery();
		try{
			vosLogin.setPass(rs.getString(1));
			vosLogin.setTipo(rs.getString(2));
			return vosLogin;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		
	}
	}
}
