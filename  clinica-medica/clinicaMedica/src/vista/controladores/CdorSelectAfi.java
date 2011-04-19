package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;
import excepciones.PersistenciaException;
import vista.dataobjet.DataAfiliado;
import vista.ventanas.FrmSelecAfiliado;

public class CdorSelectAfi extends CdorManejoVentanas {
	
	private FrmSelecAfiliado ventana;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
	private Vector<DataAfiliado> vAfi;

	public CdorSelectAfi() {
		super();
	}
	
	public FrmSelecAfiliado getVentana() {
		return ventana;
	}

	public void setVentana(FrmSelecAfiliado ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmSelecAfiliado(this);
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
	
	public ModeloTablaListAfil listarAfi(){
		ModeloTablaListAfil modelo = null;
		try {
			vAfi = super.getMod().listarAfiliados();
			modelo = new ModeloTablaListAfil(vAfi);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return modelo;
	}
	
	public void actionAceptar() {
		vino.setId(this.getId());
		this.cambioVentana(vino, ventanaVoy);
		cerrar();
	}
	
	public CdorManejoVentanas getVentanaVoy() {
		return ventanaVoy;
	}

	public void setVentanaVoy(CdorManejoVentanas ventanaVoy) {
		this.ventanaVoy = ventanaVoy;
	}

	public Vector<DataAfiliado> getvAfi() {
		return vAfi;
	}

	public void setvAfi(Vector<DataAfiliado> vAfi) {
		this.vAfi = vAfi;
	}
}
