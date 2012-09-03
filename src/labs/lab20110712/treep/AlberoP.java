package labs.lab20110712.treep;

import java.util.Iterator;

import labs.lab20110712.tree.Albero;
import labs.lab20110712.tree.Nodo;
import labs.lab20110712.tree.Tipovisita;

public class AlberoP<T> implements Albero<T> {

	private NodoP<T> radice;
	
	@Override
	public Iterator<T> iterator() {
		return new AlberoPIterator<T>(this, Tipovisita.PREVISITA);
	}

	@Override
	public boolean alberoVuoto() {
		return radice == null;
	}

	@Override
	public void aggiungiRadice(T info) {
		if(!alberoVuoto())
			throw new AlberoNonVuoto("Radice già esistente");
			
		radice = new NodoP<T>(info);
		radice.albero = this;
	}

	@Override
	public Nodo<T> radice() {
		return radice;
	}

	@Override
	public Nodo<T> padre(Nodo<T> v) {
		
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		return ((NodoP<T>) v).padre;
	}

	private boolean appartiene(NodoP<T> v) {
		return v.albero == this;
	}

	@Override
	public boolean foglia(Nodo<T> v) {
		
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		return ((NodoP<T>) v).primo == null;
	}

	@Override
	public Nodo<T> primoFiglio(Nodo<T> v) {
		
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		return ((NodoP<T>) v).primo;
	}

	@Override
	public boolean fineFratelli(Nodo<T> v) {
		
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		return ((NodoP<T>) v).succ == null;
	}

	@Override
	public Nodo<T> succFratello(Nodo<T> v) {
		
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		return ((NodoP<T>) v).succ;
	}

	@Override
	public void insPrimoSottoAlbero(Nodo<T> u, Albero<T> a) {
		
		if (!appartiene((NodoP<T>) u)) throw new NodoInesistente();
		
		if (a.alberoVuoto())
			return;
		
		NodoP<T> tmp = ((NodoP<T>) u).primo;
		((NodoP<T>) u).primo = (NodoP<T>) a.radice();
		
		updateRiferimenti(((NodoP<T>) u).primo);
		
		((NodoP<T>) u).primo.padre = (NodoP<T>) u;
		((NodoP<T>) u).primo.succ = tmp;
		
		((AlberoP<T>) a).radice = null;
	}

	private void updateRiferimenti(NodoP<T> u) {

		u.albero = this;
		
		for(NodoP<T> i = u.primo; i != null; i = i.succ)
			updateRiferimenti(i);
	}

	@Override
	public void insSottoAlbero(Nodo<T> u, Albero<T> a) {
		
		if (!appartiene((NodoP<T>) u)) throw new NodoInesistente();
		
		if (a.alberoVuoto())
			return;
		
		NodoP<T> tmp = ((NodoP<T>) u).succ;
		((NodoP<T>) u).succ = (NodoP<T>) a.radice();
		
		updateRiferimenti(((NodoP<T>) u).succ);
		
		((NodoP<T>) u).succ.succ = tmp;
		((NodoP<T>) u).succ.padre = ((NodoP<T>) u).padre;
		
		((AlberoP<T>) a).radice = null;
	}

	@Override
	public void pota(Nodo<T> v) {
	
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		if (((NodoP<T>) v) == radice)
			radice = null;
		else if (((NodoP<T>) v).padre.primo == ((NodoP<T>) v))
			((NodoP<T>) v).padre.primo = ((NodoP<T>) v).succ;
		else {
			NodoP<T> i;
			for(i = ((NodoP<T>) v).padre.primo; i.succ != ((NodoP<T>) v); i = i.succ){}
			
			i.succ = ((NodoP<T>) v).succ;
			((NodoP<T>) v).primo = null;
			((NodoP<T>) v).padre = null;
			((NodoP<T>) v).succ = null;
		}
	}

	@Override
	public T info(Nodo<T> v) {
		
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		return ((NodoP<T>) v).info;
	}

	@Override
	public void cambiaInfo(Nodo<T> v, T info) {
		
		if (!appartiene((NodoP<T>) v)) throw new NodoInesistente();
		
		((NodoP<T>) v).info = info;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		
		for (T value : this){
			builder.append(" ");
			builder.append(value);
			builder.append(" ");
		}
		builder.append("]");
		
		return builder.toString();
	}
	
}
