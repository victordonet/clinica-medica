package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public class DaoTotConsultaMySQL implements IDaoTotConsulta {

	@Override
	public int getCantConsult(Transaccion trn, String idAfi)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCantConsultasPagas(Transaccion trn, Calendar fDesde,
			Calendar fHasta) throws PersistenciaException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector listarConsultasAfi(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector listarConsFecha(Transaccion trn, Calendar fecha)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elimConsulta(Transaccion trn, String idAfi)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

}
