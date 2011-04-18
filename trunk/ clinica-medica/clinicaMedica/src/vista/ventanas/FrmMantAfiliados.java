package vista.ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import vista.controladores.CdorMantAfil;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class FrmMantAfiliados extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private CdorMantAfil cdor;
	private JButton jButton3 = null;
	private JButton jButton4 = null;

	/**
	 * This is the default constructor
	 */
	public FrmMantAfiliados(CdorMantAfil cdorMantAfil) {
		super();
		this.cdor = cdorMantAfil;
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
		this.setTitle("Afiliados");
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
			jLabel.setBounds(new Rectangle(51, 9, 219, 21));
			jLabel.setFont(new java.awt.Font("Calibri", java.awt.Font.PLAIN, 16));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("MANTENIMIENTO DE AFILIADOS");
			jContentPane = new PanelConImagen("./fondos/imgMantMediana.JPG");
			jContentPane.setLayout(null);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
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
			jButton1.setBounds(new Rectangle(58, 70, 204, 32));
			jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Alta");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Alta Afiliados");
					cdor.actionAltaAfil();

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
			jButton2.setBounds(new Rectangle(59, 123, 204, 32));
			jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Baja");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Baja Afiliados");
					System.out.println(cdor.toString());
					cdor.actionBajaAfil();
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
			jButton3.setBounds(new Rectangle(59, 176, 204, 32));
			jButton3.setFont(new Font("Arial", Font.BOLD, 12));
			jButton3.setText("Modificación");
			jButton3.setBackground(Color.lightGray);
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Modificación Afiliados");
					System.out.println(cdor.toString());
					cdor.actionModifAfil();
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
			jButton4.setBounds(new Rectangle(58, 229, 204, 32));
			jButton4.setFont(new Font("Arial", Font.BOLD, 12));
			jButton4.setText("Modificación de Usuario");
			jButton4.setBackground(Color.lightGray);
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Modificación Usuario");
					System.out.println(cdor.toString());
					cdor.actionModifPass();
				}
			});
		}
		return jButton4;
	}
}