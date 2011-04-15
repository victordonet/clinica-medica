package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.ventanas.FrmBajaAdmin;

public class CdorBajaAdmin extends CdorManejoVentanas {
	
	private FrmBajaAdmin ventana;
	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vino;
	
	public CdorBajaAdmin() {
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
		
	public FrmBajaAdmin getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmBajaAdmin ventana) {
		this.ventana = ventana;
	}
	
	public ProxyFachadaLogica getMod() {
		return mod;
	}
	
	public void setMod(ProxyFachadaLogica mod) {
		this.mod = mod;
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
		this.cerrarVentana(this, vino);
	}
	
	public void bajaAdmin(String id){
		try {
			mod.bajaAdmin(id);
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