package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataExamen;
import vista.dataobjet.DataTipoExamen;
import vista.ventanas.FrmRegistroExamen;
import vista.ventanas.FrmResultadoExamen;

public class CdorResultadoExamen extends CdorManejoVentanas {
	
	private FrmResultadoExamen ventana;
	private CdorManejoVentanas vino;
	
	public CdorResultadoExamen() {
		super();
	}
		
	public FrmResultadoExamen getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmResultadoExamen ventana) {
		this.ventana = ventana;
	}
	
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmResultadoExamen(this);
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
	
/*	public void altaRegistro(Calendar fechaInicio,Calendar fechaResultado,boolean enviaMail,boolean cobroTimbre, tex){
		DataTipoExamen tex = new DataTipoExamen(id, nombre);
		DataExamen da = new DataExamen(fechaInicio, fechaResultado, enviaMail, cobroTimbre, tex);
		try {
			super.getMod().regEx(ex, idAfil);
			JOptionPane.showMessageDialog(null,"Alta ok");
			actionCerrar();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
	}*/
}