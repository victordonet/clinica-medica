
package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import excepciones.PersistenciaException;

import logica.fachada.IfachadaLogica;
import vista.ventanas.FrmListadoEspecialidades;

public class CdorListadoEsp extends CdorManejoVentanas{

	private FrmListadoEspecialidades ventana;
	private IfachadaLogica mod1;
	private ModeloTablaListEsp modelo = null;
	private CdorManejoVentanas vino;
	

	public CdorListadoEsp()
	{
		super();
	}
	
	public void desplegarVentana (CdorManejoVentanas vino){
			this.vino = vino;
		try {
			modelo = listarEspecialidades();
			ventana = new FrmListadoEspecialidades(modelo,this);
			
		} catch (Throwable e) {
	
			e.printStackTrace();
		}
	}

	public FrmListadoEspecialidades getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoEspecialidades ventana) {
		this.ventana = ventana;
	}

	public IfachadaLogica getMod() {
		return mod1;
	}

	public void setMod(IfachadaLogica mod) {
		this.mod1 = mod;
	}

	public ModeloTablaListEsp listarEspecialidades (){

		ModeloTablaListEsp modelo =null;
		try {
			Vector hs = mod1.listarEspecialidades();
			System.out.println(hs.toString());
			modelo = new ModeloTablaListEsp(hs);
			System.out.println(modelo.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelo;

	}
	public void cerrar() {
		
	
	ventana.getVentana().dispose();
		
	}
	public void habilitarVentana(){
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	@Override
	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);
		
	}

	public void actionCerrar(){
		this.cerrarVentana(this, vino);
		
	}

}
