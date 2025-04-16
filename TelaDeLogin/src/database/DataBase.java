package database;

import configs.MessageDialog;
import configs.StatusConnection;

public class DataBase {
    private String USUARIO = "usuario";
    private String SENHA = "senha";
	private StatusConnection status = StatusConnection.CONNECTED;
    
    public boolean tryLogin(String usuario,String senha) {
    	return (USUARIO.equals(usuario) && SENHA.equals(senha));
    }
    
    public void showMensage() {MessageDialog.showMessageConnection(status);}
    
}