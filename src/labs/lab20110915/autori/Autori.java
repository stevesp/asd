package labs.lab20110915.autori;

import java.util.Arrays;
import java.util.Iterator;

public class Autori implements Iterable<Autore> {

	Autore[] data;
	int size;

	public Autori() {
		this.data = new Autore[1];
		this.size = 0;
	}

	public void add(Autore a) throws AutoreGiaPresenteException {
		int i = 0;

		for (i = 0; i < size; i++) {
			if (data[i].compareTo(a) == 0)
				throw new AutoreGiaPresenteException();

			if (data[i].compareTo(a) > 0)
				break;
		}

		for (int j = size; j > i; j--)
			data[j] = data[j - 1];
		data[i] = a;

		size++;

		if (size == data.length)
			data = Arrays.copyOf(data, size * 2);
	}

	@Override
	public Iterator<Autore> iterator() {
		return new AutoreIterator(this);
	}
}
