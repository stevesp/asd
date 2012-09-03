package lab20111115.elezione;

import lab20111115.Persona;

public class Candidato implements Persona {

	public Candidato(String nome, String cognome){
		this.nome=nome;
		this.cognome=cognome;
	}
	
	private String nome;
	private String cognome;
}
