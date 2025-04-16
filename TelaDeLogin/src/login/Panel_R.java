package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import MComponentes.enums.StatusFields;
import fields.MPasswordField;
import fields.MTextField;

@SuppressWarnings("serial")
public class Panel_R extends JPanel {
	
	public Panel_R(MTextField txtUsuario, MPasswordField txtSenha, JButton btnEntrar) {
		
		this.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.LIGHT_GRAY));
		this.setLayout(null);
		
		{
			JLabel login_label = new JLabel("Login");
			login_label.setBounds(10, 11, 80, 46);
			login_label.setFont(new Font("Arial", Font.BOLD, 30));
			this.add(login_label);
		}
		
		{
			txtUsuario.setBounds(58, 283, 280, 46);
			txtUsuario.setStatusOnFocus(StatusFields.DEFAULT);
			this.add(txtUsuario);
		}
		
		{
			txtSenha.setBounds(58, 350, 280, 46);
			txtSenha.setStatusOnFocus(StatusFields.DEFAULT);
			this.add(txtSenha);
		}
		
		{
			btnEntrar.setBounds(124, 621, 150, 40);
			btnEntrar.setFocusPainted(false);		
			btnEntrar.setPreferredSize(new Dimension(150, 40));
			btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
			this.add(btnEntrar);
		}
		
	}
	
}
