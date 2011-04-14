package vista.ventanas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vista.controladores.CdorAltaAdmin;
import vista.controladores.CdorAltaEsp;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrmAltaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JComboBox jComboBox = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private CdorAltaAdmin cdor;

	/**
	 * This is the default constructor
	 */
	public FrmAltaAdmin(CdorAltaAdmin cdor) {
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
		this.setTitle("Administrativos");
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
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(207,13,200,33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Alta de Administrativo");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(99,150,106,19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Código Admin.");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(99,178,106,19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(99,207,106,19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Cargo");
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
			jTextField1.setBounds(new Rectangle(222, 150, 86, 19));
			jTextField1.addKeyListener(new KeyAdapter()
					{
					   public void keyTyped(KeyEvent e)
					   {
					      //Controlar el largo del text
					      String s = jTextField1.getText();
					      int n=s.length();
					      if(n >= 30){
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
			jTextField2.setBounds(new java.awt.Rectangle(222,178,292,19));
			jTextField2.addKeyListener(new KeyAdapter()
					{
					   public void keyTyped(KeyEvent e)
					   {
						  //Controlar el largo del text
					      String s = jTextField2.getText();
					      int n=s.length();
					      if(n >= 20){
					    	  e.consume();  // ignorar el evento de teclado
					      }
					   }
					});
		}
		return jTextField2;
	}


	/**
	 * This method initializes jComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new java.awt.Rectangle(222,207,87,19));
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
					System.out.println("Cancelar Alta Administrativo.");
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
					System.out.println("Aceptar Alta Administrativo.");
					cdor.altaAdmin(jTextField1.getText(), jTextField2.getText(),jComboBox.getSelectedIndex());
					

				}
			});
		}
		return jButton2;
	}
}

