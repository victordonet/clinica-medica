package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import excepciones.PersistenciaException;

import vista.dataobjet.DataConsAfi;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoTurnosDisp;
import vista.ventanas.FrmReservaTurno;

public class CdorReservaTurno extends CdorManejoVentanas {
	
	private FrmReservaTurno ventana;
	//private ModeloTablaListConsDisp modelo = null;
	private CdorManejoVentanas vino;
	private Vector<DataEsp> vEsp = null;
	private Vector<VoMedEsp> vMEsp = null;
	
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
			Vector<VoTurnosDisp> vec = super.getMod().listarConsultasDisp(idMed);
			System.out.println(vec.toString());
			modelo = new ModeloTablaListConsDisp(vec);
			System.out.println(modelo.toString());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexion con el server");
			e.printStackTrace();
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
			e.printStackTrace();
		}
		return modelo;
	}
	
	public void actionReservar(Calendar fecha,int dia, int horario, int idConsultorio,String idMedico) {
		try {
			DataReservaTurno dataResTurno = new DataReservaTurno(fecha, dia, horario, super.getUsu().getIdUsu(), idConsultorio, idMedico);
			super.getMod().altaConsulta(dataResTurno);
			JOptionPane.showMessageDialog(null, "Su reserva ha sido realizada con éxito.");
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
}
