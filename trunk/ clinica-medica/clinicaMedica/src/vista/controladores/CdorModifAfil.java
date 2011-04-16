package vista.controladores;

import java.rmi.RemoteException;
import excepciones.PersistenciaException;
import vista.ventanas.FrmModifAfiliado;

public class CdorModifAfil extends CdorManejoVentanas {
	
	private FrmModifAfiliado ventana;
	private CdorManejoVentanas vino;
	
	public CdorModifAfil() {
		super();
	}
		
	public FrmModifAfiliado getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmModifAfiliado ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmModifAfiliado(this);
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
	
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, String fonasa){
		try {
			boolean fon = false;
			if(fonasa.equals("S"))
				fon=true;
			super.getMod().modifAfil(idAfil, nom, apel, ci, mail, dir, tel, fon);
			actionCerrar();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}
}