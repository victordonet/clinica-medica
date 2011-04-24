package logica.server;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import logica.fachada.FachadaLogica;
import excepciones.LogicaException;
import excepciones.PersistenciaException;


public class MainGeneracionConsultas {

//	  private org.quartz.Scheduler scheduler;
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
		
		
		//Otra opcion
//		public void start() throws org.quartz.SchedulerException {  
//	        try {  
//	            // Definimos la tarea (nombre de la tarea, nombre del grupo de tareas, Clase que implementa la tarea)  
//	            
//	        	JobDetail jobDetail = (JobDetail) new Tarea();  
//	      
//	           
//	            // Configuramos el Trigger que avisará al planificador de cuando debe ejecutar la tarea, en este caso cada 5 segundos.  
//	            org.quartz.CronTrigger trigger   =  CronTrigger.("StatusTrigger", org.quartz.Scheduler.DEFAULT_GROUP, "0/5 0 0 * * * ?");  
//	              
//	            // Obtenemos el planificador  
//	            scheduler = org.quartz.impl.StdSchedulerFactory.getDefaultScheduler();  
//	              
//	            // La tarea definida en JobDetail será ejecutada en los instantes especificados por el Trigger.  
//	            scheduler.scheduleJob(jobDetail, trigger);  
//	              
//	            // Iniciamos las tareas planificadas en el Sheduler  
//	            scheduler.start();  
//	        } catch (java.text.ParseException e) {  
//	            // No se dará  S
//	        }  
	    }  
}


