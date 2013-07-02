package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmMenuInfo;

public class CdorMenuInfo extends CdorManejoVentanas {

	private FrmMenuInfo ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenuInfo(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorMenuInfo() {
		//super();
	}
	
	public void actionExamen(){
		this.cambioVentana(this, new CdorExamenClinico());
	}
	
	public void actionTecnica(){
		this.cambioVentana(this, new CdorTecnica());
	}

	public void actionHallazgos(){
		this.cambioVentana(this, new CdorHallazgos());
	}
	
	public void actionImgUtero(){
		CdorGUI_Principal cdor = new CdorGUI_Principal();
		cdor.setNomImagen("utero.jpg");
		this.cambioVentana(this, cdor);
	}

	public void actionImgOvarios(){
		CdorGUI_Principal cdor = new CdorGUI_Principal();
		cdor.setNomImagen("ovarios.jpg");
		this.cambioVentana(this, cdor);
	}
	
	public void actionImgX(){
		CdorGUI_Principal cdor = new CdorGUI_Principal();
		cdor.setNomImagen("imagenX.jpg");
		this.cambioVentana(this, cdor);
	}

	public void actionImgY(){
		CdorGUI_Principal cdor = new CdorGUI_Principal();
		cdor.setNomImagen("imagenY.jpg");
		this.cambioVentana(this, cdor);
	}
	
	public void actionDesc(){
		this.cambioVentana(this, new CdorDescGrafica());
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

	public FrmMenuInfo getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenuInfo ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
