package grafica.vistas;

import grafica.controladores.CdorCodAnatomia;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrmCodAnatomia extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private CdorCodAnatomia cdor;
	private JLabel lbl_1 = null;
	private JLabel lbl_2 = null;
	private JLabel lbl_3 = null;
	private JLabel lbl_4 = null;
	private JLabel lbl_5 = null;
	private JLabel lbl_6 = null;
	private JLabel lbl_7 = null;
	private JLabel lbl_8 = null;
	private JLabel lbl_9 = null;
	private JLabel lbl_10 = null;
	private JLabel lbl_11 = null;
	private JLabel lbl_12 = null;
	private JLabel lbl_13 = null;
	private JLabel lbl_14 = null;
	private JLabel lbl_15 = null;
	private JLabel lbl_16 = null;
	private JLabel lbl_17 = null;
	private JLabel lbl_18 = null;
	private JLabel lbl_19 = null;
	private JLabel lbl_20 = null;
	private JLabel lbl_21 = null;
	private JLabel lbl_22 = null;
	private JLabel lbl_23 = null;
	private JLabel lbl_24 = null;
	
	public FrmCodAnatomia(CdorCodAnatomia cdor) {
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(433,400));
		this.setLocation(770,270);
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
			lbl_24 = new JLabel();
			lbl_24.setBounds(new Rectangle(241, 283, 140, 22));
			lbl_24.setText("24. SIN DATOS");
			lbl_24.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_23 = new JLabel();
			lbl_23.setBounds(new Rectangle(241, 263, 71, 20));
			lbl_23.setText("23. OTROS");
			lbl_23.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_22 = new JLabel();
			lbl_22.setBounds(new Rectangle(241, 243, 83, 21));
			lbl_22.setText("22. NORMAL");
			lbl_22.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_21 = new JLabel();
			lbl_21.setBounds(new Rectangle(241, 223, 146, 24));
			lbl_21.setText("21. MAT INSUFICIENTE");
			lbl_21.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_20 = new JLabel();
			lbl_20.setBounds(new Rectangle(241, 203, 143, 23));
			lbl_20.setText("20. CA. EPIDERMOIDE");
			lbl_20.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_19 = new JLabel();
			lbl_19.setBounds(new Rectangle(241, 183, 154, 20));
			lbl_19.setText("19. POLIPO ENDOCER.");
			lbl_19.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_18 = new JLabel();
			lbl_18.setBounds(new Rectangle(241, 163, 149, 19));
			lbl_18.setText("18. RESTOS OVULARES");
			lbl_18.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_17 = new JLabel();
			lbl_17.setBounds(new Rectangle(241, 143, 151, 20));
			lbl_17.setText("17. ENF. TROFOBLAST");
			lbl_17.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_16 = new JLabel();
			lbl_16.setBounds(new Rectangle(241, 123, 146, 23));
			lbl_16.setText("16. OTROS CANCERES");
			lbl_16.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_15 = new JLabel();
			lbl_15.setBounds(new Rectangle(241, 103, 149, 21));
			lbl_15.setText("15. SARCOMA");
			lbl_15.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_14 = new JLabel();
			lbl_14.setBounds(new Rectangle(241, 83, 142, 21));
			lbl_14.setText("14. ADENOESCAMOSO");
			lbl_14.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_13 = new JLabel();
			lbl_13.setBounds(new Rectangle(15, 323, 185, 22));
			lbl_13.setText("13. ADENOACANTOMA");
			lbl_13.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_12 = new JLabel();
			lbl_12.setBounds(new Rectangle(15, 303, 177, 22));
			lbl_12.setText("12. ADENOCARCINOMA");
			lbl_12.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_11 = new JLabel();
			lbl_11.setBounds(new Rectangle(15, 283, 196, 22));
			lbl_11.setText("11. HIPERPL. COMPLEJO C/ATIP.");
			lbl_11.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_10 = new JLabel();
			lbl_10.setBounds(new Rectangle(15, 263, 171, 22));
			lbl_10.setText("10. HIPERPL. COMPLEJO");
			lbl_10.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_9 = new JLabel();
			lbl_9.setBounds(new Rectangle(21, 243, 164, 22));
			lbl_9.setText("9. HIPERPL. SIMPLE C/ATIP.");
			lbl_9.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_8 = new JLabel();
			lbl_8.setBounds(new Rectangle(21, 223, 122, 22));
			lbl_8.setText("8. HIPERPL. SIMPLE");
			lbl_8.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_7 = new JLabel();
			lbl_7.setBounds(new Rectangle(21, 203, 122, 22));
			lbl_7.setText("7. POLIPO ENDOM.");
			lbl_7.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_6 = new JLabel();
			lbl_6.setBounds(new Rectangle(21, 183, 116, 22));
			lbl_6.setText("6. INFLAMATORIO");
			lbl_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_5 = new JLabel();
			lbl_5.setBounds(new Rectangle(21, 163, 71, 22));
			lbl_5.setText("5. MIXTO");
			lbl_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_4 = new JLabel();
			lbl_4.setBounds(new Rectangle(21, 143, 118, 22));
			lbl_4.setText("4. DISINCRONICO");
			lbl_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_3 = new JLabel();
			lbl_3.setBounds(new Rectangle(21, 123, 82, 22));
			lbl_3.setText("3. ATROFICO");
			lbl_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_2 = new JLabel();
			lbl_2.setBounds(new Rectangle(21, 103, 80, 22));
			lbl_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_2.setText("2. SECRETOR");
			lbl_1 = new JLabel();
			lbl_1.setBounds(new Rectangle(21, 83, 120, 22));
			lbl_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_1.setText("1. PROLIFERATIVO");
			panelFondo = new PanelConImagen("./src/imagenes/fondoCodAnatomia.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(lbl_1, null);
			panelFondo.add(lbl_2, null);
			panelFondo.add(lbl_3, null);
			panelFondo.add(lbl_4, null);
			panelFondo.add(lbl_5, null);
			panelFondo.add(lbl_6, null);
			panelFondo.add(lbl_7, null);
			panelFondo.add(lbl_8, null);
			panelFondo.add(lbl_9, null);
			panelFondo.add(lbl_10, null);
			panelFondo.add(lbl_11, null);
			panelFondo.add(lbl_12, null);
			panelFondo.add(lbl_13, null);
			panelFondo.add(lbl_14, null);
			panelFondo.add(lbl_15, null);
			panelFondo.add(lbl_16, null);
			panelFondo.add(lbl_17, null);
			panelFondo.add(lbl_18, null);
			panelFondo.add(lbl_19, null);
			panelFondo.add(lbl_20, null);
			panelFondo.add(lbl_21, null);
			panelFondo.add(lbl_22, null);
			panelFondo.add(lbl_23, null);
			panelFondo.add(lbl_24, null);
		}
		return panelFondo;
	}
}