
package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import vista.dataobjet.DataConsFecha;
import vista.ventanas.FrmListadoConsultas;
import excepciones.PersistenciaException;

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
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
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
			
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
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
