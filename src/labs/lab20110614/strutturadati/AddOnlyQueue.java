package lab20110614.strutturadati;

public interface AddOnlyQueue<T> {
	public void add(T dato);
	public T getElement(int i);
	public int numberElements();
}
