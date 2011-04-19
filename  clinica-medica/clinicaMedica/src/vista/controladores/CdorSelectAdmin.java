package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import excepciones.PersistenciaException;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataEsp;
import vista.ventanas.FrmSelecAdmin;

public class CdorSelectAdmin extends CdorManejoVentanas {
	
	private FrmSelecAdmin ventana;
	private ModeloTablaListAdmin modelo = null;
	private CdorManejoVentanas vino;

	public CdorSelectAdmin() {
		super();
	}
	
	public FrmSelecAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmSelecAdmin ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmSelecAdmin(this);
		} catch (Throwable e) {
			e.printStackTrace();
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
	
	public ModeloTablaListAdmin listarAdmin (){

		ModeloTablaListAdmin modelo =null;
		try {
			Vector<DataAdmin> vec = super.getMod().listarAdmin();
			System.out.println(vec.toString());
			modelo = new ModeloTablaListAdmin(vec);
			System.out.println(modelo.toString());
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
