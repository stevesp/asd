package stacks;

public interface Pila {
	/**
	 * Verifica se la pila &egrave; vuota.
	 * 
	 * @return <code>true</code>, se la pila &egrave; vuota. <code>false</code>, altrimenti
	 */
	public boolean isEmpty();
	
	/**
	 * Aggiunge l'elemento <code>e</code> al termine della sequenza di elementi
	 * presenti nella pila.
	 * 
	 * @param e l'elemento da mantenere nella pila
	 */
	public void push(Object e);
	
	/**
	 * Restituisce l'ultimo elemento della sequenza di elementi
	 * presenti nella pila.
	 * 
	 * @return l'ultimo elemento della pila
	 */
	public Object top();
	
	/** 
	 * Cancella l'ultimo elemento della sequenza di elementi presenti nella pila.
	 * 
	 * @return l'elemento rimosso
	 */
	public void pop();
}
