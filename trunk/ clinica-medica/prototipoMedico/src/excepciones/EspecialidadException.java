package excepciones;

import java.io.Serializable;

public class EspecialidadException extends Exception implements Serializable {

	public EspecialidadException(String message) {
		super(message);
	}
}
