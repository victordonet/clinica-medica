package vista.ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import vista.controladores.CdorMantListadosGerente;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class FrmMantListadosGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private CdorMantListadosGerente cdor;
	private JButton jButton21 = null;
	private JButton jButton211 = null;
	private JButton jButton2111 = null;
	private JButton jButton21111 = null;
	private JButton jButton211111 = null;

	/**
	 * This is the default constructor
	 */
	public FrmMantListadosGerente(CdorMantListadosGerente cdorMantListadosGerente) {
		super();
		this.cdor = cdorMantListadosGerente;
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(new Dimension(330, 406));
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
			jLabel.setBounds(new Rectangle(129, 6, 69, 21));
			jLabel.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 16));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("LISTADOS");
			jContentPane = new PanelConImagen("./fondos/imgMantLarga.JPG");
			jContentPane.setLayout(null);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton21(), null);
			jContentPane.add(getJButton211(), null);
			jContentPane.add(getJButton2111(), null);
			jContentPane.add(getJButton21111(), null);
			jContentPane.add(getJButton211111(), null);
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
			jButton1.setBounds(new Rectangle(59, 46, 204, 32));
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
			jButton2.setBounds(new Rectangle(59, 89, 204, 32));
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
			jButton21.setBounds(new Rectangle(59, 132, 204, 32));
			jButton21.setFont(new Font("Arial", Font.BOLD, 12));
			jButton21.setText("Detalle Afiliado");
			jButton21.setBackground(Color.lightGray);
			jButton21.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Detalle Afiliado");
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
			jButton211.setBounds(new Rectangle(59, 175, 204, 32));
			jButton211.setFont(new Font("Arial", Font.BOLD, 12));
			jButton211.setText("Listado de Consultas");
			jButton211.setBackground(Color.lightGray);
			jButton211.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Listado de Consultas");
					cdor.actionListarConsultas();
				}
			});
		}
		return jButton211;
	}

	/**
	 * This method initializes jButton2111
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2111() {
		if (jButton2111 == null) {
			jButton2111 = new JButton();
			jButton2111.setBounds(new Rectangle(59, 218, 204, 32));
			jButton2111.setFont(new Font("Arial", Font.BOLD, 12));
			jButton2111.setText("Liquidación de Salarios");
			jButton2111.setBackground(Color.lightGray);
			jButton2111.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Liquidación de Salarios");
					cdor.actionLiqSalarios();
				}
			});
		}
		return jButton2111;
	}

	/**
	 * This method initializes jButton21111
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton21111() {
		if (jButton21111 == null) {
			jButton21111 = new JButton();
			jButton21111.setBounds(new Rectangle(59, 261, 204, 32));
			jButton21111.setFont(new Font("Arial", Font.BOLD, 12));
			jButton21111.setText("Medico Premiado");
			jButton21111.setBackground(Color.lightGray);
			jButton21111.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Medico Premiado");
					cdor.actionMedPremiado();
				}
			});
		}
		return jButton21111;
	}

	/**
	 * This method initializes jButton211111
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton211111() {
		if (jButton211111 == null) {
			jButton211111 = new JButton();
			jButton211111.setBounds(new Rectangle(59, 304, 204, 32));
			jButton211111.setFont(new Font("Arial", Font.BOLD, 12));
			jButton211111.setText("Resumen Contable");
			jButton211111.setBackground(Color.lightGray);
			jButton211111.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Resumen Contable");
					cdor.actionResumentCont();
				}
			});
		}
		return jButton211111;
	}
}