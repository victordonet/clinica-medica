package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.dataobjet.DataMed;
import vista.ventanas.FrmMantDisp;
import excepciones.PersistenciaException;

public class CdorMantDisp extends CdorManejoVentanas {

	private FrmMantDisp ventana;
	private CdorManejoVentanas vino;
	private DataMed dMed;
	ModeloTablaDisp modelo =null;

	public ModeloTablaDisp obtenerDisp (){
		
		try {
			boolean[][] datosMed = this.getMod().obtenerDispoDiaHoraMedico(super.getId());
			int[][] confCelda = this.getMod().obetnerDispoDiaHora();
			int consu = this.getMod().listarConsultorios().size();
			modelo = new ModeloTablaDisp(confCelda,datosMed,consu);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return modelo;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			dMed = super.getMod().getDataMed(super.getId());
			ventana = new FrmMantDisp(this);
			super.getMod().addObsDispMed(ventana);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}				
	}
	
	public void cerrar() {
		try {
			super.getMod().remObsDispMed(ventana);
			ventana.getVentana().dispose();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		}
		
	}
	
	public void habilitarVentana(){
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);
	}

	public void actionCerrar(){
		cerrarVentana(this, vino);
	}

	public DataMed getdMed() {
		return dMed;
	}

	public void setdMed(DataMed dMed) {
		this.dMed = dMed;
	}
	
	public void actionAceptar(){

		try {
			super.getMod().modificarDisponibilidad(modelo.getMatrizDispMedico(),this.getId());
			JOptionPane.showMessageDialog(null, "Disponibilidad Actualizada con exito");
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
