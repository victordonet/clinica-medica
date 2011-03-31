package persistencia.mains;

import logica.AdminGen;
import logica.Usuario;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoUsuarios {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Usuarios:
		//Alta
		Usuario usuAdm = new AdminGen("JLOPEZ","111","A","A","Jorge","1");
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
