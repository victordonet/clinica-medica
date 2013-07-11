package grafica.vistas;

import grafica.controladores.CdorAnatomia;
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

public class FrmAnatomia extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorAnatomia cdor;
	private JLabel lbl_1 = null;
	private JLabel lbl_2 = null;
	private JRadioButton rdoCorr_1 = null;
	private JRadioButton rdoCorr_2 = null;
	private JTextField txt_1 = null;
	private ButtonGroup grpCorrelacion = new ButtonGroup();  //  @jve:decl-index=0:
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
	private JTextField txt_2 = null;
	private JTextField txt_3 = null;
	private JLabel lbl_14 = null;
	private JLabel lbl_15 = null;
	private JLabel lbl_16 = null;
	private JTextField txtOtros_1 = null;
	private JLabel lbl_17 = null;
	private JLabel lbl_18 = null;
	private JLabel lbl_19 = null;
	private JLabel lbl_20 = null;
	private JLabel lbl_21 = null;
	private JLabel lbl_22 = null;
	private JLabel lbl_23 = null;
	private JLabel lbl_24 = null;
	private JTextField txtOtros_2 = null;
	
	public FrmAnatomia(CdorAnatomia cdor) {
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
			lbl_24 = new JLabel();
			lbl_24.setBounds(new Rectangle(241, 339, 92, 22));
			lbl_24.setText("24. SIN DATOS");
			lbl_24.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_23 = new JLabel();
			lbl_23.setBounds(new Rectangle(241, 319, 71, 22));
			lbl_23.setText("23. OTROS");
			lbl_23.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_22 = new JLabel();
			lbl_22.setBounds(new Rectangle(241, 299, 80, 22));
			lbl_22.setText("22. NORMAL");
			lbl_22.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_21 = new JLabel();
			lbl_21.setBounds(new Rectangle(241, 279, 146, 22));
			lbl_21.setText("21. MAT INSUFICIENTE");
			lbl_21.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_20 = new JLabel();
			lbl_20.setBounds(new Rectangle(241, 259, 143, 22));
			lbl_20.setText("20. CA. EPIDERMOIDE");
			lbl_20.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_19 = new JLabel();
			lbl_19.setBounds(new Rectangle(241, 239, 154, 22));
			lbl_19.setText("19. POLIPO ENDOCER.");
			lbl_19.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_18 = new JLabel();
			lbl_18.setBounds(new Rectangle(241, 219, 149, 22));
			lbl_18.setText("18. RESTOS OVULARES");
			lbl_18.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_17 = new JLabel();
			lbl_17.setBounds(new Rectangle(241, 199, 151, 22));
			lbl_17.setText("17. ENF. TROFOBLAST");
			lbl_17.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_16 = new JLabel();
			lbl_16.setBounds(new Rectangle(241, 179, 136, 22));
			lbl_16.setText("16. OTROS CANCERES");
			lbl_16.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_15 = new JLabel();
			lbl_15.setBounds(new Rectangle(241, 159, 149, 22));
			lbl_15.setText("15. SARCOMA");
			lbl_15.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_14 = new JLabel();
			lbl_14.setBounds(new Rectangle(241, 139, 142, 21));
			lbl_14.setText("14. ADENOESCAMOSO");
			lbl_14.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_13 = new JLabel();
			lbl_13.setBounds(new Rectangle(15, 339, 185, 22));
			lbl_13.setText("13. ADENOACANTOMA");
			lbl_13.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_12 = new JLabel();
			lbl_12.setBounds(new Rectangle(15, 319, 177, 22));
			lbl_12.setText("12. ADENOCARCINOMA");
			lbl_12.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_11 = new JLabel();
			lbl_11.setBounds(new Rectangle(15, 299, 196, 22));
			lbl_11.setText("11. HIPERPL. COMPLEJO C/ATIP.");
			lbl_11.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_10 = new JLabel();
			lbl_10.setBounds(new Rectangle(15, 279, 171, 22));
			lbl_10.setText("10. HIPERPL. COMPLEJO");
			lbl_10.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_9 = new JLabel();
			lbl_9.setBounds(new Rectangle(21, 259, 164, 22));
			lbl_9.setText("9. HIPERPL. SIMPLE C/ATIP.");
			lbl_9.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_8 = new JLabel();
			lbl_8.setBounds(new Rectangle(21, 239, 122, 22));
			lbl_8.setText("8. HIPERPL. SIMPLE");
			lbl_8.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_7 = new JLabel();
			lbl_7.setBounds(new Rectangle(21, 219, 122, 22));
			lbl_7.setText("7. POLIPO ENDOM.");
			lbl_7.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_6 = new JLabel();
			lbl_6.setBounds(new Rectangle(21, 199, 116, 22));
			lbl_6.setText("6. INFLAMATORIO");
			lbl_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_5 = new JLabel();
			lbl_5.setBounds(new Rectangle(21, 179, 71, 22));
			lbl_5.setText("5. MIXTO");
			lbl_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_4 = new JLabel();
			lbl_4.setBounds(new Rectangle(21, 159, 118, 22));
			lbl_4.setText("4. DISINCRONICO");
			lbl_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_3 = new JLabel();
			lbl_3.setBounds(new Rectangle(21, 139, 82, 22));
			lbl_3.setText("3. ATROFICO");
			lbl_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_2 = new JLabel();
			lbl_2.setBounds(new Rectangle(21, 119, 80, 22));
			lbl_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_2.setText("2. SECRETOR");
			lbl_1 = new JLabel();
			lbl_1.setBounds(new Rectangle(21, 99, 120, 22));
			lbl_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_1.setText("1. PROLIFERATIVO");
			panelFondo = new PanelConImagen("./src/imagenes/fondoAnatomiaPat.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(lbl_1, null);
			panelFondo.add(lbl_2, null);
			panelFondo.add(getRdoCorr_1(), null);
			panelFondo.add(getRdoCorr_2(), null);
			panelFondo.add(getTxtOtra(), null);
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
			panelFondo.add(getTxt_2(), null);
			panelFondo.add(getTxt_3(), null);
			panelFondo.add(lbl_14, null);
			panelFondo.add(lbl_15, null);
			panelFondo.add(lbl_16, null);
			panelFondo.add(getTxtOtros_1(), null);
			panelFondo.add(lbl_17, null);
			panelFondo.add(lbl_18, null);
			panelFondo.add(lbl_19, null);
			panelFondo.add(lbl_20, null);
			panelFondo.add(lbl_21, null);
			panelFondo.add(lbl_22, null);
			panelFondo.add(lbl_23, null);
			panelFondo.add(lbl_24, null);
			panelFondo.add(getTxtOtros_2(), null);
			panelFondo.add(getbtGuardar(), null);
			grpCorrelacion.add(rdoCorr_1);
			grpCorrelacion.add(rdoCorr_2);
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

	private JRadioButton getRdoCorr_1() {
		if (rdoCorr_1 == null) {
			rdoCorr_1 = new JRadioButton();
			rdoCorr_1.setBounds(new Rectangle(17, 418, 50, 22));
			rdoCorr_1.setText("NO");
			rdoCorr_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCorr_1.setBackground(new java.awt.Color(204,204,204));
		}
		return rdoCorr_1;
	}

	private JRadioButton getRdoCorr_2() {
		if (rdoCorr_2 == null) {
			rdoCorr_2 = new JRadioButton();
			rdoCorr_2.setBounds(new Rectangle(69, 418, 50, 22));
			rdoCorr_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdoCorr_2.setText("SI");
			rdoCorr_2.setBackground(new Color(204, 204, 204));
		}
		return rdoCorr_2;
	}

	private JTextField getTxtOtra() {
		if (txt_1 == null) {
			txt_1 = new JTextField();
			txt_1.setBounds(new Rectangle(257, 98, 30, 22));
			txt_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			txt_1.addKeyListener(new KeyAdapter()
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
					  String s = txt_1.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txt_1;
	}

	/**
	 * This method initializes txt_2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_2() {
		if (txt_2 == null) {
			txt_2 = new JTextField();
			txt_2.setBounds(new Rectangle(297, 98, 30, 22));
			txt_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			txt_2.addKeyListener(new KeyAdapter()
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
					  String s = txt_2.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txt_2;
	}

	/**
	 * This method initializes txt_3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_3() {
		if (txt_3 == null) {
			txt_3 = new JTextField();
			txt_3.setBounds(new Rectangle(337, 98, 30, 22));
			txt_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			txt_3.addKeyListener(new KeyAdapter()
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
					  String s = txt_3.getText();
					  int n=s.length();
					  if(n >= 2){
						  e.consume(); // ignorar el evento de teclado
					  }
				   }
				});
			}
		return txt_3;
	}

	/**
	 * This method initializes txtOtros_1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtros_1() {
		if (txtOtros_1 == null) {
			txtOtros_1 = new JTextField();
			txtOtros_1.setBounds(new Rectangle(377, 179, 299, 21));
			txtOtros_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtros_1.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtros_1.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtros_1;
	}

	/**
	 * This method initializes txtOtros_2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOtros_2() {
		if (txtOtros_2 == null) {
			txtOtros_2 = new JTextField();
			txtOtros_2.setBounds(new Rectangle(320, 319, 356, 22));
			txtOtros_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtOtros_2.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {

				  //Controlar el largo del text
				  String s = txtOtros_2.getText();
				  int n=s.length();
				  if(n >= 30){
					  e.consume(); // ignorar el evento de teclado
				  }
			   }
			});
		}
		return txtOtros_2;
	}
}