package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import fields.MPasswordField;
import fields.MTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	private MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (getFocusOwner() instanceof MTextField) {
		            if (!SwingUtilities.isDescendingFrom(e.getComponent(), getFocusOwner())) {
		                requestFocusInWindow();
		            }
		        }
				
			}
		};
	
	public Login() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setSize(800,700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);;
		
		this.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		{ // DIREITA
			
			JPanel panel_R = new JPanel();
			panel_R.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
			this.getContentPane().add(panel_R);
			panel_R.setLayout(new BorderLayout(0, 0));
			
			{ // CENTRO
				
				Panel panel_RC = new Panel();
				panel_R.add(panel_RC);
				
				//panel_RC.addMouseListener(mouseAdapter);
				
				GridBagLayout gbl_panel_RC = new GridBagLayout();
				gbl_panel_RC.rowHeights = new int[] {14};
				
				panel_RC.setLayout(gbl_panel_RC);
				
				JLabel lblBemVindo = new JLabel("Bem Vindo");
				lblBemVindo.setFont(new Font("Arial", Font.BOLD, 35));
				
				GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
				gbc_lblBemVindo.insets = new Insets(10, 10, 10, 10);
				gbc_lblBemVindo.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblBemVindo.gridx = 0;
				gbc_lblBemVindo.gridy = 0;
				
				panel_RC.add(lblBemVindo, gbc_lblBemVindo);
				
			}
			
			{ // BAIXO
				
				Panel panel_RB = new Panel();
				panel_R.add(panel_RB, BorderLayout.SOUTH);
				panel_RB.setLayout(new BorderLayout(0, 0));
				
				//panel_RB.addMouseListener(mouseAdapter);
				
				Label versao_Label = new Label("Versão 0.2");
				panel_RB.add(versao_Label, BorderLayout.WEST);
				
			}
			
		}
		
		{ // ESQUERDA
			
			JPanel panel_L = new JPanel();
			panel_L.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
			this.getContentPane().add(panel_L);
			panel_L.setLayout(new BorderLayout(0, 0));
			
			{ // TOPO
				
				Panel panel_LT = new Panel();
				panel_L.add(panel_LT, BorderLayout.NORTH);
				
				//panel_LT.addMouseListener(mouseAdapter);
				
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
				panel_L.add(panel_LC, BorderLayout.CENTER);
				
				//panel_LC.addMouseListener(mouseAdapter);
				
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
				panel_L.add(panel_LB, BorderLayout.SOUTH);
				
				//panel_LB.addMouseListener(mouseAdapter);
				
				JButton btnEntrar = new JButton("Entrar");
				btnEntrar.setFocusable(false);
				panel_LB.add(btnEntrar);
				btnEntrar.setPreferredSize(new Dimension(150, 40));
				btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
				
			}
			
		}
		
		setFocusable(true);
		
		JPanel glassPane = new JPanel();
        glassPane.setOpaque(false);
        glassPane.setLayout(null);
        
        glassPane.addMouseListener(mouseAdapter);

        this.setGlassPane(glassPane);
        glassPane.setVisible(true);
		
		this.setVisible(true);
	}
	
	//panel_RC.addMouseListener(mouseAdapter);
	
}
