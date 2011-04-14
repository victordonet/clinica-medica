package vista.ventanas;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import logica.observer.IObserver;
import vista.controladores.CdorListadoEsp;
import vista.controladores.ModeloTablaListEsp;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmListadoAfiliados extends UnicastRemoteObject implements IObserver{

	private static final long serialVersionUID = 1L;
	private JFrame frm = new JFrame();
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private ModeloTablaListEsp modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorListadoEsp cdor;
	private JButton jButton2 = null;

	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmListadoAfiliados(ModeloTablaListEsp modelo, CdorListadoEsp control)throws Throwable {
		this.modelo = modelo;
		cdor = control;
		initialize();
	}

	/**
	 * This method initializes frm
	 *
	 * @return void
	 * @throws Throwable
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, Throwable {
		frm.setSize(new java.awt.Dimension(611,413));
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		frm.setResizable(false);
		frm.setTitle("Afiliados");
		frm.setContentPane(getJContentPane());
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		frm.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cdor.actionCerrar();
				frm.dispose();
			}
		});
	}

	/**
	 * This method initializes ContentPane
	 *
	 * @return javax.swing.JPanel
	 * @throws ClassNotFoundException
	 * @throws Throwable
	 */
	private PanelConImagen getJContentPane() throws Throwable, ClassNotFoundException {
		//if (jContentPane == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(99,120,106,19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Nro. Afiliado");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(99, 95, 106, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Apellido");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(99, 70, 106, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nombre");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(207, 13, 163, 24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("Listado de Afiliados");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJScrollPane(modelo), null);
			jContentPane.add(getJButton2(), null);
			//jContentPane.add(getJTable1(), null);
		//}
		return jContentPane;
			
	}

	public void update() throws RemoteException {
		//JOptionPane.showMessageDialog(null,"Update del Observer FrmListado NUEVO");
		try {
			//cdor.listarEspecialidades();
			//frm.setVisible(false);
			this.modelo = cdor.listarEspecialidades();
			initialize();
			//new FrmListadoEspecialidades(cdor.listarEspecialidades(), cdor);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes TextField1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(222, 70, 170, 19));
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
			jTextField2.setBounds(new Rectangle(222, 95, 170, 19));
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
			jTextField.setBounds(new java.awt.Rectangle(222,120,87,19));
			jTextField.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||(caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
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
		return jTextField;
	}
	
	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane(ModeloTablaListEsp modelo) {
		//if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(65, 155, 475, 180));
			jScrollPane.setViewportView(getJTable1(modelo));
			return jScrollPane;
	}

	/**
	 * This method initializes jTable1
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTable1(ModeloTablaListEsp modelo) {
		return jTable1 = new JTable(modelo);
	}
	
	public JFrame getVentana(){
		return frm;
	}

	/**
	 * This method initializes jButton2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(250, 348, 110, 26));
			jButton2.setFont(new Font("Arial", Font.BOLD, 12));
			jButton2.setText("Cancelar");
			jButton2.setBackground(Color.lightGray);
		}
		return jButton2;
	}
}
