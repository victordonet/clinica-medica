package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.ventanas.FrmLogin;

public class CdorLogin extends CdorManejoVentanas {
	
	private FrmLogin ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmLogin(this);
		} catch (Throwable e) {

			e.printStackTrace();
		}
	}
	
	public CdorLogin() {
		try {
			super.setMod(new ProxyFachadaLogica());
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
	
	public void ingresar(String usu, String pass){
		boolean usuOk = false;
	    if (usu.trim()=="" || pass.trim()==""){
	    	String msg = "Debe cargar todos los campos solicitados.";
	    	JOptionPane.showMessageDialog(null,msg);
	    }else {
	    	try {
	    		usuOk = super.getMod().validarUsuario(usu, pass);
	    		if(usuOk){
	    			String tipo = super.getMod().getTipo(usu);
	    			if (tipo.equals("ME")){
	    				CdorMenuMed cdorMenu = new CdorMenuMed();
	    				this.cambioVentana(this, cdorMenu);
	    			}else {
	    				if (tipo.equals("AF")){
	    					CdorMenuAfil cdorMenu = new CdorMenuAfil();
	    					this.cambioVentana(this, cdorMenu);						
	    				}else {
	    					if (tipo.equals("AD")){
	    						CdorMenuAdmin cdorMenu = new CdorMenuAdmin();
	    						this.cambioVentana(this, cdorMenu);
	    					}else{
	    						if (tipo.equals("GE")){
	    							CdorMenuGerente cdorMenu = new CdorMenuGerente();
	    							this.cambioVentana(this, cdorMenu);
	    						}
	    					}
	    				}
	    			}
	    		}else {
    				String msg = "Usuario o Contraseña invalido.";
    				JOptionPane.showMessageDialog(null,msg);
	    		}
			} catch (PersistenciaException e) {
				String msg = "No se pudo acceder a la información almacenada.";
				JOptionPane.showMessageDialog(null,msg);
				e.printStackTrace();
			} catch (RemoteException e) {
				String msg = "No se pudo acceder al servidor.";
				JOptionPane.showMessageDialog(null,msg);
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
	    }
	}

	public void habilitarVentana() {
		ventana.setFocusable(true);
		ventana.setEnabled(true);
		ventana.setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		actionCerrar();
	}
	public void cerrar() {
		ventana.dispose();
	}

	public void actionCerrar() {
		ventana.dispose();
	}
}
