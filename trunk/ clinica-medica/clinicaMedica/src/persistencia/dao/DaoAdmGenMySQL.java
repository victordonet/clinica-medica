package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;

import logica.AdminGen;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoAdmGenMySQL implements IDaoAdmGen {

	@Override
	public void altaAdmin(Transaccion trn, AdminGen adm)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarAdmin(Transaccion trn, String id, String nom,
			String cargo) throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void bajaAdmin(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector listarAdmin(Transaccion trn) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VosLogin getDataAdmin(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarAdmin(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifEx(Transaccion trn, String idAfil, Calendar fIni, int idTex,
			Calendar fRes) throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector listarExPend(Transaccion trn, int idAfil)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
