package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import logica.Afiliado;
import logica.Consulta;
import logica.Medico;

public interface IDaoConsultas {

	public int getCantidadConsultas(Transaccion trn, Calendar fDesde, Calendar fHasta, String idMed) throws PersistenciaException;
	public void altaConsultaProxMes(Transaccion trn, Consulta cons, String idMed) throws PersistenciaException;
	public Vector listarConsultasDisp(Transaccion trn, String idMed) throws PersistenciaException;
	public void altaConsulta(Transaccion trn, Calendar fecha, int horario, int dia, int idConsultorio, boolean timbre, Afiliado afil, int turno, Medico med) throws PersistenciaException;
	public void elimConsultasAfil(Transaccion trn, String idAfil) throws PersistenciaException;

}
