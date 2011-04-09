package persistencia.mains;

import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataEsp;
import logica.Especialidad;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoEsp {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Alta
		DataEsp datEsp = new DataEsp(2, "Traumatologia", 250);
		fachada.altaEspecialidad(datEsp);
		JOptionPane.showMessageDialog(null,"alta esp ");
		//Listar
		Vector<DataEsp> vEsp = fachada.listarEspecialidades();
		for (int i = 0; i < vEsp.size(); i++) {
			DataEsp es = vEsp.get(i);
			JOptionPane.showMessageDialog(null,"listando : " + es.getDescripcion());
		}

		//Obtener
		DataEsp es = fachada.obtenerEspecialidad(2);
		JOptionPane.showMessageDialog(null,"Obtener : "+es.getDescripcion());
	}
}
