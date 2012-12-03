package queues;

import commons.EccezioneStrutturaVuota;

public class ArrayCodaDoppia implements CodaDoppia {

	// array di coppie (elem,chiave)
	private Object[] S = new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void dequeue() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");

		n--;

		if ((n > 1) && (n <= (S.length / 4))) {
			Object[] temp = new Object[S.length / 2];
			for (int i = 0; i < n; i++)
				temp[i] = S[i];
			S = temp;
		}
	}

	@Override
	public void enqueue(Object e) {
		if (n == S.length) {
			// raddoppiare dimensione di S
			Object[] temp = new Object[2 * S.length];
			for (int i = 0; i < n; i++)
				temp[i] = S[i];
			S = temp;
		}

		S[n] = e;
		n++;
	}

	@Override
	public Object first() {
		return S[0];
	}

	@Override
	public void push(Object e) {
		Object[] temp;

		if (n == S.length)
			temp = new Object[2 * S.length];
		else
			temp = new Object[S.length];

		for (int i = 0; i < n; i++)
			temp[i + 1] = S[i];
		S = temp;

		S[0] = e;
		n++;
	}

	@Override
	public Object top() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");

		return S[n - 1];
	}

	@Override
	public void pop() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");

		Object[] temp;

		if ((n > 1) && (n <= (S.length / 4)))
			temp = new Object[S.length / 2];
		else
			temp = new Object[S.length];

		for (int i = 0; i < n; i++)
			temp[i] = S[i + 1];
		S = temp;

		n--;
	}

}
