package logica.fachada;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import logica.AdminGen;
import logica.Afiliado;
import logica.Configuracion;
import logica.Consulta;
import logica.Disponibilidad;
import logica.Especialidad;
import logica.Examen;
import logica.Medico;
import logica.TipoExamen;
import logica.TotConsulta;
import logica.Usuario;
import logica.observer.Observable;
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
import persistencia.fabrica.IabsFactory;
import persistencia.transacciones.Pool;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.dataobjet.VoDispo;
import vista.dataobjet.VosLogin;
import excepciones.EspecialidadException;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class FachadaLogica extends Observable implements IfachadaLogica {

	private static FachadaLogica INSTANCE;
	private Configuracion conf;
	private IabsFactory fabrica;
	private Pool pool;
	//private Transaccion trn;
	private int nivelTrn;
	//DAOS
	private IDaoAdmGen iDaoAdmin;
	private IDaoAfiliado iDaoAfil;
	private IDaoConsultas iDaoC;
	private IDaoDisponibilidad iDaoD;
	private IDaoEspecialidades iDaoEsp;
	private IDaoExamen iDaoEx;
	private IDaoMedico iDaoM;
	private IDaoTipoExamen iDaoTE;
	private IDaoTotConsulta iDaoTC;
	private IDaoUsuarios iDaoU;
	
	private FachadaLogica() throws LogicaException, PersistenciaException, RemoteException{
		
		conf = new Configuracion();
		
		String fb = conf.getValor("FABRICA");
		System.out.println(conf.getValor("FABRICA"));
		
		try {
			nivelTrn = 8;
			fabrica = (IabsFactory) Class.forName(fb).newInstance();
			pool = new Pool(conf);
			iDaoAdmin = fabrica.crearDaoAdminGen();
			iDaoAfil = fabrica.crearDaoAfil();
			iDaoC = fabrica.crearDaoConsultas();
			iDaoD = fabrica.crearDaoDisp();
			iDaoEsp = fabrica.crearDaoEspecialidades();
			iDaoEx = fabrica.crearDaoEx();
			iDaoM = fabrica.crearDaoMed();
			iDaoTE = fabrica.crearDaoTEx();
			iDaoTC = fabrica.crearDaoTConsultas();
			iDaoU = fabrica.crearDaoUsuarios();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new LogicaException("No es poSsible crear la instancia necesaria para persistir");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new LogicaException("Sin acceso a la persistencia");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new LogicaException("Error en configuracion de la persistencia");
		} catch (Throwable e) {
			e.printStackTrace();
			throw new PersistenciaException("Exception Throwable");
		} 

	}
	
	public static FachadaLogica getInstance()throws LogicaException, PersistenciaException, RemoteException{
		
		if (INSTANCE == null){
			INSTANCE = new FachadaLogica();
		}
		return INSTANCE;
	}
	
//	public int getNivelTrn() {
//		return nivelTrn;
//	}
//
//	public void setNivelTrn(int nivelTrn) {
//		this.nivelTrn = nivelTrn;
//	}

//	public Transaccion getTrn() {
//		Transaccion trn = null;
//		try {
//			trn = pool.obtenerTrn(nivelTrn);
//		} catch (PersistenciaException e) {
//			e.printStackTrace();
//		}
//		return trn;
//	}

	//AFILIADOS
	public void altaAfiliado(Afiliado afil) throws PersistenciaException, RemoteException {
		pool.obtenerTrn(8);
		Transaccion trn = pool.obtenerTrn(8);
		String idAfil = afil.getId();
		try {
			if (iDaoAfil.validarAfil(trn, idAfil)==false){
			iDaoAfil.altaAfiliado(trn, afil);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El afiliado ya existe");
				
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, Calendar ing, boolean fon) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoAfil.validarAfil(trn, idAfil)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El afiliado no existe");
			}
			else{
				iDaoAfil.modifAfil(trn, idAfil, nom, apel, ci, mail, dir, tel, ing, fon);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void bajaAfil(String id) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoAfil.validarAfil(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El afiliado no existe");
			}
			else{
				iDaoAfil.bajaAfil(trn, id);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public Vector<Afiliado> listarAfiliados() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<Afiliado> resultado = null;
		try {
			resultado = iDaoAfil.listarAfiliados(trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public VosLogin getDataAfiliado(String id) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		VosLogin vosL = null;
		try {
			if (iDaoAfil.validarAfil(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El afiliado no existe");
			}
			else{
				vosL = iDaoAfil.getDataAfiliado(trn, id);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return vosL;
	}
	public boolean validarAfil(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		boolean resultado = false;
		try {
			resultado = iDaoAfil.validarAfil(trn, idAfil);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return resultado;
	}
	public Vector<Examen> listarExPend(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<Examen> resultado = null;
		try {
			resultado = iDaoAfil.listarExPend(trn, idAfil);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public Afiliado getAfiliado(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Afiliado af = null;
		try {
			if (iDaoAfil.validarAfil(trn, idAfil)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El afiliado no existe");
			}
			else{
				af = iDaoAfil.getAfiliado(idAfil, trn);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return af;
	}
	
	//ADMINS-GERENTES
	public void altaAdmin(AdminGen adm) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		String idAdm = adm.getId();
		try {
			if (iDaoAdmin.validarAdmin(trn, idAdm)==false){
			iDaoAdmin.altaAdmin(trn, adm);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else{
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El administrativo ya existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void modificarAdmin(String id, String nom, String cargo) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoAdmin.validarAdmin(trn, id)){
			iDaoAdmin.modificarAdmin(trn, id, nom, cargo);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else{
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El administrativo no existe");
				}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void bajaAdmin(String id) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoAdmin.validarAdmin(trn, id)){
			iDaoAdmin.bajaAdmin(trn, id);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else{
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El administrativo no existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public Vector<AdminGen> listarAdmin() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<AdminGen> resultado = null;
		try {
			resultado = iDaoAdmin.listarAdmin(trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public VosLogin getDataAdmin(String id) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		VosLogin vosL = null;
		try {
			if (iDaoAdmin.validarAdmin(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El administrativo no existe");
			}
			else{
				vosL = iDaoAdmin.getDataAdmin(trn, id);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return vosL;
	}
	public boolean validarAdmin(String id) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		boolean resultado = false;
		try {
			resultado = iDaoAdmin.validarAdmin(trn, id);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return resultado;
	}
	public void modifEx(String idAfil,Calendar fIni,int idTex,Calendar fRes) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoAdmin.validarAdmin(trn, idAfil)){
			iDaoAdmin.modifEx(trn, idAfil, fIni, idTex, fRes);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else{
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El administrativo no existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	
	//CONSULTAS
	public int getCantidadConsultas(Calendar fDesde, Calendar fHasta, String idMed) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int resultado = 0;
		try {
			resultado = iDaoC.getCantidadConsultas(trn, fDesde, fHasta, idMed);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public void altaConsultaProxMes(Consulta cons, String idMed) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoC.altaConsultaProxMes(trn, cons, idMed);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public Vector<Consulta> listarConsultasDisp(String idMed) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<Consulta> resultado = null;
		try {
			resultado = iDaoC.listarConsultasDisp(trn, idMed);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public void altaConsulta(Calendar fecha, int horario, int dia, int idConsultorio, boolean timbre, Afiliado afil, int turno, Medico med) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoC.altaConsulta(trn, fecha, horario, dia, idConsultorio, timbre, afil, turno, med);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void elimConsultasAfil(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoC.elimConsultasAfil(trn, idAfil);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	
	//DISPONIBILIDAD
	public void updateDisponibilidad(VoDispo vo) throws PersistenciaException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoD.updateDisponibilidad(vo, trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	
	//ESPECIALIDADES
	public void altaEspecialidad(DataEsp datEsp) throws RemoteException, PersistenciaException, EspecialidadException {
		Transaccion trn = pool.obtenerTrn(8);
		Especialidad esp = new Especialidad(datEsp.getCodigo(), datEsp.getDescripcion(), datEsp.getMontoBase());
		try {
			if (iDaoEsp.obtenerEspecialidad(trn, esp.getIdEspecialidad())==null){
			iDaoEsp.altaEspecialidad(trn, esp);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else{
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new EspecialidadException("La especialidad ya existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public Vector<Especialidad> listarEspecialidades() throws RemoteException, PersistenciaException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<Especialidad> resultado = null;
		try {
			resultado = iDaoEsp.listarEspecialidades(trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public Especialidad obtenerEspecialidad(int idEsp) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Especialidad es = null;
		try {
			es = iDaoEsp.obtenerEspecialidad(trn, idEsp);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return es;
	}
	
	//EXAMENES
	public void regEx(Examen ex, String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoEx.regEx(trn, ex, idAfil);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public int getCantExPagos(Calendar fini,Calendar ffin) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int resultado = 0;
		try {
			resultado = iDaoEx.getCantExPagos(trn, fini, ffin);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public int getCantExam(Calendar fecha) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int resultado = 0;
		try {
			resultado = iDaoEx.getCantExam(trn, fecha);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	
	//MEDICOS
	public void altaMedico(Medico med) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		String idMed = med.getId();
		try {
			if (iDaoM.validarMed(trn, idMed)==false){
			iDaoM.altaMedico(trn, med);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else{
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El m�dico ya existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
 	public void modifMedico(String id, String nom, String apell, String ci, String tel, Especialidad esp) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoM.validarMed(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El m�dico no existe");
			}
			else{
				iDaoM.modifMedico(trn, id, nom, apell, ci, tel, esp);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
 	}
 	public void bajarMedico(String id) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoM.validarMed(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El m�dico no existe");
			}
			else{
				iDaoM.bajarMedico(trn, id);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
 	}
 	public Vector<Medico> listarMedicos() throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<Medico> resultado = null;
		try {
			resultado = iDaoM.listarMedicos(trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
 	}
 	public Vector<Medico> listarMedEsp(int idEsp) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<Medico> resultado = null;
		try {
			resultado = iDaoM.listarMedEsp(idEsp, trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
 	}
 	public Medico getMedico(String id) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Medico med = null;
		try {
			med = iDaoM.getMedico(trn, id);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return med;
 	}
 	public VosLogin getDataMedico(String id) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		VosLogin vosL = null;
		try {
			vosL = iDaoM.getDataMedico(trn, id);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return vosL;
 	}
 	public boolean validarMed(String id) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		boolean resultado = false;
		try {
			resultado = iDaoM.validarMed(trn, id);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return resultado;
 	}
 	public Vector listarSalarios(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector resultado = null;
		try {
			resultado = iDaoM.listarSalarios(trn, fDesde, fHasta);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
 	}
 	public Vector<Medico> listarMedPremiado(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<Medico> resultado = null;
		try {
			resultado = iDaoM.listarMedPremiado(trn, fDesde, fHasta);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
 	}
 	public Vector calcSalarioTotal(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector resultado = null;
		try {
			resultado = iDaoM.calcSalarioTotal(trn, fDesde, fHasta);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
 	}
 	public Vector<Disponibilidad> listarDispMed(DataMed dataMed) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<Disponibilidad> resultado = null;
		try {
			resultado = iDaoM.listarDispMed(dataMed, trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
 	}
 	public void cargaConsultasProxMes(String id, Calendar fecha) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoM.validarMed(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El m�dico no existe");
			}
			else{
				iDaoM.cargaConsultasProxMes(trn, id, fecha);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
 	}
	public void altaConsulta(Calendar fecha,String id, int dia, Afiliado afil, int conult) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoM.validarMed(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El m�dico no existe");
			}
			else{
				iDaoM.altaConsulta(trn, fecha, id, dia, afil, conult);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			trn.finalizarTrn(false);
			e.printStackTrace();
		}
	}
	
	//TIPO DE EXAMEN
	public void agregar(TipoExamen tex) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoTE.agregar(trn, tex);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void modificar(TipoExamen tex) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoTE.modificar(trn, tex);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public Vector<TipoExamen> listarTipoEx() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<TipoExamen> resultado = null;
		try {
			resultado = iDaoTE.listarTipoEx(trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	
	//TOTAL CONSULTAS
	public int getCantConsult(String x) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int resultado = 0;
		try {
			resultado = iDaoTC.getCantConsult(trn, x);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public int getCantConsultasPagas(Calendar fDesde,Calendar fHasta) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int resultado = 0;
		try {
			resultado = iDaoTC.getCantConsultasPagas(trn, fDesde, fHasta);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public Vector<TotConsulta> listarConsultasAfi(String id) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<TotConsulta> resultado = null;
		try {
			resultado = iDaoTC.listarConsultasAfi(trn, id);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public Vector<TotConsulta> listarConsFecha(Calendar fecha) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<TotConsulta> resultado = null;
		try {
			resultado = iDaoTC.listarConsFecha(trn, fecha);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return resultado;
	}
	public void elimConsulta(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoTC.elimConsulta(trn, idAfil);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	
	//USUARIOS
	public void altaUsuario(Usuario usu) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoU.altaUsuario(trn, usu);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public boolean validarUsuario(String clave,String pass) throws PersistenciaException, RemoteException{
		Transaccion trn = pool.obtenerTrn(8);
		boolean resultado = false;
		try {
			resultado = iDaoU.validarUsuario(clave, pass, trn);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return resultado;
	}
	public void modifContrasena(String clave, String pass) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoU.modifContrasena(clave, pass, trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
}