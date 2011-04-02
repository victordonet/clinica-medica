package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import logica.Afiliado;
import logica.Consulta;
import logica.Medico;

public interface IDaoConsultas {

	public int getCantidadConsultas(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException;
	public void altaconsultaProxMes(Transaccion trn, Consulta cons) throws PersistenciaException;
	public Vector listarConsultasDisp(Transaccion trn) throws PersistenciaException;
	public void altaConsulta(Transaccion trn, Calendar fecha, String horario, int dia, Afiliado afil, int turno, Medico med) throws PersistenciaException;
	public void elimConsultasAfil(Transaccion trn, String idAfil) throws PersistenciaException;

}
