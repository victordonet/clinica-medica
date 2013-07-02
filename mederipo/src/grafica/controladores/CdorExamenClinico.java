package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmExamenClinico;

public class CdorExamenClinico extends CdorManejoVentanas {

	private FrmExamenClinico ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmExamenClinico(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorExamenClinico() {
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

	public FrmExamenClinico getVentana() {
		return ventana;
	}

	public void setVentana(FrmExamenClinico ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
