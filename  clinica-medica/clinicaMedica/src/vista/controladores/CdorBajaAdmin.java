package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataAdmin;
import vista.ventanas.FrmBajaAdmin;

public class CdorBajaAdmin extends CdorManejoVentanas {
	
	private FrmBajaAdmin ventana;
	private CdorManejoVentanas vino;
	
	public CdorBajaAdmin() {
		super();
	}
		
	public FrmBajaAdmin getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmBajaAdmin ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmBajaAdmin(this);
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
	
	public String getDescCargo(){
		Vector<String> vecCargos = new Vector<String>();
		vecCargos.add("Gerente");
		vecCargos.add("Administrador");
		vecCargos.add("Cajero");
		String descripcion = vecCargos.get(getDatos().getCargo()-1);
		return descripcion;
	}
	
	public void bajaAdmin(String id){
		try {
			super.getMod().bajaAdmin(id);
			actionCerrar();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
	}
}