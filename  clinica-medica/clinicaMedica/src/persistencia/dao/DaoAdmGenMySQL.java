package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import logica.AdminGen;
import logica.Examen;
import logica.TipoExamen;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoAdmGenMySQL implements IDaoAdmGen {

	public void altaAdmin(Transaccion trn, DataAdmin adm) throws PersistenciaException {
		System.out.println("Insertando administrativo: "+ adm.getId());
		try {
			PreparedStatement pst = trn.preparedStatement("insert into Afiliados values (?,?,?,?)");
			pst.setString (1, adm.getId());
			pst.setString(2, adm.getNombre());
			pst.setInt(3, adm.getCargo());
			pst.setString(4, adm.getEstado());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public void modificarAdmin(Transaccion trn, String id, String nom, String cargo) throws PersistenciaException {
		System.out.println("Modificando administrativo: "+id);
		try {
			PreparedStatement pst = trn.preparedStatement("update Administrativos set nombre=?, idcargo=? where id=?");
			pst.setString (1, nom);
			pst.setString(2, cargo);
			pst.setString (3, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void bajaAdmin(Transaccion trn, String id) throws PersistenciaException {
		System.out.println("Baja del administrativo: "+id);
		try {
			PreparedStatement pst = trn.preparedStatement("update Administrativos set estado=? WHERE id=?");
			// I = inactivo
			pst.setString(1,"I");
			pst.setString (2, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<DataAdmin> listarAdmin(Transaccion trn) throws PersistenciaException {
		System.out.println("Listando Administrativos");
		Vector<DataAdmin> resultado = new Vector<DataAdmin>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select * from administrativos");
			System.out.println("paso1");
			ResultSet rst = pst.executeQuery();
			System.out.println("paso2");
			while(rst.next()){
				System.out.println("paso3");
				String id = rst.getString("Id");
				String nombre = rst.getString("nombre");
				int cargo = rst.getInt("idcargo");
				String estado = rst.getString("estado");
				DataAdmin dataAdmin = new DataAdmin(id, nombre, cargo, estado);
				resultado.add(dataAdmin);
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public VosLogin getDataAdmin(Transaccion trn, String id) throws PersistenciaException {
		VosLogin vosLogin = null;
		try{
			PreparedStatement pst = trn.preparedStatement("Select A.nombre, U.contrasena, U.tipo from Administrativos A, Usuarios U WHERE A.id=U.id and id=?");
			pst.setString (1, id);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				String nombre = rst.getString("nombre");
				String pass = rst.getString("contrasena");
				String tipo = rst.getString("tipo");
				vosLogin = new VosLogin(nombre, null, tipo, pass);
			}
			pst.close();
			return vosLogin;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");			
		}
	}

	public boolean validarAdmin(Transaccion trn, String id) throws PersistenciaException {
		Boolean validar;
		try {
			PreparedStatement pst = trn.preparedStatement("Select estado from Administrativos WHERE id=?");
			pst.setString (1, id);
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

	public void modifEx(Transaccion trn, String idAfil, Calendar fIni, int idTex, Calendar fRes) throws PersistenciaException {
		System.out.println("Modificando examen");
		try {
			PreparedStatement pst = trn.preparedStatement("update Examenes set FECHARESULTADO=? where IDAFILIADO=? AND FECHAINICIO=? AND IDTIPOEXAMEN=?");
			Date fechaRes = new java.sql.Date(fRes.getTimeInMillis());
			pst.setDate(1,fechaRes);
			pst.setString (2, idAfil);
			Date fechaInicio = new java.sql.Date(fIni.getTimeInMillis());
			pst.setDate(3,fechaInicio);
			pst.setInt(4, idTex);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public Vector<Examen> listarExPend(Transaccion trn, String idAdmin) throws PersistenciaException {
		System.out.println("Listando examenes pendientes de resolución");
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
															"WHERE E.IDTIPOEXAMEN=T.ID AND E.IDAFILIADO=? AND E.FECHARESULTADO=NULL");
			pst.setString(1, idAdmin);
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
		return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}
}
