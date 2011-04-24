package vista.controladores;

import java.rmi.RemoteException;

import vista.dataobjet.DataConsultorio;
import vista.ventanas.FrmAltaConsultorio;
import excepciones.PersistenciaException;

public class CdorAltaConsultorio extends CdorManejoVentanas {
	
	private FrmAltaConsultorio ventana;
	private CdorManejoVentanas vino;

	public CdorAltaConsultorio (){
		super();
	}
	
	public FrmAltaConsultorio getVentana() {
		return ventana;
	}

	public void setVentana(FrmAltaConsultorio ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaConsultorio(this);
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
		cerrarVentana(this, vino);
	}
	
	public void altaConsultorio (String id, String nombre){
		int idConsultorio = Integer.parseInt(id);
		DataConsultorio dc = new DataConsultorio(idConsultorio, nombre);
		actionCerrar();
		try {
			super.getMod().altaConsultorio(dc);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}
