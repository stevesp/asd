package labs.lab20100902.index;

public class Valore implements Comparable<Valore> {

	private String parola;
	private int linea;
	
	public Valore(String parola, int linea) {
		this.parola = parola;
		this.linea = linea;
	}

	public String getParola() {
		return this.parola;
	}

	public int getLinea() {
		return this.linea;
	}

	@Override
	public int compareTo(Valore v) {
		return this.parola.compareToIgnoreCase(v.parola);
	}
	
	@Override
	public String toString() {
		return this.parola+", "+this.linea;
	}
}
