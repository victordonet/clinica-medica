package vista.controladores;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import vista.dataobjet.DataEsp;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoTurnosDisp;
import vista.ventanas.FrmReservaTurno;
import excepciones.PersistenciaException;

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
			super.getMod().addObsReservaTurno(ventana);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Error interno del sistema. Por favor contacte al admnistrador.");
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
		try {
			super.getMod().remObsRservaTurno(ventana);
			ventana.getVentana().dispose();
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
	
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
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
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
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
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
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return modelo;
	}
	
	public boolean cobraTimbre(){
		boolean resultado = false;
		try {
			String idAfil =  super.getUsu().getIdUsu();
			resultado = super.getMod().cobraTimbre(idAfil);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return resultado;
	}
	
	public void actionReservar(Calendar fecha,String diaSem, String horario, int idConsultorio, int turno, int selecMed) {
		try {
			int dia = 0;
			if(diaSem.equals("Domingo")) {
				dia = 1;}
			if(diaSem.equals("Lunes")) {
				dia = 2;}
			if(diaSem.equals("Martes")) {
				dia = 3;}
			if(diaSem.equals("Miércoles")) {
				dia = 4;}
			if(diaSem.equals("Jueves")) {
				dia = 5;}
			if(diaSem.equals("Viernes")) {
				dia = 6;}
			if(diaSem.equals("Sábado")) {
				dia = 7;}
			int hora = 0;
			if(horario.equals("00 a 02")) {
				hora = 1;}
			if(horario.equals("02 a 04")) {
				hora = 2;}
			if(horario.equals("04 a 06")) {
				hora = 3;}
			if(horario.equals("06 a 08")) {
				hora = 4;}
			if(horario.equals("08 a 10")) {
				hora = 5;}
			if(horario.equals("10 a 12")) {
				hora = 6;}
			if(horario.equals("12 a 14")) {
				hora = 7;}
			if(horario.equals("14 a 16")) {
				hora = 8;}
			if(horario.equals("16 a 18")) {
				hora = 9;}
			if(horario.equals("18 a 20")) {
				hora = 10;}
			if(horario.equals("20 a 22")) {
				hora = 11;}
			if(horario.equals("22 a 24")) {
				hora = 12;}
			String idMed = vMEsp.get(selecMed).getId();
			DataReservaTurno dataResTurno = new DataReservaTurno(fecha, dia, hora, super.getUsu().getIdUsu(), idConsultorio, idMed, turno);
			super.getMod().altaConsulta(dataResTurno);
			JOptionPane.showMessageDialog(null, "Su reserva ha sido realizada con éxito.");
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null,"Error de conexión con el server.");
		} catch (PersistenciaException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
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