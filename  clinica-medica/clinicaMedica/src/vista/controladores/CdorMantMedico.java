package vista.controladores;

import vista.ventanas.FrmMantMedicos;

public class CdorMantMedico extends CdorManejoVentanas {

	private FrmMantMedicos ventana;
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
		CdorSelectMed cdorSelec = new CdorSelectMed();
		cdorSelec.setVentanaVoy(new CdorBajaMedico());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionModifMed(){
		CdorSelectMed cdorSelec = new CdorSelectMed();
		cdorSelec.setVentanaVoy(new CdorModifMedico());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionDisponibilidad(){
		CdorSelectMed cdorSelec = new CdorSelectMed();
		cdorSelec.setVentanaVoy(new CdorMantDisp());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionModifPass(){	
		CdorSelectMed cdorSelec = new CdorSelectMed();
		cdorSelec.setVentanaVoy(new CdorModifPass());
		this.cambioVentana(this, cdorSelec);
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

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
