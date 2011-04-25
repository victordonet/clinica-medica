package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataSalario;
import vista.ventanas.FrmLiqSalarioMed;
import excepciones.PersistenciaException;

public class CdorLiqSalarioMed extends CdorManejoVentanas {
	
	private FrmLiqSalarioMed ventana;
	private ModeloTablaLiqSalarioMed modelo = null;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
		
	public CdorLiqSalarioMed() {
		super();
	}

	public FrmLiqSalarioMed getVentana() {
		return ventana;
	}

	public void setVentana(FrmLiqSalarioMed ventana) {
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
			ventana = new FrmLiqSalarioMed(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
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
	
	public ModeloTablaLiqSalarioMed liqSalarioMed (){
		ModeloTablaLiqSalarioMed modelo =null;
		try {
			Vector<DataSalario> vSalario = super.getMod().listarSalarios(vino.getfDesde(), vino.getfHasta());
			modelo = new ModeloTablaLiqSalarioMed(vSalario);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return modelo;
	}
}