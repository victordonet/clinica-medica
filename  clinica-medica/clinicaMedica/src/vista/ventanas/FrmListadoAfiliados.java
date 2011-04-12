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
import logica.observer.IObserver;
import vista.controladores.CdorListadoEsp;
import vista.controladores.ModeloTablaListEsp;
import javax.swing.JButton;
import java.awt.Color;

public class FrmListadoAfiliados extends UnicastRemoteObject implements IObserver{

	private static final long serialVersionUID = 1L;
	private JFrame frm = new JFrame();
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private ModeloTablaListEsp modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorListadoEsp cdor;
	private JButton jButton2 = null;
	private JButton jButton21 = null;
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
			jContentPane.add(getJScrollPane(modelo), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton21(), null);
			
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
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane(ModeloTablaListEsp modelo) {
		//if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(65, 96, 475, 209));
			jScrollPane.setViewportView(getJTable1(modelo));
		//}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable1(ModeloTablaListEsp modelo) {
		//if (jTable1 == null) {
			jTable1 = new JTable(modelo);
		//}
		return jTable1;
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
			jButton2.setBounds(new Rectangle(309, 332, 110, 26));
			jButton2.setFont(new Font("Arial", Font.BOLD, 12));
			jButton2.setText("Aceptar");
			jButton2.setBackground(Color.lightGray);
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton21	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton21() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setBounds(new Rectangle(168, 332, 110, 26));
			jButton21.setFont(new Font("Arial", Font.BOLD, 12));
			jButton21.setText("Cancelar");
			jButton21.setBackground(Color.lightGray);
		}
		return jButton21;
	}
}
