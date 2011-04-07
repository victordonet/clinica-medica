package persistencia.dao;

import logica.TipoExamen;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataTipoExamen;

public interface IDaoTipoExamen {

	public void agregar(Transaccion trn,DataTipoExamen tex) throws PersistenciaException;
	public void modificar(Transaccion trn,DataTipoExamen tex) throws PersistenciaException;
	public Vector listarTipoEx(Transaccion trn) throws PersistenciaException;
	
}
