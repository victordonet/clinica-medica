package vista.controladores;

import javax.swing.JOptionPane;

import vista.ventanas.FrmMantEspecialidades;

public class CdorMantEsp extends CdorManejoVentanas {

	private FrmMantEspecialidades ventana;
	private CdorManejoVentanas vino;

	public CdorMantEsp() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantEspecialidades(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}

	public void actionListarEsp (){
		this.cambioVentana(this, new CdorListadoEsp()); 
	}
	
	public void actionAltaEsp(){
		this.cambioVentana(this, new CdorAltaEsp());
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

	public FrmMantEspecialidades getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantEspecialidades ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
