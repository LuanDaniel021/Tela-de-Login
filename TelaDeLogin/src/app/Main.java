package app;

public class Main { 

    public static final Config CONFIG = new Config();
    public static final Database DB = new Database();

    public static void main(String[] args) {new Login();}
    
    public static class Config {
        public final int WIDTH = 800;
        public final int HEIGHT = 700;
        public final String VERSAO = "0.5";
    }

    
    // Sem função
    public static class Database {
        public String usuario = "usuario";
        public String senha = "senha";
        
        public boolean loginResultado = false;
    }
    
    public static void tryLogin(String usuario,String senha) {
    	DB.loginResultado = (DB.usuario.equals(usuario) && DB.senha.equals(senha));
    }
}
