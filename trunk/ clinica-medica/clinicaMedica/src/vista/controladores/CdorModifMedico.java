package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import excepciones.PersistenciaException;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.ventanas.FrmModifMedico;

public class CdorModifMedico extends CdorManejoVentanas {
	
	private FrmModifMedico ventana;
	private CdorManejoVentanas vino;
	private Vector<DataEsp> vEsp = null;
	
	public CdorModifMedico() {
		super();
	}
		
	public FrmModifMedico getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmModifMedico ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmModifMedico(this);
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
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return datosMed;
	}
	
	public DefaultComboBoxModel cargarEsp(){
		DefaultComboBoxModel boxModEsp = new DefaultComboBoxModel();
		try {
			vEsp = super.getMod().listarEspecialidades();
			for (int i = 0; i < vEsp.size(); i++) {
				boxModEsp.addElement(vEsp.get(i).getDescripcion());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return boxModEsp;
	}
	
	public int selecEsp(int idEsp){
		int resultado=0;
		for (int i = 0; i < vEsp.size(); i++) {
			if(vEsp.get(i).getCodigo()==idEsp){
				resultado = i;
			}
		}
		return resultado;
	}
	
	public void modifMedico(String id, String nom, String apell, String ci, String tel, int idEsp, String estado){
		try {
			DataEsp esp = super.getMod().obtenerEspecialidad(vEsp.get(idEsp).getCodigo());
			super.getMod().modifMedico(id, nom, apell, ci, tel, esp, estado);
			actionCerrar();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}