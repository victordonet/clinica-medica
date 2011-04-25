package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import vista.dataobjet.DataExamen;
import vista.ventanas.FrmResultadoExamen;
import excepciones.PersistenciaException;

public class CdorResultadoExamen extends CdorManejoVentanas {
	
	private FrmResultadoExamen ventana;
	private CdorManejoVentanas vino;
	private DataExamen dataEx;
	
	public CdorResultadoExamen() {
		super();
	}
		
	public FrmResultadoExamen getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmResultadoExamen ventana) {
		this.ventana = ventana;
	}
	
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmResultadoExamen(this);
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

	public DataExamen getDataEx() {
		return dataEx;
	}

	public void setDataEx(DataExamen dataEx) {
		this.dataEx = dataEx;
	}
	
	public void altaResultado(Calendar fechaResultado){
		try {
			super.getMod().modifEx(super.getId(), dataEx.getFechaInicio(), dataEx.getTex().getId(), fechaResultado);
			JOptionPane.showMessageDialog(null,"Alta ok");
			actionCerrar();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}