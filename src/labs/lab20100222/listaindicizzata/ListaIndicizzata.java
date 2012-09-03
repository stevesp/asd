package labs.lab20100222.listaindicizzata;

public interface ListaIndicizzata<T> extends Iterable<T> {
	
	public boolean isEmpty(int i);
	public void addElement(T e, int i);
	public T getElement(int i);
	public int numberElements();
	
}