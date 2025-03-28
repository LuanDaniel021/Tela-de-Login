package app;

public class Main { 

    public static final Config CONFIG = new Config();
    public static final Database DB = new Database();

    public static void main(String[] args) {new Login();}
    
    public static class Config {
        public final int WIDTH = 800;
        public final int HEIGHT = 700;
        public final String VERSAO = "0.5.2";
    }

    // Simula um login pra testes
    public static class Database {
        public String USUARIO = "usuario";
        public String SENHA = "senha";
        
        public boolean loginResultado = false;
    }
    
    public static void tryLogin(String usuario,String senha) {
    	DB.loginResultado = (DB.USUARIO.equals(usuario) && DB.SENHA.equals(senha));
    }
    
    // mudei coisas mas no fim não mudei nada ...
}

