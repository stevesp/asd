package labs.lab20111115.elezione;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import labs.lab20111115.dizionario.Dictionary;
import labs.lab20111115.dizionario.LinkedDict;

public class Elezione {

	private class Coppia implements Comparable<Coppia> {
		private Integer voto;
		private ListaElettorale lista;

		private Coppia(Integer voto, ListaElettorale lista) {
			this.voto = voto;
			this.lista = lista;
		}

		@Override
		public int compareTo(Coppia o) {
			return this.voto.compareTo(o.voto);
		}

		private Integer getVoto() {
			return this.voto;
		}

		private ListaElettorale getLista() {
			return this.lista;
		}
	}

	private int votanti;
	private int numvoti;
	private int schedeNulle;
	private int schedeBianche;
	private List<ListaElettorale> liste;

	protected Dictionary<Integer> listeElettorali = new LinkedDict<Integer>();

	public Elezione(int n) {
		this.votanti = n;
		this.numvoti = 0;
		this.schedeBianche = 0;
		this.schedeNulle = 0;
		this.liste = new ArrayList<ListaElettorale>();
	}

	public void aggiungiLista(ListaElettorale l) {
		this.listeElettorali.insert(0, l);
		this.liste.add(l);
	}

	public void scrutinaVoto(Voto v) {
		if (this.numvoti >= this.votanti)
			throw new NumeroMassimoRaggiunto();

		if (v.nullo())
			schedeNulle++;
		else if (v.sbianca())
			schedeBianche++;
		else {
			ListaElettorale corrente = v.voto();

			Integer numeroVoti = listeElettorali.search(corrente);
			listeElettorali.delete(corrente);
			listeElettorali.insert(numeroVoti + 1, corrente);
		}

		numvoti++;
	}

	public int numVoti(ListaElettorale l) {
		return this.listeElettorali.search(l);
	}

	public int nulle() {
		return this.schedeNulle;
	}

	public int bianche() {
		return this.schedeBianche;
	}

	public void elencoOrdinato() {
		List<Coppia> ordina = new ArrayList<Coppia>();

		for (ListaElettorale l : this.liste)
			ordina.add(new Coppia(listeElettorali.search(l), l));

		Collections.sort(ordina);

		for (Coppia c : ordina)
			System.out.println(c.getVoto() + " " + c.getLista());
	}
}