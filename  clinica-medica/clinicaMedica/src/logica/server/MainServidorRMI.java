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
import logica.fachada.IfachadaLogica;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class MainServidorRMI 
{
	private static IfachadaLogica facade; 

	public static void main(String[] args) {
		try 
		{
			facade = FachadaLogica.getInstance();
			/**
			 *Creamos el registro en el puerto 1099 
			 */
			Registry registry =LocateRegistry.createRegistry(1099);
			/**
			 * publicamos el objeto remoto
			 */
			Configuracion conf = new Configuracion();
			String ruta = conf.getValor("SERVER-RMI");
			Naming.rebind(ruta+"logica", facade);
		}catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"No es posible iniciar el Servidor");
			System.exit(0);
		} 
		catch (MalformedURLException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
			System.exit(0);
		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			System.exit(0);
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			System.exit(0);
		}
		TimerTask tarea = new TimerTask() {
			public void run() {
				try {
					//Esto esta comentado para poder hacer las pruebas 						
					//int ultimoDia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
					//int hoy = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					//if (hoy == ultimoDia){
					facade.altaConsultaProxMes();
					//}
				} catch (RemoteException e) {
				} catch (PersistenciaException e) {
				}
			}
		};

		Timer temporizador = new Timer();
		// este temporizador es el definitivo y se ejecuta cada 24 horas
		//temporizador.schedule(tarea, 60*1000,24*60*60*1000);
		//este temporizador es de pruebas y se ejecuta cada 1 minuto
		//temporizador.schedule(tarea, 60*1000,60*1000);
		JOptionPane.showMessageDialog(null,"Servidor iniciado");
	}
}