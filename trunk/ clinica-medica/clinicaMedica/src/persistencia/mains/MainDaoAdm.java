package persistencia.mains;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataUsuario;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class MainDaoAdm {
	
	public static void main(String[] args) throws LogicaException, PersistenciaException {
		try 
		{
			IfachadaLogica facade = new ProxyFachadaLogica();
			DataAdmin adm = new DataAdmin("FEDE", "FEDERICO", 1, "A");
			facade.altaAdmin(adm);
			JOptionPane.showMessageDialog(null,"Alta ADM");
			
			JOptionPane.showMessageDialog(null,"Validando Id FEDE" + facade.validarAdmin("FEDE"));
			
			//Usuarios:
			//Alta
			DataUsuario usuAdm = new DataUsuario("FMARTINEZ","1234","AD","A");
			facade.altaUsuario(usuAdm);			
			
			facade.bajaAdmin("FEDE");
			JOptionPane.showMessageDialog(null,"Bajo Id FEDE");
			facade.modifEstado(adm.getId());
			
		} catch (RemoteException e) {
			e.printStackTrace();			
			JOptionPane.showMessageDialog(null,"Error de conexion con el Servidor");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}


}
