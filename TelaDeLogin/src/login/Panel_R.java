package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import app.Main;
import enums.Status;
import fields.MPasswordField;
import fields.MTextField;

@SuppressWarnings("serial")
public class Panel_R extends JPanel {
	
	private MTextField txtUsuario;
	private MPasswordField txtSenha;
	
	public Panel_R() {
		
		this.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.LIGHT_GRAY));
		this.setLayout(new BorderLayout(0, 0));
		
		{ // TOPO
			
			Panel panel_T = new Panel();
			this.add(panel_T, BorderLayout.NORTH);
			
			GridBagLayout gbl_panel_T = new GridBagLayout();
			gbl_panel_T.columnWidths = new int[] {350};
			
			panel_T.setLayout(gbl_panel_T);
			
			JLabel login_label = new JLabel("Login");
			login_label.setFont(new Font("Arial", Font.BOLD, 30));
			
			GridBagConstraints gbc_lblLogin = new GridBagConstraints();
			gbc_lblLogin.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblLogin.insets = new Insets(10, 10, 10, 10);
			gbc_lblLogin.gridx = 0;
			gbc_lblLogin.gridy = 0;
			
			panel_T.add(login_label, gbc_lblLogin);
			
		}
		
		{ // CENTRO
			
			Panel panel_C = new Panel();
			this.add(panel_C, BorderLayout.CENTER);
			
			GridBagLayout gbl_panel_C = new GridBagLayout();
			gbl_panel_C.rowHeights = new int[] {20, 20};
			gbl_panel_C.columnWidths = new int[] {300};
			panel_C.setLayout(gbl_panel_C);
			
			{ // ADD FIELDS
				
				GridBagConstraints gbc_Fields = new GridBagConstraints();
				
				{ // CONFIG FIELDS
					
					gbc_Fields.fill = GridBagConstraints.HORIZONTAL;
					gbc_Fields.insets = new Insets(10, 10, 10, 10);
					gbc_Fields.gridx = 0;
					
					txtUsuario = new MTextField("Nome de Usuário",10, new Font("Arial",0,18));
					txtUsuario.setStatusOnFocus(Status.DEFAULT);
					
					txtSenha = new MPasswordField("Senha",10,new Font("Arial",0,18));
					txtSenha.setStatusOnFocus(Status.DEFAULT);
				}
				
				gbc_Fields.gridy = 0;
				
				panel_C.add(txtUsuario, gbc_Fields);
				
				gbc_Fields.gridy = 1;
				
				panel_C.add(txtSenha, gbc_Fields);
			}
			
		}
		
		{ // BAIXO
			
			Panel panel_B = new Panel();
			this.add(panel_B, BorderLayout.SOUTH);
			
			JButton btnEntrar = new JButton("Entrar");
			btnEntrar.setFocusPainted(false);
			btnEntrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					resultdoLogin(Main.DB.tryLogin(txtUsuario.getText(), new String(txtSenha.getPassword())));
				}
				
			});
			panel_B.add(btnEntrar);
			
			btnEntrar.setPreferredSize(new Dimension(150, 40));
			btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
			
		}
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
	
	public void addMouseListenerInPanels(MouseAdapter mouseAdapter) {
		
		this.getComponent(0).addMouseListener(mouseAdapter);	// panel_T
		this.getComponent(1).addMouseListener(mouseAdapter);	// panel_C
		this.getComponent(2).addMouseListener(mouseAdapter);	// panel_B
		
	}
}
