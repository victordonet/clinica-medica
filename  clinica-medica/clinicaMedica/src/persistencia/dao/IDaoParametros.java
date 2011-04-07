package persistencia.dao;

import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;

public interface IDaoParametros {

	public String getValor(Transaccion trn, String param) throws PersistenciaException;
	
}
