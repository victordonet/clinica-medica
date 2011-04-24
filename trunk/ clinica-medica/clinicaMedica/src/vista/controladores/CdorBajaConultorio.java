package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import vista.dataobjet.DataConsultorio;
import vista.ventanas.FrmBajaConsultorio;
import excepciones.PersistenciaException;

public class CdorBajaConultorio extends CdorManejoVentanas {
	
	private FrmBajaConsultorio ventana;
	private CdorManejoVentanas vino;
	private Vector<DataConsultorio> vCons = null;
	
	public CdorBajaConultorio() {
		super();
	}
		
	public FrmBajaConsultorio getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmBajaConsultorio ventana) {
		this.ventana = ventana;
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
	
	public DefaultComboBoxModel cargarBox(){
		DefaultComboBoxModel boxMod = new DefaultComboBoxModel();
		try {
			vCons = super.getMod().listarConsultorios();
			for (DataConsultorio vConsecialidad : vCons){
				boxMod.addElement(vConsecialidad.getIdConsultorio());
			}
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
		return boxMod;
	}
	
	public String getNombre(int indexBox){
		return vCons.get(indexBox).getNombre();
	}
	
	public void bajaConsultorio(int indexBox){
		try {
			int id = vCons.get(indexBox).getIdConsultorio();
			super.getMod().bajaConsultorio(id);
			actionCerrar();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmBajaConsultorio(this);
	}
}