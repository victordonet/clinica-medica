package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.ventanas.FrmMenuAfil;
import excepciones.PersistenciaException;

public class CdorMenuAfil extends CdorManejoVentanas {

	private FrmMenuAfil ventana;
	private CdorManejoVentanas vino;

	public CdorMenuAfil() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenuAfil(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}

	public void actionListadoConsutlas(){
		try {
			CdorListadoDetalleAfiliado cdor = new CdorListadoDetalleAfiliado();
			cdor.setdAfil(super.getMod().getAfiliado(super.getUsu().getIdUsu()));
			this.cambioVentana(this, cdor);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexi�n con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
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
		System.exit(0);
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
