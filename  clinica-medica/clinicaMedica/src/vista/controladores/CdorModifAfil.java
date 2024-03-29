package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.dataobjet.DataAfiliado;
import vista.ventanas.FrmModifAfiliado;
import excepciones.PersistenciaException;

public class CdorModifAfil extends CdorManejoVentanas {
	
	private FrmModifAfiliado ventana;
	private CdorManejoVentanas vino;
	
	public CdorModifAfil() {
		super();
	}
		
	public FrmModifAfiliado getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmModifAfiliado ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmModifAfiliado(this);
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
	
	public DataAfiliado getDatos(){
		DataAfiliado datosAfi = null;
		try {
			datosAfi = super.getMod().getAfiliado(super.getId());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexi�n con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return datosAfi;
	}
	
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, boolean fonasa, String estado){
		try {
			super.getMod().modifAfil(idAfil, nom, apel, ci, mail, dir, tel, fonasa, estado);
			actionCerrar();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexi�n con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}