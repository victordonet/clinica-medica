
package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataConsAfi;
import vista.ventanas.FrmListadoDetalleAfiliado;

public class CdorListadoDetalleAfiliado extends CdorManejoVentanas{

	private FrmListadoDetalleAfiliado ventana;
	private ModeloTablaListadoConsAfi modelo = null;
	private CdorManejoVentanas vino;
	private DataAfiliado dAfil;

	public CdorListadoDetalleAfiliado(){
		super();
	}
	
	public void desplegarVentana (CdorManejoVentanas vino){
			this.vino = vino;
		try {
			modelo = listarConsultas();
			ventana = new FrmListadoDetalleAfiliado(modelo,this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public FrmListadoDetalleAfiliado getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoDetalleAfiliado ventana) {
		this.ventana = ventana;
	}

	public ModeloTablaListadoConsAfi listarConsultas(){
		ModeloTablaListadoConsAfi modelo =null;
		try {
			Vector<DataConsAfi> vec = super.getMod().listarConsultasAfi(dAfil.getId());
			System.out.println(vec.toString());
			modelo = new ModeloTablaListadoConsAfi(vec);
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

	public DataAfiliado getdAfil() {
		return dAfil;
	}

	public void setdAfil(DataAfiliado dAfil) {
		this.dAfil = dAfil;
	}
}
