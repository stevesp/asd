package lab20090216.listawo;

import java.util.Iterator;

public class WOListLinkedIterator implements Iterator<Comparable> {

	private Puntatore current;
	
	public WOListLinkedIterator(Puntatore inizioLista) {
		this.current = inizioLista;
	}
	
	@Override
	public boolean hasNext() {
		return this.current.link.successivo != null;
	}

	@Override
	public Comparable next() {
		Puntatore tmp = this.current;
		this.current = this.current.link.successivo;
		return tmp.link.elemento;
	}

	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

}
