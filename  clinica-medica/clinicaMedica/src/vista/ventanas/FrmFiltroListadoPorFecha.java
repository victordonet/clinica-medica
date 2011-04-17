package vista.ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import vista.controladores.CdorFiltroListFecha;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;

public class FrmFiltroListadoPorFecha extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JPanel jPanelFechaDesde = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private CdorFiltroListFecha cdor;
	JDateChooser calendar = new JDateChooser();

	/**
	 * This is the default constructor
	 */
	public FrmFiltroListadoPorFecha(CdorFiltroListFecha cdorFiltroListFecha) {
		super();
		this.cdor = cdorFiltroListFecha;
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
		this.setTitle("Filtro de Listados por fecha");
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
			jLabel1.setBounds(new Rectangle(217, 13, 190, 33));
			jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
			jLabel1.setForeground(new java.awt.Color(118,144,201));
			jLabel1.setText("Listado de Conultas");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(212, 159, 90, 19));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Fecha a listar");
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJPanelFechaDesde(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelFechaDesde
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelFechaDesde() {
		if (jPanelFechaDesde == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jPanelFechaDesde = new JPanel();
			jPanelFechaDesde.setLayout(gridLayout1);
			jPanelFechaDesde.setBounds(new Rectangle(310, 158, 90, 19));
			jPanelFechaDesde.add(calendar, null);
		}
		return jPanelFechaDesde;
	}

	/**
	 * This method initializes Button1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(198, 346, 85, 21));
			jButton1.setBackground(java.awt.Color.lightGray);
			jButton1.setText("Cancelar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar Filtro Listado por Fechas.");
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
			jButton2.setBounds(new Rectangle(312, 346, 79, 21));
			jButton2.setBackground(java.awt.Color.lightGray);
			jButton2.setText("Aceptar");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Aceptar Filtro Listado por Fechas");
					Date fecha = calendar.getDate();
					Calendar fechaList = Calendar.getInstance();
					fechaList.setTime(fecha);
					cdor.actionListar(fechaList);
				}
			});
		}
		return jButton2;
	}
}