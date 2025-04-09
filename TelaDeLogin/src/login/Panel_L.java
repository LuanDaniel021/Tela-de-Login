package login;

import java.awt.Font;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Login;
import configs.Frames;

@SuppressWarnings("serial")
public class Panel_L extends JPanel {
	
	private static final ImageIcon USER_ICON = new ImageIcon(
		Login.class.getResource("/resources/imagem-do-usuario-com-fundo-preto-128x128.png")
	);
	
	public Panel_L() {
		
		this.setLayout(null);
		
		JLabel icon_BemVindo = new JLabel(USER_ICON);
		icon_BemVindo.setBounds(126, 230, 128, 128);

		this.add(icon_BemVindo);
		
		JLabel label = new JLabel("Bem Vindo");
		label.setFont(new Font("Arial", Font.BOLD, 35));
		label.setBounds(101, 368, 178, 41);
		this.add(label);
		
		Label versao_Label = new Label("Versão " + Frames.LOGIN.getVersao());
		versao_Label.setBounds(10, 650, 77, 22);
	}
	
}
