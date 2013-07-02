package grafica.controladores;

 import javax.swing.JOptionPane;
import grafica.vistas.FrmHormonal;

public class CdorHormonal extends CdorManejoVentanas {

	private FrmHormonal ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmHormonal(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorHormonal() {
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

	public FrmHormonal getVentana() {
		return ventana;
	}

	public void setVentana(FrmHormonal ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
