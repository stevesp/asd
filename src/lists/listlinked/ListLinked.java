package lists.listlinked;

import lists.Lista;
import lists.Posizione;

public class ListLinked implements Lista {

	private Puntatore inizioLista = null;

	public boolean isEmpty() {
		return inizioLista == null;
	}

	public Posizione firstList() {
		return null;
	}

	public boolean endList(Posizione p) {
		if (isEmpty())
			return true;

		if (p == firstList())
			return false; // verifica che la lista sia vuota
		else
			return ((Puntatore) p).link.successivo == null; // verifica che
															// elemento
															// successivo a
															// quello in
															// posizione p sia
															// nullo
	}

	public Object readList(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return inizioLista.link.elemento;
		else
			return ((Puntatore) p).link.successivo.link.elemento;
	}

	public void insert(Object e, Posizione p) {
		Puntatore temp, q;

		if (!isEmpty()) {
			// se la lista non è vuota
			if (p == firstList()) {
				// se primo lista
				temp = inizioLista;
				inizioLista = new Puntatore(new Cella(e));
				inizioLista.link.successivo = temp;
			} else {
				temp = ((Puntatore) p).link.successivo;
				q = new Puntatore(new Cella(e));
				((Puntatore) p).link.successivo = q;
				q.link.successivo = temp;
			}
		} else {
			// se la lista è vuota
			inizioLista = new Puntatore(new Cella(e));
		}
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
			return ((Puntatore) p).link.successivo;
	}

	/*
	 * se p==firstList() si solleva una IndexOutOfBoundsException se la lista è
	 * vuota si solleva una IndexOutOfBoundsException altimenti partendo da
	 * inizioLista si scandisce la lista fino a trovare il puntatore a una Cella
	 * (denotato come temp) tale che temp.link.successivo sia uguale a p
	 */

	public Posizione pred(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");

		if (p == firstList())
			throw new IndexOutOfBoundsException(
					"Posizione inizio lista non valida");

		Puntatore temp = null;
		for (temp = inizioLista; !endList(temp); temp = temp.link.successivo) {
			if (p == temp.link.successivo)
				break;
		}
		return (Puntatore) temp;
	}

	/*
	 * se p==endList() si solleva una IndexOutOfBoundsException se p ==
	 * firstList() si sposta inizioLista sull'elemento successivo da esso
	 * puntato altimenti si modifica p in modo che il suo successivo sia quello
	 * puntato dal suo successivo corrente
	 */

	public void remove(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException("Fine lista");

		if (firstList() == p)
			inizioLista = inizioLista.link.successivo;
		else {
			if (endList(((Puntatore) p).link.successivo))
				((Puntatore) p).link.successivo = null;
			else
				((Puntatore) p).link.successivo = ((Puntatore) p).link.successivo.link.successivo;
		}
	}

	/*
	 * Se si è alla fine della lista si solleva una IndexOutOfBoundsException
	 * altrimenti si assegna e al campo elemento di ((Puntatore)
	 * p).link.successivo
	 */
	public void writeList(Object e, Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");

		((Puntatore) p).link.successivo.link.elemento = e;
	}

}
