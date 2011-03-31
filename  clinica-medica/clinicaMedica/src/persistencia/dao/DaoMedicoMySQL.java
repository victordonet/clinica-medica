package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;

import logica.Afiliado;
import logica.Especialidad;
import logica.Medico;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataMed;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public class DaoMedicoMySQL implements IDaoMedico {

	@Override
	public void altaMedico(Transaccion trn, Medico med)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifMedico(Transaccion trn, String id, String nom,
			String apell, String ci, String tel, Especialidad esp)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void bajarMedico(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector listarMedico(Transaccion trn) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector listarMedEsp(int idEsp, Transaccion trn)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico getMedico(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VosLogin getDataMedico(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarMed(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector listarSalarios(Transaccion trn, Calendar fDesde,
			Calendar fHasta) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector listarMedPremiado(Transaccion trn, Calendar fDesde,
			Calendar fHasta) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector calcSalarioTotal(Transaccion trn, Calendar fDesde,
			Calendar fHasta) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector listarDispMed(DataMed dataMed, Transaccion trn)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargaConsultasProxMes(Transaccion trn, String id, Calendar fecha)
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
	public void altaConsulta(Transaccion trn, Calendar fecha, String id,
			int dia, Afiliado afil, int conult) throws PersistenciaException {
		// TODO Auto-generated method stub

	}

}
