package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.dataobjet.DataMed;
import vista.ventanas.FrmBajaMedico;
import excepciones.PersistenciaException;

public class CdorBajaMedico extends CdorManejoVentanas {
	
	private FrmBajaMedico ventana;
	private CdorManejoVentanas vino;
	
	public CdorBajaMedico() {
		super();
	}
		
	public FrmBajaMedico getVentana() {
		return ventana;
	}

	public void setVentana(FrmBajaMedico ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmBajaMedico(this);
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

	public DataMed getDatos(){
		DataMed datosMed = null;
		try {
			datosMed = super.getMod().getDataMed(super.getId());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());

		}
		return datosMed;
	}
	
	public String getDescEsp(){
		String descEsp = null;
		try {
			descEsp = super.getMod().obtenerEspecialidad(this.getDatos().getEsp()).getDescripcion();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());

		}
		return descEsp;
	}

	public void bajaMedico(String id){
		try {
			super.getMod().bajarMedico(id);
			actionCerrar();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());

		}
	}
	
	
}