package excepciones;

import java.io.Serializable;


public class PersistenciaException extends Exception implements Serializable{

	public PersistenciaException(String message) {
		super(message);
	
	}
	
	
}
