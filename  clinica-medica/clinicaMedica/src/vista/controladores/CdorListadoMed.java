package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.ventanas.FrmListadoMedicos;
import excepciones.PersistenciaException;

public class CdorListadoMed extends CdorManejoVentanas {
	
	private FrmListadoMedicos ventana;
	private CdorManejoVentanas vino;

	public CdorListadoMed() {
		super();
	}
	
	public FrmListadoMedicos getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoMedicos ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmListadoMedicos(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
		}
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
	
	public ModeloTablaListMed listarMed(){
		ModeloTablaListMed modelo = null;
		try {
			modelo = new ModeloTablaListMed(super.getMod().listarMedicos());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
	
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		}
		return modelo;
	}
}
