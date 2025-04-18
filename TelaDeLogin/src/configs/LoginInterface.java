package configs;

import javax.swing.JButton;
import fields.MPasswordField;
import fields.MTextField;

public interface LoginInterface {
	public MTextField txtusuario();
	public MPasswordField txtSenha();
	public JButton btnEntrar();
}
