package persistencia.dao;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;

public interface IDaoConsultorios {

	public int totalConsultorios(Transaccion trn) throws PersistenciaException;
	public boolean validaConsultorio(Transaccion trn, String idConsul) throws PersistenciaException;
	
}
