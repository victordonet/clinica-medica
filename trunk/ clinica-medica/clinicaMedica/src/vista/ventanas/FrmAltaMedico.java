package vista.ventanas;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vista.controladores.CdorAltaEsp;
import vista.controladores.CdorManejoVentanas;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;

public class FrmAltaMedico extends JFrame{

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
	private JComboBox jComboBox = null;
	/**
	 * This is the default constructor
	 * @return 
	 */
	public  FrmAltaMedico(CdorManejoVentanas cdor) {
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
		this.setTitle("Espscialidades");
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
			jLabel4111 = new JLabel();
			jLabel4111.setBounds(new Rectangle(110, 263, 106, 19));
			jLabel4111.setText("Especialidad");
			jLabel4111.setForeground(Color.black);
			jLabel411 = new JLabel();
			jLabel411.setBounds(new Rectangle(110, 229, 106, 19));
			jLabel411.setText("Telefono");
			jLabel411.setForeground(Color.black);
			jLabel41 = new JLabel();
			jLabel41.setBounds(new Rectangle(110, 196, 106, 19));
			jLabel41.setText("C.I");
			jLabel41.setForeground(Color.black);
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
			jLabel1.setText(" Alta de Medicos");
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
			jContentPane.add(getJComboBox(), null);
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
			jTextField1.addKeyListener(new KeyAdapter()
					{
					   public void keyTyped(KeyEvent e)
					   {
						   // Verificar si la tecla pulsada no es un digito
						   char caracter = e.getKeyChar();
						   if(((caracter < '0') ||
								   (caracter > '9')) &&
								   (caracter != KeyEvent.VK_BACK_SPACE))
						   {
							   e.consume();  // ignorar el evento de teclado
						   }
					      
					      //Controlar el largo del text
					      String s = jTextField1.getText();
					      int n=s.length();
					      if(n >= 10){
					    	  e.consume();  // ignorar el evento de teclado
					      }
					   }
					});
		
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
			jTextField2.setBounds(new Rectangle(240, 130, 282, 19));
			jTextField2.addKeyListener(new KeyAdapter()
					{
					   public void keyTyped(KeyEvent e)
					   {
						  //Controlar el largo del text
					      String s = jTextField2.getText();
					      int n=s.length();
					      if(n >= 50){
					    	  e.consume();  // ignorar el evento de teclado
					      }
					   }
					});
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
			jTextField.setBounds(new Rectangle(240, 160, 282, 19));
			jTextField.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||(caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)&&(caracter != '.'))
				   {
					   e.consume();  // ignorar el evento de teclado
				   }
			      
			      //Controlar el largo del text
			      String s = jTextField.getText();
			      int n=s.length();
			      if(n >= 10){
			    	  e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
}
		return jTextField;}

	/**
	 * This method initializes jTextField3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(240, 196, 143, 19));
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
			jTextField31.setBounds(new Rectangle(240, 229, 282, 19));
		}
		return jTextField31;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(240, 263, 282, 19));
		}
		return jComboBox;
	}}
