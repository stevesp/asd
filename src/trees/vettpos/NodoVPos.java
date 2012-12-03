package trees.vettpos;

import trees.Albero;
import trees.Nodo;

public class NodoVPos implements Nodo, Cloneable {

	Object info;
	int indice;
	int arita;
	Albero albero;

	public NodoVPos(Object info) {
		this.info = info;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String toString() {
		return info.toString();
	}
}
