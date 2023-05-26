package ca;

public class Main {
	public static void main(String[] args) {
		Geracao novaPopulacao = new Geracao(3, 3);
		System.out.println(novaPopulacao.toString());
		System.out.println(novaPopulacao.proximaGeracao());
	}
}
