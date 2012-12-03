package labs.lab20110915.collaborazione;

import java.util.Calendar;
import java.util.GregorianCalendar;

import labs.lab20110915.autori.Autore;

public class Collaborazione implements Comparable<Collaborazione> {

	Autore autoreA, autoreB;
	String titolo;
	int anno;

	public Collaborazione(Autore a, Autore b, String titolo, int anno)
			throws EccezioneStessoAutore, EccezioneAnnoNonValido {
		if (a.compareTo(b) == 0)
			throw new EccezioneStessoAutore("Gli autori devono essere distinti");

		this.autoreA = a;
		this.autoreB = b;
		this.titolo = titolo;

		int currentYear = GregorianCalendar.getInstance().get(Calendar.YEAR);
		if (currentYear < anno)
			throw new EccezioneAnnoNonValido("Siamo ancora nel " + currentYear);
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "[" + autoreA + ", " + autoreB + ", " + titolo + ", " + anno
				+ "]";
	}

	@Override
	public int compareTo(Collaborazione c) {
		return this.toString().compareTo(c.toString());
	}
}
