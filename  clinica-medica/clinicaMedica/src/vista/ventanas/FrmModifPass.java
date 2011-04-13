package vista.ventanas;

import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import vista.controladores.CdorManejoVentanas;
import java.awt.Color;
import javax.swing.JComboBox;

public class FrmModifPass extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JPasswordField jPassField = null;
	private JPasswordField jPassField1 = null;
	private JPasswordField jPassField2 = null;
	private JPasswordField jPassField3 = null;
	private CdorManejoVentanas cdor;
	private JComboBox jComboBox = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	
	/**
	 * This is the default constructor
	 * @return 
	 */
	public  FrmModifPass(CdorManejoVentanas cdor) {
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
		this.setTitle("Usuarios");
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
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(163, 245, 110, 19));
			jLabel6.setText("Tipo/Cargo");
			jLabel6.setForeground(Color.black);
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(163, 212, 112, 19));
			jLabel5.setText("Repetir Contraseña");
			jLabel5.setForeground(Color.black);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(163, 179, 110, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Contraseña Nueva");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(163, 146, 110, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Contraseña Actual");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(177, 14, 255, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Modificación de Contraseña");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(163, 113, 106, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Usuario");
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
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJPassField1(), null);
			jContentPane.add(getJPassField2(), null);
			jContentPane.add(getJPassField(), null);
			jContentPane.add(getJPassField3(), null);
			jContentPane.add(getJComboBox(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes PassField1	
	 * 	
	 * @return javax.swing.JPassField	
	 */
	private JPasswordField getJPassField1() {
		if (jPassField1 == null) {
			jPassField1 = new JPasswordField();
			jPassField1.setBounds(new Rectangle(293, 113, 94, 19));
			jPassField1.setEditable(false);
	}
		return jPassField1;}

	/**
	 * This method initializes PassField2	
	 * 	
	 * @return javax.swing.JPassField	
	 */
	private JPasswordField getJPassField2() {
		if (jPassField2 == null) {
			jPassField2 = new JPasswordField();
			jPassField2.setBounds(new Rectangle(293, 146, 150, 19));
		}
		return jPassField2;
	}


	/**
	 * This method initializes jPassField	
	 * 	
	 * @return javax.swing.JPassField	
	 */
	private JPasswordField getJPassField() {
		if (jPassField == null) {
			jPassField = new JPasswordField();
			jPassField.setBounds(new Rectangle(293, 179, 150, 19));
		}
		return jPassField;
	}

	/**
	 * This method initializes jPassField3	
	 * 	
	 * @return javax.swing.JPassField	
	 */
	private JPasswordField getJPassField3() {
		if (jPassField3 == null) {
			jPassField3 = new JPasswordField();
			jPassField3.setBounds(new Rectangle(293, 212, 150, 19));
		}
		return jPassField3;
	}
	
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(293, 245, 150, 19));
		}
		return jComboBox;
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
					//cdor.altaEsp(jPassField1.getText(), jPassField2.getText(), jPassField.getText());
					
				}
			});
		}
		return jButton2;
	}
}
