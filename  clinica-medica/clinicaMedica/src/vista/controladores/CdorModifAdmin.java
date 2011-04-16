package vista.controladores;

import java.rmi.RemoteException;
import excepciones.PersistenciaException;
import vista.ventanas.FrmModifAdmin;

public class CdorModifAdmin extends CdorManejoVentanas {
	
	private FrmModifAdmin ventana;
	private CdorManejoVentanas vino;
	
	public CdorModifAdmin() {
		super();
	}
		
	public FrmModifAdmin getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmModifAdmin ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmModifAdmin(this);
	}

	public void habilitarVentana() {
		ventana.setFocusable(true);
		ventana.setEnabled(true);
		ventana.setFocusableWindowState(true);
	}
	
	public void deshabilitarVentana() {
		ventana.setFocusable(false);
		ventana.setEnabled(false);
	}
	
	public void cerrar() {
		ventana.dispose();
	}
	
	public void actionCerrar() {
		this.cerrarVentana(this, vino);
	}
	
	public void modifAdmin(String id, String nom, String cargo){
		try {
			super.getMod().modificarAdmin(id, nom, cargo);
			actionCerrar();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}