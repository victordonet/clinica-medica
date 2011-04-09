package persistencia.dao;

import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.VoDispo;

public interface IDaoDisponibilidad {

	public void altaDisponibilidad(Transaccion trn, VoDispo dataDsip) throws PersistenciaException;
	public void updateDisponibilidad(VoDispo vo, Transaccion trn) throws PersistenciaException;
	public Vector<VoDispo> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException;

}
