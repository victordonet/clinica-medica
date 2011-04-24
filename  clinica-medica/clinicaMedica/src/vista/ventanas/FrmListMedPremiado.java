package vista.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.text.MessageFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vista.controladores.CdorListMedPremiado;
import vista.controladores.ModeloTablaListMedPremiado;

public class FrmListMedPremiado extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private ModeloTablaListMedPremiado modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorListMedPremiado cdor;
	private JButton jButton21 = null;
	private JButton jButton = null;

	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmListMedPremiado(CdorListMedPremiado cdorListMedPremiado) throws Throwable {
		cdor = cdorListMedPremiado;
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
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(184, 13, 213, 24));
			jLabel.setForeground(new java.awt.Color(118,144,201));
			jLabel.setText("Listado: Medico Premiado");
			jLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			jContentPane = new PanelConImagen("./fondos/imgFondoGrl.jpg");
			jContentPane.setLayout(null);
			jContentPane.setForeground(java.awt.Color.white);
			jContentPane.setBackground(new java.awt.Color(80,80,80));
			jContentPane.add(jLabel, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton21(), null);

			jContentPane.add(getJButton(), null);
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
			modelo = cdor.listarMedPremiado();
			jTable1 = new JTable(modelo);
		}
		return jTable1;
	}

	/**
	 * This method initializes jButton21
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton21() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setBounds(new Rectangle(245, 340, 110, 26));
			jButton21.setFont(new Font("Arial", Font.BOLD, 12));
			jButton21.setText("Cancelar");
			jButton21.setBackground(Color.lightGray);
			jButton21.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cdor.actionCerrar();
				}
			});

		}
		return jButton21;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(558, 340, 28, 26));
			jButton.setIcon(new ImageIcon("./fondos/Impresora.jpg"));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MessageFormat encabezado = new MessageFormat("Page {0,number,integer}");
					
					try {
					
					jTable1.print(JTable.PrintMode.FIT_WIDTH, encabezado, null);
					
					} catch (java.awt.print.PrinterException f) {
					
					System.err.format("No se puede imprimir %s%n", f.getMessage());
					
					}
					
				}
			});
		}
		return jButton;
	}
}
