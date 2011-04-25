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
		
		
	
//		TimerTask tarea = new TimerTask() {
//			public void run() {
//				try {
//					int ultimoDia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
//					int hoy = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//					if (hoy == ultimoDia){
//					FachadaLogica.getInstance().altaConsultaProxMes();
//					}
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (PersistenciaException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (LogicaException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		Timer temporizador = new Timer();
//		temporizador.schedule(tarea, 24*60*60*1000);
		
		TimerTask tarea = new TimerTask() {
			public void run() {
				try {
					//int ultimoDia = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
					//int hoy = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					//if (hoy == ultimoDia){
					FachadaLogica.getInstance().altaConsultaProxMes();
					//}
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
		temporizador.schedule(tarea, 60*1000, 24*60*60*1000);

	    }  
}


