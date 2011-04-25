package logica.server;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import logica.fachada.FachadaLogica;
import excepciones.LogicaException;
import excepciones.PersistenciaException;


public class MainGeneracionConsultas {


	public static void main(String[] args) {
		
		Calendar fecha = Calendar.getInstance();
		
		TimerTask tarea = new TimerTask() {
			public void run() {
				try {
					FachadaLogica.getInstance().altaConsultaProxMes();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PersistenciaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LogicaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Timer temporizador = new Timer();
		temporizador.schedule(tarea,fecha.getTimeInMillis());
		

	    }  
}


