package persistencia.mains;

import logica.fachada.IfachadaLogica;
import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataUsuario;

public class MainDaoUsuarios {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Usuarios:
		//Alta
		DataUsuario usuAdm = new DataUsuario("JLOPEZ","111","AD","A");
		fachada.altaUsuario(usuAdm);
		
		//Validacion	
		String clave = "JLOPEZ";
		String pass = "111";
		boolean resultado = fachada.validarUsuario(clave, pass);
		System.out.println("Restultado= "+resultado);
		
		//Modificacion Contraseña
		clave = "JLOPEZ";
		pass = "123";
		fachada.modifContrasena(clave, pass);
	}
}
