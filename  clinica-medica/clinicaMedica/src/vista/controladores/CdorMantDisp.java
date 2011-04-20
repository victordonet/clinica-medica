package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataMed;
import vista.ventanas.FrmMantDisp;

public class CdorMantDisp extends CdorManejoVentanas {

	private FrmMantDisp ventana;
	private CdorManejoVentanas vino;
	private DataMed dMed;

	public ModeloTablaDisp obtenerDisp (String idMed){
		ModeloTablaDisp modelo =null;
		try {
			boolean[][] datosMed = this.getMod().obtenerDispoDiaHoraMedico(idMed);
			int[][] confCelda = this.getMod().obetnerDispoDiaHora();
			int consu = this.getMod().listarConsultorios().size();
			modelo = new ModeloTablaDisp(confCelda,datosMed,consu);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return modelo;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			dMed = super.getMod().getDataMed(super.getId());
			ventana = new FrmMantDisp(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}				
	}
	
	public void cerrar() {
		ventana.getVentana().dispose();
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
	
/*	public String getNombre(){
		String nomMed = null;
		try {
			nomMed = super.getMod().getDataMed(super.getId()).getNombre();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return nomMed;
	}*/
	
}
