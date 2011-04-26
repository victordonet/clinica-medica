package vista.acceso;



import javax.swing.JOptionPane;

import vista.controladores.CdorLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class ClienteClinicaMedica {
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


