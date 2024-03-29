package vista.controladores;

import javax.swing.JOptionPane;

import vista.ventanas.FrmMantConsultorios;

public class CdorMantConsultorios extends CdorManejoVentanas {

	private FrmMantConsultorios ventana;
	private CdorManejoVentanas vino;

	public CdorMantConsultorios() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantConsultorios(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}

	public void actionAltaConsultorio(){	
		this.cambioVentana(this, new CdorAltaConsultorio());
	}
	
	public void actionBajaConsultorio(){
		this.cambioVentana(this, new CdorBajaConultorio());
	}

	public void habilitarVentana() {
		ventana.setEnabled(true);
		ventana.setFocusable(true);
		ventana.setFocusableWindowState(true);
	}

	public void cerrar() {
		ventana.dispose();
	}

	public void deshabilitarVentana() {
		ventana.setEnabled(false);
		ventana.setFocusable(false);
	}

	public FrmMantConsultorios getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantConsultorios ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
