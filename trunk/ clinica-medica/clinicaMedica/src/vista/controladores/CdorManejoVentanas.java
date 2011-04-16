package vista.controladores;

import javax.swing.JOptionPane;

import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public abstract class CdorManejoVentanas {

	private IfachadaLogica mod;
	private CdorManejoVentanas vengo= null;
	private CdorManejoVentanas voy = null;

	public CdorManejoVentanas() {}	
	public abstract void desplegarVentana(CdorManejoVentanas vino);
	public abstract void habilitarVentana();
	public abstract void deshabilitarVentana();
	public abstract void cerrar();
	public abstract void actionCerrar();

	public final void cambioVentana(CdorManejoVentanas vengo, CdorManejoVentanas voy){
		this.voy=voy;
		voy.setMod(vengo.getMod());
		voy.desplegarVentana(vengo);
		vengo.deshabilitarVentana();
	}
	
	public final void cerrarVentana(CdorManejoVentanas vengo, CdorManejoVentanas voy) {
		voy.setMod(vengo.getMod());
		voy.habilitarVentana();
		System.out.println("En el manejador de ventana = "+vengo.toString());
		vengo.cerrar();
	}
	
	public IfachadaLogica getMod() {
		return mod;
	}

	public void setMod(IfachadaLogica mod) {
		this.mod = mod;
	}

	public CdorManejoVentanas getVengo() {
		return vengo;
	}

	public void setVengo(CdorManejoVentanas vengo) {
		this.vengo = vengo;
	}

	public CdorManejoVentanas getVoy() {
		return voy;
	}

	public void setVoy(CdorManejoVentanas voy) {
		this.voy = voy;
	}
}

