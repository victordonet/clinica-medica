package vista.controladores;

import vista.ventanas.FrmMenuMed;

public class CdorMenuMed extends CdorManejoVentanas {

	private FrmMenuMed ventana;
	private CdorManejoVentanas vino;

	public CdorMenuMed() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenuMed(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionListadoConsutlas(){	
		//this.cambioVentana(this, new CdorListadoConsutlas());
	}
	
	public void actionModifPass(){	
		this.cambioVentana(this, new CdorModifPass());
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

	public FrmMenuMed getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenuMed ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
