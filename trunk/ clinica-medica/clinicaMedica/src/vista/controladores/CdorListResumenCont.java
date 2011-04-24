package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.VoResumCont;
import vista.ventanas.FrmListResumenCont;
import excepciones.PersistenciaException;

public class CdorListResumenCont extends CdorManejoVentanas {
	
	private FrmListResumenCont ventana;
	private ModeloTablaListResumenCont modelo = null;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
		
	public CdorListResumenCont() {
		super();
	}

	public FrmListResumenCont getVentana() {
		return ventana;
	}

	public void setVentana(FrmListResumenCont ventana) {
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
			ventana = new FrmListResumenCont(this);
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
	public ModeloTablaListResumenCont listarResumenCont(){

		ModeloTablaListResumenCont modelo =null;
		try {
			Vector<VoResumCont> vResumen = super.getMod().listarResContable(vino.getfDesde(), vino.getfHasta());
			modelo = new ModeloTablaListResumenCont(vResumen);
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