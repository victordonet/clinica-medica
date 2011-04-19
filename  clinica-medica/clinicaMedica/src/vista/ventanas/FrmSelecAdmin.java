package vista.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import logica.observer.IObserver;
import vista.controladores.CdorSelectAdmin;
import vista.controladores.ModeloTablaListAdmin;

public class FrmSelecAdmin extends UnicastRemoteObject implements IObserver{

	private static final long serialVersionUID = 1L;
	private JFrame frm = new JFrame();
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private ModeloTablaListAdmin modelo = null;
	private CdorSelectAdmin cdor;
	private JButton jButton2 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton21 = null;

	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmSelecAdmin(CdorSelectAdmin control)throws Throwable {
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
		frm.setTitle("Administrativos");
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
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(177, 15, 239, 24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("Selección de Administrativo");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton21(), null);
			jContentPane.add(getJScrollPane(), null);
		//}
		return jContentPane;
			
	}

	public void update() throws RemoteException {
		//JOptionPane.showMessageDialog(null,"Update del Observer FrmListado NUEVO");
		try {
			//cdor.listarEspecialidades();
			//frm.setVisible(false);
			//this.modelo = cdor.listarAdmin();
			initialize();
			//new FrmListadoEspecialidades(cdor.listarEspecialidades(), cdor);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
			jButton2.setBounds(new Rectangle(191, 336, 110, 26));
			jButton2.setFont(new Font("Arial", Font.BOLD, 12));
			jButton2.setText("Cancelar");
			jButton2.setBackground(Color.lightGray);
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar Listado Administrativos");
					cdor.actionCerrar();
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(38, 84, 529, 228));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			modelo = cdor.listarAdmin();
			jTable = new JTable(modelo);
		}
		return jTable;
	}

	/**
	 * This method initializes jButton21	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton21() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setBounds(new Rectangle(330, 336, 110, 26));
			jButton21.setFont(new Font("Arial", Font.BOLD, 12));
			jButton21.setText("Aceptar");
			jButton21.setBackground(Color.lightGray);
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Aceptar Listado Administrativos");
				}
			});
		}
		return jButton21;
	}
}
