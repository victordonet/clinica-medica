package persistencia.transacciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import excepciones.PersistenciaException;


public class Transaccion {
	
	private Connection conexion;
	
	public Transaccion (Connection conexion, int nivelTrn)throws PersistenciaException{
		this.conexion = conexion;
		try {
			this.conexion.setAutoCommit(false);
			this.conexion.setTransactionIsolation(nivelTrn);
		} catch (SQLException e) {
			 
			throw new PersistenciaException("Error fatal de conexion con la base de datos");
			
		}
			
	}
	
	public Connection getConexion() {
		return conexion;
	}

	public void finalizarTrn (boolean fin)throws PersistenciaException{
		try {
		if(fin){
			conexion.commit();
			System.out.println("hago el comit");
			} 
		else{
			conexion.rollback();
			System.out.println("hago el rollback");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PersistenciaException("No pudo realizar consulta");
		}
	}
	public PreparedStatement preparedStatement (String sql)throws PersistenciaException{
		
		
		try {
			return conexion.prepareStatement(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new PersistenciaException("No pudo obtener el prepared");
		}
		
	}

}
