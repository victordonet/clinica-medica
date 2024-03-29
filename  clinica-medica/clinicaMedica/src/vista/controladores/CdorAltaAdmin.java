package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataUsuario;
import vista.ventanas.FrmAltaAdmin;
import excepciones.PersistenciaException;

public class CdorAltaAdmin extends CdorManejoVentanas {
	
	private FrmAltaAdmin ventana;
	private CdorManejoVentanas vino;
	
	public CdorAltaAdmin() {
		super();
	}
		
	public FrmAltaAdmin getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmAltaAdmin ventana) {
		this.ventana = ventana;
	}
	
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaAdmin(this);
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
	
	public void altaAdmin (String id, String nombre, int cargo){
		// el cargo es el lugar en el vector que recorro en el combobox
		DataAdmin da = new DataAdmin(id, nombre, cargo+1, "A");
		try {
			super.getMod().altaAdmin(da);
			String tipo = "AD";
			if (cargo+1==1){
				tipo = "GE";
			}
			
			DataUsuario usu = new DataUsuario(id, id,tipo , "A");
			super.getMod().altaUsuario(usu);
			JOptionPane.showMessageDialog(null,"Alta ok");
			actionCerrar();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());

		}
	}
	
	public DefaultComboBoxModel cargarBox(){
		DefaultComboBoxModel boxMod = new DefaultComboBoxModel();
		boxMod.addElement("Gerente");
		boxMod.addElement("Administrador");
		return boxMod;
	}
}