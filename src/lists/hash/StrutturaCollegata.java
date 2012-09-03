package lists.hash;

import lists.Dizionario;
import lists.EccezioneChiaveDuplicata;
import lists.EccezioneChiaveNonValida;
import objects.Chiave;

public class StrutturaCollegata implements Dizionario {

	private Record list = null;
	
	private final class Record {
		public Object elem;
		public Comparable<Object> chiave;
		public Record next;
		public Record prev;	
		
		public Record(Object e, Comparable<Object> k) {
			elem = e;
			chiave = k;
			next = prev = null;
		}
   	}

	/*
	 * Contemplare i seguenti casi:
	 * 1. Il dizionario è vuoto: list == null. Solleva l'eccezione.
	 * 2. La chiave non è presente nel dizionario. Solleva l'eccezione.
	 * 3. L'elemento cercato è presente ed è l'unico della lista. Poni list a null.
	 * 4. L'elemento cercato è presente ed è il primo della lista. Aggiorna list.
	 * 5. L'elemento cercato è presente ed è successivo al primo. Aggiorna i puntatori del predecessore e del successore.
	 */
	@Override
	public void delete(Comparable<Object> k) throws EccezioneChiaveNonValida, DizionarioVuoto{
		Record p = null;
		if (list == null)
			throw new DizionarioVuoto("Il dizionario è vuoto");

		for (p = list.next; ; p = p.next){
			if (p.chiave.equals(k))
				break;
			if (p == list) {
				p = null;
				break;
			}
		}
	
		if (p == null)
			throw new EccezioneChiaveNonValida("Chiave non presente");
		
		if (p.next == p)
			list = null;
		else {
			if (list == p)
				list = p.next;
			p.next.prev = p.prev;
			p.prev.next = p.next;
		}
	}
	
	@Override
	public void insert(Object e, Comparable<Object> k) throws EccezioneChiaveDuplicata {
		if (search(k) != null)
			throw new EccezioneChiaveDuplicata("chiave già esistente");
		
		Record p = new Record(e, k);
        if (list == null)
            list = p.prev = p.next = p;
        else {
            p.next = list.next;
            list.next.prev = p;
            list.next = p;
            p.prev = list;
        }
	}

	@Override
	public Object search(Comparable<Object> k) {
		if (list == null)
			return null;
		for (Record p = list.next; ; p = p.next){
			if (p.chiave.equals(k)) 
				return p.elem;
			if (p == list) 
				return null;
		}
	}
	
	private static void inizializza(Dizionario d) {
		try {
			d.insert("Pippo", new Chiave("080123456"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Giò", new Chiave("080654321"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Lisa", new Chiave("081123456"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Gennarino", new Chiave("081654321"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Emy", new Chiave("347112233"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		Dizionario rubrica = new StrutturaCollegata();
		inizializza(rubrica);
		
		System.out.println(rubrica.search(new Chiave("081654321")));
		
		try {
			rubrica.delete(new Chiave("081654321"));
		} catch (DizionarioVuoto e){
			System.out.println(e);			
		} catch (EccezioneChiaveNonValida e){
			System.out.println(e);
		}
		
		System.out.println(rubrica.search(new Chiave("081654321")));
		
		try {
			rubrica.delete(new Chiave("081654321"));
		} catch (DizionarioVuoto e){
			System.out.println(e);			
		} catch (EccezioneChiaveNonValida e){
			System.out.println(e);
		}

		try {
			rubrica.delete(new Chiave("080123456"));
		} catch (DizionarioVuoto e){
			System.out.println(e);			
		} catch (EccezioneChiaveNonValida e){
			System.out.println(e);
		}
			
		try {
			rubrica.delete(new Chiave("081123456"));
		} catch (DizionarioVuoto e){
			System.out.println(e);			
		} catch (EccezioneChiaveNonValida e){
			System.out.println(e);
		}
			
		try {
			rubrica.delete(new Chiave("347112233"));
		} catch (DizionarioVuoto e){
			System.out.println(e);			
		} catch (EccezioneChiaveNonValida e){
			System.out.println(e);
		}
			
		try {
			rubrica.delete(new Chiave("080654321"));	
		} catch (DizionarioVuoto e){
			System.out.println(e);			
		} catch (EccezioneChiaveNonValida e){
			System.out.println(e);
		}
	}

}
