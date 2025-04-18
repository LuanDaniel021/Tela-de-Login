package database;

import configs.MessageDialog;
import configs.StatusConnection;

public class DataBase {
    private static String USUARIO = "usuario";
    private static String SENHA = "senha";
    
	private StatusConnection status = StatusConnection.CONNECTED;
    
    public static boolean tryLogin(String usuario,String senha) {
    	return (USUARIO.equals(usuario) && SENHA.equals(senha));
    }
    
    public void showMensage() {MessageDialog.showMessageConnection(status);}
    
}