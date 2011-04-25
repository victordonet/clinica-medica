
package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataConsAfi;
import vista.ventanas.FrmListadoDetalleAfiliado;
import excepciones.PersistenciaException;

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
			if(dAfil==null){
				setdAfil(super.getMod().getAfiliado(super.getId()));
			}
			modelo = listarConsultas();
			ventana = new FrmListadoDetalleAfiliado(modelo,this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
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
			modelo = new ModeloTablaListadoConsAfi(vec);
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

	public DataAfiliado getdAfil() {
		return dAfil;
	}

	public void setdAfil(DataAfiliado dAfil) {
		this.dAfil = dAfil;
	}
}
