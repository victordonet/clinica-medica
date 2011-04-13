package vista.ventanas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vista.controladores.CdorAltaEsp;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrmAltaConsultorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private CdorAltaEsp cdor;
	
	/**
	 * This is the default constructor
	 */
	public FrmAltaConsultorio(CdorAltaEsp cdor) {
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
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(99,178,106,19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(207,13,200,33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Alta de Consultorio");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(99,150,106,19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro. Consultorio");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jTextField1, null);
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
			jTextField1.setBounds(new Rectangle(223, 149, 45, 19));
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
					      if(n >= 2){
					    	  e.consume();  // ignorar el evento de teclado
					      }
					   }
					});
		
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
			jTextField2.setBounds(new java.awt.Rectangle(221,178,292,19));
			jTextField2.addKeyListener(new KeyAdapter()
					{
					   public void keyTyped(KeyEvent e)
					   {
						  //Controlar el largo del text
					      String s = jTextField2.getText();
					      int n=s.length();
					      if(n >= 40){
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
					System.out.println("Aceptar Alta Usuario");	
					//cdor.altaEsp(jTextField1.getText(), jTextField2.getText(), jTextField.getText());
				}
			});
		}
		return jButton2;
	}
}

