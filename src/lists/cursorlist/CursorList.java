package lists.cursorlist;

import exceptions.EccezioneStrutturaVuota;
import lists.Lista;
import lists.Posizione;

public class CursorList implements Lista {

	public static final int MAXLUNG = 100;

	/*
	 * La variabile di classe spazio rappresenta l'area di memoria unica in cui verranno memorizzate le diverse liste
	 * 
	 */
	private static Cella[] spazio = new Cella[MAXLUNG];

	/*
	 * Inizializza l'area di memoria unica assegnata a spazio, in maniera tale che il cursore di ciascuna cella
	 * consenta di raggiungere la cella successiva
	 */
	static {
		int i;
		//Il cursore della cella in posizione spazio.length - 1 non punta a nulla
		spazio[0] = (new CursorList()).new Cella(null, new Cursore(0));
		for (i = 1; i < spazio.length - 1; i++) {
			spazio[i] = (new CursorList()).new Cella(new Object(), new Cursore(i + 1));
		}
		//Il cursore della cella in posizione spazio.length - 1 non punta a nulla
		spazio[i] = (new CursorList()).new Cella(null, new Cursore(0));
	}

	private class Cella {
		public Object elemento;
		public Cursore successivo;

		public Cella(Object elemento, Cursore successivo) {
			this.elemento = elemento;
			this.successivo = successivo;
		}
	}

	private static Cursore listalibera = new Cursore(1);
	private Cursore inizioLista = null;

	public boolean endList(Posizione p) {
		int indice = ((Cursore) p).cursore;
		
		if (isEmpty())
			return true;
		else if (indice == 0)
			return false;
		else
			return spazio[indice].successivo.cursore == 0;
	}

	public Posizione firstList() {
		return new Cursore(0);
	}
	
	public boolean isEmpty() {
		return inizioLista == null;
	}

	public Posizione succ(Posizione p) {
		int indice = ((Cursore) p).cursore;
		
		if (endList(p))
			throw new IndexOutOfBoundsException("Fine lista");
		
		if (indice == 0)
			return inizioLista;
		else
			return spazio[indice].successivo;
	}

	public Posizione pred(Posizione p) {
		int indice = ((Cursore) p).cursore;
		
		if (indice == 0)
			throw new IndexOutOfBoundsException("Inizio Lista");
		
		Posizione prec = firstList();
		if (indice == inizioLista.cursore)
			return prec;
		while (!endList(prec)) {
			if (((Cursore) succ(prec)).cursore == indice)
				return prec;
			else
				prec = succ(prec);
		}
		throw new IndexOutOfBoundsException("Posizione non valida");
	}

	public void insert(Object e, Posizione p) {
		int indice = ((Cursore) p).cursore;
		int primaPosLibera = listalibera.cursore;
		Cursore temp;
		if (!isEmpty()) {
			temp = spazio[primaPosLibera].successivo;
			spazio[primaPosLibera].elemento = e;
			if (indice == 0){
				spazio[primaPosLibera].successivo = inizioLista;
				inizioLista = listalibera;
			} else {
				spazio[primaPosLibera].successivo = spazio[indice].successivo;
				spazio[indice].successivo = listalibera;
			}	
 			listalibera=temp;
		} else {
			// lista vuota
			inizioLista = listalibera;
			listalibera = spazio[primaPosLibera].successivo;
			spazio[primaPosLibera].elemento = e;
			spazio[primaPosLibera].successivo = new Cursore(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see Lista#readList(Posizione)
	 * Restituisce l'elemento in posizione p di spazio 
	 */
	public Object readList(Posizione p) {
		int indice = ((Cursore) p).cursore;
		
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Lista vuota");
		
		if (indice == 0)
			return spazio[inizioLista.cursore].elemento;
		
		return spazio[spazio[indice].successivo.cursore].elemento;
	}

	/*
	 * (non-Javadoc)
	 * @see Lista#writeList(Posizione)
	 * Rimpiazza l'elemento della cella in posizione p di spazio con e
	 */
	public void writeList(Object e, Posizione p) {
		int indice = ((Cursore) p).cursore;

		if (isEmpty())
			throw new EccezioneStrutturaVuota("Lista vuota");
		
		if (indice == 0)
			spazio[inizioLista.cursore].elemento = e;
		else {
			Cursore temp = (Cursore) this.succ(p);
			spazio[temp.cursore].elemento = e;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see Lista#remove(Posizione)
	 * Si distinguono due casi
	 * caso 1: p è la posizione del primo elemento nella lista
	 * 		1) modificare inizioLista in modo che corrisponda alla cella di spazio in posizione successiva a quella che si sta rimuovento
	 * 		2) modificare listalibera in modo che parta da p
	 * caso 2: p non è la posizione del primo elemento della lista 
	 * 		1) usare l'operatore pred per determinare la posizione dell'elemento precedente a quello in posizione p nella lista (denotarla come temp)
	 * 		2) fare in modo che la cella in posizione temp di spazio abbia come successiva la cella che è attualmente successiva a quella che è in posizione p
	 * 		3) modificare listaLibera in modo che abbia come posizione di inizio p
	 */
	public void remove(Posizione p) {
		int indice = ((Cursore) p).cursore;

		if (isEmpty())
			throw new EccezioneStrutturaVuota("Lista vuota");
		
		Cursore temp = null;
		if (indice == 0) {
			temp = inizioLista;
			inizioLista = spazio[inizioLista.cursore].successivo;
			spazio[temp.cursore].successivo = listalibera;
		} else {
			temp = ((Cursore) this.succ(p));
			spazio[indice].successivo = spazio[temp.cursore].successivo;
			spazio[temp.cursore].successivo = listalibera;
		}
		listalibera = temp;
	}
}
