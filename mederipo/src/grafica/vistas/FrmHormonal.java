package grafica.vistas;

import grafica.controladores.CdorHormonal;
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

public class FrmHormonal extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorHormonal cdor;
	private JLabel lblACO = null;
	private JLabel lblTHR = null;
	private JRadioButton rdoMed_4 = null;
	private JRadioButton rdoMed_5 = null;
	private JRadioButton rdoMed_6 = null;
	private JRadioButton rdoMed_7 = null;
	private JTextField txtOtra = null;
	private JRadioButton rdoMed_1 = null;
	private JRadioButton rdoMed_2 = null;
	private JRadioButton rdoMed_3 = null;
	private ButtonGroup grpMedicacion = new ButtonGroup();  //  @jve:decl-index=0:
	private JLabel lblOtros = null;
	private JTextField txtOtros = null;
	private JTextField txtTHR = null;
	private JTextField txtACO = null;
	private JCheckBox chk_Med = null;
	private JCheckBox chk_Horm = null;
	private JLabel lblReg = null;
	private JLabel lblAdm = null;
	private JTextField txtACO_Reg = null;
	private JTextField txtTHR_Reg = null;
	private JTextField txtOtros_Reg = null;
	private JLabel lblUso_Horm = null;
	private JLabel lblmeses_horm = null;
	private JLabel lblCese_1 = null;
	private JLabel lblCese_1_2 = null;
	private JTextField txtACO_Uso = null;
	private JTextField txtACO_Cese = null;
	private JTextField txtTHR_Uso = null;
	private JTextField txtTHR_Cese = null;
	private JTextField txtOtros_Uso = null;
	private JTextField txtOtros_Cese = null;
	private JLabel lblUso_Med = null;
	private JLabel lblmeses_Med = null;
	private JTextField txtDig = null;
	private JTextField txtCort = null;
	private JTextField txtPsic = null;
	private JTextField txtAcid = null;
	private JTextField txtCoag = null;
	private JTextField txtAAS = null;
	
	public FrmHormonal(CdorHormonal cdor) {
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
			lblmeses_Med = new JLabel();
			lblmeses_Med.setBounds(new Rectangle(329, 341, 46, 16));
			lblmeses_Med.setText("en meses");
			lblmeses_Med.setFont(new Font("Calibri", Font.PLAIN, 11));
			lblUso_Med = new JLabel();
			lblUso_Med.setBounds(new Rectangle(334, 327, 32, 23));
			lblUso_Med.setText("USO");
			lblUso_Med.setFont(new Font("Calibri", Font.PLAIN, 12));
			lblCese_1_2 = new JLabel();
			lblCese_1_2.setBounds(new Rectangle(327, 160, 46, 16));
			lblCese_1_2.setText("en meses");
			lblCese_1_2.setFont(new Font("Calibri", Font.PLAIN, 11));
			lblCese_1 = new JLabel();
			lblCese_1.setBounds(new Rectangle(332, 146, 32, 23));
			lblCese_1.setText("CESE");
			lblCese_1.setFont(new Font("Calibri", Font.PLAIN, 12));
			lblmeses_horm = new JLabel();
			lblmeses_horm.setBounds(new Rectangle(275, 160, 52, 16));
			lblmeses_horm.setText("en meses");
			lblmeses_horm.setFont(new Font("Calibri", Font.PLAIN, 11));
			lblUso_Horm = new JLabel();
			lblUso_Horm.setBounds(new Rectangle(285, 146, 31, 23));
			lblUso_Horm.setText("USO");
			lblUso_Horm.setFont(new Font("Calibri", Font.PLAIN, 12));
			lblAdm = new JLabel();
			lblAdm.setBounds(new Rectangle(226, 160, 47, 16));
			lblAdm.setText("de adm.");
			lblAdm.setFont(new Font("Calibri", Font.PLAIN, 11));
			lblReg = new JLabel();
			lblReg.setBounds(new Rectangle(220, 146, 56, 23));
			lblReg.setText("REGIMEN");
			lblReg.setFont(new Font("Calibri", Font.PLAIN, 12));
			lblOtros = new JLabel();
			lblOtros.setBounds(new Rectangle(25, 232, 48, 22));
			lblOtros.setText("OTROS");
			lblOtros.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblTHR = new JLabel();
			lblTHR.setBounds(new Rectangle(25, 205, 39, 22));
			lblTHR.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblTHR.setText("THR");
			lblACO = new JLabel();
			lblACO.setBounds(new Rectangle(25, 178, 39, 22));
			lblACO.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblACO.setText("ACO");
			panelFondo = new PanelConImagen("./src/imagenes/fondoHormonal.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(lblACO, null);
			panelFondo.add(lblTHR, null);
			panelFondo.add(getRdoMed_4(), null);
			panelFondo.add(getRdoMed_5(), null);
			panelFondo.add(getRdoMed_6(), null);
			panelFondo.add(getRdoMed_7(), null);
			panelFondo.add(getTxtOtra(), null);
			panelFondo.add(getRdoMed_1(), null);
			panelFondo.add(getRdoMed_2(), null);
			panelFondo.add(getRdoMed_3(), null);
			panelFondo.add(lblOtros, null);
			panelFondo.add(getTxtOtros(), null);
			panelFondo.add(getTxtTHR(), null);
			panelFondo.add(getTxtACO(), null);
			panelFondo.add(getChk_Med(), null);
			panelFondo.add(getChk_Horm(), null);
			panelFondo.add(lblReg, null);
			panelFondo.add(lblAdm, null);
			panelFondo.add(getTxtACO_Reg(), null);
			panelFondo.add(getTxtTHR_Reg(), null);
			panelFondo.add(getTxtOtros_Reg(), null);
			panelFondo.add(lblUso_Horm, null);
			panelFondo.add(lblmeses_horm, null);
			panelFondo.add(lblCese_1, null);
			panelFondo.add(lblCese_1_2, null);
			panelFondo.add(getTxtACO_Uso(), null);
			panelFondo.add(getTxtACO_Cese(), null);
			panelFondo.add(getTxtTHR_Uso(), null);
			panelFondo.add(getTxtTHR_Cese(), null);
			panelFondo.add(getTxtOtros_Uso(), null);
			panelFondo.add(getTxtOtros_Cese(), null);
			panelFondo.add(lblUso_Med, null);
			panelFondo.add(lblmeses_Med, null);
			panelFondo.add(getTxtDig(), null);
			panelFondo.add(getTxtCort(), null);
			panelFondo.add(getTxtPsic(), null);
			panelFondo.add(getTxtAcid(), null);
			panelFondo.add(getTxtCoag(), null);
			panelFondo.add(getTxtAAS(), null);
			panelFondo.add(getbtGuardar(), null);
			grpMedicacion.add(rdoMed_1);
			grpMedicacion.add(rdoMed_2);
			grpMedicacion.add(rdoMed_3);
			grpMedicacion.add(rdoMed_4);
			grpMedicacion.add(rdoMed_5);
			grpMedicacion.add(rdoMed_6);
			grpMedicacion.add(rdoMed_7);
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

	private JRadioButton getRdoMed_4() {
		if (rdoMed_4 == null) {
			rdoMed_4 = new JRadioButton();
			rdoMed_4.setBounds(new Rectangle(24, 427, 198, 22));
			rdoMed_4.setText("ANTIACIDOS ANTIHEMETICOS");
			rdoMed_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMed_4.setBackground(new java.awt.Color(204,204,204));
			rdoMed_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtDig.setEnabled(false);
					txtCort.setEnabled(false);
					txtPsic.setEnabled(false);
					txtAcid.setEnabled(true);
					txtCoag.setEnabled(false);
					txtAAS.setEnabled(false);
					txtOtra.setEnabled(false);
					txtDig.setText("");
					txtCort.setText("");
					txtPsic.setText("");
					txtAcid.setText("");
					txtCoag.setText("");
					txtAAS.setText("");
					txtOtra.setText("");
				}
			});
		}
		return rdoMed_4;
	}

	private JRadioButton getRdoMed_5() {
		if (rdoMed_5 == null) {
			rdoMed_5 = new JRadioButton();
			rdoMed_5.setBounds(new Rectangle(24, 450, 147, 22));
			rdoMed_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMed_5.setText("ANTICOAGULANTES");
			rdoMed_5.setBackground(new Color(204, 204, 204));
			rdoMed_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtDig.setEnabled(false);
					txtCort.setEnabled(false);
					txtPsic.setEnabled(false);
					txtAcid.setEnabled(false);
					txtCoag.setEnabled(true);
					txtAAS.setEnabled(false);
					txtOtra.setEnabled(false);
					txtDig.setText("");
					txtCort.setText("");
					txtPsic.setText("");
					txtAcid.setText("");
					txtCoag.setText("");
					txtAAS.setText("");
					txtOtra.setText("");
				}
			});
		}
		return rdoMed_5;
	}

	private JRadioButton getRdoMed_6() {
		if (rdoMed_6 == null) {
			rdoMed_6 = new JRadioButton();
			rdoMed_6.setBounds(new Rectangle(24, 473, 70, 22));
			rdoMed_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMed_6.setText("A.A.S.");
			rdoMed_6.setBackground(new Color(204, 204, 204));
			rdoMed_6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtDig.setEnabled(false);
					txtCort.setEnabled(false);
					txtPsic.setEnabled(false);
					txtAcid.setEnabled(false);
					txtCoag.setEnabled(false);
					txtAAS.setEnabled(true);
					txtOtra.setEnabled(false);
					txtDig.setText("");
					txtCort.setText("");
					txtPsic.setText("");
					txtAcid.setText("");
					txtCoag.setText("");
					txtAAS.setText("");
					txtOtra.setText("");
				}
			});
		}
		return rdoMed_6;
	}

	private JRadioButton getRdoMed_7() {
		if (rdoMed_7 == null) {
			rdoMed_7 = new JRadioButton();
			rdoMed_7.setBounds(new Rectangle(24, 497, 68, 22));
			rdoMed_7.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMed_7.setText("OTROS");
			rdoMed_7.setBackground(new Color(204, 204, 204));
			rdoMed_7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtDig.setEnabled(false);
					txtCort.setEnabled(false);
					txtPsic.setEnabled(false);
					txtAcid.setEnabled(false);
					txtCoag.setEnabled(false);
					txtAAS.setEnabled(false);
					txtOtra.setEnabled(true);
					txtDig.setText("");
					txtCort.setText("");
					txtPsic.setText("");
					txtAcid.setText("");
					txtCoag.setText("");
					txtAAS.setText("");
					txtOtra.setText("");
				}
			});
		}
		return rdoMed_7;
	}

	private JTextField getTxtOtra() {
		if (txtOtra == null) {
			txtOtra = new JTextField();
			txtOtra.setBounds(new Rectangle(44, 521, 324, 22));
			txtOtra.setFont(new Font("Calibri", Font.PLAIN, 14));
			//txtOtra.setEditable(false);
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

	private JRadioButton getRdoMed_1() {
		if (rdoMed_1 == null) {
			rdoMed_1 = new JRadioButton();
			rdoMed_1.setBounds(new Rectangle(24, 357, 117, 22));
			rdoMed_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMed_1.setText("DIGITALICOS");
			rdoMed_1.setBackground(new Color(204, 204, 204));
			rdoMed_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtDig.setEnabled(true);
					txtCort.setEnabled(false);
					txtPsic.setEnabled(false);
					txtAcid.setEnabled(false);
					txtCoag.setEnabled(false);
					txtAAS.setEnabled(false);
					txtOtra.setEnabled(false);
					txtDig.setText("");
					txtCort.setText("");
					txtPsic.setText("");
					txtAcid.setText("");
					txtCoag.setText("");
					txtAAS.setText("");
					txtOtra.setText("");
				}
			});
		}
		return rdoMed_1;
	}

	private JRadioButton getRdoMed_2() {
		if (rdoMed_2 == null) {
			rdoMed_2 = new JRadioButton();
			rdoMed_2.setBounds(new Rectangle(24, 380, 122, 22));
			rdoMed_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMed_2.setText("CORTICOIDES");
			rdoMed_2.setBackground(new Color(204, 204, 204));
			rdoMed_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtDig.setEnabled(false);
					txtCort.setEnabled(true);
					txtPsic.setEnabled(false);
					txtAcid.setEnabled(false);
					txtCoag.setEnabled(false);
					txtAAS.setEnabled(false);
					txtOtra.setEnabled(false);
					txtDig.setText("");
					txtCort.setText("");
					txtPsic.setText("");
					txtAcid.setText("");
					txtCoag.setText("");
					txtAAS.setText("");
					txtOtra.setText("");
				}
			});
		}
		return rdoMed_2;
	}

	private JRadioButton getRdoMed_3() {
		if (rdoMed_3 == null) {
			rdoMed_3 = new JRadioButton();
			rdoMed_3.setBounds(new Rectangle(24, 403, 129, 22));
			rdoMed_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMed_3.setText("PSICOFARMACOS");
			rdoMed_3.setBackground(new Color(204, 204, 204));
			rdoMed_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtDig.setEnabled(false);
					txtCort.setEnabled(false);
					txtPsic.setEnabled(true);
					txtAcid.setEnabled(false);
					txtCoag.setEnabled(false);
					txtAAS.setEnabled(false);
					txtOtra.setEnabled(false);
					txtDig.setText("");
					txtCort.setText("");
					txtPsic.setText("");
					txtAcid.setText("");
					txtCoag.setText("");
					txtAAS.setText("");
					txtOtra.setText("");
				}
			});
		}
		return rdoMed_3;
	}

	/**
	 * This method initializes txtOtros	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtros() {
		if (txtOtros == null) {
			txtOtros = new JTextField();
			txtOtros.setBounds(new Rectangle(67, 233, 140, 22));
			txtOtros.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtros.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtros;
	}

	/**
	 * This method initializes txtTHR	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTHR() {
		if (txtTHR == null) {
			txtTHR = new JTextField();
			txtTHR.setBounds(new Rectangle(67, 205, 140, 22));
			txtTHR.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtTHR.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtTHR;
	}

	/**
	 * This method initializes txtACO	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtACO() {
		if (txtACO == null) {
			txtACO = new JTextField();
			txtACO.setBounds(new Rectangle(67, 178, 140, 22));
			txtACO.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtACO.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtACO;
	}

	/**
	 * This method initializes chk_Med	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChk_Med() {
		if (chk_Med == null) {
			chk_Med = new JCheckBox();
			chk_Med.setBounds(new Rectangle(24, 330, 52, 22));
			chk_Med.setText("NO");
			chk_Med.setBackground(new Color(204, 204, 204));
			chk_Med.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chk_Med.isSelected()){
						rdoMed_1.setEnabled(true);
						rdoMed_2.setEnabled(true);
						rdoMed_3.setEnabled(true);
						rdoMed_4.setEnabled(true);
						rdoMed_5.setEnabled(true);
						rdoMed_6.setEnabled(true);
						rdoMed_7.setEnabled(true);
						txtDig.setEnabled(false);
						txtCort.setEnabled(false);
						txtPsic.setEnabled(false);
						txtAcid.setEnabled(false);
						txtCoag.setEnabled(false);
						txtAAS.setEnabled(false);
						txtOtra.setEnabled(false);
					}else{
						rdoMed_1.setEnabled(false);
						rdoMed_2.setEnabled(false);
						rdoMed_3.setEnabled(false);
						rdoMed_4.setEnabled(false);
						rdoMed_5.setEnabled(false);
						rdoMed_6.setEnabled(false);
						rdoMed_7.setEnabled(false);
						txtDig.setEnabled(false);
						txtCort.setEnabled(false);
						txtPsic.setEnabled(false);
						txtAcid.setEnabled(false);
						txtCoag.setEnabled(false);
						txtAAS.setEnabled(false);
						txtOtra.setEnabled(false);
						txtDig.setText("");
						txtCort.setText("");
						txtPsic.setText("");
						txtAcid.setText("");
						txtCoag.setText("");
						txtAAS.setText("");
						txtOtra.setText("");
					}
				}
			});
		}
		return chk_Med;
	}

	/**
	 * This method initializes chk_Horm	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChk_Horm() {
		if (chk_Horm == null) {
			chk_Horm = new JCheckBox();
			chk_Horm.setBounds(new Rectangle(22, 150, 51, 21));
			chk_Horm.setText("NO");
			chk_Horm.setBackground(new Color(204, 204, 204));
			chk_Horm.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chk_Horm.isSelected()){
						txtACO.setEditable(true);
						txtTHR.setEditable(true);
						txtOtros.setEditable(true);
						txtACO_Reg.setEditable(true);
						txtTHR_Reg.setEditable(true);
						txtOtros_Reg.setEditable(true);
						txtACO_Uso.setEditable(true);
						txtTHR_Uso.setEditable(true);
						txtOtros_Uso.setEditable(true);
						txtACO_Cese.setEditable(true);
						txtTHR_Cese.setEditable(true);
						txtOtros_Cese.setEditable(true);
					}else{
						txtACO.setEditable(false);
						txtTHR.setEditable(false);
						txtOtros.setEditable(false);
						txtACO_Reg.setEditable(false);
						txtTHR_Reg.setEditable(false);
						txtOtros_Reg.setEditable(false);
						txtACO_Uso.setEditable(false);
						txtTHR_Uso.setEditable(false);
						txtOtros_Uso.setEditable(false);
						txtACO_Cese.setEditable(false);
						txtTHR_Cese.setEditable(false);
						txtOtros_Cese.setEditable(false);
						txtACO.setText("");
						txtTHR.setText("");
						txtOtros.setText("");
						txtACO_Reg.setText("");
						txtTHR_Reg.setText("");
						txtOtros_Reg.setText("");
						txtACO_Uso.setText("");
						txtTHR_Uso.setText("");
						txtOtros_Uso.setText("");
						txtACO_Cese.setText("");
						txtTHR_Cese.setText("");
						txtOtros_Cese.setText("");
					}
				}
			});
		}
		return chk_Horm;
	}

	/**
	 * This method initializes txtACO_Reg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtACO_Reg() {
		if (txtACO_Reg == null) {
			txtACO_Reg = new JTextField();
			txtACO_Reg.setBounds(new Rectangle(235, 178, 20, 22));
			txtACO_Reg.addKeyListener(new KeyAdapter()
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
					  String s = txtACO_Reg.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtACO_Reg;
	}

	/**
	 * This method initializes txtTHR_Reg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTHR_Reg() {
		if (txtTHR_Reg == null) {
			txtTHR_Reg = new JTextField();
			txtTHR_Reg.setBounds(new Rectangle(235, 205, 20, 22));
			txtTHR_Reg.addKeyListener(new KeyAdapter()
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
					  String s = txtTHR_Reg.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtTHR_Reg;
	}

	/**
	 * This method initializes txtOtros_Reg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtros_Reg() {
		if (txtOtros_Reg == null) {
			txtOtros_Reg = new JTextField();
			txtOtros_Reg.setBounds(new Rectangle(235, 233, 20, 22));
			txtOtros_Reg.addKeyListener(new KeyAdapter()
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
					  String s = txtOtros_Reg.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtOtros_Reg;
	}

	/**
	 * This method initializes txtACO_Uso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtACO_Uso() {
		if (txtACO_Uso == null) {
			txtACO_Uso = new JTextField();
			txtACO_Uso.setBounds(new Rectangle(281, 178, 32, 22));
			txtACO_Uso.addKeyListener(new KeyAdapter()
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
					  String s = txtACO_Uso.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtACO_Uso;
	}

	/**
	 * This method initializes txtACO_Cese	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtACO_Cese() {
		if (txtACO_Cese == null) {
			txtACO_Cese = new JTextField();
			txtACO_Cese.setBounds(new Rectangle(332, 178, 32, 22));
			txtACO_Cese.addKeyListener(new KeyAdapter()
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
					  String s = txtACO_Cese.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtACO_Cese;
	}

	/**
	 * This method initializes txtTHR_Uso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTHR_Uso() {
		if (txtTHR_Uso == null) {
			txtTHR_Uso = new JTextField();
			txtTHR_Uso.setBounds(new Rectangle(281, 205, 32, 22));
			txtTHR_Uso.addKeyListener(new KeyAdapter()
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
					  String s = txtTHR_Uso.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtTHR_Uso;
	}

	/**
	 * This method initializes txtTHR_Cese	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTHR_Cese() {
		if (txtTHR_Cese == null) {
			txtTHR_Cese = new JTextField();
			txtTHR_Cese.setBounds(new Rectangle(332, 205, 32, 22));
			txtTHR_Cese.addKeyListener(new KeyAdapter()
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
					  String s = txtTHR_Cese.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtTHR_Cese;
	}

	/**
	 * This method initializes txtOtros_Uso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtros_Uso() {
		if (txtOtros_Uso == null) {
			txtOtros_Uso = new JTextField();
			txtOtros_Uso.setBounds(new Rectangle(281, 233, 32, 22));
			txtOtros_Uso.addKeyListener(new KeyAdapter()
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
					  String s = txtOtros_Uso.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtOtros_Uso;
	}

	/**
	 * This method initializes txtOtros_Cese	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtros_Cese() {
		if (txtOtros_Cese == null) {
			txtOtros_Cese = new JTextField();
			txtOtros_Cese.setBounds(new Rectangle(332, 233, 32, 22));
			txtOtros_Cese.addKeyListener(new KeyAdapter()
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
					  String s = txtOtros_Cese.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtOtros_Cese;
	}

	/**
	 * This method initializes txtDig	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDig() {
		if (txtDig == null) {
			txtDig = new JTextField();
			txtDig.setBounds(new Rectangle(334, 357, 36, 22));
			//txtDig.setEditable(false);
			txtDig.addKeyListener(new KeyAdapter()
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
					  String s = txtDig.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtDig;
	}

	/**
	 * This method initializes txtCort	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCort() {
		if (txtCort == null) {
			txtCort = new JTextField();
			txtCort.setBounds(new Rectangle(334, 380, 36, 22));
			//txtCort.setEditable(false);
			txtCort.addKeyListener(new KeyAdapter()
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
					  String s = txtCort.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtCort;
	}

	/**
	 * This method initializes txtPsic	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPsic() {
		if (txtPsic == null) {
			txtPsic = new JTextField();
			txtPsic.setBounds(new Rectangle(334, 403, 36, 22));
			//txtPsic.setEditable(false);
			txtPsic.addKeyListener(new KeyAdapter()
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
					  String s = txtPsic.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtPsic;
	}

	/**
	 * This method initializes txtAcid	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtAcid() {
		if (txtAcid == null) {
			txtAcid = new JTextField();
			txtAcid.setBounds(new Rectangle(334, 427, 36, 22));
			//txtAcid.setEditable(false);
			txtAcid.addKeyListener(new KeyAdapter()
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
					  String s = txtAcid.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtAcid;
	}

	/**
	 * This method initializes txtCoag	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCoag() {
		if (txtCoag == null) {
			txtCoag = new JTextField();
			txtCoag.setBounds(new Rectangle(334, 450, 36, 22));
			//txtCoag.setEditable(false);
			txtCoag.addKeyListener(new KeyAdapter()
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
					  String s = txtCoag.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtCoag;
	}

	/**
	 * This method initializes txtAAS	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtAAS() {
		if (txtAAS == null) {
			txtAAS = new JTextField();
			txtAAS.setBounds(new Rectangle(334, 473, 36, 22));
			//txtAAS.setEditable(false);
			txtAAS.addKeyListener(new KeyAdapter()
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
					  String s = txtAAS.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtAAS;
	}
}