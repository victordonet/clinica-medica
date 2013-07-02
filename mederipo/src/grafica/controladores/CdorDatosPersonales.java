package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmDatosPersonales;

public class CdorDatosPersonales extends CdorManejoVentanas {

	private FrmDatosPersonales ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmDatosPersonales(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorDatosPersonales() {
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

	public FrmDatosPersonales getVentana() {
		return ventana;
	}

	public void setVentana(FrmDatosPersonales ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
