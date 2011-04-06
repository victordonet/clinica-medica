package logica.server;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import logica.Configuracion;
import logica.fachada.FachadaLogica;
import excepciones.LogicaException;
import excepciones.PersistenciaException;



public class MainServidorRMI 
{
	public static void main(String[] args) 
	{
		try 
		{
			/**
			 *Creamos el registro en el puerto 1099 
			 */
			Registry registry =LocateRegistry.createRegistry(1099);
           	/**
           	 * Instanciamos el objeto remoto FachadaLogica
           	 */
			FachadaLogica facade = FachadaLogica.getInstance();
            /**
             * publicamos el objeto remoto
             */
			Configuracion conf = new Configuracion();
			String ruta = conf.getValor("SERVER-RMI");
			Naming.rebind(ruta+"logica", facade);
			System.out.println("Servidor iniciado");
			JOptionPane.showMessageDialog(null,"Servidor iniciado");
		} 
		catch (RemoteException e) 
		{
			System.out.println("No es posible iniciar el Servidor");
			JOptionPane.showMessageDialog(null,"No es posible iniciar el Servidor");
			e.printStackTrace();
		} 
		catch (MalformedURLException e)
		{
			System.out.println("URL de publicacion incorrecta");
			JOptionPane.showMessageDialog(null,"URL mal");
			e.printStackTrace();
		} catch (LogicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
