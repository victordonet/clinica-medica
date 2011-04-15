package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.ventanas.FrmModifPass;

public class CdorModifPass extends CdorManejoVentanas {
	
	private FrmModifPass ventana;
	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vino;
	
	public CdorModifPass() {
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
		
	public FrmModifPass getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmModifPass ventana) {
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
		ventana = new FrmModifPass(this);
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
	
	public boolean validarPass(String passNueva, String repPass){
		boolean resultado = false;
		if (passNueva.equals(repPass)){
			resultado = true;
		}
		actionCerrar();
		return resultado;
	}
	
	public void modifPass(String clave, String pass){
		try {
			mod.modifContrasena(clave, pass);
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