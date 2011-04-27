package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.dataobjet.DataEsp;
import vista.ventanas.FrmAltaEspecialidades;
import excepciones.PersistenciaException;

public class CdorAltaEsp extends CdorManejoVentanas {
	
	private FrmAltaEspecialidades ventana;
	private CdorManejoVentanas vino;
	
	public CdorAltaEsp() {
		super();
	}
	
	public void altaEsp (String IdEsp, String desc, String monto){
		try {
			int idEspecialidad = Integer.parseInt(IdEsp);
			double montoBase = Double.parseDouble(monto);
			DataEsp datEsp = new DataEsp(idEspecialidad, desc, montoBase);
			super.getMod().altaEspecialidad(datEsp);
			JOptionPane.showMessageDialog(null,"Alta ok");
			actionCerrar();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"El campo Codigo y monto no pueden estar vacios ");
		}
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaEspecialidades(this);
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
}
