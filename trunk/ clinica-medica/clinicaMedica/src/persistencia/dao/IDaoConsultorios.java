package persistencia.dao;

import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataConsultorio;

public interface IDaoConsultorios {

	public int totalConsultorios(Transaccion trn) throws PersistenciaException;
	public boolean validaConsultorio(Transaccion trn, int idConsul) throws PersistenciaException;
	public void altaConsultorio(Transaccion trn, DataConsultorio consultorio) throws PersistenciaException;
	public void bajaConsultorio(Transaccion trn, int idConsultorio) throws PersistenciaException;
	public Vector<DataConsultorio> listarConsultorios(Transaccion trn) throws PersistenciaException;
	
}
