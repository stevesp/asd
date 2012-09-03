package labs.lab20111115.elezione;

import java.util.List;

public class ListaElettorale implements Comparable<ListaElettorale> {

	public ListaElettorale(String nome, List<String> candidati){
		this.nome = nome;
		this.candidati = candidati;
	}
	
	public String nomeLista(){
		return this.nome;
	}
	
	public List<String> candidati(){
		return this.candidati;
	}
	
	public int compareTo(ListaElettorale o) {
		return o.nome.compareToIgnoreCase(this.nome);
	}
		
	public String toString(){
		return this.nome.toUpperCase();
	}
	
	private String nome;
	private List<String> candidati;
}
