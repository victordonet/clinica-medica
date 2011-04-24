package persistencia.dao;

import java.rmi.RemoteException;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataCargo;
import excepciones.PersistenciaException;

public interface IDaoCargos {
	
	public Vector<DataCargo> listarCargos(Transaccion trn) throws PersistenciaException, RemoteException;

}
