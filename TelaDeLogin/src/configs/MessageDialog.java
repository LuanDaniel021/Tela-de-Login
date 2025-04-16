package configs;

import javax.swing.JOptionPane;

import MComponentes.enums.StatusFields;

@SuppressWarnings("serial")
public class MessageDialog extends JOptionPane {
	
	public static void showMessageConnection(StatusConnection s) {
		if (s == StatusConnection.ERROR) showError_CONNECTION_ERROR();
	}
	
	public static void showMessageFields(StatusFields s) {
		if (s == StatusFields.ERROR) showError_INCORRECT_USER();
		if (s == StatusFields.CONFIRM) showConfirmed_CONFIRMED_USER();
	}

	private enum Menssages {
		// constante(titulo, mensagem,type)
		INCORRECT_USER("Falha no Login","Senha ou nome incorretos",ERROR_MESSAGE),
		CONFIRMED_USER("Login Concluido","Usuário Conectado",INFORMATION_MESSAGE),
		CONNECTION_ERROR("Falha de Conexão", "Erro ao conectar ao banco de dados",ERROR_MESSAGE);
		
		private final String title;
		private final String msg;
		private final int type;
		
		Menssages(String title,String msg,int type) {
			this.title = title;
			this.msg = msg;
			this.type = type;
		}
		
		public int getType() {return type;}
		public String getTitle() {return title;}
		public String getMsg() {return msg;}

	}

	private static void showConfirmed_CONFIRMED_USER() {
		JOptionPane.showMessageDialog(
			null,
			Menssages.CONFIRMED_USER.getMsg(),
			Menssages.CONFIRMED_USER.getTitle(),
			Menssages.CONFIRMED_USER.getType()
		);
	}

	private static void showError_INCORRECT_USER() {
		JOptionPane.showMessageDialog(
			null,
			Menssages.INCORRECT_USER.getMsg(), 
			Menssages.INCORRECT_USER.getTitle(),
			Menssages.INCORRECT_USER.getType()
		);
	}
	
	private static void showError_CONNECTION_ERROR() {
		JOptionPane.showMessageDialog(
			null,
			Menssages.CONNECTION_ERROR.getMsg(), 
			Menssages.CONNECTION_ERROR.getTitle(),
			Menssages.CONNECTION_ERROR.getType()
		);
	}
}

