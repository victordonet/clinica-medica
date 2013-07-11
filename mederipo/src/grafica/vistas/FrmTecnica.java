package grafica.vistas;

import grafica.controladores.CdorTecnica;
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

public class FrmTecnica extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorTecnica cdor;
	private JRadioButton rdoDist_1 = null;
	private JRadioButton rdoDist_2 = null;
	private JRadioButton rdoDist_3 = null;
	private JRadioButton rdoDist_5 = null;
	private JTextField txtOtraDist = null;
	private JRadioButton rdoProc_1 = null;
	private JRadioButton rdoProc_2 = null;
	private JRadioButton rdoProc_3 = null;
	private ButtonGroup grpProcedimiento = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpDistencion = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpAnestecia = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMediPre = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMediPost = new ButtonGroup();  //  @jve:decl-index=0:
	private JRadioButton rdoProc_4 = null;
	private JRadioButton rdoProc_5 = null;
	private JRadioButton rdoDist_4 = null;
	private JRadioButton rdoAnes_1 = null;
	private JRadioButton rdoAnes_2 = null;
	private JRadioButton rdoAnes_3 = null;
	private JRadioButton rdoAnes_4 = null;
	private JRadioButton rdoAnes_5 = null;
	private JTextField txtOtraAnes = null;
	private JRadioButton rdoMediPre_1 = null;
	private JRadioButton rdoMediPre_2 = null;
	private JRadioButton rdoMediPre_3 = null;
	private JRadioButton rdoMediPre_4 = null;
	private JTextField txtOtraMedi = null;
	private JRadioButton rdoMediPost_1 = null;
	private JRadioButton rdoMediPost_2 = null;
	private JRadioButton rdoMediPost_3 = null;
	private JRadioButton rdoMediPost_4 = null;
	private JLabel lblPre = null;
	private JLabel lblPost = null;
	private JLabel lblOtros = null;
	
	public FrmTecnica(CdorTecnica cdor) {
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(1163,732));
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
			lblOtros = new JLabel();
			lblOtros.setBounds(new Rectangle(760, 242, 48, 22));
			lblOtros.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblOtros.setText("OTROS");
			lblPost = new JLabel();
			lblPost.setBounds(new Rectangle(779, 129, 31, 17));
			lblPost.setText("POST");
			lblPost.setFont(new Font("Calibri", Font.PLAIN, 11));
			lblPre = new JLabel();
			lblPre.setBounds(new Rectangle(754, 129, 22, 17));
			lblPre.setText("PRE");
			lblPre.setFont(new Font("Calibri", Font.PLAIN, 11));
			panelFondo = new PanelConImagen("./src/imagenes/fondoTecnica.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(getRdoDist_1(), null);
			panelFondo.add(getRdoDist_2(), null);
			panelFondo.add(getRdoDist_3(), null);
			panelFondo.add(getRdoDist_5(), null);
			panelFondo.add(getTxtOtraDist(), null);
			panelFondo.add(getRdoProc_1(), null);
			panelFondo.add(getRdoProc_2(), null);
			panelFondo.add(getRdoProc_3(), null);
			panelFondo.add(getRdoProc_4(), null);
			panelFondo.add(getRdoProc_5(), null);
			panelFondo.add(getRdoDist_4(), null);
			panelFondo.add(getRdoAnes_1(), null);
			panelFondo.add(getRdoAnes_2(), null);
			panelFondo.add(getRdoAnes_3(), null);
			panelFondo.add(getRdoAnes_4(), null);
			panelFondo.add(getRdoAnes_5(), null);
			panelFondo.add(getTxtOtraAnes(), null);
			panelFondo.add(getRdoMediPre_1(), null);
			panelFondo.add(getRdoMediPre_2(), null);
			panelFondo.add(getRdoMediPre_3(), null);
			panelFondo.add(getRdoMediPre_4(), null);
			panelFondo.add(getTxtOtraMedi(), null);
			panelFondo.add(getRdoMediPost_1(), null);
			panelFondo.add(getRdoMediPost_2(), null);
			panelFondo.add(getRdoMediPost_3(), null);
			panelFondo.add(getRdoMediPost_4(), null);
			panelFondo.add(lblPre, null);
			panelFondo.add(lblPost, null);
			panelFondo.add(lblOtros, null);
			panelFondo.add(getbtGuardar(), null);
			grpDistencion.add(rdoDist_1);
			grpDistencion.add(rdoDist_2);
			grpDistencion.add(rdoDist_3);
			grpDistencion.add(rdoDist_4);
			grpDistencion.add(rdoDist_5);
			grpProcedimiento.add(rdoProc_1);
			grpProcedimiento.add(rdoProc_2);
			grpProcedimiento.add(rdoProc_3);
			grpProcedimiento.add(rdoProc_4);
			grpProcedimiento.add(rdoProc_5);
			grpAnestecia.add(rdoAnes_1);
			grpAnestecia.add(rdoAnes_2);
			grpAnestecia.add(rdoAnes_3);
			grpAnestecia.add(rdoAnes_4);
			grpAnestecia.add(rdoAnes_5);
			grpMediPre.add(rdoMediPre_1);
			grpMediPre.add(rdoMediPre_2);
			grpMediPre.add(rdoMediPre_3);
			grpMediPre.add(rdoMediPre_4);
			//grpMediPre.add(rdoMediPre_5);
			grpMediPost.add(rdoMediPost_1);
			grpMediPost.add(rdoMediPost_2);
			grpMediPost.add(rdoMediPost_3);
			grpMediPost.add(rdoMediPost_4);
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

	private JRadioButton getRdoDist_1() {
		if (rdoDist_1 == null) {
			rdoDist_1 = new JRadioButton();
			rdoDist_1.setBounds(new Rectangle(264, 142, 100, 22));
			rdoDist_1.setText("CO2");
			rdoDist_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDist_1.setBackground(new java.awt.Color(204,204,204));
			rdoDist_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraDist.setEditable(false);
					txtOtraDist.setText("");
				}
			});
		}
		return rdoDist_1;
	}

	private JRadioButton getRdoDist_2() {
		if (rdoDist_2 == null) {
			rdoDist_2 = new JRadioButton();
			rdoDist_2.setBounds(new Rectangle(264, 167, 130, 22));
			rdoDist_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDist_2.setText("CRISTALOIDES");
			rdoDist_2.setBackground(new Color(204, 204, 204));
			rdoDist_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraDist.setEditable(false);
					txtOtraDist.setText("");
				}
			});
		}
		return rdoDist_2;
	}

	private JRadioButton getRdoDist_3() {
		if (rdoDist_3 == null) {
			rdoDist_3 = new JRadioButton();
			rdoDist_3.setBounds(new Rectangle(264, 192, 140, 22));
			rdoDist_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDist_3.setText("AGUA BIDESTILADA");
			rdoDist_3.setBackground(new Color(204, 204, 204));
			rdoDist_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraDist.setEditable(false);
					txtOtraDist.setText("");
				}
			});
		}
		return rdoDist_3;
	}

	private JRadioButton getRdoDist_5() {
		if (rdoDist_5 == null) {
			rdoDist_5 = new JRadioButton();
			rdoDist_5.setBounds(new Rectangle(264, 242, 100, 22));
			rdoDist_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDist_5.setText("OTROS");
			rdoDist_5.setBackground(new Color(204, 204, 204));
			rdoDist_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraDist.setEditable(true);
				}
			});
		}
		return rdoDist_5;
	}

	private JTextField getTxtOtraDist() {
		if (txtOtraDist == null) {
			txtOtraDist = new JTextField();
			txtOtraDist.setBounds(new Rectangle(264, 265, 208, 22));
			txtOtraDist.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraDist.setEditable(false);
			txtOtraDist.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraDist.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraDist;
	}

	private JRadioButton getRdoProc_1() {
		if (rdoProc_1 == null) {
			rdoProc_1 = new JRadioButton();
			rdoProc_1.setBounds(new Rectangle(13, 142, 130, 22));
			rdoProc_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoProc_1.setText("DIAGNOSTICA");
			rdoProc_1.setBackground(new Color(204, 204, 204));
		}
		return rdoProc_1;
	}

	private JRadioButton getRdoProc_2() {
		if (rdoProc_2 == null) {
			rdoProc_2 = new JRadioButton();
			rdoProc_2.setBounds(new Rectangle(13, 167, 130, 22));
			rdoProc_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoProc_2.setText("TERAPEUTICA");
			rdoProc_2.setBackground(new Color(204, 204, 204));
		}
		return rdoProc_2;
	}

	private JRadioButton getRdoProc_3() {
		if (rdoProc_3 == null) {
			rdoProc_3 = new JRadioButton();
			rdoProc_3.setBounds(new Rectangle(13, 192, 130, 22));
			rdoProc_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoProc_3.setText("QUIRURGICA");
			rdoProc_3.setBackground(new Color(204, 204, 204));
		}
		return rdoProc_3;
	}

	/**
	 * This method initializes rdoProc_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoProc_4() {
		if (rdoProc_4 == null) {
			rdoProc_4 = new JRadioButton();
			rdoProc_4.setBounds(new Rectangle(13, 217, 130, 22));
			rdoProc_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoProc_4.setText("VAGINOSCOPICA");
			rdoProc_4.setBackground(new Color(204, 204, 204));
		}
		return rdoProc_4;
	}

	/**
	 * This method initializes rdoProc_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoProc_5() {
		if (rdoProc_5 == null) {
			rdoProc_5 = new JRadioButton();
			rdoProc_5.setBounds(new Rectangle(13, 242, 140, 22));
			rdoProc_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoProc_5.setText("HISTERO. LAPARO.");
			rdoProc_5.setBackground(new Color(204, 204, 204));
		}
		return rdoProc_5;
	}

	/**
	 * This method initializes rdoDist_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoDist_4() {
		if (rdoDist_4 == null) {
			rdoDist_4 = new JRadioButton();
			rdoDist_4.setBounds(new Rectangle(264, 217, 102, 23));
			rdoDist_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDist_4.setText("GLICINA");
			rdoDist_4.setBackground(new Color(204, 204, 204));
			rdoDist_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraDist.setEditable(false);
					txtOtraDist.setText("");
				}
			});
		}
		return rdoDist_4;
	}

	/**
	 * This method initializes rdoAnes_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnes_1() {
		if (rdoAnes_1 == null) {
			rdoAnes_1 = new JRadioButton();
			rdoAnes_1.setBounds(new Rectangle(510, 142, 130, 22));
			rdoAnes_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnes_1.setText("NINGUNA");
			rdoAnes_1.setBackground(new Color(204, 204, 204));
			rdoAnes_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraAnes.setEditable(false);
					txtOtraAnes.setText("");
				}
			});
		}
		return rdoAnes_1;
	}

	/**
	 * This method initializes rdoAnes_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnes_2() {
		if (rdoAnes_2 == null) {
			rdoAnes_2 = new JRadioButton();
			rdoAnes_2.setBounds(new Rectangle(510, 167, 130, 22));
			rdoAnes_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnes_2.setText("PARACERVICAL");
			rdoAnes_2.setBackground(new Color(204, 204, 204));
			rdoAnes_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraAnes.setEditable(false);
					txtOtraAnes.setText("");
				}
			});
		}
		return rdoAnes_2;
	}

	/**
	 * This method initializes rdoAnes_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnes_3() {
		if (rdoAnes_3 == null) {
			rdoAnes_3 = new JRadioButton();
			rdoAnes_3.setBounds(new Rectangle(510, 192, 130, 22));
			rdoAnes_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnes_3.setText("CERVICAL");
			rdoAnes_3.setBackground(new Color(204, 204, 204));
			rdoAnes_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraAnes.setEditable(false);
					txtOtraAnes.setText("");
				}
			});
		}
		return rdoAnes_3;
	}

	/**
	 * This method initializes rdoAnes_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnes_4() {
		if (rdoAnes_4 == null) {
			rdoAnes_4 = new JRadioButton();
			rdoAnes_4.setBounds(new Rectangle(510, 217, 130, 22));
			rdoAnes_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnes_4.setText("GENERAL");
			rdoAnes_4.setBackground(new Color(204, 204, 204));
			rdoAnes_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraAnes.setEditable(false);
					txtOtraAnes.setText("");
				}
			});
		}
		return rdoAnes_4;
	}

	/**
	 * This method initializes rdoAnes_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnes_5() {
		if (rdoAnes_5 == null) {
			rdoAnes_5 = new JRadioButton();
			rdoAnes_5.setBounds(new Rectangle(510, 242, 130, 22));
			rdoAnes_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnes_5.setText("OTRA");
			rdoAnes_5.setBackground(new Color(204, 204, 204));
			rdoAnes_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraAnes.setEditable(true);
				}
			});
		}
		return rdoAnes_5;
	}

	/**
	 * This method initializes txtOtraAnes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraAnes() {
		if (txtOtraAnes == null) {
			txtOtraAnes = new JTextField();
			txtOtraAnes.setBounds(new Rectangle(510, 265, 211, 22));
			txtOtraAnes.setEditable(false);
			txtOtraAnes.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraAnes.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraAnes.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraAnes;
	}

	/**
	 * This method initializes rdoMediPre_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPre_1() {
		if (rdoMediPre_1 == null) {
			rdoMediPre_1 = new JRadioButton();
			rdoMediPre_1.setBounds(new Rectangle(757, 142, 20, 22));
			rdoMediPre_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPre_1.setText("");
			rdoMediPre_1.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPre_1;
	}

	/**
	 * This method initializes rdoMediPre_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPre_2() {
		if (rdoMediPre_2 == null) {
			rdoMediPre_2 = new JRadioButton();
			rdoMediPre_2.setBounds(new Rectangle(757, 167, 22, 22));
			rdoMediPre_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPre_2.setText("");
			rdoMediPre_2.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPre_2;
	}

	/**
	 * This method initializes rdoMediPre_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPre_3() {
		if (rdoMediPre_3 == null) {
			rdoMediPre_3 = new JRadioButton();
			rdoMediPre_3.setBounds(new Rectangle(757, 192, 22, 22));
			rdoMediPre_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPre_3.setText("");
			rdoMediPre_3.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPre_3;
	}

	/**
	 * This method initializes rdoMediPre_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPre_4() {
		if (rdoMediPre_4 == null) {
			rdoMediPre_4 = new JRadioButton();
			rdoMediPre_4.setBounds(new Rectangle(757, 217, 22, 22));
			rdoMediPre_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPre_4.setText("");
			rdoMediPre_4.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPre_4;
	}

	/**
	 * This method initializes txtOtraMedi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraMedi() {
		if (txtOtraMedi == null) {
			txtOtraMedi = new JTextField();
			txtOtraMedi.setBounds(new Rectangle(808, 242, 249, 22));
			txtOtraMedi.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraMedi.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraMedi.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraMedi;
	}

	/**
	 * This method initializes rdoMediPost_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPost_1() {
		if (rdoMediPost_1 == null) {
			rdoMediPost_1 = new JRadioButton();
			rdoMediPost_1.setBounds(new Rectangle(782, 142, 130, 22));
			rdoMediPost_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPost_1.setText("NINGUNA");
			rdoMediPost_1.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPost_1;
	}

	/**
	 * This method initializes rdoMediPost_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPost_2() {
		if (rdoMediPost_2 == null) {
			rdoMediPost_2 = new JRadioButton();
			rdoMediPost_2.setBounds(new Rectangle(782, 167, 130, 22));
			rdoMediPost_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPost_2.setText("SEDACION");
			rdoMediPost_2.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPost_2;
	}

	/**
	 * This method initializes rdoMediPost_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPost_3() {
		if (rdoMediPost_3 == null) {
			rdoMediPost_3 = new JRadioButton();
			rdoMediPost_3.setBounds(new Rectangle(782, 192, 130, 22));
			rdoMediPost_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPost_3.setText("ANALGESICOS");
			rdoMediPost_3.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPost_3;
	}

	/**
	 * This method initializes rdoMediPost_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMediPost_4() {
		if (rdoMediPost_4 == null) {
			rdoMediPost_4 = new JRadioButton();
			rdoMediPost_4.setBounds(new Rectangle(782, 217, 130, 22));
			rdoMediPost_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMediPost_4.setText("ANTIBIOTICOS");
			rdoMediPost_4.setBackground(new Color(204, 204, 204));
		}
		return rdoMediPost_4;
	}
}