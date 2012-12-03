package labs.lab20120117.spesa;

import labs.lab20120117.articoli.Articolo;

public class Item {

	private final Articolo articolo;
	private final int quantita;

	public Item(Articolo articolo, int quantita) {
		this.articolo = articolo;
		this.quantita = quantita;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public int getQuantita() {
		return quantita;
	}

	@Override
	public String toString() {
		return this.articolo.getClass().getSimpleName() + " [" + this.quantita
				+ "]";
	}
}
