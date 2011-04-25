package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;

import vista.dataobjet.DataConsultas;
import vista.ventanas.FrmMenuAdmin;
import excepciones.PersistenciaException;

public class CdorMenuAdmin extends CdorManejoVentanas {

	private FrmMenuAdmin ventana;
	private CdorManejoVentanas vino;

	public CdorMenuAdmin() {
		super();
	}
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMenuAdmin(this);
			super.getMod().addObsMenuGA(ventana);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
		}
	}

	public ModeloTablaListConsultas listarConsultas (){
		ModeloTablaListConsultas modelo =null;
		try {
			Vector<DataConsultas> vec = super.getMod().listarConsultas();
			modelo = new ModeloTablaListConsultas(vec);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return modelo;
	}
	
	public void actionMantAfil(){	
		this.cambioVentana(this, new CdorMantAfil());
	}
	
	public void actionMantMed(){
		this.cambioVentana(this, new CdorMantMedico()); 
	}
	
	public void actionMantExamenes(){	
		this.cambioVentana(this, new CdorMantExamenes());
	}
	
	public void actionMantConsultorios(){
		this.cambioVentana(this, new CdorMantConsultorios()); 
	}
	
	public void actionMantEsp(){	
		this.cambioVentana(this, new CdorMantEsp());
	}
	
	public void actionListados(){	
		this.cambioVentana(this, new CdorMantListadosAdmin());
	}
	
	public void habilitarVentana() {
		ventana.frmEnable();
	}

	public void cerrar() {
		ventana.frmCerrar();
	}

	public void deshabilitarVentana() {
		ventana.frmDisable();
	}

	public FrmMenuAdmin getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenuAdmin ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrar();
	}
}
