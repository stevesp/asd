package lists.vector;

import lists.Dizionario;
import lists.EccezioneChiaveDuplicata;
import lists.EccezioneChiaveNonValida;
import objects.Chiave;

public class ArrayDoubling implements Dizionario {

	// array di coppie (elem,chiave)
	private Coppia[] S= new Coppia[1];
	private int n = 0;
	
	// classe Coppia
    private class Coppia {
        public Object elem;
        public Comparable<Object> chiave;
        
        public Coppia(Object e, Comparable<Object> k) {
            this.elem = e;
            this.chiave = k;
        }
        
        public String toString(){
        	return chiave.toString()+ ":"+elem.toString();
        }
    }

	/*
	 * Sia i la posizione dell'elemento di S con chiave k, 
	 * tale elemento può essere sovrascritto con l'elemento di S in posizione (n-1), 
	 * decrementando poi n di uno ed eventualmente  (se n<S.length/4) dimezzando l'array.
	 * Sollevare la eccezione EccezioneChiaveNonValida se la chiave k non appartien ad S
	 */
    @Override
    public void delete(Comparable<Object> k){
    	int pos=-1;
    	
    	for(int i=0; i<n; i++)
			if(k.compareTo(S[i].chiave)==0){
				pos = i;
    			break;
			}
    	
		if(pos==-1)
			throw new EccezioneChiaveNonValida("Non trovato");
		
		n--;
		S[pos]=S[n];
		
		if((n>1) && (n<=(S.length/4))){
			Coppia[] temp = new Coppia[S.length/2];
			for (int i=0; i<n; i++)
				temp[i] = S[i];
			S = temp;
		}
	}

	/*
	 * Previo eventuale raddoppiamento dell'array, 
	 * ogni nuovo elemento viene inserito nella cella di indice n, 
	 * e poi si incrementa n di uno.
	 */
    @Override
    public void insert(Object e, Comparable<Object> k) throws EccezioneChiaveDuplicata {
		
		if (search(k)!=null)
			throw new EccezioneChiaveDuplicata(k +"è già presente");

		if (n == S.length) {
			//raddoppiare dimensione di S
			Coppia[] temp = new Coppia[2 * S.length];
			for (int i = 0; i < n; i++) temp[i] = S[i];
			S = temp;
		}
		//mettere in coda la nuova coppia
		S[n] = new Coppia(e, k);
		n++;
	}

	@Override
	public Object search(Comparable<Object> k) {
		for(int i=0; i<n; i++)
			if(k.compareTo(S[i].chiave)==0)
				return S[i].elem;
		return null;
	}
		
	private static void inizializza(Dizionario d) {
		
		try {
			d.insert("Pippo", new Chiave("080123456"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Giò", new Chiave("081654321"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Lisa", new Chiave("081123456"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Gennarino", new Chiave("08166321"));
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
		Dizionario rubrica = new ArrayDoubling();
		
		inizializza(rubrica);

		System.out.println(rubrica.search(new Chiave("081654321")));
		rubrica.delete(new Chiave("081654321"));
		System.out.println(rubrica.search(new Chiave("081654321")));
		try {
			rubrica.delete(new Chiave("081654321"));
		} catch (Exception e) {
			System.out.println(e);
		}	
	 }

}
