package vista.ventanas;

import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vista.controladores.CdorBajaConultorio;

public class FrmBajaConsultorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField jTextField2 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private CdorBajaConultorio cdor;
	private JComboBox jComboBox = null;

	/**
	 * This is the default constructor
	 */
	public FrmBajaConsultorio(CdorBajaConultorio cdorBajaConultorio) {
		super();
		this.cdor = cdorBajaConultorio;
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(new java.awt.Dimension(611,413));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		this.setResizable(false);
		this.setTitle("Consultaorios");
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cdor.actionCerrar();
			}
		});
	}

	/**
	 * This method initializes ContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private PanelConImagen getJContentPane() {
		if (jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(99,178,106,19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(207,13,200,33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Baja de Consultorio");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(99,150,106,19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro. Consultorio");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJComboBox(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox(cdor.cargarBox());
			jComboBox.setBounds(new Rectangle(221, 150, 50, 19));
			jComboBox.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField2.setText(cdor.getNombre(jComboBox.getSelectedIndex()));
				}
			});
		}
		return jComboBox;
	}
	
	/**
	 * This method initializes TextField2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new java.awt.Rectangle(221,178,292,19));
			jTextField2.setEditable(false);
		}
		return jTextField2;
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
			jButton1.setText("Cancelar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar Baja Consultorio.");
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
					System.out.println("Aceptar Baja Consultorio.");
					cdor.bajaConsultorio(jComboBox.getSelectedIndex());
				}
			});
		}
		return jButton2;
	}
}