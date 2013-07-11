package grafica.vistas;

import grafica.controladores.CdorExamenClinico;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FrmExamenClinico extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorExamenClinico cdor;
	private JLabel lblPosicion = null;
	private JLabel lblTamano = null;
	private JRadioButton rdoAVF = null;
	private JRadioButton rdoRVF = null;
	private JRadioButton rdoPRO = null;
	private JRadioButton rdoOtro = null;
	private JTextField txtOtra = null;
	private JRadioButton rdoNoEsp = null;
	private JRadioButton rdoMenor = null;
	private JRadioButton rdoMayor = null;
	private ButtonGroup grpPosicon = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpTamano = new ButtonGroup();  //  @jve:decl-index=0:
	
	public FrmExamenClinico(CdorExamenClinico cdor) {
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
			lblTamano = new JLabel();
			lblTamano.setBounds(new Rectangle(23, 316, 80, 22));
			lblTamano.setFont(new Font("Calibri", Font.BOLD, 14));
			lblTamano.setText("TAMAÑO");
			lblPosicion = new JLabel();
			lblPosicion.setBounds(new Rectangle(23, 165, 80, 22));
			lblPosicion.setFont(new Font("Calibri", Font.BOLD, 14));
			lblPosicion.setText("POSICION");
			panelFondo = new PanelConImagen("./src/imagenes/fondoExamen.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(lblPosicion, null);
			panelFondo.add(lblTamano, null);
			panelFondo.add(getRdoAVF(), null);
			panelFondo.add(getRdoRVF(), null);
			panelFondo.add(getRdoPRO(), null);
			panelFondo.add(getRdoOtro(), null);
			panelFondo.add(getTxtOtra(), null);
			panelFondo.add(getRdoNoEsp(), null);
			panelFondo.add(getRdoMenor(), null);
			panelFondo.add(getRdoMayor(), null);
			panelFondo.add(getbtGuardar(), null);
			grpPosicon.add(rdoAVF);
			grpPosicon.add(rdoRVF);
			grpPosicon.add(rdoPRO);
			grpPosicon.add(rdoOtro);
			grpTamano.add(rdoNoEsp);
			grpTamano.add(rdoMenor);
			grpTamano.add(rdoMayor);
			
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

	private JRadioButton getRdoAVF() {
		if (rdoAVF == null) {
			rdoAVF = new JRadioButton();
			rdoAVF.setBounds(new Rectangle(38, 195, 100, 22));
			rdoAVF.setText("A.V.F.");
			rdoAVF.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAVF.setBackground(new java.awt.Color(204,204,204));
			rdoAVF.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtra.setEditable(false);
					txtOtra.setText("");
				}
			});
		}
		return rdoAVF;
	}

	private JRadioButton getRdoRVF() {
		if (rdoRVF == null) {
			rdoRVF = new JRadioButton();
			rdoRVF.setBounds(new Rectangle(38, 220, 100, 22));
			rdoRVF.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoRVF.setText("R.V.F.");
			rdoRVF.setBackground(new Color(204, 204, 204));
			rdoRVF.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtra.setEditable(false);
					txtOtra.setText("");
				}
			});
		}
		return rdoRVF;
	}

	private JRadioButton getRdoPRO() {
		if (rdoPRO == null) {
			rdoPRO = new JRadioButton();
			rdoPRO.setBounds(new Rectangle(38, 245, 100, 22));
			rdoPRO.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoPRO.setText("PROLAPSO");
			rdoPRO.setBackground(new Color(204, 204, 204));
			rdoPRO.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtra.setEditable(false);
					txtOtra.setText("");
				}
			});
		}
		return rdoPRO;
	}

	private JRadioButton getRdoOtro() {
		if (rdoOtro == null) {
			rdoOtro = new JRadioButton();
			rdoOtro.setBounds(new Rectangle(38, 270, 57, 22));
			rdoOtro.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoOtro.setText("OTRA");
			rdoOtro.setBackground(new Color(204, 204, 204));
			rdoOtro.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtra.setEditable(true);
				}
			});
		}
		return rdoOtro;
	}

	private JTextField getTxtOtra() {
		if (txtOtra == null) {
			txtOtra = new JTextField();
			txtOtra.setBounds(new Rectangle(99, 270, 323, 22));
			txtOtra.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtra.setEditable(false);
			txtOtra.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtra.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtra;
	}

	private JRadioButton getRdoNoEsp() {
		if (rdoNoEsp == null) {
			rdoNoEsp = new JRadioButton();
			rdoNoEsp.setBounds(new Rectangle(38, 346, 130, 22));
			rdoNoEsp.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoNoEsp.setText("NO ESPECIFICADO");
			rdoNoEsp.setBackground(new Color(204, 204, 204));
		}
		return rdoNoEsp;
	}

	private JRadioButton getRdoMenor() {
		if (rdoMenor == null) {
			rdoMenor = new JRadioButton();
			rdoMenor.setBounds(new Rectangle(38, 371, 100, 22));
			rdoMenor.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMenor.setText("< 2 MESES");
			rdoMenor.setBackground(new Color(204, 204, 204));
		}
		return rdoMenor;
	}

	private JRadioButton getRdoMayor() {
		if (rdoMayor == null) {
			rdoMayor = new JRadioButton();
			rdoMayor.setBounds(new Rectangle(38, 396, 100, 22));
			rdoMayor.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMayor.setText("> 2 MESES");
			rdoMayor.setBackground(new Color(204, 204, 204));
		}
		return rdoMayor;
	}
}