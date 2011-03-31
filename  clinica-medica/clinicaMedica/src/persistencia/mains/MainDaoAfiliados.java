package persistencia.mains;

import logica.AdminGen;
import logica.Afiliado;
import logica.Usuario;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoAfiliados {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Afiliados:
		//Alta
		Afiliado afil = new Afiliado("1001", "1001", "A", "A", "Pedro", "Jimenez", "12354726", "pjimenez@hotmail.com", "Soca 1234", "27083223", "07/03/2008", true, null);
		fachada.altaAfiliado(afil);
		//Validacion	
		String clave = "1";
		String pass = "111";
		boolean resultado = fachada.validarUsuario(clave, pass);
		System.out.println("Restultado= "+resultado);
		//Modificacion Contraseña
		clave = "1";
		pass = "123";
		fachada.modifContrasena(clave, pass);
	}
}
