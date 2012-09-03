package lab20110614.referendum;

import java.util.Arrays;

import lab20110614.strutturadati.AddOnlyQueue;

public class Quesito<T> implements AddOnlyQueue<T>{

	public String quesito;
	private T[] elementData;
	private int size;
	
	public Quesito(){
		this.elementData = (T[]) new Object[1];
		this.size = 0;
	}
	
	@Override
	public void add(T dato) {
		elementData[size++] = dato;
		elementData = Arrays.copyOf(elementData, size+1);
	}
	
	private void rangeCheck(int i){
		if ( i >= size || i < 0)
			throw new IndexOutOfBoundsException();
	}

	@Override
	public T getElement(int i) {
		rangeCheck(i);
		return elementData[i];
	}

	@Override
	public int numberElements() {
		return size;
	}

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("quesito: "+ quesito +"\n");
		buffer.append("numero voti: "+ numberElements() +"\n");
		buffer.append("[ ");
		
		for (int i = 0; i < size; i++)
			buffer.append(elementData[i]+" ");
		
		return buffer.toString() + " ]";
	}
}
