package grafica.vistas;

import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import grafica.controladores.CdorObservaciones;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmObservaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorObservaciones cdor;
	private JTextArea txtObs = null;
	private JScrollPane jScrollObs = null;
	
	public FrmObservaciones(CdorObservaciones cdor) {
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
		panelFondo = new PanelConImagen("./src/imagenes/fondoObs.jpg");
		panelFondo.setLayout(null);
		panelFondo.setBackground(new java.awt.Color(80,80,80));
		panelFondo.add(getbtGuardar(), null);
		panelFondo.add(getbtCancelar(), null);
		panelFondo.add(getbtGuardar(), null);
		panelFondo.add(getJScrollObs(), null);
		}
		return panelFondo;
	}

	private JTextArea getTxtObs() {
		if (txtObs == null) {
			txtObs = new JTextArea();
			txtObs.setFont(new Font("Calibri", Font.PLAIN, 13));
			txtObs.addKeyListener(new KeyAdapter()
			{
				   public void keyTyped(KeyEvent e)
				   {
					  //Controlar el largo del text
					  String s = txtObs.getText();
					  int n=s.length();
					  if(n >= 255){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
			return txtObs;
	}

	/**
	 * This method initializes jScrollObs	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollObs() {
		if (jScrollObs == null) {
			jScrollObs = new JScrollPane();
			jScrollObs.setBounds(new Rectangle(88, 109, 978, 177));
			jScrollObs.setViewportView(getTxtObs());
		}
		return jScrollObs;
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
}