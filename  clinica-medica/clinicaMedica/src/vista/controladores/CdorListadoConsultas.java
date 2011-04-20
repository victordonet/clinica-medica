
package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataConsFecha;
import vista.ventanas.FrmListadoConsultas;

public class CdorListadoConsultas extends CdorManejoVentanas{

	private FrmListadoConsultas ventana;
	private ModeloTablaListadoConsultas modelo = null;
	private CdorManejoVentanas vino;
	private Calendar fecha;

	public CdorListadoConsultas(){
		super();
	}
	
	public void desplegarVentana (CdorManejoVentanas vino){
			this.vino = vino;
		try {
			ventana = new FrmListadoConsultas(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public FrmListadoConsultas getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoConsultas ventana) {
		this.ventana = ventana;
	}

	public ModeloTablaListadoConsultas listarConsultas(){
		ModeloTablaListadoConsultas modelo =null;
		try {
			Vector<DataConsFecha> vec = super.getMod().listarConsFecha(fecha);
			System.out.println(vec.toString());
			modelo = new ModeloTablaListadoConsultas(vec);
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
	public void cerrar() {
		ventana.dispose();

	}
	public void habilitarVentana(){
		ventana.setFocusable(true);
		ventana.setEnabled(true);
		ventana.setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.setFocusable(false);
		ventana.setEnabled(false);
	}

	public void actionCerrar(){
		cerrarVentana(this, vino);
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
}
