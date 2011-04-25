package vista.controladores;

import javax.swing.JOptionPane;

import vista.ventanas.FrmMantAfiliados;

public class CdorMantAfil extends CdorManejoVentanas {

	private FrmMantAfiliados ventana;
	private CdorManejoVentanas vino;

	public CdorMantAfil() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantAfiliados(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}

	public void actionAltaAfil(){	
		this.cambioVentana(this, new CdorAltaAfil());
	}
	
	public void actionBajaAfil(){
		CdorSelectAfi cdorSelec = new CdorSelectAfi();
		cdorSelec.setVentanaVoy(new CdorBajaAfil());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionModifAfil(){
		CdorSelectAfi cdorSelec = new CdorSelectAfi();
		cdorSelec.setVentanaVoy(new CdorModifAfil());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionModifPass(){
		CdorSelectAfi cdorSelec = new CdorSelectAfi();
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

	public FrmMantAfiliados getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantAfiliados ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
