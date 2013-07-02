package grafica.vistas;

import grafica.controladores.CdorHisteroscopia;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class FrmHisteroscopia extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorHisteroscopia cdor;
	private JRadioButton rdoQuir_1 = null;
	private JRadioButton rdoQuir_2 = null;
	private JRadioButton rdoQuir_3 = null;
	private JRadioButton rdoQuir_5 = null;
	private JTextField txtAnat_1 = null;
	private JRadioButton rdoDiag_1 = null;
	private JRadioButton rdoDiag_2 = null;
	private ButtonGroup grpDiag = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpQuir = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpDiu_Tipo = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpDiu_Retiro = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpDiu_Tiempo = new ButtonGroup();  //  @jve:decl-index=0:
	private JRadioButton rdoQuir_4 = null;
	private JRadioButton rdoDiu_1 = null;
	private JRadioButton rdoDiu_2 = null;
	private JRadioButton rdoDiu_3 = null;
	private JRadioButton rdoRet_1 = null;
	private JRadioButton rdoRet_2 = null;
	private JTextField txtAnat_2 = null;
	private JRadioButton rdoMediTiempo_1 = null;
	private JRadioButton rdoMediTiempo_2 = null;
	private JLabel lblAnatomia = null;
	private JLabel lblTipo = null;
	private JLabel lblTiempo = null;
	private JLabel lblRetiro = null;
	private JRadioButton rdoQuir_6 = null;
	private JCheckBox chkNo = null;
	private JButton btnCodigos = null;
	
	public FrmHisteroscopia(CdorHisteroscopia cdor) {
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(717,379));
		this.setLocation(520,160);
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
			lblRetiro = new JLabel();
			lblRetiro.setBounds(new Rectangle(459, 258, 54, 21));
			lblRetiro.setText("RETIRO");
			lblRetiro.setFont(new Font("Calibri", Font.BOLD, 14));
			lblTiempo = new JLabel();
			lblTiempo.setBounds(new Rectangle(459, 209, 100, 23));
			lblTiempo.setText("TIEMPO DE USO");
			lblTiempo.setFont(new Font("Calibri", Font.BOLD, 14));
			lblTipo = new JLabel();
			lblTipo.setBounds(new Rectangle(459, 126, 38, 22));
			lblTipo.setText("TIPO");
			lblTipo.setFont(new Font("Calibri", Font.BOLD, 14));
			lblAnatomia = new JLabel();
			lblAnatomia.setBounds(new Rectangle(18, 176, 161, 22));
			lblAnatomia.setText("ANATOMIA PATOLOGICA");
			lblAnatomia.setFont(new Font("Calibri", Font.BOLD, 14));
			panelFondo = new PanelConImagen("./src/imagenes/fondoHistPrevia.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(getRdoQuir_1(), null);
			panelFondo.add(getRdoQuir_2(), null);
			panelFondo.add(getRdoQuir_3(), null);
			panelFondo.add(getRdoQuir_5(), null);
			panelFondo.add(getTxtAnat_1(), null);
			panelFondo.add(getRdoDiag_1(), null);
			panelFondo.add(getRdoDiag_2(), null);
			panelFondo.add(getRdoQuir_4(), null);
			panelFondo.add(getRdoDiu_1(), null);
			panelFondo.add(getRdoDiu_2(), null);
			panelFondo.add(getRdoDiu_3(), null);
			panelFondo.add(getRdoRet_1(), null);
			panelFondo.add(getRdoRet_2(), null);
			panelFondo.add(getTxtAnat_2(), null);
			panelFondo.add(getRdoMediTiempo_1(), null);
			panelFondo.add(getRdoMediTiempo_2(), null);
			panelFondo.add(lblAnatomia, null);
			panelFondo.add(lblTipo, null);
			panelFondo.add(lblTiempo, null);
			panelFondo.add(lblRetiro, null);
			panelFondo.add(getRdoQuir_6(), null);
			panelFondo.add(getChkNo(), null);
			panelFondo.add(getBtnCodigos(), null);
			panelFondo.add(getbtGuardar(), null);
			grpQuir.add(rdoQuir_1);
			grpQuir.add(rdoQuir_2);
			grpQuir.add(rdoQuir_3);
			grpQuir.add(rdoQuir_4);
			grpQuir.add(rdoQuir_5);
			grpQuir.add(rdoQuir_6);
			grpDiag.add(rdoDiag_1);
			grpDiag.add(rdoDiag_2);
			grpDiu_Tipo.add(rdoDiu_1);
			grpDiu_Tipo.add(rdoDiu_2);
			grpDiu_Tipo.add(rdoDiu_3);
			grpDiu_Retiro.add(rdoRet_1);
			grpDiu_Retiro.add(rdoRet_2);
			grpDiu_Tiempo.add(rdoMediTiempo_1);
			grpDiu_Tiempo.add(rdoMediTiempo_2);
		}
		return panelFondo;
	}

	private JButton getbtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setBounds(new Rectangle(662, 302, 40, 40));
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
			btCancelar.setBounds(new Rectangle(612, 302, 40, 40));
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

	private JRadioButton getRdoQuir_1() {
		if (rdoQuir_1 == null) {
			rdoQuir_1 = new JRadioButton();
			rdoQuir_1.setBounds(new Rectangle(235, 123, 56, 22));
			rdoQuir_1.setText("NO");
			rdoQuir_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_1.setBackground(new java.awt.Color(204,204,204));
		}
		return rdoQuir_1;
	}

	private JRadioButton getRdoQuir_2() {
		if (rdoQuir_2 == null) {
			rdoQuir_2 = new JRadioButton();
			rdoQuir_2.setBounds(new Rectangle(235, 148, 130, 22));
			rdoQuir_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_2.setText("POLIPECTOMIA");
			rdoQuir_2.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_2;
	}

	private JRadioButton getRdoQuir_3() {
		if (rdoQuir_3 == null) {
			rdoQuir_3 = new JRadioButton();
			rdoQuir_3.setBounds(new Rectangle(235, 173, 140, 22));
			rdoQuir_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_3.setText("MIOMECTOMIA");
			rdoQuir_3.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_3;
	}

	private JRadioButton getRdoQuir_5() {
		if (rdoQuir_5 == null) {
			rdoQuir_5 = new JRadioButton();
			rdoQuir_5.setBounds(new Rectangle(235, 223, 137, 22));
			rdoQuir_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_5.setText("RESECC. TABIQUE");
			rdoQuir_5.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_5;
	}

	private JTextField getTxtAnat_1() {
		if (txtAnat_1 == null) {
			txtAnat_1 = new JTextField();
			txtAnat_1.setBounds(new Rectangle(79, 210, 30, 22));
			txtAnat_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtAnat_1.addKeyListener(new KeyAdapter()
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
					  String s = txtAnat_1.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtAnat_1;
	}

	private JRadioButton getRdoDiag_1() {
		if (rdoDiag_1 == null) {
			rdoDiag_1 = new JRadioButton();
			rdoDiag_1.setBounds(new Rectangle(13, 122, 130, 22));
			rdoDiag_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiag_1.setText("NO");
			rdoDiag_1.setBackground(new Color(204, 204, 204));
		}
		return rdoDiag_1;
	}

	private JRadioButton getRdoDiag_2() {
		if (rdoDiag_2 == null) {
			rdoDiag_2 = new JRadioButton();
			rdoDiag_2.setBounds(new Rectangle(13, 147, 130, 22));
			rdoDiag_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiag_2.setText("SI");
			rdoDiag_2.setBackground(new Color(204, 204, 204));
		}
		return rdoDiag_2;
	}

	/**
	 * This method initializes rdoQuir_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_4() {
		if (rdoQuir_4 == null) {
			rdoQuir_4 = new JRadioButton();
			rdoQuir_4.setBounds(new Rectangle(235, 198, 117, 23));
			rdoQuir_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_4.setText("ADHESIOLISIS");
			rdoQuir_4.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_4;
	}

	/**
	 * This method initializes rdoDiu_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoDiu_1() {
		if (rdoDiu_1 == null) {
			rdoDiu_1 = new JRadioButton();
			rdoDiu_1.setBounds(new Rectangle(502, 127, 78, 22));
			rdoDiu_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiu_1.setText("LIPPES");
			rdoDiu_1.setBackground(new Color(204, 204, 204));
		}
		return rdoDiu_1;
	}

	/**
	 * This method initializes rdoDiu_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoDiu_2() {
		if (rdoDiu_2 == null) {
			rdoDiu_2 = new JRadioButton();
			rdoDiu_2.setBounds(new Rectangle(502, 152, 67, 22));
			rdoDiu_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiu_2.setText("T.Cu");
			rdoDiu_2.setBackground(new Color(204, 204, 204));
		}
		return rdoDiu_2;
	}

	/**
	 * This method initializes rdoDiu_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoDiu_3() {
		if (rdoDiu_3 == null) {
			rdoDiu_3 = new JRadioButton();
			rdoDiu_3.setBounds(new Rectangle(502, 177, 75, 22));
			rdoDiu_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiu_3.setText("OTRO");
			rdoDiu_3.setBackground(new Color(204, 204, 204));
		}
		return rdoDiu_3;
	}

	/**
	 * This method initializes rdoRet_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoRet_1() {
		if (rdoRet_1 == null) {
			rdoRet_1 = new JRadioButton();
			rdoRet_1.setBounds(new Rectangle(508, 258, 74, 22));
			rdoRet_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoRet_1.setText("< 1 año");
			rdoRet_1.setBackground(new Color(204, 204, 204));
		}
		return rdoRet_1;
	}

	/**
	 * This method initializes rdoRet_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoRet_2() {
		if (rdoRet_2 == null) {
			rdoRet_2 = new JRadioButton();
			rdoRet_2.setBounds(new Rectangle(508, 283, 73, 22));
			rdoRet_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoRet_2.setText("> 1 año");
			rdoRet_2.setBackground(new Color(204, 204, 204));
		}
		return rdoRet_2;
	}

	/**
	 * This method initializes txtAnat_2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtAnat_2() {
		if (txtAnat_2 == null) {
			txtAnat_2 = new JTextField();
			txtAnat_2.setBounds(new Rectangle(115, 210, 30, 22));
			txtAnat_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtAnat_2.addKeyListener(new KeyAdapter()
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
					  String s = txtAnat_2.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtAnat_2;
	}

	/**
	 * This method initializes rdoMediTiempo_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediTiempo_1() {
		if (rdoMediTiempo_1 == null) {
			rdoMediTiempo_1 = new JRadioButton();
			rdoMediTiempo_1.setBounds(new Rectangle(559, 210, 89, 22));
			rdoMediTiempo_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediTiempo_1.setText("< 6 meses");
			rdoMediTiempo_1.setBackground(new Color(204, 204, 204));
		}
		return rdoMediTiempo_1;
	}

	/**
	 * This method initializes rdoMediTiempo_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediTiempo_2() {
		if (rdoMediTiempo_2 == null) {
			rdoMediTiempo_2 = new JRadioButton();
			rdoMediTiempo_2.setBounds(new Rectangle(559, 233, 87, 22));
			rdoMediTiempo_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediTiempo_2.setText("> 6 meses");
			rdoMediTiempo_2.setBackground(new Color(204, 204, 204));
		}
		return rdoMediTiempo_2;
	}

	/**
	 * This method initializes rdoQuir_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_6() {
		if (rdoQuir_6 == null) {
			rdoQuir_6 = new JRadioButton();
			rdoQuir_6.setBounds(new Rectangle(235, 248, 158, 22));
			rdoQuir_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_6.setText("ENDOMETRECTOMIA");
			rdoQuir_6.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_6;
	}

	/**
	 * This method initializes chkNo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkNo() {
		if (chkNo == null) {
			chkNo = new JCheckBox();
			chkNo.setBounds(new Rectangle(15, 210, 49, 22));
			chkNo.setText("NO");
			chkNo.setBackground(new Color(204, 204, 204));
			chkNo.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chkNo.isSelected()){
						txtAnat_1.setEditable(true);
						txtAnat_2.setEditable(true);
						txtAnat_1.setText("");
						txtAnat_2.setText("");
						btnCodigos.setEnabled(true);
					}else{
						txtAnat_1.setEditable(false);
						txtAnat_2.setEditable(false);
						btnCodigos.setEnabled(false);
					}
				}
			});
		}
		return chkNo;
	}

	/**
	 * This method initializes btnCodigos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCodigos() {
		if (btnCodigos == null) {
			btnCodigos = new JButton();
			btnCodigos.setBounds(new Rectangle(115, 234, 77, 21));
			btnCodigos.setText("Códigos");
			btnCodigos.setFont(new Font("Calibri", Font.PLAIN, 12));
			btnCodigos.setBackground(new Color(179, 179, 179));
			btnCodigos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("ver Codigos");
					cdor.actionCodigos();
				}
			});
		}
		return btnCodigos;
	}
}