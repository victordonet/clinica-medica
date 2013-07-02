package grafica.controladores;

import javax.swing.JOptionPane;
import GUI.GUI_Principal;

public class CdorGUI_Principal extends CdorManejoVentanas {

	private GUI_Principal ventana;
	private CdorManejoVentanas vino;
	private String nomImagen;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new GUI_Principal(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorGUI_Principal() {
		//super();
	}
	
	public String getNomImagen() {
		return nomImagen;
	}

	public void setNomImagen(String nomImagen) {
		this.nomImagen = nomImagen;
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
		vino.habilitarVentana();
	}

	public void deshabilitarVentana() {
		ventana.frmDisable();
	}

	public GUI_Principal getVentana() {
		return ventana;
	}

	public void setVentana(GUI_Principal ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
