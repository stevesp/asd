package labs.lab20120210.orologio;

import java.util.Iterator;

import labs.lab20120210.circlist.CircList;

public class Orologio<S> implements CircList<S> {

	S[] array;
	private int lancetta;
	
	public Orologio() {
		this.array = (S[]) new Object[0];
		this.lancetta = 0;
	}
	
	@Override
	public Iterator<S> iterator() {
		return new OrologioIterator<S>(this);
	}

	@Override
	public void add(S e) {
		S[] tmp = (S[]) new Object[array.length + 1];
		System.arraycopy(array, 0, tmp, 1, array.length);
		tmp[0] = e;
		array = tmp;
	}

	@Override
	public S value() {
		if (isEmpty())
			throw new EccezioneOrologioVuoto();
		
		return array[lancetta];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void rotateF() {
		if (isEmpty())
			throw new EccezioneOrologioVuoto();
		
		lancetta++;
		lancetta = lancetta % array.length;
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public boolean equals(CircList<S> s) {
		for(int i=0; i < size(); i++)
			if(! array[i].equals(((Orologio<S>) s).array[i]))
				return false;
		
		return true;
	}

}
