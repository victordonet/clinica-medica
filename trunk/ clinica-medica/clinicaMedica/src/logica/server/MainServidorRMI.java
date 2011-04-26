package logica.server;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Timer;
import java.util.TimerTask;

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
			final FachadaLogica facade = FachadaLogica.getInstance();
            /**
             * publicamos el objeto remoto
             */
			Configuracion conf = new Configuracion();
			String ruta = conf.getValor("SERVER-RMI");
			Naming.rebind(ruta+"logica", facade);

			
			
			TimerTask tarea = new TimerTask() {
				public void run() {
					try {
//Esto esta comentado para poder hacer las pruebas 						
						//int ultimoDia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
						//int hoy = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
						//if (hoy == ultimoDia){
						System.out.println("Voy con el demonio");
						facade.altaConsultaProxMes();
						//}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PersistenciaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			Timer temporizador = new Timer();
			//temporizador.schedule(tarea, 60*1000,24*60*60*1000);
			//temporizador.schedule(tarea, 60*1000,60*1000);
			//JOptionPane.showMessageDialog(null,"Servidor iniciado");
			
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
