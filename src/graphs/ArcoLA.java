package graphs;

public class ArcoLA implements Arco {

	Nodo src;
	Nodo dst;
	Object info;

	public ArcoLA(Nodo x, Nodo y, Object e) {
		src = x;
		dst = y;
		info = e;
	}

}
