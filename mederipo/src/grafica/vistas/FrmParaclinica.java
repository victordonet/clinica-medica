package grafica.vistas;

import grafica.controladores.CdorParaclinica;
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

public class FrmParaclinica extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorParaclinica cdor;
	private JRadioButton rdoLinea_1 = null;
	private JRadioButton rdoLinea_2 = null;
	private JRadioButton rdoLinea_3 = null;
	private JTextField txtLinea = null;
	private JRadioButton rdoEco_1 = null;
	private JRadioButton rdoEco_2 = null;
	private JRadioButton rdoEco_3 = null;
	private ButtonGroup grpEcografia = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpLiena = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpImagen = new ButtonGroup();  //  @jve:decl-index=0:
	private JRadioButton rdoEco_4 = null;
	private JRadioButton rdoImg_1 = null;
	private JRadioButton rdoImg_2 = null;
	private JTextField txtOtras = null;
	private JLabel lblPre = null;
	private JLabel lblPost = null;
	private JLabel lblCm = null;
	private JLabel lblLinea = null;
	private JLabel lblImagen = null;
	private JLabel lblOtras = null;
	private JCheckBox chkHSG_RX_1 = null;
	private JCheckBox chkHSG_RX_2 = null;
	private JCheckBox chkHSG_RX_3 = null;
	private JCheckBox chkHSG_RX_4 = null;
	private JCheckBox chkHSG_RX_5 = null;
	private JCheckBox chkHSG_RX_6 = null;
	private JCheckBox chkHSG_ECO_1 = null;
	private JCheckBox chkHSG_ECO_2 = null;
	private JCheckBox chkHSG_ECO_3 = null;
	private JCheckBox chkHSG_ECO_4 = null;
	private JCheckBox chkHSG_ECO_5 = null;
	private JCheckBox chkHSG_ECO_6 = null;
	public FrmParaclinica(CdorParaclinica cdor) {
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
			lblOtras = new JLabel();
			lblOtras.setBounds(new Rectangle(78, 438, 41, 20));
			lblOtras.setText("OTRAS");
			lblOtras.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblImagen = new JLabel();
			lblImagen.setBounds(new Rectangle(481, 135, 139, 22));
			lblImagen.setText("IMAGEN ECOGRAFICA");
			lblImagen.setFont(new Font("Calibri", Font.BOLD, 14));
			lblLinea = new JLabel();
			lblLinea.setBounds(new Rectangle(263, 135, 143, 22));
			lblLinea.setText("LINEA ENDOMETRIAL");
			lblLinea.setFont(new Font("Calibri", Font.BOLD, 14));
			lblCm = new JLabel();
			lblCm.setBounds(new Rectangle(388, 195, 27, 21));
			lblCm.setText("mm");
			lblCm.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblPost = new JLabel();
			lblPost.setBounds(new Rectangle(62, 300, 27, 17));
			lblPost.setText("ECO");
			lblPost.setFont(new Font("Calibri", Font.PLAIN, 11));
			lblPre = new JLabel();
			lblPre.setBounds(new Rectangle(33, 300, 22, 17));
			lblPre.setText("RX");
			lblPre.setFont(new Font("Calibri", Font.PLAIN, 11));
			panelFondo = new PanelConImagen("./src/imagenes/fondoParaclinica.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(getRdoLinea_1(), null);
			panelFondo.add(getRdoLinea_2(), null);
			panelFondo.add(getRdoLinea_3(), null);
			panelFondo.add(getTxtLinea(), null);
			panelFondo.add(getRdoEco_1(), null);
			panelFondo.add(getRdoEco_2(), null);
			panelFondo.add(getRdoEco_3(), null);
			panelFondo.add(getRdoEco_4(), null);
			panelFondo.add(getRdoImg_1(), null);
			panelFondo.add(getRdoImg_2(), null);
			panelFondo.add(getTxtOtras(), null);
			panelFondo.add(lblPre, null);
			panelFondo.add(lblPost, null);
			panelFondo.add(lblCm, null);
			panelFondo.add(lblLinea, null);
			panelFondo.add(lblImagen, null);
			panelFondo.add(lblOtras, null);
			panelFondo.add(getChkHSG_RX_1(), null);
			panelFondo.add(getChkHSG_RX_2(), null);
			panelFondo.add(getChkHSG_RX_3(), null);
			panelFondo.add(getChkHSG_RX_4(), null);
			panelFondo.add(getChkHSG_RX_5(), null);
			panelFondo.add(getChkHSG_RX_6(), null);
			panelFondo.add(getChkHSG_ECO_1(), null);
			panelFondo.add(getChkHSG_ECO_2(), null);
			panelFondo.add(getChkHSG_ECO_3(), null);
			panelFondo.add(getChkHSG_ECO_4(), null);
			panelFondo.add(getChkHSG_ECO_5(), null);
			panelFondo.add(getChkHSG_ECO_6(), null);
			panelFondo.add(getbtGuardar(), null);
			grpLiena.add(rdoLinea_1);
			grpLiena.add(rdoLinea_2);
			grpLiena.add(rdoLinea_3);
			grpEcografia.add(rdoEco_1);
			grpEcografia.add(rdoEco_2);
			grpEcografia.add(rdoEco_3);
			grpEcografia.add(rdoEco_4);
			grpImagen.add(rdoImg_1);
			grpImagen.add(rdoImg_2);
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

	private JRadioButton getRdoLinea_1() {
		if (rdoLinea_1 == null) {
			rdoLinea_1 = new JRadioButton();
			rdoLinea_1.setBounds(new Rectangle(261, 160, 100, 22));
			rdoLinea_1.setText("SIN DATO");
			rdoLinea_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoLinea_1.setBackground(new java.awt.Color(204,204,204));
			rdoLinea_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtLinea.setEditable(false);
					txtLinea.setText("");
				}
			});
		}
		return rdoLinea_1;
	}

	private JRadioButton getRdoLinea_2() {
		if (rdoLinea_2 == null) {
			rdoLinea_2 = new JRadioButton();
			rdoLinea_2.setBounds(new Rectangle(261, 185, 76, 22));
			rdoLinea_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoLinea_2.setText("FINA");
			rdoLinea_2.setBackground(new Color(204, 204, 204));
			rdoLinea_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtLinea.setEditable(true);
					txtLinea.setText("");
				}
			});
		}
		return rdoLinea_2;
	}

	private JRadioButton getRdoLinea_3() {
		if (rdoLinea_3 == null) {
			rdoLinea_3 = new JRadioButton();
			rdoLinea_3.setBounds(new Rectangle(261, 210, 86, 22));
			rdoLinea_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoLinea_3.setText("GRUESA");
			rdoLinea_3.setBackground(new Color(204, 204, 204));
			rdoLinea_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtLinea.setEditable(true);
					txtLinea.setText("");
				}
			});
		}
		return rdoLinea_3;
	}

	private JTextField getTxtLinea() {
		if (txtLinea == null) {
			txtLinea = new JTextField();
			txtLinea.setBounds(new Rectangle(348, 194, 38, 22));
			txtLinea.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtLinea.setEditable(false);
			txtLinea.addKeyListener(new KeyAdapter()
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
					  String s = txtLinea.getText();
					  int n=s.length();
					  if(n >= 3){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txtLinea;
	}

	private JRadioButton getRdoEco_1() {
		if (rdoEco_1 == null) {
			rdoEco_1 = new JRadioButton();
			rdoEco_1.setBounds(new Rectangle(30, 135, 50, 22));
			rdoEco_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEco_1.setText("NO");
			rdoEco_1.setBackground(new Color(204, 204, 204));
		}
		return rdoEco_1;
	}

	private JRadioButton getRdoEco_2() {
		if (rdoEco_2 == null) {
			rdoEco_2 = new JRadioButton();
			rdoEco_2.setBounds(new Rectangle(30, 160, 110, 22));
			rdoEco_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEco_2.setText("ABDOMINAL");
			rdoEco_2.setBackground(new Color(204, 204, 204));
		}
		return rdoEco_2;
	}

	private JRadioButton getRdoEco_3() {
		if (rdoEco_3 == null) {
			rdoEco_3 = new JRadioButton();
			rdoEco_3.setBounds(new Rectangle(30, 185, 122, 22));
			rdoEco_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEco_3.setText("TRANSVAGINAL");
			rdoEco_3.setBackground(new Color(204, 204, 204));
		}
		return rdoEco_3;
	}

	/**
	 * This method initializes rdoEco_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEco_4() {
		if (rdoEco_4 == null) {
			rdoEco_4 = new JRadioButton();
			rdoEco_4.setBounds(new Rectangle(30, 210, 157, 22));
			rdoEco_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEco_4.setText("HISTEROSONOGRAFIA");
			rdoEco_4.setBackground(new Color(204, 204, 204));
		}
		return rdoEco_4;
	}

	/**
	 * This method initializes rdoImg_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoImg_1() {
		if (rdoImg_1 == null) {
			rdoImg_1 = new JRadioButton();
			rdoImg_1.setBounds(new Rectangle(482, 160, 130, 22));
			rdoImg_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoImg_1.setText("SI");
			rdoImg_1.setBackground(new Color(204, 204, 204));
		}
		return rdoImg_1;
	}

	/**
	 * This method initializes rdoImg_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoImg_2() {
		if (rdoImg_2 == null) {
			rdoImg_2 = new JRadioButton();
			rdoImg_2.setBounds(new Rectangle(482, 185, 130, 22));
			rdoImg_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoImg_2.setText("NO");
			rdoImg_2.setBackground(new Color(204, 204, 204));
		}
		return rdoImg_2;
	}

	/**
	 * This method initializes txtOtras	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtras() {
		if (txtOtras == null) {
			txtOtras = new JTextField();
			txtOtras.setBounds(new Rectangle(120, 438, 301, 22));
			txtOtras.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtras.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtras.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtras;
	}

	/**
	 * This method initializes chkHSG_RX_1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_RX_1() {
		if (chkHSG_RX_1 == null) {
			chkHSG_RX_1 = new JCheckBox();
			chkHSG_RX_1.setBounds(new Rectangle(30, 317, 22, 22));
			chkHSG_RX_1.setBackground(new Color(204, 204, 204));
			chkHSG_RX_1.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chkHSG_RX_1.isSelected()){
						chkHSG_RX_2.setEnabled(true);
						chkHSG_RX_3.setEnabled(true);
						chkHSG_RX_4.setEnabled(true);
						chkHSG_RX_5.setEnabled(true);
						chkHSG_RX_6.setEnabled(true);
					}else{
						chkHSG_RX_2.setEnabled(false);
						chkHSG_RX_3.setEnabled(false);
						chkHSG_RX_4.setEnabled(false);
						chkHSG_RX_5.setEnabled(false);
						chkHSG_RX_6.setEnabled(false);
						chkHSG_RX_2.setSelected(false);
						chkHSG_RX_3.setSelected(false);
						chkHSG_RX_4.setSelected(false);
						chkHSG_RX_5.setSelected(false);
						chkHSG_RX_6.setSelected(false);
					}
				}
			});
		}
		return chkHSG_RX_1;
	}

	/**
	 * This method initializes chkHSG_RX_2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_RX_2() {
		if (chkHSG_RX_2 == null) {
			chkHSG_RX_2 = new JCheckBox();
			chkHSG_RX_2.setBounds(new Rectangle(30, 337, 22, 22));
			chkHSG_RX_2.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_RX_2;
	}

	/**
	 * This method initializes chkHSG_RX_3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_RX_3() {
		if (chkHSG_RX_3 == null) {
			chkHSG_RX_3 = new JCheckBox();
			chkHSG_RX_3.setBounds(new Rectangle(30, 357, 22, 22));
			chkHSG_RX_3.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_RX_3;
	}

	/**
	 * This method initializes chkHSG_RX_4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_RX_4() {
		if (chkHSG_RX_4 == null) {
			chkHSG_RX_4 = new JCheckBox();
			chkHSG_RX_4.setBounds(new Rectangle(30, 377, 22, 22));
			chkHSG_RX_4.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_RX_4;
	}

	/**
	 * This method initializes chkHSG_RX_5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_RX_5() {
		if (chkHSG_RX_5 == null) {
			chkHSG_RX_5 = new JCheckBox();
			chkHSG_RX_5.setBounds(new Rectangle(30, 397, 22, 22));
			chkHSG_RX_5.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_RX_5;
	}

	/**
	 * This method initializes chkHSG_RX_6	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_RX_6() {
		if (chkHSG_RX_6 == null) {
			chkHSG_RX_6 = new JCheckBox();
			chkHSG_RX_6.setBounds(new Rectangle(30, 417, 22, 22));
			chkHSG_RX_6.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_RX_6;
	}

	/**
	 * This method initializes chkHSG_ECO_1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_ECO_1() {
		if (chkHSG_ECO_1 == null) {
			chkHSG_ECO_1 = new JCheckBox();
			chkHSG_ECO_1.setBounds(new Rectangle(58, 317, 53, 22));
			chkHSG_ECO_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			chkHSG_ECO_1.setText("NO");
			chkHSG_ECO_1.setBackground(new Color(204, 204, 204));
			chkHSG_ECO_1.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chkHSG_ECO_1.isSelected()){
						chkHSG_ECO_2.setEnabled(true);
						chkHSG_ECO_3.setEnabled(true);
						chkHSG_ECO_4.setEnabled(true);
						chkHSG_ECO_5.setEnabled(true);
						chkHSG_ECO_6.setEnabled(true);
					}else{
						chkHSG_ECO_2.setEnabled(false);
						chkHSG_ECO_3.setEnabled(false);
						chkHSG_ECO_4.setEnabled(false);
						chkHSG_ECO_5.setEnabled(false);
						chkHSG_ECO_6.setEnabled(false);
						chkHSG_ECO_2.setSelected(false);
						chkHSG_ECO_3.setSelected(false);
						chkHSG_ECO_4.setSelected(false);
						chkHSG_ECO_5.setSelected(false);
						chkHSG_ECO_6.setSelected(false);
					}
				}
			});
		}
		return chkHSG_ECO_1;
	}

	/**
	 * This method initializes chkHSG_ECO_2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_ECO_2() {
		if (chkHSG_ECO_2 == null) {
			chkHSG_ECO_2 = new JCheckBox();
			chkHSG_ECO_2.setBounds(new Rectangle(58, 337, 102, 22));
			chkHSG_ECO_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			chkHSG_ECO_2.setText("NORMAL");
			chkHSG_ECO_2.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_ECO_2;
	}

	/**
	 * This method initializes chkHSG_ECO_3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_ECO_3() {
		if (chkHSG_ECO_3 == null) {
			chkHSG_ECO_3 = new JCheckBox();
			chkHSG_ECO_3.setBounds(new Rectangle(58, 357, 142, 22));
			chkHSG_ECO_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			chkHSG_ECO_3.setText("MALFORMACIONES");
			chkHSG_ECO_3.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_ECO_3;
	}

	/**
	 * This method initializes chkHSG_ECO_4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_ECO_4() {
		if (chkHSG_ECO_4 == null) {
			chkHSG_ECO_4 = new JCheckBox();
			chkHSG_ECO_4.setBounds(new Rectangle(58, 377, 130, 22));
			chkHSG_ECO_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			chkHSG_ECO_4.setText("ENDOMETRIOSIS");
			chkHSG_ECO_4.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_ECO_4;
	}

	/**
	 * This method initializes chkHSG_ECO_5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_ECO_5() {
		if (chkHSG_ECO_5 == null) {
			chkHSG_ECO_5 = new JCheckBox();
			chkHSG_ECO_5.setBounds(new Rectangle(58, 397, 81, 22));
			chkHSG_ECO_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			chkHSG_ECO_5.setText("TUMOR");
			chkHSG_ECO_5.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_ECO_5;
	}

	/**
	 * This method initializes chkHSG_ECO_6	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkHSG_ECO_6() {
		if (chkHSG_ECO_6 == null) {
			chkHSG_ECO_6 = new JCheckBox();
			chkHSG_ECO_6.setBounds(new Rectangle(58, 417, 133, 22));
			chkHSG_ECO_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			chkHSG_ECO_6.setText("SINEQUIAS");
			chkHSG_ECO_6.setBackground(new Color(204, 204, 204));
		}
		return chkHSG_ECO_6;
	}
}