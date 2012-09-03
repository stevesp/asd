package trees.vp;

import trees.Albero;
import trees.Nodo;

public class NodoVP implements Nodo{
	
	public Object info;
	
	public int indice;
	
	public Albero albero;
	
	public NodoVP(Object info) {
		this.info = info;
	}

	public String toString(){
		return info.toString();	
	}
}
