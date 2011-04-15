package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmMenuAfil;

public class CdorMenuAfil extends CdorManejoVentanas {

	private FrmMenuAfil ventana;
	private IfachadaLogica mod;
	private CdorManejoVentanas vino;

	public CdorMenuAfil() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenuAfil(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionListadoConsutlas(){	
		//this.cambioVentana(this, new CdorListadoConsutlas());
	}
	
	public void actionReservaTurno(){
		//this.cambioVentana(this, new CdorReservaTurno()); 
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

	public FrmMenuAfil getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenuAfil ventana) {
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
