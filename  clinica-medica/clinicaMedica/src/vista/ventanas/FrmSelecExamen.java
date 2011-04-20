package vista.ventanas;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import vista.controladores.CdorSelectExam;
import vista.controladores.ModeloTablaListExam;
import javax.swing.JButton;
import java.awt.Color;

public class FrmSelecExamen extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private ModeloTablaListExam modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorSelectExam cdor;
	private JButton jButton2 = null;
	private JButton jButton21 = null;

	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmSelecExamen(CdorSelectExam cdorSelectExam)throws Throwable {
		cdor = cdorSelectExam;
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
		this.setTitle("Exámenes");
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
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(209, 14, 178, 24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("Selección de Exámen");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton21(), null);

		}
		return jContentPane;
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
			modelo = cdor.listarExam();
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
			jButton2.setBounds(new Rectangle(309, 332, 110, 26));
			jButton2.setFont(new Font("Arial", Font.BOLD, 12));
			jButton2.setText("Aceptar");
			jButton2.setBackground(Color.lightGray);
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Aceptar selectción exámen");
					cdor.actionAceptar(jTable1.getSelectedRow());
				}
			});
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
			jButton21.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar selectción exámen");
					cdor.actionCerrar();
				}
			});
		}
		return jButton21;
	}
}
