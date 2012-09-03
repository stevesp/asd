package trees;

public interface Albero {
	
	public boolean alberoVuoto();
	public Nodo primoFiglio(Nodo padre);
	public Nodo radice();
	public Nodo succFratello(Nodo f);
	public void insprimoSottoAlbero(Nodo padre, Albero a);
	public void insSottoAlbero(Nodo fratello, Albero a);
	public void insRadice(Object info);
	public void cambiaInfo(Nodo n, Object info);
	public Object info(Nodo n);
	public void cancSottoAlbero(Nodo n);
	public boolean foglia(Nodo n);
	public boolean fineFratelli(Nodo n);
	public Nodo padre(Nodo figlio);

}
