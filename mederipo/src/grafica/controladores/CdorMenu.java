package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmMenu;

public class CdorMenu extends CdorManejoVentanas {

	private FrmMenu ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenu(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorMenu() {
		//super();
	}

	public void actionDatos(){	
		this.cambioVentana(this, new CdorDatosPersonales());
	}
	
	public void actionHistoria(){	
		this.cambioVentana(this, new CdorMenuHist());
	}

	public void actionInforme(){	
		this.cambioVentana(this, new CdorMenuInfo());
	}
	
	public void habilitarVentana() {
		ventana.frmEnable();
	}

	public void cerrar() {
		ventana.dispose();
		System.exit(0);
	}

	public void deshabilitarVentana() {
		ventana.frmDisable();
	}

	public FrmMenu getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenu ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
