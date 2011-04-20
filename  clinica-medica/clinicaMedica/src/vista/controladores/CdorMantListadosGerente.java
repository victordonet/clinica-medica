package vista.controladores;

import vista.ventanas.FrmMantListadosGerente;

public class CdorMantListadosGerente extends CdorManejoVentanas {

	private FrmMantListadosGerente ventana;
	private CdorManejoVentanas vino;

	public CdorMantListadosGerente() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantListadosGerente(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionListarAfil(){	
		//this.cambioVentana(this, new CdorListarAfil());
	}
	
	public void actionListarMed(){
		//this.cambioVentana(this, new CdorListarMed()); 
	}
	
	public void actionDetalleAfil(){	
		//this.cambioVentana(this, new CdorDetalleAfil());
	}
	
	public void actionListarConsultas(){	
		this.cambioVentana(this, new CdorFiltroListFecha());
	}
	
	public void actionLiqSalarios(){
		//this.cambioVentana(this, new CdorLiqSalarios()); 
	}
	
	public void actionMedPremiado(){	
		//this.cambioVentana(this, new CdorMedPremiado());
	}
	
	public void actionResumentCont(){	
		//this.cambioVentana(this, new CdorResumentCont());
	}
	
	public void habilitarVentana() {
		ventana.setEnabled(true);
		ventana.setFocusable(true);
		ventana.setFocusableWindowState(true);
	}

	public void cerrar() {
		ventana.dispose();
	}

	public void deshabilitarVentana() {
		ventana.setEnabled(false);
		ventana.setFocusable(false);
	}

	public FrmMantListadosGerente getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantListadosGerente ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
