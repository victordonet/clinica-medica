package logica.server;



import javax.swing.JOptionPane;

import vista.controladores.CdorLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class PruebaClienteRMI {
	public static void main(String[] args) throws LogicaException, PersistenciaException {
		try 
		{
						
			CdorLogin cdorLogin = new CdorLogin();
			cdorLogin.desplegarVentana(cdorLogin);
	
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema por favor contactar al adminitrador");
		}
	}
		
}


