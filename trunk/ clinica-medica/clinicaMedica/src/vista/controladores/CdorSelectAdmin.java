package vista.controladores;

import vista.ventanas.FrmSelecAdmin;

public class CdorSelectAdmin extends CdorManejoVentanas {
	
	private FrmSelecAdmin ventana;
	private ModeloTablaListAdmin modelo = null;
	private CdorManejoVentanas vino;

	public CdorSelectAdmin() {
		super();
	}
	
	public FrmSelecAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmSelecAdmin ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmSelecAdmin(this);
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
