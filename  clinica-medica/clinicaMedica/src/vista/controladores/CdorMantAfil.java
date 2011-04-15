package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmMantAfiliados;

public class CdorMantAfil extends CdorManejoVentanas {

	private FrmMantAfiliados ventana;
	private IfachadaLogica mod;
	private CdorManejoVentanas vino;

	public CdorMantAfil() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantAfiliados(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionAltaAfil(){	
		this.cambioVentana(this, new CdorAltaAfil());
	}
	
	public void actionBajaAfil(){
		this.cambioVentana(this, new CdorBajaAfil()); 
	}
	
	public void actionModifAfil(){	
		this.cambioVentana(this, new CdorModifAfil());
	}
	
	public void actionModifPass(){	
		this.cambioVentana(this, new CdorModifPass());
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

	public FrmMantAfiliados getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantAfiliados ventana) {
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
