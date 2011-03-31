package persistencia.dao;

import java.util.Vector;

import logica.TipoExamen;
import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public class DaoTipoExamenMySQL implements IDaoTipoExamen {

	@Override
	public void agregar(Transaccion trn, TipoExamen tex)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Transaccion trn, TipoExamen tex)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector listarTipoEx(Transaccion trn) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
