package vista.ventanas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.controladores.CdorRegistroExamen;

import com.toedter.calendar.JDateChooser;
public class FrmRegistroExamen extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JComboBox jComboBox1 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private CdorRegistroExamen cdor;
	private JCheckBox jCheckBox = null;
	private JPanel jPanelFecha = null;
	JDateChooser calendar = new JDateChooser();
	
	/**
	 * This is the default constructor
	 */
	public FrmRegistroExamen(CdorRegistroExamen cdorRegistroExamen) {
		super();
		this.cdor = cdorRegistroExamen;
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		calendar.setBounds(new Rectangle(225, 156, 86, 19));
		this.setSize(new java.awt.Dimension(611,413));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		this.setResizable(false);
		this.setTitle("Espscialidades");
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
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(101, 185, 106, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Tipo de exámen");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(101, 156, 106, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Fecha inicio");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(207,13,200,33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Registro de exámen");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(101, 128, 106, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro. Afiliado");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(101, 214, 106, 19));
			jLabel5.setForeground(java.awt.Color.black);
			jLabel5.setText("Envía mail?");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(101, 243, 106, 19));
			jLabel6.setForeground(java.awt.Color.black);
			jLabel6.setText("Cobra timbre?");
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
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJComboBox1(), null);
			jContentPane.add(getJPanelFecha(), null);
			jContentPane.add(getJCheckBox(), null);
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
			jTextField1.setBounds(new Rectangle(225, 127, 86, 19));
			jTextField1.setEditable(false);
			jTextField1.setText(cdor.getId());
		}
		return jTextField1;
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
			jPanelFecha.setBounds(new Rectangle(225, 156, 110, 19));
			jPanelFecha.add(calendar, null);
		}
		return jPanelFecha;
	}


	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(225, 243, 20, 19));
			jTextField.setEditable(false);
			boolean timbre = cdor.cobraTimbre();
			if (timbre){
				jTextField.setText("Si");
			}else{
				jTextField.setText("No");
			}
		}
		return jTextField;
	}

	/**
	 * This method initializes jComboBox1
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox(cdor.cargarTex());
			jComboBox1.setBounds(new Rectangle(225, 185, 227, 19));
			jComboBox1.setBackground(Color.WHITE);
		}
		return jComboBox1;
	}
	
	/**
	 * This method initializes jCheckBox
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setBounds(new Rectangle(222, 214, 19, 17));
		}
		return jCheckBox;
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
					System.out.println("Cancelar Registro Exámen.");
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
					System.out.println("Aceptar Registro Exámen.");
					Date fecha = calendar.getDate();
					Calendar fechaIni = Calendar.getInstance();
					fechaIni.setTime(fecha);
					boolean timbre = false;
					if (jTextField.getText().equals("Si")){
						timbre=true;
					}
					cdor.altaRegistro(fechaIni, fechaIni, jCheckBox.isSelected(), timbre, jComboBox1.getSelectedIndex());
				}
			});
		}
		return jButton2;
	}

}

