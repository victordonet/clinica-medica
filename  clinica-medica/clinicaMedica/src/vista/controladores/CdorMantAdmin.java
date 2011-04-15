package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmMantAdmin;

public class CdorMantAdmin extends CdorManejoVentanas {

	private FrmMantAdmin ventana;
	private IfachadaLogica mod;
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
		this.cambioVentana(this, new CdorBajaAdmin()); 
	}
	
	public void actionModifAdmin(){	
		this.cambioVentana(this, new CdorModifAdmin());
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

	public IfachadaLogica getMod() {
		return mod;
	}

	public void setMod(IfachadaLogica modelo) {
		this.mod = modelo;
	}

	public void actionCerrar() {
		cerrar();
	}





}
