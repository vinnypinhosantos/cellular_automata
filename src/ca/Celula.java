package ca;

public class Celula {
	private int coluna;
	private int linha;
	private Estado estado;
	
	public Celula(int coluna, int linha) {
		this.coluna = coluna;
		this.linha = linha;
		
		estado = new Estado();
	}
	
	@Override
	public String toString() {
		return estado.toString();
	}
}
