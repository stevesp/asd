package lists.listdoublelinked;

import lists.Lista;
import lists.Posizione;

public class ListDoubleLinked implements Lista {

	private PuntatoreDouble inizioLista = null;

	public boolean endList(Posizione p) {
		if (isEmpty())
			return true;
		if (p == firstList())
			return inizioLista == null;
		else
			return ((PuntatoreDouble) p).link.successivo == null;
	}

	public Posizione firstList() {
		return null;
	}

	public boolean isEmpty() {
		return inizioLista == null;
	}

	public Object readList(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return inizioLista.link.elemento;
		else
			return ((PuntatoreDouble) p).link.successivo.link.elemento;
	}

	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return inizioLista;
		else if (p == inizioLista)
			return inizioLista.link.successivo;
		else
			return ((PuntatoreDouble) p).link.successivo;
	}

	public void writeList(Object e, Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		((PuntatoreDouble) p).link.successivo.link.elemento = e;
	}

	public void insert(Object e, Posizione p) {
		PuntatoreDouble temp, q;

		if (!isEmpty()) {
			if (firstList() == p) {
				temp = inizioLista;
				inizioLista = new PuntatoreDouble(new CellaDouble(e));
				inizioLista.link.successivo = temp;
				temp.link.precedente = inizioLista;
			} else {
				temp = ((PuntatoreDouble) p).link.successivo;
				q = new PuntatoreDouble(new CellaDouble(e));
				((PuntatoreDouble) p).link.successivo = q;
				q.link.successivo = temp;
				if (temp != null)
					temp.link.precedente = q;
				q.link.precedente = (PuntatoreDouble) p;
			}

		} else {
			// se la lista � vuota
			inizioLista = new PuntatoreDouble(new CellaDouble(e));
		}

	}

	/*
	 * Se p corrisponde alla posizione di primo lista allora solleva una
	 * IndexOutOfBoundsException Se list è vuota allora solleva una
	 * IndexOutOfBoundsException altrimenti resituisci la posizione precedente a
	 * p
	 */
	public Posizione pred(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("La lista è vuota");

		if (firstList() == p)
			throw new IndexOutOfBoundsException("Primo elemento");

		return ((PuntatoreDouble) p).link.precedente;
	}

	/*
	 * Se fine lista di p è vero allora solleva una IndexOutOfBoundsException Se
	 * p coincide con il primo lista allora assegna a inizioLista il suo
	 * successivo, e assegna al campo precedente di inizioLista.link null
	 * altrimenti si disdinguono due casi caso 1: se fine lista di
	 * p.link.successivo è vero allora si sta cancellando l'ultimo elemento
	 * della lista quindi basta porre il campo successivo di p.lin a null caso
	 * 2: se fine lista di p.link.successivo è falso allora si sta cancellando
	 * un elemento che è in posizione intermedia nella lista in particolare la
	 * cella che si rimuove è quella identificata da p.link.successivo
	 */
	public void remove(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException("Fine lista");

		if (firstList() == p) {
			inizioLista = inizioLista.link.successivo;
			inizioLista.link.precedente = null;
		} else {
			if (endList(((PuntatoreDouble) p).link.successivo))
				((PuntatoreDouble) p).link.successivo = null;
			else {
				((PuntatoreDouble) p).link.successivo = ((PuntatoreDouble) p).link.successivo.link.successivo;
				((PuntatoreDouble) p).link.successivo.link.precedente = ((PuntatoreDouble) p);
			}
		}
	}

}
