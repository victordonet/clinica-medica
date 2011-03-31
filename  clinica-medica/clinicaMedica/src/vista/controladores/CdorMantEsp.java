package vista.controladores;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmListadoEspecialidades;
import vista.ventanas.FrmMantEspecialidades;

public class CdorMantEsp extends CdorManejoVentanas {

	private FrmMantEspecialidades ventana;
	private IfachadaLogica mod;
	private CdorManejoVentanas vino;

	public CdorMantEsp() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantEspecialidades(this);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionListarEsp (){

		this.cambioVentana(this, new CdorListadoEsp()); 

	}	
	public void actionAltaEsp(){
		
		this.cambioVentana(this, new CdorAltaEsp());
	}
	
	public void habilitarVentana() {
		ventana.setEnabled(true);
		ventana.setFocusable(true);
		ventana.setFocusableWindowState(true);

	}

	
	
	

	@Override
	public void cerrar() {
		ventana.dispose();

	}

	public void deshabilitarVentana() {
		ventana.setEnabled(false);
		ventana.setFocusable(false);

	}

	public FrmMantEspecialidades getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantEspecialidades ventana) {
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
