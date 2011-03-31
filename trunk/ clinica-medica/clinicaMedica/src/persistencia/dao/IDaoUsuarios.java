package persistencia.dao;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import logica.Usuario;

public interface IDaoUsuarios {

	public void altaUsuario(Transaccion trn, Usuario usu) throws PersistenciaException;
	public boolean validarUsuario(String clave,String pass, Transaccion trn) throws PersistenciaException;
	public void modifContrasena(String clave, String pass, Transaccion trn) throws PersistenciaException;
	
}
