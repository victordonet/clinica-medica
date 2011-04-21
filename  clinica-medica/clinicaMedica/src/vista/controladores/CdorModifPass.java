package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.ventanas.FrmModifPass;

public class CdorModifPass extends CdorManejoVentanas {
	
	private FrmModifPass ventana;
	private CdorManejoVentanas vino;
	
	public CdorModifPass() {
		super();
	}
		
	public FrmModifPass getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmModifPass ventana) {
		this.ventana = ventana;
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
		cerrarVentana(this, vino);
	}
	
	public boolean resertPass(){
		boolean resultado=false;
		if (this.getUsu().getTipo().equals("ME") || this.getUsu().getTipo().equals("AF")){
			resultado = false;	
		}else{
			resultado = true;
		}
		return resultado;
	}
	
	public String getIdUsuario(){
		String resultado = "";
		if (resertPass()){
			resultado = this.getId();
		}else{
			resultado = this.getUsu().getIdUsu();
		}
		return resultado;
	}
	
	public boolean validarPass(String passNueva, String repPass){
		boolean resultado = false;
		if (passNueva.equals(repPass)){
			resultado = true;
		}
		return resultado;
	}
	
	public boolean validarUsu (String clave, String pass){
		boolean valido = false;
		try {
			if (super.getMod().validarUsuario(clave, pass)){
				valido = true;
			}
			else{
				valido = false;
			}
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
		
		return valido;
	}
	
	public void modifPass(String clave, String pass){
		try {
			super.getMod().modifContrasena(clave, pass);
			JOptionPane.showMessageDialog(null,"La contraseña fue cambiada con éxito.");
			actionCerrar();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}