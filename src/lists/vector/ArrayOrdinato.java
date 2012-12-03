package lists.vector;

import lists.Dizionario;
import lists.EccezioneChiaveDuplicata;
import lists.EccezioneChiaveNonValida;
import objects.Chiave;
import utils.Keyboard;

/**
 * La classe <code>ArrayOrdinato</code> implementa il tipo di dato Dizionario
 * mantenendo le coppie (elemento, chiave) in un array S in modo tale che coppie
 * consecutive abbiano chiavi non decrescenti, cioè che l'array sia ordinato in
 * base alle chiavi.
 */

public class ArrayOrdinato implements Dizionario {

	// array di coppie (elem,chiave)
	private Coppia[] S = new Coppia[0];

	/**
	 * Classe definita localmente alla classe <code>ArrayOrdinato</code> per il
	 * mantenimento delle coppie (elemento, chiave)
	 * 
	 */

	private class Coppia {
		public Object elem;
		public Comparable<Object> chiave;

		public Coppia(Object e, Comparable<Object> k) {
			this.elem = e;
			this.chiave = k;
		}

		public String toString() {
			return chiave.toString() + ":" + elem.toString();
		}
	}

	/**
	 * Rimuove dal dizionario l'elemento con chiave <code>k</code> (<font
	 * color=red>Tempo O(n)</font>). In caso di duplicati, l'elemento cancellato
	 * è scelto arbitrariamente tra quelli con chiave <code>k</code>. La ricerca
	 * dell'elemento da cancellare avviene mediante una scansione binaria
	 * dell'array.
	 * 
	 * @param k
	 *            chiave dell'elemento da cancellare
	 * @throws EccezioneChiaveNonValida
	 *             se la chiave ricercata non è presente nel dizionario
	 */

	public void delete(Comparable<Object> k) {
		int i = 0, j = S.length, pos = -1;
		Coppia[] temp = new Coppia[S.length - 1];

		while (i < j) {
			int m = (i + j) / 2;
			if (k.compareTo(S[m].chiave) == 0) {
				pos = m;
				break;
			} else if (k.compareTo(S[m].chiave) < 0) // ricerca in partizione a
														// sinistra di m
				j = m;
			else
				// ricerca in partizione a destra di m
				i = m + 1;
		}

		if (pos == -1)
			throw new EccezioneChiaveNonValida(k + " non trovato");

		for (i = 0; i < S.length - 1; i++) {
			if (pos == i)
				continue;
			temp[i] = S[i];
		}

		S = temp;
	}

	/**
	 * Aggiunge al dizionario la coppia <code>(e,k)</code> (<font
	 * color=red>Tempo O(n)</font>). L'inserimento viene realizzato
	 * incrementando di uno la taglia dell'array e collocando la nuova coppia in
	 * modo tale da rispettare la relazione di ordinamento.
	 * 
	 * @param e
	 *            elemento da mantenere nel dizionario
	 * @param k
	 *            chiave associata all'elemento
	 */

	public void insert(Object e, Comparable<Object> k)
			throws EccezioneChiaveDuplicata {

		if (search(k) != null)
			throw new EccezioneChiaveDuplicata(k + " è già presente");

		int i, j;
		// creare un vettore temp di dimensione S.length+1
		Coppia[] temp = new Coppia[S.length + 1];
		// copiare in temp S
		for (i = 0; i < S.length; i++)
			temp[i] = S[i];
		// assegnare ad S temp
		S = temp;
		// ricercale la posizione in cui inserire l'elemento e
		for (i = 0; i < S.length - 1; i++)
			if (k.compareTo(S[i].chiave) <= 0)
				break; // i corrisponde alla posizione in cui deve essere
						// inserito e
		for (j = S.length - 1; j > i; j--)
			S[j] = S[j - 1]; // shiftare a destra
		S[i] = new Coppia(e, k);
	}

	/**
	 * Restituisce l'elemento <code>e</code> con chiave <code>k</code> (<font
	 * color=red>Tempo O(log(n)</font>). In caso di duplicati, l'elemento
	 * restituito è scelto arbitrariamente tra quelli con chiave <code>k</code>.
	 * La ricerca dell'elemento con chiave <code>k</code> avviene utilizzando
	 * l'algoritmo di ricerca binaria.
	 * 
	 * @param k
	 *            chiave dell'elemento da ricercare
	 * @return elemento di chiave <code>k</code>, <code>null</code> se assente
	 */
	public Object search(Comparable<Object> k) {
		int i = 0;
		int j = S.length;

		while (i < j) {
			int m = (i + j) / 2;
			if (k.compareTo(S[m].chiave) == 0)
				return S[m].elem;
			else if (k.compareTo(S[m].chiave) < 0) // ricerca in partizione a
													// sinistra di m
				j = m;
			else
				// ricerca in partizione a destra di m
				i = m + 1;
		}

		return null;
	}

	@SuppressWarnings("unused")
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
			d.insert("Gennarino", new Chiave("08166321"));
		} catch (EccezioneChiaveDuplicata e) {
			System.out.println(e);
		}
		try {
			d.insert("Luca", new Chiave("08166321"));
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
		ArrayOrdinato rubrica = new ArrayOrdinato();

		String nome, numero;

		// inizializza(rubrica);

		boolean exit = false;

		while (!exit) {
			System.out.println("Cosa vuoi fare?");
			System.out.println("1. Inserire un elemento");
			System.out.println("2. Eliminare un elemento");
			System.out.println("3. Cercare un elemento");
			System.out.println("4. Esci");

			int k = Keyboard.readInt();

			switch (k) {
			case 1:
				System.out.println("|| Inserimento dell'elemento ||");
				System.out.println("Nome: ");
				nome = Keyboard.readString();
				System.out.println("Numero: ");
				numero = Keyboard.readString();
				try {
					rubrica.insert(nome, new Chiave(numero));
				} catch (EccezioneChiaveDuplicata e) {
					System.out.println(e);
				}
				System.out.println("Done");
				break;
			case 2:
				System.out.println("|| Eliminazione dell'elemento ||");
				System.out.println("Numero: ");
				numero = Keyboard.readString();
				try {
					rubrica.delete(new Chiave(numero));
				} catch (EccezioneChiaveNonValida e) {
					System.out.println(e);
				}
				System.out.println("Done");
				break;
			case 3:
				System.out.println("|| Ricerca di un elemento ||");
				System.out.println("Numero: ");
				numero = Keyboard.readString();
				try {
					System.out.println(rubrica.search(new Chiave(numero)));
				} catch (NullPointerException e) {
					System.out.println("Non trovato");
				}
				break;
			case 4:
				System.out.println("Bye!");
				exit = true;
				break;
			default:
				System.out.println("Cosa vuoi fare?");
				System.out.println("1. Inserire un elemento");
				System.out.println("2. Eliminare un elemento");
				System.out.println("3. Cercare un elemento");
				System.out.println("4. Esci");
			}
		}
	}

}
