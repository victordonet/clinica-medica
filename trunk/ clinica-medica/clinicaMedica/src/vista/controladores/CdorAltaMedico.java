package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import logica.fachada.ProxyFachadaLogica;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.ventanas.FrmAltaMedico;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class CdorAltaMedico extends CdorManejoVentanas {

	private FrmAltaMedico ventana;
	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vino;
	private Vector<DataEsp> esp = null;
	
	public CdorAltaMedico() {
		try {
			mod = new ProxyFachadaLogica();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
			
		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
			
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
			
		}
	}
	public void AltaMedico(String id, String nombre, String apellido, String ci, String tel, int indexEsp){
		
			
			try {
				int idEspecialidad = esp.get(indexEsp).getCodigo();
				DataMed med = new DataMed(id, nombre, apellido, ci, tel, "A", idEspecialidad);
				mod.altaMedico(med);
				JOptionPane.showMessageDialog(null,"Alta ok");
				actionCerrar();
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
				e.printStackTrace();
			} catch (PersistenciaException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
				e.printStackTrace();
			}
		
	}
	public DefaultComboBoxModel cargarBox(){
		DefaultComboBoxModel boxMod = new DefaultComboBoxModel();
		try {
			esp = mod.listarEspecialidades();
			for (DataEsp especialidad : esp){
				boxMod.addElement(especialidad.getDescripcion());
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
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaMedico(this);
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

}
