package vista.ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import vista.controladores.CdorMantEsp;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrmMenuAfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JLabel jLabel = null;
	private CdorMantEsp cdor;

	/**
	 * This is the default constructor
	 */
	public FrmMenuAfil(CdorMantEsp cdor) {
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
		this.setSize(new java.awt.Dimension(454,338));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		this.setResizable(false);
		this.setTitle("Menu");
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
			jLabel.setBounds(new Rectangle(37, 20, 266, 21));
			jLabel.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("MENU PRINCIPAL");
			jContentPane = new PanelConImagen("./fondos/imgMenuAF.JPG");
			jContentPane.setLayout(null);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(jLabel, null);
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
			jButton1.setBounds(new Rectangle(137, 105, 204, 32));
			jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Listado de Consultas");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Listar consultas");
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
			jButton2.setBounds(new Rectangle(137, 159, 204, 32));
			jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Reserva de turno");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Reserva de turno");
					System.out.println(cdor.toString());
					//cdor.actionListarEsp();
				}
			});
		}
		return jButton2;
	}
	
	/**
	 * This method initializes Button2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(137, 212, 204, 32));
			jButton3.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton3.setBackground(java.awt.Color.lightGray);
			jButton3.setText("Modificación de contraseña");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Modificación de contraseña");
					System.out.println(cdor.toString());
					//cdor.actionListarEsp();
				}
			});
		}
		return jButton3;
	}
}