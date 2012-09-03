package labs.lab20120210.orologio;

import java.util.Iterator;

public class OrologioIterator<S> implements Iterator<S> {

	private Orologio<S> orologio;
	private int current;

	public OrologioIterator(Orologio<S> orologio) {
		this.orologio = orologio;
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return current < orologio.size();
	}

	@Override
	public S next() {		
		return orologio.array[current++];
	}

	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();		
	}

}
