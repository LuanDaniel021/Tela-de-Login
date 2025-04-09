package app;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import configs.Frames;
import configs.MouseModify;
import database.DataBase;
import enums.Status;
import fields.MPasswordField;
import fields.MTextField;
import login.Panel_L;
import login.Panel_R;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
    private static final DataBase DB = new DataBase();
    
    private MTextField txtUsuario;
	private MPasswordField txtSenha;
	private JButton btnEntrar;
	private MouseModify mouseAdapter;
	
	public Login() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setSize(Frames.LOGIN.getWidth(),Frames.LOGIN.getHeight());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		{ // INICIA
			mouseAdapter = new MouseModify(this);
			txtUsuario = new MTextField("Nome de Usuário", new Font("Arial",1,18));
			txtSenha = new MPasswordField("Senha",new Font("Arial",1,18));
			btnEntrar = new JButton("Entrar");
		}
		
		{ // ESQUERDA
			
			Panel_L panel_L = new Panel_L();
			panel_L.addMouseListener(mouseAdapter);
			getContentPane().add(panel_L);
			
		}
		
		{ // DIREITA
			
			Panel_R panel_R = new Panel_R(txtUsuario,txtSenha,btnEntrar);
			panel_R.addMouseListener(mouseAdapter);
			
			{ // Configura Botão
				
				btnEntrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						resultdoLogin(DB.tryLogin(txtUsuario.getText(), new String(txtSenha.getPassword())));
					}
		
					private void resultdoLogin(boolean loginResultado) {
						
						if (loginResultado) {
							
							txtUsuario.setStatus(Status.CONFIRM);
							txtSenha.setStatus(Status.CONFIRM);
							
							JOptionPane.showMessageDialog(
								null,
								"Usuário Conectado", 
								"Login Concluido",
								JOptionPane.INFORMATION_MESSAGE
							);
							
						} else {
							
							txtUsuario.setStatus(Status.ERROR);
							txtSenha.setStatus(Status.ERROR);
							
							JOptionPane.showMessageDialog(
								null,
								"Senha ou nome incorretos", 
								"Falha no Login",
								JOptionPane.ERROR_MESSAGE
							);
						}
						
					}
					
				});
			}
			
			getContentPane().add(panel_R);

		}
		
		setFocusable(true);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {new Login();}
	
}
