package grafica.vistas;

import grafica.controladores.CdorAntecedentes;
import java.awt.Color;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class FrmAntecedentes extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorAntecedentes cdor;
	private JTextField txtOtrosPers = null;
	private JRadioButton rdoAnat_1 = null;
	private JRadioButton rdoAnat_2 = null;
	private ButtonGroup grpEsterilidad = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMens = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpSind = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpMenop = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpInfecA = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpInfecB = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpLegados = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpCavidad_1 = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpAnatPat = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpQuirurgica = new ButtonGroup();  //  @jve:decl-index=0:
	private ButtonGroup grpCuello = new ButtonGroup();  //  @jve:decl-index=0:
	private JRadioButton rdoCuello_1 = null;
	private JRadioButton rdoCuello_2 = null;
	private JRadioButton rdoCuello_3 = null;
	private JRadioButton rdoCuello_4 = null;
	private JRadioButton rdoCuello_5 = null;
	private JRadioButton rdoCuello_6 = null;
	private JTextField txtOtroCuello = null;
	private JLabel lblAnios = null;
	private JRadioButton rdoEsterilidad_1 = null;
	private JRadioButton rdoEsterilidad_2 = null;
	private JTextField txtMenarca = null;
	private JRadioButton rdoMens_1 = null;
	private JRadioButton rdoMens_2 = null;
	private JRadioButton rdoMens_3 = null;
	private JRadioButton rdoAnatPat_1 = null;
	private JRadioButton rdoAnatPat_2 = null;
	private JRadioButton rdoAnatPat_3 = null;
	private JRadioButton rdoAnatPat_4 = null;
	private JRadioButton rdoAnatPat_5 = null;
	private JRadioButton rdoAnatPat_6 = null;
	private JTextField txtOtroCancer = null;
	private JRadioButton rdoSind_1 = null;
	private JRadioButton rdoSind_2 = null;
	private JRadioButton rdoLegados_1 = null;
	private JRadioButton rdoLegados_2 = null;
	private JRadioButton rdoLegados_3 = null;
	private JRadioButton rdoMenop_1 = null;
	private JRadioButton rdoMenop_2 = null;
	private JRadioButton rdoInfecA_1 = null;
	private JRadioButton rdoInfecA_2 = null;
	private JRadioButton rdoInfecB_1 = null;
	private JRadioButton rdoInfecB_2 = null;
	private JRadioButton rdoQuir_1 = null;
	private JRadioButton rdoQuir_2 = null;
	private JTextField txtOtraCirugia = null;
	private JLabel lblLinea_1 = null;
	private JLabel lblAnt = null;
	private JLabel lblGestas = null;
	private JLabel lblPartos = null;
	private JLabel lblCesareas = null;
	private JLabel lblAbortos = null;
	private JLabel lblEsp = null;
	private JLabel lblProv = null;
	private JLabel lblEctopicos = null;
	private JTextField txtGestas = null;
	private JTextField txtPartos = null;
	private JTextField txtCesareas = null;
	private JTextField txtAbortos = null;
	private JTextField txtEsp = null;
	private JTextField txtProv = null;
	private JTextField txtEctopicos = null;
	private JRadioButton rdoMens_4 = null;
	private JLabel lblTipo = null;
	private JLabel lblMenarca = null;
	private JLabel lblFUM = null;
	private JPanel jPanelFUM = null;
	JDateChooser calendarFUM = new JDateChooser();
	private JLabel lblMenop = null;
	private JLabel lblSind = null;
	private JLabel lblInfecciones = null;
	private JLabel lblAltas = null;
	private JLabel lblBajas = null;
	private JLabel lblLegados = null;
	private JLabel lblLinea_2 = null;
	private JLabel lblAnat_1 = null;
	private JTextField txtAnat_1 = null;
	private JButton btnCodigos = null;
	private JLabel lblCuello = null;
	private JLabel lblAnat_2 = null;
	private JLabel lblCirugia = null;
	private JCheckBox chkCirugia_1 = null;
	private JCheckBox chkCirugia_2 = null;
	private JCheckBox chkCirugia_3 = null;
	private JCheckBox chkCirugia_4 = null;
	private JCheckBox chkCirugia_5 = null;
	private JCheckBox chkCirugia_6 = null;
	private JCheckBox chkCirugia_7 = null;
	private JCheckBox chkCirugia_8 = null;
	private JCheckBox chkCirugia_9 = null;
	private JCheckBox chkCirugia_10 = null;
	private JCheckBox chkCirugia_11 = null;
	private JLabel lblOtras = null;
	private JCheckBox chkPers_1 = null;
	private JCheckBox chkPers_2 = null;
	private JCheckBox chkPers_3 = null;
	private JCheckBox chkPers_4 = null;
	private JCheckBox chkPers_5 = null;
	private JCheckBox chkPers_6 = null;
	private JLabel lblPers = null;
	private JLabel lblFam = null;
	private JCheckBox chkPers_7 = null;
	private JCheckBox chkFam_1 = null;
	private JCheckBox chkFam_2 = null;
	private JCheckBox chkFam_3 = null;
	private JCheckBox chkFam_4 = null;
	private JCheckBox chkFam_5 = null;
	private JCheckBox chkFam_6 = null;
	private JCheckBox chkFam_7 = null;
	private JCheckBox chkPers_8 = null;
	private JLabel lblOtros = null;
	private JCheckBox chkFam_8 = null;
	private JCheckBox chkPersonales_1 = null;
	private JCheckBox chkPersonales_2 = null;
	private JCheckBox chkPersonales_3 = null;
	private JCheckBox chkPersonales_4 = null;
	private JCheckBox chkPersonales_5 = null;
	private JLabel lblOtrosPer = null;
	
	public FrmAntecedentes(CdorAntecedentes cdor) {
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
			lblOtrosPer = new JLabel();
			lblOtrosPer.setBounds(new Rectangle(355, 567, 44, 22));
			lblOtrosPer.setText("OTROS");
			lblOtrosPer.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblOtros = new JLabel();
			lblOtros.setBounds(new Rectangle(17, 643, 48, 22));
			lblOtros.setText("OTROS");
			lblOtros.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblFam = new JLabel();
			lblFam.setBounds(new Rectangle(45, 462, 34, 22));
			lblFam.setText("FAM.");
			lblFam.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblPers = new JLabel();
			lblPers.setBounds(new Rectangle(9, 462, 34, 22));
			lblPers.setText("PERS.");
			lblPers.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblOtras = new JLabel();
			lblOtras.setBounds(new Rectangle(795, 397, 41, 22));
			lblOtras.setText("OTRAS");
			lblOtras.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblCirugia = new JLabel();
			lblCirugia.setBounds(new Rectangle(612, 279, 134, 21));
			lblCirugia.setText("CIRUGIA ABDOMINAL");
			lblCirugia.setFont(new Font("Calibri", Font.BOLD, 14));
			lblAnat_2 = new JLabel();
			lblAnat_2.setBounds(new Rectangle(428, 279, 146, 20));
			lblAnat_2.setText("ANATOMIA PATOLOGICA");
			lblAnat_2.setFont(new Font("Calibri", Font.BOLD, 14));
			lblCuello = new JLabel();
			lblCuello.setBounds(new Rectangle(334, 279, 60, 21));
			lblCuello.setText("CUELLO");
			lblCuello.setFont(new Font("Calibri", Font.BOLD, 14));
			lblAnat_1 = new JLabel();
			lblAnat_1.setBounds(new Rectangle(139, 327, 156, 20));
			lblAnat_1.setText("ANATOMIA PATOLOGICA");
			lblAnat_1.setFont(new Font("Calibri", Font.BOLD, 14));
			lblLinea_2 = new JLabel();
			lblLinea_2.setBounds(new Rectangle(12, 305, 292, 21));
			lblLinea_2.setText("_________________________________________");
			lblLinea_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblLegados = new JLabel();
			lblLegados.setBounds(new Rectangle(13, 327, 66, 22));
			lblLegados.setText("LEGADOS");
			lblLegados.setFont(new Font("Calibri", Font.BOLD, 14));
			lblBajas = new JLabel();
			lblBajas.setBounds(new Rectangle(807, 164, 42, 22));
			lblBajas.setText("BAJAS");
			lblBajas.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblAltas = new JLabel();
			lblAltas.setBounds(new Rectangle(806, 135, 41, 22));
			lblAltas.setText("ALTAS");
			lblAltas.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblInfecciones = new JLabel();
			lblInfecciones.setBounds(new Rectangle(799, 113, 109, 21));
			lblInfecciones.setText("INFECCIONES");
			lblInfecciones.setFont(new Font("Calibri", Font.BOLD, 14));
			lblSind = new JLabel();
			lblSind.setBounds(new Rectangle(657, 164, 120, 22));
			lblSind.setText("SIND. CLIMATERICO");
			lblSind.setFont(new Font("Calibri", Font.BOLD, 14));
			lblMenop = new JLabel();
			lblMenop.setBounds(new Rectangle(657, 113, 105, 23));
			lblMenop.setText("MENOPAUSIA");
			lblMenop.setFont(new Font("Calibri", Font.BOLD, 14));
			lblFUM = new JLabel();
			lblFUM.setBounds(new Rectangle(362, 180, 48, 22));
			lblFUM.setText("F.U.M.");
			lblFUM.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblMenarca = new JLabel();
			lblMenarca.setBounds(new Rectangle(362, 114, 75, 22));
			lblMenarca.setText("MENARCA");
			lblMenarca.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblTipo = new JLabel();
			lblTipo.setBounds(new Rectangle(493, 114, 121, 21));
			lblTipo.setText("TIPO MENSTRUAL");
			lblTipo.setFont(new Font("Calibri", Font.BOLD, 14));
			lblEctopicos = new JLabel();
			lblEctopicos.setBounds(new Rectangle(107, 181, 69, 20));
			lblEctopicos.setText("ECTOPICOS");
			lblEctopicos.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblProv = new JLabel();
			lblProv.setBounds(new Rectangle(298, 159, 39, 20));
			lblProv.setText("PROV.");
			lblProv.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblEsp = new JLabel();
			lblEsp.setBounds(new Rectangle(204, 159, 52, 20));
			lblEsp.setText("---> ESP.");
			lblEsp.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblAbortos = new JLabel();
			lblAbortos.setBounds(new Rectangle(107, 159, 69, 20));
			lblAbortos.setText("ABORTOS");
			lblAbortos.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblCesareas = new JLabel();
			lblCesareas.setBounds(new Rectangle(107, 137, 69, 20));
			lblCesareas.setText("CESAREAS");
			lblCesareas.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblPartos = new JLabel();
			lblPartos.setBounds(new Rectangle(83, 115, 93, 20));
			lblPartos.setText(" ---> PARTOS");
			lblPartos.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblGestas = new JLabel();
			lblGestas.setBounds(new Rectangle(11, 115, 50, 20));
			lblGestas.setText("GESTAS");
			lblGestas.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblAnt = new JLabel();
			lblAnt.setBounds(new Rectangle(11, 220, 179, 22));
			lblAnt.setText("Antecedentes de Esterilidad");
			lblAnt.setFont(new Font("Calibri", Font.BOLD, 14));
			lblLinea_1 = new JLabel();
			lblLinea_1.setBounds(new Rectangle(11, 195, 289, 22));
			lblLinea_1.setText("_________________________________________");
			lblLinea_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblAnios = new JLabel();
			lblAnios.setBounds(new Rectangle(395, 136, 37, 22));
			lblAnios.setText("años");
			lblAnios.setFont(new Font("Calibri", Font.PLAIN, 14));
			panelFondo = new PanelConImagen("./src/imagenes/fondoAntecedentes.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(getTxtOtrosPers(), null);
			panelFondo.add(getRdoAnat_1(), null);
			panelFondo.add(getRdoAnat_2(), null);
			panelFondo.add(getRdoCuello_1(), null);
			panelFondo.add(getRdoCuello_2(), null);
			panelFondo.add(getRdoCuello_3(), null);
			panelFondo.add(getRdoCuello_4(), null);
			panelFondo.add(getRdoCuello_5(), null);
			panelFondo.add(getRdoCuello_6(), null);
			panelFondo.add(getTxtOtroCuello(), null);
			panelFondo.add(lblAnios, null);
			panelFondo.add(getRdoEsterilidad_1(), null);
			panelFondo.add(getRdoEsterilidad_2(), null);
			panelFondo.add(getTxtMenarca(), null);
			panelFondo.add(getRdoMens_1(), null);
			panelFondo.add(getRdoMens_2(), null);
			panelFondo.add(getRdoMens_3(), null);
			panelFondo.add(getRdoAnatPat_1(), null);
			panelFondo.add(getRdoAnatPat_2(), null);
			panelFondo.add(getRdoAnatPat_3(), null);
			panelFondo.add(getRdoAnatPat_4(), null);
			panelFondo.add(getRdoAnatPat_5(), null);
			panelFondo.add(getRdoAnatPat_6(), null);
			panelFondo.add(getTxtOtroCancer(), null);
			panelFondo.add(getRdoSind_1(), null);
			panelFondo.add(getRdoSind_2(), null);
			panelFondo.add(getRdoLegados_1(), null);
			panelFondo.add(getRdoLegados_2(), null);
			panelFondo.add(getRdoLegados_3(), null);
			panelFondo.add(getRdoMenop_1(), null);
			panelFondo.add(getRdoMenop_2(), null);
			panelFondo.add(getRdoInfecA_1(), null);
			panelFondo.add(getRdoInfecA_2(), null);
			panelFondo.add(getRdoInfecB_1(), null);
			panelFondo.add(getRdoInfecB_2(), null);
			panelFondo.add(getRdoQuir_1(), null);
			panelFondo.add(getRdoQuir_2(), null);
			panelFondo.add(getTxtOtraCirugia(), null);
			panelFondo.add(lblLinea_1, null);
			panelFondo.add(lblAnt, null);
			panelFondo.add(lblGestas, null);
			panelFondo.add(lblPartos, null);
			panelFondo.add(lblCesareas, null);
			panelFondo.add(lblAbortos, null);
			panelFondo.add(lblEsp, null);
			panelFondo.add(lblProv, null);
			panelFondo.add(lblEctopicos, null);
			panelFondo.add(getTxtGestas(), null);
			panelFondo.add(getTxtPartos(), null);
			panelFondo.add(getTxtCesareas(), null);
			panelFondo.add(getTxtAbortos(), null);
			panelFondo.add(getTxtEsp(), null);
			panelFondo.add(getTxtProv(), null);
			panelFondo.add(getTxtEctopicos(), null);
			panelFondo.add(getRdoMens_4(), null);
			panelFondo.add(lblTipo, null);
			panelFondo.add(lblMenarca, null);
			panelFondo.add(lblFUM, null);
			panelFondo.add(getbtGuardar(), null);
			grpEsterilidad.add(rdoEsterilidad_1);
			grpEsterilidad.add(rdoEsterilidad_2);
			grpMens.add(rdoMens_1);
			grpMens.add(rdoMens_2);
			grpMens.add(rdoMens_3);
			grpSind.add(rdoSind_1);
			grpSind.add(rdoSind_2);
			grpMenop.add(rdoMenop_1);
			grpMenop.add(rdoMenop_2);
			grpInfecA.add(rdoInfecA_1);
			grpInfecA.add(rdoInfecA_2);
			grpInfecB.add(rdoInfecB_1);
			grpInfecB.add(rdoInfecB_2);
			grpLegados.add(rdoLegados_1);
			grpLegados.add(rdoLegados_2);
			grpLegados.add(rdoLegados_3);
			grpCavidad_1.add(rdoAnat_1);
			grpCavidad_1.add(rdoAnat_2);
			grpAnatPat.add(rdoAnatPat_1);
			grpAnatPat.add(rdoAnatPat_2);
			grpAnatPat.add(rdoAnatPat_3);
			grpAnatPat.add(rdoAnatPat_4);
			grpAnatPat.add(rdoAnatPat_5);
			grpAnatPat.add(rdoAnatPat_6);
			grpCuello.add(rdoCuello_1);
			grpCuello.add(rdoCuello_2);
			grpCuello.add(rdoCuello_3);
			grpCuello.add(rdoCuello_4);
			grpCuello.add(rdoCuello_5);
			grpCuello.add(rdoCuello_6);
			grpQuirurgica.add(rdoQuir_1);
			grpQuirurgica.add(rdoQuir_2);
			panelFondo.add(getJPanelFUM(), null);
			panelFondo.add(lblMenop, null);
			panelFondo.add(lblSind, null);
			panelFondo.add(lblInfecciones, null);
			panelFondo.add(lblAltas, null);
			panelFondo.add(lblBajas, null);
			panelFondo.add(lblLegados, null);
			panelFondo.add(lblLinea_2, null);
			panelFondo.add(lblAnat_1, null);
			panelFondo.add(getTxtAnat_1(), null);
			panelFondo.add(getBtnCodigos(), null);
			panelFondo.add(lblCuello, null);
			panelFondo.add(lblAnat_2, null);
			panelFondo.add(getRdoAnatPat_4(), null);
			panelFondo.add(getRdoAnatPat_5(), null);
			panelFondo.add(getRdoAnatPat_6(), null);
			panelFondo.add(lblCirugia, null);
			panelFondo.add(getChkCirugia_1(), null);
			panelFondo.add(getChkCirugia_2(), null);
			panelFondo.add(getChkCirugia_3(), null);
			panelFondo.add(getChkCirugia_4(), null);
			panelFondo.add(getChkCirugia_5(), null);
			panelFondo.add(getChkCirugia_6(), null);
			panelFondo.add(getChkCirugia_7(), null);
			panelFondo.add(getChkCirugia_8(), null);
			panelFondo.add(getChkCirugia_9(), null);
			panelFondo.add(getChkCirugia_10(), null);
			panelFondo.add(getChkCirugia_11(), null);
			panelFondo.add(lblOtras, null);
			panelFondo.add(getChkPers_1(), null);
			panelFondo.add(getChkPers_2(), null);
			panelFondo.add(getChkPers_3(), null);
			panelFondo.add(getChkPers_4(), null);
			panelFondo.add(getChkPers_5(), null);
			panelFondo.add(getChkPers_6(), null);
			panelFondo.add(lblPers, null);
			panelFondo.add(lblFam, null);
			panelFondo.add(getChkPers_7(), null);
			panelFondo.add(getChkFam_1(), null);
			panelFondo.add(getChkFam_2(), null);
			panelFondo.add(getChkFam_3(), null);
			panelFondo.add(getChkFam_4(), null);
			panelFondo.add(getChkFam_5(), null);
			panelFondo.add(getChkFam_6(), null);
			panelFondo.add(getChkFam_7(), null);
			panelFondo.add(getChkPers_8(), null);
			panelFondo.add(lblOtros, null);
			panelFondo.add(getChkFam_8(), null);
			panelFondo.add(getChkPersonales_1(), null);
			panelFondo.add(getChkPersonales_2(), null);
			panelFondo.add(getChkPersonales_3(), null);
			panelFondo.add(getChkPersonales_4(), null);
			panelFondo.add(getChkPersonales_5(), null);
			panelFondo.add(lblOtrosPer, null);
		}
		return panelFondo;
	}

	private JButton getbtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setBounds(new Rectangle(1102, 623, 40, 40));
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
			btCancelar.setBounds(new Rectangle(1052, 623, 40, 40));
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

	private JTextField getTxtOtrosPers() {
		if (txtOtrosPers == null) {
			txtOtrosPers = new JTextField();
			txtOtrosPers.setBounds(new Rectangle(399, 567, 217, 22));
			txtOtrosPers.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtrosPers.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtrosPers.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtrosPers;
	}

	private JRadioButton getRdoAnat_1() {
		if (rdoAnat_1 == null) {
			rdoAnat_1 = new JRadioButton();
			rdoAnat_1.setBounds(new Rectangle(142, 348, 44, 22));
			rdoAnat_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnat_1.setText("NO");
			rdoAnat_1.setBackground(new Color(204, 204, 204));
			rdoAnat_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtAnat_1.setEditable(false);
					txtAnat_1.setText("");
				}
			});
		}
		return rdoAnat_1;
	}

	private JRadioButton getRdoAnat_2() {
		if (rdoAnat_2 == null) {
			rdoAnat_2 = new JRadioButton();
			rdoAnat_2.setBounds(new Rectangle(142, 368, 44, 22));
			rdoAnat_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnat_2.setText("SI");
			rdoAnat_2.setBackground(new Color(204, 204, 204));
			rdoAnat_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtAnat_1.setEditable(true);
				}
			});
		}
		return rdoAnat_2;
	}

	/**
	 * This method initializes rdoCuello_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCuello_1() {
		if (rdoCuello_1 == null) {
			rdoCuello_1 = new JRadioButton();
			rdoCuello_1.setBounds(new Rectangle(331, 296, 50, 22));
			rdoCuello_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCuello_1.setText("NO");
			rdoCuello_1.setBackground(new Color(204, 204, 204));
			rdoCuello_1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCuello.setEditable(false);
					txtOtroCuello.setText("");
				}
			});
		}
		return rdoCuello_1;
	}

	/**
	 * This method initializes rdoCuello_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCuello_2() {
		if (rdoCuello_2 == null) {
			rdoCuello_2 = new JRadioButton();
			rdoCuello_2.setBounds(new Rectangle(331, 316, 69, 22));
			rdoCuello_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCuello_2.setText("T.L.D.");
			rdoCuello_2.setBackground(new Color(204, 204, 204));
			rdoCuello_2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCuello.setEditable(false);
					txtOtroCuello.setText("");
				}
			});
		}
		return rdoCuello_2;
	}

	/**
	 * This method initializes rdoCuello_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCuello_3() {
		if (rdoCuello_3 == null) {
			rdoCuello_3 = new JRadioButton();
			rdoCuello_3.setBounds(new Rectangle(331, 336, 70, 22));
			rdoCuello_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCuello_3.setText("LEEP");
			rdoCuello_3.setBackground(new Color(204, 204, 204));
			rdoCuello_3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCuello.setEditable(false);
					txtOtroCuello.setText("");
				}
			});
		}
		return rdoCuello_3;
	}

	/**
	 * This method initializes rdoCuello_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCuello_4() {
		if (rdoCuello_4 == null) {
			rdoCuello_4 = new JRadioButton();
			rdoCuello_4.setBounds(new Rectangle(331, 356, 71, 22));
			rdoCuello_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCuello_4.setText("CONO");
			rdoCuello_4.setBackground(new Color(204, 204, 204));
			rdoCuello_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCuello.setEditable(false);
					txtOtroCuello.setText("");
				}
			});
		}
		return rdoCuello_4;
	}

	/**
	 * This method initializes rdoCuello_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCuello_6() {
		if (rdoCuello_6 == null) {
			rdoCuello_6 = new JRadioButton();
			rdoCuello_6.setBounds(new Rectangle(331, 396, 63, 22));
			rdoCuello_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCuello_6.setText("OTRO");
			rdoCuello_6.setBackground(new Color(204, 204, 204));
			rdoCuello_6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCuello.setEditable(true);
				}
			});
		}
		return rdoCuello_6;
	}

	/**
	 * This method initializes txtOtroCuello	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtroCuello() {
		if (txtOtroCuello == null) {
			txtOtroCuello = new JTextField();
			txtOtroCuello.setBounds(new Rectangle(395, 398, 193, 22));
			txtOtroCuello.setEditable(false);
			txtOtroCuello.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtroCuello.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtroCuello.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtroCuello;
	}

	/**
	 * This method initializes rdoEsterilidad_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEsterilidad_1() {
		if (rdoEsterilidad_1 == null) {
			rdoEsterilidad_1 = new JRadioButton();
			rdoEsterilidad_1.setBounds(new Rectangle(238, 220, 43, 22));
			rdoEsterilidad_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEsterilidad_1.setText("SI");
			rdoEsterilidad_1.setBackground(new Color(204, 204, 204));
		}
		return rdoEsterilidad_1;
	}

	/**
	 * This method initializes rdoEsterilidad_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoEsterilidad_2() {
		if (rdoEsterilidad_2 == null) {
			rdoEsterilidad_2 = new JRadioButton();
			rdoEsterilidad_2.setBounds(new Rectangle(192, 220, 48, 22));
			rdoEsterilidad_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoEsterilidad_2.setText("NO");
			rdoEsterilidad_2.setBackground(new Color(204, 204, 204));
		}
		return rdoEsterilidad_2;
	}

	/**
	 * This method initializes txtMenarca	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtMenarca() {
		if (txtMenarca == null) {
			txtMenarca = new JTextField();
			txtMenarca.setBounds(new Rectangle(362, 136, 32, 22));
			txtMenarca.addKeyListener(new KeyAdapter()
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
				  String s = txtMenarca.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtMenarca;
	}

	/**
	 * This method initializes rdoMens_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMens_1() {
		if (rdoMens_1 == null) {
			rdoMens_1 = new JRadioButton();
			rdoMens_1.setBounds(new Rectangle(496, 136, 100, 22));
			rdoMens_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMens_1.setText("REGULAR");
			rdoMens_1.setBackground(new Color(204, 204, 204));
		}
		return rdoMens_1;
	}

	/**
	 * This method initializes rdoMens_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMens_2() {
		if (rdoMens_2 == null) {
			rdoMens_2 = new JRadioButton();
			rdoMens_2.setBounds(new Rectangle(496, 156, 100, 22));
			rdoMens_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMens_2.setText("IRREGULAR");
			rdoMens_2.setBackground(new Color(204, 204, 204));
		}
		return rdoMens_2;
	}

	/**
	 * This method initializes rdoMens_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMens_3() {
		if (rdoMens_3 == null) {
			rdoMens_3 = new JRadioButton();
			rdoMens_3.setBounds(new Rectangle(496, 176, 119, 22));
			rdoMens_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMens_3.setText("POLIMENORREA");
			rdoMens_3.setBackground(new Color(204, 204, 204));
		}
		return rdoMens_3;
	}

	/**
	 * This method initializes rdoAnatPat_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnatPat_1() {
		if (rdoAnatPat_1 == null) {
			rdoAnatPat_1 = new JRadioButton();
			rdoAnatPat_1.setBounds(new Rectangle(428, 296, 88, 22));
			rdoAnatPat_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnatPat_1.setText("SIN DATO");
			rdoAnatPat_1.setBackground(new Color(204, 204, 204));
		}
		return rdoAnatPat_1;
	}

	/**
	 * This method initializes rdoAnatPat_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnatPat_2() {
		if (rdoAnatPat_2 == null) {
			rdoAnatPat_2 = new JRadioButton();
			rdoAnatPat_2.setBounds(new Rectangle(428, 316, 66, 22));
			rdoAnatPat_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnatPat_2.setText("H. SIL");
			rdoAnatPat_2.setBackground(new Color(204, 204, 204));
		}
		return rdoAnatPat_2;
	}

	/**
	 * This method initializes rdoAnatPat_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnatPat_3() {
		if (rdoAnatPat_3 == null) {
			rdoAnatPat_3 = new JRadioButton();
			rdoAnatPat_3.setBounds(new Rectangle(428, 336, 65, 22));
			rdoAnatPat_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnatPat_3.setText("L. SIL");
			rdoAnatPat_3.setBackground(new Color(204, 204, 204));
		}
		return rdoAnatPat_3;
	}

	/**
	 * This method initializes rdoCuello_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoCuello_5() {
		if (rdoCuello_5 == null) {
			rdoCuello_5 = new JRadioButton();
			rdoCuello_5.setBounds(new Rectangle(331, 376, 125, 22));
			rdoCuello_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCuello_5.setText("AMPUTACION");
			rdoCuello_5.setBackground(new Color(204, 204, 204));
			rdoCuello_5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtOtroCuello.setEditable(false);
					txtOtroCuello.setText("");
				}
			});
		}
		return rdoCuello_5;
	}

	/**
	 * This method initializes txtOtroCancer	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtroCancer() {
		if (txtOtroCancer == null) {
			txtOtroCancer = new JTextField();
			txtOtroCancer.setBounds(new Rectangle(68, 643, 170, 22));
			txtOtroCancer.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtroCancer.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtroCancer.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtroCancer;
	}

	/**
	 * This method initializes rdoSind_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoSind_1() {
		if (rdoSind_1 == null) {
			rdoSind_1 = new JRadioButton();
			rdoSind_1.setBounds(new Rectangle(665, 186, 50, 22));
			rdoSind_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoSind_1.setText("NO");
			rdoSind_1.setBackground(new Color(204, 204, 204));
		}
		return rdoSind_1;
	}

	/**
	 * This method initializes rdoSind_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoSind_2() {
		if (rdoSind_2 == null) {
			rdoSind_2 = new JRadioButton();
			rdoSind_2.setBounds(new Rectangle(717, 186, 50, 22));
			rdoSind_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoSind_2.setText("SI");
			rdoSind_2.setBackground(new Color(204, 204, 204));
		}
		return rdoSind_2;
	}

	/**
	 * This method initializes rdoLegados_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoLegados_1() {
		if (rdoLegados_1 == null) {
			rdoLegados_1 = new JRadioButton();
			rdoLegados_1.setBounds(new Rectangle(14, 348, 55, 22));
			rdoLegados_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoLegados_1.setText("NO");
			rdoLegados_1.setBackground(new Color(204, 204, 204));
		}
		return rdoLegados_1;
	}

	/**
	 * This method initializes rdoLegados_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoLegados_2() {
		if (rdoLegados_2 == null) {
			rdoLegados_2 = new JRadioButton();
			rdoLegados_2.setBounds(new Rectangle(14, 368, 100, 22));
			rdoLegados_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoLegados_2.setText("EVACUADOR");
			rdoLegados_2.setBackground(new Color(204, 204, 204));
		}
		return rdoLegados_2;
	}

	/**
	 * This method initializes rdoLegados_3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoLegados_3() {
		if (rdoLegados_3 == null) {
			rdoLegados_3 = new JRadioButton();
			rdoLegados_3.setBounds(new Rectangle(14, 388, 89, 22));
			rdoLegados_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoLegados_3.setText("BIOPSICO");
			rdoLegados_3.setBackground(new Color(204, 204, 204));
		}
		return rdoLegados_3;
	}

	/**
	 * This method initializes rdoMenop_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMenop_1() {
		if (rdoMenop_1 == null) {
			rdoMenop_1 = new JRadioButton();
			rdoMenop_1.setBounds(new Rectangle(666, 135, 50, 22));
			rdoMenop_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMenop_1.setText("NO");
			rdoMenop_1.setBackground(new Color(204, 204, 204));
		}
		return rdoMenop_1;
	}

	/**
	 * This method initializes rdoMenop_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMenop_2() {
		if (rdoMenop_2 == null) {
			rdoMenop_2 = new JRadioButton();
			rdoMenop_2.setBounds(new Rectangle(718, 135, 50, 22));
			rdoMenop_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMenop_2.setText("SI");
			rdoMenop_2.setBackground(new Color(204, 204, 204));
		}
		return rdoMenop_2;
	}

	/**
	 * This method initializes rdoInfecA_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoInfecA_1() {
		if (rdoInfecA_1 == null) {
			rdoInfecA_1 = new JRadioButton();
			rdoInfecA_1.setBounds(new Rectangle(854, 135, 43, 22));
			rdoInfecA_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoInfecA_1.setText("NO");
			rdoInfecA_1.setBackground(new Color(204, 204, 204));
		}
		return rdoInfecA_1;
	}

	/**
	 * This method initializes rdoInfecA_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoInfecA_2() {
		if (rdoInfecA_2 == null) {
			rdoInfecA_2 = new JRadioButton();
			rdoInfecA_2.setBounds(new Rectangle(898, 135, 50, 22));
			rdoInfecA_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoInfecA_2.setText("SI");
			rdoInfecA_2.setBackground(new Color(204, 204, 204));
		}
		return rdoInfecA_2;
	}

	/**
	 * This method initializes rdoInfecB_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoInfecB_1() {
		if (rdoInfecB_1 == null) {
			rdoInfecB_1 = new JRadioButton();
			rdoInfecB_1.setBounds(new Rectangle(854, 164, 43, 22));
			rdoInfecB_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoInfecB_1.setText("NO");
			rdoInfecB_1.setBackground(new Color(204, 204, 204));
		}
		return rdoInfecB_1;
	}

	/**
	 * This method initializes rdoInfecB_2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoInfecB_2() {
		if (rdoInfecB_2 == null) {
			rdoInfecB_2 = new JRadioButton();
			rdoInfecB_2.setBounds(new Rectangle(898, 164, 50, 22));
			rdoInfecB_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoInfecB_2.setText("SI");
			rdoInfecB_2.setBackground(new Color(204, 204, 204));
		}
		return rdoInfecB_2;
	}

	/**
	 * This method initializes rdoQuir_1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoQuir_1() {
		if (rdoQuir_1 == null) {
			rdoQuir_1 = new JRadioButton();
			rdoQuir_1.setBounds(new Rectangle(14, 282, 50, 22));
			rdoQuir_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_1.setText("NO");
			rdoQuir_1.setBackground(new Color(204, 204, 204));
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
			rdoQuir_2.setBounds(new Rectangle(64, 282, 42, 22));
			rdoQuir_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoQuir_2.setText("SI");
			rdoQuir_2.setBackground(new Color(204, 204, 204));
		}
		return rdoQuir_2;
	}

	/**
	 * This method initializes txtOtraCirugia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtraCirugia() {
		if (txtOtraCirugia == null) {
			txtOtraCirugia = new JTextField();
			txtOtraCirugia.setBounds(new Rectangle(837, 398, 168, 22));
			txtOtraCirugia.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtraCirugia.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtraCirugia.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtraCirugia;
	}

	/**
	 * This method initializes txtGestas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtGestas() {
		if (txtGestas == null) {
			txtGestas = new JTextField();
			txtGestas.setBounds(new Rectangle(60, 115, 22, 20));
			txtGestas.addKeyListener(new KeyAdapter()
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
				  String s = txtGestas.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtGestas;
	}

	/**
	 * This method initializes txtPartos	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPartos() {
		if (txtPartos == null) {
			txtPartos = new JTextField();
			txtPartos.setBounds(new Rectangle(176, 115, 22, 20));
			txtPartos.addKeyListener(new KeyAdapter()
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
				  String s = txtPartos.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtPartos;
	}

	/**
	 * This method initializes txtCesareas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCesareas() {
		if (txtCesareas == null) {
			txtCesareas = new JTextField();
			txtCesareas.setBounds(new Rectangle(176, 137, 22, 20));
			txtCesareas.addKeyListener(new KeyAdapter()
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
				  String s = txtCesareas.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtCesareas;
	}

	/**
	 * This method initializes txtAbortos	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtAbortos() {
		if (txtAbortos == null) {
			txtAbortos = new JTextField();
			txtAbortos.setBounds(new Rectangle(176, 159, 22, 20));
			txtAbortos.addKeyListener(new KeyAdapter()
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
				  String s = txtAbortos.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtAbortos;
	}

	/**
	 * This method initializes txtEsp	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEsp() {
		if (txtEsp == null) {
			txtEsp = new JTextField();
			txtEsp.setBounds(new Rectangle(253, 159, 22, 20));
			txtEsp.addKeyListener(new KeyAdapter()
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
				  String s = txtEsp.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtEsp;
	}

	/**
	 * This method initializes txtProv	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtProv() {
		if (txtProv == null) {
			txtProv = new JTextField();
			txtProv.setBounds(new Rectangle(275, 159, 22, 20));
			txtProv.addKeyListener(new KeyAdapter()
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
				  String s = txtProv.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtProv;
	}

	/**
	 * This method initializes txtEctopicos	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEctopicos() {
		if (txtEctopicos == null) {
			txtEctopicos = new JTextField();
			txtEctopicos.setBounds(new Rectangle(176, 181, 22, 20));
			txtEctopicos.addKeyListener(new KeyAdapter()
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
				  String s = txtEctopicos.getText();
				  int n=s.length();
				  if(n >= 3){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtEctopicos;
	}

	/**
	 * This method initializes rdoMens_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoMens_4() {
		if (rdoMens_4 == null) {
			rdoMens_4 = new JRadioButton();
			rdoMens_4.setBounds(new Rectangle(496, 196, 138, 22));
			rdoMens_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoMens_4.setText("OLIGOMENORREA");
			rdoMens_4.setBackground(new Color(204, 204, 204));
		}
		return rdoMens_4;
	}
	
	private JPanel getJPanelFUM() {
		if (jPanelFUM == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jPanelFUM = new JPanel();
			jPanelFUM.setLayout(gridLayout);
			jPanelFUM.setBounds(new Rectangle(362, 202, 100, 22));
			jPanelFUM.add(calendarFUM, null);
		}
		return jPanelFUM;
	}

	/**
	 * This method initializes txtAnat_1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtAnat_1() {
		if (txtAnat_1 == null) {
			txtAnat_1 = new JTextField();
			txtAnat_1.setBounds(new Rectangle(185, 368, 25, 22));
			txtAnat_1.setEditable(false);
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

	/**
	 * This method initializes btnCodigos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCodigos() {
		if (btnCodigos == null) {
			btnCodigos = new JButton();
			btnCodigos.setBounds(new Rectangle(215, 368, 80, 22));
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

	/**
	 * This method initializes rdoAnatPat_4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnatPat_4() {
		if (rdoAnatPat_4 == null) {
			rdoAnatPat_4 = new JRadioButton();
			rdoAnatPat_4.setBounds(new Rectangle(519, 296, 81, 22));
			rdoAnatPat_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnatPat_4.setText("INFLAM");
			rdoAnatPat_4.setBackground(new Color(204, 204, 204));
		}
		return rdoAnatPat_4;
	}

	/**
	 * This method initializes rdoAnatPat_5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnatPat_5() {
		if (rdoAnatPat_5 == null) {
			rdoAnatPat_5 = new JRadioButton();
			rdoAnatPat_5.setBounds(new Rectangle(519, 316, 80, 22));
			rdoAnatPat_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnatPat_5.setText("CANCER");
			rdoAnatPat_5.setBackground(new Color(204, 204, 204));
		}
		return rdoAnatPat_5;
	}

	/**
	 * This method initializes rdoAnatPat_6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdoAnatPat_6() {
		if (rdoAnatPat_6 == null) {
			rdoAnatPat_6 = new JRadioButton();
			rdoAnatPat_6.setBounds(new Rectangle(519, 336, 81, 22));
			rdoAnatPat_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoAnatPat_6.setText("NORMAL");
			rdoAnatPat_6.setBackground(new Color(204, 204, 204));
		}
		return rdoAnatPat_6;
	}

	/**
	 * This method initializes chkCirugia_1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_1() {
		if (chkCirugia_1 == null) {
			chkCirugia_1 = new JCheckBox();
			chkCirugia_1.setBounds(new Rectangle(614, 296, 48, 22));
			chkCirugia_1.setText("NO");
			chkCirugia_1.setBackground(new Color(204, 204, 204));
			chkCirugia_1.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chkCirugia_1.isSelected()){
						chkCirugia_2.setEnabled(true);
						chkCirugia_3.setEnabled(true);
						chkCirugia_4.setEnabled(true);
						chkCirugia_5.setEnabled(true);
						chkCirugia_5.setEnabled(true);
						chkCirugia_6.setEnabled(true);
						chkCirugia_7.setEnabled(true);
						chkCirugia_8.setEnabled(true);
						chkCirugia_9.setEnabled(true);
						chkCirugia_10.setEnabled(true);
						chkCirugia_11.setEnabled(true);
						txtOtraCirugia.setEditable(true);
						txtOtraCirugia.setText("");
					}else{
						chkCirugia_2.setEnabled(false);
						chkCirugia_3.setEnabled(false);
						chkCirugia_4.setEnabled(false);
						chkCirugia_5.setEnabled(false);
						chkCirugia_6.setEnabled(false);
						chkCirugia_7.setEnabled(false);
						chkCirugia_8.setEnabled(false);
						chkCirugia_9.setEnabled(false);
						chkCirugia_10.setEnabled(false);
						chkCirugia_11.setEnabled(false);
						chkCirugia_2.setSelected(false);
						chkCirugia_3.setSelected(false);
						chkCirugia_4.setSelected(false);
						chkCirugia_5.setSelected(false);
						chkCirugia_6.setSelected(false);
						chkCirugia_7.setSelected(false);
						chkCirugia_8.setSelected(false);
						chkCirugia_9.setSelected(false);
						chkCirugia_10.setSelected(false);
						chkCirugia_11.setSelected(false);
						txtOtraCirugia.setEditable(false);
						txtOtraCirugia.setText("");
					}
				}
			});
			
		}
		return chkCirugia_1;
	}

	/**
	 * This method initializes chkCirugia_2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_2() {
		if (chkCirugia_2 == null) {
			chkCirugia_2 = new JCheckBox();
			chkCirugia_2.setBounds(new Rectangle(614, 316, 121, 22));
			chkCirugia_2.setText("MIOMECTOMIA");
			chkCirugia_2.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_2;
	}

	/**
	 * This method initializes chkCirugia_3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_3() {
		if (chkCirugia_3 == null) {
			chkCirugia_3 = new JCheckBox();
			chkCirugia_3.setBounds(new Rectangle(614, 336, 128, 22));
			chkCirugia_3.setText("HIST. SUB. TOTAL");
			chkCirugia_3.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_3;
	}

	/**
	 * This method initializes chkCirugia_4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_4() {
		if (chkCirugia_4 == null) {
			chkCirugia_4 = new JCheckBox();
			chkCirugia_4.setBounds(new Rectangle(614, 356, 129, 22));
			chkCirugia_4.setText("HIST. TOTAL");
			chkCirugia_4.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_4;
	}

	/**
	 * This method initializes chkCirugia_5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_5() {
		if (chkCirugia_5 == null) {
			chkCirugia_5 = new JCheckBox();
			chkCirugia_5.setBounds(new Rectangle(614, 376, 131, 22));
			chkCirugia_5.setText("LIG. TUBARIA");
			chkCirugia_5.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_5;
	}

	/**
	 * This method initializes chkCirugia_6	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_6() {
		if (chkCirugia_6 == null) {
			chkCirugia_6 = new JCheckBox();
			chkCirugia_6.setBounds(new Rectangle(614, 396, 173, 22));
			chkCirugia_6.setText("SALPINGET. UNILATERAL");
			chkCirugia_6.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_6;
	}

	/**
	 * This method initializes chkCirugia_7	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_7() {
		if (chkCirugia_7 == null) {
			chkCirugia_7 = new JCheckBox();
			chkCirugia_7.setBounds(new Rectangle(794, 296, 164, 22));
			chkCirugia_7.setText("SALPINGET. BILATERAL");
			chkCirugia_7.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_7;
	}

	/**
	 * This method initializes chkCirugia_8	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_8() {
		if (chkCirugia_8 == null) {
			chkCirugia_8 = new JCheckBox();
			chkCirugia_8.setBounds(new Rectangle(794, 316, 197, 22));
			chkCirugia_8.setText("OOFORECTOMIA UNILATERAL");
			chkCirugia_8.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_8;
	}

	/**
	 * This method initializes chkCirugia_9	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_9() {
		if (chkCirugia_9 == null) {
			chkCirugia_9 = new JCheckBox();
			chkCirugia_9.setBounds(new Rectangle(794, 336, 198, 22));
			chkCirugia_9.setText("OOFORECTOMIA BILATERAL");
			chkCirugia_9.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_9;
	}

	/**
	 * This method initializes chkCirugia_10	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_10() {
		if (chkCirugia_10 == null) {
			chkCirugia_10 = new JCheckBox();
			chkCirugia_10.setBounds(new Rectangle(794, 356, 194, 22));
			chkCirugia_10.setText("QUISECTOMIA");
			chkCirugia_10.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_10;
	}

	/**
	 * This method initializes chkCirugia_11	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkCirugia_11() {
		if (chkCirugia_11 == null) {
			chkCirugia_11 = new JCheckBox();
			chkCirugia_11.setBounds(new Rectangle(794, 376, 195, 22));
			chkCirugia_11.setText("ENDOMETRIOSIS");
			chkCirugia_11.setBackground(new Color(204, 204, 204));
		}
		return chkCirugia_11;
	}

	/**
	 * This method initializes chkPers_1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_1() {
		if (chkPers_1 == null) {
			chkPers_1 = new JCheckBox();
			chkPers_1.setBounds(new Rectangle(16, 478, 22, 22));
			chkPers_1.setText("");
			chkPers_1.setBackground(new Color(204, 204, 204));
			chkPers_1.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chkPers_1.isSelected()){
						chkPers_2.setEnabled(true);
						chkPers_3.setEnabled(true);
						chkPers_4.setEnabled(true);
						chkPers_5.setEnabled(true);
						chkPers_6.setEnabled(true);
						chkPers_7.setEnabled(true);
						chkPers_8.setEnabled(true);
					}else{
						chkPers_2.setEnabled(false);
						chkPers_3.setEnabled(false);
						chkPers_4.setEnabled(false);
						chkPers_5.setEnabled(false);
						chkPers_6.setEnabled(false);
						chkPers_7.setEnabled(false);
						chkPers_8.setEnabled(false);
						chkPers_2.setSelected(false);
						chkPers_3.setSelected(false);
						chkPers_4.setSelected(false);
						chkPers_5.setSelected(false);
						chkPers_6.setSelected(false);
						chkPers_7.setSelected(false);
						chkPers_8.setSelected(false);
					}
				}
			});
		}
		return chkPers_1;
	}

	/**
	 * This method initializes chkPers_2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_2() {
		if (chkPers_2 == null) {
			chkPers_2 = new JCheckBox();
			chkPers_2.setBounds(new Rectangle(16, 498, 22, 22));
			chkPers_2.setText("");
			chkPers_2.setBackground(new Color(204, 204, 204));
		}
		return chkPers_2;
	}

	/**
	 * This method initializes chkPers_3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_3() {
		if (chkPers_3 == null) {
			chkPers_3 = new JCheckBox();
			chkPers_3.setBounds(new Rectangle(16, 518, 22, 22));
			chkPers_3.setText("");
			chkPers_3.setBackground(new Color(204, 204, 204));
		}
		return chkPers_3;
	}

	/**
	 * This method initializes chkPers_4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_4() {
		if (chkPers_4 == null) {
			chkPers_4 = new JCheckBox();
			chkPers_4.setBounds(new Rectangle(16, 538, 22, 22));
			chkPers_4.setText("");
			chkPers_4.setBackground(new Color(204, 204, 204));
		}
		return chkPers_4;
	}

	/**
	 * This method initializes chkPers_5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_5() {
		if (chkPers_5 == null) {
			chkPers_5 = new JCheckBox();
			chkPers_5.setBounds(new Rectangle(16, 558, 22, 22));
			chkPers_5.setText("");
			chkPers_5.setBackground(new Color(204, 204, 204));
		}
		return chkPers_5;
	}

	/**
	 * This method initializes chkPers_6	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_6() {
		if (chkPers_6 == null) {
			chkPers_6 = new JCheckBox();
			chkPers_6.setBounds(new Rectangle(16, 578, 22, 22));
			chkPers_6.setText("");
			chkPers_6.setBackground(new Color(204, 204, 204));
		}
		return chkPers_6;
	}

	/**
	 * This method initializes chkPers_7	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_7() {
		if (chkPers_7 == null) {
			chkPers_7 = new JCheckBox();
			chkPers_7.setBounds(new Rectangle(16, 598, 22, 22));
			chkPers_7.setText("");
			chkPers_7.setBackground(new Color(204, 204, 204));
		}
		return chkPers_7;
	}

	/**
	 * This method initializes chkFam_1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_1() {
		if (chkFam_1 == null) {
			chkFam_1 = new JCheckBox();
			chkFam_1.setBounds(new Rectangle(45, 478, 50, 22));
			chkFam_1.setText("NO");
			chkFam_1.setBackground(new Color(204, 204, 204));
			chkFam_1.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chkFam_1.isSelected()){
						chkFam_2.setEnabled(true);
						chkFam_3.setEnabled(true);
						chkFam_4.setEnabled(true);
						chkFam_5.setEnabled(true);
						chkFam_6.setEnabled(true);
						chkFam_7.setEnabled(true);
						chkFam_8.setEnabled(true);
					}else{
						chkFam_2.setEnabled(false);
						chkFam_3.setEnabled(false);
						chkFam_4.setEnabled(false);
						chkFam_5.setEnabled(false);
						chkFam_6.setEnabled(false);
						chkFam_7.setEnabled(false);
						chkFam_8.setEnabled(false);
						chkFam_2.setSelected(false);
						chkFam_3.setSelected(false);
						chkFam_4.setSelected(false);
						chkFam_5.setSelected(false);
						chkFam_6.setSelected(false);
						chkFam_7.setSelected(false);
						chkFam_8.setSelected(false);
					}
				}
			});
		}
		return chkFam_1;
	}

	/**
	 * This method initializes chkFam_2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_2() {
		if (chkFam_2 == null) {
			chkFam_2 = new JCheckBox();
			chkFam_2.setBounds(new Rectangle(45, 498, 111, 22));
			chkFam_2.setText("ENDOMETRIO");
			chkFam_2.setBackground(new Color(204, 204, 204));
		}
		return chkFam_2;
	}

	/**
	 * This method initializes chkFam_3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_3() {
		if (chkFam_3 == null) {
			chkFam_3 = new JCheckBox();
			chkFam_3.setBounds(new Rectangle(45, 518, 82, 22));
			chkFam_3.setText("CUELLO");
			chkFam_3.setBackground(new Color(204, 204, 204));
		}
		return chkFam_3;
	}

	/**
	 * This method initializes chkFam_4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_4() {
		if (chkFam_4 == null) {
			chkFam_4 = new JCheckBox();
			chkFam_4.setBounds(new Rectangle(45, 538, 71, 22));
			chkFam_4.setText("UTERO");
			chkFam_4.setBackground(new Color(204, 204, 204));
		}
		return chkFam_4;
	}

	/**
	 * This method initializes chkFam_5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_5() {
		if (chkFam_5 == null) {
			chkFam_5 = new JCheckBox();
			chkFam_5.setBounds(new Rectangle(45, 558, 67, 22));
			chkFam_5.setText("MAMA");
			chkFam_5.setBackground(new Color(204, 204, 204));
		}
		return chkFam_5;
	}

	/**
	 * This method initializes chkFam_6	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_6() {
		if (chkFam_6 == null) {
			chkFam_6 = new JCheckBox();
			chkFam_6.setBounds(new Rectangle(45, 578, 76, 22));
			chkFam_6.setText("OVARIO");
			chkFam_6.setBackground(new Color(204, 204, 204));
		}
		return chkFam_6;
	}

	/**
	 * This method initializes chkFam_7	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_7() {
		if (chkFam_7 == null) {
			chkFam_7 = new JCheckBox();
			chkFam_7.setBounds(new Rectangle(45, 598, 146, 22));
			chkFam_7.setText("Otros Ginecológicos");
			chkFam_7.setBackground(new Color(204, 204, 204));
		}
		return chkFam_7;
	}

	/**
	 * This method initializes chkPers_8	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPers_8() {
		if (chkPers_8 == null) {
			chkPers_8 = new JCheckBox();
			chkPers_8.setBounds(new Rectangle(16, 618, 22, 22));
			chkPers_8.setText("");
			chkPers_8.setBackground(new Color(204, 204, 204));
		}
		return chkPers_8;
	}

	/**
	 * This method initializes chkFam_8	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFam_8() {
		if (chkFam_8 == null) {
			chkFam_8 = new JCheckBox();
			chkFam_8.setBounds(new Rectangle(45, 618, 151, 22));
			chkFam_8.setText("DIGESTIVOS");
			chkFam_8.setBackground(new Color(204, 204, 204));
		}
		return chkFam_8;
	}

	/**
	 * This method initializes chkPersonales_1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPersonales_1() {
		if (chkPersonales_1 == null) {
			chkPersonales_1 = new JCheckBox();
			chkPersonales_1.setBounds(new Rectangle(350, 465, 53, 22));
			chkPersonales_1.setText("NO");
			chkPersonales_1.setBackground(new Color(204, 204, 204));
			chkPersonales_1.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (chkPersonales_1.isSelected()){
						chkPersonales_2.setEnabled(true);
						chkPersonales_3.setEnabled(true);
						chkPersonales_4.setEnabled(true);
						chkPersonales_5.setEnabled(true);
						txtOtrosPers.setEditable(true);
						txtOtrosPers.setText("");
					}else{
						chkPersonales_2.setEnabled(false);
						chkPersonales_3.setEnabled(false);
						chkPersonales_4.setEnabled(false);
						chkPersonales_5.setEnabled(false);
						chkPersonales_2.setSelected(false);
						chkPersonales_3.setSelected(false);
						chkPersonales_4.setSelected(false);
						chkPersonales_5.setSelected(false);
						txtOtrosPers.setEditable(false);
						txtOtrosPers.setText("");
					}
				}
			});
		}
		return chkPersonales_1;
	}

	/**
	 * This method initializes chkPersonales_2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPersonales_2() {
		if (chkPersonales_2 == null) {
			chkPersonales_2 = new JCheckBox();
			chkPersonales_2.setBounds(new Rectangle(350, 485, 135, 22));
			chkPersonales_2.setText("ENDOCRINOPATIA");
			chkPersonales_2.setBackground(new Color(204, 204, 204));
		}
		return chkPersonales_2;
	}

	/**
	 * This method initializes chkPersonales_3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPersonales_3() {
		if (chkPersonales_3 == null) {
			chkPersonales_3 = new JCheckBox();
			chkPersonales_3.setBounds(new Rectangle(350, 505, 83, 22));
			chkPersonales_3.setText("H.T.A.");
			chkPersonales_3.setBackground(new Color(204, 204, 204));
		}
		return chkPersonales_3;
	}

	/**
	 * This method initializes chkPersonales_4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPersonales_4() {
		if (chkPersonales_4 == null) {
			chkPersonales_4 = new JCheckBox();
			chkPersonales_4.setBounds(new Rectangle(350, 525, 85, 22));
			chkPersonales_4.setText("DIABETES");
			chkPersonales_4.setBackground(new Color(204, 204, 204));
		}
		return chkPersonales_4;
	}

	/**
	 * This method initializes chkPersonales_5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPersonales_5() {
		if (chkPersonales_5 == null) {
			chkPersonales_5 = new JCheckBox();
			chkPersonales_5.setBounds(new Rectangle(350, 545, 89, 22));
			chkPersonales_5.setText("OBESIDAD");
			chkPersonales_5.setBackground(new Color(204, 204, 204));
		}
		return chkPersonales_5;
	}
}