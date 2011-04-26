package persistencia.dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataUsuario;
import excepciones.PersistenciaException;

public class DaoUsuariosMySQL implements IDaoUsuarios {


	public void altaUsuario(Transaccion trn, DataUsuario usu) throws PersistenciaException {

		try {
			PreparedStatement pst = trn.preparedStatement("insert into Usuarios values (?,?,?)");
			pst.setString(1, usu.getId());
			String passEncript =this.md5(usu.getContrasena());
			System.err.println("Pass= "+passEncript);
			pst.setString(2, passEncript);
			pst.setString(3, usu.getTipo());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
	//Catcheamos esta exception que se puede lanzar al aplicar el metodo md5 en la password
		} catch (Exception e) {
			throw new PersistenciaException("Error al encriptar clave ");
		}

	}

	public boolean validarUsuario(String id, String pass, Transaccion trn) throws PersistenciaException {

		boolean respuesta = false;
		int encontre = 0;
		try {
			PreparedStatement pst = trn.preparedStatement("Select count(*) as Encontre from Usuarios where id=? and contrasena=?");
			pst.setString(1, id);
			String passEncript =this.md5(pass);
			pst.setString(2, passEncript);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				encontre = rst.getInt("Encontre");
			}
			if (encontre==0)
				respuesta=false;
			else
				respuesta=true;

			rst.close();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
//Catcheamos esta exception que se puede lanzar al aplicar el metodo md5 en la password			
		} catch (Exception e) {
			throw new PersistenciaException("Error al encriptar clave ");
		}
		return respuesta;
	}
	
	public boolean validarUsuarioWeb(String id, String pass, Transaccion trn) throws PersistenciaException {
		System.out.println("Validando usuario: "+id);
		boolean respuesta = false;
		int encontre = 0;
		try {
			PreparedStatement pst = trn.preparedStatement("Select count(*) as Encontre from Usuarios where id=? and contrasena=?");
			pst.setString(1, id);
			pst.setString(2, pass);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				encontre = rst.getInt("Encontre");
			}
			if (encontre==0)
				respuesta=false;
			else
				respuesta=true;

			rst.close();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
//Catcheamos esta exception que se puede lanzar al aplicar el metodo md5 en la password			
		} catch (Exception e) {
			throw new PersistenciaException("Error al encriptar clave ");
		}
		return respuesta;
	}
	
	public void modifContrasena(String clave, String pass, Transaccion trn) throws PersistenciaException {

		try {
			PreparedStatement pst = trn.preparedStatement("update Usuarios set contrasena=? where id=?");
			String passEncript =this.md5(pass);
			pst.setString (1, passEncript);
			pst.setString(2, clave);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {

			throw new PersistenciaException("Error de conexion con la base de datos");
//Catcheamos esta exception que se puede lanzar al aplicar el metodo md5 en la password
		} catch (Exception e) {
			throw new PersistenciaException("Error al encriptar clave ");
		}
	}

	public String md5(String clear) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = md.digest(clear.getBytes());

		int size = b.length;
		StringBuffer h = new StringBuffer(size);
		for (int i = 0; i < size; i++) {
			int u = b[i] & 255;
			if (u < 16) {
				h.append("0" + Integer.toHexString(u));
			} else {
				h.append(Integer.toHexString(u));
			}
		}
		return h.toString();
	}

	public String getTipo(Transaccion trn, String idUsuario) throws PersistenciaException {

		String tipo = null ;
		try {
			PreparedStatement pst = trn.preparedStatement("Select tipo from Usuarios where id=?");
			pst.setString(1, idUsuario);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				tipo = rst.getString("tipo");
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
//Catcheamos esta exception que se puede lanzar al aplicar el metodo md5 en la password
		} catch (Exception e) {
			throw new PersistenciaException("Error al encriptar clave ");
		}
		return tipo;	
	}
}
