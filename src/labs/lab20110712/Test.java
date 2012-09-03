package labs.lab20110712;

import labs.lab20110712.tree.Albero;
import labs.lab20110712.tree.Nodo;
import labs.lab20110712.treep.AlberoP;
import labs.lab20110712.treep.NodoP;

public class Test {
	
	public static void main(String[] args){
		Albero<Integer> albero = buildTree();
		System.out.println(albero);
		
		albero = potaMinori(albero, 7);
		System.out.println(albero);
	}

	public static Albero<Integer> buildTree(){
		Albero<Integer> albero2 = new AlberoP<Integer>();
		albero2.aggiungiRadice(2);
		
		Albero<Integer> albero2413 = new AlberoP<Integer>();
		albero2413.aggiungiRadice(3);
		
		Albero<Integer> albero2415 = new AlberoP<Integer>();
		albero2415.aggiungiRadice(5);
		
		Albero<Integer> albero241 = new AlberoP<Integer>();
		albero241.aggiungiRadice(1);
		
		albero241.insPrimoSottoAlbero(albero241.radice(), albero2415);
		albero241.insPrimoSottoAlbero(albero241.radice(), albero2413);
		
		Albero<Integer> albero242 = new AlberoP<Integer>();
		albero242.aggiungiRadice(2);
		
		Albero<Integer> albero241Bis = new AlberoP<Integer>();
		albero241Bis.aggiungiRadice(1);
		
		Albero<Integer> albero24 = new AlberoP<Integer>();
		albero24.aggiungiRadice(4);
		
		albero24.insPrimoSottoAlbero(albero24.radice(), albero241Bis);
		albero24.insPrimoSottoAlbero(albero24.radice(), albero242);
		albero24.insPrimoSottoAlbero(albero24.radice(), albero241);

		Albero<Integer> albero23 = new AlberoP<Integer>();
		albero23.aggiungiRadice(3);
		
		albero2.insPrimoSottoAlbero(albero2.radice(), albero23);
		albero2.insPrimoSottoAlbero(albero2.radice(), albero24);
			
		return albero2;
	}
	
	public static Albero<Integer> potaMinori(Albero<Integer> tree, Integer s){
		
		Nodo<Integer> radice = tree.radice();
		
		previsita(tree, s, radice, 0);
		
		return tree;
	}

	private static void previsita(Albero<Integer> tree, Integer s,
			Nodo<Integer> nodo, Integer somma) {
		somma += ((NodoP<Integer>) nodo).getInfo();
		
		if(somma > s){
			tree.pota(nodo);
			return;
		}
		
		if(!tree.foglia(nodo)) {
			Nodo<Integer> t = tree.primoFiglio(nodo);
			while(!tree.fineFratelli(t)){
				previsita(tree, s, t, somma);
				t = tree.succFratello(t);
				
				if (t == null)
					return;
			}
			previsita(tree, s, t, somma);
		}
	}
	
}
