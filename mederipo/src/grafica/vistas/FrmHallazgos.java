package grafica.vistas;

import grafica.controladores.CdorHallazgos;
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

public class FrmHallazgos extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorHallazgos cdor;
	private JRadioButton rdoComp_1 = null;
	private JRadioButton rdoComp_2 = null;
	private JRadioButton rdoComp_3 = null;
	private JRadioButton rdoComp_5 = null;
	private JTextField txtOtraComp = null;
	private JRadioButton rdoCav_1 = null;
	private JRadioButton rdoCav_2 = null;
	private JRadioButton rdoCav_3 = null;
	private ButtonGroup grpPatologias = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpTolerancia = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpDIU_1 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpDIU_2 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMiomas_1 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMiomas_2 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMiomas_3 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpEndometrio = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpCanal = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpCavidad_1 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpCavidad_2 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMalformaciones = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpOstiums = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpAdherencias_1 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpAdherencias_2 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpComplicaciones = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpQuirurgica = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpTerapeutica = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpBiopsia = new ButtonGroup();  //  @jve:decl-index=0:
	private JRadioButton rdoCav_4 = null;
	private JRadioButton rdoCav_5 = null;
	private JRadioButton rdoComp_4 = null;
	private JRadioButton rdoQuir_1 = null;
	private JRadioButton rdoQuir_2 = null;
	private JRadioButton rdoQuir_3 = null;
	private JRadioButton rdoQuir_4 = null;
	private JRadioButton rdoQuir_7 = null;
	private JTextField txtOtraQuir = null;
	private JRadioButton rdoTerap_1 = null;
	private JRadioButton rdoTerap_2 = null;
	private JRadioButton rdoTerap_3 = null;
	private JRadioButton rdoTerap_4 = null;
	private JRadioButton rdoTerap_6 = null;
	private JTextField txtOtraTerap = null;
	private JRadioButton rdoBiop_1 = null;
	private JRadioButton rdoBiop_2 = null;
	private JRadioButton rdoBiop_3 = null;
	private JRadioButton rdoBiop_4 = null;
	private JLabel lblCm = null;
	private JRadioButton rdoPat_1 = null;
	private JRadioButton rdoPat_2 = null;
	private JRadioButton rdoPat_3 = null;
	private JTextField txtHister = null;
	private JRadioButton rdoTol_1 = null;
	private JRadioButton rdoTol_2 = null;
	private JRadioButton rdoTol_3 = null;
	private JRadioButton rdoOst_1 = null;
	private JRadioButton rdoOst_2 = null;
	private JRadioButton rdoOst_3 = null;
	private JRadioButton rdoQuir_5 = null;
	private JRadioButton rdoQuir_6 = null;
	private JRadioButton rdoTerap_5 = null;
	private JRadioButton rdoBiop_5 = null;
	private JTextField txtOtraBiop = null;
	private JRadioButton rdoEndo_1 = null;
	private JRadioButton rdoEndo_2 = null;
	private JRadioButton rdoEndo_3 = null;
	private JRadioButton rdoEndo_4 = null;
	private JRadioButton rdoEndo_5 = null;
	private JRadioButton rdoEndo_6 = null;
	private JRadioButton rdoEndo_7 = null;
	private JRadioButton rdoEndo_8 = null;
	private JRadioButton rdoEndo_9 = null;
	private JRadioButton rdoEndo_10 = null;
	private JRadioButton rdoEndo_11 = null;
	private JRadioButton rdoEndo_12 = null;
	private JRadioButton rdoEndo_13 = null;
	private JRadioButton rdoEndo_14 = null;
	private JRadioButton rdoEndo_15 = null;
	private JRadioButton rdoEndo_16 = null;
	private JTextField txtOtraEndo = null;
	private JRadioButton rdoDiu_1 = null;
	private JRadioButton rdoDiu_2 = null;
	private JRadioButton rdoDiu_3 = null;
	private JRadioButton rdoDiu_4 = null;
	private JRadioButton rdoCanal_1 = null;
	private JRadioButton rdoCanal_2 = null;
	private JRadioButton rdoCanal_3 = null;
	private JRadioButton rdoCanal_4 = null;
	private JRadioButton rdoCanal_5 = null;
	private JRadioButton rdoCanal_6 = null;
	private JRadioButton rdoCanal_7 = null;
	private JRadioButton rdoCanal_8 = null;
	private JTextField txtOtroCanal = null;
	private JRadioButton rdoMiomas_1 = null;
	private JRadioButton rdoMiomas_2 = null;
	private JRadioButton rdoMiomas_3 = null;
	private JRadioButton rdoMiomas_4 = null;
	private JRadioButton rdoMiomas_5 = null;
	private JRadioButton rdoMiomas_6 = null;
	private JRadioButton rdoAdh_1 = null;
	private JRadioButton rdoAdh_2 = null;
	private JRadioButton rdoAdh_3 = null;
	private JRadioButton rdoAdh_4 = null;
	private JRadioButton rdoAdh_5 = null;
	private JRadioButton rdoAdh_6 = null;
	private JRadioButton rdoMal_1 = null;
	private JRadioButton rdoMal_2 = null;
	private JRadioButton rdoMal_3 = null;
	private JRadioButton rdoMal_4 = null;
	private JTextField txtOtraMal = null;
	private JLabel lblLinea = null;
	
	public FrmHallazgos(CdorHallazgos cdor) {
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(1026,642));
		this.setLocation(210,40);
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
			lblLinea = new JLabel();
			lblLinea.setBounds(new Rectangle(695, 277, 90, 22));
			lblLinea.setText("____________");
			lblLinea.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblCm = new JLabel();
			lblCm.setBounds(new Rectangle(247, 122, 22, 22));
			lblCm.setText("cm");
			lblCm.setFont(new Font("Calibri", Font.PLAIN, 14));
			panelFondo = new PanelConImagen("./src/imagenes/fondoHallazgos.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(getRdoComp_1(), null);
			panelFondo.add(getRdoComp_2(), null);
			panelFondo.add(getRdoComp_3(), null);
			panelFondo.add(getRdoComp_5(), null);
			panelFondo.add(getTxtOtraComp(), null);
			panelFondo.add(getRdoCav_1(), null);
			panelFondo.add(getRdoCav_2(), null);
			panelFondo.add(getRdoCav_3(), null);
			panelFondo.add(getRdoCav_4(), null);
			panelFondo.add(getRdoCav_5(), null);
			panelFondo.add(getRdoComp_4(), null);
			panelFondo.add(getRdoQuir_1(), null);
			panelFondo.add(getRdoQuir_2(), null);
			panelFondo.add(getRdoQuir_3(), null);
			panelFondo.add(getRdoQuir_4(), null);
			panelFondo.add(getRdoQuir_7(), null);
			panelFondo.add(getTxtOtraQuir(), null);
			panelFondo.add(getRdoTerap_1(), null);
			panelFondo.add(getRdoTerap_2(), null);
			panelFondo.add(getRdoTerap_3(), null);
			panelFondo.add(getRdoTerap_4(), null);
			panelFondo.add(getRdoTerap_6(), null);
			panelFondo.add(getTxtOtraTerap(), null);
			panelFondo.add(getRdoBiop_1(), null);
			panelFondo.add(getRdoBiop_2(), null);
			panelFondo.add(getRdoBiop_3(), null);
			panelFondo.add(getRdoBiop_4(), null);
			panelFondo.add(lblCm, null);
			panelFondo.add(getRdoPat_1(), null);
			panelFondo.add(getRdoPat_2(), null);
			panelFondo.add(getRdoPat_3(), null);
			panelFondo.add(getTxtHister(), null);
			panelFondo.add(getRdoTol_1(), null);
			panelFondo.add(getRdoTol_2(), null);
			panelFondo.add(getRdoTol_3(), null);
			panelFondo.add(getRdoOst_1(), null);
			panelFondo.add(getRdoOst_2(), null);
			panelFondo.add(getRdoOst_3(), null);
			panelFondo.add(getRdoQuir_5(), null);
			panelFondo.add(getRdoQuir_6(), null);
			panelFondo.add(getRdoTerap_5(), null);
			panelFondo.add(getRdoBiop_5(), null);
			panelFondo.add(getTxtOtraBiop(), null);
			panelFondo.add(getRdoEndo_1(), null);
			panelFondo.add(getRdoEndo_2(), null);
			panelFondo.add(getRdoEndo_3(), null);
			panelFondo.add(getRdoEndo_4(), null);
			panelFondo.add(getRdoEndo_5(), null);
			panelFondo.add(getRdoEndo_6(), null);
			panelFondo.add(getRdoEndo_7(), null);
			panelFondo.add(getRdoEndo_8(), null);
			panelFondo.add(getRdoEndo_9(), null);
			panelFondo.add(getRdoEndo_10(), null);
			panelFondo.add(getRdoEndo_11(), null);
			panelFondo.add(getRdoEndo_12(), null);
			panelFondo.add(getRdoEndo_13(), null);
			panelFondo.add(getRdoEndo_14(), null);
			panelFondo.add(getRdoEndo_15(), null);
			panelFondo.add(getRdoEndo_16(), null);
			panelFondo.add(getTxtOtraEndo(), null);
			panelFondo.add(getRdoDiu_1(), null);
			panelFondo.add(getRdoDiu_2(), null);
			panelFondo.add(getRdoDiu_3(), null);
			panelFondo.add(getRdoDiu_4(), null);
			panelFondo.add(getRdoCanal_1(), null);
			panelFondo.add(getRdoCanal_2(), null);
			panelFondo.add(getRdoCanal_3(), null);
			panelFondo.add(getRdoCanal_4(), null);
			panelFondo.add(getRdoCanal_5(), null);
			panelFondo.add(getRdoCanal_6(), null);
			panelFondo.add(getRdoCanal_7(), null);
			panelFondo.add(getRdoCanal_8(), null);
			panelFondo.add(getTxtOtroCanal(), null);
			panelFondo.add(getRdoMiomas_1(), null);
			panelFondo.add(getRdoMiomas_2(), null);
			panelFondo.add(getRdoMiomas_3(), null);
			panelFondo.add(getRdoMiomas_4(), null);
			panelFondo.add(getRdoMiomas_5(), null);
			panelFondo.add(getRdoMiomas_6(), null);
			panelFondo.add(getRdoAdh_1(), null);
			panelFondo.add(getRdoAdh_2(), null);
			panelFondo.add(getRdoAdh_3(), null);
			panelFondo.add(getRdoAdh_4(), null);
			panelFondo.add(getRdoAdh_5(), null);
			panelFondo.add(getRdoAdh_6(), null);
			panelFondo.add(getRdoMal_1(), null);
			panelFondo.add(getRdoMal_2(), null);
			panelFondo.add(getRdoMal_3(), null);
			panelFondo.add(getRdoMal_4(), null);
			panelFondo.add(getTxtOtraMal(), null);
			panelFondo.add(lblLinea, null);
			panelFondo.add(getbtGuardar(), null);
			grpPatologias.add(rdoPat_1);
			grpPatologias.add(rdoPat_2);
			grpPatologias.add(rdoPat_3);
			grpTolerancia.add(rdoTol_1);
			grpTolerancia.add(rdoTol_2);
			grpTolerancia.add(rdoTol_3);
			grpDIU_1.add(rdoDiu_1);
			grpDIU_1.add(rdoDiu_2);
			grpDIU_2.add(rdoDiu_3);
			grpDIU_2.add(rdoDiu_4);
			grpMiomas_1.add(rdoMiomas_1);
			grpMiomas_1.add(rdoMiomas_2);
			grpMiomas_2.add(rdoMiomas_3);
			grpMiomas_2.add(rdoMiomas_4);
			grpMiomas_3.add(rdoMiomas_5);
			grpMiomas_3.add(rdoMiomas_6);
			grpEndometrio.add(rdoEndo_1);
			grpEndometrio.add(rdoEndo_2);
			grpEndometrio.add(rdoEndo_3);
			grpEndometrio.add(rdoEndo_4);
			grpEndometrio.add(rdoEndo_5);
			grpEndometrio.add(rdoEndo_6);
			grpEndometrio.add(rdoEndo_7);
			grpEndometrio.add(rdoEndo_8);
			grpEndometrio.add(rdoEndo_9);
			grpEndometrio.add(rdoEndo_10);
			grpEndometrio.add(rdoEndo_11);
			grpEndometrio.add(rdoEndo_12);
			grpEndometrio.add(rdoEndo_13);
			grpEndometrio.add(rdoEndo_14);
			grpEndometrio.add(rdoEndo_15);
			grpEndometrio.add(rdoEndo_16);
			grpCanal.add(rdoCanal_1);
			grpCanal.add(rdoCanal_2);
			grpCanal.add(rdoCanal_3);
			grpCanal.add(rdoCanal_4);
			grpCanal.add(rdoCanal_5);
			grpCanal.add(rdoCanal_6);
			grpCanal.add(rdoCanal_7);
			grpCanal.add(rdoCanal_8);
			grpCavidad_1.add(rdoCav_1);
			grpCavidad_1.add(rdoCav_2);
			grpCavidad_1.add(rdoCav_3);
			grpCavidad_2.add(rdoCav_4);
			grpCavidad_2.add(rdoCav_5);
			grpMalformaciones.add(rdoMal_1);
			grpMalformaciones.add(rdoMal_2);
			grpMalformaciones.add(rdoMal_3);
			grpMalformaciones.add(rdoMal_4);
			grpOstiums.add(rdoOst_1);
			grpOstiums.add(rdoOst_2);
			grpOstiums.add(rdoOst_3);
			grpBiopsia.add(rdoBiop_1);
			grpBiopsia.add(rdoBiop_2);
			grpBiopsia.add(rdoBiop_3);
			grpBiopsia.add(rdoBiop_4);
			grpBiopsia.add(rdoBiop_5);
			grpTerapeutica.add(rdoTerap_1);
			grpTerapeutica.add(rdoTerap_2);
			grpTerapeutica.add(rdoTerap_3);
			grpTerapeutica.add(rdoTerap_4);
			grpTerapeutica.add(rdoTerap_5);
			grpTerapeutica.add(rdoTerap_6);
			grpQuirurgica.add(rdoQuir_1);
			grpQuirurgica.add(rdoQuir_2);
			grpQuirurgica.add(rdoQuir_3);
			grpQuirurgica.add(rdoQuir_4);
			grpQuirurgica.add(rdoQuir_5);
			grpQuirurgica.add(rdoQuir_6);
			grpQuirurgica.add(rdoQuir_7);
			grpComplicaciones.add(rdoComp_1);
			grpComplicaciones.add(rdoComp_2);
			grpComplicaciones.add(rdoComp_3);
			grpComplicaciones.add(rdoComp_4);
			grpComplicaciones.add(rdoComp_5);
			grpAdherencias_1.add(rdoAdh_1);
			grpAdherencias_1.add(rdoAdh_2);
			grpAdherencias_1.add(rdoAdh_3);
			grpAdherencias_2.add(rdoAdh_4);
			grpAdherencias_2.add(rdoAdh_5);
			grpAdherencias_2.add(rdoAdh_6);
		}
		return panelFondo;
	}

	private JButton getbtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setBounds(new Rectangle(966, 560, 40, 40));
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
			btCancelar.setBounds(new Rectangle(916, 560, 40, 40));
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

	private JRadioButton getRdoComp_1() {
		if (rdoComp_1 == null) {
			rdoComp_1 = new JRadioButton();
			rdoComp_1.setBounds(new Rectangle(795, 405, 50, 22));
			rdoComp_1.setText("NO");
			rdoComp_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoComp_1.setBackground(new java.awt.Color(204,204,204));
			rdoComp_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraComp.setEditable(false);
					txtOtraComp.setText("");
				}
			});
		}
		return rdoComp_1;
	}

	private JRadioButton getRdoComp_2() {
		if (rdoComp_2 == null) {
			rdoComp_2 = new JRadioButton();
			rdoComp_2.setBounds(new Rectangle(795, 425, 130, 22));
			rdoComp_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoComp_2.setText("SANGRADO");
			rdoComp_2.setBackground(new Color(204, 204, 204));
			rdoComp_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraComp.setEditable(false);
					txtOtraComp.setText("");
				}
			});
		}
		return rdoComp_2;
	}

	private JRadioButton getRdoComp_3() {
		if (rdoComp_3 == null) {
			rdoComp_3 = new JRadioButton();
			rdoComp_3.setBounds(new Rectangle(795, 445, 130, 22));
			rdoComp_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoComp_3.setText("PERFORACION");
			rdoComp_3.setBackground(new Color(204, 204, 204));
			rdoComp_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraComp.setEditable(false);
					txtOtraComp.setText("");
				}
			});
		}
		return rdoComp_3;
	}

	private JRadioButton getRdoComp_5() {
		if (rdoComp_5 == null) {
			rdoComp_5 = new JRadioButton();
			rdoComp_5.setBounds(new Rectangle(795, 485, 68, 22));
			rdoComp_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoComp_5.setText("OTRAS");
			rdoComp_5.setBackground(new Color(204, 204, 204));
			rdoComp_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraComp.setEditable(true);
				}
			});
		}
		return rdoComp_5;
	}

	private JTextField getTxtOtraComp() {
		if (txtOtraComp == null) {
			txtOtraComp = new JTextField();
			txtOtraComp.setBounds(new Rectangle(795, 507, 206, 22));
			txtOtraComp.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraComp.setEditable(false);
			txtOtraComp.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraComp.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraComp;
	}

	private JRadioButton getRdoCav_1() {
		if (rdoCav_1 == null) {
			rdoCav_1 = new JRadioButton();
			rdoCav_1.setBounds(new Rectangle(690, 225, 80, 22));
			rdoCav_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCav_1.setText("CHICA");
			rdoCav_1.setBackground(new Color(204, 204, 204));
		}
		return rdoCav_1;
	}

	private JRadioButton getRdoCav_2() {
		if (rdoCav_2 == null) {
			rdoCav_2 = new JRadioButton();
			rdoCav_2.setBounds(new Rectangle(690, 245, 85, 22));
			rdoCav_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCav_2.setText("MEDIANA");
			rdoCav_2.setBackground(new Color(204, 204, 204));
		}
		return rdoCav_2;
	}

	private JRadioButton getRdoCav_3() {
		if (rdoCav_3 == null) {
			rdoCav_3 = new JRadioButton();
			rdoCav_3.setBounds(new Rectangle(690, 265, 85, 22));
			rdoCav_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCav_3.setText("GRANDE");
			rdoCav_3.setBackground(new Color(204, 204, 204));
		}
		return rdoCav_3;
	}

	/**
	 * This method initializes rdoCav_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCav_4() {
		if (rdoCav_4 == null) {
			rdoCav_4 = new JRadioButton();
			rdoCav_4.setBounds(new Rectangle(690, 305, 95, 22));
			rdoCav_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCav_4.setText("REGULAR");
			rdoCav_4.setBackground(new Color(204, 204, 204));
		}
		return rdoCav_4;
	}

	/**
	 * This method initializes rdoCav_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCav_5() {
		if (rdoCav_5 == null) {
			rdoCav_5 = new JRadioButton();
			rdoCav_5.setBounds(new Rectangle(690, 325, 100, 22));
			rdoCav_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCav_5.setText("IRREGULAR");
			rdoCav_5.setBackground(new Color(204, 204, 204));
		}
		return rdoCav_5;
	}

	/**
	 * This method initializes rdoComp_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoComp_4() {
		if (rdoComp_4 == null) {
			rdoComp_4 = new JRadioButton();
			rdoComp_4.setBounds(new Rectangle(795, 465, 185, 22));
			rdoComp_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoComp_4.setText("CUELLO NO FRANQUEABLE");
			rdoComp_4.setBackground(new Color(204, 204, 204));
			rdoComp_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraComp.setEditable(false);
					txtOtraComp.setText("");
				}
			});
		}
		return rdoComp_4;
	}

	/**
	 * This method initializes rdoQuir_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_1() {
		if (rdoQuir_1 == null) {
			rdoQuir_1 = new JRadioButton();
			rdoQuir_1.setBounds(new Rectangle(585, 405, 50, 22));
			rdoQuir_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_1.setText("NO");
			rdoQuir_1.setBackground(new Color(204, 204, 204));
			rdoQuir_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraQuir.setEditable(false);
					txtOtraQuir.setText("");
				}
			});
		}
		return rdoQuir_1;
	}

	/**
	 * This method initializes rdoQuir_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_2() {
		if (rdoQuir_2 == null) {
			rdoQuir_2 = new JRadioButton();
			rdoQuir_2.setBounds(new Rectangle(585, 425, 130, 22));
			rdoQuir_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_2.setText("POLIPECTOMIA");
			rdoQuir_2.setBackground(new Color(204, 204, 204));
			rdoQuir_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraQuir.setEditable(false);
					txtOtraQuir.setText("");
				}
			});
		}
		return rdoQuir_2;
	}

	/**
	 * This method initializes rdoQuir_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_3() {
		if (rdoQuir_3 == null) {
			rdoQuir_3 = new JRadioButton();
			rdoQuir_3.setBounds(new Rectangle(585, 445, 130, 22));
			rdoQuir_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_3.setText("MIOMECTOMIA");
			rdoQuir_3.setBackground(new Color(204, 204, 204));
			rdoQuir_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraQuir.setEditable(false);
					txtOtraQuir.setText("");
				}
			});
		}
		return rdoQuir_3;
	}

	/**
	 * This method initializes rdoQuir_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_4() {
		if (rdoQuir_4 == null) {
			rdoQuir_4 = new JRadioButton();
			rdoQuir_4.setBounds(new Rectangle(585, 465, 130, 22));
			rdoQuir_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_4.setText("ADHESIOLISIS");
			rdoQuir_4.setBackground(new Color(204, 204, 204));
			rdoQuir_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraQuir.setEditable(false);
					txtOtraQuir.setText("");
				}
			});
		}
		return rdoQuir_4;
	}

	/**
	 * This method initializes rdoQuir_7	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_7() {
		if (rdoQuir_7 == null) {
			rdoQuir_7 = new JRadioButton();
			rdoQuir_7.setBounds(new Rectangle(585, 525, 74, 22));
			rdoQuir_7.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_7.setText("OTROS");
			rdoQuir_7.setBackground(new Color(204, 204, 204));
			rdoQuir_7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraQuir.setEditable(true);
				}
			});
		}
		return rdoQuir_7;
	}

	/**
	 * This method initializes txtOtraQuir	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraQuir() {
		if (txtOtraQuir == null) {
			txtOtraQuir = new JTextField();
			txtOtraQuir.setBounds(new Rectangle(585, 547, 195, 22));
			txtOtraQuir.setEditable(false);
			txtOtraQuir.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraQuir.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraQuir.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraQuir;
	}

	/**
	 * This method initializes rdoTerap_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTerap_1() {
		if (rdoTerap_1 == null) {
			rdoTerap_1 = new JRadioButton();
			rdoTerap_1.setBounds(new Rectangle(370, 405, 50, 22));
			rdoTerap_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTerap_1.setText("NO");
			rdoTerap_1.setBackground(new Color(204, 204, 204));
			rdoTerap_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraTerap.setEditable(false);
					txtOtraTerap.setText("");
				}
			});
		}
		return rdoTerap_1;
	}

	/**
	 * This method initializes rdoTerap_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTerap_2() {
		if (rdoTerap_2 == null) {
			rdoTerap_2 = new JRadioButton();
			rdoTerap_2.setBounds(new Rectangle(370, 425, 150, 22));
			rdoTerap_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTerap_2.setText("POLIPEC. ENDOMET.");
			rdoTerap_2.setBackground(new Color(204, 204, 204));
			rdoTerap_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraTerap.setEditable(false);
					txtOtraTerap.setText("");
				}
			});
		}
		return rdoTerap_2;
	}

	/**
	 * This method initializes rdoTerap_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTerap_3() {
		if (rdoTerap_3 == null) {
			rdoTerap_3 = new JRadioButton();
			rdoTerap_3.setBounds(new Rectangle(370, 445, 145, 22));
			rdoTerap_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTerap_3.setText("POLIPEC. ENDOCERV");
			rdoTerap_3.setBackground(new Color(204, 204, 204));
			rdoTerap_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraTerap.setEditable(false);
					txtOtraTerap.setText("");
				}
			});
		}
		return rdoTerap_3;
	}

	/**
	 * This method initializes rdoTerap_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTerap_4() {
		if (rdoTerap_4 == null) {
			rdoTerap_4 = new JRadioButton();
			rdoTerap_4.setBounds(new Rectangle(370, 465, 141, 22));
			rdoTerap_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTerap_4.setText("LISIS ADHERENCIAS");
			rdoTerap_4.setBackground(new Color(204, 204, 204));
			rdoTerap_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraTerap.setEditable(false);
					txtOtraTerap.setText("");
				}
			});
		}
		return rdoTerap_4;
	}

	/**
	 * This method initializes rdoTerap_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTerap_6() {
		if (rdoTerap_6 == null) {
			rdoTerap_6 = new JRadioButton();
			rdoTerap_6.setBounds(new Rectangle(370, 505, 70, 22));
			rdoTerap_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTerap_6.setText("OTROS");
			rdoTerap_6.setBackground(new Color(204, 204, 204));
			rdoTerap_6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraTerap.setEditable(true);
				}
			});
		}
		return rdoTerap_6;
	}

	/**
	 * This method initializes txtOtraTerap	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraTerap() {
		if (txtOtraTerap == null) {
			txtOtraTerap = new JTextField();
			txtOtraTerap.setBounds(new Rectangle(370, 527, 193, 22));
			txtOtraTerap.setEditable(false);
			txtOtraTerap.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraTerap.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraTerap.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraTerap;
	}

	/**
	 * This method initializes rdoBiop_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoBiop_1() {
		if (rdoBiop_1 == null) {
			rdoBiop_1 = new JRadioButton();
			rdoBiop_1.setBounds(new Rectangle(185, 405, 50, 22));
			rdoBiop_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoBiop_1.setText("NO");
			rdoBiop_1.setBackground(new Color(204, 204, 204));
			rdoBiop_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraBiop.setEditable(false);
					txtOtraBiop.setText("");
				}
			});
		}
		return rdoBiop_1;
	}

	/**
	 * This method initializes rdoBiop_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoBiop_2() {
		if (rdoBiop_2 == null) {
			rdoBiop_2 = new JRadioButton();
			rdoBiop_2.setBounds(new Rectangle(185, 425, 70, 22));
			rdoBiop_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoBiop_2.setText("NOVAK");
			rdoBiop_2.setBackground(new Color(204, 204, 204));
			rdoBiop_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraBiop.setEditable(false);
					txtOtraBiop.setText("");
				}
			});
		}
		return rdoBiop_2;
	}

	/**
	 * This method initializes rdoBiop_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoBiop_3() {
		if (rdoBiop_3 == null) {
			rdoBiop_3 = new JRadioButton();
			rdoBiop_3.setBounds(new Rectangle(185, 445, 100, 22));
			rdoBiop_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoBiop_3.setText("ASPIRATIVA");
			rdoBiop_3.setBackground(new Color(204, 204, 204));
			rdoBiop_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraBiop.setEditable(false);
					txtOtraBiop.setText("");
				}
			});
		}
		return rdoBiop_3;
	}

	/**
	 * This method initializes rdoBiop_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoBiop_4() {
		if (rdoBiop_4 == null) {
			rdoBiop_4 = new JRadioButton();
			rdoBiop_4.setBounds(new Rectangle(185, 465, 100, 22));
			rdoBiop_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoBiop_4.setText("DIRIGIDA");
			rdoBiop_4.setBackground(new Color(204, 204, 204));
			rdoBiop_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraBiop.setEditable(false);
					txtOtraBiop.setText("");
				}
			});
		}
		return rdoBiop_4;
	}

	/**
	 * This method initializes rdoPat_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoPat_1() {
		if (rdoPat_1 == null) {
			rdoPat_1 = new JRadioButton();
			rdoPat_1.setBounds(new Rectangle(10, 115, 100, 22));
			rdoPat_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoPat_1.setText("SI");
			rdoPat_1.setBackground(new Color(204, 204, 204));
		}
		return rdoPat_1;
	}

	/**
	 * This method initializes rdoPat_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoPat_2() {
		if (rdoPat_2 == null) {
			rdoPat_2 = new JRadioButton();
			rdoPat_2.setBounds(new Rectangle(10, 135, 100, 22));
			rdoPat_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoPat_2.setText("NO");
			rdoPat_2.setBackground(new Color(204, 204, 204));
		}
		return rdoPat_2;
	}

	/**
	 * This method initializes rdoPat_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoPat_3() {
		if (rdoPat_3 == null) {
			rdoPat_3 = new JRadioButton();
			rdoPat_3.setBounds(new Rectangle(10, 155, 135, 22));
			rdoPat_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoPat_3.setText("NO CONCLUYENTE");
			rdoPat_3.setBackground(new Color(204, 204, 204));
		}
		return rdoPat_3;
	}

	/**
	 * This method initializes txtHister	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtHister() {
		if (txtHister == null) {
			txtHister = new JTextField();
			txtHister.setBounds(new Rectangle(192, 121, 50, 22));
			txtHister.addKeyListener(new KeyAdapter()
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
				  String s = txtHister.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtHister;
	}

	/**
	 * This method initializes rdoTol_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTol_1() {
		if (rdoTol_1 == null) {
			rdoTol_1 = new JRadioButton();
			rdoTol_1.setBounds(new Rectangle(330, 115, 100, 22));
			rdoTol_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTol_1.setText("BUENA");
			rdoTol_1.setBackground(new Color(204, 204, 204));
		}
		return rdoTol_1;
	}

	/**
	 * This method initializes rdoTol_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTol_2() {
		if (rdoTol_2 == null) {
			rdoTol_2 = new JRadioButton();
			rdoTol_2.setBounds(new Rectangle(330, 135, 100, 22));
			rdoTol_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTol_2.setText("REGULAR");
			rdoTol_2.setBackground(new Color(204, 204, 204));
		}
		return rdoTol_2;
	}

	/**
	 * This method initializes rdoTol_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTol_3() {
		if (rdoTol_3 == null) {
			rdoTol_3 = new JRadioButton();
			rdoTol_3.setBounds(new Rectangle(330, 155, 100, 22));
			rdoTol_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTol_3.setText("MALA");
			rdoTol_3.setBackground(new Color(204, 204, 204));
		}
		return rdoTol_3;
	}

	/**
	 * This method initializes rdoOst_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoOst_1() {
		if (rdoOst_1 == null) {
			rdoOst_1 = new JRadioButton();
			rdoOst_1.setBounds(new Rectangle(10, 405, 100, 22));
			rdoOst_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoOst_1.setText("NO VISIBLES");
			rdoOst_1.setBackground(new Color(204, 204, 204));
		}
		return rdoOst_1;
	}

	/**
	 * This method initializes rdoOst_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoOst_2() {
		if (rdoOst_2 == null) {
			rdoOst_2 = new JRadioButton();
			rdoOst_2.setBounds(new Rectangle(10, 425, 110, 22));
			rdoOst_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoOst_2.setText("VISIBLES IZQ.");
			rdoOst_2.setBackground(new Color(204, 204, 204));
		}
		return rdoOst_2;
	}

	/**
	 * This method initializes rdoOst_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoOst_3() {
		if (rdoOst_3 == null) {
			rdoOst_3 = new JRadioButton();
			rdoOst_3.setBounds(new Rectangle(10, 445, 110, 22));
			rdoOst_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoOst_3.setText("VISIBLES DER.");
			rdoOst_3.setBackground(new Color(204, 204, 204));
		}
		return rdoOst_3;
	}

	/**
	 * This method initializes rdoQuir_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_5() {
		if (rdoQuir_5 == null) {
			rdoQuir_5 = new JRadioButton();
			rdoQuir_5.setBounds(new Rectangle(585, 485, 129, 22));
			rdoQuir_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_5.setText("RESECC. TABIQUE");
			rdoQuir_5.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_5;
	}

	/**
	 * This method initializes rdoQuir_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_6() {
		if (rdoQuir_6 == null) {
			rdoQuir_6 = new JRadioButton();
			rdoQuir_6.setBounds(new Rectangle(585, 505, 152, 22));
			rdoQuir_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_6.setText("ENDOMETRECTOMIA");
			rdoQuir_6.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_6;
	}

	/**
	 * This method initializes rdoTerap_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoTerap_5() {
		if (rdoTerap_5 == null) {
			rdoTerap_5 = new JRadioButton();
			rdoTerap_5.setBounds(new Rectangle(370, 485, 125, 22));
			rdoTerap_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoTerap_5.setText("EXTRACCION DIU");
			rdoTerap_5.setBackground(new Color(204, 204, 204));
			rdoTerap_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraTerap.setEditable(false);
					txtOtraTerap.setText("");
				}
			});
		}
		return rdoTerap_5;
	}

	/**
	 * This method initializes rdoBiop_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoBiop_5() {
		if (rdoBiop_5 == null) {
			rdoBiop_5 = new JRadioButton();
			rdoBiop_5.setBounds(new Rectangle(185, 485, 60, 24));
			rdoBiop_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoBiop_5.setText("OTRA");
			rdoBiop_5.setBackground(new Color(204, 204, 204));
			rdoBiop_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraBiop.setEditable(true);
				}
			});
		}
		return rdoBiop_5;
	}

	/**
	 * This method initializes txtOtraBiop	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraBiop() {
		if (txtOtraBiop == null) {
			txtOtraBiop = new JTextField();
			txtOtraBiop.setBounds(new Rectangle(185, 509, 170, 22));
			txtOtraBiop.setEditable(false);
			txtOtraBiop.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraBiop.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraBiop.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraBiop;
	}

	/**
	 * This method initializes rdoEndo_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_1() {
		if (rdoEndo_1 == null) {
			rdoEndo_1 = new JRadioButton();
			rdoEndo_1.setBounds(new Rectangle(10, 225, 125, 22));
			rdoEndo_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_1.setText("PROLIFERATIVO");
			rdoEndo_1.setBackground(new Color(204, 204, 204));
			rdoEndo_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_1;
	}

	/**
	 * This method initializes rdoEndo_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_2() {
		if (rdoEndo_2 == null) {
			rdoEndo_2 = new JRadioButton();
			rdoEndo_2.setBounds(new Rectangle(10, 245, 100, 22));
			rdoEndo_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_2.setText("SECRETOR");
			rdoEndo_2.setBackground(new Color(204, 204, 204));
			rdoEndo_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_2;
	}

	/**
	 * This method initializes rdoEndo_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_3() {
		if (rdoEndo_3 == null) {
			rdoEndo_3 = new JRadioButton();
			rdoEndo_3.setBounds(new Rectangle(10, 265, 100, 22));
			rdoEndo_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_3.setText("ATROFICO");
			rdoEndo_3.setBackground(new Color(204, 204, 204));
			rdoEndo_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_3;
	}

	/**
	 * This method initializes rdoEndo_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_4() {
		if (rdoEndo_4 == null) {
			rdoEndo_4 = new JRadioButton();
			rdoEndo_4.setBounds(new Rectangle(10, 285, 125, 22));
			rdoEndo_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_4.setText("DISFUNCIONAL");
			rdoEndo_4.setBackground(new Color(204, 204, 204));
			rdoEndo_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_4;
	}

	/**
	 * This method initializes rdoEndo_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_5() {
		if (rdoEndo_5 == null) {
			rdoEndo_5 = new JRadioButton();
			rdoEndo_5.setBounds(new Rectangle(10, 305, 125, 22));
			rdoEndo_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_5.setText("INFLAMATORIO");
			rdoEndo_5.setBackground(new Color(204, 204, 204));
			rdoEndo_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_5;
	}

	/**
	 * This method initializes rdoEndo_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_6() {
		if (rdoEndo_6 == null) {
			rdoEndo_6 = new JRadioButton();
			rdoEndo_6.setBounds(new Rectangle(142, 225, 135, 22));
			rdoEndo_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_6.setText("HIPERPLAS. FOCAL");
			rdoEndo_6.setBackground(new Color(204, 204, 204));
			rdoEndo_6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_6;
	}

	/**
	 * This method initializes rdoEndo_7	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_7() {
		if (rdoEndo_7 == null) {
			rdoEndo_7 = new JRadioButton();
			rdoEndo_7.setBounds(new Rectangle(142, 245, 135, 22));
			rdoEndo_7.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_7.setText("HIPERPLAS. GRAL.");
			rdoEndo_7.setBackground(new Color(204, 204, 204));
			rdoEndo_7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_7;
	}

	/**
	 * This method initializes rdoEndo_8	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_8() {
		if (rdoEndo_8 == null) {
			rdoEndo_8 = new JRadioButton();
			rdoEndo_8.setBounds(new Rectangle(142, 265, 130, 22));
			rdoEndo_8.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_8.setText("POLIPO UNICO");
			rdoEndo_8.setBackground(new Color(204, 204, 204));
			rdoEndo_8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_8;
	}

	/**
	 * This method initializes rdoEndo_9	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_9() {
		if (rdoEndo_9 == null) {
			rdoEndo_9 = new JRadioButton();
			rdoEndo_9.setBounds(new Rectangle(142, 285, 130, 22));
			rdoEndo_9.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_9.setText("POLIPOS MULT.");
			rdoEndo_9.setBackground(new Color(204, 204, 204));
			rdoEndo_9.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_9;
	}

	/**
	 * This method initializes rdoEndo_10	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_10() {
		if (rdoEndo_10 == null) {
			rdoEndo_10 = new JRadioButton();
			rdoEndo_10.setBounds(new Rectangle(142, 305, 130, 22));
			rdoEndo_10.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_10.setText("SOSPECHA CA");
			rdoEndo_10.setBackground(new Color(204, 204, 204));
			rdoEndo_10.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_10;
	}

	/**
	 * This method initializes rdoEndo_11	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_11() {
		if (rdoEndo_11 == null) {
			rdoEndo_11 = new JRadioButton();
			rdoEndo_11.setBounds(new Rectangle(282, 225, 100, 22));
			rdoEndo_11.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_11.setText("CANCER");
			rdoEndo_11.setBackground(new Color(204, 204, 204));
			rdoEndo_11.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_11;
	}

	/**
	 * This method initializes rdoEndo_12	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_12() {
		if (rdoEndo_12 == null) {
			rdoEndo_12 = new JRadioButton();
			rdoEndo_12.setBounds(new Rectangle(282, 245, 145, 22));
			rdoEndo_12.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_12.setText("RESTOS OVULARES");
			rdoEndo_12.setBackground(new Color(204, 204, 204));
			rdoEndo_12.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_12;
	}

	/**
	 * This method initializes rdoEndo_13	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_13() {
		if (rdoEndo_13 == null) {
			rdoEndo_13 = new JRadioButton();
			rdoEndo_13.setBounds(new Rectangle(282, 265, 100, 22));
			rdoEndo_13.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_13.setText("MOLA");
			rdoEndo_13.setBackground(new Color(204, 204, 204));
			rdoEndo_13.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_13;
	}

	/**
	 * This method initializes rdoEndo_14	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_14() {
		if (rdoEndo_14 == null) {
			rdoEndo_14 = new JRadioButton();
			rdoEndo_14.setBounds(new Rectangle(282, 285, 130, 22));
			rdoEndo_14.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_14.setText("RESTOS OSEOS");
			rdoEndo_14.setBackground(new Color(204, 204, 204));
			rdoEndo_14.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_14;
	}

	/**
	 * This method initializes rdoEndo_15	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_15() {
		if (rdoEndo_15 == null) {
			rdoEndo_15 = new JRadioButton();
			rdoEndo_15.setBounds(new Rectangle(282, 305, 140, 22));
			rdoEndo_15.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_15.setText("NO CONCLUYENTE");
			rdoEndo_15.setBackground(new Color(204, 204, 204));
			rdoEndo_15.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(false);
					txtOtraEndo.setText("");
				}
			});
		}
		return rdoEndo_15;
	}

	/**
	 * This method initializes rdoEndo_16	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEndo_16() {
		if (rdoEndo_16 == null) {
			rdoEndo_16 = new JRadioButton();
			rdoEndo_16.setBounds(new Rectangle(10, 325, 135, 22));
			rdoEndo_16.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEndo_16.setText("OTRA (Especificar)");
			rdoEndo_16.setBackground(new Color(204, 204, 204));
			rdoEndo_16.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraEndo.setEditable(true);
				}
			});
		}
		return rdoEndo_16;
	}

	/**
	 * This method initializes txtOtraEndo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraEndo() {
		if (txtOtraEndo == null) {
			txtOtraEndo = new JTextField();
			txtOtraEndo.setBounds(new Rectangle(142, 326, 290, 22));
			txtOtraEndo.setEditable(false);
			txtOtraEndo.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraEndo.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraEndo.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraEndo;
	}

	/**
	 * This method initializes rdoDiu_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoDiu_1() {
		if (rdoDiu_1 == null) {
			rdoDiu_1 = new JRadioButton();
			rdoDiu_1.setBounds(new Rectangle(457, 115, 60, 22));
			rdoDiu_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiu_1.setText("NO");
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
			rdoDiu_2.setBounds(new Rectangle(457, 135, 60, 22));
			rdoDiu_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiu_2.setText("SI");
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
			rdoDiu_3.setBounds(new Rectangle(526, 115, 125, 22));
			rdoDiu_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiu_3.setText("COMPLICADO");
			rdoDiu_3.setBackground(new Color(204, 204, 204));
		}
		return rdoDiu_3;
	}

	/**
	 * This method initializes rdoDiu_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoDiu_4() {
		if (rdoDiu_4 == null) {
			rdoDiu_4 = new JRadioButton();
			rdoDiu_4.setBounds(new Rectangle(526, 135, 130, 22));
			rdoDiu_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoDiu_4.setText("NO COMPLICADO");
			rdoDiu_4.setBackground(new Color(204, 204, 204));
		}
		return rdoDiu_4;
	}

	/**
	 * This method initializes rdoCanal_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_1() {
		if (rdoCanal_1 == null) {
			rdoCanal_1 = new JRadioButton();
			rdoCanal_1.setBounds(new Rectangle(450, 225, 100, 22));
			rdoCanal_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_1.setText("SIN LESION");
			rdoCanal_1.setBackground(new Color(204, 204, 204));
			rdoCanal_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(false);
					txtOtroCanal.setText("");
				}
			});
		}
		return rdoCanal_1;
	}

	/**
	 * This method initializes rdoCanal_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_2() {
		if (rdoCanal_2 == null) {
			rdoCanal_2 = new JRadioButton();
			rdoCanal_2.setBounds(new Rectangle(450, 245, 100, 22));
			rdoCanal_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_2.setText("ATROFICO");
			rdoCanal_2.setBackground(new Color(204, 204, 204));
			rdoCanal_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(false);
					txtOtroCanal.setText("");
				}
			});
		}
		return rdoCanal_2;
	}

	/**
	 * This method initializes rdoCanal_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_3() {
		if (rdoCanal_3 == null) {
			rdoCanal_3 = new JRadioButton();
			rdoCanal_3.setBounds(new Rectangle(450, 265, 100, 22));
			rdoCanal_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_3.setText("TABIQUE");
			rdoCanal_3.setBackground(new Color(204, 204, 204));
			rdoCanal_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(false);
					txtOtroCanal.setText("");
				}
			});
		}
		return rdoCanal_3;
	}

	/**
	 * This method initializes rdoCanal_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_4() {
		if (rdoCanal_4 == null) {
			rdoCanal_4 = new JRadioButton();
			rdoCanal_4.setBounds(new Rectangle(450, 285, 80, 22));
			rdoCanal_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_4.setText("MIOMA");
			rdoCanal_4.setBackground(new Color(204, 204, 204));
			rdoCanal_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(false);
					txtOtroCanal.setText("");
				}
			});
		}
		return rdoCanal_4;
	}

	/**
	 * This method initializes rdoCanal_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_5() {
		if (rdoCanal_5 == null) {
			rdoCanal_5 = new JRadioButton();
			rdoCanal_5.setBounds(new Rectangle(559, 225, 80, 22));
			rdoCanal_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_5.setText("POLIPO");
			rdoCanal_5.setBackground(new Color(204, 204, 204));
			rdoCanal_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(false);
					txtOtroCanal.setText("");
				}
			});
		}
		return rdoCanal_5;
	}

	/**
	 * This method initializes rdoCanal_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_6() {
		if (rdoCanal_6 == null) {
			rdoCanal_6 = new JRadioButton();
			rdoCanal_6.setBounds(new Rectangle(559, 245, 110, 22));
			rdoCanal_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_6.setText("INFLAMACION");
			rdoCanal_6.setBackground(new Color(204, 204, 204));
			rdoCanal_6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(false);
					txtOtroCanal.setText("");
				}
			});
		}
		return rdoCanal_6;
	}

	/**
	 * This method initializes rdoCanal_7	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_7() {
		if (rdoCanal_7 == null) {
			rdoCanal_7 = new JRadioButton();
			rdoCanal_7.setBounds(new Rectangle(559, 265, 100, 22));
			rdoCanal_7.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_7.setText("CANCER");
			rdoCanal_7.setBackground(new Color(204, 204, 204));
			rdoCanal_7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(false);
					txtOtroCanal.setText("");
				}
			});
		}
		return rdoCanal_7;
	}

	/**
	 * This method initializes rdoCanal_8	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCanal_8() {
		if (rdoCanal_8 == null) {
			rdoCanal_8 = new JRadioButton();
			rdoCanal_8.setBounds(new Rectangle(450, 305, 80, 22));
			rdoCanal_8.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCanal_8.setText("OTRO");
			rdoCanal_8.setBackground(new Color(204, 204, 204));
			rdoCanal_8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCanal.setEditable(true);
				}
			});
		}
		return rdoCanal_8;
	}

	/**
	 * This method initializes txtOtroCanal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtroCanal() {
		if (txtOtroCanal == null) {
			txtOtroCanal = new JTextField();
			txtOtroCanal.setBounds(new Rectangle(450, 327, 220, 23));
			txtOtroCanal.setEditable(false);
			txtOtroCanal.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtroCanal.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtroCanal.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtroCanal;
	}

	/**
	 * This method initializes rdoMiomas_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMiomas_1() {
		if (rdoMiomas_1 == null) {
			rdoMiomas_1 = new JRadioButton();
			rdoMiomas_1.setBounds(new Rectangle(692, 115, 50, 22));
			rdoMiomas_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMiomas_1.setText("NO");
			rdoMiomas_1.setBackground(new Color(204, 204, 204));
		}
		return rdoMiomas_1;
	}

	/**
	 * This method initializes rdoMiomas_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMiomas_2() {
		if (rdoMiomas_2 == null) {
			rdoMiomas_2 = new JRadioButton();
			rdoMiomas_2.setBounds(new Rectangle(692, 135, 50, 22));
			rdoMiomas_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMiomas_2.setText("SI");
			rdoMiomas_2.setBackground(new Color(204, 204, 204));
		}
		return rdoMiomas_2;
	}

	/**
	 * This method initializes rdoMiomas_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMiomas_3() {
		if (rdoMiomas_3 == null) {
			rdoMiomas_3 = new JRadioButton();
			rdoMiomas_3.setBounds(new Rectangle(744, 115, 70, 22));
			rdoMiomas_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMiomas_3.setText("UNICO");
			rdoMiomas_3.setBackground(new Color(204, 204, 204));
		}
		return rdoMiomas_3;
	}

	/**
	 * This method initializes rdoMiomas_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMiomas_4() {
		if (rdoMiomas_4 == null) {
			rdoMiomas_4 = new JRadioButton();
			rdoMiomas_4.setBounds(new Rectangle(744, 135, 90, 22));
			rdoMiomas_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMiomas_4.setText("MULTIPLE");
			rdoMiomas_4.setBackground(new Color(204, 204, 204));
		}
		return rdoMiomas_4;
	}

	/**
	 * This method initializes rdoMiomas_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMiomas_5() {
		if (rdoMiomas_5 == null) {
			rdoMiomas_5 = new JRadioButton();
			rdoMiomas_5.setBounds(new Rectangle(838, 115, 110, 22));
			rdoMiomas_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMiomas_5.setText("INTRAMURAL");
			rdoMiomas_5.setBackground(new Color(204, 204, 204));
		}
		return rdoMiomas_5;
	}

	/**
	 * This method initializes rdoMiomas_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMiomas_6() {
		if (rdoMiomas_6 == null) {
			rdoMiomas_6 = new JRadioButton();
			rdoMiomas_6.setBounds(new Rectangle(838, 135, 110, 22));
			rdoMiomas_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMiomas_6.setText("SUBMUCOSO");
			rdoMiomas_6.setBackground(new Color(204, 204, 204));
		}
		return rdoMiomas_6;
	}

	/**
	 * This method initializes rdoAdh_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAdh_1() {
		if (rdoAdh_1 == null) {
			rdoAdh_1 = new JRadioButton();
			rdoAdh_1.setBounds(new Rectangle(10, 535, 50, 22));
			rdoAdh_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAdh_1.setText("NO");
			rdoAdh_1.setBackground(new Color(204, 204, 204));
		}
		return rdoAdh_1;
	}

	/**
	 * This method initializes rdoAdh_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAdh_2() {
		if (rdoAdh_2 == null) {
			rdoAdh_2 = new JRadioButton();
			rdoAdh_2.setBounds(new Rectangle(10, 555, 60, 22));
			rdoAdh_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAdh_2.setText("LAXAS");
			rdoAdh_2.setBackground(new Color(204, 204, 204));
		}
		return rdoAdh_2;
	}

	/**
	 * This method initializes rdoAdh_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAdh_3() {
		if (rdoAdh_3 == null) {
			rdoAdh_3 = new JRadioButton();
			rdoAdh_3.setBounds(new Rectangle(10, 575, 75, 22));
			rdoAdh_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAdh_3.setText("FIRMES");
			rdoAdh_3.setBackground(new Color(204, 204, 204));
		}
		return rdoAdh_3;
	}

	/**
	 * This method initializes rdoAdh_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAdh_4() {
		if (rdoAdh_4 == null) {
			rdoAdh_4 = new JRadioButton();
			rdoAdh_4.setBounds(new Rectangle(90, 535, 60, 22));
			rdoAdh_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAdh_4.setText("< 1/3");
			rdoAdh_4.setBackground(new Color(204, 204, 204));
		}
		return rdoAdh_4;
	}

	/**
	 * This method initializes rdoAdh_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAdh_5() {
		if (rdoAdh_5 == null) {
			rdoAdh_5 = new JRadioButton();
			rdoAdh_5.setBounds(new Rectangle(90, 555, 80, 22));
			rdoAdh_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAdh_5.setText("1/3 - 2/3");
			rdoAdh_5.setBackground(new Color(204, 204, 204));
		}
		return rdoAdh_5;
	}

	/**
	 * This method initializes rdoAdh_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAdh_6() {
		if (rdoAdh_6 == null) {
			rdoAdh_6 = new JRadioButton();
			rdoAdh_6.setBounds(new Rectangle(90, 575, 70, 22));
			rdoAdh_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAdh_6.setText("> 2/3");
			rdoAdh_6.setBackground(new Color(204, 204, 204));
		}
		return rdoAdh_6;
	}

	/**
	 * This method initializes rdoMal_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMal_1() {
		if (rdoMal_1 == null) {
			rdoMal_1 = new JRadioButton();
			rdoMal_1.setBounds(new Rectangle(803, 225, 60, 22));
			rdoMal_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMal_1.setText("NO");
			rdoMal_1.setBackground(new Color(204, 204, 204));
			rdoMal_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraMal.setEditable(false);
					txtOtraMal.setText("");
				}
			});
		}
		return rdoMal_1;
	}

	/**
	 * This method initializes rdoMal_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMal_2() {
		if (rdoMal_2 == null) {
			rdoMal_2 = new JRadioButton();
			rdoMal_2.setBounds(new Rectangle(803, 245, 90, 22));
			rdoMal_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMal_2.setText("TABIQUE");
			rdoMal_2.setBackground(new Color(204, 204, 204));
			rdoMal_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraMal.setEditable(false);
					txtOtraMal.setText("");
				}
			});
		}
		return rdoMal_2;
	}

	/**
	 * This method initializes rdoMal_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMal_3() {
		if (rdoMal_3 == null) {
			rdoMal_3 = new JRadioButton();
			rdoMal_3.setBounds(new Rectangle(803, 265, 90, 22));
			rdoMal_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMal_3.setText("DIDELFO");
			rdoMal_3.setBackground(new Color(204, 204, 204));
			rdoMal_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraMal.setEditable(false);
					txtOtraMal.setText("");
				}
			});
		}
		return rdoMal_3;
	}

	/**
	 * This method initializes rdoMal_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMal_4() {
		if (rdoMal_4 == null) {
			rdoMal_4 = new JRadioButton();
			rdoMal_4.setBounds(new Rectangle(803, 285, 80, 22));
			rdoMal_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMal_4.setText("OTRA");
			rdoMal_4.setBackground(new Color(204, 204, 204));
			rdoMal_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtraMal.setEditable(true);
				}
			});
		}
		return rdoMal_4;
	}

	/**
	 * This method initializes txtOtraMal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraMal() {
		if (txtOtraMal == null) {
			txtOtraMal = new JTextField();
			txtOtraMal.setBounds(new Rectangle(803, 307, 190, 22));
			txtOtraMal.setEditable(false);
			txtOtraMal.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraMal.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraMal.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraMal;
	}
}