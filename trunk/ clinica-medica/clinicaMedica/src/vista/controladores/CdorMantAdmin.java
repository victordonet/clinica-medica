package vista.controladores;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
		}
	}

	public void actionAltaAdmin(){	
		this.cambioVentana(this, new CdorAltaAdmin());
	}
	
	public void actionBajaAdmin(){
		CdorSelectAdmin cdorSelec = new CdorSelectAdmin();
		cdorSelec.setVentanaVoy(new CdorBajaAdmin());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionModifAdmin(){	
		CdorSelectAdmin cdorSelec = new CdorSelectAdmin();
		cdorSelec.setVentanaVoy(new CdorModifAdmin());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionModifPass(){
		CdorSelectAdmin cdorSelec = new CdorSelectAdmin();
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

	public FrmMantAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantAdmin ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
