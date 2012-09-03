package graphs;

import java.util.LinkedList;

public class linkedList implements Lista {
	
	LinkedList<Object> lista = new LinkedList<Object>();

	@Override
	public void insert(Nodo n) {
		lista.addFirst(n);
	}

	@Override
	public Nodo leggi(int i) {
		return (Nodo) lista.get(i);
	}

	@Override
	public int length() {
		return lista.size();
	}

}
