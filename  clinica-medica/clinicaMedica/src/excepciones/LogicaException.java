package excepciones;

import java.io.Serializable;

public class LogicaException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;

	public LogicaException(String message) {
		super(message);
	}
}
