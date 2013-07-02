package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmDescGrafica;

public class CdorDescGrafica extends CdorManejoVentanas {

	private FrmDescGrafica ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmDescGrafica(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorDescGrafica() {
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

	public FrmDescGrafica getVentana() {
		return ventana;
	}

	public void setVentana(FrmDescGrafica ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
