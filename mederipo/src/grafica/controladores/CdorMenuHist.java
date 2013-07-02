package grafica.controladores;

import javax.swing.JOptionPane;
import grafica.vistas.FrmMenuHist;

public class CdorMenuHist extends CdorManejoVentanas {

	private FrmMenuHist ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenuHist(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}
	
	public CdorMenuHist() {
		//super();
	}
	
	public void actionAntecedentes(){	
		this.cambioVentana(this, new CdorAntecedentes());
	}
	
	public void actionHormonal(){	
		this.cambioVentana(this, new CdorHormonal());
	}
	
	public void actionHister(){
		this.cambioVentana(this, new CdorHisteroscopia()); 
	}
	
	public void actionParaclinica(){
		this.cambioVentana(this, new CdorParaclinica()); 
	}
	
	public void actionAnatomia(){
		this.cambioVentana(this, new CdorAnatomia()); 
	}
	
	public void actionIndHist(){
		this.cambioVentana(this, new CdorIndHist()); 
	}
	
	public void actionObs(){
		this.cambioVentana(this, new CdorObservaciones()); 
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

	public FrmMenuHist getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenuHist ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
