package vista.ventanas;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vista.controladores.CdorModifAfil;


public class FrmModifAfiliado extends JFrame{

	private static final long serialVersionUID = 1L;
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
	private JLabel jLabel11 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private CdorModifAfil cdor;
	private JCheckBox jCheckBox = null;
	private JComboBox jComboBox = null;

	/**
	 * This is the default constructor
	 * @return
	 */
	public  FrmModifAfiliado(CdorModifAfil cdor) {
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
		this.setTitle("Afiliados");
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
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(110, 318, 106, 19));
			jLabel11.setText("Estado");
			jLabel11.setForeground(Color.black);
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(110, 291, 106, 19));
			jLabel10.setText("Fonasa");
			jLabel10.setForeground(Color.black);
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(110, 210, 106, 19));
			jLabel9.setText("Direccion");
			jLabel9.setForeground(Color.black);
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(110, 184, 106, 19));
			jLabel8.setText("E-mail");
			jLabel8.setForeground(Color.black);
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(110, 263, 106, 19));
			jLabel7.setText("Fecha Ingreso");
			jLabel7.setForeground(Color.black);
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(110, 236, 106, 19));
			jLabel6.setText("Telefono");
			jLabel6.setForeground(Color.black);
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(110, 159, 106, 19));
			jLabel5.setText("C.I *");
			jLabel5.setForeground(Color.black);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(110, 133, 106, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Apellido *");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(110, 105, 106, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre *");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(110, 77, 106, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro. Afiliado");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(174, 11, 216, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Modificación de Afiliado");
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
			jContentPane.add(jLabel8, null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJCheckBox(), null);
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
			jTextField1.setBounds(new Rectangle(246, 77, 80, 19));
			jTextField1.setEditable(false);
			jTextField1.setText(cdor.getDatos().getId());
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
			jTextField2.setBounds(new Rectangle(246, 105, 282, 19));
			jTextField2.setText(cdor.getDatos().getNombre());
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
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(246, 133, 282, 19));
			jTextField.setText(cdor.getDatos().getApellido());
			jTextField.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
			      //Controlar el largo del text
			      String s = jTextField.getText();
			      int n=s.length();
			      if(n >= 20){
			    	  e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
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
			jTextField3.setBounds(new Rectangle(246, 159, 143, 19));
			jTextField3.setText(cdor.getDatos().getCi());
			jTextField3.addKeyListener(new KeyAdapter()
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
			      String s = jTextField3.getText();
			      int n=s.length();
			      if(n >= 8){
			    	  e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
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
			jTextField4.setBounds(new Rectangle(246, 236, 282, 19));
			jTextField4.setText(cdor.getDatos().getTel());
			jTextField4.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				  //Controlar el largo del text
			      String s = jTextField4.getText();
			      int n=s.length();
			      if(n >= 50){
			    	  e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
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
			jTextField5.setBounds(new Rectangle(246, 184, 282, 19));
			jTextField5.setText(cdor.getDatos().getMail());
			jTextField5.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
			      //Controlar el largo del text
			      String s = jTextField5.getText();
			      int n=s.length();
			      if(n >= 50){
			    	  e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
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
			jTextField6.setBounds(new Rectangle(246, 210, 282, 19));
			jTextField6.setText(cdor.getDatos().getDireccion());
			jTextField6.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
			      //Controlar el largo del text
			      String s = jTextField6.getText();
			      int n=s.length();
			      if(n >= 50){
			    	  e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
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
			jCheckBox.setBounds(new Rectangle(243, 292, 17, 16));
			jCheckBox.setSelected(cdor.getDatos().getFonasa());
		}
		return jCheckBox;
	}

	/* This method initializes jTextField7
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(247, 265, 80, 19));
			jTextField7.setEditable(false);
			Calendar fecha = cdor.getDatos().getFechaIngreso();
			jTextField7.setText(fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR));
		}
		return jTextField7;
	}
	
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.addItem("Activo");
			jComboBox.addItem("Inactivo");
			jComboBox.setBackground(Color.WHITE);
			if (cdor.getDatos().getEstado().equals("A")){
				jComboBox.setSelectedIndex(0);
			}else
				jComboBox.setSelectedIndex(1);
			jComboBox.setBounds(new Rectangle(248, 316, 88, 20));
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
					System.out.println("Cancelar Modificación Afiliado.");
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
					System.out.println("Aceptar Modificación Afiliado.");
					if(jTextField2.getText().equals("") || jTextField.getText().equals("") || jTextField3.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Los campos identificados con * no pueden quedar en blanco.");
					}else{
					String estado = "I";
					if(jComboBox.getSelectedIndex()==0){
						estado = "A";
					}
					boolean fonasa = jCheckBox.isSelected();
					cdor.modifAfil(jTextField1.getText(), jTextField2.getText(), jTextField.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField6.getText(), fonasa, estado);
					}
				}
			});
		}
		return jButton2;
	}
}
