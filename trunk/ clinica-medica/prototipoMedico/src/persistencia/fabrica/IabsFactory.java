package persistencia.fabrica;

import persistencia.dao.IDaoEspecialidades;
import persistencia.dao.IDaoUsuarios;

public interface IabsFactory {
	
	public IDaoEspecialidades crearDaoEspecialidades();
	public IDaoUsuarios crearDaoUsuarios();

}
