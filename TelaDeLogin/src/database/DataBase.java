package database;

public class DataBase {
    private String USUARIO = "usuario";
    private String SENHA = "senha";
    
    public boolean tryLogin(String usuario,String senha) {
    	return (USUARIO.equals(usuario) && SENHA.equals(senha));
    }
    
}