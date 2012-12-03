package labs.lab20111115.elezione;

public class Voto {

	private enum Tipo {
		VALIDO, NULLO, BIANCA;
	}

	public Voto(ListaElettorale s) {
		if (s == null)
			this.value = Tipo.NULLO;
		else
			this.value = Tipo.VALIDO;
		this.lista = s;
	}

	public Voto() {
		this.value = Tipo.BIANCA;
		this.lista = null;
	}

	public String toString() {
		if (this.lista != null)
			return new String(this.value + " " + this.lista);
		else
			return new String(this.value + " NULLO o BIANCA.");
	}

	public boolean nullo() {
		return this.value == Tipo.NULLO;
	}

	public boolean sbianca() {
		return this.value == Tipo.BIANCA;
	}

	public ListaElettorale voto() {
		if (sbianca() || nullo())
			return null;
		else
			return this.lista;
	}

	private ListaElettorale lista;
	private Tipo value;
}
