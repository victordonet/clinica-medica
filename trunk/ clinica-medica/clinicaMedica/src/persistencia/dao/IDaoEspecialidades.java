package persistencia.dao;

import java.util.Vector;

import excepciones.PersistenciaException;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataEsp;
import logica.Especialidad;

public interface IDaoEspecialidades {

	public void altaEspecialidad(Transaccion trn,Especialidad esp) throws PersistenciaException;
	public Vector<DataEsp> listarEspecialidades(Transaccion trn)throws PersistenciaException;
	public DataEsp obtenerEspecialidad(Transaccion trn, int idEsp)throws PersistenciaException;

}
