package persistencia.dao;

import java.util.Calendar;
import persistencia.transacciones.Transaccion;
import logica.Examen;
import excepciones.PersistenciaException;

public interface IDaoExamen {

	public void regEx(Transaccion trn, Examen ex) throws PersistenciaException;
	public int getCantExPagos(Transaccion trn, Calendar fini,Calendar ffin) throws PersistenciaException;
	public int getCantExam(Transaccion trn, Calendar fecha) throws PersistenciaException;
}
