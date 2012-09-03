package labs.lab20100916.pilacollegata;

import java.util.Iterator;

import labs.lab20100916.pila.Pila;

public class PilaCollegata<T> implements Pila<T> {
	
	private Puntatore firstList;
	
	public PilaCollegata() {
		this.firstList = new Puntatore(new Cella<T>(null));
	}

	@Override
	public Iterator<T> iterator() {
		return new PilaCollegataIterator<T>(firstList);
	}

	@Override
	public boolean isEmpty() {
		return firstList.link.successivo == null;
	}

	@Override
	public void push(T e) {
		Puntatore _new = new Puntatore(new Cella<T>(e));
		
		_new.link.successivo = firstList;
		firstList = _new;
	}

	@Override
	public T top() {
		if (isEmpty())
			throw new EccezionePilaVuota("La pila è vuota");
		
		return (T) firstList.link.elem;
	}

	@Override
	public void pop() {
		if (isEmpty())
			throw new EccezionePilaVuota();
		
		firstList = firstList.link.successivo;
	}

}
