package vista.controladores;

import java.util.Calendar;

import vista.ventanas.FrmFiltroListadoPorFechas;

public class CdorFiltroListFechas extends CdorManejoVentanas {

	private FrmFiltroListadoPorFechas ventana;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;
	private Calendar fDesde, fHasta;

	public CdorFiltroListFechas() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmFiltroListadoPorFechas(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionListar(){
		this.cambioVentana(this, ventanaVoy);
	}
	
	public void habilitarVentana() {
		ventana.setEnabled(true);
		ventana.setFocusable(true);
		ventana.setFocusableWindowState(true);
	}

	public void cerrar() {
		ventana.dispose();
	}

	public void deshabilitarVentana() {
		ventana.setEnabled(false);
		ventana.setFocusable(false);
	}

	public FrmFiltroListadoPorFechas getVentana() {
		return ventana;
	}

	public void setVentana(FrmFiltroListadoPorFechas ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}

	public void setVentanaVoy(CdorManejoVentanas ventanaVoy) {
		this.ventanaVoy = ventanaVoy;
	}

	public CdorManejoVentanas getVentanaVoy() {
		return ventanaVoy;
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
