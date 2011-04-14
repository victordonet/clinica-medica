package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import excepciones.LogicaException;
import excepciones.PersistenciaException;
import vista.dataobjet.DataAdmin;
import vista.ventanas.FrmAltaAdmin;
import vista.ventanas.FrmAltaConsultorio;
import logica.fachada.ProxyFachadaLogica;


public class CdroAltaConsultorio extends CdorManejoVentanas {
	
	private FrmAltaConsultorio ventana;
	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vino;

	public CdroAltaConsultorio (){
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
	
	public FrmAltaConsultorio getVentana() {
		return ventana;
	}

	public void setVentana(FrmAltaConsultorio ventana) {
		this.ventana = ventana;
	}

	public ProxyFachadaLogica getMod() {
		return mod;
	}

	public void setMod(ProxyFachadaLogica mod) {
		this.mod = mod;
	}
	@Override
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaConsultorio(this);
	}

	@Override
	public void habilitarVentana() {
		// TODO Auto-generated method stub
	}

	@Override
	public void deshabilitarVentana() {
		// TODO Auto-generated method stub
	}

	@Override
	public void cerrar() {
		ventana.dispose();
	}

	@Override
	public void actionCerrar() {
		this.cerrarVentana(this, vino);
	}
	public void altaAdmin (String id, String nombre, int cargo){
		
		DataAdmin da = new DataAdmin(id, nombre, cargo+1, "A");
		try {
			if(mod.validarAdmin(id)==false)
			{
				mod.altaAdmin(da);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"El Administrativo que intenta dar de alta ya existe");
			}
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();

		}
	}
	
	
}
