package grafica.vistas;

import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import grafica.controladores.CdorMenuInfo;

import javax.swing.ImageIcon;

public class FrmMenuInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btExamen = null;
	private JButton btTecnica = null;
	private JButton btHallazgos = null;
	private JButton btGraficas = null;
	private CdorMenuInfo cdor;
	private JButton btImagen1 = null;
	private JButton btImagen2 = null;
	private JButton btImagen3 = null;
	private JButton btImagen4 = null;
	private JButton btDescripcion = null;

	public FrmMenuInfo(CdorMenuInfo cdorMenuHist) {
		super();
		this.cdor = cdorMenuHist;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(300	,433));
		this.setLocation(205,140);	
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
			panelFondo = new PanelConImagen("./src/imagenes/fondoInfo.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtExamen(), null);
			panelFondo.add(getBtTecnica(), null);
			panelFondo.add(getBtHallazgos(), null);
			panelFondo.add(getBtImagen1(), null);
			panelFondo.add(getBtGraficas(), null);
			panelFondo.add(getBtImagen2(), null);
			panelFondo.add(getBtImagen3(), null);
			panelFondo.add(getBtImagen4(), null);
			panelFondo.add(getBtDescripcion(), null);
		}
		return panelFondo;
	}

	private JButton getbtExamen() {
		if (btExamen == null) {
			btExamen = new JButton();
			btExamen.setBounds(new Rectangle(15, 90, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnExamen.jpg");
			btExamen.setIcon(icono);
			btExamen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Datos");
					cdor.deshabilitarVentana();
					btImagen1.setVisible(false);
					btImagen2.setVisible(false);
					btImagen3.setVisible(false);
					btImagen4.setVisible(false);
					btDescripcion.setVisible(false);
					cdor.actionExamen();
				}
			});
		}
		return btExamen;
	}

	private JButton getBtTecnica() {
		if (btTecnica == null) {
			btTecnica = new JButton();
			btTecnica.setBounds(new Rectangle(15, 150, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnTecnica.jpg");
			btTecnica.setIcon(icono);
			btTecnica.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Técnica");
					btImagen1.setVisible(false);
					btImagen2.setVisible(false);
					btImagen3.setVisible(false);
					btImagen4.setVisible(false);
					btDescripcion.setVisible(false);
					cdor.deshabilitarVentana();
					cdor.actionTecnica();
				}
			});
		}
		return btTecnica;
	}

	private JButton getBtHallazgos() {
		if (btHallazgos == null) {
			btHallazgos = new JButton();
			btHallazgos.setBounds(new Rectangle(15, 210, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnHallazgos.jpg");
			btHallazgos.setIcon(icono);
			btHallazgos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Hallazgos Histeroscópicos");
					btImagen1.setVisible(false);
					btImagen2.setVisible(false);
					btImagen3.setVisible(false);
					btImagen4.setVisible(false);
					btDescripcion.setVisible(false);
					cdor.actionHallazgos();
				}
			});
		}
		return btHallazgos;
	}

	private JButton getBtImagen1() {
		if (btImagen1 == null) {
			btImagen1 = new JButton();
			btImagen1.setBounds(new Rectangle(15, 330, 40, 40));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnImagen1.jpg");
			btImagen1.setIcon(icono);
			btImagen1.setVisible(false);
			btImagen1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Imagne Utero");
					//cdor.deshabilitarVentana();
					cdor.actionCerrar();
					cdor.actionImgUtero();
				}
			});
		}
		return btImagen1;
	}

	private JButton getBtImagen2() {
		if (btImagen2 == null) {
			btImagen2 = new JButton();
			btImagen2.setBounds(new Rectangle(70, 330, 40, 40));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnImagen2.jpg");
			btImagen2.setIcon(icono);
			btImagen2.setVisible(false);
			btImagen2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Imagen Ovarios");
					//cdor.deshabilitarVentana();
					cdor.actionCerrar();
					cdor.actionImgOvarios();
				}
			});
		}
		return btImagen2;
	}

	private JButton getBtImagen3() {
		if (btImagen3 == null) {
			btImagen3 = new JButton();
			btImagen3.setBounds(new Rectangle(130, 330, 40, 40));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnImagen3.jpg");
			btImagen3.setIcon(icono);
			btImagen3.setVisible(false);
			btImagen3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Imagen Y");
					//cdor.deshabilitarVentana();
					cdor.actionCerrar();
					cdor.actionImgX();
				}
			});
		}
		return btImagen3;
	}

	private JButton getBtImagen4() {
		if (btImagen4 == null) {
			btImagen4 = new JButton();
			btImagen4.setBounds(new Rectangle(185, 330, 40, 40));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnImagen4.jpg");
			btImagen4.setIcon(icono);
			btImagen4.setVisible(false);
			btImagen4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Imagen Y");
					//cdor.deshabilitarVentana();
					cdor.actionCerrar();
					cdor.actionImgY();
				}
			});
		}
		return btImagen4;
	}

	private JButton getBtDescripcion() {
		if (btDescripcion == null) {
			btDescripcion = new JButton();
			btDescripcion.setBounds(new Rectangle(240, 330, 40, 40));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnDescripcion.jpg");
			btDescripcion.setIcon(icono);
			btDescripcion.setVisible(false);
			btDescripcion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Descripcion");
					//cdor.deshabilitarVentana();
					cdor.actionDesc();
				}
			});
		}
		return btDescripcion;
	}
	
	private JButton getBtGraficas() {
		if (btGraficas == null) {
			btGraficas = new JButton();
			btGraficas.setBounds(new Rectangle(15, 270, 265, 53));
			btGraficas.setIcon(new ImageIcon("./src/imagenes/BtnGrafica.jpg"));
			btGraficas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Descripción Gráfica");
					btImagen1.setVisible(true);
					btImagen2.setVisible(true);
					btImagen3.setVisible(true);
					btImagen4.setVisible(true);
					btDescripcion.setVisible(true);
				}
			});
		}
		return btGraficas;
	}
}