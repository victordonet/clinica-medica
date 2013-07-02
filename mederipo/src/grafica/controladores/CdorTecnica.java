package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmTecnica;

public class CdorTecnica extends CdorManejoVentanas {

	private FrmTecnica ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmTecnica(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorTecnica() {
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

	public FrmTecnica getVentana() {
		return ventana;
	}

	public void setVentana(FrmTecnica ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
