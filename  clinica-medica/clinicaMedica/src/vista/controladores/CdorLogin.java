package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataUsu;
import vista.ventanas.FrmLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class CdorLogin extends CdorManejoVentanas {
	
	private FrmLogin ventana;
	private CdorManejoVentanas vino;
	Calendar fechaHoy;
	
	public void desplegarVentana(CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmLogin(this);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al administrador");
		
		}
	}
	
	public CdorLogin() {
		fechaHoy = Calendar.getInstance();
		//fechaHoy.setTime(Calendar.getInstance().getTime());
		try {
			super.setMod(new ProxyFachadaLogica());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			System.exit(0);
	
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			System.exit(0);
		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			System.exit(0);
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
	    				JOptionPane.showMessageDialog(new JPanel(),"Bienvenido !!! " +
	    						"Dr. "+super.getMod().getDataMedico(usu).getNombre()+" "+super.getMod().getDataMedico(usu).getApellido()+" "+
	    								fechaHoy.get(Calendar.DATE)+"/"+(fechaHoy.get(Calendar.MONTH)+1)+"/"+fechaHoy.get(Calendar.YEAR));
	    				
	    			}else {
	    				if (tipo.equals("AF")){
	    					CdorMenuAfil cdorMenu = new CdorMenuAfil();
		    				DataUsu dUsu = new DataUsu(usu, tipo);
		    				this.setUsu(dUsu);
		    				cdorMenu.setUsu(dUsu);
	    					this.cambioVentana(this, cdorMenu);
	    					JOptionPane.showMessageDialog(new JPanel(),"Bienvenido !!! " +
		    						super.getMod().getDataAfiliado(usu).getNombre()+" "+super.getMod().getDataAfiliado(usu).getApellido()+" "+
		    								fechaHoy.get(Calendar.DATE)+"/"+(fechaHoy.get(Calendar.MONTH)+1)+"/"+fechaHoy.get(Calendar.YEAR));
	    				}else {
	    					if (tipo.equals("AD")){
	    						CdorMenuAdmin cdorMenu = new CdorMenuAdmin();
    		    				DataUsu dUsu = new DataUsu(usu, tipo);
    		    				this.setUsu(dUsu);
    		    				cdorMenu.setUsu(dUsu);
	    						this.cambioVentana(this, cdorMenu);
	    						JOptionPane.showMessageDialog(new JPanel(),"Bienvenido !!! " +
	    	    						super.getMod().getDataAdmin(usu).getNombre()+" "+
	    	    								fechaHoy.get(Calendar.DATE)+"/"+(fechaHoy.get(Calendar.MONTH)+1)+"/"+fechaHoy.get(Calendar.YEAR));
	    					}else{
	    						if (tipo.equals("GE")){
	    							CdorMenuGerente cdorMenu = new CdorMenuGerente();
	    		    				DataUsu dUsu = new DataUsu(usu, tipo);
	    		    				this.setUsu(dUsu);
	    		    				cdorMenu.setUsu(dUsu);
	    							this.cambioVentana(this, cdorMenu);
	    							JOptionPane.showMessageDialog(new JPanel(),"Bienvenido !!! " +
		    	    						super.getMod().getDataAdmin(usu).getNombre()+" "+
		    	    								fechaHoy.get(Calendar.DATE)+"/"+(fechaHoy.get(Calendar.MONTH)+1)+"/"+fechaHoy.get(Calendar.YEAR));
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
