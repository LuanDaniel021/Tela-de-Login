package app;

import database.DataBase;
import login.Login;

public class Main { 
	
	public static final Caminhos CAMINHO = new Caminhos();
    public static final Config CONFIG = new Config();
    public static final DataBase DB = new DataBase();
	
    public static void main(String[] args) {new Login();}
    
    public static class Config {
        public final int WIDTH = 800;
        public final int HEIGHT = 700;
        public final String VERSAO = "0.5.2";
    }

    public static class Caminhos {
    	public final String USER_ICON;
    	
    	{ // IMAGENS
    		USER_ICON = "C:/Users/Luan/git/repository-TelaDeLogin/TelaDeLogin/img/imagem-do-usuario-com-fundo-preto-128x128.png";
    	}
    	
    }
    
}

