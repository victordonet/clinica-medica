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

		
	private Pool(Configuracion conf) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		
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
				} catch (InstantiationException e) {
					throw new PersistenciaException("Error al instanciar el Driver de acceso: Pool de conexiones");
				} catch (IllegalAccessException e) {
					throw new PersistenciaException("Error de acceso a el Driver: Pool de conexiones");
				} catch (ClassNotFoundException e) {
					throw new PersistenciaException("No se encuentra Driver de acceso: Pool de conexiones");
				}
			
		}
		
		return poolTrn;
	}
	
	public synchronized Transaccion obtenerTrn(int nivel) throws  PersistenciaException {
		Transaccion trn = null;
		if(conexionesLibres.size()>0){
			trn = new Transaccion(conexionesLibres.getFirst(), nivel);
			conexionesLibres.removeFirst();
		}
		else {
			if (cantActu < cantMax) {
				try {
					Connection con = DriverManager.getConnection(url,usuario,pass);
					cantActu ++;
					trn = new Transaccion(con, nivel);
					} 
				catch (SQLException e){
					throw new PersistenciaException("Error de conexion en la base de datos: Pool de conexiones");
				} 
			
			}
			else{
				try {
					wait();
				} catch (InterruptedException e) {
					throw new PersistenciaException("Error de concurrencia:  Pool de conexiones");
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
