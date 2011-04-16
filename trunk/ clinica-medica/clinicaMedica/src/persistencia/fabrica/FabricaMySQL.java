package persistencia.fabrica;

import persistencia.dao.DaoCargosMySQL;
import persistencia.dao.DaoConsultoriosMySQL;
import persistencia.dao.DaoParametrosMySQL;
import persistencia.dao.IDaoAdmGen;
import persistencia.dao.IDaoAfiliado;
import persistencia.dao.IDaoCargos;
import persistencia.dao.IDaoConsultas;
import persistencia.dao.IDaoConsultorios;
import persistencia.dao.IDaoDisponibilidad;
import persistencia.dao.IDaoEspecialidades;
import persistencia.dao.IDaoExamen;
import persistencia.dao.IDaoMedico;
import persistencia.dao.IDaoParametros;
import persistencia.dao.IDaoTipoExamen;
import persistencia.dao.IDaoTotConsulta;
import persistencia.dao.IDaoUsuarios;
import persistencia.dao.DaoAdmGenMySQL;
import persistencia.dao.DaoAfiliadoMySQL;
import persistencia.dao.DaoConsultasMySQL;
import persistencia.dao.DaoDisponibilidadMySQL;
import persistencia.dao.DaoEspecialidadesMySQL;
import persistencia.dao.DaoExamenMySQL;
import persistencia.dao.DaoMedicoMySQL;
import persistencia.dao.DaoTipoExamenMySQL;
import persistencia.dao.DaoTotConsultaMySQL;
import persistencia.dao.DaoUsuariosMySQL;

public class FabricaMySQL implements IabsFactory {
	
	public IDaoAdmGen crearDaoAdminGen() {
		IDaoAdmGen idAdmin = new DaoAdmGenMySQL();
		return idAdmin;
	}
	
	public IDaoAfiliado crearDaoAfil() {
		IDaoAfiliado idAdfil = new DaoAfiliadoMySQL();
		return idAdfil;
	}
	
	public IDaoConsultas crearDaoConsultas() {
		IDaoConsultas idCon = new DaoConsultasMySQL();
		return idCon;
	}
	
	public IDaoDisponibilidad crearDaoDisp() {
		IDaoDisponibilidad idD = new DaoDisponibilidadMySQL();
		return idD;
	}
	
	public IDaoEspecialidades crearDaoEspecialidades() {
		IDaoEspecialidades idEsp = new DaoEspecialidadesMySQL();
		return idEsp;
	}
	
	public IDaoExamen crearDaoEx() {
		IDaoExamen idEx = new DaoExamenMySQL();
		return idEx;
	}
	
	public IDaoMedico crearDaoMed() {
		IDaoMedico idM = new DaoMedicoMySQL();
		return idM;
	}
	
	public IDaoTipoExamen crearDaoTEx() {
		IDaoTipoExamen idTex = new DaoTipoExamenMySQL();
		return idTex;
	}
	
	public IDaoTotConsulta crearDaoTConsultas() {
		IDaoTotConsulta idTcon = new DaoTotConsultaMySQL();
		return idTcon;
	}
	
	public IDaoUsuarios crearDaoUsuarios() {
		IDaoUsuarios iusu = new DaoUsuariosMySQL();
		return iusu;
	}

	public IDaoParametros crearDaoParametros() {
		IDaoParametros ipar = new DaoParametrosMySQL();
		return ipar;
	}

	public IDaoConsultorios crearDaoConsultorios() {
		IDaoConsultorios icons = new DaoConsultoriosMySQL();
		return icons;
	}

	@Override
	public IDaoCargos crearDaoCargos() {
		IDaoCargos icar = new DaoCargosMySQL();
		return icar;
	}
	
}
