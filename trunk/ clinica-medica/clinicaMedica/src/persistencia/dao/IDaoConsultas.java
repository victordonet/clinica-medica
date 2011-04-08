package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.DataMed;
import logica.Afiliado;
import logica.Consulta;
import logica.Medico;

public interface IDaoConsultas {

	public int getCantidadConsultas(Transaccion trn, Calendar fDesde, Calendar fHasta, String idMed) throws PersistenciaException;
	public void altaConsultaProxMes(Transaccion trn, DataConsulta cons, String idMed) throws PersistenciaException;
	public Vector listarConsultasDisp(Transaccion trn, String idMed) throws PersistenciaException;
	public void altaConsulta(Transaccion trn, Calendar fecha, String idMed, int dia, DataAfiliado afil, int consult, int turno, int horario, boolean timbre) throws PersistenciaException;
	public void elimConsultasAfil(Transaccion trn, String idAfil) throws PersistenciaException;

}
