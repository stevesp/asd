package labs.lab20110614.dizionario;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayOrdinato<S> implements Dictionary<S> {

	private Coppia<S>[] elementData;
	private int size;
		
	public ArrayOrdinato() {
		this.elementData = new Coppia[1];
		this.size = 0;
	}
	
	@Override
	public Iterator<S> iterator() {
		return new ArrayOrdinatoIterator<S>(elementData,size);
	}

	@Override
	public void insert(S e, Comparable k) {
		int i;
		
		for (i = 0; i < size; i++){
			if (elementData[i].chiave.compareTo(k) == 0)
				throw new EccezioneChiaveDuplicata("Chiave duplicata");
			
			if (elementData[i].chiave.compareTo(k) > 0)
				break;
		}
		
		for ( int j = size; j > i; j--)
			elementData[j] = elementData[j-1];

		elementData[i] = new Coppia<S>(e, k);
		size++;
		elementData = Arrays.copyOf(elementData, size+1);
	}

	@Override
	public void delete(Comparable k) {
		if (size == 0)
			throw new DizionarioVuotoException("Dizionario vuoto");
		
		int inizio = 0;
		int fine = size;
		int m = -1;
		
		while(inizio<fine){
			m = (inizio+fine)/2;
			
			if (elementData[m].chiave.compareTo(k) == 0){
				for (int i = m; i < size; i++)
					elementData[i] = elementData[i+1];
				size--;
				elementData = Arrays.copyOf(elementData, size+1);
			} else if (elementData[m].chiave.compareTo(k) < 0)
				inizio = m +1;
			else
				fine = m;
		}		
	}

	@Override
	public S search(Comparable k) {
		int inizio = 0;
		int fine = size;
		
		while(inizio<fine){
			int m = (inizio+fine)/2;
			
			if (elementData[m].chiave.compareTo(k) == 0)
				return elementData[m].elem;
			else if (elementData[m].chiave.compareTo(k) < 0)
				inizio = m +1;
			else
				fine = m;
		}		

		return null;
	}

}
