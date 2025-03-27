package app;

public class Main { 

    public static final Config CONFIG = new Config();
    public static final Database DB = new Database();

    public static void main(String[] args) {new Login();}
    
    public static class Config {
        public final int WIDTH = 800;
        public final int HEIGHT = 700;
        public final String VERSAO = "0.4";
    }

    
    // Sem função
    public static class Database {
        public String usuario = "";
        public String senha = "";
        public boolean loginResultado = false;

        public String getConnectionStatus() {
            return loginResultado ? "Conectado" : "Desconectado";
        }
    }
}
