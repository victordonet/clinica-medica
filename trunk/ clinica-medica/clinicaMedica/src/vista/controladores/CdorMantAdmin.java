package vista.controladores;

import vista.ventanas.FrmMantAdmin;

public class CdorMantAdmin extends CdorManejoVentanas {

	private FrmMantAdmin ventana;
	private CdorManejoVentanas vino;

	public CdorMantAdmin() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantAdmin(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionAltaAdmin(){	
		this.cambioVentana(this, new CdorAltaAdmin());
	}
	
	public void actionBajaAdmin(){
		this.cambioVentana(this, new CdorListadoAdmin()); 
	}
	
	public void actionModifAdmin(){	
		this.cambioVentana(this, new CdorListadoAdmin());
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

	public FrmMantAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantAdmin ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
