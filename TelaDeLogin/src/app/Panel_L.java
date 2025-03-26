package app;

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
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import fields.MPasswordField;
import fields.MTextField;

@SuppressWarnings("serial")
public class Panel_L extends JPanel {
	
	
	public Panel_L() {
		
		this.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		this.setLayout(new BorderLayout(0, 0));
		
		{ // TOPO
			
			Panel panel_LT = new Panel();
			this.add(panel_LT, BorderLayout.NORTH);
			
			GridBagLayout gbl_panel_LT = new GridBagLayout();
			gbl_panel_LT.columnWidths = new int[] {350};
			
			panel_LT.setLayout(gbl_panel_LT);
			
			JLabel login_label = new JLabel("Login");
			login_label.setFont(new Font("Arial", Font.BOLD, 30));
			
			GridBagConstraints gbc_lblLogin = new GridBagConstraints();
			gbc_lblLogin.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblLogin.insets = new Insets(10, 10, 10, 10);
			gbc_lblLogin.gridx = 0;
			gbc_lblLogin.gridy = 0;
			
			panel_LT.add(login_label, gbc_lblLogin);
			
		}
		
		{ // CENTRO
			
			Panel panel_LC = new Panel();
			this.add(panel_LC, BorderLayout.CENTER);
			
			GridBagLayout gbl_panel_LC = new GridBagLayout();
			gbl_panel_LC.rowHeights = new int[] {20, 20};
			gbl_panel_LC.columnWidths = new int[] {300};
			panel_LC.setLayout(gbl_panel_LC);
			
			GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
			gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsuario.insets = new Insets(10, 10, 10, 10);
			gbc_txtUsuario.gridx = 0;
			gbc_txtUsuario.gridy = 0;
			
			MTextField txtUsuario = new MTextField("Usuario",10);
			panel_LC.add(txtUsuario, gbc_txtUsuario);
			
			GridBagConstraints gbc_txtSenha = new GridBagConstraints();
			gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSenha.insets = new Insets(10, 10, 10, 10);
			gbc_txtSenha.gridx = 0;
			gbc_txtSenha.gridy = 1;
			
			MPasswordField txtSenha = new MPasswordField("Senha",10);
			panel_LC.add(txtSenha, gbc_txtSenha);
			
		}
		
		{ // BAIXO
			
			Panel panel_LB = new Panel();
			this.add(panel_LB, BorderLayout.SOUTH);
			
			JButton btnEntrar = new JButton("Entrar");
			btnEntrar.setFocusPainted(false);
			btnEntrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO "actionPerformed" Vazio
				}
				
			});
			panel_LB.add(btnEntrar);
			
			btnEntrar.setPreferredSize(new Dimension(150, 40));
			btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
			
		}
	}
	
	public void addMouseListenerInPanels(MouseAdapter mouseAdapter) {
		
		this.getComponent(0).addMouseListener(mouseAdapter);	// panel_RC
		this.getComponent(1).addMouseListener(mouseAdapter);	// panel_RB
		
		this.getComponent(0).addMouseListener(mouseAdapter);	// panel_LT
		this.getComponent(1).addMouseListener(mouseAdapter);	// panel_LC
		this.getComponent(2).addMouseListener(mouseAdapter);	// panel_LB
		
	}
}
