package persistencia.mains;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;
import vista.controladores.CdorMantEsp;
import vista.dataobjet.DataAdmin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class MainDaoAdm {
	
	public static void main(String[] args) throws LogicaException, PersistenciaException {
		try 
		{
			
			IfachadaLogica facade = new ProxyFachadaLogica();
			
			JOptionPane.showMessageDialog(null,"Hizo el lookup");
			DataAdmin adm = new DataAdmin("ELFEDE", "FEDERICO", 1, "A");
			if (facade.validarAdmin(adm.getId())==false){
			facade.altaAdmin(adm);
			}
			else{
				JOptionPane.showMessageDialog(null,"Administrador ya esssiste");
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();			
			JOptionPane.showMessageDialog(null,"Error de conexion con el Servidor");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
