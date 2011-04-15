package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.VoTurnosDisp;

public interface IDaoConsultas {

	public int getCantidadConsultas(Transaccion trn, Calendar fDesde, Calendar fHasta, String idMed) throws PersistenciaException;
	public void altaConsultaProxMes(Transaccion trn, DataConsulta cons, String idMed) throws PersistenciaException;
	public Vector<VoTurnosDisp> listarConsultasDisp(Transaccion trn, String idMed) throws PersistenciaException;
	public void altaConsulta(Transaccion trn, Calendar fecha, String idMed, int dia, String idAfil, int consult, int turno, int horario, boolean timbre) throws PersistenciaException;
	public void elimConsultasAfil(Transaccion trn, String idAfil) throws PersistenciaException;
	public Vector<DataConsulta> listarConsultas(Transaccion trn) throws PersistenciaException;
	
}
