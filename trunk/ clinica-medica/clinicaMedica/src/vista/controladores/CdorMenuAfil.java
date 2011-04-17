package vista.controladores;

import java.rmi.RemoteException;

import excepciones.PersistenciaException;
import vista.ventanas.FrmMenuAfil;

public class CdorMenuAfil extends CdorManejoVentanas {

	private FrmMenuAfil ventana;
	private CdorManejoVentanas vino;

	public CdorMenuAfil() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenuAfil(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionListadoConsutlas(){
		try {
			CdorListadoDetalleAfiliado cdor = new CdorListadoDetalleAfiliado();
			cdor.setdAfil(super.getMod().getAfiliado(super.getUsu().getIdUsu()));
			this.cambioVentana(this, cdor);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
	
	public void actionReservaTurno(){
		this.cambioVentana(this, new CdorReservaTurno()); 
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

	public FrmMenuAfil getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenuAfil ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
