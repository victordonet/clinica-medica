package vista.controladores;

import java.util.Calendar;
import vista.ventanas.FrmFiltroListadoPorFechas;

public class CdorFiltroListFechas extends CdorManejoVentanas {

	private FrmFiltroListadoPorFechas ventana;
	private CdorManejoVentanas vino;
	private CdorManejoVentanas ventanaVoy;

	public CdorFiltroListFechas() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmFiltroListadoPorFechas(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionListar(Calendar fDesde, Calendar fHasta){
		CdorLiqSalarioMed cdor = new CdorLiqSalarioMed();
		cdor.setfDesde(fDesde);
		cdor.setfHasta(fHasta);
		this.cambioVentana(this, cdor);
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
}
