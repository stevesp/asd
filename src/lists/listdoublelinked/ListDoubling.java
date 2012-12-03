package lists.listdoublelinked;

import java.util.Iterator;

import lists.Lista;
import lists.Posizione;

public class ListDoubling implements Lista, Iterable<Object> {

	private Object[] L = new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public boolean endList(Posizione p) {
		return ((Indice) p).indice == n;
	}

	@Override
	public Posizione firstList() {
		return new Indice();
	}

	@Override
	public Posizione succ(Posizione p) {
		if (endList(p))
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ " e' ultima posizione della lista");

		Posizione pos = new Indice();
		((Indice) pos).indice = ((Indice) p).indice + 1;
		return pos;
	}

	protected boolean checkPosition(Posizione p) {
		if (((Indice) p).indice < 0 || ((Indice) p).indice > n)
			return false;
		else
			return true;
	}

	@Override
	public Object readList(Posizione p) {
		if (!checkPosition(p) && !endList(p))
			throw new IndexOutOfBoundsException("posizione non valida");
		return L[((Indice) p).indice];
	}

	@Override
	public void insert(Object e, Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(
					"Posizione di inserimento non valida");

		for (int i = n; i > ((Indice) p).indice; i--)
			L[i] = L[i - 1];
		L[((Indice) p).indice] = e;
		n++;
		if (n == L.length) {
			Object[] temp = new Object[2 * L.length];
			for (Indice pos = (Indice) firstList(); !endList(pos); pos = (Indice) succ(pos))
				temp[pos.indice] = L[pos.indice];
			L = temp;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Lista#pred(Posizione) se p coincide con la posizione del primo
	 * elemento della lista sollevo IndexOutOfBoundsException altrimenti
	 * restituisco la posizione antecedente a p
	 */
	@Override
	public Posizione pred(Posizione p) {
		if (firstList().equals(p))
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ " è la prima posizione della lista");

		Posizione pos = new Indice();
		((Indice) pos).indice = ((Indice) p).indice - 1;
		return pos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Lista#remove(Posizione) Se la posizione p non è valida sollevo una
	 * IndexOutOfBoundsException altrimenti 1. cancello l'elemento in posizione
	 * ((Indice)p).indice di L (usare shift a sinistra) 2. decremento n 3.
	 * eventualmente dimezzo L in accordo alla tecnica del
	 * raddoppiamento/dimezzamento
	 */
	@Override
	public void remove(Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ "posizione non valida");
		for (int i = ((Indice) p).indice; i < n; i++)
			L[i] = L[i + 1];
		L[n] = null;
		n--;

		if ((n > 1) && (n <= (L.length / 4))) {
			Object[] temp = new Object[L.length / 2];
			for (Indice pos = (Indice) firstList(); !endList(pos); pos = (Indice) succ(pos))
				temp[pos.indice] = L[pos.indice];
			L = temp;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Lista#writeList(java.lang.Object, Posizione) Se la posizione p non è
	 * valida sollevo una IndexOutOfBoundsException altrimenti scrivo in
	 * posizione ((Indice)p).indice di L l'elemento e
	 */
	@Override
	public void writeList(Object e, Posizione p) {
		if (!checkPosition(p))
			throw new IndexOutOfBoundsException(((Indice) p).indice
					+ "posizione non valida");

		L[((Indice) p).indice] = e;
	}

	@Override
	public Iterator<Object> iterator() {
		return new DoublingIterator(this);
	}
}
