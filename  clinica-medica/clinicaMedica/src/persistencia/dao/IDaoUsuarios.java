package persistencia.dao;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataUsuario;
import logica.Usuario;

public interface IDaoUsuarios {

	public void altaUsuario(Transaccion trn, DataUsuario usu) throws PersistenciaException;
	public boolean validarUsuario(String clave,String pass, Transaccion trn) throws PersistenciaException;
	public void modifContrasena(String clave, String pass, Transaccion trn) throws PersistenciaException;
	public void modifEstado(Transaccion trn, String id) throws PersistenciaException;
}
