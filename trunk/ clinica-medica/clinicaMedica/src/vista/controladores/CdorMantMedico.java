package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmMantMedicos;

public class CdorMantMedico extends CdorManejoVentanas {

	private FrmMantMedicos ventana;
	private IfachadaLogica mod;
	private CdorManejoVentanas vino;

	public CdorMantMedico() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantMedicos(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionAltaMed(){	
		this.cambioVentana(this, new CdorAltaMedico());
	}
	
	public void actionBajaMed(){
		this.cambioVentana(this, new CdorBajaMedico()); 
	}
	
	public void actionModifMed(){	
		this.cambioVentana(this, new CdorModifMedico());
	}
	
	public void actionModifConsultas(){	
		//this.cambioVentana(this, new CdorModifConsultas());
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

	public FrmMantMedicos getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantMedicos ventana) {
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
