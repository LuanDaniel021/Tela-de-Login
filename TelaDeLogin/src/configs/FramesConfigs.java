package configs;

import java.awt.Dimension;

public enum FramesConfigs {
	LOGIN(new Dimension(800,700),"2.0");
	
	private Dimension dimension;
	private String versao;
	
	private FramesConfigs(Dimension dimension, String versao) {
		this.dimension = dimension;
		this.versao = versao;
	}

	public Dimension getDimencion() {return dimension;}
	
	public int getWidth() {return dimension.width;}

	public int getHeight() {return dimension.height;}

	public String getVersao() {return versao;}
	
}
