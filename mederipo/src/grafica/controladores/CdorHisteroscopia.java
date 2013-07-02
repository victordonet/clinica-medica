package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmHisteroscopia;

public class CdorHisteroscopia extends CdorManejoVentanas {

	private FrmHisteroscopia ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmHisteroscopia(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorHisteroscopia() {
		//super();
	}
	
	public void actionCodigos(){	
		this.cambioVentana(this, new CdorCodAnatomia());
	}
	
	public void habilitarVentana() {
		ventana.frmEnable();
	}

	public void cerrar() {
		ventana.dispose();
		vino.habilitarVentana();
	}

	public void deshabilitarVentana() {
		ventana.frmDisable();
	}

	public FrmHisteroscopia getVentana() {
		return ventana;
	}

	public void setVentana(FrmHisteroscopia ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
