package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmMantListadosAdmin;

public class CdorMantListadosAdmin extends CdorManejoVentanas {

	private FrmMantListadosAdmin ventana;
	private IfachadaLogica mod;
	private CdorManejoVentanas vino;

	public CdorMantListadosAdmin() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantListadosAdmin(this);
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
		//this.cambioVentana(this, new CdorModifConsultas());
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

	public FrmMantListadosAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantListadosAdmin ventana) {
		this.ventana = ventana;
	}

	public IfachadaLogica getMod() {
		return mod;
	}

	public void setMod(IfachadaLogica modelo) {
		this.mod = modelo;
	}

	public void actionCerrar() {
		cerrar();
	}
}
