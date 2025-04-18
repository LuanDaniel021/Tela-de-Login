package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import MComponentes.enums.StatusFields;
import app.Main;
import configs.FramesConfigs;
import configs.LoginInterface;
import configs.MouseModify;
import fields.MPasswordField;
import fields.MTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	private final MouseModify mouseAdapter;

	public Login(LoginInterface loginInterface) {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(FramesConfigs.LOGIN.getDimencion());
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Login");
		setFocusable(true);
		
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		mouseAdapter = new MouseModify(this);

		{ // LEFT PANEL
			
			JPanel panel_L = new JPanel();
			panel_L.addMouseListener(mouseAdapter);
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{1.0};
			gridBagLayout.columnWidths = new int[]{0};
			
			panel_L.setLayout(gridBagLayout);
			
			{ // COMPINENTES
				
				{	 // IMAGEM "imagem-do-usuario-com-fundo-preto-128x128.png"
					
					JLabel icon_BemVindo = new JLabel(
						new ImageIcon(Main.class.getResource("/resources/imagem-do-usuario-com-fundo-preto-128x128.png"))
					);
					
					GridBagConstraints gbc_icon_BemVindo = new GridBagConstraints();
					gbc_icon_BemVindo.insets = new Insets(0, 0, 5, 0);
					gbc_icon_BemVindo.gridx = 0;
					gbc_icon_BemVindo.gridy = 1;
					
					panel_L.add(icon_BemVindo, gbc_icon_BemVindo);
					
				}
				
				{ // LABEL "Bem Vindo"
					Label label_bemVindo = new Label("Bem Vindo");
					
					label_bemVindo.setFont(new Font("Arial", Font.BOLD, 35));
					
					GridBagConstraints gbc_label_bemVindo = new GridBagConstraints();
					gbc_label_bemVindo.insets = new Insets(0, 0, 5, 0);
					gbc_label_bemVindo.gridx = 0;
					gbc_label_bemVindo.gridy = 2;
					
					panel_L.add(label_bemVindo, gbc_label_bemVindo);
					
				}
				
				{ // LABEL VERSÂO
					Label versao_Label = new Label("Versão " + FramesConfigs.LOGIN.getVersao());
					
					GridBagConstraints gbc_versao_Label = new GridBagConstraints();
					gbc_versao_Label.anchor = GridBagConstraints.WEST;
					gbc_versao_Label.gridx = 0;
					gbc_versao_Label.gridy = 4;
					
					panel_L.add(versao_Label, gbc_versao_Label);
				}
				
			}
			
			getContentPane().add(panel_L);
			
		}
			
		{ // RIGHT PANEL
			
			JPanel panel_R = new JPanel();
			panel_R.addMouseListener(mouseAdapter);

			panel_R.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.LIGHT_GRAY));
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{0};
			gridBagLayout.columnWeights = new double[]{1.0};
			gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 25, 0, 0, 0, 20};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
			
			panel_R.setLayout(gridBagLayout);
			
			{ // COMPONENTES
				
				{ // LABEL "Login"
					
					JLabel login_label = new JLabel("Login");
					
					login_label.setFont(new Font("Arial", Font.BOLD, 30));
					
					GridBagConstraints gbc_login_label = new GridBagConstraints();
					gbc_login_label.anchor = GridBagConstraints.WEST;
					gbc_login_label.fill = GridBagConstraints.VERTICAL;
					gbc_login_label.insets = new Insets(0, 10, 0, 0);
					gbc_login_label.gridx = 0;
					gbc_login_label.gridy = 1;
					
					panel_R.add(login_label, gbc_login_label);
				}
				
				{ // INTERAGIVEIS
					
					{ // FIELD USUÁRIO
						
						MTextField txtUsuario = loginInterface.txtusuario();
						
						txtUsuario.setStatusOnFocus(StatusFields.DEFAULT);
						
						GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
						gbc_txtUsuario.ipadx = 200;
						gbc_txtUsuario.insets = new Insets(0, 0, 0, 0);
						gbc_txtUsuario.gridx = 0;
						gbc_txtUsuario.gridy = 3;
						
						panel_R.add(txtUsuario, gbc_txtUsuario);
						
					}
					
					{ // FIELD SENHA
						
						MPasswordField txtSenha = loginInterface.txtSenha();
						
						txtSenha.setStatusOnFocus(StatusFields.DEFAULT);
						
						GridBagConstraints gbc_txtSenha = new GridBagConstraints();
						gbc_txtSenha.ipadx = 200;
						gbc_txtSenha.insets = new Insets(0, 0, 0, 0);
						gbc_txtSenha.gridx = 0;
						gbc_txtSenha.gridy = 5;
						
						panel_R.add(txtSenha, gbc_txtSenha);
						
					}
					
					{ // BOTÂO ENTRAR
						
						JButton btnEntrar = loginInterface.btnEntrar();
						
						btnEntrar.setFocusPainted(false);
						
						GridBagConstraints gbc_btnEntrar = new GridBagConstraints();					
						gbc_btnEntrar.ipadx = 150;
						gbc_btnEntrar.ipady = 20;
						gbc_btnEntrar.insets = new Insets(0, 0, 0, 0);
						gbc_btnEntrar.gridx = 0;
						gbc_btnEntrar.gridy = 7;
						
						panel_R.add(btnEntrar, gbc_btnEntrar);
						
					}
					
				}
				
			}
			
			getContentPane().add(panel_R);
			
		}
		
	}

}