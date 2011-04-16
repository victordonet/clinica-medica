package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import excepciones.PersistenciaException;
import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataAdmin;
import vista.ventanas.FrmListadoAdmin;

public class CdorListadoAdmin extends CdorManejoVentanas {
	
	private FrmListadoAdmin ventana;
	private IfachadaLogica mod;
	private ModeloTablaListAdmin modelo = null;
	private CdorManejoVentanas vino;

	public CdorListadoAdmin() {
		super();
	}
	
	public FrmListadoAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoAdmin ventana) {
		this.ventana = ventana;
	}

	public IfachadaLogica getMod() {
		return mod;
	}

	public void setMod(IfachadaLogica mod) {
		this.mod = mod;
	}

	@Override
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			modelo = listarAdmin();
			ventana = new FrmListadoAdmin(modelo,this);
		
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@Override
	public void habilitarVentana() {
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	@Override
	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);

	}

	@Override
	public void cerrar() {
		ventana.getVentana().dispose();

	}

	@Override
	public void actionCerrar() {
		this.cerrarVentana(this, vino);

	}
	public ModeloTablaListAdmin listarAdmin (){

		ModeloTablaListAdmin modelo =null;
		try {
			Vector<DataAdmin> hs = mod.listarAdmin();
			System.out.println(hs.toString());
			modelo = new ModeloTablaListAdmin(hs);
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
