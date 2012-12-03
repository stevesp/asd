package lists.listdoublelinked;

import lists.Lista;
import lists.Posizione;

public class ListDoubleLinkedExt implements Lista {

	private Entry listHead = new Entry(null);

	private class Entry implements Posizione {
		Object element;
		Entry successivo;
		Entry precedente;

		public Entry(Object e, Entry s, Entry p) {
			element = e;
			successivo = s;
			precedente = p;
		}

		public Entry(Object e) {
			element = e;
			successivo = precedente = this;
		}
	}

	public boolean endList(Posizione p) {
		if (isEmpty())
			return true;
		if (p == firstList())
			return listHead.successivo == listHead.precedente;
		else
			return ((Entry) p).successivo == listHead.precedente;
	}

	public Posizione firstList() {
		return null;
	}

	public boolean isEmpty() {
		return listHead.successivo == listHead;
	}

	public Object readList(Posizione p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return listHead.successivo.element;
		else
			return ((Entry) p).successivo.element;
	}

	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		if (p == firstList())
			return listHead.successivo;
		else
			return ((Entry) p).successivo;
	}

	public void writeList(Object e, Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(
					"Posizione fine lista non valida");
		((Entry) p).successivo.element = e;
	}

	public void insert(Object e, Posizione p) {
		Entry temp, q;

		if (!isEmpty()) {
			if (p == firstList()) {
				temp = listHead.successivo;
				q = new Entry(e);
				listHead.successivo = q;
				q.successivo = temp;
				temp.precedente = q;
				q.precedente = listHead;
			} else {
				temp = ((Entry) p).successivo;
				q = new Entry(e);
				((Entry) p).successivo = q;
				q.successivo = temp;
				temp.precedente = q;
				q.precedente = (Entry) p;
			}
		} else {
			// se la lista � vuota
			listHead.successivo = listHead.precedente = new Entry(e);
			listHead.successivo.successivo = listHead.successivo.precedente = listHead;
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
		if (p == firstList())
			throw new IndexOutOfBoundsException("Primo elemento");

		return ((Entry) p).precedente;
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

		if (p == firstList()) {
			listHead.successivo = ((Entry) succ(p)).successivo;
			listHead.successivo.precedente = listHead;
		} else if (endList((Entry) p)) {
			listHead.precedente = (Entry) pred(p);
			listHead.precedente.successivo = listHead;
		} else {
			((Entry) p).successivo = ((Entry) succ(p)).successivo;
			((Entry) p).successivo.precedente = ((Entry) p);
		}
	}

}
