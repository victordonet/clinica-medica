
package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataEsp;
import vista.ventanas.FrmListadoEspecialidades;
import excepciones.PersistenciaException;

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
			ventana = new FrmListadoEspecialidades(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");	
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
			modelo = new ModeloTablaListEsp(vec);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());		
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
		cerrarVentana(this, vino);
	}
}
