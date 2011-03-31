package persistencia.fabrica;

import persistencia.dao.IDaoAdmGen;
import persistencia.dao.IDaoAfiliado;
import persistencia.dao.IDaoConsultas;
import persistencia.dao.IDaoDisponibilidad;
import persistencia.dao.IDaoEspecialidades;
import persistencia.dao.IDaoExamen;
import persistencia.dao.IDaoMedico;
import persistencia.dao.IDaoTipoExamen;
import persistencia.dao.IDaoTotConsulta;
import persistencia.dao.IDaoUsuarios;

public interface IabsFactory {
	
	public IDaoAdmGen crearDaoAdminGen();
	public IDaoAfiliado crearDaoAfil();
	public IDaoConsultas crearDaoConsultas();
	public IDaoDisponibilidad crearDaoDisp();
	public IDaoEspecialidades crearDaoEspecialidades();
	public IDaoExamen crearDaoEx();
	public IDaoMedico crearDaoMed();
	public IDaoTipoExamen crearDaoTEx();
	public IDaoTotConsulta crearDaoTConsultas();
	public IDaoUsuarios crearDaoUsuarios();

}
