package labs.lab20090615;

import labs.lab20090615.lista.AOLista;
import labs.lab20090615.lista.EccezioneListaVuota;
import labs.lab20090615.lista.Posizione;
import labs.lab20090615.lista.WODoubleLinkedList;

public class Test {

	public static void main(String[] args){
		
		AOLista list1 = new WODoubleLinkedList();
		AOLista list2 = new WODoubleLinkedList();
		
		inizializza1(list1);
		inizializza2(list2);
		
		stampaSD(list1);
		System.out.println();
		stampaDS(list2);
		
		if(palindromo(list1))
			System.out.println("list1 è palindroma");
		
		if(palindromo(list2))
			System.out.println("list2 è palindroma");
	}
	
	public static void inizializza2(AOLista list){
		list.insert(new String("5"), list.firstList()); //=> 5
		list.insert(new String("4"), list.firstList()); //=> 4
		list.insert(new String("2"), list.firstList()); //=> 2
		list.insert(new String("1"), list.firstList()); //=> 1
		list.insert(new String("3"), list.pred(list.pred(list.pred(list.firstList())))); //=> 3
	}
	
	public static void inizializza1(AOLista list){		
		list.insert(new String("2"), list.firstList()); //=> 2
		list.insert(new String("2"), list.succ(list.firstList())); //=> 4
		list.insert(new String("3"), list.succ(list.firstList())); //=> 3
		list.insert(new String("1"), list.firstList()); //=> 1
		list.insert(new String("1"), list.pred(list.firstList())); //=> 5
	}
	
	public static void stampaSD(AOLista list){
		try {
			for(Posizione p = list.firstList(); !list.endList(p); p = list.succ(p))
				System.out.println(list.readList(p));
		} catch (EccezioneListaVuota e){
			System.out.println(e);
		}
	}
	
	public static void stampaDS(AOLista list){
		try {
			//for(Posizione p = list.pred(list.firstList()); p != list.firstList(); p = list.pred(p))
				//System.out.println(list.readList(p));
			for(Posizione p = list.pred(list.pred(list.firstList())); p != list.firstList(); p = list.pred(p))
				System.out.println(list.readList(p));
			System.out.println(list.readList(list.firstList()));
		} catch (EccezioneListaVuota e){
			System.out.println(e);
		}
	}
	
	public static boolean palindromo(AOLista list){
		try {
			Posizione p1 = list.firstList(), p2 = list.pred(list.pred(list.firstList()));
			int size = size(list); 
			System.out.println("size è "+size);
			
			for(int i=0; i<(size/2); i++){
				if (!list.readList(p1).equals(list.readList(p2)))
					return false;
				p1 = list.succ(p1);
				p2 = list.pred(p2);
			}
		} catch (EccezioneListaVuota e){
			System.out.println(e);
		}
		
		return true;
	}

	private static int size(AOLista list) {
		int size = 0;
		
		for(Posizione p = list.firstList(); !list.endList(p); p = list.succ(p))
			size++;
		
		return size;
	}
}
