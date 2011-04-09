package persistencia.dao;

import java.util.Vector;

import logica.Disponibilidad;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.VoDispo;

public interface IDaoDisponibilidad {

	public void updateDisponibilidad(VoDispo vo, Transaccion trn) throws PersistenciaException;
	public Vector<VoDispo> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException;

}
