package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataEsp;
import vista.ventanas.FrmAltaAdmin;

public class CdorAltaAdmin extends CdorManejoVentanas {
	
	private FrmAltaAdmin ventana;
	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vino;
	
	public CdorAltaAdmin() {
		try {
			mod = new ProxyFachadaLogica();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
			
		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema");
			e.printStackTrace();
			
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
			
		}
	}
		
	public FrmAltaAdmin getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmAltaAdmin ventana) {
		this.ventana = ventana;
	}
	
	public ProxyFachadaLogica getMod() {
		return mod;
	}
	
	public void setMod(ProxyFachadaLogica mod) {
		this.mod = mod;
	}
	@Override
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaAdmin(this);

	}

	@Override
	public void habilitarVentana() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deshabilitarVentana() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cerrar() {
		ventana.dispose();

	}

	@Override
	public void actionCerrar() {
		this.cerrarVentana(this, vino);

	}
	public void altaAdmin (String id, String nombre, int cargo){
		
		// el cargo es el lugar en el vector que recorro en el combobox
		DataAdmin da = new DataAdmin(id, nombre, cargo+1, "A");
		try {
			mod.altaAdmin(da);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();

		}
	}
	public DefaultComboBoxModel cargarBox(){
		DefaultComboBoxModel boxMod = new DefaultComboBoxModel();
		
			boxMod.addElement("Gerente");
			boxMod.addElement("Administrador");
			boxMod.addElement("Cajero");
			
			return boxMod;
	}
}