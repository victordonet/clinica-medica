package vista.ventanas;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vista.controladores.CdorAltaAfil;
import vista.controladores.CdorManejoVentanas;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

public class FrmAltaAfiliado extends JFrame{

	private static final long serialVersionUID = 1L;
	private CdorAltaAfil cdor;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JCheckBox jCheckBox = null;
	private JPanel jPanelFecha = null;
	JDateChooser calendar = new JDateChooser();

	/**
	 * This is the default constructor
	 * @return
	 */
	public  FrmAltaAfiliado(CdorAltaAfil cdor) {
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
		this.setTitle("Afiliados");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cdor.actionCerrar();
				dispose();			}
		});
	}

	/**
	 * This method initializes ContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private PanelConImagen getJContentPane() {
		if (jContentPane == null) {
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(108, 292, 106, 19));
			jLabel10.setText("Fonasa");
			jLabel10.setForeground(Color.black);
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(107, 217, 106, 19));
			jLabel9.setText("Direccion");
			jLabel9.setForeground(Color.black);
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(107, 191, 106, 19));
			jLabel8.setText("E-mail");
			jLabel8.setForeground(Color.black);
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(107, 268, 106, 19));
			jLabel7.setText("Fecha Ingreso");
			jLabel7.setForeground(Color.black);
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(107, 243, 106, 19));
			jLabel6.setText("Telefono");
			jLabel6.setForeground(Color.black);
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(107, 166, 106, 19));
			jLabel5.setText("C.I");
			jLabel5.setForeground(Color.black);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(107, 140, 106, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Apellido");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(107, 112, 106, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(214, 9, 136, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText(" Alta de Afiliado");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(107, 84, 106, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro. Afiliado");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jTextField1, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(getJCheckBox(), null);
			jContentPane.add(getJPanelFecha(), null);
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
			jTextField1.setBounds(new Rectangle(243, 84, 143, 19));
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
			jTextField2.setBounds(new Rectangle(243, 112, 282, 19));
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
			jTextField.setBounds(new Rectangle(243, 140, 282, 19));
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
			jTextField3.setBounds(new Rectangle(243, 166, 143, 19));
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
			jTextField4.setBounds(new Rectangle(243, 243, 282, 19));
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
			jTextField5.setBounds(new Rectangle(243, 191, 143, 19));
		}
		return jTextField5;
	}

	/**
	 * This method initializes jTextField6
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(243, 217, 282, 19));
		}
		return jTextField6;
	}

	/**
	 * This method initializes jCheckBox
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setBounds(new Rectangle(240, 295, 19, 17));
		}
		return jCheckBox;
	}

	/**
	 * This method initializes jPanelFecha
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelFecha() {
		if (jPanelFecha == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jPanelFecha = new JPanel();
			jPanelFecha.setLayout(gridLayout1);
			jPanelFecha.setBounds(new Rectangle(243, 268, 100, 19));
			jPanelFecha.add(calendar, null);
		}
		return jPanelFecha;
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
					System.out.println("Cancelar Alta Afiliado.");
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
					System.out.println("Aceptar Alta Afiliado.");
					Date fecha = calendar.getDate();
					Calendar fechaIngr = Calendar.getInstance();
					fechaIngr.setTime(fecha);
					boolean fona = jCheckBox.isSelected();
					cdor.altaAfil(jTextField1.getText(), jTextField3.getText(), jTextField2.getText(), jTextField.getText(), jTextField5.getText(), jTextField6.getText(), jTextField4.getText(), "A", fechaIngr, fona);
					cdor.actionCerrar();		
				}
			});
		}
		return jButton2;
	}
}
