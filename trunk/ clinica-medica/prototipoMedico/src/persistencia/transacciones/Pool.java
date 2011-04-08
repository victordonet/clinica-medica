package persistencia.transacciones;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import logica.Configuracion;
import excepciones.PersistenciaException;


public class Pool {
	private static Pool poolTrn =null;
	private String url,usuario,pass, driver;
	private int cantMax,cantActu;
	private LinkedList <Connection> conexionesLibres;

		
	private Pool(Configuracion conf) throws Exception, IllegalAccessException, Throwable{
		// hay que leer de un archivo la configuracion
		//String url, String usuario, String pass, String driver,int cantMax
		super();
		this.url = conf.getValor("URL");
		this.usuario = conf.getValor("USUARIO");
		this.pass = conf.getValor("PASS");
		this.cantMax = Integer.parseInt(conf.getValor("MAX"));
		this.driver = conf.getValor("DRIVER");
		conexionesLibres = new LinkedList<Connection>();
		this.cantActu = 0;
		
		Class.forName(driver).newInstance();
	}

	public static Pool getInstance(Configuracion conf) throws PersistenciaException{
		if (poolTrn ==null){
			try {
				poolTrn = new Pool(conf);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new PersistenciaException("Sin acceso...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new PersistenciaException("Exception menos idea");
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new PersistenciaException("throwable ...");
			}
		}
		
		return poolTrn;
	}
	
	public synchronized Transaccion obtenerTrn(int nivel) throws  PersistenciaException {
		Transaccion trn = null;
		if(conexionesLibres.size()>0){
			try {
				trn = new Transaccion(conexionesLibres.getFirst(), nivel);
				conexionesLibres.removeFirst();
				
			} 
			catch (PersistenciaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			if (cantActu < cantMax) {
				
				try {
					Connection con = DriverManager.getConnection(url,usuario,pass);
					cantActu ++;
					trn = new Transaccion(con, nivel);
					
					} 
				catch (SQLException e){
					throw new PersistenciaException("Error de conexion");
				} 
				catch (PersistenciaException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new PersistenciaException("Error de mierda de concurrencia");
				}
			}
		}
		return trn;
	
	}
	
	public synchronized void liberarTrn(Transaccion trn)throws PersistenciaException{
		conexionesLibres.add(trn.getConexion());
		notify();
	}

}
