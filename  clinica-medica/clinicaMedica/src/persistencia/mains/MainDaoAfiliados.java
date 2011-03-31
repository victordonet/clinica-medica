package persistencia.mains;

import java.util.Calendar;

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
		Calendar fecha = Calendar.getInstance();
		fecha.set(2009, 11, 31);
		Afiliado afil = new Afiliado("1001", "1001", "A", "A", "Pedro", "Jimenez", "12354726", "pjimenez@hotmail.com", "Soca 1234", "27083223", fecha, true, null);
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
