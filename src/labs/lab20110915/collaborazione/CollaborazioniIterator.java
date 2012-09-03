package lab20110915.collaborazione;

import java.util.Iterator;

public class CollaborazioniIterator implements Iterator<Collaborazione> {
	
	private Collaborazioni c;
	private int current;

	public CollaborazioniIterator(Collaborazioni c){
		this.current = 0;
		this.c = c;
	}
	
	@Override
	public boolean hasNext() {
		return this.current < this.c.archi.length;
	}

	@Override
	public Collaborazione next() {
		return this.c.archi[current++];
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
