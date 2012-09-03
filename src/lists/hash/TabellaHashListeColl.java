package lists.hash;

import objects.Chiave;
import lists.Dizionario;

public class TabellaHashListeColl implements Dizionario {

	StrutturaCollegata S[];
	Hash fHash;
	
	TabellaHashListeColl(Hash f, int n){
		fHash=f;
		S= new StrutturaCollegata[n];
	}

	@Override
	public void delete(Comparable<Object> k) {
		int pos=fHash.h(k, S.length);
		
		if(S[pos]==null)
			return;
		
		S[pos].delete(k);
	}

	@Override
	public void insert(Object e, Comparable<Object> k) {
		int pos=fHash.h(k, S.length);
		
		if (S[pos]==null)
			S[pos]=new StrutturaCollegata();
		
		S[pos].insert(e, k);
	}

	@Override
	public Object search(Comparable<Object> k) {
		int pos=fHash.h(k, S.length);
		
		if (S[pos]!=null)
			return S[pos].search(k);
		
		return null;
	}
	
	private static void inizializza(Dizionario d) {
		d.insert("Pippo", new Chiave("080123456"));
		d.insert("Giò", new Chiave("080654321"));
		d.insert("Lisa", new Chiave("081123456"));
		d.insert("Gennarino", new Chiave("081654321"));
		d.insert("Emy", new Chiave("347112233"));
	}
	
	public static void main(String[] args) {
		Dizionario rubrica = new TabellaHashListeColl(new HashDivisione(), 3);
		inizializza(rubrica);
		System.out.println(rubrica.search(new Chiave("080123456")));
		System.out.println(rubrica.search(new Chiave("081654321")));
		System.out.println(rubrica.search(new Chiave("081123456")));
		System.out.println(rubrica.search(new Chiave("081654321")));
		System.out.println(rubrica.search(new Chiave("347112233")));
		System.out.println(rubrica.search(new Chiave("347122233")));	
	}
}
