package labs.lab20100916.pilacollegata;

import java.util.Iterator;

public class PilaCollegataIterator<T> implements Iterator<T> {

	private Puntatore current;

	public PilaCollegataIterator(Puntatore firstList) {
		this.current = firstList;
	}

	@Override
	public boolean hasNext() {
		return current.link.successivo != null;
	}

	@Override
	public T next() {
		Puntatore tmp = current;
		current = current.link.successivo;
		return (T) tmp.link.elem;
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
