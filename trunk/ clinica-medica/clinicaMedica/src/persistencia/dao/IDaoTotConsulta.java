package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;

public interface IDaoTotConsulta {

	public int getCantConsult(Transaccion trn, String idAfi) throws PersistenciaException;
	public int getCantConsultasPagas(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException;
	public Vector listarConsultasAfi(Transaccion trn, String id) throws PersistenciaException;
	public Vector listarConsFecha(Transaccion trn, Calendar fecha) throws PersistenciaException;
	public void elimConsulta(Transaccion trn, String idAfi) throws PersistenciaException;
}
