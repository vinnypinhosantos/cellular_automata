package ca;


import java.util.Random;

public class Estado {
	private String nome;
	private String abreviacao;
	private String[][] possiveisEstados = new String[][] {
		{"SUSCETIVEL", "S"},
		{"INFECTADO", "I"},
		{"RECUPERADO", "R"}
	};
	
	public Estado() {
		Random random = new Random();
		int estadoAleatorio = random.nextInt(3);
		nome = possiveisEstados[estadoAleatorio][0];
		abreviacao = possiveisEstados[estadoAleatorio][1];
	}
	
	public Estado(String nome) {
		for (String[] possivelEstado : possiveisEstados) {
			if (possivelEstado[0].equals(nome)) {
				this.nome = nome;
				this.abreviacao = possivelEstado[1];
			}
		}
	}
	
	@Override
	public String toString() {
		return abreviacao;
	}
}
