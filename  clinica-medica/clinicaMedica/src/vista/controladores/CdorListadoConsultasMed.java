package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;
import javax.swing.JOptionPane;
import vista.dataobjet.DataConsFecha;
import vista.ventanas.FrmListadoConsultasMed;
import excepciones.PersistenciaException;

public class CdorListadoConsultasMed extends CdorManejoVentanas{

	private FrmListadoConsultasMed ventana;
	private ModeloTablaListadoConsultasMed modelo = null;
	private CdorManejoVentanas vino;

	public CdorListadoConsultasMed(){
		super();
	}
	
	public void desplegarVentana (CdorManejoVentanas vino){
			this.vino = vino;
		try {
			ventana = new FrmListadoConsultasMed(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public FrmListadoConsultasMed getVentana() {
		return ventana;
	}

	public void setVentana(FrmListadoConsultasMed ventana) {
		this.ventana = ventana;
	}

	public ModeloTablaListadoConsultasMed listarConsultas(){
		ModeloTablaListadoConsultasMed modelo =null;
		try {
			Vector<DataConsFecha> vec = super.getMod().listarConsFechasMed(vino.getfDesde(), vino.getfHasta(), super.getUsu().getIdUsu());
			modelo = new ModeloTablaListadoConsultasMed(vec);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return modelo;

	}
	public void cerrar() {
		ventana.dispose();

	}
	public void habilitarVentana(){
		ventana.setFocusable(true);
		ventana.setEnabled(true);
		ventana.setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.setFocusable(false);
		ventana.setEnabled(false);
	}

	public void actionCerrar(){
		cerrarVentana(this, vino);
	}
}
