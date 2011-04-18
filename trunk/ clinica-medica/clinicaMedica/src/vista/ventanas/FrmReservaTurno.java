package vista.ventanas;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import logica.observer.IObserver;
import vista.controladores.CdorReservaTurno;
import vista.controladores.ModeloTablaListConsDisp;
import java.awt.Dimension;
import javax.swing.JButton;

public class FrmReservaTurno extends UnicastRemoteObject implements IObserver{

	private static final long serialVersionUID = 1L;
	private JFrame frm = new JFrame();
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JComboBox jComboBox1 = null;
	private JComboBox jComboBox2 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorReservaTurno cdor;
	
	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmReservaTurno(CdorReservaTurno control)throws Throwable {
		cdor = control;
		initialize();
	}

	/**
	 * This method initializes frm
	 *
	 * @return void
	 * @throws Throwable
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, Throwable {
		frm.setSize(new Dimension(611,413));
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		frm.setResizable(false);
		frm.setTitle("Reservas");
		frm.setContentPane(getJContentPane());
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		frm.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cdor.actionCerrar();
			}
		});
	}

	/**
	 * This method initializes ContentPane
	 *
	 * @return javax.swing.JPanel
	 * @throws ClassNotFoundException
	 * @throws Throwable
	 */
	private PanelConImagen getJContentPane() throws Throwable, ClassNotFoundException {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(180, 20, 257, 18));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("Reserva de Turno");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 24));
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(102, 130, 106, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Médico");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(102, 101, 106, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Especialidad");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(102, 73, 106, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro. Afiliado");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(102, 276, 106, 19));
			jLabel5.setForeground(java.awt.Color.black);
			jLabel5.setText("Cobra timbre?");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJComboBox1(), null);
			jContentPane.add(getJComboBox2(), null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	public void update() throws RemoteException {
		try {
			initialize();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes TextField1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(226, 73, 86, 19));
			jTextField1.setEditable(false);
			jTextField1.setText(cdor.getUsu().getIdUsu());
		}
		return jTextField1;
	}

	/**
	 * This method initializes TextField2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(226, 276, 34, 19));
			jTextField2.setEditable(false);
			boolean timbre = cdor.cobraTimbre();
			if (timbre){
				jTextField2.setText("S");
			}else{
				jTextField2.setText("N");
			}
		}
		return jTextField2;
	}

	/**
	 * This method initializes jComboBox1
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox(cdor.cargarEsp());
			jComboBox1.setBounds(new Rectangle(226, 101, 137, 19));
			jComboBox1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jComboBox2.setModel(cdor.cargarMed(jComboBox1.getSelectedIndex()));
					getJTable1().setVisible(false);
				}
			});
		}
		return jComboBox1;
	}

	/**
	 * This method initializes jComboBox2
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
			jComboBox2.setBounds(new Rectangle(226, 130, 137, 19));
			jComboBox2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ModeloTablaListConsDisp modelo = cdor.listarConsultasDisp(jComboBox2.getSelectedIndex());
					getJTable1().setVisible(true);
					getJTable1().setModel(modelo);
					getJTable1().setSelectionMode(0);
					ListSelectionModel selectionModel = getJTable1().getSelectionModel();
					selectionModel.setSelectionInterval(0, 0);
				}
			});
		}
		return jComboBox2;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(149, 165, 346, 96));
			jScrollPane.setViewportView(getJTable1());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable();
			jTable1.setBounds(new Rectangle(149, 165, 346, 96));
		}
		return jTable1;
	}
	
	public JFrame getVentana(){
		return frm;
	}

	/**
	 * This method initializes Button1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new java.awt.Rectangle(194,346,79,21));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Cancelar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar Reserva de Turno.");
					cdor.actionCerrar();
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes Button2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new java.awt.Rectangle(308,346,79,21));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Aceptar");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Aceptar Reserva de Turno.");
					Calendar fecha = cdor.getvConsultas().get(jTable1.getSelectedRow()).getFecha();
					int dia = cdor.getvConsultas().get(jTable1.getSelectedRow()).getDia();
					int horario = cdor.getvConsultas().get(jTable1.getSelectedRow()).getHorario();
					int idConsultorio = cdor.getvConsultas().get(jTable1.getSelectedRow()).getIdConsultorio();
					cdor.actionReservar(fecha, dia, horario, idConsultorio, jComboBox2.getSelectedIndex());
				}
			});
		}
		return jButton2;
	}
}
