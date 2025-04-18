package app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import MComponentes.enums.StatusFields;
import configs.LoginInterface;
import configs.MessageDialog;
import database.DataBase;
import fields.MPasswordField;
import fields.MTextField;
import frame.Login;


public class Main {
	
	private static Login LOGIN;
	
	public static void main(String[] args) {

		LOGIN = new Login(new LoginInterface() {

			private final MTextField txtUsuario = new MTextField("Nome de Usuário", new Font("Arial",1,18));
			private final MPasswordField txtSenha = new MPasswordField("Senha",new Font("Arial",1,18));
			private final JButton btnEntrar = new JButton("Entrar");
			
			@Override
			public MTextField txtusuario() {return txtUsuario;}

			@Override
			public MPasswordField txtSenha() {return txtSenha;}

			@Override
			public JButton btnEntrar() {
				
				btnEntrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						login(DataBase.tryLogin(txtUsuario.getText(), new String(txtSenha.getPassword())));
					}

					private void login(boolean connection) {
						StatusFields status = (connection) ? StatusFields.CONFIRM : StatusFields.ERROR;
						
						txtUsuario.setStatus(status);
						txtSenha.setStatus(status);
						MessageDialog.showMessageFields(status);
						
					}
				});
				
				return btnEntrar;
			}

		});
		
		LOGIN.setVisible(true);
		
	}
	
}
