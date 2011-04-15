package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmMantExamenes;

public class CdorMantExamenes extends CdorManejoVentanas {

	private FrmMantExamenes ventana;
	private IfachadaLogica mod;
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
		//this.cambioVentana(this, new CdorRegistroExam());
	}
	
	public void actionResultado(){
		//this.cambioVentana(this, new CdorResultadoExam()); 
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
