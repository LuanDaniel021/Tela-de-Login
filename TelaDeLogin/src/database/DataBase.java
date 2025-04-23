package database;

import configs.MessageDialog;
import configs.StatusConnection;

public class DataBase {
    private static Usuario USUARIO = new Usuario("usuario","senha");
    
	private StatusConnection status = StatusConnection.CONNECTED;
    
    public static boolean tryLogin(Usuario usuario) {
    	return (USUARIO.getNome().equals(usuario.getNome()) && USUARIO.getSenha().equals(usuario.getSenha()));
    }
    
    public void showMensage() {MessageDialog.showMessageConnection(status);}
    
}