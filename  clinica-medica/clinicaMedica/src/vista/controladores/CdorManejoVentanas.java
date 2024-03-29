package vista.controladores;

import java.util.Calendar;

import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataUsu;

public abstract class CdorManejoVentanas {

	private ProxyFachadaLogica mod;
	private CdorManejoVentanas vengo= null;
	private CdorManejoVentanas voy = null;
	private DataUsu usu;
	private String id;
	private Calendar fDesde, fHasta;

	public CdorManejoVentanas() {}	
	public abstract void desplegarVentana(CdorManejoVentanas vino);
	public abstract void habilitarVentana();
	public abstract void deshabilitarVentana();
	public abstract void cerrar();
	public abstract void actionCerrar();

	public final void cambioVentana(CdorManejoVentanas vengo, CdorManejoVentanas voy){
		this.voy=voy;
		voy.setMod(vengo.getMod());
		voy.setUsu(vengo.getUsu());
		voy.setId(vengo.getId());
		voy.desplegarVentana(vengo);
		vengo.deshabilitarVentana();
	}
	
	public final void cerrarVentana(CdorManejoVentanas vengo, CdorManejoVentanas voy) {
		voy.setMod(vengo.getMod());
		voy.setUsu(vengo.getUsu());
		voy.setId(vengo.getId());
		voy.habilitarVentana();
		vengo.cerrar();
	}
	
	public ProxyFachadaLogica getMod() {
		return mod;
	}

	public void setMod(ProxyFachadaLogica mod) {
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
	
	public DataUsu getUsu() {
		return usu;
	}
	
	public void setUsu(DataUsu usu) {
		this.usu = usu;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Calendar getfDesde() {
		return fDesde;
	}
	
	public void setfDesde(Calendar fDesde) {
		this.fDesde = fDesde;
	}
	
	public Calendar getfHasta() {
		return fHasta;
	}
	
	public void setfHasta(Calendar fHasta) {
		this.fHasta = fHasta;
	}
}