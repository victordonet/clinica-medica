package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataExamen;
import vista.dataobjet.DataTipoExamen;
import vista.ventanas.FrmRegistroExamen;

public class CdorRegistroExamen extends CdorManejoVentanas {
	
	private FrmRegistroExamen ventana;
	private CdorManejoVentanas vino;
	private Vector<DataTipoExamen> vTex;
	
	public CdorRegistroExamen() {
		super();
	}
		
	public FrmRegistroExamen getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmRegistroExamen ventana) {
		this.ventana = ventana;
	}
	
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmRegistroExamen(this);
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
	
	public DefaultComboBoxModel cargarTex(){
		DefaultComboBoxModel boxMod = new DefaultComboBoxModel();
		try {
			 vTex = super.getMod().listarTipoEx();
			for (int i = 0; i < vTex.size(); i++) {
				boxMod.addElement(vTex.get(i).getNombre());
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
	
	public boolean cobraTimbre(){
		boolean resultado = false;
		try {
			String idAfil =  super.getId();
			resultado = super.getMod().cobraTimbre(idAfil);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void altaRegistro(Calendar fechaInicio, Calendar fechaResultado, boolean enviaMail, boolean cobroTimbre, int selecTex){
		int idTex = vTex.get(selecTex).getId();
		String nomTex = vTex.get(selecTex).getNombre();
		DataTipoExamen tex = new DataTipoExamen(idTex, nomTex);
		DataExamen ex = new DataExamen(fechaInicio, fechaResultado, enviaMail, cobroTimbre, tex);
		try {
			super.getMod().regEx(ex, super.getId());
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
}