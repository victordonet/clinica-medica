package vista.controladores;

import vista.ventanas.FrmMantListadosGerente;

public class CdorMantListadosGerente extends CdorManejoVentanas {

	private FrmMantListadosGerente ventana;
	private CdorManejoVentanas vino;

	public CdorMantListadosGerente() {}

	public void desplegarVentana (CdorManejoVentanas vino){
		this.vino = vino;
		try {
			ventana = new FrmMantListadosGerente(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actionListarAfil(){	
		this.cambioVentana(this, new CdorListadoAfil());
	}
	
	public void actionListarMed(){
		this.cambioVentana(this, new CdorListadoMed()); 
	}
	
	public void actionDetalleAfil(){
		CdorSelectAfi cdorSelec = new CdorSelectAfi();
		cdorSelec.setVentanaVoy(new CdorListadoDetalleAfiliado());
		this.cambioVentana(this, cdorSelec);
	}
	
	public void actionListarConsultas(){	
		this.cambioVentana(this, new CdorFiltroListFecha());
	}
	
	public void actionLiqSalarios(){
		CdorFiltroListFechas cdorFiltroFechas = new CdorFiltroListFechas();
		cdorFiltroFechas.setVentanaVoy(new CdorLiqSalarioMed());
		this.cambioVentana(this, cdorFiltroFechas); 
	}
	
	public void actionMedPremiado(){
		CdorFiltroListFechas cdorFiltroFechas = new CdorFiltroListFechas();
		cdorFiltroFechas.setVentanaVoy(new CdorListMedPremiado());
		this.cambioVentana(this, cdorFiltroFechas); 
	}
	
	public void actionResumentCont(){
		CdorFiltroListFechas cdorFiltroFechas = new CdorFiltroListFechas();
		cdorFiltroFechas.setVentanaVoy(new CdorListResumenCont());
		this.cambioVentana(this, cdorFiltroFechas);
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

	public FrmMantListadosGerente getVentana() {
		return ventana;
	}

	public void setVentana(FrmMantListadosGerente ventana) {
		this.ventana = ventana;
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
}
