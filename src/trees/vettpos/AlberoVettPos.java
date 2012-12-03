package trees.vettpos;

import java.util.Iterator;

import trees.Albero;
import trees.AlberoVuotoException;
import trees.EccezioneNodoEsistente;
import trees.EccezioneNodoInvalido;
import trees.Nodo;
import trees.TreeIterator;

public class AlberoVettPos implements Albero, Iterable {

	public NodoVPos[] P = new NodoVPos[0];

	private int d;

	public AlberoVettPos(int arita) throws AritaNonValidaException {
		if (arita < 2)
			throw new AritaNonValidaException("arità non valida");
		this.d = arita;
	}

	public boolean alberoVuoto() {
		return P.length == 0;
	}

	private boolean checkNode(Nodo v) throws EccezioneNodoInvalido {
		if (v == null)
			return true;
		if (((NodoVPos) v).albero != this)
			return true;
		return false;
	}

	public void cambiaInfo(Nodo v, Object info) throws EccezioneNodoInvalido {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		((NodoVPos) v).info = info;
	}

	public Object info(Nodo v) {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		return ((NodoVPos) v).info;
	}

	public Nodo padre(Nodo v) throws EccezioneNodoInvalido {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		// pos(i)=(d(p-1) + i+1)
		// p=(pos(i) - i -1)/d +1 con i=v.arita e pos(i)=v.indice
		if (radice() == v)
			return null;
		int posPadre = ((((NodoVPos) v).indice - ((NodoVPos) v).arita - 1) / d) + 1;
		return P[posPadre];
	}

	public Nodo primoFiglio(Nodo v) throws EccezioneNodoInvalido,
			EccezioneNodoInesistente {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		// (d(p-1) + i+1)
		int posPrimoFiglio = d * ((((NodoVPos) v).indice) - 1) + 1 + 1;
		if (posPrimoFiglio >= P.length)
			throw new EccezioneNodoInesistente();
		NodoVPos primoFiglio = P[posPrimoFiglio];
		if (primoFiglio == null)
			throw new EccezioneNodoInesistente();
		return primoFiglio;
	}

	public boolean foglia(Nodo v) throws EccezioneNodoInvalido {
		// verifico se ha figli (se la posizione del primo figlio restituisce un
		// nodo)
		try {
			primoFiglio(v);
			return false;
		} catch (EccezioneNodoInvalido e) {
			throw new EccezioneNodoInvalido();
		} catch (EccezioneNodoInesistente e) {
			return true;
		}
	}

	public Nodo radice() {
		if (alberoVuoto())
			throw new AlberoVuotoException("Albero vuoto");
		return P[1];
	}

	public void insRadice(Object info) throws EccezioneNodoEsistente {
		if (!alberoVuoto())
			throw new EccezioneNodoEsistente();
		P = new NodoVPos[2];
		NodoVPos nodo = new NodoVPos(info);
		nodo.albero = this;
		nodo.indice = 1;
		nodo.arita = -1;
		P[1] = nodo;
	}

	public boolean fineFratelli(Nodo v) {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		if (((NodoVPos) v).arita == d)
			return true;
		if ((((NodoVPos) v).indice + 1) < P.length)
			if (P[((NodoVPos) v).indice + 1] == null)
				return true;
		if (radice() == v)
			return true;
		return false;
	}

	/*
	 * Profondità del nodo u nell'albero
	 */
	private int profondita(Nodo u) {
		int uIndice = ((NodoVPos) u).indice;
		int i = 1;
		int inizioPos = 1;
		if (uIndice == inizioPos)
			return 0;
		inizioPos = 2;
		while (true) {
			int finePos = inizioPos + (int) Math.pow(d, i);
			if (inizioPos <= uIndice && uIndice < finePos)
				return i;
			inizioPos = finePos;
		}
	}

	/*
	 * Massima profondità dell'albero: la radice è a profondità 0
	 */
	private int maxProfondita() {
		return (int) (Math.log(P.length) / Math.log(d));
	}

	// Shif a destra del sottoalbero radicato nel nodo in posizione i (la radice
	// è già stata spostata
	private void shiftDestraSottoAlbero(int iPadre, int spostamento) {
		if (!foglia(P[iPadre])) {
			Nodo u = primoFiglio(P[iPadre]);
			int primoIndice = ((NodoVPos) u).indice;
			while (!fineFratelli(u))
				u = succFratello(u);

			int ultimoIndice = ((NodoVPos) u).indice;
			for (int i = ultimoIndice; i >= primoIndice; i--) {
				P[i + spostamento] = P[i];
				shiftDestraSottoAlbero(i, spostamento * d);
				P[i + spostamento].indice = i + spostamento;
				P[i] = null;
			}
		}
	}

	// //innesta "a" a partire dal nodo padre di this (la radice di a è già
	// innestata in padre)
	private void innesta(Nodo padre, Albero a, Nodo aPadre) {
		if (!a.foglia(aPadre)) {
			Nodo u = a.primoFiglio(aPadre);
			int posPrimoFiglio = d * ((((NodoVPos) padre).indice) - 1) + 1 + 1; // pos
																				// in
																				// this
			// inserisco u in this
			P[posPrimoFiglio] = (NodoVPos) (((NodoVPos) u).clone());

			P[posPrimoFiglio].indice = posPrimoFiglio;
			P[posPrimoFiglio].arita = 1;

			innesta(P[posPrimoFiglio], a, u);

			P[posPrimoFiglio].albero = this;
			int j = 2; // numero fratello
			while (!a.fineFratelli(u)) {
				u = a.succFratello(u);
				int posSuccFiglio = d * ((((NodoVPos) padre).indice) - 1) + j
						+ 1; // pos in this
				// inserisco u in this
				P[posSuccFiglio] = (NodoVPos) (((NodoVPos) u).clone());
				P[posSuccFiglio].indice = posSuccFiglio;
				P[posSuccFiglio].arita = j;
				innesta(P[posSuccFiglio], a, u);
				P[posSuccFiglio].albero = this;
				j++;
			}
		}
	}

	public void insprimoSottoAlbero(Nodo padre, Albero a)
			throws EccezioneNodoInvalido {
		if (checkNode(padre))
			throw new EccezioneNodoInvalido();
		if (a.alberoVuoto())
			throw new AlberoVuotoException(
					"Albero che si sta innestando è vuoto");
		Nodo ultimoFiglio = null;
		int primoIndice = 0;
		int ultimoIndice = 0;
		if (!foglia(padre)) {
			ultimoFiglio = primoFiglio(padre);
			primoIndice = ((NodoVPos) ultimoFiglio).indice;
			while (!fineFratelli(ultimoFiglio))
				ultimoFiglio = succFratello(ultimoFiglio);
			if (((NodoVPos) ultimoFiglio).arita == d)
				throw new AritaNonValidaException("Massima arità raggiunta");
		}

		// (d(p-1) + i+1)
		int posPrimoFiglio = d * ((((NodoVPos) padre).indice) - 1) + 1 + 1;

		// profodità di a
		int maxPa = ((AlberoVettPos) a).maxProfondita();

		// profondità di this
		int maxP = maxProfondita();

		// profondità a cui è localizzato padre in this
		int profCorrente = profondita(padre);

		// profondità a cui finirebbe l'ultimo livello di "a" una volta immesso
		// in this
		int maxTemp = profCorrente + maxPa + 1; // profondità massima a cui
												// finisce l'ultimo livello di a
												// una volta inserito in this

		// Alloco nuova memoria se necessario
		if (maxTemp > maxP) {
			// bisogna estendere P
			int newDim = P.length;
			for (int i = maxP + 1; i <= maxTemp; i++)
				// alloca i necessari livelli
				newDim += Math.pow(d, i);

			NodoVPos tempP[] = new NodoVPos[newDim];
			System.arraycopy(P, 0, tempP, 0, P.length);
			P = tempP;
		}

		// se esiste già un primo figlio di padre
		if (!foglia(padre)) {
			// shift a destra
			ultimoIndice = ((NodoVPos) ultimoFiglio).indice;
			for (int i = ultimoIndice; i >= primoIndice; i--) {
				P[i + 1] = P[i];
				// shift a destra del sottoalbero radicato in i
				shiftDestraSottoAlbero(i, d);
				P[i + 1].arita = P[i + 1].arita + 1;
				P[i + 1].indice = P[i + 1].indice + 1;
			}
		}

		// inserimento nuovo primo figlio
		P[posPrimoFiglio] = (NodoVPos) (((NodoVPos) ((AlberoVettPos) a)
				.radice()).clone());
		P[posPrimoFiglio].indice = posPrimoFiglio;
		P[posPrimoFiglio].arita = 1;

		innesta(P[posPrimoFiglio], a, a.radice());

		P[posPrimoFiglio].albero = this;
	}

	public String toString() {
		if (alberoVuoto())
			return "EmptyTree";

		return toString(radice());
	}

	private String toString(Nodo u) {
		// previsita
		String str = u + "[padre:" + padre(u) + "]\n";
		if (!foglia(u)) {
			Nodo v = primoFiglio(u);
			while (!fineFratelli(v)) {
				str += toString(v);
				v = succFratello(v);
			}
			str += toString(v);
		}
		return str;
	}

	public Iterator iterator() {
		return new TreeIterator(this);
	}

	public void insSottoAlbero(Nodo fratello, Albero a)
			throws EccezioneNodoInvalido {
		// TODO
	}

	public Nodo succFratello(Nodo v) {
		// TODO
		return null;
	}

	public void cancSottoAlbero(Nodo v) {
		// TODO
	}

}
