package objects;

import java.util.Random;

public class Studente implements Comparable<Object> {

	private static int matricolaCount = 0;
	private int matricola;
	private float mediaVoti;
	private int nroEsamiSostenuti;
	private int nroLodi;

	public Studente(float mediaVoti, int nroEsamiSostenuti, int nroLodi) {
		this.matricola = matricolaCount++;
		this.mediaVoti = mediaVoti;
		this.nroEsamiSostenuti = nroEsamiSostenuti;
		this.nroLodi = nroLodi;
	}

	/*
	 * Genera un Studente casuale
	 */
	public Studente() {
		this.matricola = matricolaCount++;
		this.mediaVoti = (float) (new Random().nextDouble() * 30.0);
		this.nroEsamiSostenuti = new Random().nextInt(20) + 1;
		this.nroLodi = new Random().nextInt(this.nroEsamiSostenuti) + 1;
	}

	public String toString() {
		return "MATRICOLA: " + matricola + " MEDIA VOTI: " + mediaVoti
				+ " NUMERO ESAMI SOSTENUTI: " + nroEsamiSostenuti
				+ " NUMERO LODI: " + nroLodi;
	}

	public float getMediaVoti() {
		return mediaVoti;
	}

	public int getNroEsamiSostenuti() {
		return nroEsamiSostenuti;
	}

	public int getNroLodi() {
		return nroLodi;
	}

	public int compareTo(Object o) {
		// Confronta usando come relazione d'ordine
		// o1 < o2 iff o1.mediaVoti <= o2.mediaVoti
		if (((Studente) o).getNroLodi() < this.nroLodi)
			return +1;
		else if (((Studente) o).getNroLodi() > this.nroLodi)
			return -1;
		return 0;
	}

	public static void main(String args[]) {
		Studente s[] = new Studente[4];
		s[0] = new Studente((float) 28.5, 10, 3);
		s[1] = new Studente((float) 24.5, 12, 5);
		s[2] = new Studente((float) 26.5, 15, 1);
		s[3] = new Studente((float) 22.5, 14, 4);

		int tempI = 0;
		for (int i = 1; i < s.length; i++)
			if (s[i].compareTo(s[tempI]) < 0)
				tempI = i;

		System.out.println(s[tempI]);
	}

}
