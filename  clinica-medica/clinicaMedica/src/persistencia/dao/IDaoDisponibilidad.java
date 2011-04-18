package persistencia.dao;

import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataDisp;

public interface IDaoDisponibilidad {

	public void altaDisponibilidad(Transaccion trn, DataDisp dataDsip) throws PersistenciaException;
	public void eliminarDisponibilidad(DataDisp vo, Transaccion trn) throws PersistenciaException;
	public Vector<DataDisp> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException;

}
