package persistencia.dao;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataUsuario;
import excepciones.PersistenciaException;

public interface IDaoUsuarios {

	public void altaUsuario(Transaccion trn, DataUsuario usu) throws PersistenciaException;
	public boolean validarUsuario(String clave,String pass, Transaccion trn) throws PersistenciaException;
	public boolean validarUsuarioWeb(String clave,String pass, Transaccion trn) throws PersistenciaException;
	public void modifContrasena(String clave, String pass, Transaccion trn) throws PersistenciaException;
	public String getTipo(Transaccion trn, String idUsuario) throws PersistenciaException;
	public void modificarTipo(Transaccion trn, String id, String tipo) throws PersistenciaException;
}
