package vista.ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vista.controladores.CdorModifAdmin;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;

public class FrmModifAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private CdorModifAdmin cdor;
	private JComboBox jComboBox = null;
	private JComboBox jComboBox1 = null;
	/**
	 * This is the default constructor
	 */
	public FrmModifAdmin(CdorModifAdmin cdorModifAdmin) {
		super();
		this.cdor = cdorModifAdmin;
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
			jLabel1.setBounds(new Rectangle(157, 13, 258, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Modificación de Administrativo");
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
			jLabel5 = new JLabel();
			jLabel5.setBounds(new java.awt.Rectangle(99,236,106,19));
			jLabel5.setForeground(java.awt.Color.black);
			jLabel5.setText("Estado");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJComboBox(), null);
			jContentPane.add(getJComboBox1(), null);
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
			jTextField1.setBounds(new Rectangle(222, 149, 86, 19));
			jTextField1.setEditable(false);
			jTextField1.setText(cdor.getDatos().getId());
			jTextField1.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
			      //Controlar el largo del text
			      String s = jTextField1.getText();
			      int n=s.length();
			      if(n >= 20){
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
			jTextField2.setBounds(new Rectangle(222, 178, 292, 19));
			jTextField2.setText(cdor.getDatos().getNombre());
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
					System.out.println("Cancelar Modificación Administrativo.");
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
					System.out.println("Aceptar Modificación Administrativo.");
					String estado = "I";
					if(jComboBox1.getSelectedIndex()==0){
						estado = "A";
					}
					cdor.modifAdmin(jTextField1.getText(), jTextField2.getText(), jComboBox.getSelectedIndex(),estado);
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox(cdor.cargarBox());
			jComboBox.setBounds(new Rectangle(222, 207, 161, 19));
			jComboBox.setBackground(Color.WHITE);
			jComboBox.setSelectedIndex(cdor.getDatos().getCargo()-1);
		}
		return jComboBox;
	}

	/**
	 * This method initializes jComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setBounds(new Rectangle(222, 236, 126, 19));
			jComboBox1.addItem("Activo");
			jComboBox1.addItem("Inactivo");
			jComboBox1.setBackground(Color.WHITE);
			if (cdor.getDatos().getEstado().equals("A")){
				jComboBox1.setSelectedIndex(0);
			}else
				jComboBox1.setSelectedIndex(1);
		}
		return jComboBox1;
	}
}

