package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import excepciones.PersistenciaException;
import vista.dataobjet.DataMed;
import vista.ventanas.FrmSelecMedico;

public class CdorSelectMed extends CdorManejoVentanas {
	
	private FrmSelecMedico ventana;
	private ModeloTablaListMed modelo = null;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
	private Vector<DataMed> vMed;

	public CdorSelectMed() {
		super();
	}
	
	public FrmSelecMedico getVentana() {
		return ventana;
	}

	public void setVentana(FrmSelecMedico ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmSelecMedico(this);
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
			vMed = super.getMod().listarMedicos();
			modelo = new ModeloTablaListMed(vMed);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return modelo;
	}
	
	public void actionAceptar() {
		this.cambioVentana(this, ventanaVoy);
	}
	
	public CdorManejoVentanas getVentanaVoy() {
		return ventanaVoy;
	}

	public void setVentanaVoy(CdorManejoVentanas ventanaVoy) {
		this.ventanaVoy = ventanaVoy;
	}

	public Vector<DataMed> getvMed() {
		return vMed;
	}

	public void setvMed(Vector<DataMed> vMed) {
		this.vMed = vMed;
	}
}
