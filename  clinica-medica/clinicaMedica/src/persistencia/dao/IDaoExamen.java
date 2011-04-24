package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;

import logica.Examen;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataExamen;
import excepciones.PersistenciaException;

public interface IDaoExamen {

	public void regEx(Transaccion trn, DataExamen ex, String idAfil) throws PersistenciaException;
	public int getCantExPagos(Transaccion trn, Calendar fini,Calendar ffin) throws PersistenciaException;
	public int getCantExam(Transaccion trn, String idAfil) throws PersistenciaException;
	public Vector<Examen> listarExamAfil(String idAfil, Transaccion trn) throws PersistenciaException;
}
