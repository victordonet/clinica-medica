package vista.ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import vista.controladores.CdorMantListadosAdmin;

public class FrmMantListadosAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private CdorMantListadosAdmin cdor;
	private JButton jButton21 = null;
	private JButton jButton211 = null;

	/**
	 * This is the default constructor
	 */
	public FrmMantListadosAdmin(CdorMantListadosAdmin cdorMantListadosAdmin) {
		super();
		this.cdor = cdorMantListadosAdmin;
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
		this.setTitle("Listados");
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
			jLabel.setBounds(new Rectangle(126, 7, 68, 21));
			jLabel.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 16));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("LISTADOS");
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
			jButton1.setBounds(new Rectangle(58, 72, 204, 32));
			jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Listar Afiliados");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Listar Afiliados");
					cdor.actionListarAfil();
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
			jButton2.setBounds(new Rectangle(58, 125, 204, 32));
			jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Listar Médicos");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Listar Médicos");
					System.out.println(cdor.toString());
					cdor.actionListarMed();
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
			jButton21.setBounds(new Rectangle(58, 178, 204, 32));
			jButton21.setFont(new Font("Arial", Font.BOLD, 12));
			jButton21.setText("Detalle Afiliado");
			jButton21.setBackground(Color.lightGray);
			jButton21.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Detalle Afiliado");
					System.out.println(cdor.toString());
					cdor.actionDetalleAfil();
				}
			});
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
			jButton211.setBounds(new Rectangle(58, 231, 204, 32));
			jButton211.setFont(new Font("Arial", Font.BOLD, 12));
			jButton211.setText("Listado de Consultas");
			jButton211.setBackground(Color.lightGray);
			jButton211.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Listado de Consultas");
					System.out.println(cdor.toString());
					cdor.actionListarConsultas();
				}
			});
		}
		return jButton211;
	}
}