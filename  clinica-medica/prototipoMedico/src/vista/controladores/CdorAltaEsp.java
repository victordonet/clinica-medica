package vista.controladores;



import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import persistencia.dao.EspecialidadException;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.dataobjet.DataEsp;
import vista.ventanas.FrmAltaEspecialidades;
import vista.ventanas.FrmListadoEspecialidades;

public class CdorAltaEsp extends CdorManejoVentanas {
	
	private FrmAltaEspecialidades ventana;
	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vino;
	
	public CdorAltaEsp() {
		try {
			mod = new ProxyFachadaLogica();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion");
			e.printStackTrace();
			
		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema");
			e.printStackTrace();
			
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
			
		}
				

	}

	public FrmAltaEspecialidades getVentana() {
		return ventana;
	}

	public void setVentana(FrmAltaEspecialidades ventana) {
		this.ventana = ventana;
	}

	public ProxyFachadaLogica getMod() {
		return mod;
	}

	public void setMod(ProxyFachadaLogica mod) {
		this.mod = mod;
	}
	
	public void altaEsp (String IdEsp, String desc, String monto){
		
		
		try {
			int idEspecialidad = Integer.parseInt(IdEsp);
			double montoBase = Double.parseDouble(monto);
			DataEsp datEsp = new DataEsp(idEspecialidad, desc, montoBase);
			mod.altaEspecialidades(datEsp);
			JOptionPane.showMessageDialog(null,"Alta ok");
			actionCerrar();
			
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server ");
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error en el acceso a los datos");
			e.printStackTrace();
		} catch (EspecialidadException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"El campo Codigo y monto no pueden estar vacios ");
			e.printStackTrace();
		}
		
		
		//actionCerrar();
	}

	@Override
	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		ventana = new FrmAltaEspecialidades(this);
	}

	@Override
	public void habilitarVentana() {
		ventana.setFocusable(true);
		ventana.setEnabled(true);
		ventana.setFocusableWindowState(true);
	}

	@Override
	public void deshabilitarVentana() {
		ventana.setFocusable(false);
		ventana.setEnabled(false);
		
	}

	@Override
	public void cerrar() {
		ventana.dispose();
		
	}

	@Override
	public void actionCerrar() {
		this.cerrarVentana(this, vino);
		
	}

}
