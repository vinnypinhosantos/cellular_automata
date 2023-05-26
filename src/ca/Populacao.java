package ca;

public class Populacao {
	private int colunas;
	private int linhas;
	private Celula[][] geracao;
	
	public Populacao(int colunas, int linhas) 
	{
		this.colunas = colunas;
		this.linhas = linhas;
		geracao = new Celula[colunas][linhas];
		for (int coluna = 0; coluna < colunas; coluna++) {
			for (int linha = 0; linha < linhas; linha++) {
				geracao[coluna][linha] = new Celula(coluna, linha);
			}
		}
	}
	
	@Override
	public String toString() {
		String populacao = "";
		for (int coluna = 0; coluna < colunas; coluna++) {
			for (int linha = 0; linha < linhas; linha++) {
				populacao += geracao[coluna][linha].toString();
				populacao += " ";
			}
			populacao += "\n";
		}
		return populacao;
	}
}
