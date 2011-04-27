package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataAfiliado;
import vista.ventanas.FrmSelecAfiliado;
import excepciones.PersistenciaException;

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
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
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
			if(ventanaVoy.getClass()==CdorModifAfil.class){
				vAfi = super.getMod().listarAfiliados("I");
			}
			else{
				vAfi = super.getMod().listarAfiliados("A");
			}
			modelo = new ModeloTablaListAfil(vAfi);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
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
