package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;

import logica.Afiliado;
import logica.Consulta;
import logica.Medico;
import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public class DaoConsultasMySQL implements IDaoConsultas {

	@Override
	public int getCantidadConsultas(Transaccion trn, Calendar fDesde,
			Calendar fHasta) throws PersistenciaException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void altaconsultaProxMes(Transaccion trn, Consulta cons)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector listarConsultasDisp(Transaccion trn)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altaConsulta(Transaccion trn, Calendar fecha, String horario,
			int dia, Afiliado afil, int turno, Medico med)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

}
