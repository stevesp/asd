package lab20110712.treep;

import lab20110712.tree.Nodo;

public class NodoP<T> implements Nodo<T> {
	
	NodoP<T> primo, succ, padre;
	
	AlberoP<T> albero;
	
	T info;

	public NodoP(T info) {
		this.info = info;
	}

	public T getInfo(){
		return info;
	}
	
}
