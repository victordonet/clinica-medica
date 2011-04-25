package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataExamen;
import vista.ventanas.FrmSelecExamen;
import excepciones.PersistenciaException;

public class CdorSelectExam extends CdorManejoVentanas {
	
	private FrmSelecExamen ventana;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
	private Vector<DataExamen> vEx;

	public CdorSelectExam() {
		super();
	}
	
	public FrmSelecExamen getVentana() {
		return ventana;
	}

	public void setVentana(FrmSelecExamen ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmSelecExamen(this);
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

	public ModeloTablaListExam listarExam(){
		ModeloTablaListExam modelo = null;
		try {
			vEx = super.getMod().listarExPend(super.getId());
			modelo = new ModeloTablaListExam(vEx);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return modelo;
	}
	
	public void actionAceptar(int selecEx) {
		CdorResultadoExamen cdor = new CdorResultadoExamen();
		cdor.setDataEx(vEx.get(selecEx));
		this.cambioVentana(vino, cdor);
		cerrar();
	}
	
	public CdorManejoVentanas getVentanaVoy() {
		return ventanaVoy;
	}

	public void setVentanaVoy(CdorManejoVentanas ventanaVoy) {
		this.ventanaVoy = ventanaVoy;
	}

	public Vector<DataExamen> getvEx() {
		return vEx;
	}

	public void setvEx(Vector<DataExamen> vEx) {
		this.vEx = vEx;
	}
}
