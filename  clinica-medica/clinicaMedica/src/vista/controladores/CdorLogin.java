package vista.controladores;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import excepciones.LogicaException;
import excepciones.PersistenciaException;
import logica.fachada.ProxyFachadaLogica;
import vista.ventanas.FrmLogin;

public class CdorLogin extends CdorManejoVentanas {
	
	private FrmLogin ventana;
	private ProxyFachadaLogica mod;
	
	public CdorLogin() {
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
	
	public void ingresar(String usu, String pass){
		boolean usuOk = false;
	    if (usu.trim()=="" || pass.trim()==""){
	    	String msg = "Debe cargar todos los campos solicitados.";
	    	JOptionPane.showMessageDialog(null,msg);
	    }else {
			try {
				usuOk = mod.validarUsuario(usu, pass);
				if(usuOk){
					String tipo = mod.getTipo(usu);
					if (tipo.equals("ME")){
						//new CdorMenuMed();
					}else {
						if (tipo.equals("AF")){
							//new CdorMenuAfil();							
						}else {
							if (tipo.equals("AD")){
								//new CdorMenuAdmin();
							}
						}
					}
					actionCerrar();
				} else {
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
			}
	    }
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

	public void desplegarVentana(CdorManejoVentanas vino) {
		//No aplica, es la primera ventana que se despliega.
	}

	public void actionCerrar() {
		ventana.dispose();
	}
}
