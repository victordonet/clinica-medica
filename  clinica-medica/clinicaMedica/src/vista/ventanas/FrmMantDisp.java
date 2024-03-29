package vista.ventanas;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import logica.observer.IObserver;
import vista.controladores.CdorMantDisp;
import vista.controladores.DibujoDisp;
import vista.controladores.ModeloTablaDisp;

public class FrmMantDisp extends UnicastRemoteObject implements IObserver{

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
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel17 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorMantDisp cdor;
	private ModeloTablaDisp modelo = null;
	private JFrame frm = new JFrame();
	private JLabel jLabel = null;
	private JCheckBox jCheckBox = null;
	private JCheckBox jCheckBox1 = null;

	public FrmMantDisp(CdorMantDisp cdor)throws Throwable{
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		frm.setSize(new java.awt.Dimension(611,413));
		frm.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		frm.setResizable(false);
		frm.setTitle("Disponibilidad");
		frm.setContentPane(getJContentPane());
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		frm.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cdor.actionCerrar();
			}
		});
	}

	private PanelConImagen getJContentPane() {
		//if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(471, 308, 24, 19));
			jLabel.setText("");
			jLabel.setOpaque(true);
		    jLabel.setBackground(Color.RED);
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(188, 7, 200, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Mantener disponibilidad");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(56, 65, 56, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("M�dico");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(101, 114, 20, 19));
			jLabel3.setForeground(java.awt.Color.GRAY);
			jLabel3.setText("00");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(101, 130, 20, 19));
			jLabel4.setForeground(java.awt.Color.GRAY);
			jLabel4.setText("02");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(101, 146, 20, 19));
			jLabel5.setForeground(java.awt.Color.GRAY);
			jLabel5.setText("04");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(101, 162, 20, 19));
			jLabel6.setForeground(java.awt.Color.GRAY);
			jLabel6.setText("06");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(101, 178, 20, 19));
			jLabel7.setForeground(java.awt.Color.GRAY);
			jLabel7.setText("08");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(101, 194, 20, 19));
			jLabel8.setForeground(java.awt.Color.GRAY);
			jLabel8.setText("10");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(101, 210, 20, 19));
			jLabel9.setForeground(java.awt.Color.GRAY);
			jLabel9.setText("12");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(101, 226, 20, 19));
			jLabel10.setForeground(java.awt.Color.GRAY);
			jLabel10.setText("14");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(101, 242, 20, 19));
			jLabel11.setForeground(java.awt.Color.GRAY);
			jLabel11.setText("16");
			jLabel12 = new JLabel();
			jLabel12.setForeground(java.awt.Color.GRAY);
			jLabel12.setBounds(new Rectangle(101, 258, 20, 19));
			jLabel12.setText("18");
			jLabel13 = new JLabel();
			jLabel13.setForeground(java.awt.Color.GRAY);
			jLabel13.setBounds(new Rectangle(101, 275, 20, 19));
			jLabel13.setText("20");
			jLabel14 = new JLabel();
			jLabel14.setForeground(java.awt.Color.GRAY);
			jLabel14.setBounds(new Rectangle(101, 291, 20, 19));
			jLabel14.setText("22");
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(505, 267, 80, 19));
			jLabel15.setForeground(java.awt.Color.GRAY);
			jLabel15.setText("Disponible");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(505, 286, 80, 19));
			jLabel16.setForeground(java.awt.Color.GRAY);
			jLabel16.setText("Seleccionada");
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(505, 309, 80, 19));
			jLabel17.setForeground(java.awt.Color.GRAY);
			jLabel17.setText("No disponible");
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
			jContentPane.add(jLabel12, null);
			jContentPane.add(jLabel13, null);
			jContentPane.add(jLabel14, null);
			jContentPane.add(jLabel15, null);
			jContentPane.add(jLabel16, null);
			jContentPane.add(jLabel17, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJCheckBox(), null);
			jContentPane.add(getJCheckBox1(), null);
		//}
		return jContentPane;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(125, 65, 86, 19));
			jTextField1.setEditable(false);
			jTextField1.setText(cdor.getId());
		}
		return jTextField1;}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(222, 65, 292, 19));
			jTextField2.setEditable(false);
			jTextField2.setText(cdor.getdMed().getNombre()+" "+cdor.getdMed().getApellido());
		}
		return jTextField2;
	}

	private JScrollPane getJScrollPane() {
		//if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(124, 100, 330, 211));
			jScrollPane.setViewportView(getJTable1());
		//}
		return jScrollPane;
	}

	private JTable getJTable1() {
			modelo = cdor.obtenerDisp();
			jTable1 = new JTable(modelo);
			jTable1.setCellSelectionEnabled(true);
			DibujoDisp miDibujo = new DibujoDisp();
			jTable1.setDefaultRenderer(Boolean.class, miDibujo);
			jTable1.getTableHeader().setReorderingAllowed(false);
		return jTable1;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new java.awt.Rectangle(194,346,85,21));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Cancelar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar Mantenimiento Disponibilidad");
					cdor.actionCerrar();
				}
			});
		}
		return jButton1;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new java.awt.Rectangle(308,346,79,21));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Aceptar");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionAceptar();
				}
			});
		}
		return jButton2;
	}


	public void update() throws RemoteException {
		modelo = cdor.obtenerDisp();
		jTable1.setModel(modelo);
		jTable1.setVisible(true);
	}

		
	

	public JFrame getVentana() {
		return frm;
	}

	/**
	 * This method initializes jCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setBounds(new Rectangle(471, 267, 28, 19));
			jCheckBox.setEnabled(false);
			
		}
		return jCheckBox;
	}

	/**
	 * This method initializes jCheckBox1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox1() {
		if (jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setBounds(new Rectangle(471, 288, 30, 19));
			jCheckBox1.setSelected(true);
			jCheckBox1.setEnabled(false);
		}
		return jCheckBox1;
	}
}