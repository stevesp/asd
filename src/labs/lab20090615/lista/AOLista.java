package labs.lab20090615.lista;

public interface AOLista {

	public Posizione firstList();

	public void insert(Object e, Posizione p);

	public Posizione succ(Posizione p);

	public Posizione pred(Posizione p);

	public boolean endList(Posizione p);

	public Object readList(Posizione p);

}
