package vista.controladores;

import java.rmi.RemoteException;
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
			super.getMod().modifContrasena(clave, pass);
			actionCerrar();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}