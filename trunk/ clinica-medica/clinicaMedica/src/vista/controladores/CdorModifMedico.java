package vista.controladores;

import java.rmi.RemoteException;
import excepciones.PersistenciaException;
import vista.dataobjet.DataEsp;
import vista.ventanas.FrmModifMedico;

public class CdorModifMedico extends CdorManejoVentanas {
	
	private FrmModifMedico ventana;
	private CdorManejoVentanas vino;
	
	public CdorModifMedico() {
		super();
	}
		
	public FrmModifMedico getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmModifMedico ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmModifMedico(this);
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
	
	public void modifMedico(String id, String nom, String apell, String ci, String tel, String idEsp){
		try {
			DataEsp esp = super.getMod().obtenerEspecialidad(Integer.parseInt(idEsp));
			super.getMod().modifMedico(id, nom, apell, ci, tel, esp);
			actionCerrar();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}