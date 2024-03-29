package lists.hash;

import lists.Dizionario;
import lists.EccezioneChiaveNonValida;
import objects.Chiave;

public class TabellaHashAperta implements Dizionario {

	// array di coppie (elem,chiave)
	private Coppia[] S;
	private Hash hFun;
	private Scansione cFun;

	public TabellaHashAperta(int n, Hash hFun, Scansione cFun) {
		S = new Coppia[n];
		this.hFun = hFun;
		this.cFun = cFun;
	}

	// classe Coppia
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

	@Override
	public void delete(Comparable<Object> k) throws EccezioneChiaveNonValida {
		int hk = hFun.h(k, S.length);

		for (int i = 0; i < S.length; i++) {
			int pos = cFun.c(hk, i, S.length);
			if (S[pos] == null)
				break;
			if (S[pos].chiave.compareTo(k) == 0) {
				S[pos] = null;
				return;
			}
		}

		throw new EccezioneChiaveNonValida(k + " NON TROVATA");
	}

	@Override
	public void insert(Object e, Comparable<Object> k)
			throws EccezioneArrayPieno {
		int hk = hFun.h(k, S.length);

		for (int i = 0; i < S.length; i++) {
			int pos = cFun.c(hk, i, S.length);
			if (S[pos] == null) {
				S[pos] = new Coppia(e, k);
				return;
			}
		}

		throw new EccezioneArrayPieno(k + ":Array pieno");
	}

	@Override
	public Object search(Comparable<Object> k) throws DizionarioVuoto,
			EccezioneChiaveNonValida {
		int hk = hFun.h(k, S.length);

		for (int i = 0; i < S.length; i++) {
			int pos = cFun.c(hk, i, S.length);
			if (S[pos] == null)
				throw new DizionarioVuoto("nessun elemento memorizzato");
			if (S[pos].chiave.compareTo(k) == 0)
				return S[pos].elem;
		}

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
		Dizionario rubrica = new TabellaHashAperta(4, new HashDivisione(),
				new ScansioneLineare());

		try {
			inizializza(rubrica);
		} catch (EccezioneArrayPieno e) {
			System.out.println(e);
		}

		System.out.println(rubrica.search(new Chiave("081654321")));
		System.out.println(rubrica.search(new Chiave("081654323")));
		System.out.println(rubrica.search(new Chiave("081123456")));
	}

}
