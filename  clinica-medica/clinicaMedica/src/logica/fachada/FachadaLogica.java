package logica.fachada;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import logica.Configuracion;
import logica.Especialidad;
import logica.Medico;
import logica.observer.Observable;
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
import persistencia.fabrica.IabsFactory;
import persistencia.transacciones.Pool;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataCantConsu;
import vista.dataobjet.DataCargo;
import vista.dataobjet.DataConsAfi;
import vista.dataobjet.DataConsFecha;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.DataConsultas;
import vista.dataobjet.DataConsultorio;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataExamen;
import vista.dataobjet.DataMed;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.DataSalario;
import vista.dataobjet.DataTipoExamen;
import vista.dataobjet.DataUsuario;
import vista.dataobjet.DataDisp;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoResumCont;
import vista.dataobjet.VoTurnosDisp;
import vista.dataobjet.VosLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class FachadaLogica extends Observable implements IfachadaLogica {

	private static final long serialVersionUID = 1L;
	private static FachadaLogica INSTANCE;
	private Configuracion conf;
	private IabsFactory fabrica;
	private Pool pool;
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
	private IDaoParametros iDaoP;
	private IDaoConsultorios iDaoConsultorios;
	private IDaoCargos iDaoCargos;
	
	private FachadaLogica() throws LogicaException, PersistenciaException, RemoteException{
		
		conf = new Configuracion();
		
		String fb = conf.getValor("FABRICA");
		System.out.println(conf.getValor("FABRICA"));
		
		try {
			
			fabrica = (IabsFactory) Class.forName(fb).newInstance();
			pool = Pool.getInstance(conf);
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
			iDaoP = fabrica.crearDaoParametros();
			iDaoConsultorios = fabrica.crearDaoConsultorios();
			iDaoCargos = fabrica.crearDaoCargos();
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
	
	//AFILIADOS
	public void altaAfiliado(DataAfiliado afil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		String idAfil = afil.getId();
		try {
			if (iDaoAfil.validarAfil(trn, idAfil)==false){
			iDaoAfil.altaAfiliado(trn, afil);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			
			}
			else{
			
				throw new PersistenciaException("El afiliado ya existe");
			}
				
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw new PersistenciaException(e.getMessage());
		}
	}
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, boolean fon) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoAfil.validarAfil(trn, idAfil)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El afiliado no existe");
			}
			else{
				iDaoAfil.modifAfil(trn, idAfil, nom, apel, ci, mail, dir, tel, fon);
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
		Transaccion trn = pool.obtenerTrn(1);
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
	public Vector<DataAfiliado> listarAfiliados() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataAfiliado> resultado = null;
		try {
			resultado = iDaoAfil.listarAfiliados(trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(true);
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
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return resultado;
	}
	public Vector<DataExamen> listarExPend(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataExamen> resultado = null;
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
	public DataAfiliado getAfiliado(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		DataAfiliado af = null;
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
	public boolean cobraTimbre(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		boolean resultado = true;
		try {
			DataAfiliado af =  iDaoAfil.getAfiliado(idAfil, trn);
			boolean fonasa = af.getFonasa();
			if (fonasa){
				int cantConsultas = iDaoTC.getCantConsult(trn, idAfil);
				if (cantConsultas<11){
					resultado = false;
				}
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		trn.finalizarTrn(true);
		pool.liberarTrn(trn);
		return resultado;
	}
	
	//ADMINS-GERENTES
	public void altaAdmin(DataAdmin adm) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
	
		try {
			if(iDaoAdmin.validarAdmin(trn, adm.getId())==false){
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
			throw new PersistenciaException(e.getMessage());
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
	public Vector<DataAdmin> listarAdmin() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataAdmin> resultado = null;
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
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
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
	public Vector<VoResumCont> listarResContable(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<VoResumCont> resultado = new Vector<VoResumCont>();
		//busco salarios
		VoResumCont salarios = iDaoM.calcSalarioTotal(trn, fDesde, fHasta);
		resultado.add(salarios);
		//busco valor tikets/timbres
		double valor = Double.parseDouble(iDaoP.getValor(trn, "ValorTimbre"));
		//busco timbres
		int cantConsPagas = iDaoTC.getCantConsultasPagas(trn, fDesde, fHasta);
		VoResumCont timbres = new VoResumCont("Timbres", valor*cantConsPagas);
		resultado.add(timbres);
		//busco tikets
		int cantTikets = iDaoEx.getCantExPagos(trn, fDesde, fHasta);
		VoResumCont tikets = new VoResumCont("Timbres", valor*cantTikets);
		resultado.add(tikets);
		trn.finalizarTrn(true);
		pool.liberarTrn(trn);
		return resultado;
	}
	public Vector<DataCargo> listarCargos() throws PersistenciaException, RemoteException {
		
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataCargo> resultado = null;
		try {
			resultado = iDaoCargos.listarCargos(trn);
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
	public void altaConsultaProxMes(DataConsulta cons, String idMed) throws PersistenciaException, RemoteException {
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
	public Vector<VoTurnosDisp> listarConsultasDisp(String idMed) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<VoTurnosDisp> resultado = null;
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
	public void altaConsulta(DataReservaTurno dataResTurno) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Calendar fecha = dataResTurno.getFecha();
		String idMed = dataResTurno.getIdMedico();
		int dia = dataResTurno.getDia();
		String idAfil = dataResTurno.getIdAfil();
		int consultorio = dataResTurno.getIdConsultorio();
		int turno = dataResTurno.getTurno();
		int horario = dataResTurno.getHorario();
		try {
			if (iDaoM.validarMed(trn, idMed)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El médico no existe");
			}
			else{
				int cantCons = iDaoTC.getCantConsult(trn, idAfil);
				boolean timbre = true;
				if(cantCons<10){
					timbre=false;
				}
				iDaoC.altaConsulta(trn, fecha, idMed, dia, idAfil, consultorio, turno, horario, timbre);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
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
	public Vector<DataConsultas> listarConsultas() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataConsultas> resultado = null;
		try {
			resultado = iDaoC.listarConsultas(trn);
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
	
	//DISPONIBILIDAD
	public void altaDisponibilidad(DataDisp dataDsip) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoD.altaDisponibilidad(trn, dataDsip);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void eliminarDisponibilidad(DataDisp vo) throws PersistenciaException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			iDaoD.eliminarDisponibilidad(vo, trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public int[][] obetnerDispoDiaHora() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int matriz[][] = new int [12][7];
		try {
			Vector <DataDisp> dispo = iDaoD.listarDispTotal(trn);
			 
			for(DataDisp ladis :dispo){
				switch (ladis.getHorario()){
				case 0:{
					switch (ladis.getDia()){
					case 1: matriz[0][1]++;
					case 2: matriz[0][2]++;
					case 3: matriz[0][3]++;
					case 4: matriz[0][4]++;
					case 5: matriz[0][5]++;
					case 6: matriz[0][6]++;
					case 7: matriz[0][7]++;
					}
				}
				case 1:{
					switch (ladis.getDia()){
					case 1: matriz[1][1]++;
					case 2: matriz[1][2]++;
					case 3: matriz[1][3]++;
					case 4: matriz[1][4]++;
					case 5: matriz[1][5]++;
					case 6: matriz[1][6]++;
					case 7: matriz[1][7]++;
					}
				}
				case 2:{
					switch (ladis.getDia()){
					case 1: matriz[2][1]++;
					case 2: matriz[2][2]++;
					case 3: matriz[2][3]++;
					case 4: matriz[2][4]++;
					case 5: matriz[2][5]++;
					case 6: matriz[2][6]++;
					case 7: matriz[2][7]++;
					}
				}
				case 3:{
					switch (ladis.getDia()){
					case 1: matriz[3][1]++;
					case 2: matriz[3][2]++;
					case 3: matriz[3][3]++;
					case 4: matriz[3][4]++;
					case 5: matriz[3][5]++;
					case 6: matriz[3][6]++;
					case 7: matriz[3][7]++;
					}
				}
				case 4:{
					switch (ladis.getDia()){
					case 1: matriz[4][1]++;
					case 2: matriz[4][2]++;
					case 3: matriz[4][3]++;
					case 4: matriz[4][4]++;
					case 5: matriz[4][5]++;
					case 6: matriz[4][6]++;
					case 7: matriz[4][7]++;
					}
				}
				case 5:{
					switch (ladis.getDia()){
					case 1: matriz[5][1]++;
					case 2: matriz[5][2]++;
					case 3: matriz[5][3]++;
					case 4: matriz[5][4]++;
					case 5: matriz[5][5]++;
					case 6: matriz[5][6]++;
					case 7: matriz[5][7]++;
					}
				}
				case 6:{
					switch (ladis.getDia()){
					case 1: matriz[6][1]++;
					case 2: matriz[6][2]++;
					case 3: matriz[6][3]++;
					case 4: matriz[6][4]++;
					case 5: matriz[6][5]++;
					case 6: matriz[6][6]++;
					case 7: matriz[6][7]++;
					}
				}
				case 7:{
					switch (ladis.getDia()){
					case 1: matriz[7][1]++;
					case 2: matriz[7][2]++;
					case 3: matriz[7][3]++;
					case 4: matriz[7][4]++;
					case 5: matriz[7][5]++;
					case 6: matriz[7][6]++;
					case 7: matriz[7][7]++;
					}
				}
				case 8:{
					switch (ladis.getDia()){
					case 1: matriz[8][1]++;
					case 2: matriz[8][2]++;
					case 3: matriz[8][3]++;
					case 4: matriz[8][4]++;
					case 5: matriz[8][5]++;
					case 6: matriz[8][6]++;
					case 7: matriz[8][7]++;
					}
				}
				case 9:{
					switch (ladis.getDia()){
					case 1: matriz[9][1]++;
					case 2: matriz[9][2]++;
					case 3: matriz[9][3]++;
					case 4: matriz[9][4]++;
					case 5: matriz[9][5]++;
					case 6: matriz[9][6]++;
					case 7: matriz[9][7]++;
					}
				}
				case 10:{
					switch (ladis.getDia()){
					case 1: matriz[10][1]++;
					case 2: matriz[10][2]++;
					case 3: matriz[10][3]++;
					case 4: matriz[10][4]++;
					case 5: matriz[10][5]++;
					case 6: matriz[10][6]++;
					case 7: matriz[10][7]++;
					}
				}
				case 11:{
					switch (ladis.getDia()){
					case 1: matriz[11][1]++;
					case 2: matriz[11][2]++;
					case 3: matriz[12][3]++;
					case 4: matriz[13][4]++;
					case 5: matriz[14][5]++;
					case 6: matriz[15][6]++;
					case 7: matriz[16][7]++;
					}
				}
				}
			}	
		} catch (PersistenciaException e) {
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		trn.finalizarTrn(true);
		pool.liberarTrn(trn);
		int a = matriz [2][7];
		return matriz;
	}
	//ESPECIALIDADES
	public void altaEspecialidad(DataEsp datEsp) throws RemoteException, PersistenciaException  {
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
				throw new PersistenciaException("La especialidad ya existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public Vector<DataEsp> listarEspecialidades() throws RemoteException, PersistenciaException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataEsp> resultado = null;
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
	public DataEsp obtenerEspecialidad(int idEsp) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		DataEsp es = null;
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
	public void bajaEspecialidad(int idEsp) throws RemoteException, PersistenciaException  {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoEsp.obtenerEspecialidad(trn, idEsp)==null){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("La especialidad no existe.");
			}else{
				iDaoEsp.bajaEspecialidad(trn, idEsp);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	
	//EXAMENES
	public void regEx(DataExamen ex, String idAfil) throws PersistenciaException, RemoteException {
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
	public void altaMedico(DataMed med) throws PersistenciaException, RemoteException {
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
				throw new PersistenciaException("El médico ya existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw new PersistenciaException(e.getMessage());
			
		}
	}
 	public void modifMedico(String id, String nom, String apell, String ci, String tel, DataEsp esp) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoM.validarMed(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El médico no existe");
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
				throw new PersistenciaException("El médico no existe");
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
 	public Vector<DataMed> listarMedicos() throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataMed> resultado = null;
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
 	public Vector<VoMedEsp> listarMedEsp(int idEsp) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<VoMedEsp> resultado = null;
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
 	public Vector<DataSalario> listarSalarios(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataSalario> resultado = null;
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
 	public Vector<DataCantConsu> listarMedPremiado(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataCantConsu> resultado = null;
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
 	public VoResumCont calcSalarioTotal(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
 		VoResumCont resultado = null;
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
 	public Vector<DataDisp> listarDispMed(String idMed) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataDisp> resultado = null;
		try {
			resultado = iDaoM.listarDispMed(idMed, trn);
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
 	public void cargaConsultasProxMes(String id) throws PersistenciaException, RemoteException {
 		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoM.validarMed(trn, id)==false){
				trn.finalizarTrn(false);
				pool.liberarTrn(trn);
				throw new PersistenciaException("El médico no existe");
			}
			else{
				int totalConsultorios = iDaoConsultorios.totalConsultorios(trn);
				iDaoM.cargaConsultasProxMes(trn, id, totalConsultorios);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
 	}
 	public DataMed getDataMed(String id) throws PersistenciaException, RemoteException{
 		Transaccion trn = pool.obtenerTrn(8);
 		DataMed med = null;
 		try {
 			med = iDaoM.getDataMed(trn, id);
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
 	
	//TIPO DE EXAMEN
	public void agregar(DataTipoExamen tex) throws PersistenciaException, RemoteException {
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
	public void modificar(DataTipoExamen tex) throws PersistenciaException, RemoteException {
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
	public Vector<DataTipoExamen> listarTipoEx() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataTipoExamen> resultado = null;
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
	public int getCantConsult(String idAfil) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int resultado = 0;
		try {
			resultado = iDaoTC.getCantConsult(trn, idAfil);
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
	public Vector<DataConsAfi> listarConsultasAfi(String id) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataConsAfi> resultado = null;
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
	public Vector<DataConsFecha> listarConsFecha(Calendar fecha) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataConsFecha> resultado = null;
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
	public void altaUsuario(DataUsuario usu) throws PersistenciaException, RemoteException {
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
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
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
	public String getTipo(String idUsuario) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		String resultado = null;
		try {
			resultado = iDaoU.getTipo(trn, idUsuario);
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
	public boolean validarConsultorio(int id) throws PersistenciaException, RemoteException{
		Transaccion trn = pool.obtenerTrn(8);
		boolean resultado = false;
		try {
			resultado = iDaoConsultorios.validaConsultorio(trn, id);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
		return resultado;

	}
	public void altaConsultorio(DataConsultorio consultorio) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		int idConsultorio = consultorio.getIdConsultorio();
		try {
			if (iDaoConsultorios.validaConsultorio(trn, idConsultorio)==false){
			iDaoConsultorios.altaConsultorio(trn, consultorio);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			}
			else{
			
				throw new PersistenciaException("El consultorio ya existe");
			}
				
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public void bajaConsultorio(int idConsultorio) throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		try {
			if (iDaoConsultorios.validaConsultorio(trn, idConsultorio)){
				iDaoConsultorios.bajaConsultorio(trn, idConsultorio);
				trn.finalizarTrn(true);
				pool.liberarTrn(trn);
			}
			else{
				throw new PersistenciaException("El consultorio no existe");
			}
		} catch (PersistenciaException e) {
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			e.printStackTrace();
		}
	}
	public Vector<DataConsultorio> listarConsultorios() throws PersistenciaException, RemoteException {
		Transaccion trn = pool.obtenerTrn(8);
		Vector<DataConsultorio> resultado = null;
		try {
			resultado = iDaoConsultorios.listarConsultorios(trn);
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
}