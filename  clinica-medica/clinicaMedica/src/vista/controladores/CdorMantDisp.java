package vista.controladores;



import vista.ventanas.FrmMantenerDisp;

public class CdorMantDisp extends CdorManejoVentanas {

	private FrmMantenerDisp ventana;
	//private ModeloTablaListEsp modelo = null;
	private CdorManejoVentanas vino;

	@Override
	public void desplegarVentana(CdorManejoVentanas vino) {
		    this.vino = vino;
			try {
				ventana = new FrmMantenerDisp(this);
			} catch (Throwable e) {
				e.printStackTrace();
			}
				
	}
	public void cerrar() {
		ventana.getVentana().dispose();

	}
	public void habilitarVentana(){
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);
	}

	public void actionCerrar(){
		cerrarVentana(this, vino);
	}

}
