package grafica.vistas;

import grafica.controladores.CdorIndHist;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrmIndHist extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen panelFondo = null;
	private JButton btGuardar = null;
	private JButton btCancelar = null;
	private CdorIndHist cdor;
	private JLabel lbl_1 = null;
	private JLabel lbl_2 = null;
	private JTextField txt_1 = null;
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
	private JLabel lbl_0 = null;
	public FrmIndHist(CdorIndHist cdor) {
		super();
		this.cdor = cdor;
		initialize();
	}

	private void initialize() {
		this.setSize(new java.awt.Dimension(433,461));
		this.setLocation(520,120);
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
			lbl_0 = new JLabel();
			lbl_0.setBounds(new Rectangle(21, 79, 129, 22));
			lbl_0.setText("0. SE DESCONOCE");
			lbl_0.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_23 = new JLabel();
			lbl_23.setBounds(new Rectangle(241, 303, 71, 22));
			lbl_23.setText("23. OTRA");
			lbl_23.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_22 = new JLabel();
			lbl_22.setBounds(new Rectangle(241, 283, 115, 22));
			lbl_22.setText("22. CA. CERVICAL");
			lbl_22.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_21 = new JLabel();
			lbl_21.setBounds(new Rectangle(241, 263, 146, 22));
			lbl_21.setText("21. POLIPO CERVICAL");
			lbl_21.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_20 = new JLabel();
			lbl_20.setBounds(new Rectangle(241, 243, 73, 22));
			lbl_20.setText("20. MOLA");
			lbl_20.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_19 = new JLabel();
			lbl_19.setBounds(new Rectangle(241, 223, 154, 22));
			lbl_19.setText("19. RESTOS OVULARES");
			lbl_19.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_18 = new JLabel();
			lbl_18.setBounds(new Rectangle(241, 203, 149, 22));
			lbl_18.setText("18. MIOMATOSIS");
			lbl_18.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_17 = new JLabel();
			lbl_17.setBounds(new Rectangle(241, 183, 151, 20));
			lbl_17.setText("17. DISMENORREA");
			lbl_17.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_16 = new JLabel();
			lbl_16.setBounds(new Rectangle(241, 163, 146, 22));
			lbl_16.setText("16. MALFORMACIONES");
			lbl_16.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_15 = new JLabel();
			lbl_15.setBounds(new Rectangle(241, 143, 149, 22));
			lbl_15.setText("15. TAMOXIFENO");
			lbl_15.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_14 = new JLabel();
			lbl_14.setBounds(new Rectangle(241, 123, 142, 22));
			lbl_14.setText("14. CONTROL THR");
			lbl_14.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_13 = new JLabel();
			lbl_13.setBounds(new Rectangle(15, 343, 85, 22));
			lbl_13.setText("13. PRE THR");
			lbl_13.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_12 = new JLabel();
			lbl_12.setBounds(new Rectangle(15, 323, 144, 22));
			lbl_12.setText("12. PREOPERATORIA");
			lbl_12.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_11 = new JLabel();
			lbl_11.setBounds(new Rectangle(15, 303, 121, 22));
			lbl_11.setText("11. HIPERPLASIA");
			lbl_11.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_10 = new JLabel();
			lbl_10.setBounds(new Rectangle(15, 283, 171, 22));
			lbl_10.setText("10. IMAGEN ECOGRAFICA");
			lbl_10.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_9 = new JLabel();
			lbl_9.setBounds(new Rectangle(21, 263, 187, 22));
			lbl_9.setText("9. ENDOMETRIO ENGROSADO");
			lbl_9.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_8 = new JLabel();
			lbl_8.setBounds(new Rectangle(21, 243, 153, 22));
			lbl_8.setText("8. POLIPO ENDOMETRIO");
			lbl_8.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_7 = new JLabel();
			lbl_7.setBounds(new Rectangle(21, 223, 122, 22));
			lbl_7.setText("7. D.I.U. PERDIDO");
			lbl_7.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_6 = new JLabel();
			lbl_6.setBounds(new Rectangle(21, 203, 116, 22));
			lbl_6.setText("6. ESTERILIDAD");
			lbl_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_5 = new JLabel();
			lbl_5.setBounds(new Rectangle(21, 183, 99, 22));
			lbl_5.setText("5. AMENORREA");
			lbl_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_4 = new JLabel();
			lbl_4.setBounds(new Rectangle(21, 163, 135, 22));
			lbl_4.setText("4. OTROS SANGRADOS");
			lbl_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_3 = new JLabel();
			lbl_3.setBounds(new Rectangle(21, 143, 176, 22));
			lbl_3.setText("3. MET. POSTMENOPAUSIA");
			lbl_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_2 = new JLabel();
			lbl_2.setBounds(new Rectangle(21, 123, 190, 22));
			lbl_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_2.setText("2. MET. PARAMENOPAUSIA");
			lbl_1 = new JLabel();
			lbl_1.setBounds(new Rectangle(21, 103, 190, 22));
			lbl_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbl_1.setText("1. METORRAGIA EDAD FERTIL");
			panelFondo = new PanelConImagen("./src/imagenes/fondoIndicacionesHist.jpg");
			panelFondo.setLayout(null);
			panelFondo.setBackground(new java.awt.Color(80,80,80));
			panelFondo.add(getbtGuardar(), null);
			panelFondo.add(getbtCancelar(), null);
			panelFondo.add(lbl_1, null);
			panelFondo.add(lbl_2, null);
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
			panelFondo.add(lbl_0, null);
			panelFondo.add(getbtGuardar(), null);
		}
		return panelFondo;
	}

	private JButton getbtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setBounds(new Rectangle(375, 383, 40, 40));
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
			btCancelar.setBounds(new Rectangle(325, 383, 40, 40));
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

	private JTextField getTxtOtra() {
		if (txt_1 == null) {
			txt_1 = new JTextField();
			txt_1.setBounds(new Rectangle(257, 82, 30, 22));
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
			txt_2.setBounds(new Rectangle(297, 82, 30, 22));
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
			txt_3.setBounds(new Rectangle(337, 82, 30, 22));
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
			txtOtros_1.setBounds(new Rectangle(260, 325, 154, 22));
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
}