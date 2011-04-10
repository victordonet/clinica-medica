package logica.fachada;

import java.rmi.RemoteException;
import java.util.Vector;

import persistencia.transacciones.Transaccion;

import logica.observer.IObservable;

import excepciones.EspecialidadException;
import excepciones.PersistenciaException;

import vista.dataobjet.DataEsp;

public interface IfachadaLogica extends IObservable{

	//Especialidades
	public void altaEspecialidades(DataEsp datEsp) throws PersistenciaException, RemoteException, EspecialidadException;
	public Vector listarEspecialidades() throws PersistenciaException, RemoteException;
	
	//Usuarios
	public boolean validarUsuario(String clave,String pass) throws PersistenciaException, RemoteException;
}
