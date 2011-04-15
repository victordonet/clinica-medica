package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmMantConsultorios;

public class CdorMantConsultorios extends CdorManejoVentanas {

	private FrmMantConsultorios ventana;
	private IfachadaLogica mod;
	private CdorManejoVentanas vino;

	public CdorMantConsultorios() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantConsultorios(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionAltaConsultorio(){	
		this.cambioVentana(this, new CdorAltaAfil());
	}
	
	public void actionBajaConsultorio(){
		this.cambioVentana(this, new CdorBajaAfil()); 
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
