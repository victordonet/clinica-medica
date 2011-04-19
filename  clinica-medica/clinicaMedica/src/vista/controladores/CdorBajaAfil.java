package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataAfiliado;
import vista.ventanas.FrmBajaAfiliado;

public class CdorBajaAfil extends CdorManejoVentanas {
	
	private FrmBajaAfiliado ventana;
	private CdorManejoVentanas vino;
	
	public CdorBajaAfil() {
		super();
	}
		
	public FrmBajaAfiliado getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmBajaAfiliado ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmBajaAfiliado(this);
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
	
	public DataAfiliado getDatos(){
		DataAfiliado datosAfi = null;
		try {
			datosAfi = super.getMod().getAfiliado(super.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return datosAfi;
	}
	
	public void bajaAfil(String id){
		try {
			super.getMod().bajaAfil(id);
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