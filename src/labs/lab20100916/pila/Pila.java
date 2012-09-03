package lab20100916.pila;

public interface Pila<T> extends Iterable<T>{
	
	public boolean isEmpty();
	public void push(T e);
	public T top();
	public void pop();
	
}
