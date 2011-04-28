package vista.acceso;

import vista.controladores.CdorLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class ClienteClinicaMedica {
	public static void main(String[] args) throws LogicaException, PersistenciaException {
		CdorLogin cdorLogin = new CdorLogin();
		cdorLogin.desplegarVentana(cdorLogin);
	}		
}