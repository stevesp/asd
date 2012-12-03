package trees.pffs;

import trees.Albero;
import trees.Nodo;

public class NodoPFFS implements Nodo {

	public Object info;
	public NodoPFFS padre, primo, succ;
	public Albero albero;

	public NodoPFFS(Object info) {
		this.info = info;
	}

	public String toString() {
		return info.toString();
	}
}
