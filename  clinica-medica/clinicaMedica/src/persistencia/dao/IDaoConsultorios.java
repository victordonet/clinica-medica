package persistencia.dao;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataConsultorio;

public interface IDaoConsultorios {

	public int totalConsultorios(Transaccion trn) throws PersistenciaException;
	public boolean validaConsultorio(Transaccion trn, int idConsul) throws PersistenciaException;
	public void altaConsultorio(Transaccion trn, DataConsultorio consultorio) throws PersistenciaException;
	
}
