package labs.lab20111115.dizionario;

import java.util.Iterator;

public class LinkedDict<S> implements Dictionary<S> {

	Record<S> inizio = null;
	Record<S> fine = null;
	
	class Record<S> {
 		public S elem;
 		public Comparable chiave;
 		public Record<S> next;

 		public Record(S e, Comparable k) {
			this.elem = e;
			this.chiave = k;
			this.next = null;
		}
 		
 		public String toString(){
 			return new String(this.elem +" "+ this.chiave);
 		}
	}
	
	@Override
	public Iterator<S> iterator() {
		return new LinkedDictIterator<S>(inizio);
	}
	
	public boolean isEmpty() {
		return this.inizio == null;
	}

	@Override
	public void insert(S e, Comparable k) {
		S esiste = search(k);
		
		if (esiste != null)
			throw new ListaEsistente("Lista già esistente");
			
		if (this.isEmpty())
			this.inizio = this.fine = new Record<S>(e,k);
		else {
			this.fine.next = new Record<S>(e,k);
			this.fine = this.fine.next;
		}
	}

	@Override
	public void delete(Comparable k) {
		if(isEmpty())
			throw new EccezioneStrutturaVuota();
		
		Record<S> q = null,p;
		for(p = inizio; p != null; p = p.next){
			if (p.chiave.compareTo(k) == 0){
				if (p == inizio)
					inizio = p.next;
				else if (p == fine){
					q.next = null;
					fine = q;
				} else
					q.next = p.next;
			}
			
			q = p;
		}
	}

	@Override
	public S search(Comparable k) {	
		Record<S> p;
		
		for(p = inizio; p != null; p = p.next){
			if (p.chiave.compareTo(k) == 0)
				return p.elem;
		}
		
		return null;
	}
}
