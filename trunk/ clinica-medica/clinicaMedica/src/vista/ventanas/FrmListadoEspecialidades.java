package vista.ventanas;

import java.awt.Font;
import java.awt.Rectangle;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logica.observer.IObserver;
import vista.controladores.CdorListadoEsp;
import vista.controladores.ModeloTablaListEsp;

public class FrmListadoEspecialidades extends UnicastRemoteObject implements IObserver{

	private JFrame frm = new JFrame();
	private PanelConImagen jContentPane = null;
	private JFrame deLaQueViene = null;
	private JTable jTable = null;
	
	private JLabel jLabel = null;
	private ModeloTablaListEsp modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorListadoEsp cdor;
	/**
	 * This is the default constructor
	 * @throws Throwable 
	 */
	public FrmListadoEspecialidades(ModeloTablaListEsp modelo, CdorListadoEsp control)throws Throwable {
	
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
		frm.setSize(new java.awt.Dimension(611,412));
		frm.setResizable(false);
		frm.setTitle("Especialidades");
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
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(176,15,257,24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("Listado de Especialidades");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(getJScrollPane(), null);
			
		}
		return jContentPane;
	}

	public void update() throws RemoteException {
		JOptionPane.showMessageDialog(null,"Update del Observer FrmListado");
		try {
			initialize();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(65, 96, 475, 209));
			jScrollPane.setViewportView(getJTable1());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable(modelo);
		}
		return jTable1;
	}
	public JFrame getVentana(){
		return frm;
	}
}
