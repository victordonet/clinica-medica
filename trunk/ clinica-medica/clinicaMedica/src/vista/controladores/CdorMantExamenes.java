package vista.controladores;

import vista.ventanas.FrmMantExamenes;

public class CdorMantExamenes extends CdorManejoVentanas {

	private FrmMantExamenes ventana;
	private CdorManejoVentanas vino;

	public CdorMantExamenes() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantExamenes(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionRegistro(){
		CdorSelectAfi cdorSelec = new CdorSelectAfi();
		cdorSelec.setVentanaVoy(new CdorRegistroExamen());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionResultado(){
		CdorSelectAfi cdorSelec = new CdorSelectAfi();
		cdorSelec.setVentanaVoy(new CdorResultadoExamen());
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

	public FrmMantExamenes getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantExamenes ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
