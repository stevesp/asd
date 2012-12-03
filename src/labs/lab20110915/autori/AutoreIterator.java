package labs.lab20110915.autori;

import java.util.Iterator;

public class AutoreIterator implements Iterator<Autore> {

	private Autori ref;

	private int cont;

	public AutoreIterator(Autori autori) {
		this.ref = autori;
		this.cont = 0;
	}

	@Override
	public boolean hasNext() {
		return this.cont < this.ref.size;
	}

	@Override
	public Autore next() {
		return ref.data[cont++];
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
