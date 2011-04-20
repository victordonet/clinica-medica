package vista.controladores;

import java.rmi.RemoteException;
import excepciones.PersistenciaException;
import vista.ventanas.FrmListadoMedicos;

public class CdorListadoMed extends CdorManejoVentanas {
	
	private FrmListadoMedicos ventana;
	private CdorManejoVentanas vino;

	public CdorListadoMed() {
		super();
	}
	
	public FrmListadoMedicos getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoMedicos ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmListadoMedicos(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void habilitarVentana() {
		ventana.setFocusable(true);
		ventana.setEnabled(true);
		ventana.setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.setFocusable(false);
		ventana.setEnabled(false);
	}

	public void cerrar() {
		ventana.dispose();
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
	
	public ModeloTablaListMed listarMed(){
		ModeloTablaListMed modelo = null;
		try {
			modelo = new ModeloTablaListMed(super.getMod().listarMedicos());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return modelo;
	}
}
