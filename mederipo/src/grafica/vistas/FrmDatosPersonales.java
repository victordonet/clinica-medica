package grafica.vistas;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import grafica.controladores.CdorDatosPersonales;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

public class FrmDatosPersonales extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorDatosPersonales cdor;
	private JLabel lbNombre = null;
	private JLabel lbEdad = null;
	private JLabel lbDireccion = null;
	private JLabel lbCiudad = null;
	private JLabel lbTelefono = null;
	private JLabel lbMedico = null;
	private JLabel lbAmbulatorio = null;
	private JLabel lbFechaIng = null;
	private JLabel lbInstitucion = null;
	private JLabel lbNroRegistro = null;
	private JLabel lbNroCaso = null;
	private JLabel lbNroVideo = null;
	private JLabel lbFecha = null;
	private JLabel lbNroOrden = null;
	private JLabel lbFUM = null;
	private JLabel lbIndicacion = null;
	private JTextField txtNombre = null;
	private JTextField txtEdad = null;
	private JTextField txtDireccion = null;
	private JTextField txtCiudad = null;
	private JTextField txtTelefono = null;
	private JTextField txtMedico = null;
	private JTextField txtIndicacion = null;
	private JTextField txtInstitucion = null;
	private JTextField txtNroRegistro = null;
	private JTextField txtNroCaso = null;
	private JTextField txtNroVideo = null;
	private JTextField txtNroOrden = null;
	private JPanel jPanelFechaIng = null;
	private JPanel jPanelFecha = null;
	private JPanel jPanelFUM = null;
	JDateChooser calendarIng = new JDateChooser();
	JDateChooser calendar = new JDateChooser();
	JDateChooser calendarFUM = new JDateChooser();
	private JRadioButton jRadio_1 = null;
	private JRadioButton jRadio_2 = null;
	private ButtonGroup group = new ButtonGroup();
	
	public FrmDatosPersonales(CdorDatosPersonales cdor) {
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(1164,732));
		this.setLocation(200,0);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/imagenes/miniMederi.png"));
		this.setResizable(false);
		this.setTitle("MEDERI-PRO");
		this.setContentPane(getJContentPane());
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
			cdor.actionCerrar();
			}
		});
	}

	public void frmDisable(){
		this.setEnabled(false);
	}

	public void frmEnable(){
		this.setEnabled(true);
		this.setVisible(true);
	}
	
	private PanelConImagen getJContentPane() {
		if (panelFondo == null) {
		lbFUM = new JLabel();
		lbFUM.setBounds(new Rectangle(390, 517, 115, 22));
		lbFUM.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFUM.setText("F.U.M.");
		lbFUM.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbNroOrden = new JLabel();
		lbNroOrden.setBounds(new Rectangle(390, 467, 115, 22));
		lbNroOrden.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNroOrden.setText("N° Orden:");
		lbNroOrden.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbFecha = new JLabel();
		lbFecha.setBounds(new Rectangle(390, 492, 115, 22));
		lbFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFecha.setText("Fecha:");
		lbFecha.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbNroVideo = new JLabel();
		lbNroVideo.setBounds(new Rectangle(390, 442, 115, 22));
		lbNroVideo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNroVideo.setText("N° Video:");
		lbNroVideo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbNroCaso = new JLabel();
		lbNroCaso.setBounds(new Rectangle(390, 417, 115, 22));
		lbNroCaso.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNroCaso.setText("N° Caso:");
		lbNroCaso.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbNroRegistro = new JLabel();
		lbNroRegistro.setBounds(new Rectangle(390, 392, 115, 22));
		lbNroRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNroRegistro.setText("N° Registro:");
		lbNroRegistro.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbInstitucion = new JLabel();
		lbInstitucion.setBounds(new Rectangle(390, 367, 115, 22));
		lbInstitucion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbInstitucion.setText("Institución:");
		lbInstitucion.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbFechaIng = new JLabel();
		lbFechaIng.setBounds(new Rectangle(391, 304, 115, 22));
		lbFechaIng.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFechaIng.setText("Fecha Ingreso:");
		lbFechaIng.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbAmbulatorio = new JLabel();
		lbAmbulatorio.setBounds(new Rectangle(391, 254, 115, 22));
		lbAmbulatorio.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAmbulatorio.setText("Atención");
		lbAmbulatorio.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbIndicacion = new JLabel();
		lbIndicacion.setBounds(new Rectangle(391, 229, 115, 22));
		lbIndicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbIndicacion.setText("Indicación:");
		lbIndicacion.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbMedico = new JLabel();
		lbMedico.setBounds(new Rectangle(391, 204, 115, 22));
		lbMedico.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMedico.setText("Médico Tratante:");
		lbMedico.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbTelefono = new JLabel();
		lbTelefono.setBounds(new Rectangle(661, 179, 65, 22));
		lbTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTelefono.setText("Teléfono:");
		lbTelefono.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbCiudad = new JLabel();
		lbCiudad.setBounds(new Rectangle(390, 179, 115, 22));
		lbCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCiudad.setText("Ciudad:");
		lbCiudad.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbDireccion = new JLabel();
		lbDireccion.setBounds(new Rectangle(391, 154, 115, 22));
		lbDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDireccion.setText("Dirección:");
		lbDireccion.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbEdad = new JLabel();
		lbEdad.setBounds(new Rectangle(776, 129, 40, 22));
		lbEdad.setText("Edad:");
		lbEdad.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNombre = new JLabel();
		lbNombre.setBounds(new Rectangle(391, 129, 115, 22));
		lbNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbNombre.setText("Nombre:");
		panelFondo = new PanelConImagen("./src/imagenes/fondoDatos.jpg");
		panelFondo.setLayout(null);
		panelFondo.setBackground(new java.awt.Color(80,80,80));
		panelFondo.add(getbtGuardar(), null);
		panelFondo.add(lbNombre, null);
		panelFondo.add(lbEdad, null);
		panelFondo.add(lbDireccion, null);
		panelFondo.add(lbCiudad, null);
		panelFondo.add(lbTelefono, null);
		panelFondo.add(lbMedico, null);
		panelFondo.add(lbAmbulatorio, null);
		panelFondo.add(lbFechaIng, null);
		panelFondo.add(lbInstitucion, null);
		panelFondo.add(lbNroRegistro, null);
		panelFondo.add(lbNroCaso, null);
		panelFondo.add(lbNroVideo, null);
		panelFondo.add(lbFecha, null);
		panelFondo.add(lbNroOrden, null);
		panelFondo.add(lbFUM, null);
		panelFondo.add(lbIndicacion, null);
		panelFondo.add(getTxtNombre(), null);
		panelFondo.add(getTxtEdad(), null);
		panelFondo.add(getTxtDireccion(), null);
		panelFondo.add(getTxtCiudad(), null);
		panelFondo.add(getTxtTelefono(), null);
		panelFondo.add(getTxtMedico(), null);
		panelFondo.add(getTxtIndicacion(), null);
		panelFondo.add(getTxtInstitucion(), null);
		panelFondo.add(getTxtNroRegistro(), null);
		panelFondo.add(getTxtNroCaso(), null);
		panelFondo.add(getTxtNroVideo(), null);
		panelFondo.add(getTxtNroOrden(), null);
		panelFondo.add(getJPanelFechaIng(), null);
		panelFondo.add(getJPanelFecha(), null);
		panelFondo.add(getJPanelFUM(), null);
		panelFondo.add(getJRadio_1(), null);
		panelFondo.add(getJRadio_2(), null);
		panelFondo.add(getbtCancelar(), null);
		panelFondo.add(getbtGuardar(), null);
		group.add(jRadio_1);
		group.add(jRadio_2);
		}
		return panelFondo;
	}

	private JButton getbtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setBounds(new Rectangle(1101, 621, 40, 40));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnGuardar.jpg");
			btGuardar.setIcon(icono);
			btGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Guardar");
				}
			});
		}
		return btGuardar;
	}
	
	private JButton getbtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton();
			btCancelar.setBounds(new Rectangle(1051, 621, 40, 40));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnCancelar.jpg");
			btCancelar.setIcon(icono);
			btCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Cancelar");
					cdor.actionCerrar();
				}
			});
		}
		return btCancelar;
	}

	/**
	 * This method initializes txtNombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(new Rectangle(511, 129, 260, 22));
			txtNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtNombre.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtNombre.getText();
				  int n=s.length();
				  if(n >= 60){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtNombre;
	}

	/**
	 * This method initializes txtEdad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEdad() {
		if (txtEdad == null) {
			txtEdad = new JTextField();
			txtEdad.setBounds(new Rectangle(817, 129, 35, 22));
			txtEdad.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtEdad.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||
						   (caracter > '9')) &&
						   (caracter != KeyEvent.VK_BACK_SPACE))
				   {
					   e.consume();  // ignorar el evento de teclado
				   }

				  //Controlar el largo del text
				  String s = txtEdad.getText();
				  int n=s.length();
				  if(n >= 2){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtEdad;
	}

	/**
	 * This method initializes txtDireccion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDireccion() {
		if (txtDireccion == null) {
			txtDireccion = new JTextField();
			txtDireccion.setBounds(new Rectangle(511, 154, 340, 22));
			txtDireccion.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtDireccion.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtDireccion.getText();
				  int n=s.length();
				  if(n >= 100){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtDireccion;
	}

	/**
	 * This method initializes txtCiudad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCiudad() {
		if (txtCiudad == null) {
			txtCiudad = new JTextField();
			txtCiudad.setBounds(new Rectangle(511, 179, 150, 22));
			txtCiudad.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtCiudad.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtCiudad.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtCiudad;
	}

	/**
	 * This method initializes txtTelefono	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTelefono() {
		if (txtTelefono == null) {
			txtTelefono = new JTextField();
			txtTelefono.setBounds(new Rectangle(729, 179, 122, 22));
			txtTelefono.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtTelefono.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||
						   (caracter > '9')) &&
						   (caracter != KeyEvent.VK_BACK_SPACE))
				   {
					   e.consume();  // ignorar el evento de teclado
				   }

				  //Controlar el largo del text
				  String s = txtTelefono.getText();
				  int n=s.length();
				  if(n >= 15){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtTelefono;
	}

	/**
	 * This method initializes txtMedico	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtMedico() {
		if (txtMedico == null) {
			txtMedico = new JTextField();
			txtMedico.setBounds(new Rectangle(511, 204, 340, 22));
			txtMedico.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtMedico.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtMedico.getText();
				  int n=s.length();
				  if(n >= 60){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtMedico;
	}

	/**
	 * This method initializes txtIndicacion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtIndicacion() {
		if (txtIndicacion == null) {
			txtIndicacion = new JTextField();
			txtIndicacion.setBounds(new Rectangle(511, 229, 340, 22));
			txtIndicacion.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtIndicacion.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtIndicacion.getText();
				  int n=s.length();
				  if(n >= 60){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtIndicacion;
	}
	
	/**
	 * This method initializes txtInstitucion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtInstitucion() {
		if (txtInstitucion == null) {
			txtInstitucion = new JTextField();
			txtInstitucion.setBounds(new Rectangle(510, 367, 341, 22));
			txtInstitucion.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtInstitucion.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtInstitucion.getText();
				  int n=s.length();
				  if(n >= 60){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtInstitucion;
	}

	/**
	 * This method initializes txtNroRegistro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNroRegistro() {
		if (txtNroRegistro == null) {
			txtNroRegistro = new JTextField();
			txtNroRegistro.setBounds(new Rectangle(510, 392, 100, 22));
			txtNroRegistro.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtNroRegistro.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||
						   (caracter > '9')) &&
						   (caracter != KeyEvent.VK_BACK_SPACE))
				   {
					   e.consume();  // ignorar el evento de teclado
				   }

				  //Controlar el largo del text
				  String s = txtNroRegistro.getText();
				  int n=s.length();
				  if(n >= 10){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtNroRegistro;
	}

	/**
	 * This method initializes txtNroCaso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNroCaso() {
		if (txtNroCaso == null) {
			txtNroCaso = new JTextField();
			txtNroCaso.setBounds(new Rectangle(510, 417, 50, 22));
			txtNroCaso.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtNroCaso.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||
						   (caracter > '9')) &&
						   (caracter != KeyEvent.VK_BACK_SPACE))
				   {
					   e.consume();  // ignorar el evento de teclado
				   }

				  //Controlar el largo del text
				  String s = txtNroCaso.getText();
				  int n=s.length();
				  if(n >= 4){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtNroCaso;
	}

	/**
	 * This method initializes txtNroVideo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNroVideo() {
		if (txtNroVideo == null) {
			txtNroVideo = new JTextField();
			txtNroVideo.setBounds(new Rectangle(510, 442, 35, 22));
			txtNroVideo.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtNroVideo.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||
						   (caracter > '9')) &&
						   (caracter != KeyEvent.VK_BACK_SPACE))
				   {
					   e.consume();  // ignorar el evento de teclado
				   }

				  //Controlar el largo del text
				  String s = txtNroVideo.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtNroVideo;
	}

	/**
	 * This method initializes txtNroOrden	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNroOrden() {
		if (txtNroOrden == null) {
			txtNroOrden = new JTextField();
			txtNroOrden.setBounds(new Rectangle(510, 467, 25, 22));
			txtNroOrden.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtNroOrden.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
				   // Verificar si la tecla pulsada no es un digito
				   char caracter = e.getKeyChar();
				   if(((caracter < '0') ||
						   (caracter > '9')) &&
						   (caracter != KeyEvent.VK_BACK_SPACE))
				   {
					   e.consume();  // ignorar el evento de teclado
				   }

				  //Controlar el largo del text
				  String s = txtNroOrden.getText();
				  int n=s.length();
				  if(n >= 2){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtNroOrden;
	}

	private JPanel getJPanelFechaIng() {
		if (jPanelFechaIng == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jPanelFechaIng = new JPanel();
			jPanelFechaIng.setLayout(gridLayout1);
			jPanelFechaIng.setBounds(new Rectangle(511, 304, 100, 22));
			jPanelFechaIng.add(calendarIng, null);
		}
		return jPanelFechaIng;
	}
	
	private JPanel getJPanelFecha() {
		if (jPanelFecha == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jPanelFecha = new JPanel();
			jPanelFecha.setLayout(gridLayout1);
			jPanelFecha.setBounds(new Rectangle(511, 492, 100, 22));
			jPanelFecha.add(calendar, null);
		}
		return jPanelFecha;
	}
	
	private JPanel getJPanelFUM() {
		if (jPanelFUM == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jPanelFUM = new JPanel();
			jPanelFUM.setLayout(gridLayout1);
			jPanelFUM.setBounds(new Rectangle(511, 517, 100, 22));
			jPanelFUM.add(calendarFUM, null);
		}
		return jPanelFUM;
	}

	/**
	 * This method initializes jRadio_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadio_1() {
		if (jRadio_1 == null) {
			jRadio_1 = new JRadioButton();
			jRadio_1.setText("Ambulatorio");
			jRadio_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			jRadio_1.setBounds(new Rectangle(511, 254, 114, 21));
			jRadio_1.setBackground(new java.awt.Color(204,204,204));
		}
		return jRadio_1;
	}

	private JRadioButton getJRadio_2() {
		if (jRadio_2 == null) {
			jRadio_2 = new JRadioButton();
			jRadio_2.setText("Hospitalización");
			jRadio_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			jRadio_2.setBounds(new Rectangle(511, 278, 117, 22));
			jRadio_2.setBackground(new java.awt.Color(204,204,204));
		}
		return jRadio_2;
	}
}