package lab20100902.abrpf;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ABRPFIterator implements Iterator<Comparable> {

	private List<Nodo> list;
	private int i;
	
	public ABRPFIterator(Nodo radice) {;
		this.list = new LinkedList<Nodo>();
		this.i = 0;
				
		invisita(radice);
	}

	private void invisita(Nodo nodo) {
		if(nodo.sin != null)
			invisita(nodo.sin);
		
		list.add(nodo);

		if (nodo.des != null)
			invisita(nodo.des);
	}

	@Override
	public boolean hasNext() {
		return i < list.size();
	}

	@Override
	public Comparable next() {
		return list.get(i++).valore;
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
