package graphs;

public interface Grafo {

	public boolean isEmpty();

	public Nodo creaNodo(Object info);

	public void aggiungiNodo(Nodo n);

	public Arco creaArco(Nodo src, Nodo dst, Object info);

	public void aggiungiArco(Arco a);

	public Object infoNodo(Nodo n);

	public Object infoArco(Arco a);

	public void cambiaInfoNodo(Nodo n, Object info);

	public void cambiaInfoArco(Arco a, Object info);

	public Lista nodiAdiacenti(Nodo n);

	public Arco arcoIncidente(Nodo src, Nodo dst);

}
