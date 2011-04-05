package persistencia.dao;

import java.util.Vector;

import excepciones.PersistenciaException;

import persistencia.transacciones.Transaccion;
import logica.Especialidad;

public interface IDaoEspecialidades {

	public void altaEspecialidad(Transaccion trn,Especialidad esp) throws PersistenciaException;
	public Vector listarEspecialidades(Transaccion trn)throws PersistenciaException;
	public Especialidad obtenerEspecialidad(Transaccion trn, int idEsp)throws PersistenciaException;

}
