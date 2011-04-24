package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataUsuario;
import vista.ventanas.FrmAltaAfiliado;
import excepciones.PersistenciaException;

public class CdorAltaAfil extends CdorManejoVentanas {
	
	private FrmAltaAfiliado ventana;
	private CdorManejoVentanas vino;
	
	public CdorAltaAfil() {
		super();
	}
		
	public FrmAltaAfiliado getVentana() {
		return ventana;
	}
	
	public void setVentana(FrmAltaAfiliado ventana) {
		this.ventana = ventana;
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
		cerrarVentana(this, vino);
	}
	
	public void altaAfil(String id,String ci,String nombre,String apellido,String mail,String direccion,String tel,String estado,Calendar fechaIngreso,boolean fonasa){
		DataAfiliado afil=null;
		//if(fonasa==true)
		afil = new DataAfiliado(id, ci, nombre, apellido, mail, direccion, tel, estado, fechaIngreso, fonasa);
		try {
			super.getMod().altaAfiliado(afil);
			DataUsuario usu = new DataUsuario(id, nombre, "AF", "A");
			super.getMod().altaUsuario(usu);
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