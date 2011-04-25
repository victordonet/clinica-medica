package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import excepciones.PersistenciaException;

import vista.ventanas.FrmFiltroListadoPorFecha;

public class CdorFiltroListFecha extends CdorManejoVentanas {

	private FrmFiltroListadoPorFecha ventana;
	private CdorManejoVentanas vino;


	public CdorFiltroListFecha() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmFiltroListadoPorFecha(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
		}
	
	
	
	}

	public void actionListar(Calendar fecha){
		CdorListadoConsultas cdor = new CdorListadoConsultas();
		cdor.setFecha(fecha);
		this.cambioVentana(this, cdor);
	}
	
	public void habilitarVentana() {
		ventana.setEnabled(true);
		ventana.setFocusable(true);
		ventana.setFocusableWindowState(true);
	}

	public void cerrar() {
		ventana.dispose();
	}

	public void deshabilitarVentana() {
		ventana.setEnabled(false);
		ventana.setFocusable(false);
	}

	public FrmFiltroListadoPorFecha getVentana() {
		return ventana;
	}

	public void setVentana(FrmFiltroListadoPorFecha ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}


}
