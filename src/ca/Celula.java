package ca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Celula {
	private int coluna;
	private int linha;
	private Estado estado;
	
	public Celula(int coluna, int linha) {
		this.coluna = coluna;
		this.linha = linha;
		
		estado = new Estado();
	}
	
	public Map<String[], Double> mapeiaRegras() {
		Map<String[], Double> regras = new HashMap<>();
		
		
		regras.put(new String[] {"SUSCETIVEL", "INFECTADO"}, 0.2);
		regras.put(new String[] {"SUSCETIVEL", "RECUPERADO"}, 0.1);
		regras.put(new String[] {"INFECTADO", "SUSCETIVEL"}, 0.3);
		regras.put(new String[] {"INFECTADO", "RECURADO"}, 0.6);
		regras.put(new String[] {"RECUPERADO", "SUSCETIVEL"}, 0.1);
		regras.put(new String[] {"RECUPERADO", "INFECTADO"}, 0.1);
		
		return regras;
	}
	
	public Celula aplicaRegras(List<Celula> vizinhanca) {
		Random rand = new Random();
		Map<String[], Double> regras = mapeiaRegras();
		
		for (Entry<String[], Double> regra: regras.entrySet()) {
			Double probabilidade = regra.getValue();
			if (rand.nextDouble() < probabilidade) {
				estado = new Estado(regra.getKey()[1]);
				return this;
			}
		}
		return null;
	}
	
	public double getV(List<Celula> vizinhanca) {
		double v = 0;

		for (Celula n : vizinhanca) {
		    if (this.equals(n)) {
		        v++;
		    }
		}
		return v;
	}
	
	@Override
	public String toString() {
		return estado.toString();
	}
}
