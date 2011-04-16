
package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataEsp;
import vista.ventanas.FrmListadoEspecialidades;

public class CdorListadoEsp extends CdorManejoVentanas{

	private FrmListadoEspecialidades ventana;
	private ModeloTablaListEsp modelo = null;
	private CdorManejoVentanas vino;

	public CdorListadoEsp(){
		super();
	}
	
	public void desplegarVentana (CdorManejoVentanas vino){
			this.vino = vino;
		try {
			modelo = listarEspecialidades();
			ventana = new FrmListadoEspecialidades(modelo,this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public FrmListadoEspecialidades getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoEspecialidades ventana) {
		this.ventana = ventana;
	}

	public ModeloTablaListEsp listarEspecialidades (){

		ModeloTablaListEsp modelo =null;
		try {
			Vector<DataEsp> vec = super.getMod().listarEspecialidades();
			System.out.println(vec.toString());
			modelo = new ModeloTablaListEsp(vec);
			System.out.println(modelo.toString());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return modelo;

	}
	public void cerrar() {
		ventana.getVentana().dispose();

	}
	public void habilitarVentana(){
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);
	}

	public void actionCerrar(){
		this.cerrarVentana(this, vino);
	}
}
