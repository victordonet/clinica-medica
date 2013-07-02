package grafica.vistas;

import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import grafica.controladores.CdorMenuHist;

import javax.swing.ImageIcon;

public class FrmMenuHist extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btAntecedentes = null;
	private JButton btHormonal = null;
	private JButton btHister = null;
	private JButton btParaclinica = null;
	private JButton btAnatomia= null;
	private JButton btObs = null;
	private CdorMenuHist cdor;
	private JButton btIndHist = null;

	public FrmMenuHist(CdorMenuHist cdorMenuHist) {
		super();
		this.cdor = cdorMenuHist;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(300	,550));
		this.setLocation(210,80);
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
			panelFondo = new PanelConImagen("./src/imagenes/fondoHist.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtAntecedentes(), null);
			panelFondo.add(getBtHormonal(), null);
			panelFondo.add(getBtHister(), null);
			panelFondo.add(getBtParaclinica(), null);
			panelFondo.add(getBtAnatomia(), null);
			panelFondo.add(getBtObs(), null);
			panelFondo.add(getBtIndHist(), null);
		}
		return panelFondo;
	}

	private JButton getbtAntecedentes() {
		if (btAntecedentes == null) {
			btAntecedentes = new JButton();
			btAntecedentes.setBounds(new Rectangle(15, 90, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnAntecedentes.jpg");
			btAntecedentes.setIcon(icono);
			btAntecedentes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Antecedentes");
					cdor.deshabilitarVentana();
					cdor.actionAntecedentes();
				}
			});
		}
		return btAntecedentes;
	}

	private JButton getBtHormonal() {
		if (btHormonal == null) {
			btHormonal = new JButton();
			btHormonal.setBounds(new Rectangle(15, 150, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnHormonal.jpg");
			btHormonal.setIcon(icono);
			btHormonal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Hormonal");
					cdor.deshabilitarVentana();
					cdor.actionHormonal();
				}
			});
		}
		return btHormonal;
	}

	private JButton getBtHister() {
		if (btHister == null) {
			btHister = new JButton();
			btHister.setBounds(new Rectangle(15, 210, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnHisterPrevia.jpg");
			btHister.setIcon(icono);
			btHister.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Histeroscopia Previa");
					cdor.deshabilitarVentana();
					cdor.actionHister();
				}
			});
		}
		return btHister;
	}

	private JButton getBtParaclinica() {
		if (btParaclinica == null) {
			btParaclinica = new JButton();
			btParaclinica.setBounds(new Rectangle(15, 270, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnParaclinica.jpg");
			btParaclinica.setIcon(icono);
			btParaclinica.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Paraclinica");
					cdor.deshabilitarVentana();
					cdor.actionParaclinica();
				}
			});
		}
		return btParaclinica;
	}

	private JButton getBtAnatomia() {
		if (btAnatomia == null) {
			btAnatomia = new JButton();
			btAnatomia.setBounds(new Rectangle(15, 330, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnAnatomia.jpg");
			btAnatomia.setIcon(icono);
			btAnatomia.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Anatomia Patologica");
					cdor.deshabilitarVentana();
					cdor.actionAnatomia();
				}
			});
		}
		return btAnatomia;
	}

	private JButton getBtObs() {
		if (btObs == null) {
			btObs = new JButton();
			btObs.setBounds(new Rectangle(15, 451, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnObservaciones.jpg");
			btObs.setIcon(icono);
			btObs.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Anatomia Patologica");
					cdor.deshabilitarVentana();
					cdor.actionObs();
				}
			});
		}
		return btObs;
	}

	/**
	 * This method initializes btIndHist	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtIndHist() {
		if (btIndHist == null) {
			btIndHist = new JButton();
			btIndHist.setBounds(new Rectangle(15, 390, 265, 53));
			ImageIcon icono = new ImageIcon("./src/imagenes/BtnIndHister.jpg");
			btIndHist.setIcon(icono);
			btIndHist.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Indicaciones de la Histeroscopia");
					cdor.deshabilitarVentana();
					cdor.actionIndHist();
				}
			});
		}
		return btIndHist;
	}
}