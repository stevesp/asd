package graphs;

public class NodoLA implements Nodo {
	
	Object info;
	Grafo grafo;
	
	public NodoLA(Object e, Grafo g) {
		grafo=g;
		info=e;
	}
	
}
