package companhiaAerea;

import java.util.ArrayList;

public class Aviao {
	private int classe1;
	private int classe2;
	ArrayList<Aviao> poltronas = new ArrayList<>();
	public int[] acento = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	public int getClasse1() {
		return classe1;
	}

	public void setClasse1(int classe1) {
		this.classe1 = classe1;
	}

	public int getClasse2() {
		return classe2;
	}

	public void setClasse2(int classe2) {
		this.classe2 = classe2;
	}
	
	public void adicionarPessoaPoltrona(Aviao poltrona) {
		poltronas.add(poltrona);
		try 
		{
			if(poltrona.equals(poltrona))
				System.out.println("Poltrona ocupada");	
		} 
		catch (Exception e) 
		{
			System.out.println("Poltrona livre");
		}
	}
	
	public Aviao classeAviao(int posicao, int[] p) {
		if(posicao >= 0 || posicao <= 5) {
			if(poltronas.get(posicao).equals(p)) {
				System.out.println("Poltrona ocupada, favor escolher outro acento");
			}
			System.out.println("Primeira classe");
			return poltronas.get(posicao);
		}
		else if(posicao >= 6 || posicao <= 9) {
			if(poltronas.get(posicao).equals(p)) {
				System.out.println("Poltrona ocupada, favor escolher outro acento");
			}
			System.out.println("Segunda classe");
			return poltronas.get(posicao);
		}
		
		return null;
	}
	
	public Aviao exibirPoltronas(int indice) {
		return poltronas.get(indice);
	}
	
	public int quantidadePoltronas() {
		return poltronas.size();
	}
}
