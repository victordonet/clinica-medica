package persistencia.dao;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.VoDispo;

public interface IDaoDisponibilidad {

	public void updateDisponibilidad(VoDispo vo, Transaccion trn) throws PersistenciaException;
	public void listarDispMedico(String idMed) throws PersistenciaException;
	
}
