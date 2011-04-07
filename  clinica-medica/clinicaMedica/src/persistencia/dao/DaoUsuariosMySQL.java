package persistencia.dao;

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
		PreparedStatement pst;
		try {
			pst = trn.preparedStatement("insert into Usuarios values (?,?,?)");
			pst.setString(1, usu.getId());
			pst.setString(2, "MD5("+usu.getContrasena()+")");
			pst.setString(3, usu.getTipo());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}

	}

	public boolean validarUsuario(String id, String pass, Transaccion trn) throws PersistenciaException {
		System.out.println("Validando usuario: "+id);
		boolean respuesta;
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
			System.out.println("Validado: "+respuesta);
			return respuesta;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

	public void modifContrasena(String clave, String pass, Transaccion trn) throws PersistenciaException {

	}

}
