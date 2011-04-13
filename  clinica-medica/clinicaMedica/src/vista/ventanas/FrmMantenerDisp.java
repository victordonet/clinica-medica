package vista.ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import vista.controladores.CdorAltaEsp;
import vista.controladores.ModeloTablaListEsp;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrmMantenerDisp extends JFrame {

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
	private CdorAltaEsp cdor;
	private ModeloTablaListEsp modelo = null;

	/**
	 * This is the default constructor
	 */
	public FrmMantenerDisp(CdorAltaEsp cdor) {
		super();
		this.cdor = cdor;
		//this.modelo = cdor.listarEspecialidades();
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
		this.setTitle("Disponibilidad");
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
			jLabel1.setBounds(new Rectangle(188, 13, 200, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Mantener disponibilidad");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(56, 65, 56, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Médico");

			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(96, 104, 20, 19));
			jLabel3.setForeground(java.awt.Color.GRAY);
			jLabel3.setText("00");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(96, 123, 20, 19));
			jLabel4.setForeground(java.awt.Color.GRAY);
			jLabel4.setText("02");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(96, 142, 20, 19));
			jLabel5.setForeground(java.awt.Color.GRAY);
			jLabel5.setText("04");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(96, 161, 20, 19));
			jLabel6.setForeground(java.awt.Color.GRAY);
			jLabel6.setText("06");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(96, 180, 20, 19));
			jLabel7.setForeground(java.awt.Color.GRAY);
			jLabel7.setText("08");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(96, 199, 20, 19));
			jLabel8.setForeground(java.awt.Color.GRAY);
			jLabel8.setText("10");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(96, 218, 20, 19));
			jLabel9.setForeground(java.awt.Color.GRAY);
			jLabel9.setText("12");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(96, 235, 20, 19));
			jLabel10.setForeground(java.awt.Color.GRAY);
			jLabel10.setText("14");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(96, 252, 20, 19));
			jLabel11.setForeground(java.awt.Color.GRAY);
			jLabel11.setText("16");

			jLabel12 = new JLabel();
			jLabel12.setForeground(java.awt.Color.GRAY);
			jLabel12.setBounds(new Rectangle(96, 271, 20, 19));
			jLabel12.setText("18");
			jLabel13 = new JLabel();
			jLabel13.setForeground(java.awt.Color.GRAY);
			jLabel13.setBounds(new Rectangle(96, 290, 20, 19));
			jLabel13.setText("20");
			jLabel14 = new JLabel();
			jLabel14.setForeground(java.awt.Color.GRAY);
			jLabel14.setBounds(new Rectangle(96, 309, 20, 19));
			jLabel14.setText("22");

			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(498, 267, 80, 19));
			jLabel15.setForeground(java.awt.Color.GRAY);
			jLabel15.setText("Disponible");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(498, 287, 80, 19));
			jLabel16.setForeground(java.awt.Color.GRAY);
			jLabel16.setText("Seleccionada");
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(498, 307, 80, 19));
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
			jContentPane.add(getJScrollPane(modelo), null);
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
			jTextField1.setBounds(new Rectangle(125, 65, 86, 19));
			jTextField1.setEditable(false);

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
			jTextField2.setBounds(new Rectangle(222, 65, 292, 19));
			jTextField2.setEditable(false);
		}
		return jTextField2;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane(ModeloTablaListEsp modelo) {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(125, 104, 330, 224));
			jScrollPane.setViewportView(getJTable1(modelo));
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getJTable1(ModeloTablaListEsp modelo) {
		if (jTable1 == null) {
			jTable1 = new JTable(modelo);
		}
		return jTable1;
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
					System.out.println("Cancelar Mantenimiento Disponibilidad");
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
					System.out.println("Aceptar Mantenimiento Disponibilidad");
					//cdor.altaEsp(jTextField1.getText(), jTextField2.getText(), jTextField.getText());
				}
			});
		}
		return jButton2;
	}
}