package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataCantConsu;
import vista.ventanas.FrmListMedPremiado;
import excepciones.PersistenciaException;

public class CdorListMedPremiado extends CdorManejoVentanas {
	
	private FrmListMedPremiado ventana;
	private ModeloTablaListMedPremiado modelo = null;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
		
	public CdorListMedPremiado() {
		super();
	}

	public FrmListMedPremiado getVentana() {
		return ventana;
	}

	public void setVentana(FrmListMedPremiado ventana) {
		this.ventana = ventana;
	}

	public CdorManejoVentanas getVentanaVoy() {
		return ventanaVoy;
	}

	public void setVentanaVoy(CdorManejoVentanas ventanaVoy) {
		this.ventanaVoy = ventanaVoy;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmListMedPremiado(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
	public ModeloTablaListMedPremiado listarMedPremiado(){
		ModeloTablaListMedPremiado modelo =null;
		try {
			Vector<DataCantConsu> vPremiado = super.getMod().listarMedPremiado(vino.getfDesde(), vino.getfHasta());
			modelo = new ModeloTablaListMedPremiado(vPremiado);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return modelo;


}
}