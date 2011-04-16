package vista.controladores;

import vista.ventanas.FrmListadoAdmin;

public class CdorListadoAdmin extends CdorManejoVentanas {
	
	private FrmListadoAdmin ventana;
	private ModeloTablaListAdmin modelo = null;
	private CdorManejoVentanas vino;

	public CdorListadoAdmin() {
		super();
	}
	
	public FrmListadoAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoAdmin ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmListadoAdmin(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void habilitarVentana() {
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);
	}

	public void cerrar() {
		ventana.getVentana().dispose();
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
	
	public ModeloTablaListAdmin listarAdmin (){
		ModeloTablaListAdmin modelo = new ModeloTablaListAdmin(super.getMod());
		return modelo;
	}
}
