package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataAdmin;
import vista.ventanas.FrmSelecAdmin;
import excepciones.PersistenciaException;

public class CdorSelectAdmin extends CdorManejoVentanas {
	
	private FrmSelecAdmin ventana;
	private ModeloTablaListAdmin modelo = null;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
	private Vector<DataAdmin> vAdmin;

	public CdorSelectAdmin() {
		super();
	}
	
	public FrmSelecAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmSelecAdmin ventana) {
		this.ventana = ventana;
	}

	public CdorManejoVentanas getVentanaVoy() {
		return ventanaVoy;
	}

	public void setVentanaVoy(CdorManejoVentanas ventanaVoy) {
		this.ventanaVoy = ventanaVoy;
	}

	public Vector<DataAdmin> getvAdmin() {
		return vAdmin;
	}

	public void setvAdmin(Vector<DataAdmin> vAdmin) {
		this.vAdmin = vAdmin;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmSelecAdmin(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}

	public void habilitarVentana() {
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);
	}

	public void cerrar() {
		ventana.getVentana().dispose();
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
	public void actionAceptar() {
		vino.setId(this.getId());
		this.cambioVentana(vino, ventanaVoy);
		cerrar();
	}
		
	public ModeloTablaListAdmin listarAdmin (){

		ModeloTablaListAdmin modelo =null;
		try {
			vAdmin = super.getMod().listarAdmin();
			System.out.println(vAdmin.toString());
			modelo = new ModeloTablaListAdmin(vAdmin);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return modelo;

	}
}
