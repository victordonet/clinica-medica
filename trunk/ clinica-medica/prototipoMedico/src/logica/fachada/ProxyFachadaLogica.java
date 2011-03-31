package logica.fachada;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import persistencia.dao.EspecialidadException;
import logica.Configuracion;
import logica.observer.IObserver;
import vista.dataobjet.DataEsp;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class ProxyFachadaLogica implements IfachadaLogica {
	
	private IfachadaLogica fachada;
	
	public ProxyFachadaLogica() throws RemoteException, LogicaException, PersistenciaException {
		
		Configuracion conf = new Configuracion();
		String ruta = conf.getValor("SERVER-RMI");
		 try {
			fachada = (IfachadaLogica) Naming.lookup(ruta+"logica");
		} catch (MalformedURLException e) {
			new LogicaException("Publicación del servidor incorrecta");
			e.printStackTrace();
		} catch (NotBoundException e) {
			new LogicaException("Error Bound Exception");
			e.printStackTrace();
		}
	}

	public void addObserver(IObserver obs) throws RemoteException {
		fachada.addObserver(obs);
	}
	
	public void remObserver(IObserver obs) throws RemoteException {
		fachada.remObserver(obs);
	}

	public void notificar() throws RemoteException {
		fachada.notificar();
	}

	public void altaEspecialidades(DataEsp datEsp) throws RemoteException, PersistenciaException, EspecialidadException {
		
			fachada.altaEspecialidades(datEsp);
	}

	public Vector listarEspecialidades() throws PersistenciaException, RemoteException {
		return fachada.listarEspecialidades();
	}
	
	public boolean validarUsuario(String clave, String pass) throws PersistenciaException, RemoteException {
		return fachada.validarUsuario(clave, pass);
	}
}
