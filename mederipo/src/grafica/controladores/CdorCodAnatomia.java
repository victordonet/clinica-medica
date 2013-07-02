package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmCodAnatomia;

public class CdorCodAnatomia extends CdorManejoVentanas {

	private FrmCodAnatomia ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmCodAnatomia(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorCodAnatomia() {
		//super();
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

	public FrmCodAnatomia getVentana() {
		return ventana;
	}

	public void setVentana(FrmCodAnatomia ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
