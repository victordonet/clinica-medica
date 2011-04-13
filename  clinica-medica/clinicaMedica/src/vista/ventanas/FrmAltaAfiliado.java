package vista.ventanas;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vista.controladores.CdorManejoVentanas;
import datechooser.beans.DateChooserCombo;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class FrmAltaAfiliado extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JTextField jTextField = null;
	private CdorManejoVentanas cdor;
	private JLabel jLabel41 = null;
	private JTextField jTextField3 = null;
	private JLabel jLabel411 = null;
	private JTextField jTextField31 = null;
	private JLabel jLabel4111 = null;
	private JLabel jLabel412 = null;
	private JTextField jTextField32 = null;
	private JLabel jLabel4121 = null;
	private JTextField jTextField311 = null;
	private JLabel jLabel41112 = null;
	private JCheckBox jCheckBox = null;
	private JPanel jPanel = null;
	/**
	 * This is the default constructor
	 * @return 
	 */
	public  FrmAltaAfiliado(CdorManejoVentanas cdor) {
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
		this.setSize(new java.awt.Dimension(611,412));
		this.setResizable(false);		
		this.setTitle("Alta Medicos");
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
			jLabel41112 = new JLabel();
			jLabel41112.setBounds(new Rectangle(110, 278, 106, 19));
			jLabel41112.setText("Fonasa");
			jLabel41112.setForeground(Color.black);
			jLabel4121 = new JLabel();
			jLabel4121.setBounds(new Rectangle(110, 194, 106, 19));
			jLabel4121.setText("Direccion");
			jLabel4121.setForeground(Color.black);
			jLabel412 = new JLabel();
			jLabel412.setBounds(new Rectangle(110, 168, 106, 19));
			jLabel412.setText("E-mail");
			jLabel412.setForeground(Color.black);
			jLabel4111 = new JLabel();
			jLabel4111.setBounds(new Rectangle(110, 247, 106, 19));
			jLabel4111.setText("Fecha Ingreso");
			jLabel4111.setForeground(Color.black);
			jLabel411 = new JLabel();
			jLabel411.setBounds(new Rectangle(110, 220, 106, 19));
			jLabel411.setText("Telefono");
			jLabel411.setForeground(Color.black);
			jLabel41 = new JLabel();
			jLabel41.setBounds(new Rectangle(110, 143, 106, 19));
			jLabel41.setText("C.I");
			jLabel41.setForeground(Color.black);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(110, 117, 106, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Apellido");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(110, 89, 106, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(214, 9, 136, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText(" Alta de Afiliado");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(110, 61, 106, 19));
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
			jContentPane.add(jLabel41, null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(jLabel411, null);
			jContentPane.add(getJTextField31(), null);
			jContentPane.add(jLabel4111, null);
			jContentPane.add(jLabel412, null);
			jContentPane.add(getJTextField32(), null);
			jContentPane.add(jLabel4121, null);
			jContentPane.add(getJTextField311(), null);
			jContentPane.add(jLabel41112, null);
			jContentPane.add(getJCheckBox(), null);
			jContentPane.add(getJPanel(), null);
	
		
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
			jTextField1.setBounds(new Rectangle(246, 61, 143, 19));
		}
		return jTextField1;}

	/**
	 * This method initializes TextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(246, 89, 282, 19));
			
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
					System.out.println("Cancelar Alta Usuario");
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
					System.out.println("Aceptar Alta Medico");	
					//cdor.altaEsp(jTextField1.getText(), jTextField2.getText(), jTextField.getText());
					
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(246, 117, 282, 19));
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
			jTextField3.setBounds(new Rectangle(246, 143, 143, 19));
		}
		return jTextField3;
	}

	/**
	 * This method initializes jTextField31	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField31() {
		if (jTextField31 == null) {
			jTextField31 = new JTextField();
			jTextField31.setBounds(new Rectangle(246, 220, 282, 19));
		}
		return jTextField31;
	}

	/**
	 * This method initializes jTextField32	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField32() {
		if (jTextField32 == null) {
			jTextField32 = new JTextField();
			jTextField32.setBounds(new Rectangle(246, 168, 143, 19));
		}
		return jTextField32;
	}

	/**
	 * This method initializes jTextField311	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField311() {
		if (jTextField311 == null) {
			jTextField311 = new JTextField();
			jTextField311.setBounds(new Rectangle(246, 194, 282, 19));
		}
		return jTextField311;
	}

	/**
	 * This method initializes jCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setBounds(new Rectangle(246, 278, 34, 23));
		}
		return jCheckBox;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout);
			jPanel.setBounds(new Rectangle(249, 245, 132, 25));
			DateChooserCombo dateChooserCombo1 = new DateChooserCombo();
			jPanel.add(dateChooserCombo1, null);
		
		}
		return jPanel;
	}}
