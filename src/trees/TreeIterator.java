package trees;

import java.util.Iterator;
import java.util.LinkedList;

public class TreeIterator implements Iterator {
	private Albero t;
	private tipoVisita tipo=tipoVisita.PRE;
 	private LinkedList<Nodo> tree=new LinkedList<Nodo>();
 	private int i=-1;
 	
 	private void previsita( Nodo u){
		tree.add(u);
		if (!t.foglia(u)) {
	       Nodo v=t.primoFiglio(u);
	       while (!t.fineFratelli(v)) {
	                previsita(v);
	                v =t.succFratello(v);
	       }
	       previsita(v);
		}
	}
 	
 	private void postvisita( Nodo u){
		if (!t.foglia(u)) {
	       Nodo v=t.primoFiglio(u);
	       while (!t.fineFratelli(v)) {
	                postvisita(v);
	                v =t.succFratello(v);
	       }
	       postvisita(v);
		}
		tree.add(u);
 	}
 	
 	private void invisita( Nodo u){
 		if(t.foglia(u))
 			tree.add(u);
 		else {
 			Nodo v=t.primoFiglio(u);
 			invisita(v);
 			tree.add(v);
 			while(!t.fineFratelli(v)) {
 				v=t.succFratello(v);
 				invisita(v);
 			}
 		}
 	}
 	
 	/* Cambia il tipo di visita */
 	public void setVisita(tipoVisita v){
 		if(v!=tipo){
 			tipo=v;
 			tree=new LinkedList<Nodo>();
 			if (tipo==tipoVisita.PRE)
 				previsita(t.radice());
 			else
 				if(tipo==tipoVisita.POS)
 					postvisita(t.radice());
 				else
 					if(tipo==tipoVisita.IN)
 						invisita(t.radice());
 			}
 		}
 		
 	public TreeIterator(Albero t) {
 		this.t=t;
		if(!t.alberoVuoto()){ //default per esplorare la visita
			previsita(t.radice());
		}
	}
	
	public boolean hasNext() {		
		return (i<tree.size()-1);
	}

	@Override
	public Object next() {
		i++;
		return tree.get(i);
	}

	public void remove() throws UnsupportedOperationException{
		//list.remove(p);
		throw new UnsupportedOperationException();
	} 
}
