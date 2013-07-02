package grafica.vistas;

import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import grafica.controladores.CdorMenu;
import javax.swing.ImageIcon;

public class FrmMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btDatos = null;
	private JButton btHist = null;
	private JButton btInfo = null;
	private CdorMenu cdor;

	public FrmMenu(CdorMenu cdor) {
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(197	,590));
		this.setLocation(5,60);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/imagenes/miniMederi.png"));
		this.setResizable(false);
		this.setTitle("");
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
			panelFondo = new PanelConImagen("./src/imagenes/menu.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtDatos(), null);
			panelFondo.add(getbtHist(), null);
			panelFondo.add(getbtInfo(), null);
		}
		return panelFondo;
	}

	private JButton getbtDatos() {
		if (btDatos == null) {
			btDatos = new JButton();
			btDatos.setBounds(new Rectangle(34, 70, 120, 120));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnDatos.jpg");
			btDatos.setIcon(icono);
			btDatos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Datos");
					cdor.deshabilitarVentana();
					cdor.actionDatos();
				}
			});
		}
		return btDatos;
	}
	
	private JButton getbtHist() {
		if (btHist == null) {
			btHist = new JButton();
			btHist.setBounds(new Rectangle(34, 205, 120, 120));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtHist.jpg");
			btHist.setIcon(icono);
			btHist.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Historia");
					cdor.deshabilitarVentana();
					cdor.actionHistoria();
				}
			});
		}
		return btHist;
	}
	
	private JButton getbtInfo() {
		if (btInfo == null) {
			btInfo = new JButton();
			btInfo.setBounds(new Rectangle(34, 340, 120, 120));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtInfo.jpg");
			btInfo.setIcon(icono);
			btInfo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Informe");
					cdor.deshabilitarVentana();
					cdor.actionInforme();
				}
			});
		}
		return btInfo;
	}
}