package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmAntecedentes;

public class CdorAntecedentes extends CdorManejoVentanas {

	private FrmAntecedentes ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmAntecedentes(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorAntecedentes() {
		//super();
	}
	
	public void actionCodigos(){	
		this.cambioVentana(this, new CdorCodAnatomia());
	}
	
	public void habilitarVentana() {
		ventana.frmEnable();
	}

	public void cerrar() {
		ventana.dispose();
		vino.habilitarVentana();
	}

	public void deshabilitarVentana() {
		ventana.frmDisable();
	}

	public FrmAntecedentes getVentana() {
		return ventana;
	}

	public void setVentana(FrmAntecedentes ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
