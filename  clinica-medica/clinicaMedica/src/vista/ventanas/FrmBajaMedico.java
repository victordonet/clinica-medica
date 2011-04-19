package vista.ventanas;

import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vista.controladores.CdorBajaMedico;
import vista.controladores.CdorManejoVentanas;
import java.awt.Color;

public class FrmBajaMedico extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private CdorBajaMedico cdor;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;

	/**
	 * This is the default constructor
	 * @return
	 */
	public FrmBajaMedico(CdorBajaMedico cdor) {
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
		this.setSize(new java.awt.Dimension(611,413));
		this.setResizable(false);
		this.setTitle("Médicos");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
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
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(110, 263, 106, 19));
			jLabel7.setText("Especialidad");
			jLabel7.setForeground(Color.black);
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(110, 229, 106, 19));
			jLabel6.setText("Telefono");
			jLabel6.setForeground(Color.black);
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(110, 196, 106, 19));
			jLabel5.setText("C.I");
			jLabel5.setForeground(Color.black);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(110, 160, 106, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Apellido");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(110, 130, 106, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(214, 9, 136, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Baja de Médico");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(110, 97, 106, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro. BPS");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes TextField1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(240, 97, 143, 19));
			jTextField1.setEditable(false);
			jTextField1.setText(cdor.getDatos().getId());
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
			jTextField2.setBounds(new Rectangle(240, 130, 282, 19));
			jTextField2.setEditable(false);
			jTextField2.setText(cdor.getDatos().getNombre());
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
			jTextField.setBounds(new Rectangle(240, 160, 282, 19));
			jTextField.setEditable(false);
			jTextField.setText(cdor.getDatos().getApellido());
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField3
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(240, 196, 143, 19));
			jTextField3.setEditable(false);
			jTextField3.setText(cdor.getDatos().getCi());
		}
		return jTextField3;
	}

	/**
	 * This method initializes jTextField4
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(240, 229, 282, 19));
			jTextField4.setEditable(false);
			jTextField4.setText(cdor.getDatos().getTel());
		}
		return jTextField4;
	}


	/**
	 * This method initializes jTextField5
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(240, 263, 143, 19));
			jTextField5.setEditable(false);
			jTextField5.setText(cdor.getDescEsp());
		}
		return jTextField5;
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
					System.out.println("Cancelar Baja Médico.");
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
					System.out.println("Aceptar Baja Médico.");
					cdor.bajaMedico(jTextField1.getText());
				}
			});
		}
		return jButton2;
	}
}
