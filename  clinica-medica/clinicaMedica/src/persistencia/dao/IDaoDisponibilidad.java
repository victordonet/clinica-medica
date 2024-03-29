package persistencia.dao;

import java.util.Vector;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataDisp;
import excepciones.PersistenciaException;

public interface IDaoDisponibilidad {

	public void altaDisponibilidad(Transaccion trn, DataDisp dataDsip) throws PersistenciaException;
	public void eliminarDisponibilidad(Transaccion trn, String idMed) throws PersistenciaException;
	public Vector<DataDisp> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException;
	public Vector<DataDisp> listarDispTotal(Transaccion trn) throws PersistenciaException;

}
