package trees.vp;

import java.util.Iterator;
import java.util.LinkedList;

import trees.Albero;
import trees.AlberoVuotoException;
import trees.EccezioneNodoEsistente;
import trees.EccezioneNodoInvalido;
import trees.Nodo;
import trees.TreeIterator;

public class AlberoVP implements Albero, Iterable<NodoVP> {

	private NodoVP[] padri = new NodoVP[0];
	private NodoVP[] nodi = new NodoVP[0];

	public boolean alberoVuoto() {
		return nodi.length == 0;
	}

	private boolean checkNode(Nodo v) {
		if (v == null)
			return true;
		// per verificare che il nodo passato appartiene proprio all'albero this
		if (((NodoVP) v).albero != this)
			return true;
		return false;
	}

	public Nodo padre(Nodo v) {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		return padri[((NodoVP) v).indice];
	}

	public Nodo primoFiglio(Nodo v) throws EccezioneNodoInvalido,
			RuntimeException {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		for (int i = ((NodoVP) v).indice + 1; i < padri.length; i++)
			if (padri[i] == v)
				return nodi[i];
		throw new RuntimeException();
	}

	public boolean foglia(Nodo v) throws EccezioneNodoInvalido {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		for (int i = ((NodoVP) v).indice + 1; i < padri.length; i++)
			if (padri[i] == v)
				return false;
		return true;
	}

	public Nodo radice() throws AlberoVuotoException {
		// if (nodi.length == 0)
		if (alberoVuoto())
			throw new AlberoVuotoException("Albero vuoto");
		return nodi[0];
	}

	public void insRadice(Object info) throws EccezioneNodoEsistente {
		if (!alberoVuoto())
			throw new EccezioneNodoEsistente();
		padri = new NodoVP[1];
		padri[0] = null;
		nodi = new NodoVP[1];
		nodi[0] = new NodoVP(info);
		nodi[0].albero = this;
	}

	public Object info(Nodo v) throws EccezioneNodoInvalido {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		return nodi[((NodoVP) v).indice].info;
	}

	public void cambiaInfo(Nodo v, Object info) throws EccezioneNodoInvalido {
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		((NodoVP) v).info = info;
	}

	public void insSottoAlbero(Nodo fratello, Albero a)
			throws EccezioneNodoInvalido {
		if (checkNode(fratello))
			throw new EccezioneNodoInvalido();

		int indice = ((NodoVP) fratello).indice;

		NodoVP[] tmpNodi = new NodoVP[nodi.length + ((AlberoVP) a).nodi.length];
		NodoVP[] tmpPadri = new NodoVP[padri.length
				+ ((AlberoVP) a).padri.length];

		// copio fino a fratello
		System.arraycopy(nodi, 0, tmpNodi, 0, indice + 1);
		System.arraycopy(padri, 0, tmpPadri, 0, indice + 1);

		// innesto l'albero
		tmpNodi[indice + 1] = (NodoVP) ((AlberoVP) a).radice();
		tmpNodi[indice + 1].albero = this;

		// assegno un nuovo indice alla radice di a
		tmpNodi[indice + 1].indice = indice + 1;
		// aseegno il padre
		tmpPadri[indice + 1] = (NodoVP) padre(fratello);

		for (int i = indice + 1; i < nodi.length; i++) {
			tmpNodi[i + 1] = nodi[i];
			tmpNodi[i + 1].indice = i + 1;
			tmpPadri[i + 1] = padri[i];
		}

		int j = 1; // innesto
		// aggiungo i figli della radice di a
		for (int i = nodi.length + 1; i <= tmpNodi.length - 1; i++) {
			tmpNodi[i] = ((AlberoVP) a).nodi[j];
			tmpNodi[i].indice = i;
			tmpPadri[i] = ((AlberoVP) a).padri[j];
			tmpNodi[i].albero = this;
			j++;
		}

		padri = tmpPadri;
		nodi = tmpNodi;
	}

	private void rimuoviNodo(NodoVP u) {
		int n = padri.length;

		NodoVP[] temp = new NodoVP[n - 1];

		// Cancellare elemento in posizione u.indice di nodi e ricompattare
		System.arraycopy(nodi, 0, temp, 0, u.indice);
		System.arraycopy(nodi, u.indice + 1, temp, u.indice, temp.length
				- u.indice);
		nodi = temp;

		temp = new NodoVP[n - 1];
		System.arraycopy(padri, 0, temp, 0, u.indice);
		System.arraycopy(padri, u.indice + 1, temp, u.indice, temp.length
				- u.indice);
		padri = temp;
		for (int i = 0; i < nodi.length; i++)
			nodi[i].indice = i;
	}

	public void cancSottoAlbero(Nodo v) throws EccezioneNodoInvalido {
		Nodo temp;
		if (checkNode(v))
			throw new EccezioneNodoInvalido();
		if (!foglia(v)) {
			temp = primoFiglio(v);
			LinkedList<NodoVP> listFratelli = new LinkedList<NodoVP>();
			listFratelli.add((NodoVP) temp);
			while (!fineFratelli(temp)) {
				temp = succFratello(temp);
				listFratelli.add((NodoVP) temp);
			}
			Iterator<NodoVP> it = listFratelli.iterator();
			while (it.hasNext()) {
				temp = it.next();
				cancSottoAlbero(temp);
			}
		}
		rimuoviNodo((NodoVP) v);
	}

	public Iterator iterator() {
		return new TreeIterator(this);
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

	public boolean fineFratelli(Nodo v) throws EccezioneNodoInvalido {
		if (checkNode(v))
			throw new EccezioneNodoInvalido("nodo invalido");

		for (int i = ((NodoVP) v).indice + 1; i < padri.length; i++) {
			if (padri[i] == v)
				return false;
		}

		return true;
	}

	public void insprimoSottoAlbero(Nodo u, Albero a)
			throws EccezioneNodoInvalido {
		// TODO
	}

	public Nodo succFratello(Nodo v) throws EccezioneNodoInvalido {
		// TODO
		return null;
	}

}
