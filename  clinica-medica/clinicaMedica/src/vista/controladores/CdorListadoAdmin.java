package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import excepciones.PersistenciaException;
import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataAdmin;
import vista.ventanas.FrmListadoAdmin;

public class CdorListadoAdmin extends CdorManejoVentanas {
	
	private FrmListadoAdmin ventana;
	private ModeloTablaListAdmin modelo = null;
	private CdorManejoVentanas vino;

	public CdorListadoAdmin() {
		super();
	}
	
	public FrmListadoAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoAdmin ventana) {
		this.ventana = ventana;
	}





	@Override
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			
			ventana = new FrmListadoAdmin(this);
		
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@Override
	public void habilitarVentana() {
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	@Override
	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);

	}

	@Override
	public void cerrar() {
		ventana.getVentana().dispose();

	}

	@Override
	public void actionCerrar() {
		this.cerrarVentana(this, vino);

	}
	public ModeloTablaListAdmin listarAdmin (){

		ModeloTablaListAdmin modelo = new ModeloTablaListAdmin(super.getMod());
		return modelo;

	}

}
