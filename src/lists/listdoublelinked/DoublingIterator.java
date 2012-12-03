package lists.listdoublelinked;

import java.util.Iterator;

class DoublingIterator implements Iterator<Object> {
	private ListDoubling list;
	private Indice p;

	DoublingIterator(ListDoubling l) {
		list = l;
		p = (Indice) l.firstList();
	}

	/*
	 * @see java.util.Iterator#remove() Returns true if the iteration has more
	 * elements.
	 */
	public boolean hasNext() {
		return !list.endList(p);
	}

	/*
	 * @see java.util.Iterator#remove() Returns the next element in the
	 * iteration.
	 */
	public Object next() {
		Indice q = p;
		p = (Indice) list.succ(p);
		return list.readList(q);
	}

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
