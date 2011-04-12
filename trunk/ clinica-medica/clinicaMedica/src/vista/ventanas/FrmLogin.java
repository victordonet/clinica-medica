package vista.ventanas;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vista.PanelConImagen;

public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelConImagen jPanel1 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JButton jButton1 = null;
	private JPasswordField jPassField1 = null;
	private JTextField jTextField1 = null;
	
	
	
	public FrmLogin() {
		super();
		initialize();
	
	}
	
	
	private void initialize() {
		this.setSize(new java.awt.Dimension(538,373));
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./fondos/miniLogo.gif"));
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	protected void frmDisable(){
		this.setEnabled(false);
	}

	protected void frmEnable(){
		this.setEnabled(true);
		this.setVisible(true);
	}
	
	
	private PanelConImagen getJContentPane() {
		if (jPanel1 == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(207,150,92,21));
			jLabel2.setForeground(java.awt.Color.black);
			jLabel2.setText("Contraseña");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(207,120,92,20));
			jLabel1.setForeground(java.awt.Color.black);
			jLabel1.setText("Usuario");
			jPanel1 = new PanelConImagen("./fondos/imgLogin.jpg");
			jPanel1.setLayout(null);
			jPanel1.setBackground(new java.awt.Color(80,80,80));
			jPanel1.setPreferredSize(new java.awt.Dimension(448,310));
			jPanel1.add(jLabel1, null);
			jPanel1.add(jLabel2, null);
			jPanel1.add(getJButton1(), null);
			jPanel1.add(getJPassField1(), null);
			jPanel1.add(getJTextField1(), null);
		}
		return jPanel1;
	}
	
	
	private JPasswordField getJPassField1() {
		if (jPassField1 == null) {
			jPassField1 = new JPasswordField();
			jPassField1.setBounds(new java.awt.Rectangle(309,151,90,21));
			jPassField1.addKeyListener(new KeyAdapter()
					{
					   public void keyTyped(KeyEvent e)
					   {
					      char caracter = e.getKeyChar();
					      // Verificar si la tecla pulsada no es un digito
					      if(caracter == KeyEvent.VK_ENTER)
					      {
								/*System.out.println("Inicio de cesión");
								Usuario usu = new Usuario(jTextField1.getText(),jPassField1.getText(),"");
								boolean ok = EntradaNegocio.getInst().usuarioCorrecto(usu);
								if ( ok == false){
									new FrmVentanaException(FrmLogin.this,"Usuario o Clave incorrecta, vuelva a intentarlo...");
									frmDisable();
								}else{
									dispose();
									new FrmMenu(usu);
								}*/
					      }
					   }
					});
				}
				return jPassField1;
	}
	
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new java.awt.Rectangle(309,121,89,21));
		}
		return jTextField1;
	}	
	
	
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new java.awt.Rectangle(400,151,43,20));
			jButton1.setBackground(new java.awt.Color(118,144,201));
			jButton1.setText(">");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Inicio de cesión");
					/*Usuario usu = new Usuario(jTextField1.getText(),jPassField1.getText(),"");
					boolean ok = EntradaNegocio.getInst().usuarioCorrecto(usu);
					if ( ok == false){
						new FrmVentanaException(FrmLogin.this,"Usuario o Clave incorrecta, vuelva a intentarlo...");
						frmDisable();
					}else{
						dispose();
						new FrmMenu(usu);
					}*/
				}
			});
		}
		return jButton1;
	}
}

