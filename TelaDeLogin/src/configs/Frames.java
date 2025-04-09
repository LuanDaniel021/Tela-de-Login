package configs;

public enum Frames {
	LOGIN(800,700,"1.4");
	
	private int width;
	private int height;
	private String versao;
	
	private Frames(int width, int height, String versao) {
		this.width = width;
		this.height = height;
		this.versao = versao;
	}

	public int getWidth() {return width;}

	public int getHeight() {return height;}

	public String getVersao() {return versao;}
	
}
