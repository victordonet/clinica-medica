package persistencia.dao;

import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public interface IDaoParametros {

	public String getValor(Transaccion trn, String param) throws PersistenciaException;
	
}
