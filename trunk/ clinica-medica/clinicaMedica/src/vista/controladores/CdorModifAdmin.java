package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import vista.dataobjet.DataAdmin;
import vista.ventanas.FrmModifAdmin;
import excepciones.PersistenciaException;

public class CdorModifAdmin extends CdorManejoVentanas {
	
	private FrmModifAdmin ventana;
	private CdorManejoVentanas vino;
	private Vector<String> vCargos;
	
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
		cerrarVentana(this, vino);
	}
	
	public DataAdmin getDatos(){
		DataAdmin datosAdm = null;
		try {
			datosAdm = super.getMod().getAdmin(super.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return datosAdm;
	}
	
	public void modifAdmin(String id, String nom, int selCargo, String estado){
		try {
			selCargo = selCargo+1;
			String cargo = String.valueOf(selCargo);
			super.getMod().modificarAdmin(id, nom, cargo, estado);
			actionCerrar();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
	
	public DefaultComboBoxModel cargarBox(){
		vCargos = new Vector<String>();
		vCargos.add("Gerente");
		vCargos.add("Administrador");
		vCargos.add("Cajero");
		DefaultComboBoxModel boxMod = new DefaultComboBoxModel();
		for (int i = 0; i < vCargos.size(); i++) {
			boxMod.addElement(vCargos.get(i));
		}
		return boxMod;
	}
}