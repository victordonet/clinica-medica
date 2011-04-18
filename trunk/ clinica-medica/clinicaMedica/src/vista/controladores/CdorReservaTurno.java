package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import excepciones.PersistenciaException;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoTurnosDisp;
import vista.ventanas.FrmReservaTurno;

public class CdorReservaTurno extends CdorManejoVentanas {
	
	private FrmReservaTurno ventana;
	private CdorManejoVentanas vino;
	private Vector<DataEsp> vEsp = null;
	private Vector<VoMedEsp> vMEsp = null;
	private Vector<VoTurnosDisp> vConsultas = null;

	public CdorReservaTurno() {
		super();
	}
	
	public FrmReservaTurno getVentana() {
		return ventana;
	}

	public void setVentana(FrmReservaTurno ventana) {
		this.ventana = ventana;
	}

	public void desplegarVentana(CdorManejoVentanas vino) {
		this.vino = vino;
		try {
			ventana = new FrmReservaTurno(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void habilitarVentana() {
		ventana.getVentana().setFocusable(true);
		ventana.getVentana().setEnabled(true);
		ventana.getVentana().setFocusableWindowState(true);
	}

	public void deshabilitarVentana() {
		ventana.getVentana().setFocusable(false);
		ventana.getVentana().setEnabled(false);
	}

	public void cerrar() {
		ventana.getVentana().dispose();
	}

	public void actionCerrar() {
		cerrarVentana(this, vino);
	}
	
	public DefaultComboBoxModel cargarEsp(){
		DefaultComboBoxModel boxModEsp = new DefaultComboBoxModel();
		try {
			vEsp = super.getMod().listarEspecialidades();
			for (int i = 0; i < vEsp.size(); i++) {
				boxModEsp.addElement(vEsp.get(i).getDescripcion());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return boxModEsp;
	}
	
	public DefaultComboBoxModel cargarMed(int selecEsp){
		int idEsp = vEsp.get(selecEsp).getCodigo();
		DefaultComboBoxModel boxModMed = new DefaultComboBoxModel();
		try {
			vMEsp = super.getMod().listarMedEsp(idEsp);
			for (int i = 0; i < vMEsp.size(); i++) {
				boxModMed.addElement(vMEsp.get(i).getNombre()+" "+vMEsp.get(i).getApellido());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		return boxModMed;
	}

	public ModeloTablaListConsDisp listarConsultasDisp(int selecMed){
		ModeloTablaListConsDisp modelo =null;
		String idMed = vMEsp.get(selecMed).getId();
		try {
			vConsultas = super.getMod().listarConsultasDisp(idMed);
			modelo = new ModeloTablaListConsDisp(vConsultas);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return modelo;
	}
	
	public boolean cobraTimbre(){
		boolean resultado = false;
		try {
			String idAfil =  super.getUsu().getIdUsu();
			resultado = super.getMod().cobraTimbre(idAfil);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void actionReservar(Calendar fecha,int dia, int horario, int idConsultorio, int selecMed) {
		try {
			String idMed = vMEsp.get(selecMed).getId();
			DataReservaTurno dataResTurno = new DataReservaTurno(fecha, dia, horario, super.getUsu().getIdUsu(), idConsultorio, idMed);
			super.getMod().altaConsulta(dataResTurno);
			JOptionPane.showMessageDialog(null, "Su reserva ha sido realizada con �xito.");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
		cerrarVentana(this, vino);
	}

	public Vector<DataEsp> getvEsp() {
		return vEsp;
	}

	public void setvEsp(Vector<DataEsp> vEsp) {
		this.vEsp = vEsp;
	}
	
	public Vector<VoMedEsp> getvMEsp() {
		return vMEsp;
	}

	public void setvMEsp(Vector<VoMedEsp> vMEsp) {
		this.vMEsp = vMEsp;
	}

	public Vector<VoTurnosDisp> getvConsultas() {
		return vConsultas;
	}

	public void setvConsultas(Vector<VoTurnosDisp> vConsultas) {
		this.vConsultas = vConsultas;
	}
}