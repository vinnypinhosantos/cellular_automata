package ca;

import java.util.ArrayList;
import java.util.List;

public class Geracao {
	private int colunas;
	private int linhas;
	private Celula[][] geracaoAtual;
	private Celula[][] proximaGeracao;
	private List<Celula[][]> geracoes;
	
	public int getColunas() {
		return colunas;
	}

	public int getLinhas() {
		return linhas;
	}
	
	
	public Celula[][] getGeracaoAtual() {
		return geracaoAtual;
	}

	public Geracao(int colunas, int linhas) 
	{
		this.colunas = colunas;
		this.linhas = linhas;
		this.geracaoAtual = new Celula[colunas][linhas];
		this.geracoes = new ArrayList<>();
		criarPrimeiraGeracao();
	}
	
	public void criarPrimeiraGeracao() {
		for (int coluna = 0; coluna < colunas; coluna++) {
			for (int linha = 0; linha < linhas; linha++) {
				geracaoAtual[coluna][linha] = new Celula(coluna, linha);
			}
		}
	}
	
	//TEM QUE IMPLEMENTAR
	public Celula[][] proximaGeracao() {

		int colunas = geracaoAtual.length;
		int linhas = geracaoAtual[0].length;

		for (int x = 0; x < colunas; x++) {
			for (int y = 0; y < linhas; y++) {

				List<Celula> vizinhanca = new ArrayList<>();
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						
						int xVizinhanca = calculaIndiceVizinhanca(colunas, x, i);
						int yVizinhanca = calculaIndiceVizinhanca (linhas, y, j);

						if (x != xVizinhanca && yVizinhanca != y) {
							vizinhanca.add(geracaoAtual[xVizinhanca][yVizinhanca]);
						}
					}
					
				}

				Celula celula = geracaoAtual[x][y];
				this.proximaGeracao = celula.aplicaRegras(vizinhanca);

			}
		}

		return proximaGeracao;
	}

	private int calculaIndiceVizinhanca (int length, int matrixIndex, int radiusIndex) {
		
		int index = matrixIndex + radiusIndex;
		
		if (index < 0) {
			index = length + index;
		} else if (index >= length) {
			index = index - length;
		}
		return index;
	}
	
	@Override
	public String toString() {
		String geracaoString = "";
		for (int coluna = 0; coluna < colunas; coluna++) {
			for (int linha = 0; linha < linhas; linha++) {
				geracaoString += geracaoAtual[coluna][linha].toString();
				geracaoString += " ";
			}
			geracaoString += "\n";
		}
		return geracaoString;
	}
}
