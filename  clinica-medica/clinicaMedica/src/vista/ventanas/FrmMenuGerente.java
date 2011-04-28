package vista.ventanas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logica.observer.IObserver;
import vista.controladores.CdorMenuGerente;
import vista.controladores.ModeloTablaListConsultas;

public class FrmMenuGerente extends UnicastRemoteObject implements IObserver{

	private static final long serialVersionUID = 1L;
	private JFrame frm = new JFrame();  
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private ModeloTablaListConsultas modelo = null;
	private CdorMenuGerente cdor;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	
	/**
	 * This is the default constructor
	 * @throws Throwable 
	 */
	public FrmMenuGerente(CdorMenuGerente control)throws Throwable {
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
		frm.setSize(new Dimension(411, 686));
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		frm.setResizable(false);
		frm.setTitle("Menu");
		frm.setContentPane(getJContentPane());
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);		
		frm.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cdor.actionCerrar();
			}
		});		
	}

	public void frmDisable(){
		frm.setEnabled(false);
	}

	public void frmEnable(){
		frm.setEnabled(true);
		frm.setVisible(true);
		frm.setFocusable(true);
	}
	

	
	/**
	 * This method initializes ContentPane
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws ClassNotFoundException 
	 * @throws Throwable 
	 */
	private PanelConImagen getJContentPane() throws Throwable, ClassNotFoundException {
	
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(35, 18, 210, 24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("MENU PRINCIPAL");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 24));
			jContentPane = new PanelConImagen("./fondos/imgMenuGA.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getjButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
			jContentPane.add(getJButton5(), null);
			jContentPane.add(getJButton6(), null);
			jContentPane.add(getJButton7(), null);
			jContentPane.add(getJScrollPane(), null);
	
		return jContentPane;
	}

	public void update() throws RemoteException {
		modelo = cdor.listarConsultas();
		jTable.setModel(modelo);
		jTable.setVisible(true);

	}

	public JFrame getVentana(){
		return frm;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(108, 88, 200, 30));
			jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Afiliados");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionMantAfil();
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getjButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(108, 135, 200, 30));
			jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Médicos");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionMantMed();
				}
			});
		}
		return jButton2;
	}
	
	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(108, 184, 200, 30));
			jButton3.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton3.setBackground(java.awt.Color.lightGray);
			jButton3.setText("Administrativos");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionMantAdmin();
				}
			});
		}
		return jButton3;
	}
	
	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(108, 232, 200, 30));
			jButton4.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton4.setBackground(java.awt.Color.lightGray);
			jButton4.setText("Exámenes");
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionMantExamenes();
				}
			});
		}
		return jButton4;
	}
	
	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(108, 280, 200, 30));
			jButton5.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton5.setBackground(java.awt.Color.lightGray);
			jButton5.setText("Consultorios");
			jButton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionMantConsultorios();
				}
			});
		}
		return jButton5;
	}
	
	/**
	 * This method initializes jButton6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(108, 328, 200, 30));
			jButton6.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton6.setBackground(java.awt.Color.lightGray);
			jButton6.setText("Especialidades");
			jButton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionMantEsp();
				}
			});
		}
		return jButton6;
	}
	
	/**
	 * This method initializes jButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(108, 376, 200, 30));
			jButton7.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton7.setBackground(java.awt.Color.lightGray);
			jButton7.setText("Listados");
			jButton7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionListados();
				}
			});
		}
		return jButton7;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
	
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(90, 440, 245, 155));
			jScrollPane.setViewportView(getJTable());
	
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
			
		modelo = cdor.listarConsultas();
		jTable = new JTable(modelo);
	
		return jTable;
	}
} 
