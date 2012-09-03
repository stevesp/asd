package lab20110614.dizionario;

import java.util.Iterator;

public class ArrayOrdinatoIterator<S> implements Iterator<S> {
	
	private Coppia<S>[] lista;
	private int n;
	private int current;

	public ArrayOrdinatoIterator(Coppia<S>[] element, int size){
		this.lista = element;
		this.n = size;
		this.current = 0;
	}

	@Override
	public boolean hasNext() {
		return n < current;
	}

	@Override
	public S next() {
		return lista[current++].elem;
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();	
	}
}
