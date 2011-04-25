package vista.controladores;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataUsu;
import vista.ventanas.FrmLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class CdorLogin extends CdorManejoVentanas {
	
	private FrmLogin ventana;
	private CdorManejoVentanas vino;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmLogin(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
		}
	}
	
	public CdorLogin() {
		try {
			super.setMod(new ProxyFachadaLogica());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
	
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
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
	    				DataUsu dUsu = new DataUsu(usu, tipo);
	    				this.setUsu(dUsu);
	    				cdorMenu.setUsu(dUsu);
	    				this.cambioVentana(this, cdorMenu);
	    			}else {
	    				if (tipo.equals("AF")){
	    					CdorMenuAfil cdorMenu = new CdorMenuAfil();
		    				DataUsu dUsu = new DataUsu(usu, tipo);
		    				this.setUsu(dUsu);
		    				cdorMenu.setUsu(dUsu);
	    					this.cambioVentana(this, cdorMenu);						
	    				}else {
	    					if (tipo.equals("AD")){
	    						CdorMenuAdmin cdorMenu = new CdorMenuAdmin();
    		    				DataUsu dUsu = new DataUsu(usu, tipo);
    		    				this.setUsu(dUsu);
    		    				cdorMenu.setUsu(dUsu);
	    						this.cambioVentana(this, cdorMenu);
	    					}else{
	    						if (tipo.equals("GE")){
	    							CdorMenuGerente cdorMenu = new CdorMenuGerente();
	    		    				DataUsu dUsu = new DataUsu(usu, tipo);
	    		    				this.setUsu(dUsu);
	    		    				cdorMenu.setUsu(dUsu);
	    							this.cambioVentana(this, cdorMenu);
	    						}
	    					}
	    				}
	    			}
	    		}else {
    				String msg = "Usuario o Contraseña invalido.";
    				JOptionPane.showMessageDialog(null,msg);
	    		}
	    	} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null,"Error de conexion con el server");
		
			} catch (PersistenciaException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
				
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
		cerrar();
	}
}
