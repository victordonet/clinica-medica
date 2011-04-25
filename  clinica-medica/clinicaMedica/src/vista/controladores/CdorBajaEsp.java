package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.ventanas.FrmBajaEspecialidades;
import excepciones.PersistenciaException;

public class CdorBajaEsp extends CdorManejoVentanas {
	
	private FrmBajaEspecialidades ventana;
	private CdorManejoVentanas vino;
	
	public CdorBajaEsp() {
		super();
	}
		
	public FrmBajaEspecialidades getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmBajaEspecialidades ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmBajaEspecialidades(this);
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
	
	public void bajaEsp(String id){
		try {
			int idEsp = Integer.parseInt(id);
			super.getMod().bajaEspecialidad(idEsp);
			actionCerrar();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());

		}
	}
}