package lab20100222.listaarray;

import java.util.Iterator;

public class ListaArrayIterator<T> implements Iterator<T> {

	private ListaArray<T> list;
	private int index;
	
	public ListaArrayIterator(ListaArray<T> list) {
		this.list = list;
		this.index = 0;
		
		//trovo il primo elemento non null
		//FIXME
		while(list.getElement(index) == null){
			if(index > list.elements.length)
				break;
			index++;
		}
	}

	@Override
	public boolean hasNext() {
		return index < list.elements.length;
	}

	@Override
	public T next() {
		T tmp = list.getElement(index);
		index++;
		while(list.getElement(index) == null){
			if(index > list.elements.length)
				break;
			index++;
		}
		
		return tmp;
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();		
	}

}
