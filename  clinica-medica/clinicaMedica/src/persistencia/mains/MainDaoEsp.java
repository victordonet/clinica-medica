package persistencia.mains;

import java.util.Vector;

import javax.swing.JOptionPane;
import vista.dataobjet.DataEsp;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoEsp {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Alta
		DataEsp datEsp = new DataEsp(5, "Oftalmologia", 170);
		DataEsp datEsp1 = new DataEsp(4, "Traumatoogia", 200);
		DataEsp datEsp2 = new DataEsp(1, "Medicina General", 300);
		
		fachada.altaEspecialidad(datEsp);
		fachada.altaEspecialidad(datEsp1);
		fachada.altaEspecialidad(datEsp2);
		
		
		//Listar
		Vector<DataEsp> vEsp = fachada.listarEspecialidades();
		for (int i = 0; i < vEsp.size(); i++) {
			DataEsp es = vEsp.get(i);
			JOptionPane.showMessageDialog(null,"listando : " + es.getDescripcion());
		}

		//Obtener
		DataEsp es = fachada.obtenerEspecialidad(5);
	
	}
}
