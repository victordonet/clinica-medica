package vista.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import vista.controladores.CdorListadoDetalleAfiliado;
import vista.controladores.ModeloTablaListadoConsAfi;

public class FrmListadoDetalleAfiliado extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JTextField jTextField8 = null;
	private ModeloTablaListadoConsAfi modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorListadoDetalleAfiliado cdor;
	private JButton jButton2 = null;

	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmListadoDetalleAfiliado(ModeloTablaListadoConsAfi modelo, CdorListadoDetalleAfiliado cdorListadoDetalleAfiliado)throws Throwable {
		this.modelo = modelo;
		cdor = cdorListadoDetalleAfiliado;
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
		this.setSize(new java.awt.Dimension(611,413));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		this.setResizable(false);
		this.setTitle("Listados");
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
	 * @throws ClassNotFoundException
	 * @throws Throwable
	 */
	private PanelConImagen getJContentPane() throws Throwable, ClassNotFoundException {
		if (jContentPane == null) {
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(330, 129, 65, 19));
			jLabel10.setForeground(java.awt.Color.black);
			jLabel10.setText("Estado");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(330, 104, 65, 19));
			jLabel9.setForeground(java.awt.Color.black);
			jLabel9.setText("Fonasa");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(330, 79, 65, 19));
			jLabel8.setForeground(java.awt.Color.black);
			jLabel8.setText("Fecha Ing.");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(330, 54, 65, 19));
			jLabel7.setForeground(java.awt.Color.black);
			jLabel7.setText("Mail");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(65, 154, 74, 19));
			jLabel6.setForeground(java.awt.Color.black);
			jLabel6.setText("Dirección");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(65, 129, 74, 19));
			jLabel5.setForeground(java.awt.Color.black);
			jLabel5.setText("Teléfono");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(65, 104, 74, 19));
			jLabel4.setForeground(java.awt.Color.black);
			jLabel4.setText("Apellido");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(65, 79, 74, 19));
			jLabel3.setForeground(java.awt.Color.black);
			jLabel3.setText("Nombre");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(65, 54, 74, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Nro.Afiliado");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(174, 13, 230, 24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("Listado: Detalle del Afiliado");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJTextField3(), null);
			jContentPane.add(getJTextField4(), null);
			jContentPane.add(getJTextField5(), null);
			jContentPane.add(getJTextField6(), null);
			jContentPane.add(getJTextField7(), null);
			jContentPane.add(getJTextField8(), null);
			jContentPane.add(getJScrollPane());
			jContentPane.add(getJButton2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(145, 54, 87, 19));
			jTextField.setEditable(false);
			jTextField.setText(cdor.getdAfil().getId());
		}
		return jTextField;
	}
	
	/**
	 * This method initializes TextField1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(145, 79, 170, 19));
			jTextField1.setEditable(false);
			jTextField1.setText(cdor.getdAfil().getNombre());
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
			jTextField2.setBounds(new Rectangle(145, 104, 170, 19));
			jTextField2.setEditable(false);
			jTextField2.setText(cdor.getdAfil().getApellido());
		}
		return jTextField2;
	}
	
	/**
	 * This method initializes TextField3
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(145, 129, 170, 19));
			jTextField3.setEditable(false);
			jTextField3.setText(cdor.getdAfil().getTel());
		}
		return jTextField3;
	}
	
	/**
	 * This method initializes TextField4
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(145, 154, 393, 19));
			jTextField4.setEditable(false);
			jTextField4.setText(cdor.getdAfil().getDireccion());
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
			jTextField5.setBounds(new Rectangle(400, 54, 137, 19));
			jTextField5.setEditable(false);
			jTextField5.setText(cdor.getdAfil().getMail());
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
			jTextField6.setBounds(new Rectangle(400, 79, 80, 19));
			jTextField6.setEditable(false);
			Calendar fecha = cdor.getdAfil().getFechaIngreso();
			jTextField6.setText(fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR));
		}
		return jTextField6;
	}
	
	/**
	 * This method initializes jTextField7
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(400, 104, 30, 19));
			jTextField7.setEditable(false);
			boolean fonasa = cdor.getdAfil().getFonasa();
			String fon = "N";
			if (fonasa)
				fon="S";
			jTextField7.setText(fon);
		}
		return jTextField7;
	}
	
	/**
	 * This method initializes jTextField8
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setBounds(new Rectangle(400, 129, 80, 19));
			jTextField8.setEditable(false);
			String estadoAf = cdor.getdAfil().getEstado();
			String estado = "Inactivo";
			if (estadoAf.equals("A"))
				estado="Activo";
			jTextField8.setText(estado);
		}
		return jTextField8;
	}
	
	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(65, 180, 475, 160));
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
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar Listado Consultas");
					cdor.actionCerrar();
				}
			});
		}
		return jButton2;
	}
}
