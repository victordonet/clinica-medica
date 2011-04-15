package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataConsultas;
import vista.ventanas.FrmMenuGerente;

public class CdorMenuGerente extends CdorManejoVentanas {

	private FrmMenuGerente ventana;
	private IfachadaLogica mod;
	private CdorManejoVentanas vino;
	//private ModeloTablaListConsultas modelo = null;

	public CdorMenuGerente() {
		super();
	}
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			//modelo = listarConsultas();
			ventana = new FrmMenuGerente(this);
			mod.addObsMenuGA(ventana);

		} catch (Throwable e) {

			e.printStackTrace();
		}
	}

	public ModeloTablaListConsultas listarConsultas (){
		ModeloTablaListConsultas modelo =null;
		try {
			Vector<DataConsultas> vec = mod.listarConsultas();
			System.out.println(vec.toString());
			modelo = new ModeloTablaListConsultas(vec);
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
	
	public void actionMantAfil(){	
		this.cambioVentana(this, new CdorMantAfil());
	}
	
	public void actionMantMed(){
		this.cambioVentana(this, new CdorMantMedico()); 
	}
	
	public void actionMantAdmin(){	
		this.cambioVentana(this, new CdorMantAdmin());
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
		this.cambioVentana(this, new CdorMantListadosGerente());
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

	public FrmMenuGerente getVentana() {
		return ventana;
	}

	public void setVentana(FrmMenuGerente ventana) {
		this.ventana = ventana;
	}

	public IfachadaLogica getMod() {
		return mod;
	}

	public void setMod(IfachadaLogica modelo) {
		this.mod = modelo;
	}

	public void actionCerrar() {
		cerrar();
	}
}
