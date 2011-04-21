package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import excepciones.PersistenciaException;
import vista.dataobjet.DataAfiliado;
import vista.ventanas.FrmListadoAfiliados;

public class CdorListadoAfil extends CdorManejoVentanas {
	
	private FrmListadoAfiliados ventana;
	private CdorManejoVentanas vino;
	private Vector<DataAfiliado> vAfi;

	public CdorListadoAfil() {
		super();
	}
	
	public FrmListadoAfiliados getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoAfiliados ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmListadoAfiliados(this);
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
	
	public void actionAceptar() {
		CdorListadoDetalleAfiliado cdor = new CdorListadoDetalleAfiliado();
		try {
			cdor.setdAfil(super.getMod().getAfiliado(super.getId()));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		this.cambioVentana(this, cdor);
	}
	
	public ModeloTablaListAfil listarAfil(){
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
	
	public Vector<DataAfiliado> getvAfi() {
		return vAfi;
	}

	public void setvAfi(Vector<DataAfiliado> vAfi) {
		this.vAfi = vAfi;
	}
}
