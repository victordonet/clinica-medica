package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import java.sql.Date;
import logica.Afiliado;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataExamen;
import vista.dataobjet.DataTipoExamen;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoAfiliadoMySQL implements IDaoAfiliado {

	public void altaAfiliado(Transaccion trn, DataAfiliado afil) throws PersistenciaException {
		System.out.println("==============Insertando afiliado: "+afil.getId()+"==============================");
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Afiliados values (?,?,?,?,?,?,?,?,?,?)");
			pst.setString (1, afil.getId());
			pst.setString(2, afil.getNombre());
			pst.setString(3, afil.getApellido());
			pst.setString(4, afil.getCi());
			pst.setString(5, afil.getMail());
			pst.setString(6, afil.getDireccion());
			pst.setString(7, afil.getTel());
			Date dt = new Date(afil.getFechaIngreso().getTimeInMillis());
			pst.setDate(8, dt);
			pst.setBoolean(9, afil.getFonasa());
			pst.setString(10, afil.getEstado());
			pst.executeUpdate();
			pst.close();
			System.out.println("==============Afiliado de Alta==============================");
	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public void modifAfil(Transaccion trn, String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, boolean fon) throws PersistenciaException {
		System.out.println("================================Modificando afiliado: "+ idAfil+"==============================================");
		try {
			PreparedStatement pst = trn.preparedStatement("update Afiliados set nombre=?, apellido=?, ci=?, mail=?, direccion=?, telefono=?, fonasa=? where id=?");
			pst.setString (1, nom);
			pst.setString(2, apel);
			pst.setString(3, ci);
			pst.setString(4, mail);
			pst.setString(5, dir);
			pst.setString(6, tel);
			pst.setBoolean(7, fon);
			pst.setString(8, idAfil);
			pst.executeUpdate();
			pst.close();
			System.out.println("==============Afiliado Modificado==============================");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void bajaAfil(Transaccion trn, String id) throws PersistenciaException {	
		System.out.println("=============================Baja del afiliado: "+id+"===================================");
		try {
			PreparedStatement pst = trn.preparedStatement("update Afiliados set estado=? where id=?");
			// I = inactivo
			pst.setString(1,"I");
			pst.setString(2, id);
			pst.executeUpdate();

			pst.close();
			System.out.println("==============Baja Afiliado==============================");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataAfiliado> listarAfiliados(Transaccion trn) throws PersistenciaException {
		System.out.println("====================Listando afiliados======================");
		Vector<DataAfiliado> resultado = new Vector<DataAfiliado>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select id, nombre, apellido, ci, mail, direccion, telefono, " +
															"fechaingreso, fonasa, estado from Afiliados");
		
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String id = rst.getString("Id");
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				String ci = rst.getString("ci");
				String mail = rst.getString("mail");
				String direccion = rst.getString("direccion");
				String telefono = rst.getString("telefono");
				Date fechaIngreso = rst.getDate("fechaingreso");
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaIngreso);
				Boolean fonasa = rst.getBoolean("fonasa");
				String estado = rst.getString("estado");
				DataAfiliado dataAfil = new DataAfiliado (id, ci, nombre, apellido,  mail, direccion, telefono, estado, cal, fonasa);
				resultado.add(dataAfil);
			}
			rst.close();
			pst.close();
			System.out.println("==============Fin Listado afiliado==============================");

			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public boolean validarAfil(Transaccion trn, String idAfil) throws PersistenciaException {
		Boolean validar;
		try {
			System.out.println("==============Validando Afiliado"+idAfil+"==============================");

			PreparedStatement pst = trn.preparedStatement("Select estado from Afiliados WHERE id=?");
			pst.setString(1, idAfil);
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
			System.out.println("==============Fin Validación Afiliado==============================");

		}catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
		return validar;
	}

	public Vector<DataExamen> listarExPend(Transaccion trn, String idAfil) throws PersistenciaException {
		System.out.println("Listando examenes pendientes de resolución");
		Vector<DataExamen> resultado = new Vector<DataExamen>();
		Date  fechaInicio, fechaResultado;
		Calendar fechaIni = Calendar.getInstance();
		Calendar fechaRes = Calendar.getInstance();
		int tipoEx;
		boolean enviaMail, cobroTimbre;
		
		try {
			PreparedStatement pst = trn.preparedStatement("SELECT E.IDTIPOEXAMEN, T.NOMBRE AS DESC_EXAMEN, E.ENVIAMAIL, " +
														"E.COBRATIMBRE, E.FECHARESULTADO " +
														"FROM EXAMENES E, TIPOEXAMENES T " +
														"WHERE E.IDTIPOEXAMEN=T.ID AND E.IDAFILIADO=? AND E.FECHARESULTADO=NULL");
		pst.setString(1, idAfil);
		ResultSet rst = pst.executeQuery();
		while(rst.next()){
			fechaInicio = rst.getDate("FECHAINICIO");
			fechaIni.setTime(fechaInicio);
			//Tipo de Examen
			tipoEx = rst.getInt("IDTIPOEXAMEN");
			String descTipoEx = rst.getString("DESC_EXAMEN");
			DataTipoExamen tex = new DataTipoExamen(tipoEx, descTipoEx);
			//----
			enviaMail = rst.getBoolean("ENVIAMAIL");
			cobroTimbre = rst.getBoolean("COBRATIMBRE");
			fechaResultado = rst.getDate("FECHARESULTADO");
			fechaRes.setTime(fechaResultado);
			DataExamen ex = new DataExamen(fechaIni, fechaRes, enviaMail, cobroTimbre, tex);
			resultado.add(ex);
		}
		rst.close();
		pst.close();
		return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public DataAfiliado getAfiliado(String idAfil, Transaccion trn)	throws PersistenciaException {
		String pass = null, tipo = null, nombre = null, apellido = null, ci = null, email = null, direccion = null, telefono = null, estado = null;
		Date fechaIngreso;
		Calendar fechaIng = Calendar.getInstance();
		Boolean fonasa = null;
		DataAfiliado af = null;
		try {
			System.out.println("==============Obteniendo afiliado: "+idAfil+"==============================");

			PreparedStatement pst = trn.preparedStatement("SELECT U.CONTRASENA, U.TIPO, A.NOMBRE, A.APELLIDO, A.CI, " +
														"A.MAIL, A.DIRECCION, A.TELEFONO, A.FECHAINGRESO, A.FONASA, A.ESTADO " +
														"FROM AFILIADOS A, USUARIOS U " +
														"WHERE A.ID=U.ID AND A.ID=?");
			pst.setString(1, idAfil);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				pass = rst.getString("CONTRASENA");
				tipo = rst.getString("TIPO");
				nombre = rst.getString("NOMBRE");
				apellido = rst.getString("APELLIDO");
				ci = rst.getString("CI");
				email = rst.getString("MAIL");
				direccion = rst.getString("DIRECCION");
				telefono = rst.getString("TELEFONO");
				fechaIngreso = rst.getDate("FECHAINGRESO");
				fechaIng.setTime(fechaIngreso);
				fonasa = rst.getBoolean("FONASA");
				estado = rst.getString("ESTADO");
			}
			rst.close();
			pst.close();
			//IDaoExamen daoEx = new DaoExamenMySQL();
			af = new DataAfiliado(idAfil, ci, nombre, apellido, email, direccion, telefono, estado, fechaIng, fonasa);
			System.out.println("==============Fin Obtener Afiliado==============================");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return af;
	}

	public VosLogin getDataAfiliado(Transaccion trn, String id) throws PersistenciaException {
		String nombre= null,apellido = null,pass = null,tipo= null;
		try{
			System.out.println("==============Obteniendo data Afiliado==============================");

			PreparedStatement pst = trn.preparedStatement("Select A.nombre, A.apellido, U.contrasena, U.tipo " +
														"from Afiliados A, Usuarios U WHERE A.id=U.id and A.id=?");
			pst.setString(1, id);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				nombre = rst.getString("nombre");
				apellido = rst.getString("apellido");
				pass = rst.getString("contrasena");
				tipo = rst.getString("tipo");
			}
			rst.close();
			pst.close();
			VosLogin vosLogin = new VosLogin(nombre, apellido, tipo, pass);
			System.out.println("==============Fin Obtener data Afiliado==============================");

			return vosLogin;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");			
		}
	}
}
