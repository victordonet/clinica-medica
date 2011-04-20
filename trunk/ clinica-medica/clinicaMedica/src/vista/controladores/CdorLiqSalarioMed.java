package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataSalario;
import vista.ventanas.FrmLiqSalarioMed;

public class CdorLiqSalarioMed extends CdorManejoVentanas {
	
	private FrmLiqSalarioMed ventana;
	private ModeloTablaLiqSalarioMed modelo = null;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
	private Vector<DataSalario> vSalario;
	private Calendar fDesde, fHasta;

		
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

	public Vector<DataSalario> getvSalario() {
		return vSalario;
	}

	public void setvSalario(Vector<DataSalario> vSalario) {
		this.vSalario = vSalario;
	}
	
	public Calendar getfDesde() {
		return fDesde;
	}

	public void setfDesde(Calendar fDesde) {
		this.fDesde = fDesde;
	}

	public Calendar getfHasta() {
		return fHasta;
	}

	public void setfHasta(Calendar fHasta) {
		this.fHasta = fHasta;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmLiqSalarioMed(this);
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
	public ModeloTablaLiqSalarioMed liqSalarioMed (){

		ModeloTablaLiqSalarioMed modelo =null;
		try {
			vSalario = super.getMod().listarSalarios(fDesde, fHasta);
			modelo = new ModeloTablaLiqSalarioMed(vSalario);
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