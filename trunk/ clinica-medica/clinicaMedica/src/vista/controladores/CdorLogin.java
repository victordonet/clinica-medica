package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.ventanas.FrmLogin;
import vista.ventanas.FrmMenuAdmin;
import vista.ventanas.FrmMenuAfil;
import vista.ventanas.FrmMenuGerente;
import vista.ventanas.FrmMenuMed;

public class CdorLogin extends CdorManejoVentanas {
	
	private FrmLogin ventana;
	//private ProxyFachadaLogica mod = (ProxyFachadaLogica) super.getMod();
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
	    				cdorMenu.desplegarVentana(cdorMenu);
	    			}else {
	    				if (tipo.equals("AF")){
	    					CdorMenuAfil cdorMenu = new CdorMenuAfil();
	    					cdorMenu.desplegarVentana(cdorMenu);						
	    				}else {
	    					if (tipo.equals("AD")){
	    						CdorMenuAdmin cdorMenu = new CdorMenuAdmin();
	    						cdorMenu.desplegarVentana(cdorMenu);
	    					}else{
	    						if (tipo.equals("GE")){
	    							CdorMenuGerente cdorMenu = new CdorMenuGerente();
	    							this.cambioVentana(this, cdorMenu);
	    							//cdorMenu.desplegarVentana(cdorMenu);
	    						}
	    					}
	    				}
	    			}
	    			//actionCerrar();
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
