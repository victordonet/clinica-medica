package vista.ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import vista.controladores.CdorMantEsp;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;

public class FrmMantAdmin extends JFrame {

	private PanelConImagen jContentPane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private CdorMantEsp cdor;
	private JButton jButton21 = null;
	private JButton jButton211 = null;

	/**
	 * This is the default constructor
	 */
	public FrmMantAdmin(CdorMantEsp cdor) {
		super();
		this.cdor = cdor;
		initialize();
	
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(new Dimension(330, 349));
		this.setResizable(false);
		this.setTitle("Administrativos");
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
			jLabel.setBounds(new Rectangle(29, 11, 267, 21));
			jLabel.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 16));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("MANTENIMIENTO DE ADMINISTRATIVOS");
			jContentPane = new PanelConImagen("./fondos/imgMantMediana.JPG");
			jContentPane.setLayout(null);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton21(), null);
			jContentPane.add(getJButton211(), null);
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
			jButton1.setBounds(new Rectangle(60, 71, 204, 32));
			jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Alta");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Alta Administrativo");
					cdor.actionAltaEsp();
					
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
			jButton2.setBounds(new Rectangle(60, 124, 204, 32));
			jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Baja");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Baja Administrativo");
					System.out.println(cdor.toString());
					cdor.actionListarEsp();
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
	private JButton getJButton21() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setBounds(new Rectangle(60, 177, 204, 32));
			jButton21.setFont(new Font("Arial", Font.BOLD, 12));
			jButton21.setText("Modificación");
			jButton21.setBackground(Color.lightGray);
		}
		return jButton21;
	}

	/**
	 * This method initializes jButton211	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton211() {
		if (jButton211 == null) {
			jButton211 = new JButton();
			jButton211.setBounds(new Rectangle(60, 230, 204, 32));
			jButton211.setFont(new Font("Arial", Font.BOLD, 12));
			jButton211.setText("Modificación de Usuario");
			jButton211.setBackground(Color.lightGray);
		}
		return jButton211;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"