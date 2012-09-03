package labs.lab20100222.listaarray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import labs.lab20100222.listaindicizzata.ListaIndicizzata;

public class ListaArray<T> implements ListaIndicizzata<T> {

	T[] elements;
	int size = 0;
	
	public ListaArray() {
		this.elements = (T[]) new Object[0];
		this.size = 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListaArrayIterator<T>(this);
	}

	@Override
	public boolean isEmpty(int i) {
		return this.elements[i] == null;
	}

	@Override
	public void addElement(T e, int i) {
		T tmp = getElement(i);
		if (tmp != null)
			throw new EccezionePosizioneOccupata("Posizione "+i+" già occupata");
		
		if (i >= elements.length)
			elements = Arrays.copyOf(elements, i+1);
		
		elements[i] = e;
		
		size++;
	}

	@Override
	public T getElement(int i) {
		if (i >= elements.length)
			return null;
		
		return elements[i];
	}

	@Override
	public int numberElements() {
		return this.size;
	}
	
	public static void main(String[] args){
		ListaArray<String> test = new ListaArray<String>();

		Random random = new Random();
		
		try {
			for(int i=0; i < 20; i++){
				int pos = random.nextInt(300);
				test.addElement("Posizione "+(pos), pos);
			}
		} catch (EccezionePosizioneOccupata e){
			System.out.println(e);
		}
				
		for(String s:test)
			System.out.println(s);
	}

}
