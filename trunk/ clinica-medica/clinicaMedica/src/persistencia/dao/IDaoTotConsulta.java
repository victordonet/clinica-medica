package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataConsAfi;
import vista.dataobjet.DataConsFecha;
import excepciones.PersistenciaException;

public interface IDaoTotConsulta {

	public int getCantConsult(Transaccion trn, String idAfi) throws PersistenciaException;
	public int getCantConsultasPagas(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException;
	public Vector<DataConsAfi> listarConsultasAfi(Transaccion trn, String id) throws PersistenciaException;
	public Vector<DataConsFecha> listarConsFecha(Transaccion trn, Calendar fecha) throws PersistenciaException;
	public void elimConsultaAfi(Transaccion trn, String idAfi) throws PersistenciaException;
	public void elimConsultaMed (Transaccion trn, String idMed) throws PersistenciaException;
}
