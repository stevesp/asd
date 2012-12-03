package labs.lab20110915.autori;

public class Autore implements Comparable<Autore> {
	private String nome, cognome, affiliazione;

	public Autore(String nome, String cognome, String affiliazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.affiliazione = affiliazione;
	}

	@Override
	public String toString() {
		return nome + ", " + cognome + ", " + affiliazione;
	}

	@Override
	public int compareTo(Autore a) {
		return this.toString().compareTo(a.toString());
	}

	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

}
