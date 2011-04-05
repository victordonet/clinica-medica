package logica.fachada;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import logica.Configuracion;
import logica.Especialidad;
import logica.observer.Observable;
import persistencia.dao.EspecialidadException;
import persistencia.dao.IDaoEspecialidades;
import persistencia.dao.IDaoUsuarios;
import persistencia.fabrica.IabsFactory;
import persistencia.transacciones.Pool;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataEsp;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class FachadaLogica extends Observable implements IfachadaLogica {

	private static FachadaLogica INSTANCE;
	private IDaoEspecialidades IDaoE;
	private IDaoUsuarios IDaoU;
	private Configuracion conf;
	private IabsFactory fabrica;
	private Pool pool;
	
	private FachadaLogica() throws LogicaException, PersistenciaException, RemoteException{
		
		conf = new Configuracion();
		
		String fb = conf.getValor("FABRICA");
		System.out.println(conf.getValor("FABRICA"));
		
		try {
			fabrica = (IabsFactory) Class.forName(fb).newInstance();
			pool = new Pool(conf);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LogicaException("No es posible crear la instancia necesaria para persistir");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LogicaException("Sin acceso a la persistencia");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LogicaException("Error en configuracion de la persistencia");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PersistenciaException("No tengo idea que mensaje dar");
		} 
		IDaoE = fabrica.crearDaoEspecialidades();
		IDaoU = fabrica.crearDaoUsuarios();
	}
	
	public static FachadaLogica getInstance()throws LogicaException, PersistenciaException, RemoteException{
		
		if (INSTANCE == null){
			INSTANCE = new FachadaLogica();
		}
		return INSTANCE;
	}
	
	public void altaEspecialidades(DataEsp datEsp)throws RemoteException, PersistenciaException, EspecialidadException {
		Transaccion trn = pool.obtenerTrn(8);
		Especialidad esp = new Especialidad(datEsp.getCodigo(), datEsp.getDescripcion(), datEsp.getMontoBase());
		try {
			if (IDaoE.obtenerEspecialidad(trn, esp.getIdEspecialidad())==null){
			//JOptionPane.showMessageDialog(null,esp.getIdEspecialidad());
			IDaoE.agregar(trn, esp);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
			this.notificar();
			}
			else
				throw new EspecialidadException("La especialidad ya existe");
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			trn.finalizarTrn(false);
			e.printStackTrace();
		}
	}
	
	public Vector listarEspecialidades()throws RemoteException, PersistenciaException {
		Vector hs = null;
		Transaccion trn = pool.obtenerTrn(8);
		try {
			hs = IDaoE.listarEspecialidades(trn);
			trn.finalizarTrn(true);
			pool.liberarTrn(trn);
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			trn.finalizarTrn(false);
			pool.liberarTrn(trn);
			throw e;
		}
		return hs;
	}
	
	public boolean validarUsuario(String clave,String pass) throws PersistenciaException, RemoteException{
		boolean resultado = false;
		try {
			Transaccion trn = pool.obtenerTrn(8);
			resultado = IDaoU.validarUsuario(clave, pass, trn);
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
}
