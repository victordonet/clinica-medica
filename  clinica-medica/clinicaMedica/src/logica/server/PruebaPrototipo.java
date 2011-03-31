package logica.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.*;
import vista.controladores.CdorListadoEsp;
import vista.controladores.CdorManejoVentanas;
import vista.controladores.CdorMantEsp;

import excepciones.LogicaException;
import excepciones.PersistenciaException;

import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class PruebaPrototipo {

	/**
	 * @param args
	 * @throws PersistenciaException 
	 * @throws LogicaException 
	 */
	public static void main(String[] args) throws LogicaException, PersistenciaException {
		try 
		{
			
			IfachadaLogica facade = new ProxyFachadaLogica();
			
			JOptionPane.showMessageDialog(null,"Hizo el lookup");
			CdorMantEsp ctrl = new CdorMantEsp();
			ctrl.setMod(facade);
			ctrl.desplegarVentana(ctrl);	
		} catch (RemoteException e) {
			e.printStackTrace();			
			JOptionPane.showMessageDialog(null,"Error de conexion con el Servidor");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


