package vista.ventanas;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import logica.observer.IObserver;
import vista.controladores.CdorReservaTurno;
import vista.controladores.ModeloTablaListConsDisp;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.table.TableRowSorter;

public class FrmReservaTurno extends UnicastRemoteObject implements IObserver{

	private static final long serialVersionUID = 1L;
	private JFrame frm = new JFrame();
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JComboBox jComboBox1 = null;
	private JComboBox jComboBox2 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	//private ModeloTablaListConsDisp modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private TableRowSorter<ModeloTablaListConsDisp> sorter;
	private CdorReservaTurno cdor;
	
	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmReservaTurno(CdorReservaTurno control)throws Throwable {
		//this.modelo = modelo;
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
			jLabel5.setText("Nro. turno");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(102, 305, 106, 19));
			jLabel6.setForeground(java.awt.Color.black);
			jLabel6.setText("Cobra timbre?");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJTextField(), null);
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
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(226, 305, 34, 19));
			jTextField.setEditable(false);
		}
		return jTextField;
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
					cdor.cargarMed(jComboBox1.getSelectedIndex());
					jComboBox2.setModel(cdor.cargarMed(jComboBox1.getSelectedIndex()));
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
					if(e.getSource()== jComboBox2){
						//tomo el contenido del texto ingresado en el jcombo
						String text = jComboBox2.getSelectedItem().toString();
						//si todavia no se eligio nada, que no haya ningun filtro
						if (text.length() == 0) {
							sorter.setRowFilter(null);
						} else {
							//se le agrega al sorter el filtro
							sorter.setRowFilter(RowFilter.regexFilter(text));
							// como es la columna 0, no es necesario ponerla
							//si quisiera que el filtro fuera en otra columna
							//si hay que aclarar en cual:
							// sorter.setRowFilter(RowFilter.regexFilter(text,1));
							//con esto logramos que el filtro se ejecute sobre la columna 2
						}
					}
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
			ModeloTablaListConsDisp modelo = cdor.listarConsultasDisp(jComboBox2.getSelectedIndex());
			jTable1 = new JTable(modelo);
			sorter = new TableRowSorter<ModeloTablaListConsDisp>(modelo);
			jTable1.setRowSorter(sorter);
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
			jButton1.setBounds(new java.awt.Rectangle(194,346,85,21));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Cancelar Reserva Turno.");
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
			jButton2.setText("Aceptar Reserva Turno.");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Aceptar Reserva de Turno.");
					/*Date fecha = calendar.getDate();
					Calendar fechaList = Calendar.getInstance();
					fechaList.setTime(fecha);
					cdor.actionReservar(jTextField1.getText(), jTextField2.getText(), jTextField.getText());*/
				}
			});
		}
		return jButton2;
	}
}
