package persistencia.fabrica;

import persistencia.dao.DaoEspecialidadesMySQL;
import persistencia.dao.DaoUsuariosMySQL;
import persistencia.dao.IDaoEspecialidades;
import persistencia.dao.IDaoUsuarios;

public class FabricaMySQL implements IabsFactory {

	public IDaoEspecialidades crearDaoEspecialidades() {
	
		IDaoEspecialidades ide = new DaoEspecialidadesMySQL();
		return ide;
	}

	public IDaoUsuarios crearDaoUsuarios() {
		
		IDaoUsuarios iusu = new DaoUsuariosMySQL();
		return iusu;
	}
	
}
