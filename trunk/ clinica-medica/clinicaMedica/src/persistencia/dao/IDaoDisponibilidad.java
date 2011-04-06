package persistencia.dao;

import java.util.Vector;

import logica.Disponibilidad;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.VoDispo;

public interface IDaoDisponibilidad {

	public void updateDisponibilidad(VoDispo vo, Transaccion trn) throws PersistenciaException;
	public Vector<Disponibilidad> listarDispMedico(String idMed, Transaccion trn) throws PersistenciaException;

}
