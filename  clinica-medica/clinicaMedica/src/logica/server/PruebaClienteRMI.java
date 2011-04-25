package logica.server;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import logica.fachada.IfachadaLogica;
import vista.acceso.ProxyFachadaLogica;
import vista.controladores.CdorLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class PruebaClienteRMI {

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
			/*CdorAltaMedico ctrl = new CdorAltaMedico();
			FrmAltaMedico frm = new FrmAltaMedico(ctrl);
			
			//CdorAltaAdmin ctrl1 = new CdorAltaAdmin();
			FrmAltaAdmin frm1 = new FrmAltaAdmin(ctrl1);*/
			
			CdorLogin cdorLogin = new CdorLogin();
			cdorLogin.desplegarVentana(cdorLogin);
//			ctrl.setMod(facade);
//			ctrl.desplegarVentana(ctrl);	
		} catch (RemoteException e) {
			e.printStackTrace();			
			JOptionPane.showMessageDialog(null,"Error de conexion con el Servidor");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}


