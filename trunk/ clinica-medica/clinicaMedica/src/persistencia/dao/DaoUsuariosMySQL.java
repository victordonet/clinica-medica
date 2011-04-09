package persistencia.dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Usuario;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataUsuario;
import excepciones.PersistenciaException;

public class DaoUsuariosMySQL implements IDaoUsuarios {


	public void altaUsuario(Transaccion trn, DataUsuario usu) throws PersistenciaException {
		System.out.println("Insertando usuario: "+ usu.getId());
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
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean validarUsuario(String id, String pass, Transaccion trn) throws PersistenciaException {
		System.out.println("Validando usuario: "+id);
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
			System.out.println("Validado: "+respuesta);
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	public void modifContrasena(String clave, String pass, Transaccion trn) throws PersistenciaException {
		System.out.println("Modificando contraseña del usu: "+clave);
		try {
			PreparedStatement pst = trn.preparedStatement("update Usuarios set contrasena=? where id=?");
			String passEncript =this.md5(pass);
			pst.setString (1, passEncript);
			pst.setString(2, clave);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String md5(String clear) throws Exception {
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
}
