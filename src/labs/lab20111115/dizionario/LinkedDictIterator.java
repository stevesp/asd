package labs.lab20111115.dizionario;

import java.util.Iterator;

import labs.lab20111115.dizionario.LinkedDict.Record;

public class LinkedDictIterator<S> implements Iterator<S> {
    private Record current;
	
	public LinkedDictIterator(Record inizio) {
        this.current = inizio;
	}
	
	@Override
	public boolean hasNext() {
		return this.current != null;
	}

	@Override
	public S next() {
		Record tmp = this.current;
		this.current = this.current.next;
		return (S) tmp.elem;
	}

	@Override
	public void remove() throws UnsupportedOperationException{	
		throw new UnsupportedOperationException();
	}		
}
