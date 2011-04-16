package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.dataobjet.DataAfiliado;
import vista.ventanas.FrmAltaAfiliado;

public class CdorAltaAfil extends CdorManejoVentanas {
	
	private FrmAltaAfiliado ventana;
	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vino;
	
	public CdorAltaAfil() {
		try {
			mod = new ProxyFachadaLogica();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
			
		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema");
			e.printStackTrace();
			
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
	}
		
	public FrmAltaAfiliado getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmAltaAfiliado ventana) {
		this.ventana = ventana;
	}
	
	public ProxyFachadaLogica getMod() {
		return mod;
	}
	
	public void setMod(ProxyFachadaLogica mod) {
		this.mod = mod;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaAfiliado(this);
	}
	
	public void habilitarVentana() {
		ventana.setFocusable(true);
		ventana.setEnabled(true);
		ventana.setFocusableWindowState(true);
	}
	
	public void deshabilitarVentana() {
		ventana.setFocusable(false);
		ventana.setEnabled(false);
	}
	
	public void cerrar() {
		ventana.dispose();
	}
	
	public void actionCerrar() {
		this.cerrarVentana(this, vino);
	}
	
	public void altaAfil(String id,String ci,String nombre,String apellido,String mail,String direccion,String tel,String estado,Calendar fechaIngreso,boolean fonasa){
		
		DataAfiliado afil=null;
		if(fonasa==true)
		afil = new DataAfiliado(id, ci, nombre, apellido, mail, direccion, tel, estado, fechaIngreso, fonasa);
		try {
			mod.altaAfiliado(afil);
			actionCerrar();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
	}
}