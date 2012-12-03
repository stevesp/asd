package labs.lab20110712.tree;

public interface Albero<T> extends Iterable<T> {
	public boolean alberoVuoto();

	public void aggiungiRadice(T info);

	public Nodo<T> radice();

	public Nodo<T> padre(Nodo<T> v);

	public boolean foglia(Nodo<T> v);

	public Nodo<T> primoFiglio(Nodo<T> v);

	public boolean fineFratelli(Nodo<T> v);

	public Nodo<T> succFratello(Nodo<T> v);

	public void insPrimoSottoAlbero(Nodo<T> u, Albero<T> a);

	public void insSottoAlbero(Nodo<T> u, Albero<T> a);

	public void pota(Nodo<T> v);

	public T info(Nodo<T> v);

	public void cambiaInfo(Nodo<T> v, T info);
}
