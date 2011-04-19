package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataMed;
import vista.ventanas.FrmBajaMedico;

public class CdorBajaMedico extends CdorManejoVentanas {
	
	private FrmBajaMedico ventana;
	private CdorManejoVentanas vino;
	
	public CdorBajaMedico() {
		super();
	}
		
	public FrmBajaMedico getVentana() {
		return ventana;
	}

	public void setVentana(FrmBajaMedico ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmBajaMedico(this);
	}

	public DataMed getDatos(){
		DataMed dMed = super.getMod().getMedico(super.getId());
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
	
	public void bajaMedico(String id){
		try {
			super.getMod().bajarMedico(id);
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