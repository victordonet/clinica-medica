package vista.ventanas;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import vista.controladores.CdorListadoAfil;
import vista.controladores.ModeloTablaListAfil;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.MessageFormat;

import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;

public class FrmListadoAfiliados extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelConImagen jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private ModeloTablaListAfil modelo = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private CdorListadoAfil cdor;
	private JButton jButton2 = null;
	private TableRowSorter<ModeloTablaListAfil> filtroId;
	private TableRowSorter<ModeloTablaListAfil> filtroNombre;
	private TableRowSorter<ModeloTablaListAfil> filtroApellido;
	private JButton jButton = null;
	private JButton jButton1 = null;

	/**
	 * This is the default constructor
	 * @throws Throwable
	 */
	public FrmListadoAfiliados(CdorListadoAfil cdorListadoAfil)throws Throwable {
		cdor = cdorListadoAfil;
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
			jLabel.setText("Listado: Afiliados");
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
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
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
			jTextField1.setBounds(new Rectangle(222, 70, 170, 19));
			jTextField1.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					filtroNombre = new TableRowSorter<ModeloTablaListAfil>(modelo);
				    jTable1.setRowSorter(filtroNombre);
					if(e.getSource()== jTextField1){
						//tomo el contenido del texto ingresado en el textfield
						String text = jTextField1.getText();
						//si todavia no se escribio nada
						//que no haya ningun filtro
						if (text.length() == 0) {
							filtroNombre.setRowFilter(null);
						} else {
							//se le agrega al sorter el filtro en la columna 2
							filtroNombre.setRowFilter(RowFilter.regexFilter(text,1));
						}
					}
					
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
					filtroApellido = new TableRowSorter<ModeloTablaListAfil>(modelo);
				    jTable1.setRowSorter(filtroApellido);
					if(e.getSource()== jTextField2){
						//tomo el contenido del texto ingresado en el textfield
						String text = jTextField2.getText();
						//si todavia no se escribio nada
						//que no haya ningun filtro
						if (text.length() == 0) {
							filtroApellido.setRowFilter(null);
						} else {
							//se le agrega al sorter el filtro en otra columna 3
							filtroApellido.setRowFilter(RowFilter.regexFilter(text,2));
						}
					}
					
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

					filtroId = new TableRowSorter<ModeloTablaListAfil>(modelo);
					jTable1.setRowSorter(filtroId);
					if(e.getSource()== jTextField){
						//tomo el contenido del texto ingresado en el textfield
						String text = jTextField.getText();
						//si todavia no se escribio nada
						//que no haya ningun filtro
						if (text.length() == 0) {
							filtroId.setRowFilter(null);
						} else {
							//se le agrega al sorter el filtro en la columna 1
							filtroId.setRowFilter(RowFilter.regexFilter(text, 0));
						}
					}

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
						e.consume();
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
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(65, 155, 475, 180));
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
		modelo = cdor.listarAfil();
	    return jTable1 = new JTable(modelo);
	}
	
	/**
	 * This method initializes jButton2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(176, 349, 110, 26));
			jButton2.setFont(new Font("Arial", Font.BOLD, 12));
			jButton2.setText("Cancelar");
			jButton2.setBackground(Color.lightGray);
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar selectción medicos");
					cdor.actionCerrar();
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(329, 349, 110, 26));
			jButton.setFont(new Font("Arial", Font.BOLD, 12));
			jButton.setText("Ver Detalle");
			jButton.setBackground(Color.lightGray);
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Ver Detalle Afiliado");
					String id = cdor.getvAfi().get(jTable1.getSelectedRow()).getId();
					cdor.setId(id);
					cdor.actionAceptar();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(558, 349, 28, 26));
			jButton1.setIcon(new ImageIcon("./fondos/Impresora.jpg"));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
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
		return jButton1;
	}
}
