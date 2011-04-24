package vista.ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import vista.controladores.CdorMantMedico;

public class FrmMantMedicos extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private CdorMantMedico cdor;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;

	/**
	 * This is the default constructor
	 */
	public FrmMantMedicos(CdorMantMedico cdorMantMedico) {
		super();
		this.cdor = cdorMantMedico;
		initialize();

	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(new Dimension(330, 349));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		this.setResizable(false);
		this.setTitle("Médicos");
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
			cdor.actionCerrar();
			}
		});
	}

	protected void frmDisable(){
		this.setEnabled(false);
	}

	protected void frmEnable(){
		this.setEnabled(true);
		this.setVisible(true);
	}

	/**
	 * This method initializes ContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private PanelConImagen getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(59, 7, 204, 21));
			jLabel.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 16));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("MANTENIMIENTO DE MÉDICOS");
			jContentPane = new PanelConImagen("./fondos/imgMantGrande.JPG");
			jContentPane.setLayout(null);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
			jContentPane.add(getJButton5(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes Button1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(59, 51, 204, 32));
			jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Alta");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Alta Medicos");
					cdor.actionAltaMed();
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
			jButton2.setBounds(new Rectangle(59, 101, 204, 32));
			jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Baja");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Baja Médicos");
					System.out.println(cdor.toString());
					cdor.actionBajaMed();
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton21
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(59, 151, 204, 32));
			jButton3.setFont(new Font("Arial", Font.BOLD, 12));
			jButton3.setText("Modificación");
			jButton3.setBackground(Color.lightGray);
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Modificación Medicos");
					cdor.actionModifMed();
				}
			});
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton211
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(59, 201, 204, 32));
			jButton4.setFont(new Font("Arial", Font.BOLD, 12));
			jButton4.setText("Disponibilidad");
			jButton4.setBackground(Color.lightGray);
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Disponibilidad");
					cdor.actionDisponibilidad();
				}
			});
		}
		return jButton4;
	}

	/**
	 * This method initializes jButton2111
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(59, 251, 204, 32));
			jButton5.setFont(new Font("Arial", Font.BOLD, 12));
			jButton5.setText("Modificación de Usuario");
			jButton5.setBackground(Color.lightGray);
			jButton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Modificación Usuario");
					cdor.actionModifPass();
				}
			});
		}
		return jButton5;
	}
}