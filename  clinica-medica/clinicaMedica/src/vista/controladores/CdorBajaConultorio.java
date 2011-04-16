package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.ventanas.FrmBajaConsultorio;

public class CdorBajaConultorio extends CdorManejoVentanas {
	
	private FrmBajaConsultorio ventana;
	private CdorManejoVentanas vino;
	
	public CdorBajaConultorio() {
		super();
	}
		
	public FrmBajaConsultorio getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmBajaConsultorio ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmBajaConsultorio(this);
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
	
	public void bajaConsultorio(int id){
		try {
			super.getMod().bajaConsultorio(id);
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