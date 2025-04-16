package app;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import MComponentes.enums.StatusFields;
import configs.Frames;
import configs.MessageDialog;
import configs.MouseModify;
import database.DataBase;
import fields.MPasswordField;
import fields.MTextField;
import login.Panel_L;
import login.Panel_R;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
    private final DataBase DB;
    private final MTextField txtUsuario;
	private final MPasswordField txtSenha;
	private final JButton btnEntrar;
	private final MouseModify mouseAdapter;
	
	public Login() {
		
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		{ // INICIA
			DB = new DataBase();
			txtUsuario = new MTextField("Nome de Usuário", new Font("Arial",1,18));
			txtSenha = new MPasswordField("Senha",new Font("Arial",1,18));
			btnEntrar = new JButton("Entrar");
			mouseAdapter = new MouseModify(this);
		}
		
		{ // ESQUERDA
			
			Panel_L panel_L = new Panel_L();
			panel_L.addMouseListener(mouseAdapter);
			getContentPane().add(panel_L);
			
		}
		
		{ // DIREITA
			
			Panel_R panel_R = new Panel_R(txtUsuario,txtSenha,btnEntrar);
			panel_R.addMouseListener(mouseAdapter);
			
			{ // Configura Botão "btnEntrar"
				
				btnEntrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						resultdoLogin(DB.tryLogin(txtUsuario.getText(), new String(txtSenha.getPassword())));
					}
		
					private void resultdoLogin(boolean loginResultado) {
						StatusFields status = StatusFields.ERROR; 
						
						if (loginResultado) status = StatusFields.CONFIRM;
						
						MessageDialog.showMessageFields(status);
						txtUsuario.setStatus(status);
						txtSenha.setStatus(status);
						
					}
					
				});
			}
			
			getContentPane().add(panel_R);

		}
		
	}
	
	public static void main(String[] args) {
		
		Login login = new Login();
		
		login.setDefaultCloseOperation(EXIT_ON_CLOSE);
		login.setSize(Frames.LOGIN.getWidth(),Frames.LOGIN.getHeight());
		login.setResizable(false);
		login.setLocationRelativeTo(null);
		login.setTitle("Login");
		login.setFocusable(true);
		
		login.setVisible(true);
		
	}
	
}
