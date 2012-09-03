package labs.lab20110712.treep;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import labs.lab20110712.tree.Albero;
import labs.lab20110712.tree.Nodo;
import labs.lab20110712.tree.Tipovisita;

public class AlberoPIterator<T> implements Iterator<T> {
		
	private Albero<T> ref;
	private List<Nodo<T>> list;
	private int i;

	public AlberoPIterator(Albero<T> ref, Tipovisita tipo) {
		this.ref = ref;
		this.list = new LinkedList<Nodo<T>>();
		this.i = 0;
		
		switch (tipo) {
		case PREVISITA:
			previsita(ref.radice());
			break;
		case INVISITA:
			invisita(ref.radice());
			break;
		case POSTVISITA:
			postvisita(ref.radice());
			break;
		default:
			break;
		}
	}

	private void postvisita(Nodo<T> nodo) {
		if(ref.foglia(nodo))
			return;
		
		Nodo<T> v = ref.primoFiglio(nodo);
		while(!ref.fineFratelli(v)){
			postvisita(v);
			v = ref.succFratello(v);
		}
		postvisita(v);
		
		list.add(nodo);
	}

	private void invisita(Nodo<T> nodo) {
		if(ref.foglia(nodo))
			list.add(nodo);
		else {
			Nodo<T> v = ref.primoFiglio(nodo);
			invisita(v);
			list.add(v);
			while(!ref.fineFratelli(v)){
				v = ref.succFratello(v);
				invisita(v);
			}
		}		
	}

	private void previsita(Nodo<T> nodo) {
		list.add(nodo);
		
		if(ref.foglia(nodo))
			return;
		
		Nodo<T> v = ref.primoFiglio(nodo);
		while(!ref.fineFratelli(v)){
			previsita(v);
			v = ref.succFratello(v);
		}
		previsita(v);
	}

	@Override
	public boolean hasNext() {
		return i < list.size();
	}

	@Override
	public T next() {
		return ((NodoP<T>) list.get(i++)).info;
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
